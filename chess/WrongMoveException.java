package chess;

import javax.swing.JOptionPane;

public class WrongMoveException extends Exception{
	
	public WrongMoveException() {
		
		super("Wrong move!");
    JOptionPane.showMessageDialog(null, "Wrong move! Try Again!", "Exception Message", 2);
  }
}