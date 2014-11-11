package org.motechproject.commcarehq.service;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.apache.log4j.Level;
import org.motechproject.commcarehq.domain.AlertDocCase;
import org.motechproject.commcarehq.repository.AllAlertDocCases;
import org.motechproject.commons.date.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.StringReader;


@Controller
@RequestMapping("/**")
public class EndpointService {

    //private AllAlertDocCases allCareCases;
   // private AlertDocCaseFactory alertDocCaseFactory;

    Logger logger = Logger.getLogger(EndpointService.class);

    
    public EndpointService(/*AllAlertDocCases allCareCases, AlertDocCaseFactory alertDocCaseFactory*/) {
       // this.allCareCases = allCareCases;
        //this.alertDocCaseFactory = alertDocCaseFactory;
    }

    @RequestMapping(value="/", method= RequestMethod.GET)
    public void index(HttpServletResponse response) {
        try {
            response.getOutputStream().print("hello I am up and running. Relax. :)");
        } catch (IOException e) {
        }
    }

    @RequestMapping(value="/endpoint",method= RequestMethod.POST)
    public void endpoint(@RequestBody String xmlDocument, HttpServletResponse response) {
        ValidationResponse validationResponse = processDocument(xmlDocument);
        validationResponse.sendResponse(response);
    }



    private AlertDocCase careCase(String xmlDocument) {
        if(StringUtil.isNullOrEmpty(xmlDocument)) {
            throw new IllegalArgumentException();
        }

        DOMParser parser = new DOMParser();

        InputSource inputSource = new InputSource();
        inputSource.setCharacterStream(new StringReader(xmlDocument));

        try {
            parser.parse(inputSource);
            Document document = parser.getDocument();
            return null/*alertDocCaseFactory.getAlertDocCase(xmlDocument, document)*/;

        } catch (IOException ex) {
            throw new MalformedXmlException();
        }
        catch (SAXException ex){
            throw new MalformedXmlException();
        }
    }

    private ValidationResponse processDocument(String xmlDocument) {
        try {
            //AlertDocCase careCase = careCase(xmlDocument);
            //allCareCases.add(careCase);
            logger.info(xmlDocument);
        } catch (IllegalArgumentException ex) {
            return ValidationResponse.MISSING;
        }
        catch (MalformedXmlException ex){
            return ValidationResponse.MALFORMED;
        } catch (Exception ex) {
            return ValidationResponse.INTERNAL;
        }

        return ValidationResponse.SUCCESS;
    }
}
