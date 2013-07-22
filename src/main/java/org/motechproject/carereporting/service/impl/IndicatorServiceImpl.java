package org.motechproject.carereporting.service.impl;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.motechproject.carereporting.dao.IndicatorCategoryDao;
import org.motechproject.carereporting.dao.IndicatorDao;
import org.motechproject.carereporting.dao.IndicatorTypeDao;
import org.motechproject.carereporting.dao.IndicatorValueDao;
import org.motechproject.carereporting.domain.AreaEntity;
import org.motechproject.carereporting.domain.ComplexConditionEntity;
import org.motechproject.carereporting.domain.ComputedFieldEntity;
import org.motechproject.carereporting.domain.DashboardEntity;
import org.motechproject.carereporting.domain.IndicatorCategoryEntity;
import org.motechproject.carereporting.domain.IndicatorEntity;
import org.motechproject.carereporting.domain.IndicatorTypeEntity;
import org.motechproject.carereporting.domain.IndicatorValueEntity;
import org.motechproject.carereporting.domain.ReportEntity;
import org.motechproject.carereporting.domain.UserEntity;
import org.motechproject.carereporting.domain.dto.IndicatorDto;
import org.motechproject.carereporting.domain.dto.IndicatorWithTrendDto;
import org.motechproject.carereporting.domain.dto.TrendIndicatorCategoryDto;
import org.motechproject.carereporting.service.AreaService;
import org.motechproject.carereporting.service.ComplexConditionService;
import org.motechproject.carereporting.service.ComputedFieldService;
import org.motechproject.carereporting.service.DashboardService;
import org.motechproject.carereporting.service.IndicatorService;
import org.motechproject.carereporting.service.ReportService;
import org.motechproject.carereporting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional(readOnly = true)
public class IndicatorServiceImpl implements IndicatorService {

    private static final int TREND_NEUTRAL = 0;
    private static final int TREND_NEGATIVE = -1;
    private static final int TREND_POSITIVE = 1;

    @Autowired
    private IndicatorDao indicatorDao;

    @Autowired
    private IndicatorTypeDao indicatorTypeDao;

    @Autowired
    private IndicatorCategoryDao indicatorCategoryDao;

    @Autowired
    private IndicatorValueDao indicatorValueDao;

    @Autowired
    private AreaService areaService;

    @Autowired
    private ComplexConditionService complexConditionService;

    @Autowired
    private ComputedFieldService computedFieldService;

    @Autowired
    private DashboardService dashboardService;

    @Autowired
    private UserService userService;

    @Autowired
    private ReportService reportService;

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public Set<IndicatorEntity> getAllIndicators() {
        return indicatorDao.getAll();
    }

    @Transactional
    @Override
    public Set<IndicatorEntity> getIndicatorsByCategoryId(Integer categoryId) {
        return indicatorDao.getIndicatorsByCategoryId(categoryId);
    }

    private Set<AreaEntity> getAllChildEntities(AreaEntity areaEntity) {
        Set<AreaEntity> areas = new LinkedHashSet<>();

        areas.add(areaEntity);
        for (AreaEntity area : areaEntity.getChildAreas()) {
            areas.addAll(getAllChildEntities(area));
        }

        return areas;
    }

    @Transactional
    @Override
    @SuppressWarnings("unchecked")
    public Set<IndicatorEntity> getAllIndicatorsUnderUserArea(Integer areaId) {
        AreaEntity areaEntity = areaService.getAreaById(areaId);
        Set<AreaEntity> areaEntities = getAllChildEntities(areaEntity);

        List<Integer> areaIds = new ArrayList<>();
        for (AreaEntity area : areaEntities) {
            areaIds.add(area.getId());
        }

        Query query = sessionFactory.getCurrentSession()
                .createQuery("from IndicatorEntity where area.id in (:areaEntities)");
        query.setParameterList("areaEntities", areaIds);

        return new LinkedHashSet<IndicatorEntity>(query.list());
    }

