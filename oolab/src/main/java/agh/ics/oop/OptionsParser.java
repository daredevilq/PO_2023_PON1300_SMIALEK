package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {

    public static List<MoveDirection> convert(String [] inputArgs) throws IllegalArgumentException{

        List<MoveDirection> directionsList = new ArrayList<>();
        for (String inputArg:inputArgs){
                switch (inputArg){
                    case "f" -> directionsList.add(MoveDirection.FORWARD);
                    case "b" -> directionsList.add(MoveDirection.BACKWARD);
                    case "r" -> directionsList.add(MoveDirection.RIGHT);
                    case "l" -> directionsList.add(MoveDirection.LEFT);
                    default -> throw new IllegalArgumentException("argument: " + inputArg + " is not legal move specification");
                }
        }

        return directionsList;

    }

}
