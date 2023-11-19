package agh.ics.oop.model;

public class Animal implements WorldElement{

    private MapDirection orientation =  MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);


    public Animal(){

    }

    public Animal(Vector2d initialPosition){
        this.position = initialPosition;
    }

    @Override
    public String toString() {
       switch (orientation){
           case NORTH: return "N";
           case SOUTH: return "S";
           case EAST: return "E";
           case WEST: return "W";
       }
        return null;
    }



    public boolean  isAt(Vector2d position) {
        return this.position.equals(position);
    }


    private Vector2d calculateNewPosition(int x, int y, Vector2d moveVector){
        return new Vector2d(x,y).add(moveVector);
    }

    public void moveAnimal(MoveDirection direction, MoveValidator map) {
        switch(direction){
            case FORWARD -> {
                Vector2d newPosition = calculateNewPosition(this.position.getX(), this.position.getY(), this.orientation.toUnitVector());
                if (map.canMoveTo(newPosition)) {
                    this.position = newPosition;
                }
            }
            case BACKWARD -> {
                Vector2d newPosition = calculateNewPosition(this.position.getX(), this.position.getY(), this.orientation.toUnitVector().opposite());
                if (map.canMoveTo(newPosition)) {
                    this.position = newPosition;
                }
            }
            case RIGHT -> this.orientation = this.orientation.next();
            case LEFT -> this.orientation = this.orientation.previous();

        }
    }
    public Vector2d getPosition() {
        return position;
    }

    public MapDirection getOrientation() {
        return orientation;
    }
}
