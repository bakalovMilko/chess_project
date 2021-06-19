package chess;

import java.awt.*;
import javax.swing.*;

public class ChessApp {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(1000, 800);
		frame.add(new MainPanel());
		frame.setTitle("Chess");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}