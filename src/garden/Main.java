package garden;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		String name;
		String action = "run";
		Scanner scanner = new Scanner(System.in);
		
		//ask for player's name
		System.out.print("Enter your name: ");
		name = scanner.next();
		
		//initiate the Game class
		Game game = new Game(name);
		
		//begin game loop
		while (action.equals("quit") == false){
			game.printGarden();
			System.out.print("What next? ");
			action = scanner.next();
			game.actionLogic(action);
		}
		
		scanner.close();
	}

}
