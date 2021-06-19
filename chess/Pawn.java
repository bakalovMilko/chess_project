package chess;

public class Pawn extends Figura {
	
    public Pawn(int x) {
		
    	this.color = x;
		this.type = "Pawn";
	}
	
	  public boolean movement(Duska x, Pole nachalo, Pole krai) {
		  
		  
		if(this.color == 1)	{
		  if(nachalo.y-krai.y<0 && (Math.abs(nachalo.x-krai.x)==0  || (Math.abs(nachalo.x-krai.x)==1 && krai.f.color ==0 ))) {
		  super.movement(x, nachalo, krai);
		 }
		}
		else if(this.color == 0)	{
			  if(nachalo.y-krai.y>0 && (Math.abs(nachalo.x-krai.x)==0  || (Math.abs(nachalo.x-krai.x)==1 && krai.f.color ==1 ))) {
				  super.movement(x, nachalo, krai);
				}
	      }
		return false;
         
	  }

}
