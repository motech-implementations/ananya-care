package org.motechproject.care.service.router;

import org.motechproject.care.schedule.vaccinations.ChildVaccinationSchedule;
import org.motechproject.care.schedule.vaccinations.ExpirySchedule;
import org.motechproject.care.schedule.vaccinations.MotherVaccinationSchedule;
import org.motechproject.care.service.router.action.*;
import org.motechproject.scheduletracking.domain.WindowName;
import org.motechproject.scheduletracking.events.MilestoneEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.motechproject.care.service.router.Matcher.any;
import static org.motechproject.care.service.router.Matcher.anyOf;
import static org.motechproject.care.service.router.Matcher.eq;

@Component
public class AlertRoutes {

    private List<Route> routes;

    @Autowired
    public AlertRoutes(AlertChildAction alertChildAction,
            AlertMotherAction alertMotherAction,
            ClientExpiryAction expiryAction, Hep0ExpiryAction hep0ExpiryAction,
            Opv0ExpiryAction opv0ExpiryAction, BcgExpiryAction bcgExpiryAction,
            OpvExpiryAction opvExpiryAction, DptExpiryAction dptExpiryAction,
            DptBoosterExpiryAction dptBoosterExpiryAction,
            HepExpiryAction hepExpiryAction,
            MeaslesExpiryAction measlesExpiryAction,
            OpvBoosterExpiryAction opvBoosterExpiryAction,
            VitaExpiryAction vitaExpiryAction,
            MeaslesBoosterExpiryAction measlesBoosterExpiryAction) {
        routes = new ArrayList<Route>();
        routes.add(new Route(eq(ChildVaccinationSchedule.Hepatitis0.getName()),
                any(), eq(WindowName.late.name()), hep0ExpiryAction));
        routes.add(new Route(eq(ChildVaccinationSchedule.OPV0.getName()),
                any(), eq(WindowName.late.name()), opv0ExpiryAction));
        routes.add(new Route(eq(ChildVaccinationSchedule.Bcg.getName()), any(),
                eq(WindowName.late.name()), bcgExpiryAction));
        routes.add(new Route(eq(ChildVaccinationSchedule.OPV.getName()), any(),
                eq(WindowName.late.name()), opvExpiryAction));
        routes.add(new Route(eq(ChildVaccinationSchedule.DPT.getName()), any(),
                eq(WindowName.late.name()), dptExpiryAction));
        routes.add(new Route(eq(ChildVaccinationSchedule.DPTBooster.getName()),
                any(), eq(WindowName.late.name()), dptBoosterExpiryAction));
        routes.add(new Route(eq(ChildVaccinationSchedule.Hepatitis.getName()),
                any(), eq(WindowName.late.name()), hepExpiryAction));
        routes.add(new Route(eq(ChildVaccinationSchedule.Measles.getName()),
                any(), eq(WindowName.late.name()), measlesExpiryAction));
        routes.add(new Route(eq(ChildVaccinationSchedule.OPVBooster.getName()),
                any(), eq(WindowName.late.name()), opvBoosterExpiryAction));
        routes.add(new Route(eq(ChildVaccinationSchedule.Vita.getName()),
                any(), eq(WindowName.late.name()), vitaExpiryAction));
        routes.add(new Route(eq(ChildVaccinationSchedule.MeaslesBooster.getName()),
                any(), eq(WindowName.late.name()), measlesBoosterExpiryAction));
        routes.add(new Route(childSchedules(), any(), any(), alertChildAction));
        routes.add(new Route(motherSchedules(), any(), any(), alertMotherAction));
        //routes.add(new Route(expirySchedules(), any(), any(), expiryAction));
    }

    private Matcher childSchedules() {
        ArrayList<String> childVaccines = new ArrayList<String>();
        for (ChildVaccinationSchedule b : ChildVaccinationSchedule.values()) {
            childVaccines.add(b.getName());
        }
        return anyOf(childVaccines);
    }

    private Matcher motherSchedules() {
        ArrayList<String> motherVaccines = new ArrayList<String>();
        for (MotherVaccinationSchedule b : MotherVaccinationSchedule.values()) {
            motherVaccines.add(b.getName());
        }
        return anyOf(motherVaccines);
    }

    private Matcher expirySchedules() {
        ArrayList<String> expiryVaccines = new ArrayList<String>();
        for (ExpirySchedule b : ExpirySchedule.values()) {
            expiryVaccines.add(b.getName());
        }
        return anyOf(expiryVaccines);
    }

    public void route(MilestoneEvent event) {
        for (Route route : routes) {
            if (route.isSatisfiedBy(event.getScheduleName(), event
                    .getMilestoneAlert().getMilestoneName(), event
                    .getWindowName())) {
                route.invokeAction(event);
                return;
            }
        }

        throw new NoRoutesMatchException();
    }
}
