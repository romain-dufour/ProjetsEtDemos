package org.example.services;

import org.example.entity.Classe;
import org.example.entity.Etudiant;
import org.example.interfaces.Repository;
import org.hibernate.query.Query;

import java.util.List;

public class ClasseService extends BaseService implements Repository<Classe> {
    public ClasseService(){super();}

    @Override
    public boolean create(Classe o) {
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Classe o) {
        return false;
    }

    @Override
    public boolean delete(Classe o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Classe findById(Long id) {
        Classe classe = null;
        session = sessionFactory.openSession();
        classe = (Classe) session.get(Classe.class, id);
        session.close();
        return classe;
    }

    @Override
    public List<Classe> findAll() {
        List<Classe> classeList = null;
        session = sessionFactory.openSession();
        Query<Classe> classeQuery = session.createQuery("from Classe ");
        classeList = classeQuery.list();
        session.close();
        return classeList;
    }

    public List<Etudiant> findAllStudientsByLevel(String level){
        List<Etudiant> etudiantList = null;
        session = sessionFactory.openSession();
        Query<Etudiant> classeQuery = session.createQuery("select etudiantList from Classe where Niveau_classe = :niveau ");
        classeQuery.setParameter("niveau" , level);
        etudiantList = classeQuery.list();
        session.close();
        return etudiantList;
    }
}
