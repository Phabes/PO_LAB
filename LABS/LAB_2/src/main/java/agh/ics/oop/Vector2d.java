package agh.ics.oop;

public class Vector2d {
  public int x;
  public int y;

  public Vector2d(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public String toString() {
    return "(" + this.x + "," + this.y + ")";
  }

  public boolean precedes(Vector2d other) {
    return this.x <= other.x && this.y <= other.y;
  }

  public boolean follows(Vector2d other) {
    return this.x >= other.x && this.y >= other.y;
  }

  public Vector2d upperRight(Vector2d other) {
    int maxiX = this.x;
    int maxiY = this.y;
    if (maxiX < other.x)
      maxiX = other.x;
    if (maxiY < other.y)
      maxiY = other.y;
    return new Vector2d(maxiX, maxiY);
  }

  public Vector2d lowerLeft(Vector2d other) {
    int miniX = this.x;
    int miniY = this.y;
    if (miniX > other.x)
      miniX = other.x;
    if (miniY > other.y)
      miniY = other.y;
    return new Vector2d(miniX, miniY);
  }

  public Vector2d add(Vector2d other) {
    return new Vector2d(this.x + other.x, this.y + other.y);
  }

  public Vector2d subtract(Vector2d other) {
    return new Vector2d(this.x - other.x, this.y - other.y);
  }

  public boolean equals(Object other) {
    if (!(other instanceof Vector2d that))
      return false;
    return this.x == that.x && this.y == that.y;
//    if (!(other instanceof Vector2d))
//      return false;
//    Vector2d that = (Vector2d) other;
//    return this.x == that.x && this.y == that.y;
  }

  public Vector2d opposite() {
    return new Vector2d(-this.x, -this.y);
  }
}