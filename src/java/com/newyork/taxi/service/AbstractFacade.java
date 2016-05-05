/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newyork.taxi.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.*;

public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();
    
    public List<T> findByTimeRange(Date from, Date to) {
        CriteriaQuery criteriaQuery = getEntityManager().getCriteriaBuilder().createQuery();
        Root<T> root = criteriaQuery.from(entityClass);
        
        getEntityManager().find(entityClass, 1);
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        
        criteriaQuery.select(root).where(
            criteriaBuilder.between(root.get("lpepPickupDatetime").as(Timestamp.class), from, to)
        );
        
        Query q = getEntityManager().createQuery(criteriaQuery);
        
        return q.getResultList();
    }
}
