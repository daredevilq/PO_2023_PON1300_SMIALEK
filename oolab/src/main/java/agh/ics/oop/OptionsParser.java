package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class OptionsParser {

    public static MoveDirection[] convert(String [] inputArgs){

        MoveDirection[] directionsArray = new MoveDirection[inputArgs.length];
        int iterator =0;
        for (String inputArg:inputArgs){
            switch (inputArg){
                case "f" -> directionsArray[iterator] = MoveDirection.FORWARD;
                case "b" -> directionsArray[iterator] = MoveDirection.BACKWARD;
                case "r" -> directionsArray[iterator] = MoveDirection.RIGHT;
                case "l" -> directionsArray[iterator] = MoveDirection.LEFT;
            }
            iterator++;
        }

        return directionsArray;

    }

}