    @Transactional
    @Override
    public IndicatorEntity getIndicatorById(Integer id) {
        return indicatorDao.getById(id);
    }

    @Transactional(readOnly = false)
    @Override
    public void createNewIndicator(IndicatorEntity indicatorEntity) {
        indicatorDao.save(indicatorEntity);
    }

    @Transactional(readOnly = false)
    @Override
    public void createNewIndicatorFromDto(IndicatorDto indicatorDto) {

        IndicatorEntity indicatorEntity = new IndicatorEntity(
                findIndicatorTypeEntityFromDto(indicatorDto),
                findIndicatorCategoryEntitiesFromDto(indicatorDto),
                findAreaEntityFromDto(indicatorDto),
                findUserEntitiesFromDto(indicatorDto),
                findComputedFieldEntityFromDto(indicatorDto),
                findComplexConditionEntityFromDto(indicatorDto),
                findIndicatorValueEntitiesFromDto(indicatorDto),
                indicatorDto.getReports(),
                indicatorDto.getFrequency(),
                indicatorDto.getName());

        indicatorEntity.setTrend(indicatorDto.getTrend());
        indicatorDao.save(indicatorEntity);
    }

    @Transactional(readOnly = false)
    @Override
    public void updateIndicator(IndicatorEntity indicatorEntity) {
        indicatorDao.update(indicatorEntity);
    }

    @Transactional(readOnly = false)
    @Override
    public void updateIndicatorFromDto(IndicatorDto indicatorDto) {
        IndicatorEntity indicatorEntity = this.getIndicatorById(indicatorDto.getId());

        indicatorEntity.setIndicatorType(findIndicatorTypeEntityFromDto(indicatorDto));
        indicatorEntity.setCategories(findIndicatorCategoryEntitiesFromDto(indicatorDto));
        indicatorEntity.setArea(findAreaEntityFromDto(indicatorDto));
        indicatorEntity.setOwners(findUserEntitiesFromDto(indicatorDto));
        indicatorEntity.setComputedField(findComputedFieldEntityFromDto(indicatorDto));
        indicatorEntity.setComplexCondition(findComplexConditionEntityFromDto(indicatorDto));
        indicatorEntity.setValues(findIndicatorValueEntitiesFromDto(indicatorDto));
        indicatorEntity.getTrend().setPositiveDiff(indicatorDto.getTrend().getPositiveDiff());
        indicatorEntity.getTrend().setNegativeDiff(indicatorDto.getTrend().getNegativeDiff());
        indicatorEntity.setReports(setUpdatedReports(indicatorDto.getReports(), indicatorEntity));
        indicatorEntity.setFrequency(indicatorDto.getFrequency());
        indicatorEntity.setName(indicatorDto.getName());
        indicatorDao.update(indicatorEntity);
    }


    private Set<ReportEntity> setUpdatedReports(Set<ReportEntity> reportsFromDto, IndicatorEntity indicatorEntity) {
        Set<ReportEntity> reportsUpdated = new HashSet<>();
        Set<ReportEntity> reportsToUpdate = indicatorEntity.getReports();
        for (ReportEntity reportForm : reportsFromDto) {
            if (reportForm.getId() == null) {
                reportForm.setIndicator(indicatorEntity);
                reportsUpdated.add(reportForm);
                continue;
            }
            for (ReportEntity reportToUpdate : reportsToUpdate) {
                if (reportForm.getId() != null && reportForm.getId().equals(reportToUpdate.getId())) {
                    reportToUpdate.setReportType(reportForm.getReportType());
                    reportsUpdated.add(reportToUpdate);
                    break;
                }
            }
        }
        reportsToUpdate.removeAll(reportsUpdated);
        reportService.deleteReportSet(reportsToUpdate);
        return reportsUpdated;
    }

    private IndicatorTypeEntity findIndicatorTypeEntityFromDto(IndicatorDto indicatorDto) {
        return getIndicatorTypeById(indicatorDto.getIndicatorType());
    }

