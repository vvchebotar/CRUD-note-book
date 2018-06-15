package org.vvchebotar.crud.dao;

import org.vvchebotar.crud.domain.Book;

import java.util.List;

public interface BookDao extends GenericDao<Book, Long> {

    List<Book> getAllBooks();

    List<Book> getBooksByPage(String pageNumber);

    Book getBookById(String id);

    List<Book> getBooksByYear(String searchFromYear, String searchToYear);

    void deleteBookById(String id);

    int getAllBooksCount();
}
