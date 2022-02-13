public class Main {
  public static void main(String[] args) throws Exception{
    Game game = new Game();
    game.startGame();
  }
}

/*
IDEA (FINALLY!)
- you got teleported to another world after getting hit by truck-kun. There are different islands where you have to explore and play games, but islands require portals to enter. Earn points from games to unlock portals! Earn enough points to unlock all portals in order to meet God and buy the 10000 point gem to bribe God to let you return to your world!
- games can be repeated for more points, but you have to pass all the games in all the portals at least once
- If the player reaches 0 points, God will kill the player
- Shop Island (ik very creative): trade your points for the gem and to unlock portals
- Players can access a map that shows which portals they have purchased (unlocked) and which portals they can enter(players use the map to enter the portals)
- Starting points for players: 150 points

Shop Island
- Gem: 10000 points 
- White portal: 0 points (leads to island 1)
- Red portal: 500 points (leads to island 2)
- Orange portal: 500 points (leads to island 3)
- Yellow portal: 500 points (leads to island 4)
- Green portal: 500 points (leads to island 5)
- Blue portal: 500 points (leads to island 6)
- Purple portal: 500 points (leads to island 7)
- Black portal: 500 points (leads to island 8)

Island 1: Guess the Number
- requirements: white portal
- points gain if won: depends
- points lost if quit: depends

Island 2: Rock Paper Scissors (win 3 rounds)
- requirements: red portal
- points gain if won: 500 or 700 if win all 3 rounds
- points lost if lost: 100

Island 3: Hangman
- requirements: orange portal
- points gain if won: 1000
- points lost if lost: 100

Island 4: Portal Trivia
- requirements: yellow portal
- points gain if won (answered 4/7 questions corrently): numRright * 200
- points lost if lost: numWrong * 20

Island 5: Memory Game 
- requirements: green portal
- points gain if won: 1000
- points lost if lost: 100

Island 6: Typing game (give the user a large paragraph of text that they have to copy exactly word for word or else they lose, no time limit cause idk how to do time)
- requirements: blue portal
- points gain if won: 1000
- points lost if lost: 100

*/