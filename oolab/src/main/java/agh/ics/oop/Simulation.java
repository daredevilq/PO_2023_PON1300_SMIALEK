package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.WorldMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Simulation {

    private final List<MoveDirection> initialMoves;
    private final List<Vector2d> initialPositions;
    private final List<Animal> animalsList;

    private final WorldMap map;


    public Simulation(List<MoveDirection> initialMoves, List<Vector2d> initialPositions, WorldMap map) {

        this.initialMoves = initialMoves;
        this.initialPositions = initialPositions;
        this.animalsList = new ArrayList<>();
        this.map = map;

        for (Vector2d i : initialPositions) {
            Animal animal = new Animal(i);
            this.animalsList.add(animal);
            this.map.place(animal);
        }
    }

    public void run(){
        int actualAnimalNumber = 0;
        int numberOfAnimals = this.animalsList.size();
        int numberOfMoves = this.initialMoves.size();
        for (MoveDirection initialMove : this.initialMoves) {
            System.out.println(map.toString());
            Animal actualAnimal = animalsList.get(actualAnimalNumber);
            map.move(actualAnimal, initialMove);
            actualAnimalNumber = (actualAnimalNumber + 1) % numberOfAnimals;

        }
        System.out.println(map.toString());

    }

    public List<Animal> getAnimalsList() {
        return Collections.unmodifiableList(this.animalsList);
    }

    public List<MoveDirection> getInitialMoves() {
        return Collections.unmodifiableList(this.initialMoves);
    }

    public List<Vector2d> getInitialPositions() {
        return Collections.unmodifiableList(this.initialPositions);
    }


}
