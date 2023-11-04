package agh.ics.oop.model;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {

    //czy zwierzę ma właściwą orientację

    @Test

    public void orientationTest1(){
        //given
        Animal testAnimal = new Animal();
        //when
        MapDirection expectedOutcome = MapDirection.NORTH;
        //then
        assertEquals(testAnimal.getOrientation(), expectedOutcome);
    }

    @Test
    public void orientationTest2(){
        //given
        Animal testAnimal = new Animal();
        WorldMap map = new RectangularMap(4, 4);
        //when
        MapDirection expectedOutcome = MapDirection.EAST;
        map.place(testAnimal);
        map.move(testAnimal, MoveDirection.RIGHT);
        //then
        assertEquals(testAnimal.getOrientation(), expectedOutcome);
    }



    @Test
    public void orientationTest3(){
        //given
        Animal testAnimal = new Animal();
        WorldMap map = new RectangularMap(4, 4);
        //when
        MapDirection expectedOutcome = MapDirection.WEST;
        map.place(testAnimal);
        map.move(testAnimal, MoveDirection.LEFT);
        //then
        assertEquals(testAnimal.getOrientation(), expectedOutcome);
    }

    @Test
    public void orientationTest4(){
        //given
        Animal testAnimal = new Animal();
        WorldMap map = new RectangularMap(4, 4);
        //when
        MapDirection expectedOutcome = MapDirection.SOUTH;
        map.place(testAnimal);
        map.move(testAnimal, MoveDirection.LEFT);
        map.move(testAnimal, MoveDirection.LEFT);
        //then
        assertEquals(testAnimal.getOrientation(), expectedOutcome);
    }


    //czy zwierzę przemieszcza się na właściwe pozycje

    @Test
    public void moveTest1(){
        //given
        Animal testAnimal = new Animal();
        WorldMap map = new RectangularMap(4, 4);
        //when
        Vector2d expectedOutcome = new Vector2d(3,2);
        map.place(testAnimal);
        map.move(testAnimal, MoveDirection.FORWARD);;
        map.move(testAnimal, MoveDirection.RIGHT);
        map.move(testAnimal, MoveDirection.FORWARD);
        map.move(testAnimal, MoveDirection.RIGHT);
        map.move(testAnimal, MoveDirection.FORWARD);

        //then
        assertEquals(testAnimal.getPosition(), expectedOutcome);
    }

    @Test
    public void moveTest2(){
        //given
        Animal testAnimal = new Animal();
        WorldMap map = new RectangularMap(4, 4);
        //when
        Vector2d expectedOutcome = new Vector2d(1,2);
        map.place(testAnimal);
        map.move(testAnimal, MoveDirection.FORWARD);
        map.move(testAnimal, MoveDirection.LEFT);
        map.move(testAnimal, MoveDirection.FORWARD);
        map.move(testAnimal, MoveDirection.LEFT);
        map.move(testAnimal, MoveDirection.FORWARD);
        //then
        assertEquals(testAnimal.getPosition(), expectedOutcome);
    }


    //czy zwierzę nie wychodzi poza mapę

    @Test
    public void moveTest3(){
        //given
        Animal testAnimal = new Animal();
        WorldMap map = new RectangularMap(4, 4);
        //when
        map.place(testAnimal);
        Vector2d expectedOutcome = new Vector2d(4, 4);
        map.move(testAnimal, MoveDirection.FORWARD);
        map.move(testAnimal, MoveDirection.RIGHT);
        map.move(testAnimal, MoveDirection.FORWARD);
        map.move(testAnimal, MoveDirection.LEFT);
        map.move(testAnimal, MoveDirection.FORWARD);
        map.move(testAnimal, MoveDirection.FORWARD);
        map.move(testAnimal, MoveDirection.RIGHT);
        map.move(testAnimal, MoveDirection.FORWARD);
        map.move(testAnimal, MoveDirection.FORWARD);
        //then
        assertEquals(testAnimal.getPosition(), expectedOutcome);
    }

    @Test
    public void moveTest4(){
        //given
        Animal testAnimal = new Animal();
        WorldMap map = new RectangularMap(4, 4);

        //when
        Vector2d expectedOutcome = new Vector2d(4, 0);
        map.place(testAnimal);
        map.move(testAnimal, MoveDirection.RIGHT);
        map.move(testAnimal, MoveDirection.FORWARD);
        map.move(testAnimal, MoveDirection.FORWARD);
        map.move(testAnimal, MoveDirection.FORWARD);
        map.move(testAnimal, MoveDirection.RIGHT);
        map.move(testAnimal, MoveDirection.FORWARD);
        map.move(testAnimal, MoveDirection.FORWARD);
        map.move(testAnimal, MoveDirection.FORWARD);
        map.move(testAnimal, MoveDirection.FORWARD);

        //then
        assertEquals(testAnimal.getPosition(), expectedOutcome);
    }

    @Test
    public void moveTest5(){
        //given
        Animal testAnimal = new Animal();
        WorldMap map = new RectangularMap(4, 4);
        //when
        map.place(testAnimal);
        Vector2d expectedOutcome = new Vector2d(0, 4);
        map.move(testAnimal, MoveDirection.FORWARD);
        map.move(testAnimal, MoveDirection.LEFT);
        map.move(testAnimal, MoveDirection.FORWARD);
        map.move(testAnimal, MoveDirection.FORWARD);
        map.move(testAnimal, MoveDirection.FORWARD);
        map.move(testAnimal, MoveDirection.RIGHT);
        map.move(testAnimal, MoveDirection.FORWARD);
        map.move(testAnimal, MoveDirection.FORWARD);
        map.move(testAnimal, MoveDirection.FORWARD);

        //then
        assertEquals(testAnimal.getPosition(), expectedOutcome);
    }

    @Test
    public void moveTest6(){
        //given
        Animal testAnimal = new Animal();
        WorldMap map = new RectangularMap(4, 4);
        //when
        map.place(testAnimal);
        Vector2d expectedOutcome = new Vector2d(0, 0);
        map.move(testAnimal, MoveDirection.BACKWARD);
        map.move(testAnimal, MoveDirection.BACKWARD);
        map.move(testAnimal, MoveDirection.BACKWARD);
        map.move(testAnimal, MoveDirection.LEFT);;
        map.move(testAnimal, MoveDirection.FORWARD);
        map.move(testAnimal, MoveDirection.FORWARD);
        map.move(testAnimal, MoveDirection.FORWARD);
        map.move(testAnimal, MoveDirection.FORWARD);
        //then
        assertEquals(testAnimal.getPosition(), expectedOutcome);
    }



}