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

@Service(value = "mdsServiceFactory")
public class MdsServiceFactoryImpl implements MdsServiceFactory {

    private static Map<Class<?>, MotechDataService<?>> mapper = new HashMap<Class<?>, MotechDataService<?>>();

    private AbortFormMDSService abortFormMDSService;
    private AwwCloseChildFormMDSService awwCloseChildFormMDSService;
    private AwwEditChildFormMDSService awwEditChildFormMDSService;
    private AwwGrowthMonitoringChildForm1MDSService awwGrowthMonitoringChildForm1MDSService;
    private AwwGrowthMonitoringChildForm2MDSService awwGrowthMonitoringChildForm2MDSService;
    private AwwPreschoolActivitiesChildFormMDSService awwPreschoolActivitiesChildFormMDSService;
    private AwwPreschoolActivitiesFormMDSService awwPreschoolActivitiesFormMDSService;
    private AwwRegisterChildFormMDSService awwRegisterChildFormMDSService;
    private AwwRegisterMotherFormMDSService awwRegisterMotherFormMDSService;
    private AwwThrChildFormMDSService awwThrChildFormMDSService;
    private AwwThrMotherFormMDSService awwThrMotherFormMDSService;
    private AwwUpdateVaccinationsChildFormMDSService awwUpdateVaccinationsChildFormMDSService;
    private BpFormMDSService bpFormMDSService;
    private CfChildFormMDSService cfChildFormMDSService;
    private CfMotherFormMDSService cfMotherFormMDSService;
    private ChildCaseMDSService childCaseMDSService;
    private CloseChildFormMDSService closeChildFormMDSService;
    private CloseMotherFormMDSService closeMotherFormMDSService;
    private DeathChildFormMDSService deathChildFormMDSService;
    private DeathMotherFormMDSService deathMotherFormMDSService;
    private DeliveryChildFormMDSService deliveryChildFormMDSService;
    private DeliveryMotherFormMDSService deliveryMotherFormMDSService;
    private EbfChildFormMDSService ebfChildFormMDSService;
    private EbfMotherFormMDSService ebfMotherFormMDSService;
    private FlwGroupMapMDSService flwGroupMapMDSService;
    private FlwGroupMDSService flwGroupMDSService;
    private FlwMDSService flwMDSService;
    private FormMDSService formMDSService;
    private GrowthMonitoringChildFormMDSService growthMonitoringChildFormMDSService;
    private LocationDimensionMDSService locationDimensionMDSService;
    private MiFormMDSService miFormMDSService;
    private MoFormMDSService moFormMDSService;
    private MotherCaseMDSService motherCaseMDSService;
    private MotherEditFormMDSService motherEditFormMDSService;
    private MoveBeneficiaryFormMDSService moveBeneficiaryFormMDSService;
    private NewFormMDSService newFormMDSService;
    private PncChildFormMDSService pncChildFormMDSService;
    private PncMotherFormMDSService pncMotherFormMDSService;
    private ReferChildFormMDSService referChildFormMDSService;
    private ReferMotherFormMDSService referMotherFormMDSService;
    private RegistrationChildFormMDSService registrationChildFormMDSService;
    private RegistrationMotherFormMDSService registrationMotherFormMDSService;
    private UiChildFormMDSService uiChildFormMDSService;
    private UiMotherFormMDSService uiMotherFormMDSService;

