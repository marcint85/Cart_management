import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class Shop{
	
	private LinkedList<Product> shopItems; // list of products available for purchase
	private Cart myCart;					// products that we want to purchase will be stored under myCart ref
	private Scanner keyboard;
	
	public Shop(){
		shopItems = new LinkedList<Product>();
		myCart = new Cart();
		keyboard = new Scanner(System.in);
	}
	
	public void addItem(Product product){
		shopItems.add(product);
	}
	//displays items available for purchase
	public void displayItems(){
		int i = 1;
		System.out.println("Produkty w sklepie:");
		for(Product item: shopItems)
		{	
			System.out.println(i++ + ".) " + item.getName() + " | " + item.getDescription() + " | cena: " + item.getPrice());
		}
	}
	
	public void putToCart(int choice, int quantity){
		myCart.addProduct(shopItems.get(choice), quantity);
	}
	//displays products added to the cart
	public void displayMyCart(){
		System.out.println("Produkty w koszyku:");
		myCart.displayProducts();
	}
	
	public void removeFromCart(int choice, int quantity){
		int i = 0;
		Set<Product> myCartSet = myCart.getKeySet();
		for(Product key: myCartSet)
		{
			if(i++ == choice)
			{
				myCart.removeProduct(key, quantity);
				break;
			}
		}
	}
	
	public Product findKeyName(int choice){
		int i = 0;
		Set<Product> myCartSet = myCart.getKeySet();
		Product keyName = null;
		for(Product key: myCartSet)
		{
			if(i++ == choice)
			{
				keyName = key;
				break;
			}
		}
		return keyName;
	}

	public BigDecimal totalCost(){
		return myCart.totalCost();
	}
	
	public int totalQuantity(){
		return myCart.totalQuantity();
	}
	
	public boolean cartIsEmpty(){
		return myCart.isEmpty();
	}
	
	public int intValidation(Scanner scanner){
		while(!scanner.hasNextInt())
		{
			scanner.nextLine();
			System.out.println("Nieprawid�owa opcja");
		}
		
		return scanner.nextInt();
	}
	//main method of class - runs a user interface with options for adding products to the cart and
	//removing items from cart, the method generates a map holding products added to the cart
	public Map<Product, Integer> run(){
		boolean exit = false;
		while(exit != true)
		{
			for(int i = 0; i < 5; i++)
				System.out.println(' ');
			
			displayItems();
			System.out.print('\n');
			displayMyCart();
			System.out.print('\n');
			System.out.println("��czny koszt zakup�w: " + totalCost());
			System.out.println("��czna ilo�� produkt�w: " + totalQuantity() + '\n');
			System.out.println("Prosze wybra� opcj�:");
			System.out.println("1) Dodaj produkt do koszyka");
			System.out.println("2) Usu� produkt z koszyka");
			System.out.println("3) Zako�cz");
			
			switch(intValidation(keyboard)){
			//adding products to the cart
				case 1: {
					System.out.println("Wybierz produkt, kt�ry chcesz doda� do koszyka:");
					displayItems();
					
					int choice = intValidation(keyboard)-1;
					while(choice >= shopItems.size() || choice < 0)
					{
						System.out.println("Wybierz inny produkt");
						choice = intValidation(keyboard)-1;
					}
					System.out.println("Ile produkt�w chcesz doda� do koszyka?");
					int quantity = intValidation(keyboard);
					while(quantity <= 0)
					{
						System.out.println("wprowad� inn� ilo��");
						quantity = intValidation(keyboard);
					}
					putToCart(choice, quantity);
					break;
				}
				//removing products from the cart
				case 2: {
					
					if(cartIsEmpty())
					{
						System.out.println("Koszyk jest pusty");
					}
					else
					{
						System.out.println("Wybierz produkt, kt�ry chcesz usun�� z koszyka:");
						displayMyCart();
						int choice = intValidation(keyboard)-1;
						while(choice >= myCart.getKeySet().size() || choice < 0)
						{
							System.out.println("Nie ma takiego produktu w koszyku, wybierz inny produkt");
							choice = intValidation(keyboard)-1;
						}
						System.out.println("Ile produkt�w chcesz usun��?");
						int quantity = intValidation(keyboard);
						
						while(quantity <= 0 || quantity > myCart.getMap().get(findKeyName(choice)))
						{
							System.out.println("wprowad� inn� ilo��");
							quantity = intValidation(keyboard);
						}
						
						
						removeFromCart(choice,quantity);
					}
					break;
				}
				case 3: {
					exit = true;
					break;
				}
				case 0:
				default:
					System.out.println("Nieprawid�owa opcja");
					break;
			}
		}	
		return myCart.getMap();
	
	}
	
	public static void main(String[] args){
		
		Shop sklep = new Shop();
		//generating products that user may add to cart
		sklep.addItem(new Product("mleko", "mleko jest biale", 4.99));
		sklep.addItem(new Product("chleb", "chleb bia�y", 2.00));
		sklep.addItem(new Product("kie�basa", "pyszna kie�basa", 7.50));
		sklep.addItem(new Product("ry�", "ry� prosto z Chin", 3.89));
		sklep.addItem(new Product("jajka", "jajka strusie", 10.99));
		
		Map<Product, Integer> zakupy = sklep.run();
		
		if(!sklep.myCart.getKeySet().isEmpty())
		{
			System.out.println("Lista zakup�w:");
			for(Product key: zakupy.keySet())
				System.out.println(key.getName() + ": " + zakupy.get(key));
		}
	}
}
