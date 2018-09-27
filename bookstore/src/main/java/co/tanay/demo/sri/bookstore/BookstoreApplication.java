package co.tanay.demo.sri.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import co.tanay.demo.sri.bookstore.business.api.SearchService;
import co.tanay.demo.sri.bookstore.data.api.DataStore;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BookstoreApplication.class, args);

		DataStore dataStore = context.getBean(DataStore.class);
		SearchService searchService = context.getBean(SearchService.class);
		
		System.out.println("Total Books in store : " + dataStore.fetch().size());
		System.out.println("No. of books matching 'Harry' : " + searchService.searchByName("Harry").size());
		System.out.println("No. of books under 700 : " + searchService.searchByPrice(700).size());
	}
}
