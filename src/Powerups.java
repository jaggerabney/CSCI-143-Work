import java.util.*;

public class Powerups {
  private Powerup[] powerups;
  private double powerupSize;
  private int updates, defaultUpdatesUntilPlacement, updatesUntilNextPlacement;

  public Powerups(double powerupSize, int updatesUntilNextPlacement) {
    this.powerupSize = powerupSize;
    this.defaultUpdatesUntilPlacement = updatesUntilNextPlacement;
    this.updatesUntilNextPlacement = updatesUntilNextPlacement;
    this.powerups = new Powerup[] { new Powerup(powerupSize, "Double Points"),
        new Powerup(powerupSize, "Big Paddle"), new Powerup(powerupSize, "Fast Ball") };
    this.updates = 0;
  }

  public Powerup[] getPowerups() {
    return powerups;
  }

  public void update(Game game, Ball ball) {
    Powerup powerup = null;

    if (updatesUntilNextPlacement > 0 && getActivePowerup() == null) {
      updatesUntilNextPlacement--;
    } else if (updatesUntilNextPlacement == 0) {
      Random rng = new Random();
      Powerup placedPowerup = powerups[rng.nextInt(powerups.length - 1)];
      placedPowerup.makeVisible();

      game.add(placedPowerup, 200, 250);

      updatesUntilNextPlacement = defaultUpdatesUntilPlacement;
    }

    for (int i = 0; i < powerups.length; i++) {
      powerup = powerups[i];

      if (!powerup.isActive()) {
        if (powerup.isVisible() && powerup.intersects(ball)) {
          powerup.activate();
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
