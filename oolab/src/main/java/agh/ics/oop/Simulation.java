package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Simulation {

    private final List<MoveDirection> initialMoves;
    private final List<Vector2d> initialPositions;
    private final List<Animal> animalsList;
    public Simulation(List<MoveDirection> initialMoves, List<Vector2d> initialPositions) {

        this.initialMoves = initialMoves;
        this.initialPositions = initialPositions;
        this.animalsList = new ArrayList<>();

        for (Vector2d i : initialPositions) {
            this.animalsList.add(new Animal(i));

        }

    }

    public void run(){
        int actualAnimal = 0;
        int numberOfAnimals = this.animalsList.size();
        int numberOfMoves = this.initialMoves.size();

        for (MoveDirection initialMove : this.initialMoves) {

            this.animalsList.get(actualAnimal).move(initialMove);
            System.out.println("Zwierzę " + actualAnimal + " " + this.animalsList.get(actualAnimal));
            actualAnimal = (actualAnimal + 1) % numberOfAnimals;

        }

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
