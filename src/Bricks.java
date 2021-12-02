import java.awt.*;
import java.lang.reflect.Field;
import java.util.*;

public class Bricks implements Updateable {
  private Brick[][] bricks;
  private Color[] colors;

  public Bricks(Config config) {
    this.bricks = new Brick[config.getIntProp("BRICK_ROWS")][config.getIntProp("BRICKS_PER_ROW")];
    this.colors = initBrickColors(config.getStringProp("BRICK_COLORS"));
  }

  @Override
  public void update() {
    // TODO: add code here!
  }

  private Color[] initBrickColors(String colorString) {
    String[] colorStrings = colorString.split(",");
    Color[] result = new Color[colorStrings.length];

    for (int i = 0; i < result.length; i++) {
      try {
        Field field = Class.forName("java.awt.Color").getField(colorStrings[i].toUpperCase());
        result[i] = (Color) field.get(null);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    return result;
  }
}
