package chess;

public class Prazna extends Figura {
	
      public Prazna() {
		
		this.type = "Prazna";
	  } 
      
      
	@Override 
	public boolean movement(Duska x, Pole nachalo, Pole krai) {
		
		if(super.movement(x, nachalo, krai)) {
		return false;
		}
		
		return false;
	
	 }
	
}
