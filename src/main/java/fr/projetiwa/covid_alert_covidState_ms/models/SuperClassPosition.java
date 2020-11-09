package fr.projetiwa.covid_alert_covidState_ms.models;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class SuperClassPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long positionId;
    protected Float longitude;
    protected Date positionDate;
    protected Float latitude;

    public long getPositionId() {
        return positionId;
    }

    public void setPositionId(long positionId) {
        this.positionId = positionId;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Date getPositionDate() {
        return positionDate;
    }

    public void setPositionDate(Date positionDate) {
        this.positionDate = positionDate;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }
}