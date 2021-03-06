package org.motechproject.carereporting.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import org.motechproject.carereporting.domain.views.BaseView;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "operator_type")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "operator_type_id"))
})
public class OperatorTypeEntity extends AbstractEntity {

    @NotNull
    @Column(name = "name")
    @JsonView(BaseView.class)
    private String name;

    @OneToMany(mappedBy = "operatorType", cascade = CascadeType.ALL)
    private Set<FieldOperationEntity> fieldOperations;

    public OperatorTypeEntity() {

    }

    public OperatorTypeEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public Set<FieldOperationEntity> getFieldOperations() {
        return fieldOperations;
    }

    public void setFieldOperations(Set<FieldOperationEntity> fieldOperations) {
        this.fieldOperations = fieldOperations;
    }
}
