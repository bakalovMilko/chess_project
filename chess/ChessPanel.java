package chess;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;

import javax.swing.JPanel;


class ChessPanel extends JPanel {
  Duska duska = new Duska();
	  public ChessPanel() {
       
    }
    public void paintComponent(Graphics g){
      super.paintComponent(g);
      int width = this.getWidth()/8;
      int height = this.getHeight()/8;

      for(int i = 0; i < 8; i++){
        for(int j = 7; j >= 0; j--){
          if((i+j)%2==1) {
          g.setColor(new Color(164242));
          g.fillRect(i*width, j*height, width, height);
          }
        }
      }
      for(int i = 0; i < 8; i++){
        for(int j = 7; j >= 0; j--){
          try {
        	if(duska.d[i][j].f.color != 2) {  
			g.drawImage(duska.d[i][j].getImage(), i*width+3, j*height+5, null);
        	}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        }
      }
    }
}

