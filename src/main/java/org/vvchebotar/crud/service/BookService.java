package org.vvchebotar.crud.service;

import org.vvchebotar.crud.domain.Book;

import java.util.List;
import java.util.Map;

public interface BookService extends GenericService <Book, Long> {
    List<Book> readAll();

    List<Book> readPageNumber(String pageNumber);

    int getAllBooksCount();

    void deleteById(String id);

    void markById(String id);

    Book getBookById(String id);

    void refreshBook(Book book);

    List<Book> getBooksByYear(String searchFromYear, String searchToYear);
}
