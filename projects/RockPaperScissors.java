package deneme;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RockPaperScissors {

	public static void main(String[] args) {
		
		// ROCK-->1  PAPER-->2   SCISSORS-->3
		
		String[] choice = new String[] {"","Rock","Paper","Scissors"};

		System.out.println("--Rock Paper Scissors--");
		System.out.println("ROCK-->1  PAPER-->2   SCISSORS-->3");
		System.out.println();
		
		
		int computerChoice;
		int playerChoice;
		int numberofComputerWin=0;
		int numberofPlayerWin=0;
		
		do {
		
			computerChoice = (int) (Math.random()*3+1); //it should be between 1 and 3.
			System.out.print("Enter Your Choice: ");
			playerChoice = integerRead(0,3);
			System.out.println("Computer Choice: " + choice[computerChoice]);
			System.out.println("Player Choice: " + choice[playerChoice]);
			
			if(playerChoice != 0) {
				
				if(computerChoice == playerChoice ) {
					
					System.out.println("Draw!");
					
				} else if ((computerChoice == 1 && playerChoice == 3 ) || (computerChoice == 2 && playerChoice == 1 )
						|| (computerChoice == 3 && playerChoice == 2)) {
					
					numberofComputerWin++;
					System.out.println("Winning Side Computer");
					System.out.println("Score => Computer = " +numberofComputerWin+" / Player = " +numberofPlayerWin);
					
				} else {
					
					numberofPlayerWin++;
					System.out.println("Winning Side Player");
					System.out.println("Score => Computer = " +numberofComputerWin+" / Player = " +numberofPlayerWin);
					
					
				}
		
			
		} 
		} while(playerChoice != 0);
		
	}

	private static int integerRead(int min, int max) {
		
		Scanner scan = new Scanner(System.in);
		int number = 0;
		boolean readingOK = false;
		
		do {
			try {
				number = Integer.parseInt(scan.nextLine());
				readingOK = true;
			}catch(NumberFormatException e) {
				
			}
			if(number<min  || number>max || !readingOK) {
				System.out.print("Incorrect! Try Again ("+min+" - "+max+"):");
			}
			
		}while (!readingOK || number<min || number>max);
		
		return number;
	}}

	
