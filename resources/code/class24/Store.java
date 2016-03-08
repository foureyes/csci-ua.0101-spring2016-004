// Sellin' Clothes ... this file has classes to create an inventory of
// T-Shirts and Dress Shirts
//
// Demonstrates
//
// * Inheritance and Polymorphism
// * Using super to call super's constructor
//
// NOTES: 
// 1. these *should* be in SEPARATE .java files; the single file for 
//    convenience in demo only
// 2. the getters and setters are a bit overkill, but not a big deal since
//    you can just use Eclipse's Source-->generate to write these for you!
// 3. the class hierarchy is also little too much for such a small example
// 4. probably *not* exactly the way you'd model this (maybe an abstract
//    base class is more appropriate)

public class Store {
	
	public static void main(String[] args) {
		DressShirt dressShirt = new DressShirt("Oxford", 40.00, false, 36);
		TShirt tShirt = new TShirt("Raglan", 15.00, true, "XS");
		
		Shirt[] shirts = new Shirt[2];
		shirts[0] = dressShirt;
		shirts[1] = tShirt;
		
		System.out.println(shirts[0]);
		System.out.println(shirts[1]);
		
		// call halfOff with instance of TShirt or DressShirt
		halfOff(dressShirt);
		halfOff(tShirt);
		
		System.out.println(shirts[0]);
		System.out.println(shirts[1]);
	}
	
	// notice the type of the argument - clothing!
	public static void halfOff(Clothing clothing) {
		clothing.setPrice(clothing.getPrice() / 2);
	}
}

class Clothing {
	private String name;
	
	// id will be incremental based on count
	private int itemId;
	private double price;
	
	// count will continually increase 
	private static int count;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	
	public int getItemId() {
		return itemId;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}

	public Clothing(String name, double price) {
		itemId = ++count;
		this.name = name;
		this.price = price;
	}
	
}

class Shirt extends Clothing {
	public Shirt(String name, double price, boolean shortSleeved) {
		super(name, price);
		this.shortSleeved = shortSleeved;
	}

	private boolean shortSleeved = false;

	public boolean isShortSleeved() {
		return shortSleeved;
	}

	public void setShortSleeved(boolean shortSleeved) {
		this.shortSleeved = shortSleeved;
	}
	
	public String shortSleevedAsString() {
		return (shortSleeved ? "Short-" : "Long-") + "Sleeved";
	}
}

class TShirt extends Shirt{
	private String size;
	
	public TShirt(String name, double price, boolean shortSleeved, 
			String size) {
		super(name, price, shortSleeved);
		this.size = size;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
	public String toString() {
		return String.format("%s %s %s %s $%.2f", getItemId(), getName(), 
				shortSleevedAsString(), size, getPrice());
	}	

}

class DressShirt extends Shirt {
	private int chest;

	public DressShirt(String name, double price, boolean shortSleeved,
			int chest) {
		super(name, price, shortSleeved);
		this.chest = chest;
	}

	public int getChest() {
		return chest;
	}

	public void setChest(int chest) {
		this.chest = chest;
	}
	
	public String toString() {
		return String.format("%s %s %s %s\" $%.2f", getItemId(), getName(), 
				shortSleevedAsString(), chest, getPrice());
	}		
}
