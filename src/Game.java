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
  }

  public void update() {
    // ball.update();
    // paddle.update();
    // bricks.update();
    // powerups.update();
    // scoreboard.update();
  }
}