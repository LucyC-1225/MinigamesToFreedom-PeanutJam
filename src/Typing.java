//island 5 - Green portal
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Stream;
import java.util.Scanner;

public class Typing
{
  //portal stuff
  public static boolean unlocked;
  private static int numWins;
  private final static String maxWin = "\u221E";//"infinite";

    private Scanner scan;
    private int seconds;
    private Timer timer;
    private TimerTask task;

    public Typing(){
        
    }

    public void startTimer()
    {
        timer.scheduleAtFixedRate(task, 0, 1000);
    }

    public void startGame()
    {
        seconds = 0;
        scan = new Scanner(System.in);
        timer = new Timer();
        task = new TimerTask(){
            public void run(){
                seconds++;
            }
        };
        String words = "";
        for (int i = 0; i < 30; i++)
        {
            int rand = (int) (Math.random() * 742) + 1;
            try (Stream<String> all_lines = Files.lines(Paths.get("newwords.txt"))) {
                words += all_lines.skip(rand-1).findFirst().get();
            }
            catch (IOException e)
            {

            }
            if (i != 29)
            {
                words += " ";
            }
        }
        U.println("Welcome to <Typing Game>!");
        U.println("All you have to do is type the following words below and press enter! You need to beat 30 wpm to win!");
        U.sleep(1000);
        System.out.println();
        System.out.println("-----------------------------------");
        System.out.println(words);
        System.out.println("-----------------------------------");
        System.out.println();
        startTimer();
        String input = scan.nextLine();
        timer.cancel(); 
        if (input.equals(words) && 30 / (seconds / 60.0) >= 30)
        {
            U.println("\nYou win!\nYour wpm was " + Math.round(30 / (seconds / 60.0)) + "!\nYou win 1000 points!");
            Points.changePoints(1000);
            numWins++;
        }
        else if(!input.equals(words))
        {
            U.println("\nYou lose!\nYou didn't type in the correct words!\nYou lose 100 points!");
            Points.changePoints(-100);
        }
        else
        {
            U.println("\nYou lose!\nYour wpm was " + Math.round(30 / (seconds / 60.0)) + ", which is too low!\nYou lose 100 points!");
            Points.changePoints(-100);
        }
    }
    public static String getStatus(){
      String str = "";
      if (unlocked){
        str += "Green Portal  | unlocked | Number of wins: " + numWins + " | Max wins: " + maxWin;
      } else {
        str += "Green Portal  |  locked  | Number of wins: " + numWins + " | Max wins: " + maxWin;
      }
      return str;
    }

  public static int getNumWins()
  {
    return numWins;
  }
}