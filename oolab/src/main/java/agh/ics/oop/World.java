package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.model.util.MapVisualizer;

import java.util.List;

public class World {

    public static void main(String[] args) {

        List<MoveDirection> directions = OptionsParser.convert(args);
        WorldMap map = new RectangularMap(6, 6);
        List<Vector2d> positions = List.of(new Vector2d(0,0), new Vector2d(1,2), new Vector2d(3,3));
        Simulation simulation = new Simulation(directions, positions, map);
        simulation.run();

    }

}
