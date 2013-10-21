package garden;

//class used as a template for "plants" that
//go into the garden. Couln't make abstract because
//I want to use this to utilize polymorphism
public class Plant {
	
	protected int age = 0; 			//always start at 0 days
	protected int maturity; 		//age at which plant is "ripe"
	protected int old; 				//age when plant stops producing or being edible
	protected int death; 			//age when plant dies off
	protected String babySym;		//symbol returned when "baby"
	protected String maturitySym;	//symbol returned when "mature"
	protected String deathSym;		//symbol returned when "dead"

	public Plant(){
		this.babySym  = "_";
		this.maturitySym = "_";
		this.deathSym = "_";
	}
	//get method for age
	public int getAge() {
		return age;
	}

	//basically the set method for age
	//age can only go up one day at a time
	public void growDay(int days){
		this.age += days;
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
	
	public String getSymbol(){
		if (this.age >= this.death){
			return this.deathSym;
		}
		if (this.age >= this.maturity){
			return this.maturitySym;
		}
		return this.babySym;
	}
	

}
