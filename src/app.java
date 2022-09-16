import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Formatter;  




class Item {
private String itemName;
private String itemID;
private int itemPrice;
private int itemsTotalPrice;
private String itemCategory;
private int itemQuantity;

public void setItem(String itemName,String itemID,int itemPrice,String itemCategory) {
	this.itemName = itemName;
	this.itemID = itemID;
	this.itemPrice = itemPrice;
	this.itemCategory = itemCategory;
}


void setItemsTotalPrice(int price) {
		 itemsTotalPrice=price;
	} 
void setItemQuantity(int number) {
	 itemQuantity=number;
} 

public int getItemsTotalPrice() {
		return itemsTotalPrice;
	} 
public String getItemName() {
	return itemName;
}

public String getItemID() {
	return itemID;
}

public int getItemPrice() {
	return itemPrice;
}

public int getItemQuantity() {
	return itemQuantity;
}

public String getItemCategory() {
	return itemCategory;
}
}



class ShopMall extends Item{
	List<Item> cartList= new ArrayList<Item>();
	
	
	
	public void clearCart() {
		cartList.clear();
	}
	public void addToCart(Item a)
	{
		cartList.add(a);
	}
	
	public int getCartTotalPrice()
	{
		int totalprice = 0;
		for (int i = 0;i<cartList.size();i++)
		{
			totalprice = totalprice + cartList.get(i).getItemsTotalPrice();
			
		}
		
		return totalprice;
		
		
	}
	
	public void DisplayCart()
	{
		Formatter fmt = new Formatter(); 
		System.out.println();
		fmt.format("%15s %15s %15s\n", "Item Name", "Quantity", "Total ITem Price");
		fmt.format("%15s %15s   %15s\n", "---------", "-------", "------------------"); 
		int i = 0;
		for (i = 0;i<cartList.size();i++)
		{
			fmt.format("%15s %15s %15s\n", cartList.get(i).getItemName(), cartList.get(i).getItemQuantity(), cartList.get(i).getItemsTotalPrice());			
		}
		fmt.format("%45s\n", "");
		fmt.format("%45s\n", "----------------------------------------------------");
		fmt.format("%15s %15s %15s\n", "", "Total :", getCartTotalPrice());
		System.out.println(fmt); 
	}

}


public class app  {

	public static void main(String[] args) {
		//
		Formatter fmt = new Formatter(); 
		List<Item> itemlist= new ArrayList<Item>();
		
		Item v = new Item();
		v.setItem("Wheat-Bread", "PD-00001", 20, "Food");
		itemlist.add(v);
		Item a = new Item();
		a.setItem("IPhone14 Pro", "PD-00002", 9410, "Technology");
		itemlist.add(a);
		Item c = new Item();
		c.setItem("Hp Envy 500", "PD-00003", 2400, "Technology");
		itemlist.add(c);
		Item d = new Item();
		d.setItem("Screw Driver", "PD-00004", 12, "Tools");
		itemlist.add(d);
		//
		//
		fmt.format("%15s %15s %15s %15s %15s\n", "No.", "Item Name", "Item ID", "Category", "Price");
		fmt.format("%15s %15s %15s %15s %15s\n", "---", "---------", "-------", "--------", "-----"); 
		int i = 0;
		for (i = 0;i<itemlist.size();i++)
		{
			fmt.format("%15s %15s %15s %15s %15s\n", i+1, itemlist.get(i).getItemName(), itemlist.get(i).getItemID(), itemlist.get(i).getItemCategory(),"GHC "+ itemlist.get(i).getItemPrice());
			
		}
		
		//
		
		Scanner input = new Scanner(System.in); 
		System.out.println();
		System.out.println("Welcome to GUTC ShoppingMall");
		System.out.println("----------------------------");
		boolean status = true;
		ShopMall shop = new ShopMall();
		//
		
		while(status)
		{
		System.out.println();
		System.out.println("Press 1 to add item");
		System.out.println("Press 2 to quit or Exit");

		    int data = Integer.parseInt(input.nextLine());
		    switch(data)
		    {
		    case 1:
		    	System.out.println(fmt); 
		    	System.out.println("Select An Item you want to Buy");
		    	int data1 = Integer.parseInt(input.nextLine());
		    	Item selected =itemlist.get(data1-1);
		    	System.out.println("How many "+selected.getItemName()+"(s) Do you want to Buy?");
		    	int data2 = Integer.parseInt(input.nextLine());
		    	selected.setItemQuantity(data2);
		    	selected.setItemsTotalPrice(data2*selected.getItemPrice());
		    	shop.addToCart(selected);
		    	shop.DisplayCart();
		    	
		    break;
		    case 2:
		    	shop.clearCart();
		    	status=false;
		    	System.exit(0);
		    	break;
		    	
		    
		    }
		    
		}
		    
		
	
		
	}
	

	

}

