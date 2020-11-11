package fr.projetiwa.covid_alert_covidState_ms.controllers;

import fr.projetiwa.covid_alert_covidState_ms.models.PersonState;
import fr.projetiwa.covid_alert_covidState_ms.repositories.PersonStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personState")
public class PersonStateController {
    @Autowired
    private PersonStateRepository personStateRepository ;

    @GetMapping
    public List<PersonState> list () {
        return personStateRepository.findAll(); }

    @GetMapping
    @RequestMapping("/isNegative")
    public Boolean isNegative (@RequestParam("personId") long personId) {
        String covidStateLabel = personStateRepository.getLastCovidStateLabelByPersonId(personId);
        if(covidStateLabel.equals("negative")){
            return true;
        }
        return false;
    }

}
