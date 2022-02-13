public class Points{
  private static int points = 250;

  public static void changePoints(int pointsChanged)
  {
    points += pointsChanged;
  }

  public static int getPoints()
  {
    return points;
  }
}