package Game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Hangman {

	public static void main(String[] args) throws FileNotFoundException {
		
		System.out.println("*********** Welcome to Hangman ***********");
		
		File dict = new File("/Users/mervesaltik/eclipse-workspace/deneme/src/Game/engmix 2.txt");
		
		Scanner sc = new Scanner(dict);
		Scanner user = new Scanner(System.in);
		
		ArrayList<String> phrase = new ArrayList<>();
		
		while(sc.hasNextLine()) {
			phrase.add(sc.nextLine());
		}
		
		String secret_text = phrase.get((int) (Math.random() * phrase.size()));
		char[] textArray = secret_text.toCharArray();
		char[] userAnswer = new char[textArray.length];
		for(int i= 0; i < textArray.length; i++) {
			userAnswer[i] = '?';		
				
		}
		
		boolean finished = false;
		int lives = 6;
		
		while(finished == false) {
			
			System.out.println("******************************************");
			String character = user.next();
			
			while(character.length() != 1 || Character.isDigit(character.charAt(0))) {
				
				System.out.println("Invalid input!");
				character = user.next();
				
			}
			
			boolean found = false;
			for(int i= 0; i < textArray.length; i++) {
				if(character.charAt(0) == textArray[i]) {
					userAnswer[i] = textArray[i];
					found = true;
				}
			}
			
			
			if(!found) {
				lives--;
				System.out.println("Wrong character :( ");
			}
			
			boolean done = true;
			for(int i = 0 ; i<userAnswer.length ; i ++) {
				if(userAnswer[i] == '?') {
					System.out.print(" _");
					done = false;
				}
				else {
					System.out.print(" " + userAnswer[i]);
				}
			}
			
			System.out.println("\n" + "Remaining Lives: " + lives);
			drawHangman(lives);
			
			if(done) {
				System.out.println("You Win!!!");
				finished = true;
			}
			
			if(lives <= 0 ) {
				System.out.println("Unfortunately, you didn't win. Try again.");
				finished = true;
			}		
		}
		}
		public static void drawHangman(int l) {
			  if(l == 6) {
			   System.out.println("|----------");
			   System.out.println("|");
			   System.out.println("|");
			   System.out.println("|");
			   System.out.println("|");
			   System.out.println("|");
			   System.out.println("|");
			  }
			  else if(l == 5) {
			   System.out.println("|----------");
			   System.out.println("|    O");
			   System.out.println("|");
			   System.out.println("|");
			   System.out.println("|");
			   System.out.println("|");
			   System.out.println("|");
			  }
			  else if(l == 4) {
			   System.out.println("|----------");
			   System.out.println("|    O");
			   System.out.println("|    |");
			   System.out.println("|");
			   System.out.println("|");
			   System.out.println("|");
			   System.out.println("|");
			  }
			  else if(l == 3) {
			   System.out.println("|----------");
			   System.out.println("|    O");
			   System.out.println("|   -|");
			   System.out.println("|");
			   System.out.println("|");
			   System.out.println("|");
			   System.out.println("|");
			  }
			  else if(l == 2) {
			   System.out.println("|----------");
			   System.out.println("|    O");
			   System.out.println("|   -|-");
			   System.out.println("|");
			   System.out.println("|");
			   System.out.println("|");
			   System.out.println("|");
			  }
			  else if(l == 1) {
			   System.out.println("|----------");
			   System.out.println("|    O");
			   System.out.println("|   -|-");
			   System.out.println("|   /");
			   System.out.println("|");
			   System.out.println("|");
			   System.out.println("|");
			  }
			  else{
			   System.out.println("|----------");
			   System.out.println("|    O");
			   System.out.println("|   -|-");
			   System.out.println("|   /|");
			   System.out.println("|");
			   System.out.println("|");
			   System.out.println("|");
			  }
			 	

	}

}

