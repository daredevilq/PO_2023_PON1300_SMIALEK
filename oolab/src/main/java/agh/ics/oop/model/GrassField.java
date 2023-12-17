package agh.ics.oop.model;
import agh.ics.oop.model.util.MapVisualizer;
import java.util.HashMap;
import java.util.Map;

public class GrassField extends AbstractWorldMap{

    private final int grassCount;


    public GrassField(int grassCount){
        if (grassCount <= 0) throw new Error("Grass count must be positive");
        this.grassCount = grassCount;
        generateGrass();
    }




    private void generateGrass(){
        int max = Math.min( (int) Math.sqrt(grassCount * 10), Integer.MAX_VALUE);

        for (int i = 0; i < grassCount ; i++) {

            Grass grass = new Grass(generateEmptyField(max, max));
            Vector2d grassPosition = grass.getPosition();
            grassFields.put(grassPosition, grass);
            updateMapBounds(grassPosition);
        }

    }

    private Vector2d generateEmptyField(int maxX, int maxY){
        Vector2d position = Vector2d.generateRandomVector(maxX, maxY);
        while (isOccupied(position)){
            position = Vector2d.generateRandomVector(maxX, maxY);
        }
        return position;
    }

    @Override
    public Boundary getCurrentBoundary() {
        return new Boundary(lowerLeft, upperRight);
    }
}
