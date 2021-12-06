import acm.graphics.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends GCanvas {
  private Config config;
  private Scoreboard scoreboard;
  private Controls controls;
  private Ball ball;
  private Paddle paddle;
  private Bricks bricks;
  private Powerups powerups;
  private GRectangle bounds;
  private boolean doublePointsActive, bigPaddleActive, fastBallActive;

  public Game(Config config, Scoreboard scoreboard) {
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
        config.getIntProp("COLLISIONS_THRESHOLD"));
    this.bricks = new Bricks(config);
    this.powerups = new Powerups(config.getDoubleProp("POWERUP_SIZE"), 300);

    add(ball);
    add(paddle);
    for (int i = 0; i < config.getIntProp("BRICK_ROWS"); i++) {
      for (int j = 0; j < config.getIntProp("BRICKS_PER_ROW"); j++) {
        add(bricks.getBrick(i, j));
      }
    }
  }

  public void update() {
    ball.update(bricks.getAllBricks(), paddle, bounds, fastBallActive);
    paddle.update();
    if (bricks != null) {
      bricks.update(this, scoreboard, doublePointsActive);
    }
    if (scoreboard != null) {
      scoreboard.update(powerups);
    }
    powerups.update(this, ball);
  }

  public void activatePowerup(Powerup powerup) {
    String effect = powerup.getEffect();
    scoreboard.powerupActivated(effect, 120);

    switch (effect) {
      case "Double Points":
        doublePointsActive = true;
        break;
      case "Big Paddle":
        bigPaddleActive = true;
        paddle.setSize(config.getDoubleProp("PADDLE_WIDTH") * 3, paddle.getHeight());
        break;
      case "Fast Ball":
        fastBallActive = true;
        break;
    }
  }

  public void deactivatePowerup(Powerup powerup) {
    String effect = powerup.getEffect();

    switch (effect) {
      case "Double Points":
        doublePointsActive = false;
        break;
      case "Big Paddle":
        bigPaddleActive = false;
        paddle.setSize(config.getDoubleProp("PADDLE_WIDTH"), paddle.getHeight());
        break;
      case "Fast Ball":
        fastBallActive = false;
        break;
    }
  }

  public void windowResizeHandler(ComponentEvent e) {
    int windowWidth = e.getComponent().getWidth(),
        windowHeight = e.getComponent().getHeight();
    Dimension windowSize = new Dimension(windowWidth, windowHeight);

    this.setSize(windowSize);
    this.bounds = new GRectangle(windowWidth, windowHeight);
    bricks.setBrickWidth(config, windowSize);
    paddle.setLocation(paddle.getX(), windowHeight - config.getIntProp("PADDLE_Y_OFFSET"));
  }
}