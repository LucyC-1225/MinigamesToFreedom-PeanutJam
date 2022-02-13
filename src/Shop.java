import java.util.ArrayList;

public class Shop{
  private final static int GEM = 10000;
  private final static int WHITE_PORTAL = 0;
  private final static int RED_PORTAL = 500;
  private final static int ORANGE_PORTAL = 500;
  private final static int YELLOW_PORTAL = 500;
  private final static int GREEN_PORTAL = 500;
  private final static int BLUE_PORTAL = 500;
  private final static int PURPLE_PORTAL = 500;
  private static boolean gemBought = false;
  private static ArrayList<Boolean> unlockedPortals;

  public Shop()
  {
    unlockedPortals = new ArrayList<>();
    for (int i = 1; i <= 7; i++)
    {
      unlockedPortals.add(false);
    }
  }

  public String getShopItems(){
    String str = "";
    str += "    --------------------------\n";
    str += "   /                          \\\n";
    str += "  /                            \\\n";
    str += " /                              \\\n";
    str += "/                                \\\n";
    str += "---------------Shop---------------\n";
    str += "| Name                    Points |\n";
    str += "|                                |\n";
    str += "| " + U.BLACK + "GEM                     10000 " + U.WHITE + " |\n";
    str += "| " + U.WHITE + "White Portal                0 " + U.WHITE + " |\n";
    str += "| " + U.ORANGE + "Orange Portal             500 " + U.WHITE + " |\n";
    str += "| " + U.RED + "Red Portal                500 " + U.WHITE + " |\n";
    str += "| " + U.YELLOW + "Yellow Portal             500 " + U.WHITE + " |\n";
    str += "| " + U.GREEN + "Green Portal              500 " + U.WHITE + " |\n";
    str += "| " + U.BLUE + "Blue Portal               500 " + U.WHITE + " |\n";
    str += "| " + U.PURPLE + "Purple Portal             500 " + U.WHITE + " |\n";
    str += U.WHITE +  "__________________________________\n";
    return str;
  }
  public String toString(){
    return "";
  }

  public void buy(String item)
  {
    if (!item.equalsIgnoreCase("White Portal") && !item.equalsIgnoreCase("Orange Portal") &&       !item.equalsIgnoreCase("Red Portal") && !item.equalsIgnoreCase("Yellow Portal") &&         !item.equalsIgnoreCase("Green Portal") && !item.equalsIgnoreCase("Blue Portal") &&         !item.equalsIgnoreCase("Purple Portal") && !item.equalsIgnoreCase("GEM"))
    {
      U.println("That is not a valid item from the shop!");
    }
    else if (Points.getPoints() < 500 && !item.equalsIgnoreCase("White Portal"))
    {
      U.println("You do not have enough points to buy anything!");
    }
    else if (item.equalsIgnoreCase("White Portal"))
    {
      if (unlockedPortals.get(0))
      {
        U.println("You have already unlocked the White Portal!");
      }
      else
      {
        U.println("You have unlocked the White Portal!");
        unlockedPortals.set(0, true);
        GuessNum.unlocked = true;
        Points.changePoints(-1*WHITE_PORTAL);
      }
    }
    else if (item.equalsIgnoreCase("Orange Portal"))
    {
      if (unlockedPortals.get(1))
      {
        U.println("You have already unlocked the Orange Portal!");
      }
      else if (!unlockedPortals.get(0)) 
      {
        U.println("You have not unlocked the previous portal yet!");
      }
      else
      {
        U.println("You have unlocked the Orange Portal!");
        unlockedPortals.set(1, true);
        Hangman.unlocked = true;
        Points.changePoints(-1*ORANGE_PORTAL);
      }
    }
    else if (item.equalsIgnoreCase("Red Portal"))
    {
      if (unlockedPortals.get(2))
      {
        U.println("You have already unlocked the Red Portal!");
      }
      else if (!unlockedPortals.get(1))
      {
        U.println("You have not unlocked the previous portal yet!");
      }
      else
      {
        U.println("You have unlocked the Red Portal!");
        unlockedPortals.set(2, true);
        RockPaperScissors.unlocked = true;
        Points.changePoints(-1*RED_PORTAL);
      }
    }
    else if (item.equalsIgnoreCase("Yellow Portal"))
    {
      if (unlockedPortals.get(3))
      {
        U.println("You have already unlocked the Yellow Portal!");
      }
      else if (!unlockedPortals.get(2))
      {
        U.println("You have not unlocked the previous portal yet!");
      }
      else
      {
        U.println("You have unlocked the Yellow Portal!");
        unlockedPortals.set(3, true);
        MemoryGame.unlocked = true;
        Points.changePoints(-1*YELLOW_PORTAL);
      }
    }
    else if (item.equalsIgnoreCase("Green Portal"))
    {
      if (unlockedPortals.get(4))
      {
        U.println("You have already unlocked the Green Portal!");
      }
      else if (!unlockedPortals.get(3))
      {
        U.println("You have not unlocked the previous portal yet!");
      }
      else
      {
        U.println("You have unlocked the Green Portal!");
        unlockedPortals.set(4, true);
        Typing.unlocked = true;
        Points.changePoints(-1*GREEN_PORTAL);
      }
    }
    else if (item.equalsIgnoreCase("Blue Portal"))
    {
      if (unlockedPortals.get(5))
      {
        U.println("You have already unlocked the Blue Portal!");
      }
      else if (!unlockedPortals.get(4))
      {
        U.println("You have not unlocked the previous portal yet!");
      }
      else
      {
        U.println("You have unlocked the Blue Portal!");
        unlockedPortals.set(5, true);
        Blackjack.unlocked = true;
        Points.changePoints(-1*BLUE_PORTAL);
      }
    }
    else if (item.equalsIgnoreCase("Purple Portal"))
    {
      if (unlockedPortals.get(6))
      {
        U.println("You have already unlocked the Purple Portal!");
      }
      else if (!unlockedPortals.get(5))
      {
        U.println("You have not unlocked the previous portal yet!");
      }
      else
      {
        U.println("You have unlocked the Purple Portal!");
        unlockedPortals.set(6, true);
        Trivia.unlocked = true;
        Points.changePoints(-1*PURPLE_PORTAL);
      }
    }
    else if (item.equalsIgnoreCase("GEM") && Points.getPoints() >= 10000)
    {
      if (unlockedPortals.get(0) && unlockedPortals.get(1) && unlockedPortals.get(2) && unlockedPortals.get(3) && unlockedPortals.get(4) && unlockedPortals.get(5) && unlockedPortals.get(6)) 
      {
        gemBought = true;
        Points.changePoints(-1 * GEM);
        U.println("Congrats! You have acquired a gem!");
      }
      else 
      {
        U.println("You do not have all the previous portals unlocked yet!");
      }
    }
    else if ((item.equalsIgnoreCase("GEM") && Points.getPoints() < 10000))
    {
      U.println("You do not have enough points to buy the gem");
    }
  }
  public static boolean boughtGem(){
    return gemBought;
  }
}