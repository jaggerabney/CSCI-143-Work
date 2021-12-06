import java.util.*;

// Helper class used to keep track of Powerups
public class Powerups {
  // fields
  private Powerup[] powerups;
  private int updates, defaultUpdatesUntilPlacement, updatesUntilNextPlacement;

  // inits fields, and three Powerups:
  // Double Points, Big Paddle, and Fast Ball
  public Powerups(double powerupSize, int updatesUntilNextPlacement) {
    this.defaultUpdatesUntilPlacement = updatesUntilNextPlacement;
    this.updatesUntilNextPlacement = updatesUntilNextPlacement;
    this.powerups = new Powerup[] { new Powerup(powerupSize, "Double Points"),
        new Powerup(powerupSize, "Big Paddle"), new Powerup(powerupSize, "Fast Ball") };
    this.updates = 0;
  }

  public Powerup[] getPowerups() {
    return powerups;
  }

  public void update(Game game, Ball ball, Config config) {
    Powerup powerup = null;

    // if a Powerup cannot be placed, decrement the "timer"
    if (updatesUntilNextPlacement > 0 && getActivePowerup() == null) {
      updatesUntilNextPlacement--;
    } else if (updatesUntilNextPlacement == 0) {
      // if the "timer" is up *and* there isn't already a Powerup
      // on the screen, place one randomly on the screen
      if (getVisiblePowerup() == null) {
        Random rng = new Random();
        Powerup placedPowerup = powerups[rng.nextInt(powerups.length - 1)];
        placedPowerup.makeVisible();
        double powerupX = game.getBounds().getCenterX()
            + rng.nextDouble(game.getBounds().getCenterX() / 2) * (rng.nextBoolean() ? -1 : 1);
        double powerupY = game.getBounds().getCenterY()
            + rng.nextDouble(game.getBounds().getCenterY() / 2) * (rng.nextBoolean() ? -1 : 1);

        game.add(placedPowerup, powerupX, powerupY);

        updatesUntilNextPlacement = defaultUpdatesUntilPlacement;
      }
    }

    // loops through powerups to manage their states
    for (int i = 0; i < powerups.length; i++) {
      powerup = powerups[i];

      // if the given powerup is *not* active,
      // (this is different from visible! Powerups are activated
      // when the Ball hits them)...
      if (!powerup.isActive()) {
        // if it's on the screen and the Ball hits it,
        // activate it!
        if (powerup.isVisible() && powerup.intersects(ball)) {
          powerup.activate(config.getIntProp("POWERUP_TIME"));
          game.activatePowerup(powerup);
          game.remove(powerup);
        } else {
          // otherwise, play an idle animation
          powerup.rotate(Math.cos(Math.toRadians(updates)));
        }
      } else {
        // this block can only be reached if the given Powerup
        // is active, in which case one of two things happen:
        // 1. the "timer" is decremented, or
        // 2. the Powerup is deactivated (if the "timer" runs out)
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

  // helpers
  public Powerup getActivePowerup() {
    Powerup activePowerup = null;

    for (Powerup powerup : powerups) {
      if (powerup.isActive()) {
        activePowerup = powerup;
      }
    }

    return activePowerup;
  }

  public Powerup getVisiblePowerup() {
    Powerup visiblePowerup = null;

    for (Powerup powerup : powerups) {
      if (powerup.isVisible()) {
        visiblePowerup = powerup;
      }
    }

    return visiblePowerup;
  }
}
