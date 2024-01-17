// Light class represents a traffic light with a name (color) and sleep time (duration of the signal).
class Light {
    public String name;
    public long sleepTime;

    // Synchronized method to print the light color.
    public synchronized void printLight() {
        System.out.print(name);
    }
}

// Runnable classes representing different signal states (Red, Green, Yellow).
class Red implements Runnable {
    private Light red;

    public Red(Light red) {
        this.red = red;
    }

    public void run() {
        red.printLight();
        try {
            Thread.sleep(red.sleepTime * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Green implements Runnable {
    private Light green;

    public Green(Light green) {
        this.green = green;
    }

    public void run() {
        green.printLight();
        try {
            Thread.sleep(green.sleepTime * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Yellow implements Runnable {
    private Light yellow;

    public Yellow(Light yellow) {
        this.yellow = yellow;
    }

    public void run() {
        yellow.printLight();
        try {
            Thread.sleep(yellow.sleepTime * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// TrafficSignal class simulates a traffic signal system with three lights.
class TrafficSignal implements Runnable {
    @Override
    public void run() {
        // Initialize lights with names and sleep times.
        Light red = new Light();
        red.name = "Red";
        red.sleepTime = 10;

        Light green = new Light();
        green.name = "Green";
        green.sleepTime = 15;

        Light yellow = new Light();
        yellow.name = "Yellow";
        yellow.sleepTime = 3;

        // Infinitely cycle through the signal states (Red, Green, Yellow).
        while (true) {
            Thread t1 = new Thread(new Red(red));
            Thread t2 = new Thread(new Green(green));
            Thread t3 = new Thread(new Yellow(yellow));

            // Start threads and wait for them to finish before moving to the next state.
            t1.start();
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t2.start();
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t3.start();
            try {
                t3.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Main class to start the simulation with two traffic signal intersections.
public class Main {
    public static void main(String args[]) {
        // Create two traffic signal instances.
        TrafficSignal intersection1 = new TrafficSignal();
        TrafficSignal intersection2 = new TrafficSignal();
        // uncomment below to add more intersection
        // TrafficSignal intersection3 = new TrafficSignal();

        // Create threads for each intersection and start them.
        Thread thread1 = new Thread(intersection1);
        Thread thread2 = new Thread(intersection2);
        // uncomment below to add more intersection
        // Thread thread3 = new Thread(intersection3);


        thread1.start();
        thread2.start();
        // uncomment below to add more intersection
        // thread3.start();

    }
}
