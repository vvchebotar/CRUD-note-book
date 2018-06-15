package org.vvchebotar.crud.dao;

import org.vvchebotar.crud.domain.Book;

import javax.persistence.Query;
import java.util.List;
import java.util.Map;

public interface BookDao extends GenericDao <Book, Long> {
    void refreshBook(Book book);

    List<Book> readAll();

    List<Book> readPageNumber(String pageNumber);

    int getAllBooksCount();

    void deleteById(String id);

    Book getById(String id);

    List<Book> getBooksByFilter(String searchFromYear, String searchToYear);

}
