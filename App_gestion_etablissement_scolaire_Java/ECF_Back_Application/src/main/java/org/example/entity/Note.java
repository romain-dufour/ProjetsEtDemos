package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id_note", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "matiere_id")
    private Matiere matiere;

    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant ;

    private Double Valeur_note;

    @Column(length = 250)

    private String Commentaire_note;


    public Note() {
    }

    public Note(Matiere matiere, Etudiant etudiant, Double valeur_note, String commentaire_note) {
        this.matiere = matiere;
        this.etudiant = etudiant;
        Valeur_note = valeur_note;
        Commentaire_note = commentaire_note;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Double getValeur_note() {
        return Valeur_note;
    }

    public void setValeur_note(Double valeur_note) {
        Valeur_note = valeur_note;
    }

    public String getCommentaire_note() {
        return Commentaire_note;
    }

    public void setCommentaire_note(String commentaire_note) {
        Commentaire_note = commentaire_note;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", Valeur_note=" + Valeur_note +
                ", Commentaire_note='" + Commentaire_note + '\'' +
                '}';
    }
}
