import acm.graphics.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends GCanvas {
  private Config config;
  private Controls controls;
  private Ball ball;
  private Paddle paddle;
  private Bricks bricks;
  private Powerups powerups;
  private GRectangle bounds;

  public Game(Config config) {
    super();
    this.config = config;
    this.controls = new Controls();
    addMouseMotionListener(controls);

    this.paddle = new Paddle(0, this.config.getIntProp("HEIGHT") - this.config.getIntProp("PADDLE_Y_OFFSET"),
        this.config.getIntProp("PADDLE_WIDTH"), this.config.getIntProp("PADDLE_HEIGHT"));
    this.paddle.addControls(this.controls);
    this.ball = new Ball(this.config.getIntProp("WIDTH") / 2, this.config.getIntProp("HEIGHT") / 2,
        this.config.getIntProp("BALL_RADIUS") * 2, this.config.getIntProp("BALL_RADIUS") * 2,
        config.getIntProp("COLLISIONS_THRESHOLD"));
    this.bricks = new Bricks(config);

    add(ball);
    add(paddle);
    for (int i = 0; i < config.getIntProp("BRICK_ROWS"); i++) {
      for (int j = 0; j < config.getIntProp("BRICKS_PER_ROW"); j++) {
        add(bricks.getBrick(i, j));
      }
    }
  }

  public void update() {
    ball.update(bricks.getAllBricks(), paddle, bounds);
    paddle.update(null);
    if (bricks != null) {
      bricks.update(this);
    }
    // powerups.update();
  }

  public void windowResizeHandler(ComponentEvent e) {
    int defaultWindowHeight = config.getIntProp("HEIGHT"),
        windowWidth = e.getComponent().getWidth(),
        windowHeight = e.getComponent().getHeight();
    Dimension windowSize = new Dimension(windowWidth, windowHeight);

    this.setSize(windowSize);
    this.bounds = new GRectangle(windowWidth, windowHeight);
    bricks.setBrickWidth(config, windowSize);
    paddle.setLocation(paddle.getX(), windowHeight - config.getIntProp("PADDLE_Y_OFFSET"));
  }
}