package fr.projetiwa.covid_alert_covidState_ms.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity(name="personState")
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class PersonState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long personStateId;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    private String personId;

    private Date date;

    @ManyToOne
    @JoinColumn(name = "covidStateId")
    @JsonIgnore
    private CovidState covidState;

    public PersonState(){

    }

    public PersonState(long personStateId, String personId, Date date, CovidState covidState) {
        this.personStateId = personStateId;
        this.personId = personId;
        this.date = date;
        this.covidState = covidState;
    }

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

    public void setCovidState(CovidState covidState) {
        this.covidState = covidState;
    }

    /**
     * Check if the user is allowed to change is State
     * (He cannot change status if positive at covid-19 less than 7 days ago)
     * @return
     */
    public boolean forbiddenUpdateState(){
        Long sevenDaysAgo = new Date().getTime() - (7*24*3600*1000);
        return (this.getDate().after(new Date(sevenDaysAgo)) && this.getCovidState().getStateId()==1);
    }



}