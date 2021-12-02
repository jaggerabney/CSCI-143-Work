import acm.graphics.*;

public class Brick extends GRect {
  public Brick() {
    super(0, 0);
  }

  public Brick(double width, double height) {
    super(width, height);
  }

  public Brick(double x, double y, double width, double height) {
    super(x, y, width, height);
  }

  public void setWidth(int windowWidth, int numBricksPerRow, int brickSep) {
    int width = (windowWidth - (numBricksPerRow - 1) * brickSep) / numBricksPerRow;
    this.setSize(width, this.getHeight());
  }
}
