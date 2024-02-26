#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: Departement
#------------------------------------------------------------

CREATE TABLE Departement(
        Id_departement  Int  Auto_increment  NOT NULL ,
        Nom_departement Varchar (50)
	,CONSTRAINT Departement_PK PRIMARY KEY (Id_departement)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Matiere
#------------------------------------------------------------

CREATE TABLE Matiere(
        Id_matiere          Int  Auto_increment  NOT NULL ,
        Intitule_matiere    Varchar (50) ,
        Description_matiere Varchar (250) ,
        Duree_matiere       Int ,
        Coefficient_matiere Int 
	,CONSTRAINT Matiere_PK PRIMARY KEY (Id_matiere)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Enseignant
#------------------------------------------------------------

CREATE TABLE Enseignant(
        Matricule               Int  Auto_increment  NOT NULL ,
        Nom_enseignant          Varchar (50)  ,
        Prenom_enseignant       Varchar (50) ,
        Age_enseignant          Int  ,
        Grade_enseignant        Int ,
        Prof_principal          Bool  ,
        Responsable_departement Bool  ,
        Id_departement          Int 
	,CONSTRAINT Enseignant_PK PRIMARY KEY (Matricule)

	,CONSTRAINT Enseignant_Departement_FK FOREIGN KEY (Id_departement) REFERENCES Departement(Id_departement)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Classe
#------------------------------------------------------------

CREATE TABLE Classe(
        Id_classe      Int  Auto_increment  NOT NULL ,
        Nom_classe     Varchar (50) ,
        Niveau_classe  Varchar (50)  ,
        Id_departement Int
	,CONSTRAINT Classe_PK PRIMARY KEY (Id_classe)

	,CONSTRAINT Classe_Departement_FK FOREIGN KEY (Id_departement) REFERENCES Departement(Id_departement)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Etudiant
#------------------------------------------------------------

CREATE TABLE Etudiant(
        Id_etudiant     Int  Auto_increment  NOT NULL ,
        Nom_etudiant    Varchar (50)  ,
        Prenom_etudiant Varchar (50)  ,
        Date_naissance  Date  ,
        Email           Varchar (250)  ,
        Id_classe       Int 
	,CONSTRAINT Etudiant_PK PRIMARY KEY (Id_etudiant)

	,CONSTRAINT Etudiant_Classe_FK FOREIGN KEY (Id_classe) REFERENCES Classe(Id_classe)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Emploi_du_temps
#------------------------------------------------------------

CREATE TABLE Emploi_du_temps(
        Id_emploi_du_temps Int  Auto_increment  NOT NULL ,
        Jour               Date ,
        Id_etudiant        Int
	,CONSTRAINT Emploi_du_temps_PK PRIMARY KEY (Id_emploi_du_temps)

	,CONSTRAINT Emploi_du_temps_Etudiant_FK FOREIGN KEY (Id_etudiant) REFERENCES Etudiant(Id_etudiant)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Note
#------------------------------------------------------------

CREATE TABLE Note(
        Id_note          Int  Auto_increment  NOT NULL ,
        Valeur_note      Float ,
        Commentaire_note Varchar (250) ,
        Id_matiere       Int  ,
        Id_etudiant      Int 
	,CONSTRAINT Note_PK PRIMARY KEY (Id_note)

	,CONSTRAINT Note_Matiere_FK FOREIGN KEY (Id_matiere) REFERENCES Matiere(Id_matiere)
	,CONSTRAINT Note_Etudiant0_FK FOREIGN KEY (Id_etudiant) REFERENCES Etudiant(Id_etudiant)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Enseigne
#------------------------------------------------------------

CREATE TABLE matiere_enseignant(
        Id_matiere Int NOT NULL ,
        Matricule  Int NOT NULL
	,CONSTRAINT Enseigne_PK PRIMARY KEY (Id_matiere,Matricule)

	,CONSTRAINT Enseigne_Matiere_FK FOREIGN KEY (Id_matiere) REFERENCES Matiere(Id_matiere)
	,CONSTRAINT Enseigne_Enseignant0_FK FOREIGN KEY (Matricule) REFERENCES Enseignant(Matricule)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: inculque
#------------------------------------------------------------

CREATE TABLE classe_enseignant(
        Id_classe Int NOT NULL ,
        Matricule Int NOT NULL
	,CONSTRAINT inculque_PK PRIMARY KEY (Id_classe,Matricule)

	,CONSTRAINT inculque_Classe_FK FOREIGN KEY (Id_classe) REFERENCES Classe(Id_classe)
	,CONSTRAINT inculque_Enseignant0_FK FOREIGN KEY (Matricule) REFERENCES Enseignant(Matricule)
)ENGINE=InnoDB;

