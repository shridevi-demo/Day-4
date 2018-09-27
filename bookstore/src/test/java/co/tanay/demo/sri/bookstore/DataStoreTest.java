package co.tanay.demo.sri.bookstore;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import co.tanay.demo.sri.bookstore.data.api.BookNotFoundException;
import co.tanay.demo.sri.bookstore.data.api.DataStore;
import co.tanay.demo.sri.bookstore.models.Book;
import co.tanay.demo.sri.bookstore.models.Price;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestBookStoreContext.class)
public class DataStoreTest {
	
	@Autowired
	DataStore dataStore;
	
	@Rule
	public ExpectedException expect = ExpectedException.none();

	@Test
	public void testFetch() {
		assertNotEquals(dataStore.fetch().size(), 0);
	}
	
	@Test
	public void testAdd() {
		assertTrue(dataStore.add(new Book(12, "Harry test 12", new Price("INR", 322))));
	}
	
	@Test
	public void testUpdateSuccess() {
		try {
			assertTrue(dataStore.update(new Book(2, "Harry test 02", new Price("INR", 652))));
		} catch (BookNotFoundException e) {
			fail("Upadte should have passed.");
		}
	}
	
	@Test
	public void testUpdateFailure() {
		try {
			dataStore.update(new Book(-1, "Harry test 02", new Price("INR", 652)));
			fail("Should have thrown BookNotFoundException");
		} catch (BookNotFoundException e) {
			// thrown as expected 
		}
	}
	
	@Test
	public void removeSuccess() {
		assertTrue(dataStore.remove(new Book(1, "Watever. Matched via id only.", new Price("INR", 652))));
	}
	
	@Test
	public void removeFailureNull() {
		expect.expect(IllegalArgumentException.class);
		dataStore.remove(null);
	}
	
	@Test
	public void removeFailureNotFound() {
		expect.expect(BookNotFoundException.class);
		dataStore.remove(new Book(-1, "Harry test 02", new Price("INR", 652)));
	}
	
	@Test(expected = BookNotFoundException.class)
	public void removeFailureNotFoundAnother() {
		dataStore.remove(new Book(-1, "Harry test 02", new Price("INR", 652)));
	}
}
