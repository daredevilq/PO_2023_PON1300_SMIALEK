package agh.ics.oop.model;

public class GrassField extends AbstractWorldMap{



    public GrassField(int grassCount){
        if (grassCount <= 0) throw new Error("Grass count must be positive");
        generateGrass(grassCount);
    }




    private void generateGrass(int grassCount){
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
