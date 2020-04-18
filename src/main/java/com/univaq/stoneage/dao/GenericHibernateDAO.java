package com.univaq.stoneage.dao;

import com.univaq.stoneage.hibernate.HibernateUtil;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

public abstract class GenericHibernateDAO<T extends Serializable> implements IGenericDAO<T> {

    protected HibernateUtil sessionFactory;
    private Class<T> clazz;

    protected Session getCurrentSession() {
        return HibernateUtil.getCurrentSession();
    }

    public void setClazz(Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    public T findOne(long id) {
        return getCurrentSession().get(clazz, id);
    }

    public List findAll() {
        Session s = getCurrentSession();
        s.beginTransaction();
        List list = s.createQuery("from " + clazz.getName()).list();
        s.getTransaction().commit();
        s.close();
        return list;
    }

    public void create(T entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

//    public T create(T entity) {
//        getCurrentSession().saveOrUpdate(entity);
//        return entity;
//    }

    public T update(T entity) {
        return (T) getCurrentSession().merge(entity);
    }

    public void delete(T entity) {
        getCurrentSession().delete(entity);
    }

    public void deleteById(int entityId) {
        T entity = findOne(entityId);
        delete(entity);
    }
}