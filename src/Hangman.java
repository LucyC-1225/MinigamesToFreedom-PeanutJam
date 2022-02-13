//Island 2: Orange portal
import java.io.File;
import java.util.Scanner;
public class Hangman {
  //portal stuff
  public static boolean unlocked;
  private static int numWins;
  private final static String maxWin = "\u221E";//"infinite";

  String[] userLetters;
  String[] wordArr;
  String[] display;
  Scanner sc;
  int mistakes;
  int numLetters;
  Hangman() {
    userLetters = new String[26];
  }
  public void startGame() throws Exception {
    String word = chooseWord();
    wordArr = new String[word.length()];
    display = new String[word.length()];
    userLetters = new String[26];
    mistakes = 0;
    numLetters = 0;
    
    U.println("Welcome to <Hangman>!");

    for (int i = 0; i < display.length; i++){
      display[i] = " _ ";
      wordArr[i] = word.substring(i, i + 1);
    }
    drawMan(mistakes);
    U.println(toString(display));
    System.out.println();
    U.println("Current guessed letters: none");
    while (!endGame()){
      boolean result = chooseLetter();
      if (result){
        U.println("Correct!");
      } else {
        U.println("Incorrect!");
        mistakes++;
      }
      drawMan(mistakes);
      U.println(toString(display));
      System.out.println();
      U.println("Current guessed letters: " + toString(userLetters));
    }
    U.println("The word was " + toString(wordArr));
    if (mistakes < 6){
      U.println("Congrats! You won 1000 points!");
      Points.changePoints(1000);
      numWins++;
    } else {
      U.println("You lost 100 points! :(");
      Points.changePoints(-100);
    }
  }
  private boolean endGame(){
    boolean end = true;
    for (int i = 0; i < display.length; i++){
      if (display[i].equals(" _ ")){
        end = false;
      }
    }
    if (mistakes == 6){
      end = true;
    }
    return end;
  }
  private boolean chooseLetter(){
    U.print("Guess a letter!: ");
    sc = new Scanner(System.in);
    String letter = sc.nextLine();
    
    boolean valid = false;
    while (!valid){
      boolean alreadyALetter = false;
      for (int i = 0; i < userLetters.length; i++){
        if (letter.equals(userLetters[i])){
          alreadyALetter = true;
        }
      }
      if (letter.length() != 1){
        U.println("Please enter a letter!");
        U.clearScreen();
        drawMan(mistakes);
        U.println(toString(display));
        U.println("Current guessed letters: " + toString(userLetters));
        U.print("Guess a letter!: ");
        letter = sc.nextLine();
      } else if (alreadyALetter){
        U.println("You already guessed this letter!");
        U.clearScreen();
        drawMan(mistakes);
        U.println(toString(display));
        U.println("Current guessed letters: " + toString(userLetters));
        U.print("Guess a letter!: ");
        letter = sc.nextLine();
      } else {
        valid = true;
      }
    }
    U.clearScreen();
    boolean exist = false;

    for (int i = 0; i < wordArr.length; i++){
      if (wordArr[i].equalsIgnoreCase(letter)){
        exist = true;
        display[i] = letter;
      }
    }
    
    userLetters[numLetters] = letter;
    numLetters++;
    return exist;
  }
  private String chooseWord() throws Exception {
    int rand = (int) (Math.random()*742 + 1);
    File file = new File("newwords.txt");
    Scanner sc = new Scanner(file);
    
    int counter = 1;
    while(counter < rand) 
    {
      sc.nextLine();
      counter++;
    }
    return sc.nextLine();
  }
  private void drawMan(int mistakes){
    if (mistakes == 0){
      System.out.println(" #######");
      System.out.println(" ##   |");
      System.out.println(" ##");
      System.out.println(" ##");
      System.out.println(" ##");
      System.out.println(" ##");
      System.out.println("#########");
    } else if (mistakes == 1){
      System.out.println(" #######");
      System.out.println(" ##   |");
      System.out.println(" ##   @");
      System.out.println(" ##");
      System.out.println(" ##");
      System.out.println(" ##");
      System.out.println("#########");
    } else if (mistakes == 2){
      System.out.println(" #######");
      System.out.println(" ##   |");
      System.out.println(" ##   @");
      System.out.println(" ##   |");
      System.out.println(" ##");
      System.out.println(" ##");
      System.out.println("#########");
    } else if (mistakes == 3){
      System.out.println(" #######");
      System.out.println(" ##   |");
      System.out.println(" ##   @");
      System.out.println(" ##  /|");
      System.out.println(" ##");
      System.out.println(" ##");
      System.out.println("#########");
    } else if (mistakes == 4){
      System.out.println(" #######");
      System.out.println(" ##   |");
      System.out.println(" ##   @");
      System.out.println(" ##  /|\\");
      System.out.println(" ##");
      System.out.println(" ##");
      System.out.println("#########");
    } else if (mistakes == 5){
      System.out.println(" #######");
      System.out.println(" ##   |");
      System.out.println(" ##   @");
      System.out.println(" ##  /|\\");
      System.out.println(" ##  /");
      System.out.println(" ##");
      System.out.println("#########");
    } else if (mistakes == 6){
      System.out.println(" #######");
      System.out.println(" ##   |");
      System.out.println(" ##   @");
      System.out.println(" ##  /|\\");
      System.out.println(" ##  / \\");
      System.out.println(" ##");
      System.out.println("#########");
    }
  }
  private String toString(String[] arr){
    String str = "";
    for (int i = 0; i < arr.length; i++){
      if (arr[i] != null){
        str += arr[i];
      }
    }
    return str;
  }
  public static String getStatus(){
    String str = "";
    if (unlocked){
      str += "Orange Portal | unlocked | Number of wins: " + numWins + " | Max wins: " + maxWin;
    } else {
      str += "Orange Portal |  locked  | Number of wins: " + numWins + " | Max wins: " + maxWin;
    }
    return str;
  }
  public int getNumWins()
  {
    return numWins;
  }
}