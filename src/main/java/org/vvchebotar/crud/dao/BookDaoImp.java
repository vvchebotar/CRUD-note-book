package org.vvchebotar.crud.dao;

import java.util.List;

import org.hibernate.*;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.vvchebotar.crud.domain.Book;

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
        Session session = sessionFactory.openSession();
        Book book = null;
        try {
            session.beginTransaction();
            book = session.get(clazz, id);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            Transaction tx = session.getTransaction();
            if (tx.isActive()) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return book;
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
            if (tx.isActive()) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    @Transactional(readOnly = false)
    @Override
    public void delete(Book book) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(book);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            Transaction tx = session.getTransaction();
            if (tx.isActive()) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    @Override
    public List<Book> getAllBooks() {
        return sessionFactory.openSession().createCriteria(Book.class).list();
    }


    @Override
    public List<Book> getBooksByPage(String pageNumber) {
        Criteria criteria = sessionFactory.openSession().createCriteria(Book.class);
        criteria.setFirstResult((Integer.parseInt(pageNumber) - 1) * 10);
        criteria.setMaxResults(10);
        return criteria.list();
    }

    @Override
    public Book getBookById(String id) {
        Session session = sessionFactory.openSession();
        Book book = null;
        try {
            session.beginTransaction();
            book = (Book) session.createCriteria(Book.class).add(Restrictions.eq("id", Long.parseLong(id))).uniqueResult();
        } catch (HibernateException e) {
            Transaction tx = session.getTransaction();
            if (tx.isActive()) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return book;
    }

    @Transactional(readOnly = false)
    @Override
    public void deleteBookById(String id) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Book book = (Book) session.createCriteria(Book.class).add(Restrictions.eq("id", Long.parseLong(id))).uniqueResult();
            if (book != null) {
                session.delete(book);
            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            Transaction tx = session.getTransaction();
            if (tx.isActive()) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    @Override
    public List<Book> getBooksByYear(String searchFromYear, String searchToYear) {
        Session session = sessionFactory.openSession();
        List<Book> bookList = null;
        try {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Book.class)
                    .add(Restrictions.ge("printYear", Integer.parseInt(searchFromYear)))
                    .add(Restrictions.le("printYear", Integer.parseInt(searchToYear)));
            bookList = criteria.list();
        } catch (HibernateException e) {
            Transaction tx = session.getTransaction();
            if (tx.isActive()) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return bookList;
    }

    @Override
    public int getAllBooksCount() {
        return ((Number) sessionFactory.openSession().createCriteria(Book.class).setProjection(Projections.rowCount()).uniqueResult()).intValue();
    }
}

