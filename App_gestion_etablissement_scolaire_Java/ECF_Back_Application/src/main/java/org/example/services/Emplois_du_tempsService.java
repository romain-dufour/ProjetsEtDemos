package org.example.services;

import org.example.entity.Classe;
import org.example.entity.Departement;
import org.example.entity.Emplois_du_temps;
import org.example.interfaces.Repository;

import java.util.List;

public class Emplois_du_tempsService extends BaseService implements Repository<Emplois_du_temps> {
    public Emplois_du_tempsService(){super();}

    @Override
    public boolean create(Emplois_du_temps o) {
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Emplois_du_temps o) {
        return false;
    }

    @Override
    public boolean delete(Emplois_du_temps o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Emplois_du_temps findById(Long id) {
        Emplois_du_temps emploisDuTemps = null;
        session = sessionFactory.openSession();
        emploisDuTemps = (Emplois_du_temps) session.get(Emplois_du_temps.class, id);
        session.close();
        return emploisDuTemps;       }

    @Override
    public List<Emplois_du_temps> findAll() {
        return null;
    }
}
