import acm.graphics.*;

public class Powerup extends GPolygon {
  public Powerup(double size) {
    double sinTheta = GMath.sinDegrees(18);
    double b = 0.5 * sinTheta / (1.0 + sinTheta);
    double edge = (0.5 - b) * size;
    addVertex(-size / 2, -b * size);
    int angle = 0;
    for (int i = 0; i < 5; i++) {
      addPolarEdge(edge, angle);
      addPolarEdge(edge, angle + 72);
      angle -= 72;
    }
    markAsComplete();
  }
}
