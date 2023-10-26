package work4;

public class Customer implements Runnable{

    public Window window;
    public String category;

    @Override
    public void run() {
        window.serveCustomer(this);
        System.out.println("Клиент "+category+" обслужен окном "+window.windowName);
    }

    public String getCategory() {
        return category;
    }

    public Customer(String category, Window window) {
        this.window = window;
        this.category = category;
    }
}
