package fr.projetiwa.covid_alert_covidState_ms.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;


@Entity(name="covidState")
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class CovidState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long stateId;
    private String stateLabel;

    public CovidState(long stateId, String stateLabel) {
        this.stateId = stateId;
        this.stateLabel = stateLabel;
    }
    public CovidState() {
    }
    public long getStateId() {
        return stateId;
    }

    public void setStateId(long stateId) {
        this.stateId = stateId;
    }

    public String getStateLabel() {
        return stateLabel;
    }

    public void setStateLabel(String stateLabel) {
        this.stateLabel = stateLabel;
    }

    public boolean isPositive(){return this.stateId==1;}
}