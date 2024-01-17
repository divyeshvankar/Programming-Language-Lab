class Light {
    public String name;
    public long sleepTime;

    public synchronized void printLight() {
        System.out.print( name);
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
            Thread.sleep(red.sleepTime*1000);
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
            Thread.sleep(green.sleepTime*1000);
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
            Thread.sleep(yellow.sleepTime*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // System.out.println("Red End");
    }
}

class TrafficSignal implements Runnable {
    @Override
    public void run() {
        Light red = new Light();
        red.name="Red";
        red.sleepTime=10;

        Light green = new Light();
        green.name="Green";
        green.sleepTime=15;

        Light yellow = new Light();
        yellow.name="Yellow";
        yellow.sleepTime=3;

       
        
           
         while(true)
         {
            Thread t1 = new Thread(new Red(red));
            Thread t2 = new Thread(new Green(green));
            Thread t3 = new Thread(new Yellow(yellow));
         
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



public class Main{

    
    
    public static void main(String args[])  {
        TrafficSignal intersection1= new TrafficSignal();
        TrafficSignal intersection2= new TrafficSignal();
        Thread thread1 = new Thread(intersection1);
        Thread thread2 = new Thread(intersection2);

        thread1.start();
        thread2.start();

    }
}