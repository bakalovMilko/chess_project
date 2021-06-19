package chess;

public class Bishop extends Figura{
	
	public Bishop(int x) {
		
		this.color = x;
		this.type = "Bishop";
	}
	
	
   public boolean movement(Duska x, Pole nachalo, Pole krai) {
	   
		if(Math.abs(nachalo.x-krai.x) == Math.abs(nachalo.y-krai.y) ) {
			return super.movement(x, nachalo, krai);
		
	    }return false;
   }

}
