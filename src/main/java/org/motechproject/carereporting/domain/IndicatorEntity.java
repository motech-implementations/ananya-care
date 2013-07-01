package org.motechproject.carereporting.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "indicator")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "indicator_id"))
})
public class IndicatorEntity extends AbstractEntity {

    @NotNull
    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "indicator_type_id", nullable = false)
    private IndicatorTypeEntity indicatorType;

    @NotNull
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "indicator_indicator_category", joinColumns = { @JoinColumn(name = "indicator_id") },
            inverseJoinColumns = { @JoinColumn(name = "indicator_category_id") })
    private Set<IndicatorCategoryEntity> categories;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "top_level_id", referencedColumnName = "level_id", nullable = false)
    private LevelEntity level;

    @NotNull
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "indicator_user", joinColumns = { @JoinColumn(name = "indicator_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") })
    private Set<UserEntity> owners;

    @OneToMany(mappedBy = "indicator", cascade = CascadeType.ALL)
    private Set<IndicatorValueEntity> values;

    @NotNull
    @Column(name = "frequency", nullable = false)
    private Integer frequency;

    @NotNull
    @NotEmpty
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    public IndicatorTypeEntity getIndicatorType() {
        return indicatorType;
    }

    public void setIndicatorType(IndicatorTypeEntity indicatorType) {
        this.indicatorType = indicatorType;
    }

    public Set<IndicatorCategoryEntity> getCategories() {
        return categories;
    }

    public void setCategories(Set<IndicatorCategoryEntity> categories) {
        this.categories = categories;
    }

    public LevelEntity getLevel() {
        return level;
    }

    public void setLevel(LevelEntity level) {
        this.level = level;
    }

    public Set<UserEntity> getOwners() {
        return owners;
    }

    public void setOwners(Set<UserEntity> owners) {
        this.owners = owners;
    }

    public Set<IndicatorValueEntity> getValues() {
        return values;
    }

    public void setValues(Set<IndicatorValueEntity> values) {
        this.values = values;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
