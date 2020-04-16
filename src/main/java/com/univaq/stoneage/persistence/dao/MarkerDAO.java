package com.univaq.stoneage.persistence.dao;

import com.univaq.stoneage.Model.MMarker;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

public class MarkerDAO implements IMarkerDAO {

    HibernateTemplate template;

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addMarker(MMarker marker) {
        this.sessionFactory.getCurrentSession().save(marker);
    }

    @Override
    public List<MMarker> getAllMarkers() {
        return this.sessionFactory.getCurrentSession().createQuery("from MMarker ").list();
    }

    @Override
    public void deleteMarker(String markerName) {
        MMarker marker = sessionFactory.getCurrentSession().load(
                MMarker.class, markerName);
        if (null != marker) {
            this.sessionFactory.getCurrentSession().delete(marker);
        }

    }
}