    private Set<IndicatorCategoryEntity> findIndicatorCategoryEntitiesFromDto(
            IndicatorDto indicatorDto) {
        Set<IndicatorCategoryEntity> indicatorCategoryEntities = new LinkedHashSet<>();

        for (Integer indicatorCategoryId : indicatorDto.getCategories()) {
            IndicatorCategoryEntity indicatorCategoryEntity = this.getIndicatorCategoryById(indicatorCategoryId);

            indicatorCategoryEntities.add(indicatorCategoryEntity);
        }

        return indicatorCategoryEntities;
    }

    private AreaEntity findAreaEntityFromDto(IndicatorDto indicatorDto) {
        return areaService.getAreaById(indicatorDto.getArea());
    }

    private Set<UserEntity> findUserEntitiesFromDto(IndicatorDto indicatorDto) {
        Set<UserEntity> userEntities = new LinkedHashSet<>();

        for (Integer ownerId : indicatorDto.getOwners()) {
            UserEntity userEntity = userService.getUserById(ownerId);

            userEntities.add(userEntity);
        }

        return userEntities;
    }

    private ComputedFieldEntity findComputedFieldEntityFromDto(
            IndicatorDto indicatorDto) {
        return computedFieldService.getComputedFieldById(indicatorDto.getComputedField());
    }

    private ComplexConditionEntity findComplexConditionEntityFromDto(
            IndicatorDto indicatorDto) {
        if (indicatorDto.getComplexCondition() == null) {
            return null;
        }

        return complexConditionService.getComplexConditionById(indicatorDto.getComplexCondition());
    }

    private Set<IndicatorValueEntity> findIndicatorValueEntitiesFromDto(
            IndicatorDto indicatorDto) {
        Set<IndicatorValueEntity> indicatorValueEntities = new LinkedHashSet<>();

        for (Integer valueId : indicatorDto.getValues()) {
            IndicatorValueEntity indicatorValueEntity = this.getIndicatorValueById(valueId);

            indicatorValueEntities.add(indicatorValueEntity);
        }

        return indicatorValueEntities;
    }

    @Transactional(readOnly = false)
    @Override
    public void deleteIndicator(IndicatorEntity indicatorEntity) {
        indicatorDao.remove(indicatorEntity);
    }

    // IndicatorTypeEntity

    @Transactional
    @Override
    public Set<IndicatorTypeEntity> getAllIndicatorTypes() {
        return indicatorTypeDao.getAll();
    }

    @Transactional
    @Override
    public IndicatorTypeEntity getIndicatorTypeById(Integer id) {
        return indicatorTypeDao.getById(id);
    }

    @Transactional(readOnly = false)
    @Override
    public void createNewIndicatorType(IndicatorTypeEntity indicatorTypeEntity) {
        indicatorTypeDao.save(indicatorTypeEntity);
    }

    @Transactional(readOnly = false)
    @Override
    public void updateIndicatorType(IndicatorTypeEntity indicatorTypeEntity) {
        indicatorTypeDao.update(indicatorTypeEntity);
    }

    @Transactional(readOnly = false)
    @Override
    public void deleteIndicatorType(IndicatorTypeEntity indicatorTypeEntity) {
        indicatorTypeDao.remove(indicatorTypeEntity);
    }

    // IndicatorCategoryEntity

    @Transactional
    @Override
    public Set<IndicatorCategoryEntity> getAllIndicatorCategories() {
        return indicatorCategoryDao.getAll();
    }

    @Transactional
    @Override
    public IndicatorCategoryEntity getIndicatorCategoryById(Integer id) {
        return indicatorCategoryDao.getById(id);
    }

    @Transactional(readOnly = false)
    @Override
    public void createNewIndicatorCategory(IndicatorCategoryEntity indicatorCategoryEntity) {
        DashboardEntity dashboardForCategory = createDashboardForNewIndicatorCategory(indicatorCategoryEntity.getName());
        indicatorCategoryEntity.setDashboard(dashboardForCategory);
        indicatorCategoryDao.save(indicatorCategoryEntity);
    }

