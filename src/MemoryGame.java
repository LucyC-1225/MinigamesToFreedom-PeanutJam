//yellow U TYPED cLOCK WRONGASDMNAOISDSAASAA

import java.util.ArrayList;
import java.util.Scanner;

public class MemoryGame{
  //portal stuff
  public static boolean unlocked;
  private static int numWins;
  private final static String maxWin = "\u221E";//"infinite";
  /*
  [] [] [] [] [] [] 
  [] [] [] [] [] [] 
  [] [] [] [] [] [] 
  */
  private ArrayList<Integer> possibleIndex = new ArrayList<Integer>();
  private ArrayList<Integer> pairsIndex = new ArrayList<Integer>();
  private String[] display = new String[18];//{" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "};
  private String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
  private String[] displayUser = new String[18];//{" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "};
  private String[] reference = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18"};
  private int tries;

  public MemoryGame(){
    
  }
  
  public void startGame(){
    for (int i = 0; i < 18; i++){
      display[i] = " ";
      displayUser[i] = " ";
    }
    
    Scanner sc = new Scanner(System.in);
    possibleIndex.clear();
    pairsIndex.clear();
    for (int i = 0; i < 18; i++){
      possibleIndex.add(i);
    }
    while (possibleIndex.size() > 0){
      int index1 = (int) (Math.random() * possibleIndex.size());
      pairsIndex.add(possibleIndex.get(index1));
      possibleIndex.remove(index1);
      int index2 = (int) (Math.random() * possibleIndex.size());
      pairsIndex.add(possibleIndex.get(index2));
      possibleIndex.remove(index2);
    }
    int j = 0;
    for (int i = 0; i < letters.length; i++){
      display[pairsIndex.get(j)] = letters[i];
      display[pairsIndex.get(j + 1)] = letters[i];
      j += 2;
    }
    tries = 0;
    U.println("Welcome to <Memory Game>!");
    int correct = 0;

    while(correct < 9 && tries < 20){
      System.out.println();
      //user input and display
      U.sleep(4000);
      U.clearScreen();
      System.out.println(toString(reference));
      System.out.println();
      System.out.println(toString(displayUser));
      System.out.println("Using the reference board, enter the indexes (where you want to \"flip\" the cards) in the format firstIndex secondIndex. Ex: entering \"03 04\" would flip card 3 and card 4. Note the space between 3 and 4 and the 0 before 3 and 3. Find the matching cards within 20 tries!"); 
      U.println("Number of tries: " + tries + " / 20");
      U.print("Enter your indexes: ");
      String input = sc.nextLine();
      //checking if input is in the correct format
      while (!(input.length() == 5) || !input.substring(2, 3).equals(" ") || !U.isNumeric(input.substring(0, 2)) || !U.isNumeric(input.substring(3))){
          U.clearScreen();
          System.out.println(toString(reference));
          System.out.println();
          System.out.println(toString(displayUser));
          U.println("Please enter your input in the correct format! Ex: 03 12");
          U.print("Enter your indexes: ");
          input = sc.nextLine();
      }
      int index1 = Integer.parseInt(input.substring(0, 2)) - 1;
      int index2 = Integer.parseInt(input.substring(3)) - 1;
      //checking if card is already flipped
      boolean valid = false;
      while (!valid){ 
        if (!displayUser[index1].equals(" ") || !displayUser[index2].equals(" ") || index1 != index2){
          U.clearScreen();
          System.out.println(toString(reference));
          System.out.println();
          System.out.println(toString(displayUser));
          if (!displayUser[index1].equals(" ") || !displayUser[index2].equals(" "))
          {
            System.out.println("The index(es) you entered are the index(es) of cards you already guessed correctly!");
          }
          else if (index1 != index2)
          {
            System.out.println("You cannot input the same flip over the same card twice!");
          }
          U.print("Enter your indexes: ");
          input = sc.nextLine();
          index1 = Integer.parseInt(input.substring(0, 2)) - 1;
          index2 = Integer.parseInt(input.substring(2 + 1)) - 1;
        } else {
          valid = true;
        }
      }
      
      //if the user got it right
      if (display[index1].equals(display[index2])){
        displayUser[index1] = display[index1];
        displayUser[index2] = display[index2];
        System.out.println(toString(displayUser));
        System.out.println("Good job!");
        correct++;
      } else { //if the user got it wrong
        displayUser[index1] = display[index1];
        displayUser[index2] = display[index2];
        System.out.println(toString(displayUser));
        System.out.println("Wrong!");
        displayUser[index1] = " ";
        displayUser[index2] = " ";
      }
      tries++;
    }
    if (correct == 9){
      System.out.println("Congrats! You won 1000 points!");
      Points.changePoints(1000);
      numWins++;
    } else {
      U.println("Number of tries: " + tries + " / 20");
      U.println("You exceeded the maximum number of tries! You lost 100 points! :(");
      Points.changePoints(-100);
    }
  }
  public String toString(String[] arr){
    String str = "";
    for (int j = 0; j < 6; j++){
      str += "[" + arr[j] + "]";
    }
    str += "\n";
    for (int j = 6; j < 12; j++){
      str += "[" + arr[j] + "]";
    }
    str += "\n";
    for (int j = 12; j < 18; j++){
      str += "[" + arr[j] + "]";
    }
    return str;
  }
  public static String getStatus(){
    String str = "";
    if (unlocked){
      str += "Yellow Portal | unlocked | Number of wins: " + numWins + " | Max wins: " + maxWin;
    } else {
      str += "Yellow Portal |  locked  | Number of wins: " + numWins + " | Max wins: " + maxWin;
    }
    return str;
  }
  public int getNumWins()
  {
    return numWins;
  }
}