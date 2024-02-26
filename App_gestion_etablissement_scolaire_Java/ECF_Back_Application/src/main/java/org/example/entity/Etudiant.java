package org.example.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id_etudiant", nullable = false)
    private Long id;

    @Column(nullable = false, length = 50)
    private String Nom_etudiant;

    @Column(length = 50)
    private String Prenom_etudiant;


    private Date Date_naissance;

    @Column(length = 250)
    private String Email;

    @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL)
    private List<Emplois_du_temps> emploisDuTempsList;

    @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL)
    private List<Note> noteList;


    @ManyToOne
    @JoinColumn(name = "class_id")
    private Classe classe;


    public Etudiant() {
    }

    public Etudiant(String nom_etudiant, String prenom_etudiant, Date date_naissance, String email) {
        Nom_etudiant = nom_etudiant;
        Prenom_etudiant = prenom_etudiant;
        Date_naissance = date_naissance;
        Email = email;
    }

    public Etudiant(String nom_etudiant, String prenom_etudiant, Date date_naissance, String email, Classe classe) {
        Nom_etudiant = nom_etudiant;
        Prenom_etudiant = prenom_etudiant;
        Date_naissance = date_naissance;
        Email = email;
        this.classe = classe;
    }

    public List<Note> getNoteList() {
        return noteList;
    }

    public void setNoteList(List<Note> noteList) {
        this.noteList = noteList;
    }

    public List<Emplois_du_temps> getEmploisDuTempsList() {
        return emploisDuTempsList;
    }

    public void setEmploisDuTempsList(List<Emplois_du_temps> emploisDuTempsList) {
        this.emploisDuTempsList = emploisDuTempsList;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public String getNom_etudiant() {
        return Nom_etudiant;
    }

    public void setNom_etudiant(String nom_etudiant) {
        Nom_etudiant = nom_etudiant;
    }

    public String getPrenom_etudiant() {
        return Prenom_etudiant;
    }

    public void setPrenom_etudiant(String prenom_etudiant) {
        Prenom_etudiant = prenom_etudiant;
    }

    public Date getDate_naissance() {
        return Date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        Date_naissance = date_naissance;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "id=" + id +
                ", Nom_etudiant='" + Nom_etudiant + '\'' +
                ", Prenom_etudiant='" + Prenom_etudiant + '\'' +
                ", Date_naissance=" + Date_naissance +
                ", Email='" + Email + '\'' +
                '}';
    }
}
