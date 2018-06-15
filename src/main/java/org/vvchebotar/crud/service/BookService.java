package org.vvchebotar.crud.service;

import org.vvchebotar.crud.domain.Book;

import java.util.List;

public interface BookService extends GenericService<Book, Long> {
    List<Book> readAllBooks();

    List<Book> getBooksByPage(String pageNumber);

    List<Book> getBooksByYear(String searchFromYear, String searchToYear);

    Book getBookById(String id);

    void deleteBookById(String id);

    void markBookById(String id);

    int getAllBooksCount();
}
