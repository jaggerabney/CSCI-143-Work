import acm.graphics.*;

public class Paddle extends GRect implements Updateable {
  private Controls controls;

  public Paddle(double width, double height) {
    super(width, height);
  }

  public Paddle(double x, double y, double width, double height) {
    super(x, y, width, height);
  }

  public void addControls(Controls controls) {
    this.controls = controls;
  }

  @Override
  public void update() {
    // TODO: add code here!
  }
}
