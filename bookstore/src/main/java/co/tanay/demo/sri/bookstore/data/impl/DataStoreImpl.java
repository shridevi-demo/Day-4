package co.tanay.demo.sri.bookstore.data.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import co.tanay.demo.sri.bookstore.data.api.BookNotFoundException;
import co.tanay.demo.sri.bookstore.data.api.DataStore;
import co.tanay.demo.sri.bookstore.models.Book;
import co.tanay.demo.sri.bookstore.models.Price;

@Repository
public class DataStoreImpl implements DataStore {

	private List<Book> books;
	
	public DataStoreImpl() {
		this.books = new ArrayList<>(Arrays.asList(
				new Book(1, "Harry Potter 1", new Price("INR", 782)),
				new Book(2, "Harry Potter 2", new Price("INR", 682)),
				new Book(3, "Harry Potter 3", new Price("INR", 382)),
				new Book(4, "Harry Potter 4", new Price("INR", 786)),
				new Book(5, "Harry Potter 5", new Price("INR", 783))
		));
	}
	
	@Override
	public boolean add(Book book) {
		books.add(book);
		return true;
	}

	@Override
	public List<Book> fetch() {
		return new ArrayList<>(books);
	}

	@Override
	public boolean update(Book book) throws BookNotFoundException {
		for (int i = 0; i < books.size(); i++) {
			if (book.getId() == books.get(i).getId()) {
				books.remove(i);
				books.add(i, book);
				return true;
			}
		}
		throw new BookNotFoundException();
	}

	@Override
	public boolean remove(Book book) {
		if (book == null) throw new IllegalArgumentException();
		for (int i = 0; i < books.size(); i++) {
			if (book.getId() == books.get(i).getId()) {
				books.remove(i);
				return true;
			}
		}
		throw new BookNotFoundException();
	}

}
