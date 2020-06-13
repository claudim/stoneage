package com.univaq.stoneage.persistence;

import com.univaq.stoneage.model.forestTokens.MTokenForest;
import com.univaq.stoneage.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;

/**
 * Class that handle persistence for Forest Token objects in green mode
 */
public class PGreenTokenForest extends PTokenForest {

    /**
     * Select all tuples of Forest Token needed in green mode present in memory
     *
     * @return list of Forest Tokens objects for the green mode
     */
    public ArrayList<MTokenForest> findAll() {
        ArrayList<MTokenForest> list = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<MTokenForest> criteriaQuery = criteriaBuilder.createQuery(MTokenForest.class);
            Root<MTokenForest> root = criteriaQuery.from(MTokenForest.class);
            criteriaQuery.select(root).where(criteriaBuilder.or(criteriaBuilder.equal(root.get("m_mode"), "verde"), criteriaBuilder.isNull(root.get("m_mode"))));
            Query<MTokenForest> q = session.createQuery(criteriaQuery);
            list = (ArrayList<MTokenForest>) q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
