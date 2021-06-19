package chess;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;


public class Pole {
	int x;
	int y;
	Figura f = new Prazna();
	public static Map<String, String> paths = new HashMap<String, String>();
	static {
		paths.put("King 0", "src\\chess\\images\\Chess_kdt60.png");
		paths.put("King 1", "src\\chess\\images\\Chess_klt60.png");
		paths.put("Queen 0", "src\\chess\\images\\Chess_qdt60.png");
		paths.put("Queen 1", "src\\chess\\images\\Chess_qlt60.png");
		paths.put("Bishop 0", "src\\chess\\images\\Chess_bdt60.png");
		paths.put("Bishop 1", "src\\chess\\images\\Chess_blt60.png");
		paths.put("Knight 0", "src\\chess\\images\\Chess_ndt60.png");
		paths.put("Knight 1", "src\\chess\\images\\Chess_nlt60.png");
		paths.put("Rook 0", "src\\chess\\images\\Chess_rdt60.png");
		paths.put("Rook 1", "src\\chess\\images\\Chess_rlt60.png");
		paths.put("Pawn 0", "src\\chess\\images\\Chess_pdt60.png");
		paths.put("Pawn 1", "src\\chess\\images\\Chess_plt60.png");
	}
	
	Pole(int x, int y){
		this.x = x;
		this.y = y;
	}
	public BufferedImage getImage() throws IOException {
		String path = paths.get(f.type + " " +  f.color);
		return ImageIO.read(new File(path));
	}
	
//	public void remove() {
//		this.f = null;
//	}

	
}
