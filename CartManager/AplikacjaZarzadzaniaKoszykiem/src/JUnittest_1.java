import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;


public class JUnittest_1 {
	
	private Cart koszyk;
	Product product1;
	Product product2;
	Product product3;
	Set<Product> expected;
	
	
	@Before
	public void setUp()
	{
		koszyk = new Cart();
		product1 = new Product("mleko", "mleko jest biale", 4.99);
		product2 = new Product("chleb", "chleb bia³y", 2.00);
		product3 = new Product("mleko", "mleko jest biale", 4.99);
	}

	@Test
	public void NewCartTotalQuantityIsZero() {
		assertEquals("Total quantity was not zero",0,koszyk.totalQuantity());
	}
	@Test
	public void NewCartTotalPriceIsZero() {
		BigDecimal expected = BigDecimal.valueOf(0);
		assertEquals("Total cost was not zero", expected,koszyk.totalCost());
	}
	@Test
	public void addingProductsToCart(){
		koszyk.addProduct(product1,5);
		BigDecimal expected = BigDecimal.valueOf(24.95);
		assertEquals(5,koszyk.totalQuantity());
		assertEquals(expected,koszyk.totalCost());
	}
	@Test
	public void addingProductsToCartDifferentProducts(){
		koszyk.addProduct(product1,5);
		koszyk.addProduct(product2,2);
		BigDecimal expected = BigDecimal.valueOf(28.95);
		assertEquals(7,koszyk.totalQuantity());
		assertEquals(expected,koszyk.totalCost());
	}
	@Test
	public void removingProductsFromCartWhenEmpty(){
		koszyk.removeProduct(product1,1);
		BigDecimal expected = BigDecimal.valueOf(0);
		assertEquals(0,koszyk.totalQuantity());
		assertEquals(expected,koszyk.totalCost());
		
	}
	@Test
	public void removingProductsFromCart(){
		koszyk.addProduct(product1,5);
		koszyk.addProduct(product2,2);
		koszyk.removeProduct(product2,1);
		BigDecimal expected = BigDecimal.valueOf(26.95);
		assertEquals(6,koszyk.totalQuantity());
		assertEquals(expected,koszyk.totalCost());
		
	}
	@Test
	public void addingSameProductsToTheCart(){
		koszyk.addProduct(product1, 5);
		koszyk.addProduct(product2, 2);
		koszyk.addProduct(product3, 2);
		koszyk.removeProduct(product2,1);
		expected = new LinkedHashSet<Product>();
		expected.add(product1);
		expected.add(product2);
		assertEquals(expected, koszyk.getKeySet());
	}
}	
