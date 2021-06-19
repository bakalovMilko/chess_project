//package chess;
//
//import java.awt.Color;
//
//import javax.swing.BoxLayout;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTextArea;
//import javax.swing.JTextField;
//
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//import java.awt.Font;
//import java.awt.Panel;
//
//import javax.swing.JPopupMenu;
//import java.awt.Component;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.io.File;
//import java.io.IOException;
//
//import javax.swing.JMenuBar;
//import java.awt.TextField;
//
//class MainPanel extends JPanel {
//	
//	JTextArea movesPlayed = new JTextArea();
//	JScrollPane scrollPane = new JScrollPane(movesPlayed);
//	MainPanel(){
//		setLayout(null);
//		movesPlayed.setEditable(false);
//		movesPlayed.setLineWrap(true);
//		
//		scrollPane.setBounds(750, 25, 200, 700);
//		add(scrollPane);
//		
//		JButton btnNewGame = new JButton("New Game");
//		btnNewGame.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		btnNewGame.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		btnNewGame.setBounds(30, 725, 120, 37);
//		add(btnNewGame);
//		
//		JButton btnSaveGame = new JButton("Save Game");
//		btnSaveGame.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		btnSaveGame.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				JFrame gameNameFrame = new JFrame();
//				gameNameFrame.setSize(350, 250);
//				//frame.add(new MainPanel());
//				gameNameFrame.setTitle("Game Name");
//				gameNameFrame.setLocationRelativeTo(null);
//				gameNameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//				Panel gameNamePanel = new Panel();
//				gameNameFrame.add(gameNamePanel);
//				gameNameFrame.setVisible(true);
//				gameNamePanel.setLayout(null);
//				JLabel question = new JLabel("How do you want to name this game?");
//				JTextField answer = new JTextField();
//				JButton submit = new JButton("Submit");
//				question.setBounds(50, 50, 250, 30);
//				answer.setBounds(50, 100, 200, 30);
//				submit.setBounds(50, 150, 150, 30);
//				gameNamePanel.add(question);
//				gameNamePanel.add(answer);
//				gameNamePanel.add(submit);
//				submit.addActionListener(new ActionListener() {
//					public void actionPerformed(ActionEvent e) {
//						String gameName = answer.getText();
//						try {
//						      File file = new File("src\\Chess Games");
//						      boolean dirCreated = file.mkdir();
//						      File myObj = new File("src\\Chess Games\\"+gameName+".txt");
//						      if (myObj.createNewFile()) {
//						        question.setText("File created: " + myObj.getName());
//						      } else {
//						    	question.setText("File already exists.");
//						      }
//						    } catch (IOException i) {
//						      System.out.println("An error occurred.");
//						      i.printStackTrace();
//						    }
//					}});
//				
//			}});
//		btnSaveGame.setBounds(325, 725, 128, 37);
//		add(btnSaveGame);
//		
//		JButton btnLoadGame = new JButton("Load Game");
//		btnLoadGame.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//			}
//		});
//		btnLoadGame.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		btnLoadGame.setBounds(605, 725, 120, 37);
//		add(btnLoadGame);
//	}
//}

package chess;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JMenuBar;
import java.awt.TextField;

class MainPanel extends JPanel {
	JTextArea movesPlayed = new JTextArea();
	JScrollPane scrollPane = new JScrollPane(movesPlayed);
  ChessPanel cp = new ChessPanel();

	MainPanel(){
		setBackground(Color.GRAY);
		setLayout(null);
		movesPlayed.setEditable(false);
		movesPlayed.setLineWrap(true);
		
		scrollPane.setBounds(750, 25, 200, 700);
		add(scrollPane);

    add(cp);
    cp.setBounds(70, 70, 560, 560);
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewGame.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewGame.setBounds(29, 702, 120, 37);
		add(btnNewGame);
		
		JButton btnSaveGame = new JButton("Save Game");
		btnSaveGame.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSaveGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame gameNameFrame = new JFrame();
				gameNameFrame.setSize(350, 250);
				//frame.add(new MainPanel());
				gameNameFrame.setTitle("Game Name");
				gameNameFrame.setLocationRelativeTo(null);
				gameNameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Panel gameNamePanel = new Panel();
				gameNameFrame.getContentPane().add(gameNamePanel);
				gameNameFrame.setVisible(true);
				gameNamePanel.setLayout(null);
				JLabel question = new JLabel("How do you want to name this game?");
				JTextField answer = new JTextField();
				JButton submit = new JButton("Submit");
				question.setBounds(50, 50, 250, 30);
				answer.setBounds(50, 100, 200, 30);
				submit.setBounds(50, 150, 150, 30);
				gameNamePanel.add(question);
				gameNamePanel.add(answer);
				gameNamePanel.add(submit);
				submit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String gameName = answer.getText();
						try {
						      File file = new File("src\\Chess Games");
						      boolean dirCreated = file.mkdir();
						      File myObj = new File("src\\Chess Games\\"+gameName+".txt");
						      if (myObj.createNewFile()) {
						        question.setText("File created: " + myObj.getName());
						      } else {
						    	question.setText("File already exists.");
						      }
						    } catch (IOException i) {
						      System.out.println("An error occurred.");
						      i.printStackTrace();
						    }
					}});
				
			}});
		btnSaveGame.setBounds(324, 702, 128, 37);
		add(btnSaveGame);
		
		JButton btnLoadGame = new JButton("Load Game");
		btnLoadGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnLoadGame.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLoadGame.setBounds(604, 702, 120, 37);
		add(btnLoadGame);
	}
}

