package agh.ics.oop.model;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {

    //testowanie equals(Object other)

    @Test
    public void equalsTest1(){
        //given
        Vector2d vector1 = new Vector2d(2, 2);
        Vector2d vector2 = new Vector2d(2, 2);

        //when
        boolean outcome = vector1.equals(vector2);

        //then
        assertTrue(outcome);

    }

    @Test
    public void equalsTest2(){
        //given
        Vector2d vector1 = new Vector2d(2, 2);
        Vector2d vector2 = new Vector2d(2, 5);

        //when
        boolean outcome = vector1.equals(vector2);

        //then
        assertFalse(outcome);

    }
    // Wydaje mi sie ze powinienem sprawdzic co zwraca jak porownuje 2 rozne klasy obiektow
    // ale do tego musze miec jakas inna klase do tego 2giego wektora??
    // nie wiem do konca jak to dziala ;[


    // test toString()

    @Test
    public void toStringTest1(){
        //given
        Vector2d vector1 = new Vector2d(5,10);

        //when
        String actual = "(5,10)";
        String outcome = vector1.toString();

        //then
        assertEquals(actual, outcome);
    }

    //tesowanie precedes()
    @Test
    public void precedesTest1(){
        //given
        Vector2d vector1 = new Vector2d(4,1);
        Vector2d vector2 = new Vector2d(5,10);

        //then
        boolean outcome = vector1.precedes(vector2);

        //then
        assertTrue(outcome);
    }

    @Test
    public void precedesTest2(){
        //given
        Vector2d vector2 = new Vector2d(4,1);
        Vector2d vector1 = new Vector2d(5,10);

        //then
        boolean outcome = vector1.precedes(vector2);

        //then
        assertFalse(outcome);
    }

    @Test
    public void precedesTest3(){
        //given
        Vector2d vector2 = new Vector2d(11,1);
        Vector2d vector1 = new Vector2d(5,10);

        //then
        boolean outcome = vector1.precedes(vector2);

        //then
        assertFalse(outcome);
    }

    @Test
    public void precedesTest4(){
        //given
        Vector2d vector2 = new Vector2d(4,22);
        Vector2d vector1 = new Vector2d(5,10);

        //then
        boolean outcome = vector1.precedes(vector2);

        //then
        assertFalse(outcome);
    }



    // testowanie follows()

    @Test
    public void followsTest1(){
        //given
        Vector2d vector1 = new Vector2d(4,1);
        Vector2d vector2 = new Vector2d(5,10);

        //then
        boolean outcome = vector2.follows(vector1);

        //then
        assertTrue(outcome);
    }

    @Test
    public void followsTest2(){
        //given
        Vector2d vector1 = new Vector2d(4,1);
        Vector2d vector2 = new Vector2d(5,10);

        //then
        boolean outcome = vector1.follows(vector2);

        //then
        assertFalse(outcome);
    }

    @Test
    public void followsTest3(){
        //given
        Vector2d vector2 = new Vector2d(11,1);
        Vector2d vector1 = new Vector2d(5,10);

        //then
        boolean outcome = vector1.follows(vector2);

        //then
        assertFalse(outcome);
    }

    @Test
    public void followsTest4(){
        //given
        Vector2d vector2 = new Vector2d(4,22);
        Vector2d vector1 = new Vector2d(5,10);

        //then
        boolean outcome = vector1.follows(vector2);

        //then
        assertFalse(outcome);
    }


    //testowanie upperRight

    @Test
    public void upperRightTest(){
        //given
        Vector2d vector2 = new Vector2d(4,22);
        Vector2d vector1 = new Vector2d(5,10);

        //when

        Vector2d outcomeVector = vector1.upperRight(vector2);
        boolean outcome = outcomeVector.equals(new Vector2d(5,22));
        //then
        assertTrue(outcome);

    }

    //testowanie lowerLeft()

    @Test
    public void lowerLeftTest(){
        //given
        Vector2d vector2 = new Vector2d(4,22);
        Vector2d vector1 = new Vector2d(5,10);

        //when

        Vector2d outcomeVector = vector1.lowerLeft(vector2);
        boolean outcome = outcomeVector.equals(new Vector2d(4,10));
        //then
        assertTrue(outcome);

    }



    //tesowanie add()
    @Test
    public void addTest(){
        //given
        Vector2d vector2 = new Vector2d(4,22);
        Vector2d vector1 = new Vector2d(5,10);

        //when
        Vector2d outcomeVector = vector1.add(vector2);
        boolean outcome = outcomeVector.getX() == 9 && outcomeVector.getY()==32;

        //then
        assertTrue(outcome);


    }

    //tesowanie substract()
    @Test
    public void substractTest(){
        //given
        Vector2d vector2 = new Vector2d(4,22);
        Vector2d vector1 = new Vector2d(5,10);

        //when
        Vector2d outcomeVector = vector1.subtract(vector2);
        boolean outcome = outcomeVector.getX() == 1 && outcomeVector.getY()==-12;

        //then
        assertTrue(outcome);


    }

    //tesowanie opposite()
    @Test
    public void oppositeTest(){
        //given
        Vector2d vector1 = new Vector2d(5,10);

        //when
        Vector2d outcomeVector = vector1.opposite();
        boolean outcome = outcomeVector.getX() == -5 && outcomeVector.getY()==-10;

        //then
        assertTrue(outcome);


    }

}