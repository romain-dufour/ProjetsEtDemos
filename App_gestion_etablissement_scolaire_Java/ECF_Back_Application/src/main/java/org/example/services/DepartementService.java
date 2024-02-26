package org.example.services;

import org.example.entity.Classe;
import org.example.entity.Departement;
import org.example.entity.Etudiant;
import org.example.interfaces.Repository;

import java.util.List;

public class DepartementService extends BaseService implements Repository<Departement> {

    public DepartementService(){super();}

    @Override
    public boolean create(Departement o) {
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Departement o) {
        return false;
    }

    @Override
    public boolean delete(Departement o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Departement findById(Long id) {
        Departement departement   = null;
        session = sessionFactory.openSession();
        departement = (Departement) session.get(Departement.class, id);
        session.close();
        return departement;
    }

    @Override
    public List<Departement> findAll() {
        return null;
    }

    public List<Classe>getClassList(){
        List<Classe>classeList = null;
        return classeList;
    }

    public void begin(){
        session = sessionFactory.openSession();
    }


    public void end(){

        //  session.close();
        sessionFactory.close();
    }


    public int afficherNombreEleveDepartement(Long id) {
        try {
            Long id_departement = id;

            session = sessionFactory.openSession();
            session.beginTransaction();

            Departement departement = session.get(Departement.class, id_departement);
            List<Classe> classeList = departement.getClasseList();

            int nombre_eleve = 0;

            for (Classe classe : classeList) {
                // Force le chargement de la collection EtudiantList
                classe.getEtudiantList().size();
                nombre_eleve += classe.getEtudiantList().size();
            }

            session.getTransaction().commit();
            return nombre_eleve;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

}
