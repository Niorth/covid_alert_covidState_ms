package fr.projetiwa.covid_alert_covidState_ms.repositories;

import fr.projetiwa.covid_alert_covidState_ms.models.CovidState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CovidStateRepository extends JpaRepository<CovidState,Long> {
    @Query("select s.stateLabel from covidState s where s.stateId = :stateId ")
    String getLabelByStateId(@Param("stateId")Long stateId);
}
