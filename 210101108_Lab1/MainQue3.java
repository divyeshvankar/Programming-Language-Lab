public class MainQue3 implements Runnable {
    public static void main(String[] args) {
        MainQue3 obj = new MainQue3();
        Thread thread = new Thread(obj);
        thread.start();
        // System.out.println("This code is outside of the thread");
    }

    public void run() {
        System.out.println("Hello, World!");
    }
}
