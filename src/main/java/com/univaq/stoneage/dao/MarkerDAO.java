package com.univaq.stoneage.dao;

import com.univaq.stoneage.hibernate.HibernateUtil2;
import com.univaq.stoneage.model.MMarker;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;

public class MarkerDAO extends GenericHibernateDAO<MMarker> {
    public MarkerDAO() {
        super();
        this.setClazz(MMarker.class);
    }

    public ArrayList<String> getAllMarkersName() {
        ArrayList<String> markersName = new ArrayList<>();
        Transaction transaction = null;
        try (Session session = HibernateUtil2.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
            Root<MMarker> root = criteriaQuery.from(MMarker.class);
            criteriaQuery.select(root.get("m_markerName"));
            Query<String> q = session.createQuery(criteriaQuery);
            markersName = (ArrayList<String>) q.getResultList();
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return markersName;
    }
}




