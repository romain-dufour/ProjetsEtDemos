package com.example.tp_hopital.entities;

import javax.persistence.*;

@Entity
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_prescription", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String medicType ;

    private int duration;

    @ManyToOne
    @JoinColumn(name = "consultation_id")
    private Consultation consultation;

    public Prescription() {
    }


    public Prescription(String medicType, int duration, Consultation consultation) {
        this.medicType = medicType;
        this.duration = duration;
        this.consultation = consultation;
    }

    public String getMedicType() {
        return medicType;
    }

    public void setMedicType(String medicType) {
        this.medicType = medicType;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
