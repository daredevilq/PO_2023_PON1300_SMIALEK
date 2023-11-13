package agh.ics.oop.model;

import static org.junit.jupiter.api.Assertions.*;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import agh.ics.oop.World;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {
    WorldMap map = new GrassField(10);

    @Test
    public void testCanMoveTo() {
        Vector2d[] positions = { new Vector2d(0,0), new Vector2d(9,9), new Vector2d(0,1) };
        HashSet<String> positionsSet = new HashSet<>();

        for (Vector2d position: positions) {
            Animal animal = new Animal(position);
            positionsSet.add(position.toString());
            map.place(animal);
        }

        Vector2d position;
        for (int i = 0; i <= 11; i++) {
            for (int j = 0; j <= 11; j++) {
                position = new Vector2d(i, j);
                if (positionsSet.contains(position.toString())) assertFalse(map.canMoveTo(position));
                else assertTrue(map.canMoveTo(position));
            }
        }
    }

    @Test
    public void testPlace() {
        // Test if 10 grass fields were put
        // (since max distance is sqrt(10 * 10) = 10, we will check all fields which have x and y coordinate
        // between 0 and 10 (inclusive) and count grass fields)
        int grassCount = 0;
        Vector2d position;
        for (int x = 0; x <= 10; x++) {
            for (int y = 0; y <= 10; y++) {
                position = new Vector2d(x, y);
                if (map.objectAt(position) instanceof Grass) grassCount++;
            }
        }
        assertEquals(10, grassCount);

        // Place animals on the whole 11x11 square and check if there is no more grass
        // and are 100 animals placed where they should
        ArrayList<Animal> animals = new ArrayList<>();
        Animal animal;
        for (int x = 0; x <= 10; x++) {
            for (int y = 0; y <= 10; y++) {
                animal = new Animal( new Vector2d(x, y));
                animals.add(animal);
                map.place(animal);
            }
        }

        // Count animals and grass
        int animalsCount = 0;
        grassCount = 0;
        for (int x = 0; x <= 10; x++) {
            for (int y = 0; y <= 10; y++) {
                position = new Vector2d(x, y);
                if (map.objectAt(position) instanceof Animal) animalsCount++;
                else if (map.objectAt(position) instanceof Grass) grassCount++;
            }
        }
        assertEquals(0, grassCount);
        assertEquals(11 * 11, animalsCount);

        // Check if animals were placed where they should
        for (Animal a: animals) assertEquals(a, map.objectAt(a.getPosition()));
    }

    @Test
    public void Grass_field_test_with_no_moves(){
        String[] args1 = {};
        List<MoveDirection> directions = new OptionsParser().convert(args1);
        WorldMap map = new GrassField(10);
        List<Vector2d>  positions = List.of( new Vector2d(2,2), new Vector2d(3,4));
        assertFalse(map.isOccupied(new Vector2d(3, 4)));
        assertFalse(map.isOccupied(new Vector2d(2, 2)));
        Simulation engine = new Simulation(directions, positions, map);
        engine.run();

        assertTrue(map.isOccupied(new Vector2d(3, 4)));
        assertTrue(map.isOccupied(new Vector2d(2, 2)));
    }

    @Test
    public void Grass_field_test_with_another_animal_collision(){
        String[] args1 = {"f", "b", "r", "l", "f", "f"};
        List<MoveDirection> directions = new OptionsParser().convert(args1);
        WorldMap map = new GrassField(10);
        List<Vector2d>  positions = List.of( new Vector2d(2,2), new Vector2d(3,4));
        Simulation engine = new Simulation(directions, positions, map);
        engine.run();

        assertTrue(map.isOccupied(new Vector2d(3, 3)));
        assertTrue(map.isOccupied(new Vector2d(2, 3)));
    }

}

