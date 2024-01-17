package tsi.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import tsi.models.Evenement;

public class EvenementService {
    private final SessionFactory sessionFactory;

    public EvenementService (SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    public void insert(Evenement evenement){
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.persist(evenement);
        session.getTransaction().commit();
        session.close();
    }
}
