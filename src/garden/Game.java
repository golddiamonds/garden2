package garden;

import java.util.Scanner;

//class that holds basics of the game.
//has player and garden objects as well as
//an actionLogic method.
public class Game {
	
	private Player player;
	private Garden garden;
	private Store store;
	private Scanner scanner = new Scanner(System.in);
	private int days = 0;
	
	public Game(String name){
		
		//create player instance
		this.player = new Player(name);
		System.out.println("Your name is " + player.getName());
		
		//get them excited
		System.out.println("GARDEN!");
		//get a garden going
		this.garden = new Garden(5,5); //do a 5x5 for now
		
		//create a store instance
		this.store = new Store();
	}
	
	//logic depending on action entered
	public void actionLogic(String action){
		switch(action.toLowerCase()){
		case "plant":
			plant();
			break;
		case "hoe":
			System.out.println("Hoeing ground!");
			hoe();
			break;
		case "water":
			System.out.println("Watering plants!");
			water();
			break;
		case "fertilize":
			System.out.println("Fertilizing plants!");
			fertilize();
			break;
		case "harvest":
			harvest();
			break;
		case "buy":
			buy();
			break;
		case "inventory":
			inventory();
			break;
		case "wait":
			waitTurn();
			break;
		case "help":
			help();
			break;
		case "quit":
			System.out.print("Fin.");
			break;
		}
	}
	
	public void printStats(){
		System.out.println("Days: " + this.days + "  Gold: " + player.getMoney());
	}
	
	public void printGarden(){
		Plant[][] gardenArray = garden.getGarden();
		int xco = garden.getX();
		int yco = garden.getY();
		System.out.println("    0     1     2     3     4");
		for (int y = 0; y < yco; y++){
			for (int x = 0; x < xco; x++){
				if (x == 0){
					System.out.print(y + " [" + gardenArray[x][y].getStatus(1) + gardenArray[x][y].getSymbol() + gardenArray[x][y].getStatus(2) + "] " );
				}
				if (x > 0 && x < (xco - 1)){
					System.out.print("[" + gardenArray[x][y].getStatus(1) + gardenArray[x][y].getSymbol() + gardenArray[x][y].getStatus(2) + "] ");
				}
				if (x == (xco -1 )){
					System.out.println("[" + gardenArray[x][y].getStatus(1) + gardenArray[x][y].getSymbol() + gardenArray[x][y].getStatus(2) + "]");
				}
			}
		}
		
	}
	
	private void plant(){
		System.out.println("Where do you want to plant?");
		System.out.print("X: ");
		int x = scanner.nextInt();
		System.out.print("Y: ");
		int y = scanner.nextInt();
		System.out.print("What do you want to plant? ");
		String plant = scanner.next();
		garden.plant(x, y, plant.toLowerCase());
	}
	
	private void hoe(){
		System.out.println("Ground has been hoed.");
	}
	
	private void water(){
		System.out.println("Plants have been watered");
		garden.waterGarden();
	}
	
	private void fertilize(){
		System.out.println("Plants have been fertilized");
		garden.fertilizeGarden();
	}
	
	private void harvest(){
		System.out.println("Which plant would you like to harvest? ");
		System.out.print("X: ");
		int xcord = scanner.nextInt();
		System.out.print("Y: ");
		int ycord = scanner.nextInt();
		//make sure it's not a Plant type and make sure that it is ripe
		if (garden.getGarden()[xcord][ycord].getSymbol() != "_" && garden.getGarden()[xcord][ycord].checkRipe()){
			//remove plant by setting it to generic Plant() using "harvest"
			garden.plant(xcord, ycord, "harvest");
			//add money for harvesting
			player.setMoney(10);
		} else {
			System.out.println("You must choose a ripe plant.");
		}
	}
	
	private void buy(){
		System.out.println("What do you want to buy?");
	}
	
	private void inventory(){
		System.out.println("Listing your inventory...");
		player.iterateOverInventory();
	}
	
	private void waitTurn(){
		int waitturns;
		System.out.print("How many days do you want to wait? ");
		waitturns = scanner.nextInt();
		garden.growGarden(waitturns);
		this.days += waitturns;
		
	}
	
	private void help(){
		System.out.println("Type: buy, plant, or wait.");
		
	}

}
