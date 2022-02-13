//Island 3: Red portal
import java.util.Scanner;
public class RockPaperScissors {
  //portal stuff
  public static boolean unlocked;
  private static int numWins;
  private final static String maxWin = "\u221E";//"infinite";
  
  private Scanner sc;
  private int roundsWon;
  
  RockPaperScissors() {
    
  }
  public void startGame(){
    //3 rounds
    roundsWon = 0;
    U.println("Welcome to <Rock Paper Scissors>!");
    for (int i = 1; i <= 3; i++){
      U.println("You have won " + roundsWon + " round(s) so far! Win 2 out of 3 rounds to win!");
      U.println("Round " + i + "!");
      int round = playGame();
      while (round == -1){
        round = playGame();
      }
      if (round == 1){
        roundsWon++;
      }
    }
    //result
    if (roundsWon == 2){
      U.println("Congrats! You have won 300 points!");
      Points.changePoints(300);
      numWins++;
    } else if (roundsWon == 3){
      U.println("Congrats! You have won 300 points! You also won an extra 200 points for winning all three rounds!");
      Points.changePoints(500);
      numWins++;
    } else {
      U.println("You have lost 100 points! :(");
      Points.changePoints(-100);
    }
  }
  private int playGame(){
    //player move
    U.print("Enter your move: ");
    sc = new Scanner(System.in);
    String input = sc.nextLine();
    while (!(input.equalsIgnoreCase("rock") || input.equalsIgnoreCase("paper") || input.equalsIgnoreCase("scissor"))){
      U.println("Invalid input. Please enter rock paper or scissor");
      U.print("Enter your move: ");
      input = sc.nextLine();
    }
    String playerMove = input;
    //God move
    U.println("God is making a move....");
    String compMove = "";
    int rand = (int) (Math.random() * 3);
    if (rand == 0){
      compMove = "rock";
    } else if (rand == 1){
      compMove = "paper";
    } else {
      compMove = "scissor";
    }
    U.println("God's move was " + compMove + "!");
    //result of game 
    if (playerMove.equalsIgnoreCase(compMove)){
      U.println("It was a tie! You get to try again!");
      System.out.println();
      return -1;
    } else if (playerMove.equalsIgnoreCase("rock") && compMove.equalsIgnoreCase("scissor") || playerMove.equalsIgnoreCase("paper") && compMove.equalsIgnoreCase("rock") || playerMove.equalsIgnoreCase("scissor") && compMove.equalsIgnoreCase("paper")){
      U.println("You won!");
      System.out.println();
      return 1;
    } else {
      U.println("You lost!");
      System.out.println();
      return 0;
    }
  }
  public static String getStatus(){
    String str = "";
    if (unlocked){
      str += "Red Portal    | unlocked | Number of wins: " + numWins + " | Max wins: " + maxWin;
    } else {
      str += "Red Portal    |  locked  | Number of wins: " + numWins + " | Max wins: " + maxWin;
    }
    return str;
  }
  public int getNumWins()
  {
    return numWins;
  }
}