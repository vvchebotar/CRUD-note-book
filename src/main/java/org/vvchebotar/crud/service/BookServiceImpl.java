package org.vvchebotar.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.vvchebotar.crud.dao.BookDao;
import org.vvchebotar.crud.domain.Book;

import java.util.List;
import java.util.Map;

public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDAO;

	@Override
	public Long create(Book newInstance) {
		return bookDAO.create(newInstance);
	}

	@Override
	public Book read(Class <Book> clazz, Long id) {
		return (Book) bookDAO.read(clazz,id);
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
	public List<Book> readAll() {
		return bookDAO.readAll();
	}

	@Override
	public List<Book> readPageNumber(String pageNumber) {
		return bookDAO.readPageNumber(pageNumber);
	}

	@Override
	public int getAllBooksCount() {
		return bookDAO.getAllBooksCount();
	}

	@Override
	public void deleteById(String id) {
		bookDAO.deleteById(id);
	}

	@Override
	public void markById(String id) {
		Book book = bookDAO.getById(id);
		if(book!=null){
            book.setReadAlready(true);
            book.setAuthor("updatedMark");//<-----------------delete
            bookDAO.update(book);
        }
	}

    @Override
    public Book getBookById(String id) {
        return bookDAO.getById(id);
    }

    @Override
    public void refreshBook(Book book) {
	    bookDAO.refreshBook(book);
    }

	@Override
	public List<Book> getBooksByYear(String searchFromYear, String searchToYear ){
				return bookDAO.getBooksByFilter(searchFromYear,searchToYear);
	}
}
