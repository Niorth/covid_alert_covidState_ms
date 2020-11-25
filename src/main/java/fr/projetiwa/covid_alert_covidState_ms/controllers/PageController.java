package fr.projetiwa.covid_alert_covidState_ms.controllers;


import fr.projetiwa.covid_alert_covidState_ms.models.PersonState;
import fr.projetiwa.covid_alert_covidState_ms.repositories.PersonStateRepository;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;


@Controller
public class PageController {

    @Autowired
    private PersonStateRepository personStateRepository ;

    /**
     *
     * @param principal
     * @param model
     * @return the html page to fill the form and set the new personState
     */
    @GetMapping
    @RequestMapping("personState/update")
    public String changePersonState(Principal principal, Model model){
        String personId = principal.getName();
        PersonState personState = personStateRepository.getLastPersonStateStateByPersonId(personId);
        model.addAttribute("personId",personId);
        model.addAttribute("personState",personState);
        return "changeCovidState";
    }



    @GetMapping
    @RequestMapping("personState/states")
    public String personState(Model model, Principal principal){
        String personId = principal.getName();
        ArrayList<PersonState> personStates = personStateRepository.getAllPersonStateByPersonId(personId);
        model.addAttribute("personStates",personStates);
        return "personState";
    }


}
