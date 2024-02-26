package org.example.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Matiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_matiere", nullable = false)
    private Long id;

    @OneToMany(mappedBy = "matiere", cascade = CascadeType.ALL)
    private List<Note> noteList;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="matiere_enseignant",
            joinColumns = @JoinColumn(name="matiere_id"),
            inverseJoinColumns = @JoinColumn(name="enseignant_id"))
    private List<Enseignant> enseignantList = new ArrayList<>();

    @Column(length = 50)
    private String Intitule_matiere;

    @Column(length = 250)
    private String Description_matiere;

    private int Duree_matiere;

    private int Coefficient_matiere;


    public Matiere() {
    }

    public Matiere(String intitule_matiere, String description_matiere, int duree_matiere, int coefficient_matiere) {
        Intitule_matiere = intitule_matiere;
        Description_matiere = description_matiere;
        Duree_matiere = duree_matiere;
        Coefficient_matiere = coefficient_matiere;
    }

    public List<Note> getNoteList() {
        return noteList;
    }

    public void setNoteList(List<Note> noteList) {
        this.noteList = noteList;
    }

    public List<Enseignant> getEnseignantList() {
        return enseignantList;
    }

    public void setEnseignantList(List<Enseignant> enseignantList) {
        this.enseignantList = enseignantList;
    }

    public String getIntitule_matiere() {
        return Intitule_matiere;
    }

    public void setIntitule_matiere(String intitule_matiere) {
        Intitule_matiere = intitule_matiere;
    }

    public String getDescription_matiere() {
        return Description_matiere;
    }

    public void setDescription_matiere(String description_matiere) {
        Description_matiere = description_matiere;
    }

    public int getDuree_matiere() {
        return Duree_matiere;
    }

    public void setDuree_matiere(int duree_matiere) {
        Duree_matiere = duree_matiere;
    }

    public int getCoefficient_matiere() {
        return Coefficient_matiere;
    }

    public void setCoefficient_matiere(int coefficient_matiere) {
        Coefficient_matiere = coefficient_matiere;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Matiere{" +
                "id=" + id +
                ", Intitule_matiere='" + Intitule_matiere + '\'' +
                ", Description_matiere='" + Description_matiere + '\'' +
                ", Duree_matiere=" + Duree_matiere +
                ", Coefficient_matiere=" + Coefficient_matiere +
                '}';
    }
}
