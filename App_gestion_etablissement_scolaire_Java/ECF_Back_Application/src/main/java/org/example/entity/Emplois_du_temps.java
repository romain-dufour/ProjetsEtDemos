package org.example.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table
public class Emplois_du_temps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_emploi_du_temps", nullable = false)
    private Long id;

    private LocalDateTime Jour;

    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;



    public Emplois_du_temps() {
    }

    public Emplois_du_temps(LocalDateTime jour, Etudiant etudiant) {
        Jour = jour;
        this.etudiant = etudiant;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public LocalDateTime getJour() {
        return Jour;
    }

    public void setJour(LocalDateTime jour) {
        Jour = jour;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Emplois_du_temps{" +
                "id=" + id +
                ", Jour=" + Jour +
                '}';
    }
}
