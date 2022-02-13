import java.util.*;

public class Game{
  private GuessNum white;
  private Hangman orange;
  private RockPaperScissors red;
  private MemoryGame yellow;
  private Typing green;
  private Blackjack blue;
  private Trivia purple;
  private Shop shop;
  private Scanner scan;
  private boolean win;

  public Game()
  {
    white = new GuessNum();
    orange = new Hangman();
    red = new RockPaperScissors();
    yellow = new MemoryGame();
    green = new Typing();
    blue = new Blackjack();
    purple = new Trivia();
    scan = new Scanner(System.in);
    shop = new Shop();
  }

  public void startGame() throws Exception {
    U.println("You wake up on a random desert island");
    U.println("You don't know how you got here, but you faintly remember something");
    U.println("Flashback: ");
    U.truckAnimation();
    System.out.println();
    U.println("Ah.");
    U.println("Suddenly, a voice calls down from above");
    U.println("It's...............GOD!"); 
    U.println("Greetings player! Welcome to Iakesi! Don't worry! You did not die! I merely want to have some entertainment so I prepared this just for you!"); 
    U.println("If you want to get out of this place, you must earn enough points to buy the gem from the shop to bribe me to let you return!"); 
    U.println("How do you earn points you ask? Great question!");
    U.println("Since I am so generous, you start off with 250 points! There are different islands where you have to explore and play games, but islands require portals to enter. Earn points from games to unlock portals!");
    U.println("Earn enough points to unlock all portals and win each game at least once and buy the GEM!");
    U.println("Since you probably did not understand a thing I just said, I have created a menu for you. Good luck! I'll see you later!!");
    U.println("Ah yes by the way, if your points gets to less than 0, I think you'll die :D");
   boolean end = false;
   while (!end){
     U.sleep(2000);
     U.clearScreen();
     menu();
     
     if (Points.getPoints() < 0){
       end = true;
       U.println("Oh no! You have ran out of points! God struck you with lightning! :("); 
       U.sleep(2000);
       //credits to https://texteditor.com/multiline-text-art/
       System.out.println("██╗   ██╗ ██████╗ ██╗   ██╗    ██╗      ██████╗ ███████╗███████╗██╗\n╚██╗ ██╔╝██╔═══██╗██║   ██║    ██║     ██╔═══██╗██╔════╝██╔════╝██║\n ╚████╔╝ ██║   ██║██║   ██║    ██║     ██║   ██║███████╗█████╗  ██║\n  ╚██╔╝  ██║   ██║██║   ██║    ██║     ██║   ██║╚════██║██╔══╝  ╚═╝\n   ██║   ╚██████╔╝╚██████╔╝    ███████╗╚██████╔╝███████║███████╗██╗\n   ╚═╝    ╚═════╝  ╚═════╝     ╚══════╝ ╚═════╝ ╚══════╝╚══════╝╚═╝");
       System.exit(0);
     } else if (win){
       U.println("You have won!!!!"); //credits to https://texteditor.com/multiline-text-art/
       end = true;
       System.out.println(" ██╗   ██╗ ██████╗ ██╗   ██╗    ██╗    ██╗██╗███╗   ██╗██╗\n ╚██╗ ██╔╝██╔═══██╗██║   ██║    ██║    ██║██║████╗  ██║██║\n  ╚████╔╝ ██║   ██║██║   ██║    ██║ █╗ ██║██║██╔██╗ ██║██║\n   ╚██╔╝  ██║   ██║██║   ██║    ██║███╗██║██║██║╚██╗██║╚═╝\n    ██║   ╚██████╔╝╚██████╔╝    ╚███╔███╔╝██║██║ ╚████║██╗\n    ╚═╝    ╚═════╝  ╚═════╝      ╚══╝╚══╝ ╚═╝╚═╝  ╚═══╝╚═╝");
       U.sleep(2500);
       U.println("STATS: ");
      U.println("Number of total wins: " + (white.getNumWins() + orange.getNumWins() + red.getNumWins() + yellow.getNumWins() + green.getNumWins() + blue.getNumWins() + purple.getNumWins()));
        U.sleep(5000);
       System.exit(0);
     }
   }
  }
  private void menu() throws Exception
  {
    System.out.println();
    U.println("MENU");
    System.out.println("--------------------");
    //when the user opens the map, they are given the status of each portal and is asked which portal they would like to go into. If the portals are unlocked and the numwins does not equal maxwins, they can enter. *amazing animation* *user plays respective game* *amazing animation* *user is shown the menu* (this repeats forever until the user either wins or loses by having no points)
    U.println("Points: " + Points.getPoints());
    U.println("1. Map");
    //when the user opens the shop, they can unlock portals (but in order)
    U.println("2. Shop");
    //tell the user the stuff god told them lol kinda goes into more detail on how to win
    U.println("3. Instructions");
    //this open is only valid once the user has unlocked all portals, won all games at least once and bought the gem. After the user has met god, set instance variable win to true
    U.println("4. Meet God");
    System.out.println("--------------------");
    boolean keepRunning = false;
    while (!keepRunning) {
      System.out.println();
      U.print("Choose an option: ");
      String option = scan.nextLine();
      System.out.println();
      if (option.equals("1"))
      {
        boolean val = false;
        while (!val){
          Map.getMap();
          U.print(U.WHITE + "Which portal would you like to enter? (Enter a number 1 - 7 or enter -1 exit map): ");
          String input = scan.nextLine();
          System.out.println();
          if (input.equals("-1")){
            val = true;
          } else if (input.equals("1")){
            if (white.unlocked && white.getNumWins() < 5)
            {
              val = true;
              U.tpAnimation(true);
              U.clearScreen();
              white.startGame();
              Thread.sleep(2000);
              U.tpAnimation(false);
            }
            else
            {
              if (!white.unlocked){
                U.println("That portal is not unlocked yet! Buy the portal in the shop to unlock it!");
              } else {
                //how u word this
                U.println("You have already won the max number of wins");
              }
            }
          } else if (input.equals("2")){
            if (orange.unlocked)
            {
              val = true;
              U.tpAnimation(true);
              U.clearScreen();
              orange.startGame();
              Thread.sleep(2000);
              U.tpAnimation(false);
            }
            else
            {
              U.println("That portal is not unlocked yet! Buy the portal in the shop to unlock it!");
            }
          } else if (input.equals("3")){
            if (red.unlocked)
            {
              val = true;
              U.tpAnimation(true);
              U.clearScreen();
              red.startGame();
              Thread.sleep(2000);
              U.tpAnimation(false);
            }
            else
            {
              U.println("That portal is not unlocked yet! Buy the portal in the shop to unlock it!");
            }
          } else if (input.equals("4")){
            if (yellow.unlocked)
            {
              val = true;
              U.tpAnimation(true);
              U.clearScreen();
              yellow.startGame();
              Thread.sleep(2000);
              U.tpAnimation(false);
            }
            else
            {
              U.println("That portal is not unlocked yet! Buy the portal in the shop to unlock it!");
            }
          } else if (input.equals("5")){
            if (green.unlocked)
            {
              val = true;
              U.tpAnimation(true);
              U.clearScreen();
              //green green = new Typing();
              green.startGame();
              Thread.sleep(2000);
              U.tpAnimation(false);
            }
            else
            {
              U.println("That portal is not unlocked yet! Buy the portal in the shop to unlock it!");
            }
          } else if (input.equals("6")){
            if (blue.unlocked)
            {
              val = true;
              U.tpAnimation(true);
              U.clearScreen();
              blue.startGame();
              Thread.sleep(2000);
              U.tpAnimation(false);
            }
            else
            {
              U.println("That portal is not unlocked yet! Buy the portal in the shop to unlock it!");
            }
          } else if (input.equals("7")){
           if (purple.unlocked && purple.getNumWins() < 1)
            {
              val = true;
              U.tpAnimation(true);
              U.clearScreen();
              purple.startGame();
              Thread.sleep(2000);
              U.tpAnimation(false);
            }
            else
            {
              if (!purple.unlocked)
              {
                U.println("That portal is not unlocked yet! Buy the portal in the shop to unlock it!");
              }
              else
              {
                U.println("You have already won the max number of wins");
              }
            }
          } else {
            U.println("That is not a valid option!");
          } 
        }
        keepRunning = true;
      }
      else if (option.equals("2"))
      {
        U.clearScreen();
        System.out.println(shop.getShopItems());
        System.out.println();
        U.print("What would you like to buy? ");
        shop.buy(scan.nextLine());
        keepRunning = true;
      }
      else if (option.equals("3"))
      {
        U.println("Greetings player! Welcome to Iakesi!"); 
        U.println("To get out of this place you must: "); 
        U.println("1) Unlock all the portals");
        U.println("2) Win each game at least one");
        U.println("3) Buy the GEM to bribe God");
        U.println("The map is used to see which portals you have unlocked, the number of times you have won the game so far, the max number of times you can win and to teleport to the different games");
        U.println("The shop is where you unlock the portals and buy the gem");
        U.println("Once you fulfill all the requirements to get out of the place, you can meet God");
        U.println("Good luck and have fun!");
        keepRunning = true;
        U.sleep(2000);
      }
      else if (option.equals("4"))
      {
        if (Shop.boughtGem() && white.getNumWins() > 0 && orange.getNumWins() > 0 && red.getNumWins() > 0 && yellow.getNumWins() > 0 && green.getNumWins() > 0 && blue.getNumWins() > 0 && purple.getNumWins() > 0) 
        {
          U.println("A voice calls down from above.... (deja vu?)");
          U.println("It is........GOD!!!");
          U.println("Hello player. I see we have met once again!");
          U.println("Since you have fulfilled all my requirements, I'll keep my promise and send you home...");
          U.println("You will be returned to your world...");
          U.sleep(2000);
          win = true; 
          keepRunning = true; 
        } 
        else
        {
          System.out.println("God doesn't want to meet you right now! Come back later!");
        }
      } 
      else
      {
        System.out.println("That is not a valid option");
      }
    }
  }
}