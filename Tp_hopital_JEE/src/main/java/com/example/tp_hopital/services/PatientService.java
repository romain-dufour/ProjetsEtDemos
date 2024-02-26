package com.example.tp_hopital.services;

import com.example.tp_hopital.entities.Patient;
import com.example.tp_hopital.interfaces.Repository;
import org.hibernate.query.Query;

import java.util.List;

public class PatientService extends com.example.correctionproduit.services.BaseService implements Repository<Patient> {
    @Override
    public boolean create(Patient o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Patient o) {
        return false;
    }

    @Override
    public boolean delete(Patient o) {
        return false;
    }

    @Override
    public Patient findById(Long id) {
        Patient patient = null;
        session = sessionFactory.openSession();
        patient = (Patient) session.get(Patient.class, id);
        session.close();
        return patient;
    }

    @Override
    public List<Patient> findAll() {
        List<Patient> patientList = null;
        session = sessionFactory.openSession();
        Query<Patient> patientQuery = session.createQuery("from Patient");
        patientList = patientQuery.list();
        session.close();
        return patientList;
    }


    public List<Patient> filterByLastName(String lastName) throws Exception {
        List<Patient> patientList = null;
        session = sessionFactory.openSession();

        if (lastName == null){
            Query<Patient> patientQuery = session.createQuery("from Patient");
            patientList = patientQuery.list();
            session.close();
            return patientList;
        }else {
            Query<Patient> patientQuery = session.createQuery("from Patient where lastName = :lastName");
            patientQuery.setParameter("lastName", lastName);
            patientList = patientQuery.list();
        }

        session.getTransaction().commit();
        session.close();

        return patientList;
    }
}
