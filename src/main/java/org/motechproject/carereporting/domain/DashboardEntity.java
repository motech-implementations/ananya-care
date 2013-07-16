package org.motechproject.carereporting.domain;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonView;
import org.motechproject.carereporting.domain.views.DashboardJsonView;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "dashboard")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "dashboard_id"))
})
@NamedQueries({
        @NamedQuery(name = "dashboardEntity.getTabPositionForNewDashboard",
            query = "select max(tabPosition) + 1 from DashboardEntity dashboardEntity"
        ),
        @NamedQuery(name = "dashboardEntity.findDashboardByName",
            query = "from DashboardEntity d where d.name=:name"
        )
})
public class DashboardEntity extends AbstractEntity {

    @NotNull
    @Column(name = "name", unique = true)
    @JsonView({ DashboardJsonView.class })
    private String name;

    @NotNull
    @Column(name = "tab_position", unique = true)
    @JsonView({ DashboardJsonView.class })
    private Short tabPosition;

    @OneToOne(mappedBy = "dashboard", cascade = CascadeType.ALL)
    @JsonView({ DashboardJsonView.class })
    private IndicatorCategoryEntity indicatorCategory;

    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "dashboard_user", joinColumns = { @JoinColumn(name = "dashboard_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") })
    private Set<UserEntity> owners;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "report_dashboard", joinColumns = { @JoinColumn(name = "dashboard_id") },
            inverseJoinColumns = { @JoinColumn(name = "report_id") })
    private Set<ReportEntity> reports;

    public DashboardEntity() {

    }

    public DashboardEntity(String name, Short tabPosition, Set<UserEntity> owners) {
        this.name = name;
        this.tabPosition = tabPosition;
        this.owners = owners;
    }

    public Set<ReportEntity> getReports() {
        return reports;
    }

    public void setReports(Set<ReportEntity> reports) {
        this.reports = reports;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getTabPosition() {
        return tabPosition;
    }

    public void setTabPosition(Short tabPosition) {
        this.tabPosition = tabPosition;
    }

    public IndicatorCategoryEntity getIndicatorCategory() {
        return indicatorCategory;
    }

    public void setIndicatorCategory(IndicatorCategoryEntity indicatorCategory) {
        this.indicatorCategory = indicatorCategory;
    }

    @JsonIgnore
    public Set<UserEntity> getOwners() {
        return owners;
    }

    public void setOwners(Set<UserEntity> owners) {
        this.owners = owners;
    }
}
