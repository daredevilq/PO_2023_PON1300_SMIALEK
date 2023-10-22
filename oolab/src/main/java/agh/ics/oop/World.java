package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class World {

    static void run(MoveDirection[] directions){
        for (MoveDirection i: directions) {
            switch (i){
                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case BACKWARD -> System.out.println("Zwierzak idzie do tylu");
                case RIGHT -> System.out.println("Zwierzak skreca w prawo");
                case LEFT -> System.out.println("Zwierzak skreca w lewo");
            }
        }
    }

    public static void main(String[] args) {
        MoveDirection[] directions = OptionsParser.convert(args);
        System.out.println("Start");
        World.run(directions);
        System.out.println("Stop");
    }

}
