package com.univaq.stoneage.dao;

import com.univaq.stoneage.model.squares.MSquare;
import com.univaq.stoneage.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;

public class SquareDAO extends GenericHibernateDAO<MSquare> {

    public SquareDAO() {
        super();
        this.setClazz(MSquare.class);
    }

    public ArrayList<MSquare> findAll() {
        ArrayList<MSquare> list = new ArrayList<>();
//        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
//            transaction = session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<MSquare> criteriaQuery = criteriaBuilder.createQuery(MSquare.class);
            Root<MSquare> root = criteriaQuery.from(MSquare.class);
            criteriaQuery.select(root);
//                    where(criteriaBuilder.equal(root.get("square_type"), "resourcesquare"));

            //   Root<MResourceSquare> resourceSquareRoot = criteriaBuilder.treat(root, MResourceSquare.class);
            // Root<MBuildingSite> buildingSiteRoot = criteriaBuilder.treat(root, MBuildingSite.class);
            //criteriaQuery.select(root);
            Query<MSquare> q = session.createQuery(criteriaQuery);
            list = (ArrayList<MSquare>) q.getResultList();

            // list = (ArrayList<T>) session.createQuery("from " + clazz.getName(), this.clazz).list();
            // commit transaction
//            transaction.commit();
        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
            e.printStackTrace();
        }
        return list;
    }
}