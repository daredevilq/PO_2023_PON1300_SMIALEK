package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener{

    private static int changeCounter = 0;

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        System.out.println("Change number: " + changeCounter + " -> "+ message);
        System.out.println(worldMap.toString());
        changeCounter++;
    }

}
