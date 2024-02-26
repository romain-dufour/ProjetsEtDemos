package com.example.tp_hopital.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_consultation", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Temporal(TemporalType.DATE)
    private Date consultDate;

    private String doctorName;

    @OneToMany(mappedBy = "consultation" , cascade = CascadeType.ALL)
    private List<Prescription> prescriptionList;

    @OneToMany(mappedBy = "consultation" , cascade = CascadeType.ALL)
    private List<FicheDeSoin> ficheDeSoinList;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public Consultation() {
    }

    public Consultation(Date consultDate, String doctorName, Patient patient) {
        this.consultDate = consultDate;
        this.doctorName = doctorName;
        this.patient = patient;
    }

    public Consultation(Date consultDate, String doctorName, List<Prescription> prescriptionList, List<FicheDeSoin> ficheDeSoinList, Patient patient) {
        this.consultDate = consultDate;
        this.doctorName = doctorName;
        this.prescriptionList = prescriptionList;
        this.ficheDeSoinList = ficheDeSoinList;
        this.patient = patient;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getConsultDate() {
        return consultDate;
    }

    public void setConsultDate(Date consultDate) {
        this.consultDate = consultDate;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public List<Prescription> getPrescriptionList() {
        return prescriptionList;
    }

    public void setPrescriptionList(List<Prescription> prescriptionList) {
        this.prescriptionList = prescriptionList;
    }

    public List<FicheDeSoin> getFicheDeSoinList() {
        return ficheDeSoinList;
    }

    public void setFicheDeSoinList(List<FicheDeSoin> ficheDeSoinList) {
        this.ficheDeSoinList = ficheDeSoinList;
    }
}
