package number_guessing_game;

public class NumberGuessingMain {
	public static void main(String[] args) throws InterruptedException {
		NumberGuessingFactory factory=new NumberGuessingFactory();
		factory.designHeadLine("Wel Come to Ashwini's❤️ Number Guessing Game");
		factory.generateActualNumber();
		factory.wonOrLoss();
	}
}
