package com.example.tp_hopital.services;

import com.example.tp_hopital.entities.Consultation;
import com.example.tp_hopital.entities.Patient;
import com.example.tp_hopital.entities.Prescription;
import com.example.tp_hopital.interfaces.Repository;
import org.hibernate.query.Query;

import java.util.List;

public class PrescriptionService extends com.example.correctionproduit.services.BaseService implements Repository<Prescription> {
    @Override
    public boolean create(Prescription o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Prescription o) {
        return false;
    }

    @Override
    public boolean delete(Prescription o) {
        return false;
    }

    @Override
    public Prescription findById(Long id) {
        Prescription prescription = null;
        session = sessionFactory.openSession();
        prescription = (Prescription) session.get(Prescription.class, id);
        session.close();
        return prescription;    }

    @Override
    public List<Prescription> findAll() {
        return null;
    }

    public List<Consultation> findByPatientId(Long id){
        List<Consultation> consultationList = null;
        session = sessionFactory.openSession();
        Query<Consultation> consultationQuery = session.createQuery("from Consultation where id = :consultation_id");
        consultationQuery.setParameter("consultation_id", id);
        consultationList = consultationQuery.list();
        session.close();

        return consultationList;
    }

}
