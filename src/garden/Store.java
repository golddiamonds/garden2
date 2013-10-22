package garden;

import java.util.Scanner;

//used when buying things
public class Store {
	
	private int costOfTomatoSeeds;
	private int costOfLettuceSeeds;
	private int costOfPotatoTubers;
	private int costOfFertilizer;
	private Scanner scanner;
	
	//store constructor
	public Store(){
		this.scanner = new Scanner(System.in);
		this.costOfTomatoSeeds = 3;
		this.costOfLettuceSeeds = 1;
		this.costOfPotatoTubers = 2;
		this.costOfFertilizer = 5;
	}
	
	//let player know what is available
	public void available(){
		System.out.println("We have (1) tomato seeds, (2) lettuce seeds, (3) potato tubers, and (4) fertilizer. " +
				"Choose a number: ");
		int choice = scanner.nextInt();
		switch(choice){
		case 1:
			buySeeds(1);
			break;
		case 2:
			buySeeds(2);
			break;
		case 3:
			buySeeds(3);
			break;
		case 4:
			buyFertilizer();
			break;
		}
	}
	
	//buy seeds
	public Item buySeeds(int itemNo){
		if (itemNo == 1){
			System.out.println("Buying tomato seeds");
			return new TomatoSeeds();
		}
		if (itemNo == 2){
			System.out.println("Buying lettuce seeds");
			return new LettuceSeeds();
		}
		if (itemNo == 3){
			System.out.println("Buying potato tuber");
			return new PotatoTuber();
		}
		return new Item();
	}
	
	//buy fertilizer
	public Item buyFertilizer(){
		System.out.println("Buying fertilizer");
		return new Fertilizer();
		
	}

}
