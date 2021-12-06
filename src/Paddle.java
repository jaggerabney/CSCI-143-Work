import acm.graphics.*;

// Paddle object that the player uses to reflect the Ball
public class Paddle extends GRect {
  private Controls controls;

  // constructors
  public Paddle(double width, double height) {
    super(width, height);
    this.setFilled(true);
  }

  public Paddle(double x, double y, double width, double height) {
    super(x, y, width, height);
    this.setFilled(true);
  }

  // used to tie the Controls object to the Paddle
  public void addControls(Controls controls) {
    this.controls = controls;
  }

  // used by the Big Paddle Powerup
  public void changeWidthBy(int scalingFactor) {
    this.setSize(getWidth() * scalingFactor, getHeight());
  }

  // changes the Paddle's location according to the mouse position
  public void update() {
    this.setLocation(this.controls.getMouseX(), this.getY());
  }
}
