package fr.projetiwa.covid_alert_covidState_ms.controllers;

import fr.projetiwa.covid_alert_covidState_ms.models.Person_state;
import fr.projetiwa.covid_alert_covidState_ms.repositories.Person_stateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personState")
public class Person_stateController {
    @Autowired
    private Person_stateRepository person_stateRepository ;

    @GetMapping
    public List<Person_state> list () {
        return person_stateRepository.findAll(); }

}
