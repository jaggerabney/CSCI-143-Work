import acm.graphics.*;
import java.awt.*;

// Powerups that are collected by the player to help 
public class Powerup extends GPolygon {
  // fields
  private String effect;
  private boolean active, visible;
  private int updatesUntilDeactivation;

  public Powerup(double size, String effect) {
    // inits fields
    this.effect = effect;
    this.active = false;

    // does a bunch of math stuff that we don't really
    // understand to make the Powerup a five-pointed star
    double sinTheta = GMath.sinDegrees(18);
    double b = 0.5 * sinTheta / (1.0 + sinTheta);
    double edge = (0.5 - b) * size;
    addVertex(-size / 2, -b * size);
    int angle = 0;
    for (int i = 0; i < 5; i++) {
      addPolarEdge(edge, angle);
      addPolarEdge(edge, angle + 72);
      angle -= 72;
    }
    // GPolygon method that prevents any more points from
    // being added to the GPolygon; prevents tampering
    markAsComplete();

    setColor(Color.BLACK);
    setFillColor(Color.YELLOW);
    setFilled(true);
  }

  // custom implementation of intersects.
  // the method checks the four corners of the other
  // object's bounding box, and assumes that if any corner
  // is in it, then the two GObjects are intersecting
  public boolean intersects(GObject other) {
    GRectangle bounds = other.getBounds();
    double x0 = bounds.getX(), y0 = bounds.getY(),
        x1 = bounds.getX() + bounds.getWidth(),
        y1 = bounds.getY() + bounds.getHeight();

    if (contains(x0, y0)) { // top left corner
      return true;
    } else if (contains(x0, y1)) { // top right corner
      return true;
    } else if (contains(x1, y0)) { // bottom left corner
      return true;
    } else if (contains(x1, y1)) { // bottom right corner
      return true;
    } else {
      return false;
    }
  }

  public String getEffect() {
    return effect;
  }

  // used to keep track of the time that a Powerup is active
  // decrements every update until it hits zero, then deactivates.
  // since the program runs at a constant 60 updates a second,
  // this effectively serves as a timer
  public void doUpdateTick() {
    if (updatesUntilDeactivation > 0) {
      updatesUntilDeactivation--;
    }
  }

  public int getUpdateTicks() {
    return updatesUntilDeactivation;
  }

  // called when the Ball hits the powerup
  public void activate(int updates) {
    this.updatesUntilDeactivation = updates;
    this.active = true;
    this.visible = false;
  }

  // called when the Powerup's "timer" runs out
  public void deactivate() {
    this.updatesUntilDeactivation = 0;
    this.active = false;
  }

  // helpers
  public void makeVisible() {
    this.visible = true;
  }

  public boolean isVisible() {
    return visible;
  }

  public boolean isActive() {
    return active;
  }
}
