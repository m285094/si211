import java.util.*;

public class Geyser
{
  private String name;
  private double baseProbFactor;
  private int daysSinceLastBlow;

    // reads (and returns) geyser in the following format
  // <name> <initBlowProb> <days>
  public static Geyser read(Scanner sc)
  {
    Geyser g = new Geyser();
    g.name = sc.next();
    g.baseProbFactor = 1.0 - sc.nextDouble();
    g.daysSinceLastBlow = sc.nextInt();
    return g;
  }

  // Simulate one day.  If g doesn't blow, return -1
  // if g blows, return number of days since last blow
  public int simDay(Random r)
  {
    int tmp = ++daysSinceLastBlow;
    double blowProb = 1 - Math.pow(baseProbFactor,tmp);
    if (r.nextDouble() <= blowProb)
      daysSinceLastBlow = 0;
    else
      tmp = -1;
    return tmp;
  }

  public String getName() {
    return name;
  }
}