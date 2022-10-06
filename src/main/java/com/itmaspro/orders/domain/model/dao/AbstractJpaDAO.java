package com.itmaspro.orders.domain.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractJpaDAO< T extends Serializable> {

    private Class< T > clazz;

    @PersistenceContext
    EntityManager entityManager;

    public  void setClazz( Class< T > clazzToSet ){
        this.clazz = clazzToSet;
    }

    public T findOne( String id ){
        return entityManager.find( clazz, id );
    }
    public List< T > findAll(){
        return entityManager.createQuery( "from " + clazz.getName() )
                .getResultList();
    }
@SuppressWarnings( "unchecked" )
    public List<T> findAll(Integer limit, Integer offset, String namedQuery){
        TypedQuery<T> query = entityManager
                .createNamedQuery(namedQuery, clazz);

        if (limit != null && limit > 0) {

            query = query.setMaxResults(limit);
        }

        if (offset != null && offset > 0) {

            query = query.setFirstResult(offset);
        }

        List<T> customerEntities = query.getResultList();
        return customerEntities;
    }

    public void create( T entity ){
        entityManager.persist( entity );
    }

    public T update( T entity ){
        return entityManager.merge( entity );
    }

    public void delete( T entity ){
        entityManager.remove( entity );
    }
    public void deleteById( String entityId ){
        T entity = findOne( entityId );
        delete( entity );
    }
}