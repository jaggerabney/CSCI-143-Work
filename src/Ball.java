import acm.graphics.*;
import acm.util.RandomGenerator;

public class Ball extends GOval implements Updateable {
  private double velocityX, velocityY;

  public Ball(double width, double height) {
    super(width, height);
    randomVelocity();
  }

  public Ball(double x, double y, double width, double height) {
    super(x, y, width, height);
    randomVelocity();
    this.velocityY = 3.0;
  }

  private void randomVelocity() {
    RandomGenerator rg = RandomGenerator.getInstance();
    this.velocityX = rg.nextDouble(1.0, 3.0);
    if (rg.nextBoolean(0.5)) {
      velocityX = -velocityX;
    }
  }

  @Override
  public void update(GObject other) {
    this.setFilled(true);
    this.move(velocityX, velocityY);
  }

  public void flipVelocityX() {
    this.velocityX *= -1;
  }

  public void flipVelocityY() {
    this.velocityY *= -1;
  }
}
