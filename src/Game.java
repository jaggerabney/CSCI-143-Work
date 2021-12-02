import acm.graphics.*;
import java.awt.*;

public class Game extends GCanvas {
  private Config config;
  private Controls controls;
  private Ball ball;
  private Paddle paddle;
  private Bricks bricks;
  private Powerups powerups;
  private Scoreboard scoreboard;

  public Game(Config config) {
    super();
    this.config = config;
    this.controls = new Controls();
    addMouseMotionListener(controls);

    Brick test = new Brick(Color.RED);
    test.setWidth(config.getIntProp("WIDTH"), config.getIntProp("BRICKS_PER_ROW"), config.getIntProp("BRICK_SEP"));
    test.setHeight(config.getIntProp("BRICK_HEIGHT"));
    add(test);
  }

  public void update() {
    // ball.update();
    // paddle.update();
    // bricks.update();
    // powerups.update();
    // scoreboard.update();
  }
}