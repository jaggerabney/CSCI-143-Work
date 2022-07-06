import acm.graphics.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends GCanvas {
  // references to all Game objects
  private Config config;
  private Scoreboard scoreboard;
  private Controls controls;
  private Ball ball;
  private Paddle paddle;
  private Bricks bricks;
  private Powerups powerups;
  private GRectangle bounds;
  // used for keeping track of Powerup effects
  private boolean doublePointsActive, fastBallActive, served;
  private int numLives, updatesUntilServe;

  public Game(Config config, Scoreboard scoreboard) {
    // inits fields
    super();
    this.config = config;
    this.scoreboard = scoreboard;
    this.controls = new Controls();
    addMouseMotionListener(controls);

    this.paddle = new Paddle(0, this.config.getIntProp("HEIGHT") - this.config.getIntProp("PADDLE_Y_OFFSET"),
        this.config.getIntProp("PADDLE_WIDTH"), this.config.getIntProp("PADDLE_HEIGHT"));
    this.paddle.addControls(this.controls);
    this.ball = new Ball(this.config.getIntProp("WIDTH") / 2, this.config.getIntProp("HEIGHT") / 2,
        this.config.getIntProp("BALL_RADIUS") * 2, this.config.getIntProp("BALL_RADIUS") * 2,
        config.getIntProp("COLLISIONS_THRESHOLD"), config.getIntProp("BALL_UPDATES_UNTIL_COLLIDABLE"));
    this.bricks = new Bricks(config);
    this.powerups = new Powerups(config.getDoubleProp("POWERUP_SIZE"), config.getIntProp("POWERUP_PLACEMENT_TIME"));
    this.numLives = config.getIntProp("NUM_LIVES");
    this.served = true;

    // adds the Ball, Paddle, and Bricks to the window
    add(ball);
    add(paddle);
    for (int i = 0; i < config.getIntProp("BRICK_ROWS"); i++) {
      for (int j = 0; j < config.getIntProp("BRICKS_PER_ROW"); j++) {
        add(bricks.getBrick(i, j));
      }
    }
  }

  public void update() {
    // updates the Game objects - called in Breakout to limit number of updates.
    // components are tested for null because this can sometimes run
    // before they're initialized
    if (bricks.allBricksDestroyed() && served) {
      win();
    }

    if (updatesUntilServe > 0) {
      updatesUntilServe--;

      System.out.println(updatesUntilServe);

      if (numLives == 0) {
        scoreboard.setText("Thanks for playing!");
      } else if (numLives == -1) {
        scoreboard.setText("You win!");
      } else {
        scoreboard.setText("Too bad! Lives left: " + numLives);
      }
    } else if (updatesUntilServe == 0 && !served) {
      if (numLives <= 0) {
        System.exit(0);
      } else {
        ball.setLocation(this.config.getIntProp("WIDTH") / 2, this.config.getIntProp("HEIGHT") / 2);
        ball.resetNumCollisions();
        ball.randomVelocity();
        add(ball);
        served = true;
      }
    } else {
      ball.update(bricks.getAllBricks(), paddle, this, fastBallActive);
      paddle.update();
      if (bricks != null) {
        bricks.update(this, scoreboard, doublePointsActive);
      }
      if (scoreboard != null) {
        scoreboard.update(powerups);
      }
      powerups.update(this, ball, config);
    }
  }

  public void serve() {
    served = false;
    updatesUntilServe = config.getIntProp("SERVE_NOTIFICATION_TIME");
    numLives--;
    remove(ball);
  }

  private void win() {
    served = false;
    updatesUntilServe = config.getIntProp("SERVE_NOTIFICATION_TIME");
    numLives = 0;
  }

  // switches the corresponding boolean for the given Powerup to true
  public void activatePowerup(Powerup powerup) {
    String effect = powerup.getEffect();
    scoreboard.powerupActivated(effect, config.getIntProp("POWERUP_NOTIFICATION_TIME"));

    switch (effect) {
      case "Double Points":
        doublePointsActive = true;
        break;
      case "Big Paddle":
        paddle.setSize(config.getDoubleProp("PADDLE_WIDTH") * config.getDoubleProp("BIG_PADDLE_MULTIPLIER"),
            paddle.getHeight());
        break;
      case "Fast Ball":
        fastBallActive = true;
        break;
    }
  }

  // switches the corresponding boolean for the given Powerup to false
  public void deactivatePowerup(Powerup powerup) {
    String effect = powerup.getEffect();

    switch (effect) {
      case "Double Points":
        doublePointsActive = false;
        break;
      case "Big Paddle":
        paddle.setSize(config.getDoubleProp("PADDLE_WIDTH"), paddle.getHeight());
        break;
      case "Fast Ball":
        fastBallActive = false;
        break;
    }
  }

  // called when the window is resized; resizes components accordingly
  public void windowResizeHandler(ComponentEvent e) {
    int windowWidth = e.getComponent().getWidth(),
        windowHeight = e.getComponent().getHeight();
    Dimension windowSize = new Dimension(windowWidth, windowHeight);

    this.setSize(windowSize);
    this.bounds = new GRectangle(windowWidth, windowHeight);
    bricks.setBrickWidth(config, windowSize);
    paddle.setLocation(paddle.getX(), windowHeight - config.getIntProp("PADDLE_Y_OFFSET"));
  }

  public GRectangle getGRectangleBounds() {
    return bounds;
  }
}