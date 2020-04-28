package com.univaq.stoneage.dao;

import com.univaq.stoneage.model.forestTokens.MTokenForest;

public class TokenForestDAO extends GenericHibernateDAO<MTokenForest> {
    public TokenForestDAO() {
        super();
        setClazz(MTokenForest.class);
    }

//    @Override
//    public ArrayList<MTokenForest> findAll() {
//        ArrayList<MTokenForest> tokenForests = new ArrayList<>();
//        Transaction transaction = null;
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            // start a transaction
//            transaction = session.beginTransaction();
//            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//
//
////            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
////            CriteriaQuery<MDieFaceTokenForest> criteria = criteriaBuilder.createQuery(MDieFaceTokenForest.class);
////
////            Root<MDieFaceTokenForest> root = criteria.from(MDieFaceTokenForest.class);
////
////            criteria.where(criteriaBuilder.equal(root.get("m_dieFace"), null));
////            Query<MDieFaceTokenForest> q = session.createQuery(criteria);
////
////            List<MDieFaceTokenForest> list = q.getResultList();
////            tokenForests = (ArrayList<MDieFaceTokenForest>) list;
//
//
////            CriteriaQuery<MTokenForest> criteria = criteriaBuilder.createQuery( MTokenForest.class );
////            Root<MTokenForest> root = criteria.from( MTokenForest.class );
////            criteriaBuilder.treat( root, MDieFaceTokenForest.class );
////            //criteriaBuilder.treat( root, MDieFaceTokenForest.class ).fetch( "subField" );
////            CriteriaQuery<MTokenForest> all = criteria.select(root.get("die_value"));
////            Query<MTokenForest> q = session.createQuery(all);
////            ArrayList<MTokenForest> t = (ArrayList<MTokenForest>) q.getResultList();
//
//
//            CriteriaQuery<MTokenForest> criteriaQuery = criteriaBuilder.createQuery(MTokenForest.class);
//            Root<MTokenForest> root = criteriaQuery.from(MTokenForest.class);
//            Root<MDieFaceTokenForest> root2 = criteriaBuilder.treat(root, MDieFaceTokenForest.class);
//            Root<MSquareTokenForest> root3 = criteriaBuilder.treat(root, MSquareTokenForest.class);
//
//
//            criteriaQuery.multiselect(root.get("token_id"), root.get("m_state"), root.get("m_position"),
//                    root2.get("m_dieFace"), root3.get("m_squareName"));
//            //criteriaQuery.select(root);
//            Query<MTokenForest> q = session.createQuery(criteriaQuery);
//            tokenForests = (ArrayList<MTokenForest>) q.getResultList();
//
//
////
////            CriteriaQuery<MDieFaceTokenForest> criteriaQuery = criteriaBuilder.createQuery(MDieFaceTokenForest.class);
////            Root<MDieFaceTokenForest> root = criteriaQuery.from(MDieFaceTokenForest.class);
////          //  criteriaQuery.multiselect(root.get("id"), root.get("state"), root.get("position"), root.get("die_value"));
////            criteriaQuery.select(root.get("die_value"));
//////
//////            //criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("type", "diefacetokenforest"));
////            CriteriaQuery<MDieFaceTokenForest> all = criteriaQuery.select(root);
////            Query<MDieFaceTokenForest> q = session.createQuery(all);
////            tokenForests = (ArrayList<MDieFaceTokenForest>) q.getResultList();
////            tokenForests  = (ArrayList<MDieFaceTokenForest>) session.createNativeQuery("SELECT * FROM diefacetokenforest").list();
//
//
//            // commit transaction
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        }
//        return tokenForests;
//    }


}