    private DashboardEntity createDashboardForNewIndicatorCategory(String name) {
        Short newDashboardTabPosition = dashboardService.getTabPositionForNewDashboard();
        Set<UserEntity> dashboardOwners = new HashSet<UserEntity>();
        dashboardOwners.add(userService.getCurrentlyLoggedUser());
        return new DashboardEntity(name, newDashboardTabPosition, dashboardOwners);
    }

    @Transactional(readOnly = false)
    @Override
    public void updateIndicatorCategory(IndicatorCategoryEntity indicatorCategoryEntity) {
        indicatorCategoryEntity.getDashboard().setName(indicatorCategoryEntity.getName());
        indicatorCategoryDao.update(indicatorCategoryEntity);
    }

    @Transactional(readOnly = false)
    @Override
    public void deleteIndicatorCategory(IndicatorCategoryEntity indicatorCategoryEntity) {
        indicatorCategoryDao.remove(indicatorCategoryEntity);
    }

    @Transactional
    @Override
    public Set<IndicatorValueEntity> getAllIndicatorValues() {
        return indicatorValueDao.getAll();
    }

    // IndicatorValueEntity

    @Transactional
    @Override
    public IndicatorValueEntity getIndicatorValueById(Integer id) {
        return indicatorValueDao.getById(id);
    }

    @Transactional(readOnly = false)
    @Override
    public void createNewIndicatorValue(IndicatorValueEntity indicatorValueEntity) {
        indicatorValueDao.save(indicatorValueEntity);
    }

    @Transactional(readOnly = false)
    @Override
    public void updateIndicatorValue(IndicatorValueEntity indicatorValueEntity) {
        indicatorValueDao.update(indicatorValueEntity);
    }

    @Transactional(readOnly = false)
    @Override
    public void deleteIndicatorValue(IndicatorValueEntity indicatorValueEntity) {
        indicatorValueDao.remove(indicatorValueEntity);
    }

    @Override
    @Transactional
    public List<IndicatorValueEntity> getIndicatorValuesForArea(Integer indicatorId, Integer areaId, Date earliestDate) {
        return indicatorValueDao.getIndicatorValuesForArea(indicatorId, areaId, earliestDate);
    }

    @Override
    @Transactional
    public Set<TrendIndicatorCategoryDto> getIndicatorsWithTrendsUnderUser(UserEntity user, Date startDate, Date endDate) {
        Set<TrendIndicatorCategoryDto> categories = new LinkedHashSet<>();
        Set<IndicatorCategoryEntity> indicatorCategories = getAllIndicatorCategories();
        for (IndicatorCategoryEntity indicatorCategory: indicatorCategories) {
            TrendIndicatorCategoryDto trendCategory = new TrendIndicatorCategoryDto(indicatorCategory.getName());
            categories.add(trendCategory);
            for (IndicatorEntity indicator: indicatorCategory.getIndicators()) {
                if (indicator.getOwners().contains(user)) {
                    IndicatorWithTrendDto trendIndicator = new IndicatorWithTrendDto(indicator,
                            getTrendForIndicator(user.getArea(), indicator, startDate, endDate));
                    trendCategory.getIndicators().add(trendIndicator);
                }
            }
        }
        return categories;
    }

    private int getTrendForIndicator(AreaEntity area, IndicatorEntity indicator, Date startDate, Date endDate) {

        IndicatorValueEntity startValue = indicatorValueDao.getIndicatorValueClosestToDate(area, indicator, startDate);
        IndicatorValueEntity endValue = indicatorValueDao.getIndicatorValueClosestToDate(area, indicator, endDate);

        if (startValue == null || endValue == null) {
            return TREND_NEUTRAL;
        }

        BigDecimal diff = endValue.getValue().subtract(startValue.getValue());

        if (diff.compareTo(indicator.getTrend().getNegativeDiff()) < 0) {
            return TREND_NEGATIVE;
        } else if (diff.compareTo(indicator.getTrend().getPositiveDiff()) > 0) {
            return TREND_POSITIVE;
        }
        return TREND_NEUTRAL;
    }

}
