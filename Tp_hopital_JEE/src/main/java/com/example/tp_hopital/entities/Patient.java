package com.example.tp_hopital.entities;

import com.sun.xml.bind.v2.TODO;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String lastName;

    private String firstName;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] photo;

    @OneToMany(mappedBy = "patient" , cascade = CascadeType.ALL)
    private List<Consultation> consultationList;

    public Patient() {
    }

    public Patient(String lastName, String firstName, Date birthDate, byte[] photo) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.photo = photo;
    }

    public Patient(String lastName, String firstName, Date birthDate) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
    }

    public List<Consultation> getConsultationList() {
        return consultationList;
    }

    public void setConsultationList(List<Consultation> consultationList) {
        this.consultationList = consultationList;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
