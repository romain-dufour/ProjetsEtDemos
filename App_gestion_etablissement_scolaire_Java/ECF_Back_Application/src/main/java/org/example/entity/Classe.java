package org.example.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Classe")
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id_classe", nullable = false)
    private Long id;

    @Column(length = 50)
    private String Nom_classe;

    @Column(length = 50)
    private String Niveau_classe;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Departement departement;

    @OneToMany(mappedBy = "classe" , cascade = CascadeType.ALL)
    private List<Etudiant> etudiantList;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="classe_enseignant",
            joinColumns = @JoinColumn(name="classe_id"),
            inverseJoinColumns = @JoinColumn(name="enseignant_id"))
    private List<Enseignant> enseignantList = new ArrayList<>();



    public Classe() {
    }

    public Classe(String nom_classe, String niveau_classe, Departement departement) {
        Nom_classe = nom_classe;
        Niveau_classe = niveau_classe;
        this.departement = departement;
    }

    public List<Enseignant> getEnseignantList() {
        return enseignantList;
    }

    public void setEnseignantList(List<Enseignant> enseignantList) {
        this.enseignantList = enseignantList;
    }

    public String getNom_classe() {
        return Nom_classe;
    }

    public void setNom_classe(String nom_classe) {
        Nom_classe = nom_classe;
    }

    public String getNiveau_classe() {
        return Niveau_classe;
    }

    public void setNiveau_classe(String niveau_classe) {
        Niveau_classe = niveau_classe;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public List<Etudiant> getEtudiantList() {
        return etudiantList;
    }

    public void setEtudiantList(List<Etudiant> etudiantList) {
        this.etudiantList = etudiantList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Classe{" +
                "id=" + id +
                ", Nom_classe='" + Nom_classe + '\'' +
                ", Niveau_classe='" + Niveau_classe + '\'' +
                ", departement=" + departement +
                '}';
    }
}
