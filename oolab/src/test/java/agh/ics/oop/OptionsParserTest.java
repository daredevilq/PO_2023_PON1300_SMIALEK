package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OptionsParserTest {

    @Test
    public void convertTest1(){
        //given
        String [] inputValues = {"f","b","r","l"};

        //when
        MoveDirection[] directions =  OptionsParser.convert(inputValues);

        boolean outcome = directions[0] == MoveDirection.FORWARD &&  directions[1] == MoveDirection.BACKWARD && directions[2] == MoveDirection.RIGHT && directions[3] == MoveDirection.LEFT;

        //then
        assertTrue(outcome);

    }

    @Test
    public void convertTest2(){
        //given
        String [] inputValues = {"f","b","r","dasd"};

        //when
        MoveDirection[] directions =  OptionsParser.convert(inputValues);

        boolean outcome = directions[0] == MoveDirection.FORWARD &&  directions[1] == MoveDirection.BACKWARD && directions[2] == MoveDirection.RIGHT && directions[3] != MoveDirection.LEFT;

        //then
        assertTrue(outcome);

    }


}