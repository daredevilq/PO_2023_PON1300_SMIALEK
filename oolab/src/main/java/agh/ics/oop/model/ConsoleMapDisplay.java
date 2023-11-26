package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener{

    private static int changeCounter = 0;

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        synchronized (this) {
            System.out.println("Change number: " + changeCounter + " -> " + message + " map ID: " + worldMap.getId());
            System.out.println(worldMap.toString());
            changeCounter++;
        }
    }

}
