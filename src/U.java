import java.util.*;

public class U {
  public final static String TREE = "\uD83C\uDF34"; 
  public final static String SAND = "\uD83D\uDFE8";
  public final static String WATER = "\uD83D\uDFE6";
  public final static String GREEN_SQUARE = "\uD83D\uDFE9";//"☐";
  public final static String RED_SQUARE = "\uD83D\uDFE5";
  public static final String RED = "\u001B[31m";
  public static final String GREEN = "\u001B[32m";
  public static final String PURPLE = "\u001B[35m";
  public static final String BLUE = "\u001B[34m";
  public static final String YELLOW = "\u001B[33m";
  public static final String WHITE	= "\u001B[37m";
  public static final String ORANGE = "\u001B[93m";
  public static final String BLACK = "\u001B[30m";
  
  public static void print(String str) {
    for (int i = 0; i < str.length(); i++) {
      try {
        System.out.print(str.substring(i, i+1));
        Thread.sleep(40);
      }
      catch (InterruptedException e) {
        System.out.println("No interruptions thank you");
      }
    }
  }

  public static void println(String str) {
    print(str);
    System.out.println();
  }

  //dont look
  public static void tpAnimation(boolean forwards)
  {
    int flipper = (forwards)? 0: 19;
    String[][] map = new String[20][20];

    for (int i = 0; i < 20; i++)
    {
      for (int j = 0; j < 20; j++)
      {
        map[i][j] = WATER; 
      }
    }
    map[2][Math.abs(flipper-2)] = TREE;
    map[2][Math.abs(flipper-3)] = TREE;
    map[3][Math.abs(flipper-2)] = SAND;
    map[4][Math.abs(flipper-2)] = SAND;
    map[3][Math.abs(flipper-3)] = SAND;
    map[4][Math.abs(flipper-3)] = SAND;
    map[15][Math.abs(flipper-16)] = TREE;
    map[15][Math.abs(flipper-17)] = TREE;
    map[16][Math.abs(flipper-17)] = SAND;
    map[17][Math.abs(flipper-17)] = SAND;
    map[16][Math.abs(flipper-16)] = SAND;
    map[17][Math.abs(flipper-16)] = SAND;
    map[3][Math.abs(flipper-4)] = RED_SQUARE;
    map[2][Math.abs(flipper-5)] = RED_SQUARE;
    map[1][Math.abs(flipper-6)] = RED_SQUARE;
    map[1][Math.abs(flipper-7)] = RED_SQUARE;
    map[1][Math.abs(flipper-8)] = RED_SQUARE;
    map[1][Math.abs(flipper-9)] = RED_SQUARE;
    map[2][Math.abs(flipper-10)] = RED_SQUARE;
    map[2][Math.abs(flipper-11)] = RED_SQUARE;
    map[3][Math.abs(flipper-12)] = RED_SQUARE;
    map[4][Math.abs(flipper-13)] = RED_SQUARE;   
    map[5][Math.abs(flipper-13)] = RED_SQUARE;    
    map[6][Math.abs(flipper-14)] = RED_SQUARE;
    map[7][Math.abs(flipper-14)] = RED_SQUARE;
    map[8][Math.abs(flipper-14)] = RED_SQUARE;
    map[9][Math.abs(flipper-13)] = RED_SQUARE;
    map[10][Math.abs(flipper-13)] = RED_SQUARE;
    map[11][Math.abs(flipper-12)] = RED_SQUARE;
    map[12][Math.abs(flipper-11)] = RED_SQUARE;
    map[12][Math.abs(flipper-10)] = RED_SQUARE;
    map[13][Math.abs(flipper-9)] = RED_SQUARE;
    map[13][Math.abs(flipper-8)] = RED_SQUARE;
    map[14][Math.abs(flipper-7)] = RED_SQUARE;
    map[15][Math.abs(flipper-7)] = RED_SQUARE;
    map[16][Math.abs(flipper-8)] = RED_SQUARE;
    map[17][Math.abs(flipper-9)] = RED_SQUARE;
    map[17][Math.abs(flipper-10)] = RED_SQUARE;
    map[18][Math.abs(flipper-11)] = RED_SQUARE;
    map[18][Math.abs(flipper-12)] = RED_SQUARE;
    map[18][Math.abs(flipper-13)] = RED_SQUARE;
    map[17][Math.abs(flipper-14)] = RED_SQUARE;
    map[16][Math.abs(flipper-15)] = RED_SQUARE;
    printMap(map);

    map[3][Math.abs(flipper-4)] = GREEN_SQUARE;
    combo(map);
    map[2][Math.abs(flipper-5)] = GREEN_SQUARE;
    combo(map);
    map[1][Math.abs(flipper-6)] = GREEN_SQUARE;
    combo(map);
    map[1][Math.abs(flipper-7)] = GREEN_SQUARE;
    combo(map);
    map[1][Math.abs(flipper-8)] = GREEN_SQUARE;
    combo(map);
    map[1][Math.abs(flipper-9)] = GREEN_SQUARE;
    combo(map);
    map[2][Math.abs(flipper-10)] = GREEN_SQUARE;
    combo(map);
    map[2][Math.abs(flipper-11)] = GREEN_SQUARE;
    combo(map);
    map[3][Math.abs(flipper-12)] = GREEN_SQUARE;
    combo(map);
    map[4][Math.abs(flipper-13)] = GREEN_SQUARE;
    combo(map);   
    map[5][Math.abs(flipper-13)] = GREEN_SQUARE;
    combo(map);   
    map[6][Math.abs(flipper-14)] = GREEN_SQUARE;
    combo(map);
    map[7][Math.abs(flipper-14)] = GREEN_SQUARE;
    combo(map);
    map[8][Math.abs(flipper-14)] = GREEN_SQUARE;
    combo(map);
    map[9][Math.abs(flipper-13)] = GREEN_SQUARE;
    combo(map);
    map[10][Math.abs(flipper-13)] = GREEN_SQUARE;
    combo(map);
    map[11][Math.abs(flipper-12)] = GREEN_SQUARE;
    combo(map);
    map[12][Math.abs(flipper-11)] = GREEN_SQUARE;
    combo(map);
    map[12][Math.abs(flipper-10)] = GREEN_SQUARE;
    combo(map);
    map[13][Math.abs(flipper-9)] = GREEN_SQUARE;
    combo(map);
    map[13][Math.abs(flipper-8)] = GREEN_SQUARE;
    combo(map);
    map[14][Math.abs(flipper-7)] = GREEN_SQUARE;
    combo(map);
    map[15][Math.abs(flipper-7)] = GREEN_SQUARE;
    combo(map);
    map[16][Math.abs(flipper-8)] = GREEN_SQUARE;
    combo(map);
    map[17][Math.abs(flipper-9)] = GREEN_SQUARE;
    combo(map);
    map[17][Math.abs(flipper-10)] = GREEN_SQUARE;
    combo(map);
    map[18][Math.abs(flipper-11)] = GREEN_SQUARE;
    combo(map);
    map[18][Math.abs(flipper-12)] = GREEN_SQUARE;
    combo(map);
    map[18][Math.abs(flipper-13)] = GREEN_SQUARE;
    combo(map);
    map[17][Math.abs(flipper-14)] = GREEN_SQUARE;
    combo(map);
    map[16][Math.abs(flipper-15)] = GREEN_SQUARE;
    combo(map);
    sleep(2000);
    clearScreen();
  }

