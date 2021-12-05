import acm.graphics.*;
import acm.util.RandomGenerator;

public class Ball extends GOval {
  private double velocityX, velocityY;
  private boolean intersectingPaddle, intersectingWall, intersectingBrick;
  private int numCollisions, collisionsThreshold, defaultUpdatesUntilCollidable, updatesUntilCollidable;

  public Ball(double width, double height) {
    super(width, height);
    this.intersectingPaddle = false;
    this.intersectingWall = false;
    this.intersectingBrick = false;
    this.numCollisions = 0;
    this.defaultUpdatesUntilCollidable = 2;
    this.updatesUntilCollidable = 0;
    randomVelocity();
    setFilled(true);
  }

  public Ball(double x, double y, double width, double height, int collisionsThreshold) {
    super(x, y, width, height);
    this.intersectingPaddle = false;
    this.intersectingWall = false;
    this.intersectingBrick = false;
    this.collisionsThreshold = collisionsThreshold;
    this.numCollisions = 0;
    this.defaultUpdatesUntilCollidable = 2;
    this.updatesUntilCollidable = 0;
    randomVelocity();
    this.velocityY = 3.0;
    setFilled(true);
  }

  private void randomVelocity() {
    RandomGenerator rg = RandomGenerator.getInstance();
    this.velocityX = rg.nextDouble(1.0, 3.0);
    if (rg.nextBoolean(0.5)) {
      velocityX = -velocityX;
    }
  }

  public void update(Brick[][] bricks, Paddle paddle, GRectangle gameBounds) {
    GRectangle ballBoundingBox = this.getBounds();
    GRectangle brickBoundingBox = null;

    for (Brick[] row : bricks) {
      for (Brick brick : row) {
        brickBoundingBox = brick.getBounds();

        if (ballBoundingBox.intersects(brickBoundingBox) && !intersectingBrick && !brick.isDestroyed()) {
          intersectingBrick = true;
          brick.destroy();
          String soi = findSideOfIntersection(brickBoundingBox);

          if (soi.contentEquals("top") || soi.contentEquals("bottom")) {
            flipVelocityY();
          } else {
            flipVelocityX();
          }

          numCollisions++;
          return;
        }
      }
    }

    GRectangle paddleBoundingBox = paddle.getBounds();

    if (ballBoundingBox.intersects(paddleBoundingBox) && !intersectingPaddle) {
      intersectingPaddle = true;
      String soi = findSideOfIntersection(paddleBoundingBox);

      if (soi.contentEquals("top") || soi.contentEquals("bottom")) {
        flipVelocityY();
      } else {
        flipVelocityY();
        flipVelocityX();
      }

      numCollisions++;
      return;
    }

    if (gameBounds != null) {
      if ((ballBoundingBox.getX() < 0 || ballBoundingBox.getX() + ballBoundingBox.getWidth() > gameBounds.getWidth())
          && !intersectingWall) {
        intersectingWall = true;
        flipVelocityX();
        return;
      } else if (ballBoundingBox.getY() < 0 && !intersectingWall) {
        intersectingWall = true;
        flipVelocityY();
        return;
      }
    }

    if (numCollisions > collisionsThreshold) {
      numCollisions = 0;
      velocityX *= 1.05;
      velocityY *= 1.05;
    }

    if (updatesUntilCollidable == 0) {
      intersectingBrick = false;
      intersectingPaddle = false;
      intersectingWall = false;
      updatesUntilCollidable = defaultUpdatesUntilCollidable;
    } else {
      updatesUntilCollidable--;
    }

    this.move(velocityX, velocityY);
  }

  public String findSideOfIntersection(GRectangle other) {
    double wy = (this.getWidth() + other.getWidth())
        * ((this.getY() + (this.getHeight() / 2)) - (other.getY() + (other.getHeight() / 2)));
    double hx = (this.getHeight() + other.getHeight())
        * ((this.getX() + (this.getWidth() / 2)) - (other.getX() + (other.getWidth() / 2)));

    if (wy > hx) {
      if (wy > -hx) {
        return "top";
      } else {
        return "left";
      }
    } else {
      if (wy > -hx) {
        return "right";
      } else {
        return "bottom";
      }
    }
  }

  public void flipVelocityX() {
    this.velocityX *= -1;
  }

  public void flipVelocityY() {
    this.velocityY *= -1;
  }
}
