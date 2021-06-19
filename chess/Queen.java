package chess;

public class Queen extends Figura{
	
    public Queen(int x) {
		
    	this.color = x;
		this.type = "Queen";
	}
	
	
	public boolean movement(Duska x, Pole nachalo, Pole krai) {
		
		  if((Math.abs(nachalo.x-krai.x)>0 && Math.abs(nachalo.y-krai.y)==0 ) || (Math.abs(nachalo.x-krai.x)==0 && Math.abs(nachalo.y-krai.y)>0) || 
				  Math.abs(nachalo.x-krai.x) == Math.abs(nachalo.y-krai.y )) {
			  return super.movement(x, nachalo, krai);
		
	      }return false;
    }


}
