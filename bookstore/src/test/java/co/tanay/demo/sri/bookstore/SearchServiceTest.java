package co.tanay.demo.sri.bookstore;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import co.tanay.demo.sri.bookstore.business.api.SearchService;
import co.tanay.demo.sri.bookstore.data.api.DataStore;
import co.tanay.demo.sri.bookstore.models.Book;
import co.tanay.demo.sri.bookstore.models.Price;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestBookStoreContext.class)
public class SearchServiceTest {
		
	@MockBean
	DataStore dataStore;
	
	@Autowired
	SearchService searchService;
	
	@Before
	public void setup() {
		when(dataStore.fetch()).thenReturn(Arrays.asList(
				new Book(1, "Sherlock H", new Price("USD", 130)),
				new Book(2, "Byomkesh N", new Price("USD", 90)),
				new Book(1, "Sherlock H", new Price("USD", 100))));
	}
	
	@Test
	public void testSearchByNameSuccess() {
		List<Book> results = searchService.searchByName("sherlock");
		assertEquals(2, results.size());
	}
	
	@Test
	public void testSearchByNameNonExistent() {
		List<Book> results = searchService.searchByName("Sri");
		assertEquals(0, results.size());
	}
	
	@Test
	public void testSearchByNameNullCondition() {
		try {
			List<Book> results = searchService.searchByName(null);
			assertEquals(0, results.size()); // shall pass
		} catch (NullPointerException e) {
			fail("Should not throw null pointer exception");
		} catch (Exception | Error e) {
			// can throw some other error or custom exception even, 
		}
	}
	
	@Test
	public void testSearchByPrice() {
		List<Book> results = searchService.searchByPrice(110);
		assertEquals(2, results.size());
	}
	
	@Test
	public void testSearchByPriceNegative() {
		List<Book> results = searchService.searchByPrice(-110);
		assertEquals(0, results.size());
	}
}
