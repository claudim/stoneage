package com.univaq.stoneage.dao;

import com.univaq.stoneage.model.MSquare;

//public class SquareDAO  extends GenericHibernateDAO< MSquare> {
//    public SquareDAO() {
//        super();
//        setClazz(MSquare.class);
//    }
//
//}

public class SquareDAO extends GenericHibernateDAO<MSquare> {

    public SquareDAO() {
        super();
        this.setClazz(MSquare.class);
    }

//    public List<MSquare> findAll() {
//
//        List<MSquare> squares = new ArrayList<>();
//        Transaction transaction = null;
//        try (Session session = HibernateUtil2.getSessionFactory().openSession()) {
//            // start a transaction
//            transaction = session.beginTransaction();
//            squares = session.createQuery("from MSquare ", MSquare.class).list();
//            // commit transaction
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        }
//        return squares;
//    }
}