public class Map{
  public static void getMap(){
    U.clearScreen();
    U.println("Map!");
    System.out.println("1: " + GuessNum.getStatus());
    System.out.println(U.ORANGE + "2: " + Hangman.getStatus());
    System.out.println(U.RED + "3: " + RockPaperScissors.getStatus());
    System.out.println(U.YELLOW + "4: " + MemoryGame.getStatus());
    System.out.println(U.GREEN + "5: " + Typing.getStatus());
    System.out.println(U.BLUE + "6: " + Blackjack.getStatus());
    System.out.println(U.PURPLE + "7: " + Trivia.getStatus());
  }
}
  