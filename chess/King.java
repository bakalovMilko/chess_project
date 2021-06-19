package chess;

public class King extends Figura{
	
	
	public King(int x) {
		
		this.color = x;
		this.type = "King";
	}
	
	@Override 
	public boolean movement(Duska x, Pole nachalo, Pole krai) {
		
		if(Math.abs(nachalo.x-krai.x)<2 && Math.abs(nachalo.y-krai.y)<2 ) {
		super.movement(x, nachalo, krai);
		
	    }return false;
   }
}
