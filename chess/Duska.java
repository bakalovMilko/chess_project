package chess;

public class Duska {
	Pole[][] d = new Pole[8][8];
	Duska() {
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				d[i][j] = new Pole(i, j);
			}
		}
		for(int i = 0; i<8; i++) {
			//d[i][1].remove();
			d[i][1].f = new Pawn(0);
			//d[i][6].remove();
			d[i][6].f = new Pawn(1);
			//d[3][5].f = new Pawn(0);
		}
		//d[4][0].remove();
		d[4][0].f = new King(0);
		//d[4][7].remove();
		d[4][7].f = new King(1);
		
	}
	
	
	public boolean putqChistLiE(Pole start, Pole end) {
		//check if the start square is empty
		if(start.f.color == 2)
			return false;
		
		//check if the start and the end squares have different colors
		if(start.f.color == end.f.color)
			return false;
		
		//check if the path is clear
		if(start.x == end.x && start.y == end.y)
			return false;
		else if(start.x == end.x && start.y < end.y) {
			for(int i = start.y + 1; i<end.y; i++) {
				if(d[start.x][i].f.color != 2)
					return false;
			}
			return true;
		}
		else if(start.x == end.x && start.y > end.y) {
			for(int i = end.y + 1; i<start.y; i++) {
				if(d[start.x][i].f.color != 2)
					return false;
			}
			return true;
		}
		else if(start.y == end.y && start.x > end.x) {
			for(int i = start.x + 1; i<end.x; i++) {
				if(d[i][start.y].f.color != 2)
					return false;
			}
			return true;
		}
		else if(start.y == end.y && start.x < end.x) {
			for(int i = start.x + 1; i<end.x; i++) {
				if(d[i][start.y].f.color != 2)
					return false;
			}
			return true;
		}
		else if(((start.x-end.x)*(start.x-end.x))/((start.y - end.y)*(start.y - end.y)) == 1) {
			int difX = (int) ((end.x - start.x)/Math.sqrt((end.x - start.x)*(end.x - start.x)));
			int difY = (int) ((end.y - start.y)/Math.sqrt((end.y - start.y)*(end.y - start.y)));
			
			int i = start.x+difX;
			int j = start.y+difY;
			while(i != end.x && j != end.y) {
				if(d[i][j].f.color != 2)
					return false;
				i += difX;
				j += difY;
			}
			return true;
		}
		else return true;
	}
}
