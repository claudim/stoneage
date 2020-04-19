package com.univaq.stoneage.dao;

import com.univaq.stoneage.hibernate.HibernateUtil2;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class GenericHibernateDAO<T extends Serializable> implements IGenericDAO<T> {

    private Class<T> clazz;

    public void setClazz(Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }
//
//    public T findOne(long id) {
//        return getCurrentSession().get(clazz, id);
//    }
//

    public ArrayList<T> findAll() {
        ArrayList<T> list = new ArrayList<>();
        Transaction transaction = null;
        try (Session session = HibernateUtil2.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            list = (ArrayList<T>) session.createQuery("from " + clazz.getName(), this.clazz).list();
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return list;
    }

//    public void create(T entity) {
//        getCurrentSession().saveOrUpdate(entity);
//    }

//    public T create(T entity) {
//        getCurrentSession().saveOrUpdate(entity);
//        return entity;
//    }

//    public T update(T entity) {
//        return (T) getCurrentSession().merge(entity);
//    }
//
//    public void delete(T entity) {
//        getCurrentSession().delete(entity);
//    }
//
//    public void deleteById(int entityId) {
//        T entity = findOne(entityId);
//        delete(entity);
//    }
}