import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame{
    public static void main(String[] args) {
        Random rdm = new Random();
        Scanner sc = new Scanner(System.in);
        
        int rdmNmbr = rdm.nextInt(100)+1;
        // System.out.println("Random Number is :"+ rdmNmbr);
        
        int tryCount = 0;
        while(true){
             System.out.println("Enter your guess no (1-100): ");
        int playerGuess = sc.nextInt();
        tryCount++;
        if(playerGuess == rdmNmbr){
            System.out.println("Correct! You Win!");
            System.out.println("It took you " + tryCount + "tries");
            break;
        }
        else if(playerGuess > rdmNmbr){
            System.out.println("Nope! The Number is higher.\n ****Guess again****");
        }
        else{
            System.out.println("Nope! The Number is lower.\n ****Guess again****");
        }
        }
       
       
    }
}