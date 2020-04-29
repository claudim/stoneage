package com.univaq.stoneage.dao;

import com.univaq.stoneage.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class GenericHibernateDAO<T extends Serializable> implements IGenericDAO<T> {

    private Class<T> clazz;

    public void setClazz(Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    public ArrayList<T> findAll() {
        ArrayList<T> list = new ArrayList<>();
//        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
//            transaction = session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
            Root<T> root = criteriaQuery.from(clazz);
            criteriaQuery.select(root);
            Query<T> q = session.createQuery(criteriaQuery);
            list = (ArrayList<T>) q.getResultList();

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

    //
//    public T findOne(long id) {
//        return getCurrentSession().get(clazz, id);
//    }
//
}