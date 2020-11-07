package fr.projetiwa.covid_alert_covidState_ms.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;


@Entity(name="covid_state")
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Covid_state {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long state_id;
    private String state_label;

    /*@OneToMany(mappedBy = "covid_state")
    private List<Person_state> state_persons;
*/
    public long getState_id() {
        return state_id;
    }

    public void setState_id(long state_id) {
        this.state_id = state_id;
    }

    public String getState_label() {
        return state_label;
    }

    public void setState_label(String state_label) {
        this.state_label = state_label;
    }
/*
    public List<Person_state> getState_persons() {
        return state_persons;
    }

    public void setState_persons(List<Person_state> state_persons) {
        this.state_persons = state_persons;
    }*/
}