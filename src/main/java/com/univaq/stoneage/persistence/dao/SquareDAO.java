package com.univaq.stoneage.persistence.dao;

import com.univaq.stoneage.Model.MSquare;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SquareDAO implements ISquareDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addSquare(MSquare square) {
        this.sessionFactory.getCurrentSession().save(square);
    }

    @Override
    public List<MSquare> getAllSquares() {
        return this.sessionFactory.getCurrentSession().createQuery("from MSquare ").list();
    }

    @Override
    public void deleteSquare(String squareName) {
        MSquare square = sessionFactory.getCurrentSession().load(
                MSquare.class, squareName);
        if (null != square) {
            this.sessionFactory.getCurrentSession().delete(square);
        }

    }
}
