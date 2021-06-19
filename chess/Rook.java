package chess;

public class Rook extends Figura {
	
	
    public Rook(int x) {
		
		this.color = x;
		this.type = "Rook";
	}
	
	
      public boolean movement(Duska x, Pole nachalo, Pole krai) {
		
		  if((Math.abs(nachalo.x-krai.x)>0 && Math.abs(nachalo.y-krai.y)==0 ) || (Math.abs(nachalo.x-krai.x)==0 && Math.abs(nachalo.y-krai.y)>0 )) {
		  super.movement(x, nachalo, krai);
		
	      }return false;
      }

}
