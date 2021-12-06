import acm.graphics.*;
import java.awt.*;

public class Powerup extends GPolygon {
  private String effect;
  private boolean active, visible;
  private int updatesUntilDeactivation;

  public Powerup(double size, String effect) {
    this.effect = effect;
    this.active = false;

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
    markAsComplete();

    setColor(Color.BLACK);
    setFillColor(Color.YELLOW);
    setFilled(true);
  }

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

  public void doUpdateTick() {
    if (updatesUntilDeactivation > 0) {
      updatesUntilDeactivation--;
      System.out.println(updatesUntilDeactivation);
    }
  }

  public int getUpdateTicks() {
    return updatesUntilDeactivation;
  }

  public void activate() {
    this.updatesUntilDeactivation = 600;
    this.active = true;
    this.visible = false;
  }

  public void deactivate() {
    this.updatesUntilDeactivation = 0;
    this.active = false;
    System.out.println("Deactivated");
  }

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
