package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class OptionsParser {

    public static MoveDirection[] convert(String [] args){

        MoveDirection[] arr = new MoveDirection[args.length];

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("f")){
                arr[i] = MoveDirection.FORWARD;
            }
            else if (args[i].equals("b")) {
                arr[i] = MoveDirection.BACKWARD;
            }
            else if (args[i].equals("l")) {
                arr[i] = MoveDirection.LEFT;
            } else if (args[i].equals("r")) {
                arr[i] = MoveDirection.RIGHT;
            }
        }
        return arr;

    }


}
