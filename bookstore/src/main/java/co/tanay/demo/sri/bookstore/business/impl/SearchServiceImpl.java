package co.tanay.demo.sri.bookstore.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.tanay.demo.sri.bookstore.business.api.SearchService;
import co.tanay.demo.sri.bookstore.data.api.DataStore;
import co.tanay.demo.sri.bookstore.models.Book;

@Service
public class SearchServiceImpl implements SearchService {
	
	@Autowired
	DataStore dataStore;

	@Override
	public List<Book> searchByName(String query) {
		List<Book> f = new ArrayList<>();
		for (Book b : dataStore.fetch()) {
			if (b.getName().toLowerCase().contains(query.toLowerCase())) f.add(b);
		}
		return f;
	}

	@Override
	public List<Book> searchByPrice(int amount) {
		List<Book> f = new ArrayList<>();
		for (Book b : dataStore.fetch()) {
			if (b.getPrice().getAmount() <= amount) f.add(b);
		}
		return f;
	}
}
