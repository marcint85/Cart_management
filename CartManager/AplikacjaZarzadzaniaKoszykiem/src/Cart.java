
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;


public class Cart{

	private Map<Product, Integer> products;
	
	public Cart(){
		products = new LinkedHashMap<Product, Integer>();
	}
	
	public void addProduct(Product product, int i){
		if(products.containsKey(product))
			products.put(product, products.get(product)+i);
		else
			products.put(product, i);
	}
	
	public void addProduct(Product product){
		addProduct(product,1);
	}
	
	public void removeProduct(Product product, int i){
		if(products.containsKey(product))
		{
			if(products.get(product) <= i)
				products.remove(product);
			else
			products.put(product, products.get(product)-i);
		}
	}
	
	public void removeProduct(Product product){
		removeProduct(product,1);
	}
	
	public void displayProducts()
	{
		int i = 1;
		for(Product key: products.keySet())
			System.out.println( i++ +") " + key.getName() + " - " + key.getDescription() + " | iloœæ: " + products.get(key) + " )");
	}
	
	public BigDecimal totalCost()
	{
		BigDecimal sum = new BigDecimal(0);
		for(Product key: products.keySet())
		{
			sum = sum.add(key.getPrice().multiply(new BigDecimal(products.get(key))));
		}
		return sum;
	}
	
	public int totalQuantity()
	{
		int sum = 0;
		for(Product key: products.keySet())
		{
			sum = sum + products.get(key);
		}
		return sum;
	}
	
	public Set<Product> getKeySet()
	{
		return products.keySet();
	}
	
	public boolean isEmpty(){
		return products.isEmpty();
	}
	
	public Map<Product, Integer> getMap(){
		return products;
	}
}
