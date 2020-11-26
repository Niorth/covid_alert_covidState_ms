package fr.projetiwa.covid_alert_covidState_ms.controllers;

import fr.projetiwa.covid_alert_covidState_ms.models.CovidState;
import fr.projetiwa.covid_alert_covidState_ms.repositories.CovidStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/covidState")
public class CovidStateController {
    @Autowired
    private CovidStateRepository covidStateRepository ;
    /**
     * get all the CovidState
     * @return list of CovidState
     */
    @GetMapping
    public List<CovidState> list () {
        return covidStateRepository.findAll();
    }

}
