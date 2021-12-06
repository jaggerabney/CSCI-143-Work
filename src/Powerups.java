import java.util.*;

public class Powerups {
  private Powerup[] powerups;
  private double powerupSize;
  private int updates;

  public Powerups(double powerupSize) {
    this.powerupSize = powerupSize;
    this.powerups = new Powerup[] { new Powerup(powerupSize, "Double Points"),
        new Powerup(powerupSize, "Big Paddle"), new Powerup(powerupSize, "Fast Ball") };
    this.updates = 0;
  }

  public Powerup[] getPowerups() {
    return powerups;
  }

  public void update(Game game, Ball ball) {
    Powerup powerup = null;

    for (int i = 0; i < powerups.length; i++) {
      powerup = powerups[i];

      if (!powerup.isActive()) {
        if (powerup.intersects(ball)) {
          powerup.activate(updates);
          game.activatePowerup(powerup);
          game.remove(powerup);
        } else {
          powerup.rotate(Math.cos(Math.toRadians(updates)));
        }
      } else {
        if (powerup.getUpdateTicks() > 0) {
          powerup.doUpdateTick();
        } else {
          powerup.deactivate();
          game.deactivatePowerup(powerup);
        }
      }

      updates++;
    }
  }

  public Powerup getActivePowerup() {
    Powerup activePowerup = null;

    for (Powerup powerup : powerups) {
      if (powerup.isActive()) {
        activePowerup = powerup;
      }
    }

    return activePowerup;
  }
}
