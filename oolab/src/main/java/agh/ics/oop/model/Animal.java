package agh.ics.oop.model;

public class Animal {

    private MapDirection orientation;
    private Vector2d position;

    private static final Vector2d moveOneStepNorthVector = new Vector2d(0,1);
    private static final Vector2d moveOneStepEastVector = new Vector2d(1,0);
    private static final Vector2d moveOneStepSouthVector = new Vector2d(0,-1);
    private static final Vector2d moveOneStepWestVector = new Vector2d(-1,0);
    private static final Vector2d rightTopBound = new Vector2d(4,4);
    private static final Vector2d leftBottomBound = new Vector2d(0,0);


    public Animal(){
        this.position = new Vector2d(2,2);
        this.orientation = MapDirection.NORTH;

    }

    public Animal(Vector2d initialPosition){
        this.position = initialPosition;
        this.orientation = MapDirection.NORTH;
    }

    @Override
    public String toString() {
        return "{" +
                "orientation=" + orientation +
                ", position=" + position +
                '}';
    }


    boolean isAt(Vector2d position){
        return this.position.equals(position);
    }


    private boolean isValidMove(int x, int y, Vector2d moveVector, MoveDirection direction){

        Vector2d newPosition = new Vector2d(x,y);
        if (direction.equals(MoveDirection.BACKWARD)){
            newPosition = newPosition.subtract(moveVector);
        }
        else if (direction.equals(MoveDirection.FORWARD)){
            newPosition = newPosition.add(moveVector);
        }

        return rightTopBound.follows(newPosition) && leftBottomBound.precedes(newPosition);
    }

    public void move(MoveDirection direction){
        switch (direction){
            case FORWARD ->{
                switch (this.orientation){
                    case NORTH ->{
                        if (isValidMove(this.position.getX(),this.position.getY(),moveOneStepNorthVector, direction)){
                            this.position = this.position.add(moveOneStepNorthVector);
                        }
                    }
                    case SOUTH ->{
                        if (isValidMove(this.position.getX(),this.position.getY(),moveOneStepSouthVector, direction)){
                            this.position = this.position.add(moveOneStepSouthVector);
                        }
                    }
                    case EAST ->{
                        if (isValidMove(this.position.getX(),this.position.getY(),moveOneStepEastVector, direction)){
                            this.position = this.position.add(moveOneStepEastVector);
                        }
                    }
                    case WEST ->{
                        if (isValidMove(this.position.getX(),this.position.getY(),moveOneStepWestVector, direction)){
                            this.position = this.position.add(moveOneStepWestVector);
                        }
                    }

                }

            }

            case BACKWARD -> {
                switch (this.orientation){
                    case NORTH ->{
                        if (isValidMove(this.position.getX(),this.position.getY(),moveOneStepNorthVector, direction)){
                            this.position = this.position.subtract(moveOneStepNorthVector);
                        }
                    }
                    case SOUTH ->{
                        if (isValidMove(this.position.getX(),this.position.getY(),moveOneStepSouthVector, direction)){
                            this.position = this.position.subtract(moveOneStepSouthVector);
                        }
                    }
                    case EAST ->{
                        if (isValidMove(this.position.getX(),this.position.getY(),moveOneStepEastVector, direction)){
                            this.position = this.position.subtract(moveOneStepEastVector);
                        }
                    }
                    case WEST ->{
                        if (isValidMove(this.position.getX(),this.position.getY(),moveOneStepWestVector, direction)){
                            this.position = this.position.subtract(moveOneStepWestVector);
                        }
                    }

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
