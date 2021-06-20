package chess;

public class King extends Figura{
	
	
	public King(int x) {
		
		this.color = x;
		this.type = "King";
	}
	
	@Override 
	public boolean movement(Duska x, Pole nachalo, Pole krai) {
		
		if(hasntMoved &&(Math.abs(nachalo.x-krai.x)>=2 && Math.abs(nachalo.y-krai.y)==0) && krai.f.type == "Rook" ){

      return super.movement(x, nachalo, krai);
    } 
    
    else if(Math.abs(nachalo.x-krai.x)<2 && Math.abs(nachalo.y-krai.y)<2 ) {

		return super.movement(x, nachalo, krai);
	  }
    return false;
   }
}