    @Autowired
    public MdsServiceFactoryImpl(
            AbortFormMDSService abortFormMDSService,
            AwwCloseChildFormMDSService awwCloseChildFormMDSService,
            AwwEditChildFormMDSService awwEditChildFormMDSService,
            AwwGrowthMonitoringChildForm1MDSService awwGrowthMonitoringChildForm1MDSService,
            AwwGrowthMonitoringChildForm2MDSService awwGrowthMonitoringChildForm2MDSService,
            AwwPreschoolActivitiesChildFormMDSService awwPreschoolActivitiesChildFormMDSService,
            AwwPreschoolActivitiesFormMDSService awwPreschoolActivitiesFormMDSService,
            AwwRegisterChildFormMDSService awwRegisterChildFormMDSService,
            AwwRegisterMotherFormMDSService awwRegisterMotherFormMDSService,
            AwwThrChildFormMDSService awwThrChildFormMDSService,
            AwwThrMotherFormMDSService awwThrMotherFormMDSService,
            AwwUpdateVaccinationsChildFormMDSService awwUpdateVaccinationsChildFormMDSService,
            BpFormMDSService bpFormMDSService,
            CfChildFormMDSService cfChildFormMDSService,
            CfMotherFormMDSService cfMotherFormMDSService,
            ChildCaseMDSService childCaseMDSService,
            CloseChildFormMDSService closeChildFormMDSService,
            CloseMotherFormMDSService closeMotherFormMDSService,
            DeathChildFormMDSService deathChildFormMDSService,
            DeathMotherFormMDSService deathMotherFormMDSService,
            DeliveryChildFormMDSService deliveryChildFormMDSService,
            DeliveryMotherFormMDSService deliveryMotherFormMDSService,
            EbfChildFormMDSService ebfChildFormMDSService,
            EbfMotherFormMDSService ebfMotherFormMDSService,
            FlwGroupMapMDSService flwGroupMapMDSService,
            FlwGroupMDSService flwGroupMDSService,
            FlwMDSService flwMDSService,
            FormMDSService formMDSService,
            GrowthMonitoringChildFormMDSService growthMonitoringChildFormMDSService,
            LocationDimensionMDSService locationDimensionMDSService,
            MiFormMDSService miFormMDSService,
            MoFormMDSService moFormMDSService,
            MotherCaseMDSService motherCaseMDSService,
            MotherEditFormMDSService motherEditFormMDSService,
            MoveBeneficiaryFormMDSService moveBeneficiaryFormMDSService,
            NewFormMDSService newFormMDSService,
            PncChildFormMDSService pncChildFormMDSService,
            PncMotherFormMDSService pncMotherFormMDSService,
            ReferChildFormMDSService referChildFormMDSService,
            ReferMotherFormMDSService referMotherFormMDSService,
            RegistrationChildFormMDSService registrationChildFormMDSService,
            RegistrationMotherFormMDSService registrationMotherFormMDSService,
            UiChildFormMDSService uiChildFormMDSService,
            UiMotherFormMDSService uiMotherFormMDSService) {
        this.abortFormMDSService = abortFormMDSService;
        this.awwCloseChildFormMDSService = awwCloseChildFormMDSService;
        this.awwEditChildFormMDSService = awwEditChildFormMDSService;
        this.awwGrowthMonitoringChildForm1MDSService = awwGrowthMonitoringChildForm1MDSService;
        this.awwGrowthMonitoringChildForm2MDSService = awwGrowthMonitoringChildForm2MDSService;
        this.awwPreschoolActivitiesChildFormMDSService = awwPreschoolActivitiesChildFormMDSService;
        this.awwPreschoolActivitiesFormMDSService = awwPreschoolActivitiesFormMDSService;
        this.awwRegisterChildFormMDSService = awwRegisterChildFormMDSService;
        this.awwRegisterMotherFormMDSService = awwRegisterMotherFormMDSService;
        this.awwThrChildFormMDSService = awwThrChildFormMDSService;
        this.awwThrMotherFormMDSService = awwThrMotherFormMDSService;
        this.awwUpdateVaccinationsChildFormMDSService = awwUpdateVaccinationsChildFormMDSService;
        this.bpFormMDSService = bpFormMDSService;
        this.cfChildFormMDSService = cfChildFormMDSService;
        this.cfMotherFormMDSService = cfMotherFormMDSService;
        this.childCaseMDSService = childCaseMDSService;
        this.closeChildFormMDSService = closeChildFormMDSService;
        this.closeMotherFormMDSService = closeMotherFormMDSService;
        this.deathChildFormMDSService = deathChildFormMDSService;
        this.deliveryChildFormMDSService = deliveryChildFormMDSService;
        this.deathMotherFormMDSService = deathMotherFormMDSService;
        this.deliveryMotherFormMDSService = deliveryMotherFormMDSService;
        this.ebfChildFormMDSService = ebfChildFormMDSService;
        this.ebfMotherFormMDSService = ebfMotherFormMDSService;
        this.flwGroupMapMDSService = flwGroupMapMDSService;
        this.flwGroupMDSService = flwGroupMDSService;
        this.flwMDSService = flwMDSService;
        this.formMDSService = formMDSService;
        this.growthMonitoringChildFormMDSService = growthMonitoringChildFormMDSService;
        this.locationDimensionMDSService = locationDimensionMDSService;
        this.miFormMDSService = miFormMDSService;
        this.moFormMDSService = moFormMDSService;
        this.motherCaseMDSService = motherCaseMDSService;
        this.motherEditFormMDSService = motherEditFormMDSService;
        this.moveBeneficiaryFormMDSService = moveBeneficiaryFormMDSService;
        this.newFormMDSService = newFormMDSService;
        this.pncChildFormMDSService = pncChildFormMDSService;
        this.pncMotherFormMDSService = pncMotherFormMDSService;
        this.referChildFormMDSService = referChildFormMDSService;
        this.referMotherFormMDSService = referMotherFormMDSService;
        this.registrationChildFormMDSService = registrationChildFormMDSService;
        this.registrationMotherFormMDSService = registrationMotherFormMDSService;
        this.uiChildFormMDSService = uiChildFormMDSService;
        this.uiMotherFormMDSService = uiMotherFormMDSService;
    }

