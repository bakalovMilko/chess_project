package chess;


public abstract class Figura {
	public int color = 2;
	public String type;
	boolean hasntMoved = true;
	
	public boolean movement(Duska x, Pole nachalo, Pole krai) {
		
		return x.putqChistLiE(nachalo, krai);
	}
	
}

