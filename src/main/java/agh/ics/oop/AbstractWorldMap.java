package agh.ics.oop;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
  protected Vector2d leftBottom;
  protected Vector2d rightTop;
  protected Map<Vector2d, Animal> animals = new LinkedHashMap<>();
  public final MapVisualizer visualizer = new MapVisualizer(this);
  public MapBoundary mapEnds = new MapBoundary(this);

  public Map<Vector2d, Animal> getAnimals(){
    return this.animals;
  }

  public String toString(Vector2d leftBottom, Vector2d rightTop) {
    return visualizer.draw(leftBottom, rightTop);
  }

  public boolean place(Animal animal) {
    Vector2d animalPosition = animal.getPosition();
    if (this.animals.get(animalPosition) != null)
      throw new IllegalArgumentException("Position " + animalPosition.toString() + " is busy");
    this.animals.put(animalPosition, animal);
    return true;
  }

  public boolean isOccupied(Vector2d position) {
    return this.animals.get(position) != null;
  }

  public Object objectAt(Vector2d position) {
    return this.animals.get(position);
  }

  public boolean positionChanged(Vector2d oldPosition, Vector2d newPosition) {
    Animal animal = this.animals.remove(oldPosition);
    this.animals.put(newPosition, animal);
    return true;
  }
}
