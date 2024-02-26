package org.example.services;

import org.example.entity.Etudiant;
import org.example.entity.Matiere;
import org.example.interfaces.Repository;

import java.util.List;

public class MatiereService extends BaseService implements Repository<Matiere> {

    public MatiereService(){super();}
    @Override
    public boolean create(Matiere o) {
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Matiere o) {
        return false;
    }

    @Override
    public boolean delete(Matiere o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Matiere findById(Long id) {
        Matiere matiere  = null;
        session = sessionFactory.openSession();
        matiere = (Matiere) session.get(Matiere.class, id);
        session.close();
        return matiere;
    }

    @Override
    public List<Matiere> findAll() {
        return null;
    }
}
