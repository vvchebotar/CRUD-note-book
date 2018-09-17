package org.vvchebotar.crud.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vvchebotar.crud.dao.BookDao;
import org.vvchebotar.crud.domain.Book;

import java.util.List;

import static java.util.Objects.isNull;

@Service
public class BookServiceImpl implements BookService {
    private final BookDao bookDAO;

    public BookServiceImpl(BookDao bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public Long create(Book newInstance) {
        return bookDAO.create(newInstance);
    }

    @Override
    public Book read(Class<Book> clazz, Long id) {
        return bookDAO.read(clazz, id);
    }

    @Override
    public void update(Book transientObject) {
        bookDAO.update(transientObject);
    }

    @Override
    public void delete(Book persistentObject) {
        bookDAO.delete(persistentObject);
    }

    @Override
    public List<Book> readAllBooks() {
        return bookDAO.getAllBooks();
    }

    @Override
    public List<Book> getBooksByPage(String pageNumber) {
        return bookDAO.getBooksByPage(pageNumber);
    }

    @Override
    public List<Book> getBooksByYear(String searchFromYear, String searchToYear) {
        return bookDAO.getBooksByYear(searchFromYear, searchToYear);
    }

    @Override
    public Book getBookById(String id) {
        return bookDAO.getBookById(id);
    }

    @Override
    public void deleteBookById(String id) {
        bookDAO.deleteBookById(id);
    }

    @Transactional
    @Override
    public void markBookById(String id) {
        Book book = bookDAO.getBookById(id);
        if (isNull(book)) {
            return;
        }
        if (book.getReadAlready()) {
            book.setReadAlready(false);
        } else {
            book.setReadAlready(true);
        }
        bookDAO.update(book);
    }


    @Override
    public int getAllBooksCount() {
        return bookDAO.getAllBooksCount();
    }
}
