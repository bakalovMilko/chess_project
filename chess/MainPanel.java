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
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.awt.TextField;

class MainPanel extends JPanel {
	JTextArea movesPlayed = new JTextArea();
	JScrollPane scrollPane = new JScrollPane(movesPlayed);
	ChessPanel cp = new ChessPanel();

	int kingCounter = 0;
	int moveCounter = 1;
	Pole nachalo = null;
	MoveRecorder mr = new MoveRecorder();

	MainPanel() {
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
				cp.duska = new Duska();
				cp.repaint();
				mr.game = "";
				movesPlayed.setText("");
				moveCounter = 1;
				nachalo = null;
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
							File file = new File("src\\chess\\Chess Games");
							boolean dirCreated = file.mkdir();
							File myObj = new File("src\\chess\\Chess Games\\" + gameName + ".txt");
							if (myObj.createNewFile()) {
								question.setText("File created: " + myObj.getName());
								try {
									FileWriter myWriter = new FileWriter(
											"src\\chess\\Chess Games\\" + gameName + ".txt");
									myWriter.write(mr.finalGame());
									myWriter.close();
									//System.out.println("Successfully wrote to the file.");
								} catch (IOException h) {
									//System.out.println("An error occurred.");
									h.printStackTrace();
								}
							} else {
								question.setText("File already exists.");
							}
						} catch (IOException i) {
							System.out.println("An error occurred.");
							i.printStackTrace();
						}
					}
				});

			}
		});
		btnSaveGame.setBounds(324, 702, 128, 37);
		add(btnSaveGame);

		JButton btnLoadGame = new JButton("Load Game");
		btnLoadGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cp.duska = new Duska();
				JOptionPane loadGamePane = new JOptionPane();
				String gameToLoad = (String) loadGamePane.showInputDialog(null, "Choose a game to load", "Load Game", 2,
						null, new File("src\\chess\\Chess Games").list(), "Choice");
				Scanner sc;
				try {
					sc = new Scanner(new File("src\\chess\\Chess Games\\" + gameToLoad));
					while (sc.hasNextLine()) {
						String point;
						Pole krai;
						String line = sc.nextLine();
						mr.game += line.substring(3) + " ";
						point = mr.reverseTraspose(line.substring(4, 5), line.substring(5, 6));
						nachalo = cp.duska.d[Integer.parseInt(point.substring(0, 1))][Integer
								.parseInt(point.substring(1, 2))];
						point = mr.reverseTraspose(line.substring(8, 9), line.substring(9, 10));
						krai = cp.duska.d[Integer.parseInt(point.substring(0, 1))][Integer
								.parseInt(point.substring(1, 2))];
						if (nachalo.f.type == "King" && krai.f.type == "Rook") {

//		                 if(nachalo.x-krai.x>0){    // <-
//
//		                    cp.duska.d[nachalo.x-2][nachalo.y].f = nachalo.f;
//		                    cp.duska.d[nachalo.x-2][nachalo.y].f.hasntMoved = false;
//		                    cp.duska.d[krai.x+3][nachalo.y].f = krai.f;
//		                    cp.duska.d[krai.x+3][nachalo.y].f.hasntMoved = false;
//		                    krai.f = new Prazna();
//		                    nachalo.f = new Prazna();
//						            cp.repaint();
//
//		                 }else{  // ->
//
//		                   cp.duska.d[nachalo.x+2][nachalo.y].f = nachalo.f;
//		                   cp.duska.d[nachalo.x+2][nachalo.y].f.hasntMoved = false;
//		                   cp.duska.d[krai.x-2][nachalo.y].f = krai.f;
//		                   cp.duska.d[krai.x-2][nachalo.y].f.hasntMoved = false;
//		                   krai.f = new Prazna();
//		                   nachalo.f = new Prazna();
//						           cp.repaint();
//
//		                 }
//
//		               }else if(nachalo.f.type=="Rook" && krai.f.type == "King"){
//
//		                 if(krai.x-nachalo.x>0){    // <-
//
//		                 cp.duska.d[krai.x-2][nachalo.y].f = krai.f;
//		                 cp.duska.d[krai.x-2][nachalo.y].f.hasntMoved = false;
//		                 cp.duska.d[nachalo.x+3][nachalo.y].f = nachalo.f;
//		                 cp.duska.d[nachalo.x+3][nachalo.y].f.hasntMoved = false;
//		                 krai.f = new Prazna();
//		                 nachalo.f = new Prazna();
//						         cp.repaint();
//
//		                 }else{  // ->
//
//		                   cp.duska.d[krai.x+2][nachalo.y].f = krai.f;
//		                   cp.duska.d[krai.x+2][nachalo.y].f.hasntMoved = false;
//		                   cp.duska.d[nachalo.x-2][nachalo.y].f = nachalo.f;
//		                   cp.duska.d[nachalo.x-2][nachalo.y].f.hasntMoved = false;
//		                   krai.f = new Prazna();
//		                   nachalo.f = new Prazna();
//						           cp.repaint();
//
//		                 }

						} else if (nachalo.f.type == "Pawn"
								&& ((nachalo.f.color == 1 && krai.y == 0) || (nachalo.f.color == 0 && krai.y == 7))) {

							krai.f = new Queen(nachalo.f.color);
							nachalo.f = new Prazna();
							cp.repaint();
							krai.f.hasntMoved = false;

						} else {
							krai.f = nachalo.f;
							nachalo.f = new Prazna();
							cp.repaint();
							krai.f.hasntMoved = false;
						}

						point = mr.reverseTraspose(line.substring(12, 13), line.substring(13, 14));
						nachalo = cp.duska.d[Integer.parseInt(point.substring(0, 1))][Integer
								.parseInt(point.substring(1, 2))];
						point = mr.reverseTraspose(line.substring(16, 17), line.substring(17, 18));
						krai = cp.duska.d[Integer.parseInt(point.substring(0, 1))][Integer
								.parseInt(point.substring(1, 2))];
						if (nachalo.f.type == "King" && krai.f.type == "Rook") {

//		                 if(nachalo.x-krai.x>0){    // <-
//
//		                    cp.duska.d[nachalo.x-2][nachalo.y].f = nachalo.f;
//		                    cp.duska.d[nachalo.x-2][nachalo.y].f.hasntMoved = false;
//		                    cp.duska.d[krai.x+3][nachalo.y].f = krai.f;
//		                    cp.duska.d[krai.x+3][nachalo.y].f.hasntMoved = false;
//		                    krai.f = new Prazna();
//		                    nachalo.f = new Prazna();
//						            cp.repaint();
//
//		                 }else{  // ->
//
//		                   cp.duska.d[nachalo.x+2][nachalo.y].f = nachalo.f;
//		                   cp.duska.d[nachalo.x+2][nachalo.y].f.hasntMoved = false;
//		                   cp.duska.d[krai.x-2][nachalo.y].f = krai.f;
//		                   cp.duska.d[krai.x-2][nachalo.y].f.hasntMoved = false;
//		                   krai.f = new Prazna();
//		                   nachalo.f = new Prazna();
//						           cp.repaint();
//
//		                 }
//
//		               }else if(nachalo.f.type=="Rook" && krai.f.type == "King"){
//
//		                 if(krai.x-nachalo.x>0){    // <-
//
//		                 cp.duska.d[krai.x-2][nachalo.y].f = krai.f;
//		                 cp.duska.d[krai.x-2][nachalo.y].f.hasntMoved = false;
//		                 cp.duska.d[nachalo.x+3][nachalo.y].f = nachalo.f;
//		                 cp.duska.d[nachalo.x+3][nachalo.y].f.hasntMoved = false;
//		                 krai.f = new Prazna();
//		                 nachalo.f = new Prazna();
//						         cp.repaint();
//
//		                 }else{  // ->
//
//		                   cp.duska.d[krai.x+2][nachalo.y].f = krai.f;
//		                   cp.duska.d[krai.x+2][nachalo.y].f.hasntMoved = false;
//		                   cp.duska.d[nachalo.x-2][nachalo.y].f = nachalo.f;
//		                   cp.duska.d[nachalo.x-2][nachalo.y].f.hasntMoved = false;
//		                   krai.f = new Prazna();
//		                   nachalo.f = new Prazna();
//						           cp.repaint();
//
//		                 }

						} else if (nachalo.f.type == "Pawn"
								&& ((nachalo.f.color == 1 && krai.y == 0) || (nachalo.f.color == 0 && krai.y == 7))) {

							krai.f = new Queen(nachalo.f.color);
							nachalo.f = new Prazna();
							cp.repaint();
							krai.f.hasntMoved = false;

						} else {
							krai.f = nachalo.f;
							nachalo.f = new Prazna();
							cp.repaint();
							krai.f.hasntMoved = false;
						}
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				movesPlayed.setText(mr.finalGame());
				nachalo = null;
			}
		});
		btnLoadGame.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLoadGame.setBounds(604, 702, 120, 37);
		add(btnLoadGame);

		cp.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {

				cp.repaint();
				int x = ((8 * e.getPoint().x) / cp.getWidth());
				int y = ((8 * e.getPoint().y) / cp.getHeight());

				if (nachalo == null && moveCounter % 2 == cp.duska.d[x][y].f.color) {

					nachalo = cp.duska.d[x][y];
					mr.recordFirstMove(nachalo);
				} else if(nachalo == null && moveCounter % 2 != cp.duska.d[x][y].f.color) {
					new WrongMoveException();
				} else if (moveCounter % 2 == nachalo.f.color) {

					Pole krai = cp.duska.d[x][y];

					if (nachalo.f.movement(cp.duska, nachalo, krai)) {
						mr.recordSecondMove(krai);
						if (nachalo.f.type == "King" && krai.f.type == "Rook") {

//		                    if(nachalo.x-krai.x>0){    // <-
//
//		                       cp.duska.d[nachalo.x-2][nachalo.y].f = nachalo.f;
//		                       cp.duska.d[nachalo.x-2][nachalo.y].f.hasntMoved = false;
//		                       cp.duska.d[krai.x+3][nachalo.y].f = krai.f;
//		                       cp.duska.d[krai.x+3][nachalo.y].f.hasntMoved = false;
//		                       krai.f = new Prazna();
//		                       nachalo.f = new Prazna();
//		   				            cp.repaint();
//
//		                    }else{  // ->
//
//		                      cp.duska.d[nachalo.x+2][nachalo.y].f = nachalo.f;
//		                      cp.duska.d[nachalo.x+2][nachalo.y].f.hasntMoved = false;
//		                      cp.duska.d[krai.x-2][nachalo.y].f = krai.f;
//		                      cp.duska.d[krai.x-2][nachalo.y].f.hasntMoved = false;
//		                      krai.f = new Prazna();
//		                      nachalo.f = new Prazna();
//		   				           cp.repaint();
//
//		                    }
//
//		                  }else if(nachalo.f.type=="Rook" && krai.f.type == "King"){
//
//		                    if(krai.x-nachalo.x>0){    // <-
//
//		                    cp.duska.d[krai.x-2][nachalo.y].f = krai.f;
//		                    cp.duska.d[krai.x-2][nachalo.y].f.hasntMoved = false;
//		                    cp.duska.d[nachalo.x+3][nachalo.y].f = nachalo.f;
//		                    cp.duska.d[nachalo.x+3][nachalo.y].f.hasntMoved = false;
//		                    krai.f = new Prazna();
//		                    nachalo.f = new Prazna();
//		   				         cp.repaint();
//
//		                    }else{  // ->
//
//		                      cp.duska.d[krai.x+2][nachalo.y].f = krai.f;
//		                      cp.duska.d[krai.x+2][nachalo.y].f.hasntMoved = false;
//		                      cp.duska.d[nachalo.x-2][nachalo.y].f = nachalo.f;
//		                      cp.duska.d[nachalo.x-2][nachalo.y].f.hasntMoved = false;
//		                      krai.f = new Prazna();
//		                      nachalo.f = new Prazna();
//		   				           cp.repaint();
//
//		                    }

						} else if (nachalo.f.type == "Pawn"
								&& ((nachalo.f.color == 1 && krai.y == 0) || (nachalo.f.color == 0 && krai.y == 7))) {

							krai.f = new Queen(nachalo.f.color);
							nachalo.f = new Prazna();
							cp.repaint();
							krai.f.hasntMoved = false;

						} else {
							krai.f = nachalo.f;
							nachalo.f = new Prazna();
							cp.repaint();
							krai.f.hasntMoved = false;
						}

						// kingcounter
						for (int i = 0; i < 8; i++) {
							for (int j = 0; j < 8; j++) {
								if (cp.duska.d[i][j].f.type.equals("King")) {
									kingCounter++;
								}
							}
						}

						if (kingCounter == 2) {

							moveCounter++;
							kingCounter = 0;
							
						}

						else {
							if(moveCounter%2==0) {
								JOptionPane.showMessageDialog(null, "Checkmate! Black is victorious!", "Game Over", 2);
							}else {
								JOptionPane.showMessageDialog(null, "Checkmate! White is victorious!", "Game Over", 2);
							}
							
						}

					} else {
						new WrongMoveException();
						mr.removeFirstMove();
						
					}

					nachalo = null;
				}
				// nachalo = null;
				movesPlayed.setText(mr.finalGame());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		// public void win() {

		// }
	}
}
