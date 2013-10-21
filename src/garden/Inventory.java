package garden;

import java.util.ArrayList;

//class to hold items the character possesses.
public class Inventory {
	
	//set a size
	private int size = 10;
	
	//ArrayList to hold item objects
	private ArrayList<Item> inventory = new ArrayList<Item>(size);
	
	//get method for inventory
	public Item getInventory(int index) {
		return inventory.get(index);
	}
	
	//set method for inventory
	public void setInventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
	}
	
	public int getSize(){
		return this.size;
	}

}
