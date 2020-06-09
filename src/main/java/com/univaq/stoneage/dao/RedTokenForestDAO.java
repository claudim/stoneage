package com.univaq.stoneage.dao;

import com.univaq.stoneage.model.forestTokens.MTokenForest;
import com.univaq.stoneage.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;

public class RedTokenForestDAO extends TokenForestDAO {
    public ArrayList<MTokenForest> findAll() {
        ArrayList<MTokenForest> list = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<MTokenForest> criteriaQuery = criteriaBuilder.createQuery(MTokenForest.class);
            Root<MTokenForest> root = criteriaQuery.from(MTokenForest.class);
            criteriaQuery.select(root).where(criteriaBuilder.or(criteriaBuilder.equal(root.get("m_mode"), "rossa"), criteriaBuilder.isNull(root.get("m_mode"))));
            Query<MTokenForest> q = session.createQuery(criteriaQuery);
            list = (ArrayList<MTokenForest>) q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
