package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {
  @Test
  public void canMoveTo() {
    IWorldMap map = new RectangularMap(10, 5);
    Vector2d v1 = new Vector2d(1, 1);
    Animal a1 = new Animal(map, v1);
    map.place(a1);
    assertFalse(map.canMoveTo(v1));
    Vector2d v2 = new Vector2d(-1, 1);
//    assertFalse(map.canMoveTo(v2));
    Vector2d v3 = new Vector2d(3, 1);
    assertTrue(map.canMoveTo(v3));
  }

  @Test
  public void place() {
    IWorldMap map = new RectangularMap(10, 5);
    Vector2d v1 = new Vector2d(1, 1);
    Animal a1 = new Animal(map, v1);
    assertTrue(map.place(a1));
    Animal a2 = new Animal(map, v1);
    assertFalse(map.place(a2));
    Vector2d v2 = new Vector2d(2, 2);
    a2 = new Animal(map, v2);
    assertTrue(map.place(a2));
    Vector2d v3 = new Vector2d(-5, 1);
    Animal a3 = new Animal(map, v3);
    assertFalse(map.place(a3));
  }

  @Test
  public void isOccupied() {
    IWorldMap map = new RectangularMap(10, 5);
    Vector2d v1 = new Vector2d(1, 1);
    Animal a1 = new Animal(map, v1);
    map.place(a1);
    assertTrue(map.isOccupied(v1));
    Vector2d v3 = new Vector2d(4, 4);
    assertFalse(map.isOccupied(v3));
  }

  @Test
  public void objectAt() {
    IWorldMap map = new RectangularMap(10, 5);
    Vector2d v1 = new Vector2d(1, 1);
    Animal a1 = new Animal(map, v1);
    map.place(a1);
    Vector2d v2 = new Vector2d(4, 4);
    assertNull(map.objectAt(v2));
    assertEquals(a1, map.objectAt(v1));
    a1.move(MoveDirection.RIGHT);
    a1.move(MoveDirection.FORWARD);
    assertEquals(a1, map.objectAt(v1.add(new Vector2d(1, 0))));
  }

  @Test
  public void engine() {
    MoveDirection[] directions = {MoveDirection.LEFT, MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.FORWARD};
    IWorldMap map = new RectangularMap(10, 5);
    Vector2d v1 = new Vector2d(2, 2);
    Vector2d v2 = new Vector2d(3, 4);
    Vector2d[] positions = {v1, v2};
    SimulationEngine engine = new SimulationEngine(map, positions);
    engine.setMoves2(directions);
    engine.run();
    Vector2d v3 = new Vector2d(1, 2);
    Vector2d v4 = new Vector2d(2, 4);
    Animal animal = new Animal(map, v3);
    assertFalse(map.place(animal));
    animal = new Animal(map, v4);
    assertFalse(map.place(animal));
    animal = new Animal(map, v1);
    assertTrue(map.place(animal));
    animal = new Animal(map, v2);
    assertTrue(map.place(animal));
  }
}