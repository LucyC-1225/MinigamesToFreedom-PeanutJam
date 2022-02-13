//blue
import java.util.*;

public class Blackjack {
  //portal stuff
  public static boolean unlocked;
  private static int numWins;
  private final static String maxWin = "\u221E";//"infinite";

    private Scanner scan;
    private ArrayList<Integer> playerNumCards;
    private ArrayList<String> playerCards;
    private ArrayList<Integer> dealerNumCards;
    private ArrayList<String> dealerCards;

    public Blackjack()
    {
        scan = new Scanner(System.in);
        playerNumCards = new ArrayList<>();
        playerCards = new ArrayList<>();
        dealerNumCards = new ArrayList<>();
        dealerCards = new ArrayList<>();
    }

    public void startGame()
    {
        playerNumCards.clear();
        playerCards.clear();
        dealerNumCards.clear();
        dealerCards.clear();
        U.println("Welcome to <Blackjack>!");
        boolean input = false;
        while (!input)
        {
            U.print("Do you know the rules already? (y) / (n)? ");
            String yn = scan.nextLine();
            if (yn.equalsIgnoreCase("y") || yn.equalsIgnoreCase("yes"))
            {
                U.println("Perfect!");
                input = true;
            }
            else if (yn.equalsIgnoreCase("n") || yn.equalsIgnoreCase("no"))
            {
                boolean repeat = false;
                while (!repeat)
                {
                    U.println("You will be playing against God!");
                    U.println("The goal of the game is to not have the sum of the values of your cards exceed 21!");
                    U.println("You and God will be dealt two cards(A, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K)");
                    U.println("The J, Q, and K are all worth 10 points");
                    U.println("The A will be worth 11 points unless the total value of your cards is over 21, then it will be worth 1 point");
                    U.println("All other cards will have face-value");
                    U.println("After you draw your two initial cards, you will be asked to hit or stand");
                    U.println("If you hit, you draw another card");
                    U.println("You can keep hitting until you want to keep");
                    U.println("If you hit and go over 21, you bust, meaning you lose!");
                    U.println("If you stand and haven't busted yet, God reveals his cards.");
                    U.println("If God has less than 17, he draws until he exceeds 17. Otherwise, he will stand.");
                    U.println("If God exceeds 21, he busts and loses");
                    U.println("Whoever has the higher sum wins!");
                    U.print("Do you want the instructions to be repeated? (y) / (n)? ");
                    while (true)
                    {
                        String yn2 = scan.nextLine();
                        if (yn2.equalsIgnoreCase("y") || yn2.equalsIgnoreCase("yes"))
                        {
                            break;
                        }
                        else if (yn2.equalsIgnoreCase("n") || yn2.equalsIgnoreCase("no"))
                        {
                            repeat = true;
                            input = true;
                            U.clearScreen();
                            break;
                        }
                        else
                        {
                            U.print("Do you want the instructions to be repeated? (y) / (n)? ");
                        }
                    }
                }
            }
        }
        U.print("Let's start!");
        System.out.println("\n--------------------------");
        System.out.println();
        runBlackJack();
    }

