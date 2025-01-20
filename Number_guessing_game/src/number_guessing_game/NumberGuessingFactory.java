package number_guessing_game;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingFactory {
	private int actualNumber;
	private int guessedNumber;
	Scanner sc=new Scanner(System.in);
	
	public void generateActualNumber() {
		Random random=new Random();
		actualNumber=random.nextInt(1000,9999);
	}
	
	public int getActualNumber() {
		return actualNumber;
	}

	public int guessNumber() {
		int status=0;
		System.out.println("\u001B[33m"+"Guess the Number: "+"\u001B[0m");
		guessedNumber=sc.nextInt();
		if(guessedNumber<actualNumber)
			System.out.println("\u001B[35m"+"Guessed number is lower than the actual number"+"\u001B[0m");
		else if(guessedNumber>actualNumber)
			System.out.println("\u001B[35m"+"Guessed number is higher than the actual number"+"\u001B[30m");
		else if(guessedNumber==actualNumber) {
			System.out.println("💕💕You Won💕💕");
			status=1;
		}
		return status;		
	}
	public void wonOrLoss() {
		designChances("You have only 5 chances to guess the number...");
		int chances=5;
		while(chances>=0) {
			if(chances==0) {
				System.err.println("😥😥 You Loss the Game...😥😥");
				System.out.println("\u001B[36m"+"ActualNumber is :"+getActualNumber()+"\u001B[0m");
				break;
			}
			else {
				int status=guessNumber();
				chances--;
				if(status==1)
					break;
			}
			
		}
	}
	public void designHeadLine(String s) throws InterruptedException {
		System.out.println("\u001B[34m");
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			Thread.sleep(100);
			System.out.print(c);
		}
		System.out.println("\u001B[0m");
		System.out.println();
	}
	public void designChances(String s) {
		System.out.print("\u001B[2m"+"\u001B[32m");
		System.out.println(s);
		System.out.println("\u001B[0m");
	}
	
}
