package org.motechproject.care.reporting.migration.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

@Component
public class CommcareDataUtil {

    public String toFormXml(JsonObject formJson) {
        Document document = createNewDocument("data");
        Element rootElement = document.getDocumentElement();
        recursivelyParse(rootElement, (JsonObject) formJson.get("form"));
        return toString(document);
    }

    public CaseXmlPair toCaseXml(JsonObject jsonObject) {
        CaseXmlPair caseXmlPair = new CaseXmlPair();

        Document createUpdateCase = processForCreateAndUpdate(jsonObject);
        caseXmlPair.setCreateUpdateAction(toString(createUpdateCase));

        if (jsonObject.get("closed").getAsBoolean()) {
            Document closeCase = processForClosedCase(jsonObject);
            caseXmlPair.setClosedAction(toString(closeCase));
        }
        return caseXmlPair;
    }

    public Map<String, String> extractAsMap(JsonObject jsonResponse,
            String fieldToExtract, String requestHeader) {
        Map<String, String> map = new HashMap<>();
        JsonElement extractedValue = jsonResponse.get(fieldToExtract);
        if (extractedValue == null)
            throw new RuntimeException(String
                    .format("%s field not present in commcare response",
                            fieldToExtract));
        map.put(requestHeader, extractedValue.getAsString());
        return map;
    }

    private Document createNewDocument(String rootElementName) {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory
                .newInstance();
        try {
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document document = docBuilder.newDocument();
            Element rootElement = document.createElement(rootElementName);
            document.appendChild(rootElement);
            return document;
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    private Document processForCreateAndUpdate(JsonObject jsonObject) {
        List<String> createPropertyNames = asList("case_type", "case_name",
                "owner_id");
        JsonObject properties = jsonObject.get("properties").getAsJsonObject();
        JsonObject indices = jsonObject.get("indices").getAsJsonObject();
        Document caseDocument = createCaseAndPopulateAttributes(jsonObject);

        processCreate(createPropertyNames, properties, caseDocument);
        processUpdate(createPropertyNames, properties, caseDocument);
        if (indices.has("mother_id")) {
            processIndex(indices, caseDocument);
        }

        return caseDocument;
    }

    private void processCreate(List<String> createPropertyNames,
            JsonObject properties, Document caseDocument) {
        Element createElement = caseDocument.createElement("create");
        for (String property : createPropertyNames) {
            populateProperty(createElement, properties, property);
        }
        caseDocument.getDocumentElement().appendChild(createElement);
    }

    private void processUpdate(List<String> createPropertyNames,
            JsonObject properties, Document caseDocument) {
        Element updateElement = caseDocument.createElement("update");
        for (Map.Entry<String, JsonElement> entry : properties.entrySet()) {
            if (createPropertyNames.contains(entry.getKey())) {
                continue;
            }
            JsonElement value = entry.getValue();
            if (!value.isJsonNull() && !value.isJsonArray()) {
                populateProperty(updateElement, value.getAsString(), entry
                        .getKey());
            }
        }
        caseDocument.getDocumentElement().appendChild(updateElement);
    }

    private void processIndex(JsonObject indices, Document caseDocument) {
        Element indexElement = caseDocument.createElement("index");
        JsonObject mother = indices.get("mother_id").getAsJsonObject();
        Element motherElement = populateProperty(indexElement, mother.get(
                "case_id").getAsString(), "mother_id");
        motherElement.setAttribute("case_type", mother.get("case_type")
                .getAsString());
        caseDocument.getDocumentElement().appendChild(indexElement);
    }

    private Element populateProperty(Element element, String propertyValue,
            String propertyName) {
        Element propertyElement = element.getOwnerDocument().createElement(
                propertyName);
        propertyElement.setTextContent(propertyValue);
        element.appendChild(propertyElement);
        return propertyElement;
    }

    private Element populateProperty(Element element, JsonObject jsonObject,
            String propertyName) {
        JsonElement jsonElement = jsonObject.get(propertyName);
        String propertyValue = jsonElement.isJsonNull() ? null : jsonElement
                .getAsString();
        return populateProperty(element, propertyValue, propertyName);
    }

    private Document processForClosedCase(JsonObject jsonObject) {
        Document caseDocument = createCaseAndPopulateAttributes(jsonObject);
        Element closeElement = caseDocument.createElement("close");
        caseDocument.getDocumentElement().appendChild(closeElement);
        return caseDocument;
    }

    private Document createCaseAndPopulateAttributes(JsonObject jsonObject) {
        Document closedCaseDocument = createNewDocument("case");
        Element caseElement = closedCaseDocument.getDocumentElement();
        populateCaseAttributes(caseElement, jsonObject);
        return closedCaseDocument;
    }

    private void populateCaseAttributes(Element caseElement,
            JsonObject jsonObject) {
        String caseId = jsonObject.get("case_id").getAsString();
        caseElement.setAttribute("case_id", caseId);
        String dateModified = jsonObject.get("date_modified").getAsString();
        caseElement.setAttribute("date_modified", dateModified);
        String userId = jsonObject.get("user_id").getAsString();
        caseElement.setAttribute("user_id", userId);
        caseElement.setAttribute("xmlns",
                "http://commcarehq.org/case/transaction/v2");
    }

    private String toString(Node node) {
        try {
            Transformer transformer = TransformerFactory.newInstance()
                    .newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION,
                    "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            StringWriter sw = new StringWriter();
            transformer.transform(new DOMSource(node), new StreamResult(sw));
            return sw.toString();
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }

    private void recursivelyParse(Element parentElement,
            JsonPrimitive jsonPrimitive, String nodeName) {
        String value = jsonPrimitive.getAsString();
        if (isValue(nodeName)) {
            parentElement.setTextContent(value);
            return;
        }
        if (isAttribute(nodeName)) {
            parentElement.setAttribute(nodeName.substring(1), value);
            return;
        }
        Element element = parentElement.getOwnerDocument().createElement(
                nodeName);
        element.setTextContent(value);
        parentElement.appendChild(element);
    }

    private void recursivelyParse(Element parentElement, JsonArray jsonArray,
            String nodeName) {
        for (int i = 0; i < jsonArray.size(); i++) {
            recursivelyParse(parentElement, jsonArray.get(i), nodeName);
        }
    }

    private void recursivelyParse(Element parentElement, JsonObject jsonObject,
            String nodeName) {
        Element element = parentElement.getOwnerDocument().createElement(
                nodeName);
        parentElement.appendChild(element);
        recursivelyParse(element, jsonObject);
    }

    private void recursivelyParse(Element thisElement, JsonObject jsonObject) {
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            recursivelyParse(thisElement, entry.getValue(), entry.getKey());
        }
    }

    private void recursivelyParse(Element parentElement,
            JsonElement jsonElement, String nodeName) {
        if (jsonElement.isJsonPrimitive()) {
            recursivelyParse(parentElement, jsonElement.getAsJsonPrimitive(),
                    nodeName);
            return;
        }

        if (jsonElement.isJsonArray()) {
            recursivelyParse(parentElement, jsonElement.getAsJsonArray(),
                    nodeName);
            return;
        }

        if (jsonElement.isJsonObject()) {
            recursivelyParse(parentElement, jsonElement.getAsJsonObject(),
                    nodeName);
        }
    }

    private boolean isAttribute(String key) {
        return key.startsWith("@");
    }

    private boolean isValue(String key) {
        return key.startsWith("#");
    }
}
