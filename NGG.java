import java.util.Random;
import java.util.Scanner;

public class NGG {
	
	private Random random;
	private Scanner scanner;
	private int temp;
	private int mark;
	private int number;
	private int totalGuesses;
	private int guessLimit;
	private String response;
	
	private void numberGuessingGame() {
		scanner = new Scanner(System.in);
		random = new Random();
		do {
			System.out.print("You have to guess a number between 1 to 100\n");
			totalGuesses = 0;
			mark = 0;
			guessLimit = 10;
			number = 0;
			temp = random.nextInt(1,101);
			while(number != temp) {
				System.out.print("\n");
				System.out.print("Make a guess : ");
				number = scanner.nextInt();
				if((number > temp) && (number < (temp + 6))) {
					System.out.println("Too close, but a high guess!");
				}
				if((number < temp) && (number > (temp - 6))) {
					System.out.println("Too close, but a low guess!");
				}
				if((number > temp) && (number < (temp + 11)) && (number > (temp + 5))) {
					System.out.println("It\'s a high guess!");
				}
				if((number < temp) && (number > (temp - 11)) && (number < (temp - 5))) {
					System.out.println("It\'s a low guess!");
				}
				if(number > (temp + 10)) {
					System.out.println("It\'s a too high guess!");
				}
				if(number < (temp - 10)) {
					System.out.println("It\'s a too low guess!");
				}
				if(number == temp) {
					System.out.println("\nYou win ;), It\'s a perfect guess!");
					mark = 1;
				}
				
				totalGuesses++;
				
				if(mark == 1) {
					System.out.println("You took " + totalGuesses + " guesses!\n");
				}
				
				if((totalGuesses == guessLimit) && (mark == 0)) {
					System.out.println("\nYou lost :( , you took 10 guesses, the correct answer is : " + temp);
					break;
				}
			}
			System.out.print("\n");
			System.out.print("Do you want to play another round?(y/n) : ");
			response = scanner.next();
			System.out.print("\n");
		}while(!response.equals("n"));
		System.out.print("");
	}
	public static void main(String[] args) {
		NGG ngg = new NGG();
		ngg.numberGuessingGame();
	}

}
