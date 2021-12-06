import java.util.*;

public class Powerups {
  private Powerup[] powerups;
  private double powerupSize;
  private int updatesActive;

  public Powerups(double powerupSize) {
    this.powerups = new Powerup[3];
    this.powerupSize = powerupSize;
    this.updatesActive = 0;
    powerups[0] = new Powerup(powerupSize);
  }

  public Powerup[] getPowerups() {
    return powerups;
  }

  public void update() {
    for (Powerup powerup : powerups) {
      if (powerup != null) {
        powerup.rotate(Math.cos(Math.toRadians(updatesActive)));
      }
    }
    updatesActive++;
  }
}
