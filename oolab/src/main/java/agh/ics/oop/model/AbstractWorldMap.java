package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.*;

public abstract class AbstractWorldMap implements WorldMap {

    protected int width;
    protected int height;

    protected Vector2d lowerLeft = new Vector2d(0,0);
    protected Vector2d upperRight = new Vector2d(width,height);
    protected Map<Vector2d, Animal> animals = new HashMap<>();
    protected Map<Vector2d, Grass> grassFields = new HashMap<>();
    protected  MapVisualizer mapVisualizer;

    private final List<MapChangeListener> subscribers = new ArrayList<>();


    public AbstractWorldMap() {
        this.mapVisualizer = new MapVisualizer(this);
    }

    public boolean canMoveTo(Vector2d position) {
        return !animals.containsKey(position);
    }

    public String toString() {
        return mapVisualizer.draw(getCurrentBoundary().leftBottom(), getCurrentBoundary().rightTop());
    }

    public void place(Animal animal) throws PositionAlreadyOccupiedException {
        if (isOccupied(animal.getPosition())) {
            if (objectAt(animal.getPosition()) instanceof Grass) {
                grassFields.remove(animal.getPosition());
                animals.put(animal.getPosition(), animal);
                updateMapBounds(animal.getPosition());
                notifySubscribers("Animal placed at " + animal.getPosition().toString() + " (grass destroyed)");
            }
            else {
                throw new PositionAlreadyOccupiedException(animal.getPosition());
            }
        }
        updateMapBounds(animal.getPosition());
        animals.put(animal.getPosition(), animal);
        notifySubscribers("Animal placed at " + animal.getPosition().toString());

    }

    public boolean isOccupied(Vector2d position){
        return animals.containsKey(position) || grassFields.containsKey(position);
    }

    protected void updateMapBounds(Vector2d position){
        lowerLeft = new Vector2d(Math.min(position.getX(), lowerLeft.getX()), Math.min(position.getY(), lowerLeft.getY()));
        upperRight = new Vector2d(Math.max(position.getX(), upperRight.getX()), Math.max(position.getY(), upperRight.getY()));
    }

    public abstract Boundary getCurrentBoundary();

    public  WorldElement objectAt(Vector2d position){
        if(this.animals.get(position) != null){
            return this.animals.get(position);
        }
        if(this.grassFields.get(position) != null){
            return this.grassFields.get(position);
        }
        return null;
    }
    public void move(Animal animal, MoveDirection direction) {
        Vector2d oldPosition = animal.getPosition();
        if(animals.get(oldPosition) != null){
            animal.moveAnimal(direction, this);
            Vector2d newPosition = animal.getPosition();
            animals.remove(oldPosition);
            animals.put(newPosition, animal);
            updateMapBounds(newPosition);
            notifySubscribers("Animal moved from " + oldPosition.toString() + " to " + newPosition.toString());
        }
    }

    public Map<Vector2d, WorldElement> getElements(){
        Map<Vector2d, WorldElement> elements = new HashMap<>();
        elements.putAll(Collections.unmodifiableMap(animals));
        elements.putAll(Collections.unmodifiableMap(grassFields));
        return elements;
    }

    public void addSubscriber(MapChangeListener subscriber){
        subscribers.add(subscriber);
    }

    public void removeSubscriber(MapChangeListener subscriber){
        subscribers.remove(subscriber);
    }

    public void notifySubscribers(String message){
        for (MapChangeListener subscriber : subscribers) {
            subscriber.mapChanged(this, message);
        }
    }


}




