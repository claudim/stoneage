package com.univaq.stoneage.dao;

import com.univaq.stoneage.model.squares.MSquare;
import com.univaq.stoneage.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;

public class RedSquareDAO extends SquareDAO {

    public ArrayList<MSquare> findAll() {
        ArrayList<MSquare> list = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<MSquare> criteriaQuery = criteriaBuilder.createQuery(MSquare.class);
            Root<MSquare> root = criteriaQuery.from(MSquare.class);
            criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("m_mode"), "rossa"));
            Query<MSquare> q = session.createQuery(criteriaQuery);
            list = (ArrayList<MSquare>) q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
