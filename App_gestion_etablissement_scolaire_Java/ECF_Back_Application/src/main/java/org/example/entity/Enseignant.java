package org.example.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Enseignant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Matricule", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Departement departement;

    @ManyToMany(mappedBy = "enseignantList")
    private List<Matiere> matieres = new ArrayList<>();

    @ManyToMany(mappedBy = "enseignantList")
    private List<Classe> classeList = new ArrayList<>();

    @Column(nullable = false, length = 50)
    private String Nom_enseignant;

    @Column(length = 50)
    private String Prenom_enseignant;

    private int Age_enseignant;

    private String Grade_enseignant;


    private  boolean Prof_principal;

    private boolean Responsable_departement;


    public Enseignant() {
    }

    public Enseignant(String nom_enseignant, String prenom_enseignant, int age_enseignant, String grade_enseignant, boolean prof_principal, boolean responsable_departement) {
        Nom_enseignant = nom_enseignant;
        Prenom_enseignant = prenom_enseignant;
        Age_enseignant = age_enseignant;
        Grade_enseignant = grade_enseignant;
        Prof_principal = prof_principal;
        Responsable_departement = responsable_departement;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public List<Matiere> getMatieres() {
        return matieres;
    }

    public void setMatieres(List<Matiere> matieres) {
        this.matieres = matieres;
    }

    public List<Classe> getClasseList() {
        return classeList;
    }

    public void setClasseList(List<Classe> classeList) {
        this.classeList = classeList;
    }

    public String getNom_enseignant() {
        return Nom_enseignant;
    }

    public void setNom_enseignant(String nom_enseignant) {
        Nom_enseignant = nom_enseignant;
    }

    public String getPrenom_enseignant() {
        return Prenom_enseignant;
    }

    public void setPrenom_enseignant(String prenom_enseignant) {
        Prenom_enseignant = prenom_enseignant;
    }

    public int getAge_enseignant() {
        return Age_enseignant;
    }

    public void setAge_enseignant(int age_enseignant) {
        Age_enseignant = age_enseignant;
    }

    public String getGrade_enseignant() {
        return Grade_enseignant;
    }

    public void setGrade_enseignant(String grade_enseignant) {
        Grade_enseignant = grade_enseignant;
    }

    public boolean isProf_principal() {
        return Prof_principal;
    }

    public void setProf_principal(boolean prof_principal) {
        Prof_principal = prof_principal;
    }

    public boolean isResponsable_departement() {
        return Responsable_departement;
    }

    public void setResponsable_departement(boolean responsable_departement) {
        Responsable_departement = responsable_departement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Enseignant{" +
                "id=" + id +
                ", Nom_enseignant='" + Nom_enseignant + '\'' +
                ", Prenom_enseignant='" + Prenom_enseignant + '\'' +
                ", Age_enseignant=" + Age_enseignant +
                ", Grade_enseignant=" + Grade_enseignant +
                ", Prof_principal=" + Prof_principal +
                ", Responsable_departement=" + Responsable_departement +
                '}';
    }


}
