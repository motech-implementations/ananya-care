package org.motechproject.carereporting.domain;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonView;
import org.motechproject.carereporting.domain.types.ConditionType;
import org.motechproject.carereporting.domain.views.ComplexConditionJsonView;
import org.motechproject.carereporting.domain.views.IndicatorJsonView;
import org.motechproject.carereporting.domain.views.QueryJsonView;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "value_comparison")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "value_comparison_id"))
})
@JsonTypeName(value = "value")
public class ValueComparisonConditionEntity extends ConditionEntity {

    @ManyToOne
    @JoinColumn(name = "comparison_symbol_id", nullable = false)
    @JsonView({ IndicatorJsonView.IndicatorDetails.class, ComplexConditionJsonView.ComplexConditionDetails.class,
        QueryJsonView.EditForm.class })
    private ComparisonSymbolEntity operator;

    @NotNull
    @Column(name = "value")
    @JsonView({ IndicatorJsonView.IndicatorDetails.class, ComplexConditionJsonView.ComplexConditionDetails.class,
        QueryJsonView.EditForm.class })
    private String value;

    public ValueComparisonConditionEntity() {
        super();
    }

    @Override
    public String getType() {
        return ConditionType.ValueComparison.getValue();
    }

    public ValueComparisonConditionEntity(ValueComparisonConditionEntity conditionEntity) {
        super(conditionEntity);

        this.operator = conditionEntity.getOperator();
        this.value = conditionEntity.getValue();
    }

    public ComparisonSymbolEntity getOperator() {
        return operator;
    }

    public void setOperator(ComparisonSymbolEntity operator) {
        this.operator = operator;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        ValueComparisonConditionEntity valueComparisonConditionEntity = new ValueComparisonConditionEntity();

        valueComparisonConditionEntity.setField1(this.getField1());
        valueComparisonConditionEntity.setOperator(this.getOperator());
        valueComparisonConditionEntity.setValue(this.getValue());

        return valueComparisonConditionEntity;
    }
}
