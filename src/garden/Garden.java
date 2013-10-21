package garden;

//class to hold a double array storing plants, representing
//the character's garden
public class Garden {
	
	private int xco; // width of garden
	private int yco; // height of garden
	private Plant[][] garden;
	
	
	public Garden(int xco, int yco){
		this.xco = xco;
		this.yco = yco;
		this.garden = new Plant[xco][yco];
		for (int y = 0; y < yco; y++){
			for (int x = 0; x < xco; x++){
				this.garden[x][y] = new Plant(); 
			}
		}
	}
	
	//method to "plant" a Plant. Hopefully not too confusing...
	public void plant(int x, int y, String plant){
		
		if (plant.equals("tomato")){
			System.out.println("Planting tomato seeds.");
			garden[y][x] = new Tomato();
		}
		
		if (plant.equals("lettuce")){
			System.out.println("Planting lettuce seeds.");
			garden[y][x] = new Lettuce();
		}
		
		if (plant.equals("potato")){
			System.out.println("Planting potatoes.");
			garden[y][x] = new Potato();
		}	
	}
	
	public Plant[][] getGarden(){
		return garden; 
	}
	
	public void growGarden(int days){
		for (int y = 0; y < this.yco; y++){
			for (int x = 0; x < this.xco; x++){
				this.garden[x][y].growDay(days); 
			}
		}
		System.out.println("Your garden has grown for " + days + " days.");
	}
	
	public int getX(){
		return xco;
	}
	
	public int getY(){
		return yco;
	}

}
