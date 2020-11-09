package fr.projetiwa.covid_alert_covidState_ms.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity(name="personState")
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Person_state {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long personStateId;

    @ManyToOne
    @JoinColumn(name = "personId")
    @JsonIgnore
    private Person person;

    private Date date;

    @ManyToOne
    @JoinColumn(name = "covidStateId")
    @JsonIgnore
    private Covid_state covidState;

    public long getPersonStateId() {
        return personStateId;
    }

    public void setPersonStateId(long personStateId) {
        this.personStateId = personStateId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Covid_state getCovidState() {
        return covidState;
    }

    public void setCovid_state(Covid_state covidState) {
        this.covidState = covidState;
    }

}