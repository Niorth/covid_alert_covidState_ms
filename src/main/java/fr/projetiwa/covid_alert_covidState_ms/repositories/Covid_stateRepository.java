package fr.projetiwa.covid_alert_covidState_ms.repositories;

import fr.projetiwa.covid_alert_covidState_ms.models.Covid_state;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Covid_stateRepository extends JpaRepository<Covid_state,Long> {
}
