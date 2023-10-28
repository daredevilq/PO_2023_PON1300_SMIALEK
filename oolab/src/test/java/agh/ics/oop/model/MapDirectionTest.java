package agh.ics.oop.model;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MapDirectionTest {


    // testy next():
    @Test
    public void testNextNorth(){
        //given
        MapDirection outcome = MapDirection.NORTH;

        //when
        outcome = outcome.next();

        //then
        assertEquals(MapDirection.EAST,outcome);

    }
    @Test
    public void testNextEast(){
        //given
        MapDirection outcome = MapDirection.EAST;

        //when
        outcome = outcome.next();

        //then
        assertEquals(MapDirection.SOUTH,outcome);

    }
    @Test
    public void testNextSouth(){
        //given
        MapDirection outcome = MapDirection.SOUTH;

        //when
        outcome = outcome.next();

        //then
        assertEquals(MapDirection.WEST,outcome);

    }
    @Test
    public void testNextWest(){
        //given
        MapDirection outcome = MapDirection.WEST;

        //when
        outcome = outcome.next();

        //then
        assertEquals(MapDirection.NORTH,outcome);
    }


    //testy previous():

    @Test
    public void testPreviousNorth(){
        //given
        MapDirection outcome = MapDirection.NORTH;

        //when
        outcome = outcome.previous();

        //then
        assertEquals(MapDirection.WEST,outcome);

    }
    @Test
    public void testPreviousEast(){
        //given
        MapDirection outcome = MapDirection.EAST;

        //when
        outcome = outcome.previous();

        //then
        assertEquals(MapDirection.NORTH,outcome);

    }
    @Test
    public void testPreviousSouth(){
        //given
        MapDirection outcome = MapDirection.SOUTH;

        //when
        outcome = outcome.previous();

        //then
        assertEquals(MapDirection.EAST,outcome);

    }
    @Test
    public void testPreviousWest(){
        //given
        MapDirection outcome = MapDirection.WEST;

        //when
        outcome = outcome.previous();

        //then
        assertEquals(MapDirection.SOUTH,outcome);

    }



}