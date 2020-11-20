package fr.projetiwa.covid_alert_covidState_ms.controllers;


import fr.projetiwa.covid_alert_covidState_ms.models.CovidState;
import fr.projetiwa.covid_alert_covidState_ms.models.PersonState;
import fr.projetiwa.covid_alert_covidState_ms.repositories.CovidStateRepository;
import fr.projetiwa.covid_alert_covidState_ms.repositories.PersonStateRepository;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.time.Instant;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/personState")
public class PersonStateController {
    @Autowired
    private PersonStateRepository personStateRepository ;

    @Autowired
    private CovidStateRepository covidStateRepository ;

    @GetMapping
    public List<PersonState> list () {
        return personStateRepository.findAll(); }

    @GetMapping("/isNegative")
    public Boolean isNegative (@RequestHeader (name="Authorization") String token) {
        String payload = token.split("\\.")[1];

        try {
            String str = new String(Base64.decodeBase64(payload),"UTF-8");
            JSONObject jsonObject = new JSONObject(str);

            String personId = jsonObject.getString("sub");
            String covidStateLabel = personStateRepository.getLastCovidStateLabelByPersonId(personId);
            if(covidStateLabel.equals("negative")){
                return true;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return false;
    }

    @PostMapping("/update")
    public String changePersonState(@RequestHeader (name="Authorization") String token, @RequestBody String req){
        String payload = token.split("\\.")[1];

        try {
            String str = new String(Base64.decodeBase64(payload),"UTF-8");
            JSONObject jsonObject = new JSONObject(str);
            String personId = jsonObject.getString("sub");
            JSONObject json = new JSONObject(req);
            Long stateId = json.getLong("stateId");
            CovidState selectedCovidState = covidStateRepository.getCovidStateByStateId(stateId);
            PersonState newPersonState = new PersonState();
            newPersonState.setPersonId(personId);
            newPersonState.setDate(Date.from(Instant.now()));
            newPersonState.setCovidState(selectedCovidState);
            personStateRepository.saveAndFlush(newPersonState);


            //Check if new state is positive
            if(selectedCovidState.isPositive()){
                String urlPositions = "http://localhost:3003/positions/setSuspicious";
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
                headers.add(HttpHeaders.AUTHORIZATION, token);
                HttpEntity request = new HttpEntity(headers);
                RestTemplate restTemplate = new RestTemplate();
                String serviceUrl = urlPositions;
                //System.out.println(headers);
                ResponseEntity<String> response = restTemplate.exchange( serviceUrl, HttpMethod.POST, request, String.class, 1 );
            }



        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }





        return "{\"success\":1}";
    }

}
