package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.model.util.MapVisualizer;
import javafx.application.Application;
import java.util.ArrayList;
import java.util.List;

public class World {

        public static void main(String[] args) {


//        List<MoveDirection> directions = OptionsParser.convert(args);
//        List<Vector2d> positions = List.of( new Vector2d(2,2), new Vector2d(3,4) );
//        ConsoleMapDisplay listener = new ConsoleMapDisplay();
//        //grass map

//        AbstractWorldMap map = new GrassField(10);
//        map.addSubscriber(listener);
//        Simulation simulation1 = new Simulation(directions, positions, map);
//
//
//       // rectangular map
//
//        AbstractWorldMap map2 = new RectangularMap(10, 5);
//        //ConsoleMapDisplay listener2 = new ConsoleMapDisplay();
//        map2.addSubscriber(listener);
//        Simulation simulation2 = new Simulation(directions, positions, map2);
//
//        List<Simulation> simulationsList = List.of(simulation1, simulation2);
//        SimulationEngine engine = new SimulationEngine(simulationsList);
//        engine.runAsync();
//        //engine.runSync();
//        engine.awaitSimulationsEnd();
//        System.out.println("Simulation finished.");
        // multiple simulations
//        List<Simulation> simulationList = new ArrayList<>();
//        for (int i = 0; i <1000 ; i++) {
//            AbstractWorldMap grassMap = new GrassField(10);
//            grassMap.addSubscriber(listener);
//            AbstractWorldMap rectangularMap = new RectangularMap(10, 5);
//            rectangularMap.addSubscriber(listener);
//            Simulation simulationGrass = new Simulation(directions, positions, grassMap);
//            Simulation simulationRectangular = new Simulation(directions, positions, rectangularMap);
//            simulationList.add(simulationGrass);
//            simulationList.add(simulationRectangular);
//        }
//        SimulationEngine engine = new SimulationEngine(simulationList);
//        engine.runAsyncInThreadPool();
//        System.out.println("Simulation finished.");

            Application.launch(SimulationApp.class, args);
    
        }

}
