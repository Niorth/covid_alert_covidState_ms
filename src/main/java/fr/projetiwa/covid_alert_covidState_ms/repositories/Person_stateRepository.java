package fr.projetiwa.covid_alert_covidState_ms.repositories;

import fr.projetiwa.covid_alert_covidState_ms.models.Person_state;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Person_stateRepository extends JpaRepository<Person_state,Long> {
}
