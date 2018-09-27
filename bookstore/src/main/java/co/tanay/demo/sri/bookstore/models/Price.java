package co.tanay.demo.sri.bookstore.models;

public class Price {
	
	String currency;
	int amount;
	
	
	public Price(String currency, int amount) {
		this.currency = currency;
		this.amount = amount;
	}
	
	public Price() {}
	
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "Price [currency=" + currency + ", amount=" + amount + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Price) {
			Price p = (Price) obj;
			return currency != null && p.currency != null
					&& currency.equalsIgnoreCase(p.currency)
					&& amount == p.amount;
		}
		return false;
	}
}
