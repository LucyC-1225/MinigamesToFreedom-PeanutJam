//island 1 - white portal
import java.util.Scanner;
import java.util.InputMismatchException;

public class GuessNum{
  //portal stuff
  public static boolean unlocked;
  private static int numWins;
  private final static int maxWin = 5;
  
  private Scanner scan; 
  private double multiplier;

  public GuessNum()
  {
    scan = new Scanner(System.in);
  }

  public void startGame(){
    int randomNum = (int) (Math.random() * 10) + 1;
    multiplier = 1.0;
    boolean isWin = false;
    int guessedNum = 0;
    
    U.println("Welcome to <Guess the Number>!");
    while (!isWin) {
      boolean input = false;
      if (multiplier < 0)
      {
        U.println("How did you even take more than 10 tries?!");
        U.println("You lose, the correct number was " + randomNum);
        break;
      }
      while (!input){
        U.print("Pick a number from 1-10! ");
        try{ 
          guessedNum = scan.nextInt();
          input = true;
        }
        catch (InputMismatchException e){
          U.println("That is not a valid input! ");
          scan.nextLine();
        }
      }
      if (randomNum == guessedNum){
        System.out.println("You win! The correct number was " + randomNum + "!");
        System.out.println("You win " + (int) (500 * multiplier) + " points!");
        Points.changePoints((int) (500 * multiplier));
        numWins++;
        isWin = true; 
      }
      else{
        System.out.println("That was not the correct number! Try again!");
        multiplier -= .1;
      }
    }
  }
  public static String getStatus(){
    String str = "";
    if (unlocked){
      str += "White Portal  | unlocked | Number of wins: " + numWins + " | Max wins: " + maxWin;
    } else {
      str += "White Portal  |  locked  | Number of wins: " + numWins + " | Max wins: " + maxWin;
    }
    return str;
  }
  public int getNumWins()
  {
    return numWins;
  }
}