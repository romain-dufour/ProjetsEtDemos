package org.example.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Departement")
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_departement", nullable = false)
    private Long id;

    @Column(length = 50)
    private String Nom_departement;

    @OneToMany(mappedBy = "departement", cascade = CascadeType.ALL)
    private List<Enseignant> enseignantList;

    @OneToMany(mappedBy = "departement", cascade = CascadeType.ALL)
    private List<Classe> classeList;

    public Departement() {
    }

    public Departement(String nom_departement) {
        Nom_departement = nom_departement;
    }

    public List<Classe> getClasseList() {
        return classeList;
    }

    public void setClasseList(List<Classe> classeList) {
        this.classeList = classeList;
    }

    public String getNom_departement() {
        return Nom_departement;
    }

    public void setNom_departement(String nom_departement) {
        Nom_departement = nom_departement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Enseignant> getEnseignantList() {
        return enseignantList;
    }

    public void setEnseignantList(List<Enseignant> enseignantList) {
        this.enseignantList = enseignantList;
    }

    @Override
    public String toString() {
        return "Departement{" +
                "id=" + id +
                ", Nom_departement='" + Nom_departement + '\'' +
                '}';
    }
}
