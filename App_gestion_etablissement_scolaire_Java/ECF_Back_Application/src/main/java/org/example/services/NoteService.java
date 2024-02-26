package org.example.services;

import org.example.entity.Enseignant;
import org.example.entity.Note;
import org.example.interfaces.Repository;
import org.hibernate.query.Query;

import java.util.List;

public class NoteService extends BaseService implements Repository<Note> {
    public NoteService(){super();}


    @Override
    public boolean create(Note o) {
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Note o) {
        return false;
    }

    @Override
    public boolean delete(Note o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Note findById(Long id) {
        Note note = null;
        session = sessionFactory.openSession();
        note = (Note) session.get(Note.class, id);
        session.close();
        return note;    }

    @Override
    public List<Note> findAll() {
        return null;
    }

    public List<Note> findAll1(Long etudiant_id) {
        List<Note> noteList = null;
        session = sessionFactory.openSession();
        Query<Note> noteQuery = session.createQuery("from Note where etudiant.id = :etudiantId", Note.class);
        noteQuery.setParameter("etudiantId", etudiant_id);

        noteList = noteQuery.list();
        session.close();
        return noteList;    }



    public double moyenne(Long etudiant_id) {
        session = sessionFactory.openSession();
        session.beginTransaction();

        Query<Double> query = session.createQuery("select avg(n.Valeur_note) from Note n where n.etudiant.id = :etudiantId", Double.class);
        query.setParameter("etudiantId", etudiant_id);

        Double moyenne = query.uniqueResult();

        session.getTransaction().commit();
        session.close();

        return moyenne != null ? moyenne : 0.0;
    }


}
