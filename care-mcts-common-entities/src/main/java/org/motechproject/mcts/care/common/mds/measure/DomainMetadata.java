package org.motechproject.mcts.care.common.mds.measure;

import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

@Entity(name = "domain_metadata")
public class DomainMetadata implements java.io.Serializable {

    private static final long serialVersionUID = -8194182991314061593L;

    @Field
    private String tableName;

    @Field
    private String type;

    @Field
    private String category;

    public DomainMetadata(String tableName, String type, String category) {
        this.tableName = tableName;
        this.type = type;
        this.category = category;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}