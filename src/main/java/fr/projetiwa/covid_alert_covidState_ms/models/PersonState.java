package fr.projetiwa.covid_alert_covidState_ms.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity(name="personState")
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class PersonState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long personStateId;

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    private long personId;

    private Date date;

    @ManyToOne
    @JoinColumn(name = "covidStateId")
    @JsonIgnore
    private CovidState covidState;

    public long getPersonStateId() {
        return personStateId;
    }

    public void setPersonStateId(long personStateId) {
        this.personStateId = personStateId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public CovidState getCovidState() {
        return covidState;
    }

    public void setCovid_state(CovidState covidState) {
        this.covidState = covidState;
    }

}