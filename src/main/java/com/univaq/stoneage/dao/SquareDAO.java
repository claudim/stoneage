package com.univaq.stoneage.dao;

import com.univaq.stoneage.model.squares.MSquare;
import com.univaq.stoneage.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;

/**
 * Class that handle persistence for Square objects
 */
public class SquareDAO extends GenericHibernateDAO<MSquare> {

    /**
     * Constructor
     */
    public SquareDAO() {
        super();
        this.setClazz(MSquare.class);
    }

    /**
     * Select all tuples of MSquare present in memory
     *
     * @return list of MSquare objects
     */
    public ArrayList<MSquare> findAll() {
        ArrayList<MSquare> list = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<MSquare> criteriaQuery = criteriaBuilder.createQuery(MSquare.class);
            Root<MSquare> root = criteriaQuery.from(MSquare.class);
            criteriaQuery.select(root);
            Query<MSquare> q = session.createQuery(criteriaQuery);
            list = (ArrayList<MSquare>) q.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}