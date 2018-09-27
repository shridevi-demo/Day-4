package co.tanay.demo.sri.bookstore.data.api;

public class BookNotFoundException extends RuntimeException {

	public BookNotFoundException() {
		super("No book found for supplied parameters");
	}
}
