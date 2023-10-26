package work4;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class Window{

    public String windowName;
    Semaphore semaphore = new Semaphore(1);

    public Window(String name) {
        this.windowName = name;
    }

    public synchronized void serveCustomer(Customer customer){
        try {
            semaphore.acquire();
            System.out.println(windowName + " принимает клиента " + customer.getCategory());
            Thread.sleep(new Random().nextInt(1000, 7000));
            semaphore.release();
            System.out.println(windowName + " отпустил клиента " + customer.getCategory());

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
