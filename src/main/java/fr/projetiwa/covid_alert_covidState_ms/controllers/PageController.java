package fr.projetiwa.covid_alert_covidState_ms.controllers;


import fr.projetiwa.covid_alert_covidState_ms.models.CovidState;
import fr.projetiwa.covid_alert_covidState_ms.models.PersonState;
import fr.projetiwa.covid_alert_covidState_ms.repositories.CovidStateRepository;
import fr.projetiwa.covid_alert_covidState_ms.repositories.PersonStateRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.*;

@Controller
public class PageController {

    @Autowired
    private PersonStateRepository personStateRepository ;

    @GetMapping
    @RequestMapping("personState/update/{personId}")
    public String changePersonState(@PathVariable Long personId, Model model){
        PersonState personState = personStateRepository.getLastPersonStateStateByPersonId(personId);
        model.addAttribute("personId",personId);
        model.addAttribute("personState",personState);
        return "changeCovidState";
    }
}