  public static void truckAnimation()
  {
    String dead = " ";
    for (int i = 0; i <= 15; i++)
    {
      String space = "";
      clearScreen();
      for (int j = i; j <= 15; j++)
      {
        space += " ";
      }
      //truck semi-stolen from https://www.asciiart.eu/vehicles/trucks
      System.out.println("              " + space + "/================ ");
      System.out.println("       " + space + "___   //  @||----------|");
      System.out.println("  _  " + space + "_|___|_//_\\_|||_____|____|");
      System.out.println(" |" + dead + "|" + space + "|  ____ |     ||    /___  |>");
      System.out.println(" /|\\" + space + "| |    \\|_____||___|    \\ |>");
      System.out.println("  |" + space + "||_|  O  \\__________|  O  \\||");
      System.out.println(" / \\" + space + "   \\___/ TRUCK-KUN  \\___/");
      sleep(100);
      if (i == 14)
      {
        dead = "X";
      }
    }
    sleep(3000);
    clearScreen();
  }

  public static void clearScreen()
  {
    System.out.print("\033[H\033[2J");  
    System.out.flush();
  }

  public static void sleep(int ms)
  {
    try{
      Thread.sleep(ms);
    }
    catch(InterruptedException e){
      System.out.print(e);
    }
  }

  private static void printMap(String[][] map)
  {
    for (int i = 0; i < 20; i++)
    {
      for (int j = 0; j < 20; j++)
      {
        System.out.print(map[i][j]);
      }
      System.out.println();
    }
  }

  private static void combo(String[][] map)
  {
    sleep(150);
    clearScreen();
    printMap(map);
  }

  public static int random(int min, int max)
  {
      return (int) (Math.random() * (max-min+1)) + min;
  }

  public static boolean isNumeric(String strNum) {
    if (strNum == null) {
        return false;
    }
    try {
        int d = Integer.parseInt(strNum);
    } catch (NumberFormatException nfe) {
        return false;
    }
    return true;
  }
}