    public void runBlackJack()
    {
        draw(true);
        draw(true);
        boolean gameStop = false;
        boolean playerBusted = false;
        String cardsStr = "";
        for (String card : playerCards)
        {
            cardsStr += card;
            cardsStr += " ";
        }
        U.println("Your cards: " + cardsStr);
        U.println("Sum: " + sum(playerNumCards));
        System.out.println();
        while (!gameStop)
        {
            boolean input = false;
            U.print("Would you like to (hit) or (stand)? ");
            while (!input)
            {
                String hd = scan.nextLine();
                if (hd.equalsIgnoreCase("hit"))
                {
                    draw(true);
                    System.out.println();
                    U.println("You drawed a " + playerCards.get(playerCards.size()-1));
                    changeAce(true);
                    cardsStr = "";
                    for (String card : playerCards)
                    {
                        cardsStr += card;
                        cardsStr += " ";
                    }
                    U.println("Your cards: " + cardsStr);
                    U.println("Sum: " + sum(playerNumCards));
                    System.out.println();
                    if (sum(playerNumCards) > 21)
                    {
                        playerBusted = true;
                        System.out.println("You busted! You exceeded 21!");
                        U.println("You lose 250 points!");
                        Points.changePoints(-250);
                    }
                    input = true;
                }
                else if (hd.equalsIgnoreCase("stand"))
                {
                    draw(false);
                    draw(false);
                    System.out.println();
                    while (sum(dealerNumCards) < 17)
                    {
                        draw(false);
                        changeAce(false);
                    }
                    String dealerCardsStr = "";
                    for (String card : dealerCards)
                    {
                        dealerCardsStr += card;
                        dealerCardsStr += " ";
                    }
                    U.println("God's cards: " + dealerCardsStr);
                    input = true;
                    gameStop = true;
                }
                else
                {
                    U.print("Would you like to (hit) or (stand)? ");
                }
            }
            if (checkLoss(true) || checkLoss(false) || playerBusted)
            {
                gameStop = true;
                System.out.println();
            }
        }
        if (!playerBusted)
        {
            if (sum(playerNumCards) == 21 && sum(dealerNumCards) == 21)
            {
                U.println("Both you and God hit blackjack!");
                U.println("You get 500 points!");
                Points.changePoints(500);
            }
            else if (sum(playerNumCards) == 21 && sum(dealerNumCards) != 21)
            {
                numWins++;
                U.println("You hit blackjack!");
                U.println("You win 2000 points!");
                Points.changePoints(2000);
            }
            else if (sum(playerNumCards) != 21 && sum(dealerNumCards) == 21)
            {
                U.println("God hit blackjack!");
                U.println("You lose 250 points!");
                Points.changePoints(-250);
            }
            else if (sum(dealerNumCards) > 21)
            {
                numWins++;
                U.println("God busted! He exceeded 21!");
                U.println("You win 1000 points!");
                Points.changePoints(1000);
            }
            else if (sum(playerNumCards) > sum(dealerNumCards))
            {
                numWins++;
                U.println("You had a " + sum(playerNumCards) + " and God had a " + sum(dealerNumCards));
                U.println("You had a greater sum");
                U.println("You win 1000 points!");
                Points.changePoints(1000);
                numWins++;
            }
            else if (sum(playerNumCards) < sum(dealerNumCards))
            {
                U.println("You had a " + sum(playerNumCards) + " and God had a " + sum(dealerNumCards));
                U.println("God had a greater sum");
                U.println("You lose 250 points!");
                Points.changePoints(-250);
            }
            else if (sum(playerNumCards) == sum(dealerNumCards))
            {
                U.println("You had a " + sum(playerNumCards) + " and God had a " + sum(dealerNumCards));
                U.println("You and God tied");
                U.println("You win 500 points!");
                Points.changePoints(500);
            }
        }
    }

    private int sum(ArrayList<Integer> list)
    {
        int sum = 0;
        for (int num : list)
        {
            sum += num;
        }
        return sum;
    }

    private void draw(boolean pd)
    {
        int cardNum = U.random(1, 13);
        String card = "";

        if (cardNum == 1)
            {card = "A";}
        else if (cardNum == 11)
            {card = "J";}
        else if (cardNum == 12)
            {card = "Q";}
        else if (cardNum == 13)
            {card = "K";}
        else
            {card = "" + cardNum;}

        if (cardNum == 11 || cardNum == 12 || cardNum == 13)
            {cardNum = 10;}
        else if (cardNum == 1)
            {cardNum = 11;}

        if (pd)
        {
            playerNumCards.add(cardNum);
            playerCards.add(card);
        }
        else if (!pd)
        {
            dealerNumCards.add(cardNum);
            dealerCards.add(card);
        }
    }

    private boolean checkLoss(boolean pd)
    {
        if (pd)
        {
            if (sum(playerNumCards) > 21)
            {
                return true;
            }
        }
        else if (!pd)
        {
            if (sum(dealerNumCards) > 21)
            {
                return true;
            }
        }
        return false;
    }


    private void changeAce(boolean pd)
    {
        if (pd)
        {
            if (sum(playerNumCards) > 21)
            {
                for (int i = 0; i < playerNumCards.size(); i++)
                {
                    if (playerNumCards.get(i) == 11)
                    {
                        playerNumCards.set(i, 1);
                        break;
                    }
                }
            }
        }
        else if (!pd)
        {
            if (sum(dealerNumCards) > 21)
            {
                for (int i = 0; i < dealerNumCards.size(); i++)
                {
                    if (dealerNumCards.get(i) == 11)
                    {
                        dealerNumCards.set(i, 1);
                        break;
                    }
                }
            }
        }
    }
    public static String getStatus(){
    String str = "";
    if (unlocked){
      str += "Blue Portal   | unlocked | Number of wins: " + numWins + " | Max wins: " + maxWin;
    } else {
      str += "Blue Portal   |  locked  | Number of wins: " + numWins + " | Max wins: " + maxWin;
    }
    return str;
  }
  public int getNumWins()
  {
    return numWins;
  }
}
