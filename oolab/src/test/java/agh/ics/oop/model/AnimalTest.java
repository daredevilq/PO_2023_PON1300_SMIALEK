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
        //when
        MapDirection expectedOutcome = MapDirection.EAST;
        testAnimal.move(MoveDirection.RIGHT);
        //then
        assertEquals(testAnimal.getOrientation(), expectedOutcome);
    }



    @Test
    public void orientationTest3(){
        //given
        Animal testAnimal = new Animal();
        //when
        MapDirection expectedOutcome = MapDirection.WEST;
        testAnimal.move(MoveDirection.LEFT);
        //then
        assertEquals(testAnimal.getOrientation(), expectedOutcome);
    }

    @Test
    public void orientationTest4(){
        //given
        Animal testAnimal = new Animal();
        //when
        MapDirection expectedOutcome = MapDirection.SOUTH;
        testAnimal.move(MoveDirection.LEFT);
        testAnimal.move(MoveDirection.LEFT);
        //then
        assertEquals(testAnimal.getOrientation(), expectedOutcome);
    }


    //czy zwierzę przemieszcza się na właściwe pozycje

    @Test
    public void moveTest1(){
        //given
        Animal testAnimal = new Animal();
        //when
        Vector2d expectedOutcome = new Vector2d(3,2);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.RIGHT);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.RIGHT);
        testAnimal.move(MoveDirection.FORWARD);
        //then
        assertEquals(testAnimal.getPosition(), expectedOutcome);
    }

    @Test
    public void moveTest2(){
        //given
        Animal testAnimal = new Animal();
        //when
        Vector2d expectedOutcome = new Vector2d(1,2);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.LEFT);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.LEFT);
        testAnimal.move(MoveDirection.FORWARD);
        //then
        assertEquals(testAnimal.getPosition(), expectedOutcome);
    }


    //czy zwierzę nie wychodzi poza mapę

    @Test
    public void moveTest3(){
        //given
        Animal testAnimal = new Animal();
        //when
        Vector2d expectedOutcome = new Vector2d(4, 4);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.RIGHT);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.LEFT);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.RIGHT);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        //then
        assertEquals(testAnimal.getPosition(), expectedOutcome);
    }

    @Test
    public void moveTest4(){
        //given
        Animal testAnimal = new Animal();
        //when
        Vector2d expectedOutcome = new Vector2d(4, 0);
        testAnimal.move(MoveDirection.RIGHT);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.RIGHT);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        //then
        assertEquals(testAnimal.getPosition(), expectedOutcome);
    }

    @Test
    public void moveTest5(){
        //given
        Animal testAnimal = new Animal();
        //when
        Vector2d expectedOutcome = new Vector2d(0, 4);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.LEFT);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.RIGHT);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        //then
        assertEquals(testAnimal.getPosition(), expectedOutcome);
    }

    @Test
    public void moveTest6(){
        //given
        Animal testAnimal = new Animal();
        //when
        Vector2d expectedOutcome = new Vector2d(0, 0);
        testAnimal.move(MoveDirection.BACKWARD);
        testAnimal.move(MoveDirection.BACKWARD);
        testAnimal.move(MoveDirection.BACKWARD);
        testAnimal.move(MoveDirection.LEFT);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        //then
        assertEquals(testAnimal.getPosition(), expectedOutcome);
    }



}