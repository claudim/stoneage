package com.univaq.stoneage.persistence;

import com.univaq.stoneage.model.squares.MSquare;
import com.univaq.stoneage.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;

/**
 * Class that handle persistence for Square objects in green mode
 */
public class PGreenSquare extends PSquare {

    /**
     * Select all tuples of MSquare needed in green mode game present in memory
     *
     * @return list of MSquare objects for the green mode
     */
    public ArrayList<MSquare> findAll() {
        ArrayList<MSquare> list = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<MSquare> criteriaQuery = criteriaBuilder.createQuery(MSquare.class);
            Root<MSquare> root = criteriaQuery.from(MSquare.class);
            criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("m_mode"), "verde"));
            Query<MSquare> q = session.createQuery(criteriaQuery);
            list = (ArrayList<MSquare>) q.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
