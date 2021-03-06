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
@Table(name = "report_type")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "report_type_id"))
})
public class ReportTypeEntity extends AbstractEntity {

    @NotNull
    @Column (name = "name")
    @JsonView({ BaseView.class })
    private String name;

    @OneToMany(mappedBy = "reportType", cascade = CascadeType.PERSIST)
    private Set<ReportEntity> reports;

    public ReportTypeEntity() {

    }

    public ReportTypeEntity(Integer id) {
        this.id = id;
    }

    public ReportTypeEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public Set<ReportEntity> getReports() {
        return reports;
    }

    public void setReports(Set<ReportEntity> reports) {
        this.reports = reports;
    }
}
