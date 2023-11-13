package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {

    public static List<MoveDirection> convert(String [] inputArgs){

        List<MoveDirection> directionsList = new ArrayList<>();
        for (String inputArg:inputArgs){
            if (inputArg.equals("f") || inputArg.equals("b") || inputArg.equals("r") || inputArg.equals("l")){
                switch (inputArg){
                    case "f" -> directionsList.add(MoveDirection.FORWARD);
                    case "b" -> directionsList.add(MoveDirection.BACKWARD);
                    case "r" -> directionsList.add(MoveDirection.RIGHT);
                    case "l" -> directionsList.add(MoveDirection.LEFT);
                }
            }
        }

        return directionsList;

    }

}
