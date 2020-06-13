package com.univaq.stoneage.persistence;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This interface as the Data Access Object (DAO) pattern allows us to isolate the application/business layer from the persistence layer (usually a relational database, but it could be any other persistence mechanism) using an abstract API.
 * The functionality of this API is to hide from the application all the complexities involved in performing CRUD operations in the underlying storage mechanism. This permits both layers to evolve separately without knowing anything about each other.
 * The most relevant facet of this process is how PSquare hides from the application all the low-level details on how the objects are persisted, updated, and deleted.
 * <p>
 * IPersistentGeneric interface defines an abstract API that performs CRUD operations on objects of type T.
 */
public interface IPersistentGeneric<T extends Serializable> {
//    T findOne(final long id);

    /**
     * Select all tuples of the parametric object present in memory
     *
     * @return list of objects of the requested type
     */
    ArrayList<T> findAll();

    //  ArrayList<T> findAllId();

//    T create(final T entity);
//
//    T update(final T entity);
//
//    void delete(final T entity);
//
//    void deleteById(final long entityId);
}