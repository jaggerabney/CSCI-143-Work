import java.util.*;

public class Powerups {
  private ArrayList<Powerup> powerups;
  private double powerupSize;

  public Powerups(double powerupSize) {
    this.powerups = new ArrayList<>();
    this.powerupSize = powerupSize;
    powerups.add(new Powerup(powerupSize));
  }

  public Powerup[] getPowerups() {
    return powerups.toArray(new Powerup[] {});
  }

  public void update() {
    // TODO: add code here!
  }
}
