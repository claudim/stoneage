package com.univaq.stoneage.persistence;

import com.univaq.stoneage.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Abstract generic class defining parametric crud operations. All other persistent classes extend this
 *
 * @param <T> the type of the object over execute operations
 */
public abstract class PGenericHibernate<T extends Serializable> implements IPersistentGeneric<T> {

    /* Specific class on which execute operations */
    private Class<T> clazz;

    /**
     * Setter for the class
     *
     * @param clazzToSet class to set
     */
    public void setClazz(Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    /**
     * Select all tuples of the parametric object present in memory
     *
     * @return list of objects of the requested type
     */
    public ArrayList<T> findAll() {
        ArrayList<T> list = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
            Root<T> root = criteriaQuery.from(clazz);
            criteriaQuery.select(root);
            Query<T> q = session.createQuery(criteriaQuery);
            list = (ArrayList<T>) q.getResultList();

        } catch (Exception e) {
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