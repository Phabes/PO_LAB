package agh.ics.oop;

public class WrapMap extends AbstractWorldMap {
  public WrapMap(int width, int height, int startEnergy, int moveEnergy, int plantEnergy, int jungleWidth, int jungleHeight, boolean isMagical) {
    super(width, height, startEnergy, moveEnergy, plantEnergy, jungleWidth, jungleHeight, isMagical);
  }

  @Override
  public boolean canMoveBeyondMap() {
    return true;
  }

  @Override
  public Vector2d moveBeyondMapVector(Vector2d oldPosition) {
    int x = 0;
    int y = 0;
    if (oldPosition.x < 0)
      x = this.width - 1;
    else if (oldPosition.x >= this.width)
      x = -(this.width - 1);
    if (oldPosition.y < 0)
      y = this.height - 1;
    else if (oldPosition.y >= this.height)
      y = -(this.height - 1);
    return new Vector2d(x, y);
  }
}