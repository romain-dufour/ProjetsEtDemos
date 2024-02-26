package com.example.tp_hopital.services;

import com.example.tp_hopital.entities.Consultation;
import com.example.tp_hopital.entities.FicheDeSoin;
import com.example.tp_hopital.entities.Prescription;
import com.example.tp_hopital.interfaces.Repository;
import org.hibernate.query.Query;

import java.util.List;

public class FicheDeSoinService extends com.example.correctionproduit.services.BaseService implements Repository<FicheDeSoin> {
    @Override
    public boolean create(FicheDeSoin o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(FicheDeSoin o) {
        return false;
    }

    @Override
    public boolean delete(FicheDeSoin o) {
        return false;
    }

    @Override
    public FicheDeSoin findById(Long id) {
        FicheDeSoin ficheDeSoin = null;
        session = sessionFactory.openSession();
        ficheDeSoin = (FicheDeSoin) session.get(FicheDeSoin.class, id);
        session.close();
        return ficheDeSoin;
    }

    @Override
    public List<FicheDeSoin> findAll() {
        return null;
    }

    public List<FicheDeSoin> findByConsultationId(Long id){
        List<FicheDeSoin> ficheDeSoinList = null;
        session = sessionFactory.openSession();
        Query<FicheDeSoin> ficheDeSoinQuery = session.createQuery("from FicheDeSoin where id = :consultation_id");
        ficheDeSoinQuery.setParameter("consultation_id", id);
        ficheDeSoinList = ficheDeSoinQuery.list();
        session.close();

        return ficheDeSoinList;
    }
}
