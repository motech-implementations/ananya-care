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
import org.motechproject.mcts.care.common.mds.domain.CareCaseTask;
import org.motechproject.mcts.care.common.mds.domain.Child;
import org.motechproject.mcts.care.common.mds.domain.Client;
import org.motechproject.mcts.care.common.mds.domain.Mother;
import org.motechproject.mcts.care.common.mds.domain.Window;
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
import org.motechproject.mcts.care.common.mds.measure.CaseAlreadyClosedForm;
import org.motechproject.mcts.care.common.mds.measure.CfChildForm;
import org.motechproject.mcts.care.common.mds.measure.CfMotherForm;
import org.motechproject.mcts.care.common.mds.measure.CloseChildForm;
import org.motechproject.mcts.care.common.mds.measure.CloseMotherForm;
import org.motechproject.mcts.care.common.mds.measure.DeathChildForm;
import org.motechproject.mcts.care.common.mds.measure.DeathMotherForm;
import org.motechproject.mcts.care.common.mds.measure.DeliveryChildForm;
import org.motechproject.mcts.care.common.mds.measure.DeliveryMotherForm;
import org.motechproject.mcts.care.common.mds.measure.DontKnowForm;
import org.motechproject.mcts.care.common.mds.measure.EbfChildForm;
import org.motechproject.mcts.care.common.mds.measure.EbfMotherForm;
import org.motechproject.mcts.care.common.mds.measure.Form;
import org.motechproject.mcts.care.common.mds.measure.GrowthMonitoringChildForm;
import org.motechproject.mcts.care.common.mds.measure.JobMetadata;
import org.motechproject.mcts.care.common.mds.measure.MappingToApproveForm;
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
import org.motechproject.mcts.care.common.mds.measure.UnapprovedToDiscussForm;
import org.motechproject.mcts.care.common.mds.measure.UnmappedToReviewForm;
import org.motechproject.mcts.care.common.mds.model.HubTransaction;
import org.motechproject.mcts.care.common.mds.model.MctsDistrict;
import org.motechproject.mcts.care.common.mds.model.MctsHealthblock;
import org.motechproject.mcts.care.common.mds.model.MctsHealthworker;
import org.motechproject.mcts.care.common.mds.model.MctsHealthworkerErrorLog;
import org.motechproject.mcts.care.common.mds.model.MctsLocationErrorLog;
import org.motechproject.mcts.care.common.mds.model.MctsPhc;
import org.motechproject.mcts.care.common.mds.model.MctsPregnantMother;
import org.motechproject.mcts.care.common.mds.model.MctsPregnantMotherErrorLog;
import org.motechproject.mcts.care.common.mds.model.MctsPregnantMotherServiceUpdate;
import org.motechproject.mcts.care.common.mds.model.MctsState;
import org.motechproject.mcts.care.common.mds.model.MctsSubcenter;
import org.motechproject.mcts.care.common.mds.model.MctsTaluk;
import org.motechproject.mcts.care.common.mds.model.MctsVillage;
import org.motechproject.mcts.care.common.mds.model.MotherCaseMctsUpdate;
import org.motechproject.mds.service.MotechDataService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * This is a factory class which stores the mapping between various entities
 * versus their corresponding Mds service interfaces.
 *
 * @author anuranjan
 */
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
    private JobMetadataMDSService jobMetadataMDSService;
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

    private MctsPregnantMotherMDSService mctsPregnantMotherMDSService;
    private MctsLocationErrorLogMDSService mctsLocationErrorLogMDSService;
    private MctsDistrictMDSService mctsDistrictMDSService;
    private MctsPhcMDSService mctsPhcMDSService;
    private MctsStateMDSService mctsStateMDSService;
    private MctsSubcenterMDSService mctsSubcenterMDSService;
    private MctsTalukMDSService mctsTalukMDSService;
    private MctsVillageMDSService mctsVillageMDSService;
    private MctsHealthblockMDSService mctsHealthblockMDSService;
    private MctsHealthworkerMDSService mctsHealthworkerMDSService;
    private MctsPregnantMotherErrorLogMDSService mctsPregnantMotherErrorLogMDSService;
    private MctsPregnantMotherServiceUpdateMDSService mctsPregnantMotherServiceUpdateMDSService;
    private UnapprovedToDiscussFormMDSService unapprovedToDiscussFormMDSService;
    private UnmappedToReviewFormMDSService unmappedToReviewFormMDSService;
    private DontKnowFormMDSService dontKnowFormMDSService;
    private MotherCaseMctsUpdateMDSService motherCaseMctsUpdateMDSService;
    private HubTransactionMDSService hubTransactionMDSService;
    private CaseAlreadyClosedFormMDSService caseAlreadyClosedFormMDSService;
    private MappingToApproveFormMDSService mappingToApproveFormMDSService;
    private MctsHealthWorkerErrorLogMDSService mctsHealthWorkerErrorLogMDSService;

    private CareCaseTaskMDSService careCaseTaskMDSService;
    private ChildMDSService childMDSService;
    private ClientMDSService clientMDSService;
    private MotherMDSService motherMDSService;
    private WindowMDSService windowMDSService;

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
            JobMetadataMDSService jobMetadataMDSService,
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
            UiMotherFormMDSService uiMotherFormMDSService,
            MctsPregnantMotherMDSService mctsPregnantMotherMDSService,
            MctsLocationErrorLogMDSService mctsLocationErrorLogMDSService,
            MctsDistrictMDSService mctsDistrictMDSService,
            MctsPhcMDSService mctsPhcMDSService,
            MctsStateMDSService mctsStateMDSService,
            MctsSubcenterMDSService mctsSubcenterMDSService,
            MctsTalukMDSService mctsTalukMDSService,
            MctsVillageMDSService mctsVillageMDSService,
            MctsHealthblockMDSService mctsHealthblockMDSService,
            MctsHealthworkerMDSService mctsHealthworkerMDSService,
            MctsPregnantMotherErrorLogMDSService mctsPregnantMotherErrorLogMDSService,
            MctsPregnantMotherServiceUpdateMDSService mctsPregnantMotherServiceUpdateMDSService,
            UnapprovedToDiscussFormMDSService unapprovedToDiscussFormMDSService,
            UnmappedToReviewFormMDSService unmappedToReviewFormMDSService,
            DontKnowFormMDSService dontKnowFormMDSService,
            MappingToApproveFormMDSService mappingToApproveFormMDSService,
            MotherCaseMctsUpdateMDSService motherCaseMctsUpdateMDSService,
            HubTransactionMDSService hubTransactionMDSService,
            CaseAlreadyClosedFormMDSService caseAlreadyClosedFormMDSService,
            MctsHealthWorkerErrorLogMDSService mctsHealthWorkerErrorLogMDSService,
            CareCaseTaskMDSService careCaseTaskMDSService,
            ChildMDSService childMDSService, ClientMDSService clientMDSService,
            MotherMDSService motherMDSService, WindowMDSService windowMDSService) {
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
        this.jobMetadataMDSService = jobMetadataMDSService;
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

        this.mctsDistrictMDSService = mctsDistrictMDSService;
        this.mctsLocationErrorLogMDSService = mctsLocationErrorLogMDSService;
        this.mctsPhcMDSService = mctsPhcMDSService;
        this.mctsPregnantMotherMDSService = mctsPregnantMotherMDSService;
        this.mctsStateMDSService = mctsStateMDSService;
        this.mctsSubcenterMDSService = mctsSubcenterMDSService;
        this.mctsTalukMDSService = mctsTalukMDSService;
        this.mctsVillageMDSService = mctsVillageMDSService;
        this.mctsHealthblockMDSService = mctsHealthblockMDSService;
        this.mctsHealthworkerMDSService = mctsHealthworkerMDSService;
        this.mctsPregnantMotherErrorLogMDSService = mctsPregnantMotherErrorLogMDSService;
        this.mctsPregnantMotherServiceUpdateMDSService = mctsPregnantMotherServiceUpdateMDSService;
        this.unapprovedToDiscussFormMDSService = unapprovedToDiscussFormMDSService;
        this.unmappedToReviewFormMDSService = unmappedToReviewFormMDSService;
        this.dontKnowFormMDSService = dontKnowFormMDSService;
        this.mappingToApproveFormMDSService = mappingToApproveFormMDSService;
        this.motherCaseMctsUpdateMDSService = motherCaseMctsUpdateMDSService;
        this.hubTransactionMDSService = hubTransactionMDSService;
        this.caseAlreadyClosedFormMDSService = caseAlreadyClosedFormMDSService;
        this.mctsHealthWorkerErrorLogMDSService = mctsHealthWorkerErrorLogMDSService;

        this.careCaseTaskMDSService = careCaseTaskMDSService;
        this.childMDSService = childMDSService;
        this.clientMDSService = clientMDSService;
        this.motherMDSService = motherMDSService;
        this.windowMDSService = windowMDSService;

    }

    @PostConstruct
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
        mapper.put(JobMetadata.class, jobMetadataMDSService);
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

        mapper.put(MctsPregnantMother.class, mctsPregnantMotherMDSService);
        mapper.put(MctsLocationErrorLog.class, mctsLocationErrorLogMDSService);
        mapper.put(MctsDistrict.class, mctsDistrictMDSService);
        mapper.put(MctsPhc.class, mctsPhcMDSService);
        mapper.put(MctsState.class, mctsStateMDSService);
        mapper.put(MctsSubcenter.class, mctsSubcenterMDSService);
        mapper.put(MctsTaluk.class, mctsTalukMDSService);
        mapper.put(MctsVillage.class, mctsVillageMDSService);
        mapper.put(MctsHealthblock.class, mctsHealthblockMDSService);
        mapper.put(MctsHealthworker.class, mctsHealthworkerMDSService);
        mapper.put(MctsPregnantMotherErrorLog.class,
                mctsPregnantMotherErrorLogMDSService);
        mapper.put(MctsPregnantMotherServiceUpdate.class,
                mctsPregnantMotherServiceUpdateMDSService);
        mapper.put(UnapprovedToDiscussForm.class,
                unapprovedToDiscussFormMDSService);
        mapper.put(UnmappedToReviewForm.class, unmappedToReviewFormMDSService);
        mapper.put(DontKnowForm.class, dontKnowFormMDSService);
        mapper.put(MappingToApproveForm.class, mappingToApproveFormMDSService);
        mapper.put(MotherCaseMctsUpdate.class, motherCaseMctsUpdateMDSService);
        mapper.put(HubTransaction.class, hubTransactionMDSService);
        mapper.put(CaseAlreadyClosedForm.class, caseAlreadyClosedFormMDSService);
        mapper.put(MctsHealthworkerErrorLog.class,
                mctsHealthWorkerErrorLogMDSService);

        mapper.put(CareCaseTask.class, careCaseTaskMDSService);
        mapper.put(Child.class, childMDSService);
        mapper.put(Client.class, clientMDSService);
        mapper.put(Mother.class, motherMDSService);
        mapper.put(Window.class, windowMDSService);

    }

    @Override
    public MotechDataService<?> fetchServiceInterface(Class<?> clazz) {
        if (mapper == null) {
            createEntityServiceMap();
        }
        return (MotechDataService<?>) mapper.get(clazz);
    }

    @Override
    public MotechDataService<?> fetchDefaultServiceInterface() {
        return this.abortFormMDSService;
    }

    public void initializeMetadata() {
        JobMetadata jobMetadata = jobMetadataMDSService
                .findByJobName("populate_delivery_offset_days");
        if (jobMetadata == null) {
            jobMetadata = new JobMetadata("populate_delivery_offset_days", null);
            jobMetadataMDSService.create(jobMetadata);
        }
    }
}
