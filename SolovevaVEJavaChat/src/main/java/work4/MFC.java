package work4;


import client.ReadThread;
import client.WriteThread;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MFC {
    public static void main(String[] args) {

        Window win1 = new Window("young-elder-business");
        Window win2 = new Window("elder");
        Window win3 = new Window("business");

        String[] categories = {"young", "elder", "business"};
        for (int i = 0; i < 100; i++) {
            String category = categories[new Random().nextInt(0, categories.length-1)];
            int num = new Random().nextInt(1, 5);
            Customer customer;

            if (category.equals("elder") && (num > 1)) {
                customer = new Customer(category+"_"+i, win2);
            }
            else if (category.equals("business") && (num > 1)) {
                customer = new Customer(category+"_"+i, win3);
            }
            else {
                customer = new Customer(category+"_"+i, win1);
            }

            Thread thread = new Thread(customer);
            thread.start();
        }

    }
}
