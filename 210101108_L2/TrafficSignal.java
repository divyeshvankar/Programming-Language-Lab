class Light {
    public String name;
    public long sleepTime;

    public synchronized void printLight() {
        System.out.print( "->"+name);
    }

    
}


class Red implements Runnable {
    private Light red;

    public Red(Light red) {
        this.red = red;
    }
    public void run() {

        red.printLight();
        try {
            Thread.sleep(red.sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // System.out.println("Red End");
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
            Thread.sleep(green.sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // System.out.println("Green End");
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
            Thread.sleep(yellow.sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // System.out.println("Red End");
    }
}

public class TrafficSignal {
    public static void main(String args[]) throws InterruptedException {
        Light red = new Light();
        red.name="Red";
        red.sleepTime=10;

        Light green = new Light();
        green.name="Green";
        green.sleepTime=15;

        Light yellow = new Light();
        yellow.name="Yellow";
        yellow.sleepTime=3;

       
        for(int i=0;i<5;i++)
        {
            Thread t1 = new Thread(new Red(red));
            Thread t2 = new Thread(new Green(green));
            Thread t3 = new Thread(new Yellow(yellow));

            t1.start();
            t1.join();
            t2.start();
            t2.join();
            t3.start();
            t3.join();
        }
    }
}