package org.vvchebotar.crud.dao;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Primary
@Transactional(readOnly = true)
public class GenericDaoImp<T, PK extends Serializable> implements GenericDao<T, PK> {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(readOnly = false)
    @Override
    public PK create(T o) {
        System.out.println("object saved");
        return (PK) sessionFactory.openSession().save(o);
    }

    @Override
    public T read(Class<T> clazz, PK id) {
        System.out.println("object got");
        return (T) sessionFactory.openSession().get(clazz, id);
    }

    @Transactional(readOnly = false)
    @Override
    public void update(T o) {
        sessionFactory.openSession().update(o);
    }

    @Transactional(readOnly = false)
    @Override
    public void delete(T o) {
        sessionFactory.openSession().delete(o);
    }
}

