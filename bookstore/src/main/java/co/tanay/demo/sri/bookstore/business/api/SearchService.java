package co.tanay.demo.sri.bookstore.business.api;

import java.util.List;

import co.tanay.demo.sri.bookstore.models.Book;

public interface SearchService {
	List<Book> searchByName(String query);
	List<Book> searchByPrice(int amount);
}
