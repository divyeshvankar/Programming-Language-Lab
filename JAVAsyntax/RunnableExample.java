// class MyRunnable implements Runnable {
//     public void run() {
        // for (int i = 1; i <= 5; i++) {
        //     System.out.println(Thread.currentThread().getId() + " Value " + i);
        // }
//     }
// }

public class RunnableExample {
    public static void main(String args[]) {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getId() + " Value " + i);
            }
        }, "Thread-1");
        t1.start();
    }
}

