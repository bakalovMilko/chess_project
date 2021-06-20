package chess;

import java.awt.Point;

public class MoveRecorder {
	String game;
	String kolona, figura, red;
	MoveRecorder(){
		game = "";
	}
	public String reverseTraspose(String x, String y) {
		String xy = "";
		switch(x) {
		case "a":
			xy += "0";
			break;
		case "b":
			xy += "1";
			break;
		case "c":
			xy += "2";
			break;
		case "d":
			xy += "3";
			break;
		case "e":
			xy += "4";
			break;
		case "f":
			xy += "5";
			break;
		case "g":
			xy += "6";
			break;
		case "h":
			xy += "7";
			break;
			
		}
		
		switch(y) {
		case "8":
			xy += "0";
			break;
		case "7":
			xy += "1";
			break;
		case "6":
			xy += "2";
			break;
		case "5":
			xy += "3";
			break;
		case "4":
			xy += "4";
			break;
		case "3":
			xy += "5";
			break;
		case "2":
			xy += "6";
			break;
		case "1":
			xy += "7";
			break;
			
		}
		return xy;
		//Pole d[Integer.parseInt(mr.xy.charAt(0))][Integer.parseInt(mr.xy.charAt(1))]
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
