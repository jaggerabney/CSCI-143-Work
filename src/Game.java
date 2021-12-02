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

    Bricks test = new Bricks(config);

    for (int i = 0; i < config.getIntProp("BRICK_ROWS"); i++) {
      for (int j = 0; j < config.getIntProp("BRICKS_PER_ROW"); j++) {
        add(test.getBrick(i, j));
      }
    }
  }

  public void update() {
    // ball.update();
    // paddle.update();
    // bricks.update();
    // powerups.update();
    // scoreboard.update();
  }
}