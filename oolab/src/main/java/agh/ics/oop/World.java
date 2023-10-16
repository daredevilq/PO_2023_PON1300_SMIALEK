package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class World {

    static void run(MoveDirection[] arg){
        for (MoveDirection i: arg) {
            switch (i){
                case FORWARD: {
                    System.out.println("Zwierzak idzie do przodu");
                    break;
                }
                case BACKWARD:{
                    System.out.println("Zwierzak idzie do tylu");
                    break;
                }
                case RIGHT:{
                    System.out.println("Zwierzak skreca w prawo");
                    break;
                }
                case LEFT:{
                    System.out.println("Zwierzak skreca w lewo");
                    break;
                }

            }
        }
    }

    //MoveDirection direction = MoveDirection.RIGHT;
    public static void main(String[] args) {
        MoveDirection[] direction = OptionsParser.convert(args);
        System.out.println("Start");
        World.run(direction);
        System.out.println("Stop");
    }

}
