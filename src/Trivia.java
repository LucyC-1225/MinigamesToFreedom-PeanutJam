//purple
import java.util.ArrayList;
import java.util.Scanner;

public class Trivia{
  //portal stuff
  public static boolean unlocked;
  private static int numWins;
  private final static int maxWin = 1;

  String[] questions = {"What is the name of the game behind the white portal?", "What is the name of the game behind the orange portal?", "What is the name of the game behind the red portal?", "What is the name of the game behind the yellow portal?", "What is the name of the game behind the green portal?", "What is the name of the game behind the blue portal?", "What is the name of the game behind the purple portal?"};
  String[] answers = {"Guess the Number", "Hangman", "Rock Paper Scissors", "Memory Game", "Typing Game", "Blackjack", "Portal Trivia"};
  ArrayList<Integer> order = new ArrayList<Integer>();
  int right = 0;

  int[] questionOrder = new int[7];

  public Trivia(){
    for (int i = 0; i < 7; i++){
      order.add(i);
    }
    for (int i = 0; i < 7; i++){
      int random = U.random(0, order.size() - 1);
      questionOrder[i] = order.get(random);
      order.remove(random);
    }
  }
  public void startGame(){
    U.println("Welcome to <Portal Trivia>! You must answer at least 4 / 7 questions right in order to win! Note that your input needs to exactly match the answers (spelling and capitalization). Hint: whenever you start playing a game, the name of the game is always written inside <> :D");
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < questionOrder.length; i++){
      U.println("Questions right: " + right + " / 7");
      U.println("Question " + (i + 1) + "!");
      U.println(questions[questionOrder[i]]);
      U.print("Answer: ");
      String input = sc.nextLine();
      if (input.equalsIgnoreCase(answers[questionOrder[i]])){
        right++;
        U.println("Correct!");
        System.out.println();
      } else {
        U.println("Incorrect!");
        System.out.println();
      }
    }
    if (right >= 4){
      U.println("You won " + (right * 200) + " points!");
      Points.changePoints(right * 200);
      numWins++;
    } else {
      U.println("You lost " + ((7 - right) * 20) + " points!");
      Points.changePoints(((7 - right) * 20) * -1);
    }
  }
  public static String getStatus(){
    String str = "";
    if (unlocked){
      str += "Purple Portal | unlocked | Number of wins: " + numWins + " | Max wins: " + maxWin;
    } else {
      str += "Purple Portal |  locked  | Number of wins: " + numWins + " | Max wins: " + maxWin;
    }
    return str;
  }
  public int getNumWins()
  {
    return numWins;
  }
}