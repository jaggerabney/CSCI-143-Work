import acm.graphics.*;

public class Paddle extends GRect implements Updateable {
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

  @Override
  public void update(GObject other) {
    // TODO: add code here!
    this.setLocation(this.controls.getMouseX(), this.controls.getMouseY());
  }
}
