package fr.projetiwa.covid_alert_covidState_ms.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;


@Entity(name="person")
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long personId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;

    @ManyToMany
    @JoinTable(name="personPosition",
            joinColumns = @JoinColumn(name="personId"),
            inverseJoinColumns = @JoinColumn(name="positionId"))
    private List<Position> position;

    @OneToMany(mappedBy = "person")
    private List<Person_state> person_states;

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Position> getPosition() {
        return position;
    }

    public void setPosition(List<Position> position) {
        this.position = position;
    }

    public List<Person_state> getPerson_states() {
        return person_states;
    }

    public void setPerson_states(List<Person_state> person_states) {
        this.person_states = person_states;
    }
}
