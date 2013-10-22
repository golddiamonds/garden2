package garden;

import java.util.ArrayList;

//class to hold items the character possesses.
public class Inventory {
	
	//set a size
	private int size;
	
	//ArrayList to hold item objects
	private ArrayList<Item> inventory;
	
	//constructor
	public Inventory(){
		this.size = 10;
		this.inventory = new ArrayList<Item>(this.size);
		for (int i = 1; i <= size; i++){
			inventory.add(new Item());
		}
	}
	//get method for inventory
	public String getInventory(int index) {
		return inventory.get(index).getType();
	}
	
	//set method for inventory
	public void setInventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
	}
	
	public int getSize(){
		return this.size;
	}

}
