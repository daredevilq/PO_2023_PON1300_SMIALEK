package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OptionsParserTest {

    @Test
    public void convertTest1(){
        //given
        String [] inputValues = {"f","b","r","l"};

        //when
        List<MoveDirection> directions =  OptionsParser.convert(inputValues);

        boolean outcome = true;

        for (MoveDirection i:directions){
            boolean temp;
            temp = i.equals(MoveDirection.FORWARD) || i.equals(MoveDirection.BACKWARD) || i.equals(MoveDirection.LEFT) || i.equals(MoveDirection.RIGHT);

            outcome = outcome && temp;
        }

        //then
        assertTrue(outcome);

    }

    @Test
    public void convertTest2(){
        //given
        String [] inputValues = {"s","f","b", "zdas","r","dasd"};

        //when
        List<MoveDirection> directions =  OptionsParser.convert(inputValues);

        boolean outcome = true;

        for (MoveDirection i:directions){
            boolean temp;
            temp = i.equals(MoveDirection.FORWARD) || i.equals(MoveDirection.BACKWARD) || i.equals(MoveDirection.LEFT) || i.equals(MoveDirection.RIGHT);

            outcome = outcome && temp;
        }

        //then
        assertTrue(outcome);

    }


}