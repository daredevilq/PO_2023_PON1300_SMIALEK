package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimulationTest {

    @Test
    void runTest1() {
        //given
        String [] arguments = {"f", "b", "r", "l" ,"f" ,"f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));

        //when
        List<MoveDirection> directions = OptionsParser.convert(arguments);
        Simulation simulation = new Simulation(directions, positions);
        simulation.run();

        //then
        List<Animal> animalsList = simulation.getAnimalsList();

        int expectedLength = 2;
        int actualLength = animalsList.size();

        boolean outcome1 = expectedLength == actualLength;

        boolean outcome2 = animalsList.get(0).getPosition().equals(new Vector2d(3,0));
        boolean outcome3 = animalsList.get(0).getOrientation().equals(MapDirection.SOUTH);

        boolean outcome4 = animalsList.get(1).getPosition().equals(new Vector2d(2,4));
        boolean outcome5 = animalsList.get(1).getOrientation().equals(MapDirection.NORTH);

        assertTrue(outcome1 && outcome2 && outcome3 && outcome4 && outcome5);

    }

    @Test
    void runTest2() {
        //given
        String [] arguments = {"dasdas","f", "b", "r", "l","s","s" ,"f" ,"f", "r", "r", "f","fggf", "f", "f", "f", "f", "f", "f", "f", "losowe slowo", "dasdas"};
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));

        //when
        List<MoveDirection> directions = OptionsParser.convert(arguments);
        Simulation simulation = new Simulation(directions, positions);
        simulation.run();

        //then
        List<Animal> animalsList = simulation.getAnimalsList();

        int expectedLength = 2;
        int actualLength = animalsList.size();

        boolean outcome1 = expectedLength == actualLength;

        boolean outcome2 = animalsList.get(0).getPosition().equals(new Vector2d(3,0));
        boolean outcome3 = animalsList.get(0).getOrientation().equals(MapDirection.SOUTH);

        boolean outcome4 = animalsList.get(1).getPosition().equals(new Vector2d(2,4));
        boolean outcome5 = animalsList.get(1).getOrientation().equals(MapDirection.NORTH);

        assertTrue(outcome1 && outcome2 && outcome3 && outcome4 && outcome5);

    }


    @Test
    void runTest3() {
        //given
        String [] arguments = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f", "b", "b", "r", "r", "l", "f", "f", "r", "f", "f", "l", "f", "b"};
        List<Vector2d> positions = List.of(new Vector2d(0,0), new Vector2d(1,2), new Vector2d(3,3), new Vector2d(2,4));

        //when
        List<MoveDirection> directions = OptionsParser.convert(arguments);
        Simulation simulation = new Simulation(directions, positions);
        simulation.run();

        //then
        List<Animal> animalsList = simulation.getAnimalsList();

        int expectedLength = 4;
        int actualLength = animalsList.size();

        boolean outcome1 = expectedLength == actualLength;

        boolean outcome2 = animalsList.get(0).getPosition().equals(new Vector2d(1,3));
        boolean outcome3 = animalsList.get(0).getOrientation().equals(MapDirection.WEST);

        boolean outcome4 = animalsList.get(1).getPosition().equals(new Vector2d(1,4));
        boolean outcome5 = animalsList.get(1).getOrientation().equals(MapDirection.NORTH);

        boolean outcome6 = animalsList.get(2).getPosition().equals(new Vector2d(2,1));
        boolean outcome7 = animalsList.get(2).getOrientation().equals(MapDirection.SOUTH);

        boolean outcome8 = animalsList.get(3).getPosition().equals(new Vector2d(2,3));
        boolean outcome9 = animalsList.get(3).getOrientation().equals(MapDirection.SOUTH);

        assertTrue(outcome1 && outcome2 && outcome3 && outcome4 && outcome5);

    }

    @Test
    void runTest4() {
        //given
        String [] arguments = {"a","f", "b", "r","ss", "l", "f", "f", "r", "r", "f", "f", "f","radnom", "f", "f", "f", "f", "dasda","f", "b", "b", "r", "r", "l", "f", "f", "r", "f", "f", "l", "f", "b","idk"};
        List<Vector2d> positions = List.of(new Vector2d(0,0), new Vector2d(1,2), new Vector2d(3,3), new Vector2d(2,4));

        //when
        List<MoveDirection> directions = OptionsParser.convert(arguments);
        Simulation simulation = new Simulation(directions, positions);
        simulation.run();

        //then
        List<Animal> animalsList = simulation.getAnimalsList();

        int expectedLength = 4;
        int actualLength = animalsList.size();

        boolean outcome1 = expectedLength == actualLength;

        boolean outcome2 = animalsList.get(0).getPosition().equals(new Vector2d(1,3));
        boolean outcome3 = animalsList.get(0).getOrientation().equals(MapDirection.WEST);

        boolean outcome4 = animalsList.get(1).getPosition().equals(new Vector2d(1,4));
        boolean outcome5 = animalsList.get(1).getOrientation().equals(MapDirection.NORTH);

        boolean outcome6 = animalsList.get(2).getPosition().equals(new Vector2d(2,1));
        boolean outcome7 = animalsList.get(2).getOrientation().equals(MapDirection.SOUTH);

        boolean outcome8 = animalsList.get(3).getPosition().equals(new Vector2d(2,3));
        boolean outcome9 = animalsList.get(3).getOrientation().equals(MapDirection.SOUTH);

        assertTrue(outcome1 && outcome2 && outcome3 && outcome4 && outcome5);

    }



}