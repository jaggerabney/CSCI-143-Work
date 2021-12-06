import acm.graphics.*;

public class Paddle extends GRect {
  private Controls controls;

  public Paddle(double width, double height) {
    super(width, height);
    this.setFilled(true);
  }

  public Paddle(double x, double y, double width, double height) {
    super(x, y, width, height);
    this.setFilled(true);
  }

  public void addControls(Controls controls) {
    this.controls = controls;
  }

  public void changeWidthBy(int scalingFactor) {
    this.setSize(getWidth() * scalingFactor, getHeight());
  }

  public void update() {
    this.setLocation(this.controls.getMouseX(), this.getY());
  }
}
