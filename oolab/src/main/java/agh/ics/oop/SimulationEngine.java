package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimulationEngine implements Runnable {

    List<Simulation> simulationsList = new ArrayList<>();
    List<Thread> threads = new ArrayList<>();
    public SimulationEngine(List<Simulation> simulationsList) {
        this.simulationsList = simulationsList;
    }

    ExecutorService executorService = Executors.newFixedThreadPool(4);

    public void runSync() {
        for (Simulation simulation : simulationsList) {
            simulation.run();
        }
    }

    public void runAsync(){

        for (Simulation simulation : simulationsList) {
            Thread thread = new Thread(simulation::run);
            threads.add(thread);
            thread.start();
        }
        awaitSimulationsEndAsync();
    }
    public void awaitSimulationsEndAsync() {
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void runAsyncInThreadPool() {
        // Utwórz pulę wątków z 4 wątkami
        for (Simulation simulation : simulationsList) {
            // Uruchom symulację w puli wątków
            executorService.submit(simulation::run);
        }
        awaitSimulationsEnd();
    }

    public void awaitSimulationsEnd() {
        if (executorService != null) {
            // Zaczekaj na zakończenie wszystkich zadań w puli wątków
            try {
                executorService.shutdown();
                executorService.awaitTermination(10, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void run() {
        System.out.println("Thread started.");
    }
}
