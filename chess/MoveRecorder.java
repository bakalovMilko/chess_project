package chess;

public class MoveRecorder {
	String game;
	String kolona, figura, red;
	MoveRecorder(){
		game = "";
	}
	public void transpose(Pole p) {
		switch (p.x) {
		case 0:
			kolona = "a";
			break;
		case 1:
			kolona = "b";
			break;
		case 2:
			kolona = "c";
			break;
		case 3:
			kolona = "d";
			break;
		case 4:
			kolona = "e";
			break;
		case 5:
			kolona = "f";
			break;
		case 6:
			kolona = "g";
			break;
		case 7:
			kolona = "h";
			break;
		}
		
		switch(p.f.type) {
		case "Rook":
			figura = "R";
			break;
		case "King":
			figura = "K";
			break;
		case "Knight":
			figura = "N";
			break;
		case "Queen":
			figura = "Q";
			break;
		case "Bishop":
			figura = "B";
			break;
		case "Pawn":
			figura = "P";
			break;
		}
		
		red = ""+(8 - p.y);
	}
	
	public void recordFirstMove(Pole p) {
		this.transpose(p);
		game+= figura+kolona+red+"->";
	}
	
	public void recordSecondMove(Pole p) {
		this.transpose(p);
		game+= kolona+red+" ";
	}
	
	public void removeFirstMove() {
		int charCount = game.length();
		game = game.substring(0, charCount-5);
	}
	
	public String finalGame() {
		String answer="";
		
		String[] moves = game.split(" ");
		for(int i = 0; i<moves.length; i++) {
			if(i%2==0) {
				answer += ((i/2)+1) + ". " + moves[i] + " ";
			} else {
				answer += moves[i] + "\n";
			}
		}
		return answer;
	}
}
