package fr.projetiwa.covid_alert_covidState_ms.controllers;

import fr.projetiwa.covid_alert_covidState_ms.models.Covid_state;
import fr.projetiwa.covid_alert_covidState_ms.models.Person_state;
import fr.projetiwa.covid_alert_covidState_ms.repositories.Covid_stateRepository;
import fr.projetiwa.covid_alert_covidState_ms.repositories.Person_stateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/covidState")
public class Covid_stateController {
    @Autowired
    private Covid_stateRepository covid_stateRepository ;

    @GetMapping
    public List<Covid_state> list () {
        return covid_stateRepository.findAll(); }

}
