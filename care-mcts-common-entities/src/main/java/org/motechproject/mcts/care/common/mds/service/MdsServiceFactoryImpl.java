package org.motechproject.mcts.care.common.mds.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.dimension.Flw;
import org.motechproject.mcts.care.common.mds.dimension.FlwGroup;
import org.motechproject.mcts.care.common.mds.dimension.FlwGroupMap;
import org.motechproject.mcts.care.common.mds.dimension.LocationDimension;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;
import org.motechproject.mcts.care.common.mds.measure.AbortForm;
import org.motechproject.mcts.care.common.mds.measure.AwwCloseChildForm;
import org.motechproject.mcts.care.common.mds.measure.AwwEditChildForm;
import org.motechproject.mcts.care.common.mds.measure.AwwGrowthMonitoringChildForm1;
import org.motechproject.mcts.care.common.mds.measure.AwwGrowthMonitoringChildForm2;
import org.motechproject.mcts.care.common.mds.measure.AwwPreschoolActivitiesChildForm;
import org.motechproject.mcts.care.common.mds.measure.AwwPreschoolActivitiesForm;
import org.motechproject.mcts.care.common.mds.measure.AwwRegisterChildForm;
import org.motechproject.mcts.care.common.mds.measure.AwwRegisterMotherForm;
import org.motechproject.mcts.care.common.mds.measure.AwwThrChildForm;
import org.motechproject.mcts.care.common.mds.measure.AwwThrMotherForm;
import org.motechproject.mcts.care.common.mds.measure.AwwUpdateVaccinationsChildForm;
import org.motechproject.mcts.care.common.mds.measure.BpForm;
import org.motechproject.mcts.care.common.mds.measure.CfChildForm;
import org.motechproject.mcts.care.common.mds.measure.CfMotherForm;
import org.motechproject.mcts.care.common.mds.measure.CloseChildForm;
import org.motechproject.mcts.care.common.mds.measure.CloseMotherForm;
import org.motechproject.mcts.care.common.mds.measure.DeathChildForm;
import org.motechproject.mcts.care.common.mds.measure.DeathMotherForm;
import org.motechproject.mcts.care.common.mds.measure.DeliveryChildForm;
import org.motechproject.mcts.care.common.mds.measure.DeliveryMotherForm;
import org.motechproject.mcts.care.common.mds.measure.EbfChildForm;
import org.motechproject.mcts.care.common.mds.measure.EbfMotherForm;
import org.motechproject.mcts.care.common.mds.measure.Form;
import org.motechproject.mcts.care.common.mds.measure.GrowthMonitoringChildForm;
import org.motechproject.mcts.care.common.mds.measure.MiForm;
import org.motechproject.mcts.care.common.mds.measure.MoForm;
import org.motechproject.mcts.care.common.mds.measure.MotherEditForm;
import org.motechproject.mcts.care.common.mds.measure.MoveBeneficiaryForm;
import org.motechproject.mcts.care.common.mds.measure.NewForm;
import org.motechproject.mcts.care.common.mds.measure.PncChildForm;
import org.motechproject.mcts.care.common.mds.measure.PncMotherForm;
import org.motechproject.mcts.care.common.mds.measure.ReferChildForm;
import org.motechproject.mcts.care.common.mds.measure.ReferMotherForm;
import org.motechproject.mcts.care.common.mds.measure.RegistrationChildForm;
import org.motechproject.mcts.care.common.mds.measure.RegistrationMotherForm;
import org.motechproject.mcts.care.common.mds.measure.UiChildForm;
import org.motechproject.mcts.care.common.mds.measure.UiMotherForm;
import org.motechproject.mds.service.MotechDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MdsServiceFactoryImpl implements MdsServiceFactory {

    @Autowired
    private AbortFormMDSService abortFormMDSService;

    @Autowired
    private AwwCloseChildFormMDSService awwCloseChildFormMDSService;

    @Autowired
    private AwwEditChildFormMDSService awwEditChildFormMDSService;

    @Autowired
    private AwwGrowthMonitoringChildForm1MDSService awwGrowthMonitoringChildForm1MDSService;

    @Autowired
    private AwwGrowthMonitoringChildForm2MDSService awwGrowthMonitoringChildForm2MDSService;

    @Autowired
    private AwwPreschoolActivitiesChildFormMDSService awwPreschoolActivitiesChildFormMDSService;

    @Autowired
    private AwwPreschoolActivitiesFormMDSService awwPreschoolActivitiesFormMDSService;

    @Autowired
    private AwwRegisterChildFormMDSService awwRegisterChildFormMDSService;

    @Autowired
    private AwwRegisterMotherFormMDSService awwRegisterMotherFormMDSService;

    @Autowired
    private AwwThrChildFormMDSService awwThrChildFormMDSService;

    @Autowired
    private AwwThrMotherFormMDSService awwThrMotherFormMDSService;

    @Autowired
    private AwwUpdateVaccinationsChildFormMDSService awwUpdateVaccinationsChildFormMDSService;

    @Autowired
    private BpFormMDSService bpFormMDSService;

    @Autowired
    private CfChildFormMDSService cfChildFormMDSService;

    @Autowired
    private CfMotherFormMDSService cfMotherFormMDSService;

    @Autowired
    private ChildCaseMDSService childCaseMDSService;

    @Autowired
    private CloseChildFormMDSService closeChildFormMDSService;

    @Autowired
    private CloseMotherFormMDSService closeMotherFormMDSService;

    @Autowired
    private DeathChildFormMDSService deathChildFormMDSService;

    @Autowired
    private DeathMotherFormMDSService deathMotherFormMDSService;

    @Autowired
    private DeliveryChildFormMDSService deliveryChildFormMDSService;

    @Autowired
    private DeliveryMotherFormMDSService deliveryMotherFormMDSService;

    @Autowired
    private EbfChildFormMDSService ebfChildFormMDSService;

    @Autowired
    private EbfMotherFormMDSService ebfMotherFormMDSService;

    @Autowired
    private FlwGroupMapMDSService flwGroupMapMDSService;

    @Autowired
    private FlwGroupMDSService flwGroupMDSService;

    @Autowired
    private FlwMDSService flwMDSService;

    @Autowired
    private FormMDSService formMDSService;

    @Autowired
    private GrowthMonitoringChildFormMDSService growthMonitoringChildFormMDSService;

    @Autowired
    private LocationDimensionMDSService locationDimensionMDSService;

    @Autowired
    private MiFormMDSService miFormMDSService;

    @Autowired
    private MoFormMDSService moFormMDSService;

    @Autowired
    private MotherCaseMDSService motherCaseMDSService;

    @Autowired
    private MotherEditFormMDSService motherEditFormMDSService;

    @Autowired
    private MoveBeneficiaryFormMDSService moveBeneficiaryFormMDSService;

    @Autowired
    private NewFormMDSService newFormMDSService;

    @Autowired
    private PncChildFormMDSService pncChildFormMDSService;

    @Autowired
    private PncMotherFormMDSService pncMotherFormMDSService;

    @Autowired
    private ReferChildFormMDSService referChildFormMDSService;

    @Autowired
    private ReferMotherFormMDSService referMotherFormMDSService;

    @Autowired
    private RegistrationChildFormMDSService registrationChildFormMDSService;

    @Autowired
    private RegistrationMotherFormMDSService registrationMotherFormMDSService;

    @Autowired
    private UiChildFormMDSService uiChildFormMDSService;

    @Autowired
    private UiMotherFormMDSService uiMotherFormMDSService;
    
    private static Map<Class<?>, MotechDataService<?>> mapper;

    @PostConstruct
    public void createEntityServiceMap() {
        mapper = new HashMap<Class<?>, MotechDataService<?>>() {

            private static final long serialVersionUID = -2300514640910721151L;

            {
                put(AbortForm.class, abortFormMDSService);
                put(AwwCloseChildForm.class, awwCloseChildFormMDSService);
                put(AwwEditChildForm.class, awwEditChildFormMDSService);
                put(AwwGrowthMonitoringChildForm1.class,
                        awwGrowthMonitoringChildForm1MDSService);
                put(AwwGrowthMonitoringChildForm2.class,
                        awwGrowthMonitoringChildForm2MDSService);
                put(AwwPreschoolActivitiesChildForm.class,
                        awwPreschoolActivitiesChildFormMDSService);
                put(AwwPreschoolActivitiesForm.class,
                        awwPreschoolActivitiesFormMDSService);
                put(AwwRegisterChildForm.class, awwRegisterChildFormMDSService);
                put(AwwRegisterMotherForm.class,
                        awwRegisterMotherFormMDSService);
                put(AwwThrChildForm.class, awwThrChildFormMDSService);
                put(AwwThrMotherForm.class, awwThrMotherFormMDSService);
                put(AwwUpdateVaccinationsChildForm.class,
                        awwUpdateVaccinationsChildFormMDSService);
                put(BpForm.class, bpFormMDSService);
                put(CfChildForm.class, cfChildFormMDSService);
                put(CfMotherForm.class, cfMotherFormMDSService);
                put(ChildCase.class, childCaseMDSService);
                put(CloseChildForm.class, closeChildFormMDSService);
                put(CloseMotherForm.class, closeMotherFormMDSService);
                put(DeathChildForm.class, deathChildFormMDSService);
                put(DeathMotherForm.class, deathMotherFormMDSService);
                put(DeliveryChildForm.class, deliveryChildFormMDSService);
                put(DeliveryMotherForm.class, deliveryMotherFormMDSService);
                put(EbfChildForm.class, ebfChildFormMDSService);
                put(EbfMotherForm.class, ebfMotherFormMDSService);
                put(FlwGroupMap.class, flwGroupMapMDSService);
                put(FlwGroup.class, flwGroupMDSService);
                put(Flw.class, flwMDSService);
                put(Form.class, formMDSService);
                put(GrowthMonitoringChildForm.class,
                        growthMonitoringChildFormMDSService);
                put(LocationDimension.class, locationDimensionMDSService);
                put(MiForm.class, miFormMDSService);
                put(MoForm.class, moFormMDSService);
                put(MotherCase.class, motherCaseMDSService);
                put(MotherEditForm.class, motherEditFormMDSService);
                put(MoveBeneficiaryForm.class, moveBeneficiaryFormMDSService);
                put(NewForm.class, newFormMDSService);
                put(PncChildForm.class, pncChildFormMDSService);
                put(PncMotherForm.class, pncMotherFormMDSService);
                put(ReferChildForm.class, referChildFormMDSService);
                put(ReferMotherForm.class, referMotherFormMDSService);
                put(RegistrationChildForm.class,
                        registrationChildFormMDSService);
                put(RegistrationMotherForm.class,
                        registrationMotherFormMDSService);
                put(UiChildForm.class, uiChildFormMDSService);
                put(UiMotherForm.class, uiMotherFormMDSService);

            }
        };

    }

    @Override
    public MotechDataService<?> fetchServiceInterface(Class<?> clazz) {
        return (MotechDataService<?>) mapper.get(clazz);
    }
}
