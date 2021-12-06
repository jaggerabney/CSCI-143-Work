import acm.graphics.*;
import acm.util.RandomGenerator;

public class Ball extends GOval {
  // velocities in the x and y directions
  private double velocityX, velocityY;
  // booleans for keeping track of if the ball is intersecting
  // the paddle, wall, or bricks
  private boolean intersectingPaddle, intersectingWall, intersectingBrick;
  // int fields used for speeding up the ball after a certain number of collisions
  // and for (trying to) prevent the ball from bouncing too fast
  private int numCollisions, collisionsThreshold, defaultUpdatesUntilCollidable, updatesUntilCollidable;

  public Ball(double width, double height) {
    // inits fields
    super(width, height);
    this.intersectingPaddle = false;
    this.intersectingWall = false;
    this.intersectingBrick = false;
    this.numCollisions = 0;
    this.defaultUpdatesUntilCollidable = 0;
    this.updatesUntilCollidable = 0;
    // "throws" the ball in a random direction, and sets it filled
    randomVelocity();
    setFilled(true);
  }

  public Ball(double x, double y, double width, double height, int collisionsThreshold, int updatesUntilCollidable) {
    // inits fields
    super(x, y, width, height);
    this.intersectingPaddle = false;
    this.intersectingWall = false;
    this.intersectingBrick = false;
    this.collisionsThreshold = collisionsThreshold;
    this.numCollisions = 0;
    this.defaultUpdatesUntilCollidable = updatesUntilCollidable;
    this.updatesUntilCollidable = 0;
    // "throws" the ball in a random direction, and sets it to filled
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

  // updates the Ball's velocity by performing collision checks against the
  // Bricks, Paddle, and walls
  public void update(Brick[][] bricks, Paddle paddle, Game game, boolean fastBallActive) {
    // bounding boxes, for convenience
    if (getY() > game.getGRectangleBounds().getHeight()) {
      game.serve();
    }

    GRectangle ballBoundingBox = this.getBounds();
    GRectangle brickBoundingBox = null;

    for (Brick[] row : bricks) {
      for (Brick brick : row) {
        brickBoundingBox = (brick != null) ? brick.getBounds() : null;

        // if:
        // 1. the Brick is not null,
        // 2. the Ball intersects the given Brick,
        // 3. it is not already intersecting a Brick,
        // 4. the Brick is not already destroyed, then the brick is destroyed, and
        // 5. if the Ball is eligible to collide
        // and the Ball's velocity is flipped accordingly
        if (brickBoundingBox != null && ballBoundingBox.intersects(brickBoundingBox) && !intersectingBrick
            && !brick.isDestroyed() && updatesUntilCollidable == 0) {
          intersectingBrick = true;
          brick.destroy();
          String soi = findSideOfIntersection(brickBoundingBox);
          updatesUntilCollidable = defaultUpdatesUntilCollidable;

          // if the top or bottom of the Brick is intersected, the y velocity
          // is flipped; otherwise, the x velocity is
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

    // instantiates paddleBoundingBox after to potentially save processing power;
    // after all, the function returns if the Ball collides with an object, so
    // there's no point in instantiating this until after you know it's not
    // intersecting any Bricks
    GRectangle paddleBoundingBox = paddle.getBounds();

    // if the Ball intersects the Paddle, if it is not already doing so, and
    // if the Ball is eligible to collide, then reflect it accordingly
    if (ballBoundingBox.intersects(paddleBoundingBox) && !intersectingPaddle && updatesUntilCollidable == 0) {
      intersectingPaddle = true;
      String soi = findSideOfIntersection(paddleBoundingBox);
      updatesUntilCollidable = defaultUpdatesUntilCollidable;

      // if the top or bottom is hit, then the y velocity is flipped; otherwise,
      // the x *and* y velocity is flipped
      if (soi.contentEquals("top") || soi.contentEquals("bottom")) {
        flipVelocityY();
      } else {
        flipVelocityY();
        flipVelocityX();
      }

      numCollisions++;
      return;
    }

    // checks if the Ball is colliding with the bounds of the window (i.e. the wall)
    // if it's hitting the side walls, the x velocity is reflected; otherwise, the
    // y velocity is reflected
    GRectangle gameBounds = game.getGRectangleBounds();

    if (gameBounds != null) {
      if ((ballBoundingBox.getX() < 0 || ballBoundingBox.getX() + ballBoundingBox.getWidth() > gameBounds.getWidth())
          && !intersectingWall && updatesUntilCollidable == 0) {
        updatesUntilCollidable = defaultUpdatesUntilCollidable;
        intersectingWall = true;
        flipVelocityX();
        return;
      } else if (ballBoundingBox.getY() < 0 && !intersectingWall && updatesUntilCollidable == 0) {
        intersectingWall = true;
        updatesUntilCollidable = defaultUpdatesUntilCollidable;
        flipVelocityY();
        return;
      }
    }

    // if the number of collisions has surpassed the predetermined threshold
    // - seven, by default - then the Ball's velocity is increased by 5%
    if (numCollisions > collisionsThreshold) {
      numCollisions = 0;
      velocityX *= 1.05;
      velocityY *= 1.05;
    }

    if (updatesUntilCollidable == 0) {
      intersectingBrick = false;
      intersectingPaddle = false;
      intersectingWall = false;
    } else {
      updatesUntilCollidable--;
    }

    // moves the Ball according to the velocity
    // if the Fast Ball Powerup is active, then the Ball's velocity is sped up 50%
    this.move((fastBallActive) ? velocityX * 1.5 : velocityX, (fastBallActive) ? velocityY * 1.5 : velocityY);
  }

  // finds the side of intersection between two rectangles using their
  // Minkowski sum
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

  // helper methods to better illustrate that velocities are being flipped
  public void flipVelocityX() {
    this.velocityX *= -1;
  }

  public void flipVelocityY() {
    this.velocityY *= -1;
  }
}
