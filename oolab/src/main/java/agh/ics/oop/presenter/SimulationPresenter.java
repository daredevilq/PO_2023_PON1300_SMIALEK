package agh.ics.oop.presenter;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import agh.ics.oop.SimulationEngine;
import agh.ics.oop.model.*;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import javax.swing.*;
import java.util.List;

public class SimulationPresenter implements MapChangeListener {

    private static final double CELL_WIDTH = 50;
    private static final double CELL_HEIGHT = 50;
    private WorldMap map;
    @FXML
    private Label infoLabel;
    @FXML
    private Label infoLabel2;
    @FXML
    private TextField moveListTextField;
    @FXML
    private GridPane mapGrid;

    public void setMap(WorldMap map) {
        this.map = map;

    }


    public void drawMap(WorldMap map){
        infoLabel.setText(map.toString());

    }


    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        Platform.runLater(() -> {
            drawMap(worldMap);
            infoLabel2.setText(message);
        });

    }
    private boolean isSimulationRunning = false;
    public void onSimulationStartClicked(ActionEvent actionEvent) {



        if (!isSimulationRunning) {
            isSimulationRunning = true;
            Task<Void> task = new Task<>() {
                @Override
                protected Void call() {
                    List<MoveDirection> directions = OptionsParser.convert(moveListTextField.getText().split(" "));
                    List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4));

                    Simulation simulation = new Simulation(directions, positions, map);
                    SimulationEngine simulationEng = new SimulationEngine(List.of(simulation));
                    simulationEng.runAsync();

                    return null;
                }
            };

            task.setOnSucceeded(event -> isSimulationRunning = false);

            new Thread(task).start();
        }
    }

    }

