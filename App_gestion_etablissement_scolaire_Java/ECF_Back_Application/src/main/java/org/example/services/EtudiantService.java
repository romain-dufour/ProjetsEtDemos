package org.example.services;

import org.example.entity.Etudiant;
import org.example.entity.Matiere;
import org.example.entity.Note;
import org.example.interfaces.Repository;

import javax.management.Query;
import java.util.List;

public class EtudiantService extends BaseService implements Repository<Etudiant> {

    public EtudiantService(){super();}

    @Override
    public boolean create(Etudiant o) {
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Etudiant o) {
        return false;
    }

    @Override
    public boolean delete(Etudiant o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Etudiant findById(Long id) {
        Etudiant etudiant  = null;
        session = sessionFactory.openSession();
        etudiant = (Etudiant) session.get(Etudiant.class, id);
        session.close();
        return etudiant;
    }

    @Override
    public List<Etudiant> findAll() {
        return null;
    }
/*



    public List<Matiere> getNombreMatieresParEtudiant(Long etudiant_id){
        List<Matiere> matiereList = null;
        session = sessionFactory.openSession();
        org.hibernate.query.Query<Matiere> matiereQuery = session.createQuery("select count(matiere_id) from Etudiant where etudiant.id = :etudiantId")
    }
 */
    public List<Note> findAll1(Long etudiant_id) {
        List<Note> noteList = null;
        session = sessionFactory.openSession();
        org.hibernate.query.Query<Note> noteQuery = session.createQuery("from Note where etudiant.id = :etudiantId", Note.class);
        noteQuery.setParameter("etudiantId", etudiant_id);

        noteList = noteQuery.list();
        session.close();
        return noteList;    }
}
