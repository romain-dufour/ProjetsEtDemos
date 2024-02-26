package com.example.tp_hopital.services;

import com.example.tp_hopital.entities.Consultation;
import com.example.tp_hopital.entities.Patient;
import com.example.tp_hopital.interfaces.Repository;
import org.hibernate.query.Query;

import java.util.List;

public class ConsultationService extends com.example.correctionproduit.services.BaseService implements Repository<Consultation> {
    @Override
    public boolean create(Consultation o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(o);
        session.getTransaction().commit();
        session.close();
        return true;    }

    @Override
    public boolean update(Consultation o) {
        return false;
    }

    @Override
    public boolean delete(Consultation o) {
        return false;
    }

    @Override
    public Consultation findById(Long id) {
        Consultation consultation = null;
        session = sessionFactory.openSession();
        consultation = (Consultation) session.get(Consultation.class, id);
        session.close();
        return consultation;    }

    @Override
    public List<Consultation> findAll() {
        List<Consultation> consultationList = null;
        session = sessionFactory.openSession();
        Query<Consultation> consultationQuery = session.createQuery("from Consultation");
        consultationList = consultationQuery.list();
        session.close();
        return consultationList;
    }


    public List<Consultation> findByPatientId(Long id){
        List<Consultation> consultationList = null;
        session = sessionFactory.openSession();
        Query<Consultation> consultationQuery = session.createQuery("from Consultation where id = :patient_id");
        consultationQuery.setParameter("patient_id", id);
        consultationList = consultationQuery.list();
        session.close();

        return consultationList;
    }
}
