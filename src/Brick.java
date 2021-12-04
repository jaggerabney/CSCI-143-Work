import acm.graphics.*;
import java.awt.*;

public class Brick extends GRect {
  private boolean destroyed;

  // these have to be here to prevent compiler errors
  public Brick(double width, double height) {
    super(width, height);
    this.destroyed = false;
  }

  public Brick(double x, double y, double width, double height) {
    super(x, y, width, height);
    this.destroyed = false;
  }

  // this is the constructor used in Bricks
  public Brick(double x, double y, double width, double height, Color color) {
    super(x, y, width, height);
    this.destroyed = false;
    this.setFilled(true);
    this.setColor(color);
  }

  public void setWidth(int windowWidth, int bricksPerRow, int brickSep) {
    int width = (windowWidth - (bricksPerRow - 1) * brickSep) / bricksPerRow;
    this.setSize(width, this.getHeight());
  }

  public void setHeight(int height) {
    this.setSize(this.getWidth(), height);
  }

  public void destroy() {
    this.destroyed = true;
  }

  public boolean isDestroyed() {
    return destroyed;
  }

  public void doRainbowStep() {
    Color currentColor = this.getColor();
  }
}
