package fr.projetiwa.covid_alert_covidState_ms.repositories;

import fr.projetiwa.covid_alert_covidState_ms.models.CovidState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface CovidStateRepository extends JpaRepository<CovidState,Long> {

    CovidState getCovidStateByStateId(Long stateId);
    CovidState getCovidStateByStateLabel(String stateLabel);
}