    public void createEntityServiceMap() {

        mapper.put(AbortForm.class, abortFormMDSService);
        mapper.put(AwwCloseChildForm.class, awwCloseChildFormMDSService);
        mapper.put(AwwEditChildForm.class, awwEditChildFormMDSService);
        mapper.put(AwwGrowthMonitoringChildForm1.class,
                awwGrowthMonitoringChildForm1MDSService);
        mapper.put(AwwGrowthMonitoringChildForm2.class,
                awwGrowthMonitoringChildForm2MDSService);
        mapper.put(AwwPreschoolActivitiesChildForm.class,
                awwPreschoolActivitiesChildFormMDSService);
        mapper.put(AwwPreschoolActivitiesForm.class,
                awwPreschoolActivitiesFormMDSService);
        mapper.put(AwwRegisterChildForm.class, awwRegisterChildFormMDSService);
        mapper.put(AwwRegisterMotherForm.class, awwRegisterMotherFormMDSService);
        mapper.put(AwwThrChildForm.class, awwThrChildFormMDSService);
        mapper.put(AwwThrMotherForm.class, awwThrMotherFormMDSService);
        mapper.put(AwwUpdateVaccinationsChildForm.class,
                awwUpdateVaccinationsChildFormMDSService);
        mapper.put(BpForm.class, bpFormMDSService);
        mapper.put(CfChildForm.class, cfChildFormMDSService);
        mapper.put(CfMotherForm.class, cfMotherFormMDSService);
        mapper.put(ChildCase.class, childCaseMDSService);
        mapper.put(CloseChildForm.class, closeChildFormMDSService);
        mapper.put(CloseMotherForm.class, closeMotherFormMDSService);
        mapper.put(DeathChildForm.class, deathChildFormMDSService);
        mapper.put(DeathMotherForm.class, deathMotherFormMDSService);
        mapper.put(DeliveryChildForm.class, deliveryChildFormMDSService);
        mapper.put(DeliveryMotherForm.class, deliveryMotherFormMDSService);
        mapper.put(EbfChildForm.class, ebfChildFormMDSService);
        mapper.put(EbfMotherForm.class, ebfMotherFormMDSService);
        mapper.put(FlwGroupMap.class, flwGroupMapMDSService);
        mapper.put(FlwGroup.class, flwGroupMDSService);
        mapper.put(Flw.class, flwMDSService);
        mapper.put(Form.class, formMDSService);
        mapper.put(GrowthMonitoringChildForm.class,
                growthMonitoringChildFormMDSService);
        mapper.put(LocationDimension.class, locationDimensionMDSService);
        mapper.put(MiForm.class, miFormMDSService);
        mapper.put(MoForm.class, moFormMDSService);
        mapper.put(MotherCase.class, motherCaseMDSService);
        mapper.put(MotherEditForm.class, motherEditFormMDSService);
        mapper.put(MoveBeneficiaryForm.class, moveBeneficiaryFormMDSService);
        mapper.put(NewForm.class, newFormMDSService);
        mapper.put(PncChildForm.class, pncChildFormMDSService);
        mapper.put(PncMotherForm.class, pncMotherFormMDSService);
        mapper.put(ReferChildForm.class, referChildFormMDSService);
        mapper.put(ReferMotherForm.class, referMotherFormMDSService);
        mapper.put(RegistrationChildForm.class, registrationChildFormMDSService);
        mapper.put(RegistrationMotherForm.class,
                registrationMotherFormMDSService);
        mapper.put(UiChildForm.class, uiChildFormMDSService);
        mapper.put(UiMotherForm.class, uiMotherFormMDSService);

    }

    @Override
    public MotechDataService<?> fetchServiceInterface(Class<?> clazz) {
        if (mapper == null) {
            createEntityServiceMap();
        }
        return (MotechDataService<?>) mapper.get(clazz);
    }
}
