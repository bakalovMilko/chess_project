package chess;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int kolonaP = 0, redP = 3;
		String figuraOznachenieP = "Knight";
		int red = redP+1;
		char figuraOznachenie = 'R', kolona = 'b';
		boolean fileCreated = false;
		switch (kolonaP) {
		case 0:
			kolona = 'a';
			break;
		case 1:
			kolona = 'b';
			break;
		case 2:
			kolona = 'c';
			break;
		case 3:
			kolona = 'd';
			break;
		case 4:
			kolona = 'e';
			break;
		case 5:
			kolona = 'f';
			break;
		case 6:
			kolona = 'g';
			break;
		case 7:
			kolona = 'h';
			break;
		}
		switch (figuraOznachenieP) {
		case "Rook":
			figuraOznachenie = 'R';
			break;
		case "King":
			figuraOznachenie = 'K';
			break;
		case "Knight":
			figuraOznachenie = 'N';
			break;
		case "Queen":
			figuraOznachenie = 'Q';
			break;
		case "Bishop":
			figuraOznachenie = 'B';
			break;
		case "Pawn":
			figuraOznachenie = ' ';
			break;
		}
		String gameName;
			System.out.println("How will you name this game?");
			gameName = sc.nextLine();
			try {
			      File myObj = new File("C:\\Users\\Default\\Documents\\"+gameName+".txt");
			      if (myObj.createNewFile()) {
			        System.out.println("File created: " + myObj.getName());
			        fileCreated = true;
			      } else {
			        System.out.println("File already exists.");
			        fileCreated = false;
			      }
			    } catch (IOException e) {
			      System.out.println("An error occurred.");
			      e.printStackTrace();
			    }
		try {
		      FileWriter myWriter = new FileWriter(gameName+".txt");
		      myWriter.write(figuraOznachenie+kolona+red);
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}

}
