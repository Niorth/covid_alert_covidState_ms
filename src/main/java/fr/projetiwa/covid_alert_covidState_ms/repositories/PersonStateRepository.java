package fr.projetiwa.covid_alert_covidState_ms.repositories;

import fr.projetiwa.covid_alert_covidState_ms.models.PersonState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonStateRepository extends JpaRepository<PersonState,Long> {

    @Query("select p.covidState.stateLabel from personState p where p.personId = :personId and p.date = (select max(p2.date) from personState p2 where p2.personId = :personId)")
    String getLastCovidStateLabelByPersonId(@Param("personId")Long personId);

    @Query("select p.personStateId, p.personId, p.date, p.covidState from personState p where p.personId = :personId and p.date = (select max(p2.date) from personState p2 where p2.personId = :personId)")
    PersonState getLastPersonStateByPersonId(@Param("personId") Long personId);

}
