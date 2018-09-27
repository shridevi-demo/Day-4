package co.tanay.demo.sri.bookstore.data.api;

import java.util.List;

import co.tanay.demo.sri.bookstore.models.Book;

public interface DataStore {
	List<Book> fetch();
	boolean add(Book book);
	boolean update(Book book) throws BookNotFoundException;
	boolean remove(Book book);
}
