package garden;

//Class that holds all player related objects and info
public class Player {
	
	private String name; //Should only get set at construction of player
	private int money; //An INT should be fine
	private Inventory inventory; //Inventory class
	
	public Player(String name){
		
		this.name = name;
		this.inventory = new Inventory();
	}
	
	public String getName(){
		
		return name;
	}
	
	public void setMoney(int amount){
		this.money += amount;
		
		if (this.money < 0){
			this.money = 0;
		}
	}
	
	public int getMoney(){
		return money;
	}
	
	public void iterateOverInventory(){
		int length = this.inventory.getSize();
		for (int i = 0; i < length; i++){
			System.out.println(this.inventory.getInventory(i));
		}
	}

	
}
