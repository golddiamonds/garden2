package garden;

//class used as a template for "plants" that
//go into the garden. Couln't make abstract because
//I want to use this to utilize polymorphism
public class Plant {
	
	protected int age = 0; 				//always start at 0 days
	protected int maturity; 			//age at which plant is "ripe"
	protected int old; 					//age when plant stops producing or being edible
	protected int death; 				//age when plant dies off
	protected String babySym;			//symbol returned when "baby"
	protected String maturitySym;		//symbol returned when "mature"
	protected String deathSym = "~";	//symbol returned when "dead"
	protected String statusSym1;		//symbol returned for status info
	protected String statusSym2;		//symbol returned for status info 2
	protected int water; 				//int to hold water data
	protected int fertilizer;			//int to hold fertilizer data
	
	//plant constructor, might want to move this to hard coded above
	public Plant(){
		this.babySym  = "_";
		this.maturitySym = "_";
		this.statusSym1 = " ";
		this.statusSym2 = " ";
		this.water = 0;
		this.fertilizer = 0;
		this.death = 10000;
	}
	//get method for age
	public int getAge() {
		return age;
	}

	//basically the set method for age
	//age can only go up one day at a time
	public void growDay(int days){
		for (int i = 0; i < days; i++){
			if (this.water > 0 && this.fertilizer > 0){
				this.age += 1;
				this.water -= 1;
				this.fertilizer -= 1;
			}
			if (this.water == 0){
				this.statusSym1 = "*";
			}
			if (this.fertilizer == 0){
				this.statusSym2 = "^";
			}
			if (this.water > 0){
				this.statusSym1 = " ";
			}
			if (this.fertilizer > 0){
				this.statusSym2 = " ";
			}
		}
	}
	
	//get method to grab state of plant
	public void getState(){
		if (age < maturity){
			System.out.println("Still growing");
		} else if (age >= maturity && age < old) {
			System.out.println("Ripe!");
		} else if (age >= old && age < death){
			System.out.println("Past prime");
		} else if (age >= death){
			System.out.println("Your plant has expired.");
		}
	}
	
	//get the plant identifier symbol (e.g. "T" for tomato)
	public String getSymbol(){
		if (this.age >= this.death){
			return this.deathSym;
		}
		if (this.age >= this.maturity){
			return this.maturitySym;
		}
		return this.babySym;
	}
	
	//get the status symbols that tell whether plant needs to be fertilized
	//or watered.
	public String getStatus(int type){
		
		if (type == 2){
			return this.statusSym2;
		}
		return statusSym1;
	}
	
	//water plant, which will last for 3 days
	public void waterPlant(){
		this.water += 3;
		this.statusSym1 = " ";
	}
	
	//fertilize plant which will last for 10 days.
	public void fertilizePlant(){
		this.fertilizer += 10;
		this.statusSym2 = " ";
	}
	
	//check if plant is ripe
	public boolean checkRipe(){
		return (this.age >= this.maturity && this.age < this.death);
	}

}
