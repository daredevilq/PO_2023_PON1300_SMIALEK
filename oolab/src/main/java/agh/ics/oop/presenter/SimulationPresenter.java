package agh.ics.oop.presenter;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import agh.ics.oop.SimulationEngine;
import agh.ics.oop.model.*;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import javax.swing.*;
import java.util.List;
import java.util.Map;

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
    private void clearGrid() {
        mapGrid.getChildren().retainAll(mapGrid.getChildren().get(0)); // hack to retain visible grid lines
        mapGrid.getColumnConstraints().clear();
        mapGrid.getRowConstraints().clear();
    }

    public void drawMap(WorldMap map){
        clearGrid();

        Boundary boundaries =  map.getCurrentBoundary();
        for (int i = boundaries.leftBottom().getX(); i <= boundaries.rightTop().getX() + 1; i++) {
            mapGrid.getColumnConstraints().add( new ColumnConstraints(CELL_WIDTH));
        }

        for (int i = boundaries.leftBottom().getY(); i <= boundaries.rightTop().getY() + 1; i++) {
            mapGrid.getRowConstraints().add( new RowConstraints(CELL_HEIGHT));
        }

        mapGrid.add(new Label("y/x "), 0, 0);

        for (int i = boundaries.leftBottom().getX(); i < boundaries.rightTop().getX() + 1; i++) {
            Label label = new Label(Integer.toString(i));
            mapGrid.add(label, i + 1 - boundaries.leftBottom().getX() , 0);
            GridPane.setHalignment(label, HPos.CENTER);
            GridPane.setValignment(label, VPos.CENTER);
        }

        for (int i = boundaries.leftBottom().getY(); i < boundaries.rightTop().getY() + 1; i++) {
            Label label = new Label(Integer.toString(i));

            GridPane.setHalignment(label, HPos.CENTER);
            GridPane.setValignment(label, VPos.CENTER);

            mapGrid.add(new Label(Integer.toString(i)),0, i + 1 - boundaries.leftBottom().getY());

        }

        Map<Vector2d, WorldElement> mapElements = map.getElements();

        for (Map.Entry<Vector2d, WorldElement> entry : mapElements.entrySet()) {
            Vector2d key = entry.getKey();
            WorldElement value = entry.getValue();
            Label label = new Label(value.toString());

            GridPane.setHalignment(label, HPos.CENTER);
            GridPane.setValignment(label, VPos.CENTER);

            mapGrid.add(label, key.getX() + 1 - boundaries.leftBottom().getX(),  key.getY() + 1 - boundaries.leftBottom().getY());

        }


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

