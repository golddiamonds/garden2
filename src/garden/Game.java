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
	
	public void printGarden(){
		Plant[][] gardenArray = garden.getGarden();
		int xco = garden.getX();
		int yco = garden.getY();
		for (int y = 0; y < yco; y++){
			for (int x = 0; x < xco; x++){
				if (x < (xco - 1)){
					System.out.print("[" + gardenArray[x][y].getSymbol() + "] ");
				}
				if (x == (xco -1 )){
					System.out.println("[" + gardenArray[x][y].getSymbol() + "]");
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
	}
	
	private void fertilize(){
		System.out.println("Plant have been fertilized");
	}
	
	private void buy(){
		System.out.println("What do you want to buy?");
		
	}
	
	private void inventory(){
		System.out.println("Listing your inventory...");
	}
	
	private void waitTurn(){
		int waitturns;
		System.out.print("How many days do you want to wait? ");
		waitturns = scanner.nextInt();
		garden.growGarden(waitturns);
		
	}
	
	private void help(){
		System.out.println("Type: buy, plant, or wait.");
		
	}

}
