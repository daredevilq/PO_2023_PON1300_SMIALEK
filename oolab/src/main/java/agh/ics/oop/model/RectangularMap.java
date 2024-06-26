package agh.ics.oop.model;
import agh.ics.oop.model.util.MapVisualizer;
import java.util.HashMap;
import java.util.Map;

public class RectangularMap extends AbstractWorldMap{


    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (0> position.getX() || position.getX() > width || 0> position.getY() || position.getY() > height) {
            return false;
        }
        return !isOccupied(position);
    }

    @Override
    public Boundary getCurrentBoundary() {
        return new Boundary(new Vector2d(0,0), new Vector2d(width, height));
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        return animals.get(position);
    }


}
