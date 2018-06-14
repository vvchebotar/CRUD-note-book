package org.vvchebotar.crud.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.*;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.internal.CriteriaBuilderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.vvchebotar.crud.domain.Book;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

@Repository
@Primary
@Transactional(readOnly = true)
public class BookDaoImp implements BookDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(readOnly = false)
    @Override
    public Long create(Book b) {
        return (Long) sessionFactory.openSession().save(b);
    }

    @Override
    public Book read(Class<Book> clazz, Long id) {
        return (Book) sessionFactory.openSession().get(clazz, id);
    }

    @Override
    public void refreshBook(Book book) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.refresh(book);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            Transaction tx = session.getTransaction();
            if (tx.isActive()) {tx.rollback();}
        } finally {
            session.close();
        }
    }

    @Override
    public List<Book> readAll() {
       // String hql = "FROM Book";
        return sessionFactory.openSession().createCriteria(Book.class).list();
    }

    @Override
    public List<Book> readPageNumber(String pageNumber) {
        Criteria criteria = sessionFactory.openSession().createCriteria(Book.class);
        criteria.setFirstResult((Integer.parseInt(pageNumber)-1)*10);
        criteria.setMaxResults(10);
        return criteria.list();
    }

    @Transactional(readOnly = false)
    @Override
    public void update(Book book) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(book);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            Transaction tx = session.getTransaction();
            if (tx.isActive()) {tx.rollback();}
        } finally {
            session.close();
        }
    }

    @Transactional(readOnly = false)
    @Override
    public void delete(Book book) {
        sessionFactory.openSession().delete(book);
    }

    @Override
    public int getAllBooksCount() {
        return ((Number) sessionFactory.openSession().createCriteria(Book.class).setProjection(Projections.rowCount()).uniqueResult()).intValue();
    }

    @Override
    public void deleteById(String id) {

        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Book book = (Book) session.createCriteria(Book.class).add(Restrictions.eq("id",Long.parseLong(id))).uniqueResult();
            //book.setAuthor("updateddelete");
            if(book!=null){
                session.delete(book);
            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            Transaction tx = session.getTransaction();
            if (tx.isActive()) {tx.rollback();}
        } finally {
            session.close();
        }
        /*Session session = sessionFactory.openSession();
        Book book = (Book) session.createCriteria(Book.class).add(Restrictions.eq("id",1L*//*Long.parseLong(id)*//*)).uniqueResult();
        book.setAuthor("updateddelete");
        session.update(book);*/
        //session.delete(book);
    }

    @Override
    public Book getById(String id) {
        Session session = sessionFactory.openSession();
        Book book = null;
        try {
            session.beginTransaction();
            book = (Book) session.createCriteria(Book.class).add(Restrictions.eq("id",Long.parseLong(id))).uniqueResult();
        } catch (HibernateException e) {
            Transaction tx = session.getTransaction();
            if (tx.isActive()) {tx.rollback();}
        } finally {
            session.close();
        }
        return book;
    }


}

