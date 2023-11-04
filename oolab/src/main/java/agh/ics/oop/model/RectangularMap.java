package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap implements WorldMap{

    private final int width;
    private final int height;

    private final MapVisualizer object;
    Map<Vector2d, Animal> animals = new HashMap<>();
    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.object = new MapVisualizer(this);

    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (0> position.getX() || position.getX() > width || 0> position.getY() || position.getY() > height) {
            return false;
        }
        return !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        Vector2d position = animal.getPosition();
        if (position.precedes(new Vector2d(width, height)) && position.follows(new Vector2d(0, 0))) {
            if (!isOccupied(position)) {
                animals.put(position, animal);
                return true;
            }
        }
        return false;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        Vector2d oldPosition = animal.getPosition();
        if(animals.get(oldPosition) != null){
            animal.move(direction, this);
            Vector2d newPosition = animal.getPosition();
            animals.remove(oldPosition);
            animals.put(newPosition, animal);
        }

    }

    @Override
    public boolean isOccupied(Vector2d position) {
        Animal animalAtPosition = animals.get(position);
        return animalAtPosition != null;
    }

    @Override
    public Animal objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public String toString() {
        return object.draw(new Vector2d(0, 0), new Vector2d(width, height));
    }
}
