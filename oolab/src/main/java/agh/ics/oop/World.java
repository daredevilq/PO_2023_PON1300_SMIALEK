package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.model.util.MapVisualizer;

import java.util.List;

public class World {

    public static void main(String[] args) {


        List<MoveDirection> directions = OptionsParser.convert(args);
        WorldMap map = new GrassField(10);
        List<Vector2d> positions = List.of( new Vector2d(2,2), new Vector2d(3,4) );
        Simulation  engine = new Simulation(directions, positions, map);
        engine.run();
        System.out.println(map.getElements());

    }

}
