package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.model.util.MapVisualizer;

import java.util.List;

public class World {

    public static void main(String[] args) {

        //grass map
        List<MoveDirection> directions = OptionsParser.convert(args);
        AbstractWorldMap map = new GrassField(10);
        List<Vector2d> positions = List.of( new Vector2d(2,2), new Vector2d(3,4), new Vector2d(3,4), new Vector2d(3,4) );
        ConsoleMapDisplay listener = new ConsoleMapDisplay();
        map.addSubscriber(listener);
        Simulation engine = new Simulation(directions, positions, map);
        engine.run();
        System.out.println(map.getElements());

       // rectangular map
//     List<MoveDirection> directions2 = OptionsParser.convert(args);
//     AbstractWorldMap map2 = new RectangularMap(10, 5);
//     List<Vector2d> positions2 = List.of( new Vector2d(2,2), new Vector2d(3,4), new Vector2d(3,4), new Vector2d(3,4) );
//     ConsoleMapDisplay listener2 = new ConsoleMapDisplay();
//     map2.addSubscriber(listener2);
//     Simulation engine = new Simulation(directions2, positions2, map2);
//     engine.run();

    }

}
