import java.math.BigDecimal;

public class Product {
	private String name;
	private String description;
	private BigDecimal price;
	
	public Product(String name, String description, double price){
		this.name = name;
		this.description = description;
		this.price = BigDecimal.valueOf(price);
	}
	
	public String getName(){
		return name;
	}
	
	public BigDecimal getPrice(){
		return price;
	}
	public String getDescription(){
		return description;
	}

	//required for map collection to see two objects with same name, price and description as equal
	@Override									
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		return result;
	}
	//required for map collection to see two objects with same name, price and description as equal
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}
	
	
}