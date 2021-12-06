import java.awt.*;
import java.lang.reflect.Field;

public class Bricks {
  // Bricks are in a grid, so they are stored in a 2D array
  private Brick[][] bricks;
  // Colors correspond to the rows in bricks: they should be the same length!
  private Color[] colors;

  public Bricks(Config config) {
    loadBrickColors(config.getStringProp("BRICK_COLORS"));
    initBricks(config);
  }

  public void update(Game game, Scoreboard scoreboard, boolean doublePointsActive) {
    Brick brick = null;

    // loops through bricks, looking for any Brick objects that are:
    // 1. not null, and
    // 2. destroyed,
    // and removes them from the screen and awards points accordingly
    for (int i = 0; i < bricks.length; i++) {
      for (int j = 0; j < bricks[i].length; j++) {
        brick = bricks[i][j];

        if (brick != null && brick.isDestroyed()) {
          game.remove(brick);
          scoreboard.addScore(100, doublePointsActive);
          bricks[i][j] = null;
        }
      }
    }
  }

  private void initBricks(Config config) {
    // inits bricks
    int brickRows = config.getIntProp("BRICK_ROWS"),
        bricksPerRow = config.getIntProp("BRICKS_PER_ROW");
    bricks = new Brick[brickRows][bricksPerRow];

    for (int i = 0; i < bricks.length; i++) {
      for (int j = 0; j < bricks[i].length; j++) {
        bricks[i][j] = new Brick(colors[i]);
      }
    }
    // sets the width of the Bricks according to a bunch of variables
    setBrickWidth(config, new Dimension(config.getIntProp("WIDTH"), config.getIntProp("HEIGHT")));
  }

  private void loadBrickColors(String colorString) {
    // uses the COLOR_NAMES prop to load the Colors that will fill the Bricks
    String[] colorStrings = colorString.split(",");
    colors = new Color[colorStrings.length];

    for (int i = 0; i < colors.length; i++) {
      try {
        Field field = Class.forName("java.awt.Color").getField(colorStrings[i].toUpperCase());
        colors[i] = (Color) field.get(null);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  // helpers
  public Brick getBrick(int row, int column) {
    return bricks[row][column];
  }

  public Brick[][] getAllBricks() {
    return bricks;
  }

  // sets the width of the Bricks in bricks according to:
  // - the ratio between the default window size and the
  // current window size
  // - the number of rows of bricks, and the amount of bricks per row
  // - the amount of seperation between bricks, in pixels
  // - the brick y offset (AKA how far down the bricks should be drawn)
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
        if (bricks[i][j] != null) {
          brickX = ((brickWidth + brickSep) * j) + brickSep;
          brickY = (i * (brickHeight + brickSep)) + brickYOffset;
          bricks[i][j].setLocation(brickX, brickY);
          bricks[i][j].setSize(brickWidth, brickHeight);
        }
      }
    }
  }
}
