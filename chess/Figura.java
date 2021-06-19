package chess;


public abstract class Figura {
	public int color = 2;
	public String type;
	
	public boolean movement(Duska x, Pole nachalo, Pole krai) {
		
		return x.putqChistLiE(nachalo, krai);
	}
	
}

