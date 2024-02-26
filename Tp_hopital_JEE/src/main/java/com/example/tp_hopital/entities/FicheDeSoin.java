package com.example.tp_hopital.entities;

import javax.persistence.*;

@Entity
public class FicheDeSoin {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_ficheDeSoin", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String typeOfCare;

    private int duration;

    @ManyToOne
    @JoinColumn(name = "consultation_id")
    private Consultation consultation;

    public FicheDeSoin() {
    }


    public FicheDeSoin(String typeOfCare, int duration, Consultation consultation) {
        this.typeOfCare = typeOfCare;
        this.duration = duration;
        this.consultation = consultation;
    }

    public String getTypeOfCare() {
        return typeOfCare;
    }

    public void setTypeOfCare(String typeOfCare) {
        this.typeOfCare = typeOfCare;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
