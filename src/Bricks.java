import java.awt.*;
import java.lang.reflect.Field;
import acm.graphics.*;

public class Bricks {
  private Brick[][] bricks;
  private Color[] colors;

  public Bricks(Config config) {
    loadBrickColors(config.getStringProp("BRICK_COLORS"));
    initBricks(config);
  }

  public void update(Game game) {
    for (Brick[] row : bricks) {
      for (Brick brick : row) {
        if (brick != null && brick.isDestroyed()) {
          game.remove(brick);
        }
      }
    }
  }

  private void initBricks(Config config) {
    int brickRows = config.getIntProp("BRICK_ROWS"),
        bricksPerRow = config.getIntProp("BRICKS_PER_ROW");
    bricks = new Brick[brickRows][bricksPerRow];

    for (int i = 0; i < bricks.length; i++) {
      for (int j = 0; j < bricks[i].length; j++) {
        bricks[i][j] = new Brick(colors[i]);
      }
    }
    setBrickWidth(config, new Dimension(config.getIntProp("WIDTH"), config.getIntProp("HEIGHT")));
  }

  private void loadBrickColors(String colorString) {
    String[] colorStrings = colorString.split(",");
    colors = new Color[colorStrings.length];

    for (int i = 0; i < colors.length; i++) {
      try {
        Field field = Class.forName("java.awt.Color").getField(colorStrings[i].toUpperCase());
        colors[i] = (Color) field.get(null);
        System.out.println(colors[i].getRGB());
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public Brick getBrick(int row, int column) {
    return bricks[row][column];
  }

  public Brick[][] getAllBricks() {
    return bricks;
  }

  public void setBrickWidth(Config config, Dimension windowSize) {
    double defaultWindowHeight = config.getDoubleProp("APPLICATION_HEIGHT"),
        windowWidth = windowSize.getWidth(),
        windowHeight = windowSize.getHeight(),
        brickRows = config.getDoubleProp("BRICK_ROWS"),
        bricksPerRow = config.getDoubleProp("BRICKS_PER_ROW"),
        brickHeight = (config.getDoubleProp("BRICK_HEIGHT") / defaultWindowHeight) * windowHeight,
        brickSep = config.getDoubleProp("BRICK_SEP"),
        brickYOffset = (config.getDoubleProp("BRICK_Y_OFFSET") / defaultWindowHeight) * windowHeight,
        brickWidth = ((windowWidth - bricksPerRow * brickSep) / bricksPerRow) - .5;
    double brickX, brickY;

    for (int i = 0; i < brickRows; i++) {
      for (int j = 0; j < bricksPerRow; j++) {
        brickX = ((brickWidth + brickSep) * j) + brickSep;
        brickY = (i * (brickHeight + brickSep)) + brickYOffset;
        bricks[i][j].setLocation(brickX, brickY);
        bricks[i][j].setSize(brickWidth, brickHeight);
      }
    }
  }
}
