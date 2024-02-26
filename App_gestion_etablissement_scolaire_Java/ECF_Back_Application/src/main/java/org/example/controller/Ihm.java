package org.example.controller;


import org.example.entity.*;
import org.example.services.*;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Ihm {

    private ClasseService classeService;
    private DepartementService departementService;
    private Emplois_du_tempsService emploisDuTempsService;
    private EnseignantService enseignantService;
    private EtudiantService etudiantService;
    private MatiereService matiereService;
    private NoteService noteService;
    private Scanner scanner;

    public  Ihm() {
        classeService = new ClasseService();
        departementService = new DepartementService();
        emploisDuTempsService = new Emplois_du_tempsService();
        enseignantService= new EnseignantService();
        etudiantService = new EtudiantService();
        matiereService = new MatiereService();
        noteService = new NoteService();
        scanner = new Scanner(System.in);

    }

    public  void start() {
        String choice;
        do {
            menu();
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    creerDepartement();
                    break;
                case "2":
                    creerEnseignant();
                    break;
                case "3":
                    creerEtudiant();
                    break;
                case "4":
                    creerMatiere();
                    break;
                case "5":
                    creerNote();
                    break;
                case "6":
                    creerClasse();
                    break;
                case "7":
                    creerEmploiDuTemps();
                    break;
                case "8":
                    afficherListeClassesSansEleves();
                    break;
                case "9":
                    afficherNombreMatiereEleve();
                    break;
                case "10":
                    afficherListeNoteEleveAvecDetails();
                    break;
                case "11":
                    afficherMoyenneEleve();
                    break;
                case "12":
                    afficherNombreEleveDepartement();
                    break;
                case "13":
                    afficherNomElevesNiveau();
                    break;
                case "14":
                    supprimerEleve();
                    break;
                case "15":
                    suppressionClasse();
                    break;
                case "16":
                    suppressionDepartement();
                    break;
            }
        }while(!choice.equals("0"));
        departementService.end();
    }


    private void menu() {
        System.out.println("########  Menu  #########");
        System.out.println("1 -- Créer un département");
        System.out.println("2 -- Créer un enseignant");
        System.out.println("3 -- Créer un etudiant");
        System.out.println("4 -- Créer une matière ");
        System.out.println("5 -- Créer une note ");
        System.out.println("6 -- Créer une classe ");
        System.out.println("7 -- Créer un emploi du temps");
        System.out.println("8 -- Afficher la liste des classes (sans les eleves)");
        System.out.println("9 -- Afficher le nombre de matière d'un élève");
        System.out.println("10 -- Afficher la liste des notes d'un eleve (avec les détails)");
        System.out.println("11 -- Aficher la moyenne d'un eleve");
        System.out.println("12 -- Afficher le nombre d'eleve d'un département");
        System.out.println("13 -- Afficher tous les noms des eleves d'un niveau");
        System.out.println("14 -- Suppression d'un eleve, supprimera sa note mais pas sa classe");
        System.out.println("15 -- Suppression classe => supprime uniquement les éléves de cette classe.");
        System.out.println("16 -- Suppression d'un departement => Supprime toutes les classes et tous les professeurs");

        System.out.println("0 -- Quitter ");


    }

    private void creerDepartement(){
        try{
        System.out.println("Merci de saisir le nom du département : ");
        String nom_departement = scanner.nextLine();
        Departement departement = new Departement(nom_departement);
        if(departementService.create(departement)) {
            System.out.println("Departement ajouté");
        }else {
            System.out.println("Erreur ajout");
        }

    }catch (Exception e){
        System.out.println(e.getMessage());
    }
    }


    private void creerEnseignant(){
        try{
            String nom_enseignant;
            do {
                System.out.println("Merci de saisir le nom de l'enseignant (au moins 3 caractères) : ");
                nom_enseignant = scanner.nextLine();
            } while (nom_enseignant.length() < 3);

        System.out.println("Merci de saisir le prenom de l'enseignant : ");
        String prenom_enseignant = scanner.nextLine();
            boolean value = true;
            int age_enseignant ;
            do {
                System.out.println("Merci de saisir l'age de l'enseignant : ");
                age_enseignant = scanner.nextInt();
                if (age_enseignant >= 18){
                    value = true;
                }else {
                    value = false;
                    System.out.println("Vous avez saisi un age inférieur à 18 ans, l'enseignant doit être majeur");
                }
            }while (!value);

        scanner.nextLine();
        System.out.println("Merci de saisir le grade de l'enseignant : ");
        String grade_enseignant = scanner.nextLine();
        boolean prof_principal = false;
        boolean resp_dept = false;
        do {
            System.out.println("L'enseignant est il professeur principal ? oui : 1, non : 0 ");
            int reponse_prof_principal = scanner.nextInt();
            if (reponse_prof_principal == 0){
                prof_principal = false;
                value = true;
            }else if (reponse_prof_principal == 1){
                prof_principal=true;
                value = true;
            }else {
               value = false;
                System.out.println("Saisissez oui : 1, non : 0 ");
            }
        }while (!value);

        value = true;

        do {
            System.out.println("L'enseignant est il responsable d'un département ? oui : 1, non : 0 ");
            int reponse_resp_dept = scanner.nextInt();
            if (reponse_resp_dept == 0){
                resp_dept = false;
                value = true;
            } else if (reponse_resp_dept == 1){
                resp_dept=true;
                value = true;
            }else {
                value = false;
                System.out.println("Saisissez oui : 1, non : 0 ");
            }
        }while (!value);
            scanner.nextLine();

        Enseignant enseignant = new Enseignant(nom_enseignant,prenom_enseignant, age_enseignant, grade_enseignant, prof_principal, resp_dept);


        if(enseignantService.create(enseignant)) {
            System.out.println("Enseignant ajouté");
        }else {
            System.out.println("Erreur ajout");
        }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void creerEtudiant(){
        try {
            String nom_etudiant;
            do {
                System.out.println("Merci de saisir le nom de l'étudiant (au moins 3 caractères) : ");
                nom_etudiant = scanner.nextLine();
            } while (nom_etudiant.length() < 3);


            System.out.println("Merci de saisir le prenom de l'etudiant : ");
            String prenom_etudiant = scanner.nextLine();
            System.out.println("Merci de saisir la date de naissance de l'étudiant :(dd/MM/YYYY) :");
            String date = scanner.nextLine();

            Date date_naissane = new SimpleDateFormat("dd/MM/yyyy").parse(date);

            String email_etudiant;
            do {
                System.out.println("Merci de saisir l'e-mail de l'étudiant (l'e-mail doit finir par @gmail.com) :");
                email_etudiant = scanner.nextLine();
            } while (!email_etudiant.endsWith("@gmail.com"));


            System.out.println("Voici la liste des classes");
            List<Classe>classeList = classeService.findAll();
            for (Classe c: classeList
                 ) {
                System.out.println("Classe : " + c.toString());
            }

            System.out.println("Merci de saisir l'id de la classe de l'étudiant:");
            Long classe_id = scanner.nextLong();
            scanner.nextLine();

            Classe classe = this.classeService.findById(classe_id);

            Etudiant etudiant = new Etudiant(nom_etudiant,prenom_etudiant,date_naissane,email_etudiant, classe);

            if(etudiantService.create(etudiant)) {
                System.out.println("Etudiant ajouté");
            }else {
                System.out.println("Erreur ajout");}
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void creerMatiere(){
        try {
            System.out.println("Merci de saisir l'intitulé de la matiere': ");
            String intitule_matiere = scanner.nextLine();
            System.out.println("Merci de saisir la description de la matiere: ");
            String description_matiere = scanner.nextLine();
            System.out.println("Merci de saisir la durée de la matiere : ");
            int duree = scanner.nextInt();
            System.out.println("Merci de saisir le coefficient de la matiere: ");
            int coeff_matiere = scanner.nextInt();
            scanner.nextLine();

            Matiere matiere = new Matiere(intitule_matiere,description_matiere,duree,coeff_matiere);

            if(matiereService.create(matiere)) {
                System.out.println("Matiere ajoutée");
            }else {
                System.out.println("Erreur ajout");}
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void creerNote(){
        try {
            System.out.println("Merci de saisir l'id de la matiere': ");
            Long id_matiere = scanner.nextLong();
            System.out.println("Merci de saisir l'id de l'etudiant': ");
            Long id_etudiant = scanner.nextLong();

            int min = 0;
            int max = 20;
            boolean value = true;
            Double value_note = null;
            do {
                System.out.println("Merci de saisir la valeur de la note (entre 0 et 20): ");
                value_note = scanner.nextDouble();
                if (value_note >= min && value_note <= max) {
                    value = false;
                } else {
                    System.out.println("Saisissez une note entre 0 et 20 !");
                }
            }while (value);
            scanner.nextLine();
            System.out.println("Merci de saisir un commentaire de la note : ");
            String commentaire_note = scanner.nextLine();

            Matiere matiere = this.matiereService.findById(id_matiere);
            Etudiant etudiant = this.etudiantService.findById(id_etudiant);

            Note note = new Note(matiere,etudiant,value_note,commentaire_note);

            if(noteService.create(note)) {
                System.out.println("Note ajoutée");
            }else {
                System.out.println("Erreur ajout");}
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void creerClasse(){
        try {
            System.out.println("Merci de saisir le nom de la classe': ");
            String nom_classe = scanner.nextLine();
            System.out.println("Merci de saisir le niveau de la classe: ");
            String niveau_classe = scanner.nextLine();
            System.out.println("Merci de saisir l'id du departement relié a la classe': ");
            Long id_departement = scanner.nextLong();
            scanner.nextLine();

            Departement departement = this.departementService.findById(id_departement);

            Classe classe = new Classe(nom_classe,niveau_classe,departement);

            if(classeService.create(classe)) {
                System.out.println("Classe ajoutée");
            }else {
                System.out.println("Erreur ajout");}
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void creerEmploiDuTemps() {
        try {
            System.out.println("Merci de saisir l'id de l'etudiant : ");
            Long id_etudiant = scanner.nextLong();
            scanner.nextLine();
            System.out.println("Merci de saisir le jour et l'heure:(yyyy-MM-dd HH:mm) ");
            String userInput = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime localDateTime = null;
            try {
                localDateTime = LocalDateTime.parse(userInput, formatter);
            } catch (Exception e) {
                System.out.println("Format invalide. Assurez-vous de respecter le format yyyy-MM-dd HH:mm.");
            }
            Etudiant etudiant = this.etudiantService.findById(id_etudiant);

            Emplois_du_temps emploisDuTemps = new Emplois_du_temps(localDateTime, etudiant);

            if(emploisDuTempsService.create(emploisDuTemps)) {
                System.out.println("Emploi du temps ajouté");
            }else {
                System.out.println("Erreur ajout");}
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private void afficherListeClassesSansEleves(){
        List<Classe>classeList = classeService.findAll();
        for (Classe c: classeList
             ) {
            System.out.println("la classe est : " + c.toString());
        }
        }

    private void afficherNombreMatiereEleve(){
        try {
            System.out.println("Merci de saisir l'id de l'étudiant : ");
            Long etudiant_id = scanner.nextLong();
            scanner.nextLine();
            Etudiant etudiant = this.etudiantService.findById(etudiant_id);

            List<Matiere> matiereList = null;
            System.out.println("L'étudiant "+ etudiant.getNom_etudiant() + " suit " +  matiereList.size() + " matiere(s).");
            
        }
        catch(Exception ex) {
            System.out.println("erreur calcule moyenne");
        }
    }

    private void afficherListeNoteEleveAvecDetails(){
        try {
            System.out.println("Merci de saisir l'id de l'étudiant : ");
            Long etudiant_id = scanner.nextLong();
            scanner.nextLine();
            Etudiant etudiant = this.etudiantService.findById(etudiant_id);

            List<Note> noteList = noteService.findAll1(etudiant_id);
            for (Note note: noteList) {
                System.out.println(note.toString());
            }
        }
        catch(Exception ex) {
            System.out.println("erreur calcule moyenne");
        }
    }

    private void afficherMoyenneEleve(){
        try {
        System.out.println("Merci de saisir l'id de l'étudiant : ");
        Long etudiant_id = scanner.nextLong();
        scanner.nextLine();

            System.out.println("La moyenne générale de l'étudiant est :" + noteService.moyenne(etudiant_id) + " /20 ");
        }
        catch(Exception ex) {
            System.out.println("erreur calcule moyenne");
        }

    }

    private void afficherNombreEleveDepartement(){
        try{
            System.out.println("Merci de saisir l'id du département :");
            Long id_departement = scanner.nextLong();
            scanner.nextLine();

            Departement departement= this.departementService.findById(id_departement);
            int nombre_eleve = departementService.afficherNombreEleveDepartement(id_departement);

            System.out.println("Il y a " + nombre_eleve + " élève(s) dans le département " + departement.getNom_departement() );

        }catch(Exception ex) {
            ex.printStackTrace();
            System.out.println("erreur calcul");
        }

    }

    private void afficherNomElevesNiveau(){
        try{
            System.out.println("Merci de saisir le nom du niveau :");
            String niveau = scanner.nextLine();

            System.out.println("Ci dessous les noms des élèves dont le niveau est : " + niveau );
            List<Etudiant> etudiantList = classeService.findAllStudientsByLevel(niveau);

            for (Etudiant etudiant: etudiantList
                 ) {
                System.out.println("Le nom de l'élève : " + etudiant.getId() + " est : " + etudiant.getNom_etudiant());
            }
        }catch(Exception ex) {
        System.out.println("erreur calcule moyenne");
    }


    }

    private void supprimerEleve(){
        System.out.println("Merci de saisir l'id de l'étudiant à supprimer: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        Etudiant etudiant = etudiantService.findById(id);
        etudiantService.delete(etudiant);
    }

    private void suppressionClasse(){}

    private void suppressionDepartement(){}



}
