package chess;

public class Knight extends Figura{
	
	
    public Knight(int x) {
		
		this.color = x;
		this.type = "Knight";
	}
	
	  public boolean movement(Duska x, Pole nachalo, Pole krai) {
			
		  if((Math.abs(nachalo.x-krai.x)==1 && Math.abs(nachalo.y-krai.y)==2 ) || (Math.abs(nachalo.x-krai.x)==2 && Math.abs(nachalo.y-krai.y)==1 )) {
		  super.movement(x, nachalo, krai);
		
	      }return false;
      }

}
