package co.tanay.demo.sri.bookstore.models;

public class Book {
	
	int id;
	String name;
	Price price;
	
	public Book() {
		
	}
	
	public Book(int id, String name, Price price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Price getPrice() {
		return price;
	}
	public void setPrice(Price price) {
		this.price = price;
	}
}
