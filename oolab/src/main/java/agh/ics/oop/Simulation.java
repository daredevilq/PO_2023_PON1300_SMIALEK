package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Thread.sleep;

public class Simulation {

    private final List<MoveDirection> initialMoves;
    private final List<Animal> animalsList;

    private final WorldMap map;


    public Simulation(List<MoveDirection> initialMoves, List<Vector2d> initialPositions, WorldMap map)  {

        this.initialMoves = initialMoves;
        this.animalsList = new ArrayList<>();
        this.map = map;

            for (Vector2d initialPosition : initialPositions) {
                Animal animal = new Animal(initialPosition);
                this.animalsList.add(animal);
                synchronized (this.map) {
                    try {
                        this.map.place(animal);
                        Thread.sleep(500);
                    } catch (PositionAlreadyOccupiedException  | InterruptedException e) {
                        System.out.println(e.getMessage());
                        this.animalsList.remove(animal);
                    }

                }

            }

    }

    public void run(){
        int actualAnimalNumber = 0;
        for (MoveDirection initialMove : this.initialMoves) {
            Animal actualAnimal = animalsList.get(actualAnimalNumber);
            synchronized (this.map) {
                try {
                    this.map.move(actualAnimal, initialMove);
                    Thread.sleep(500);
                } catch ( InterruptedException e) {
                    System.out.println(e.getMessage());
                }

            }
            actualAnimalNumber = (actualAnimalNumber + 1) % this.animalsList.size();
        }
    }

    public List<Animal> getAnimalsList() {
        return Collections.unmodifiableList(this.animalsList);
    }

    public List<MoveDirection> getInitialMoves() {
        return Collections.unmodifiableList(this.initialMoves);
    }


}
