package work4_2;

public class Patient implements Runnable{

    private String name;
    private Reception reception;

    @Override
    public void run() {
        reception.Therapist(this);
    }

    public Patient(String name, Reception reception) {
        this.name = name;
        this.reception = reception;
    }

    public String getName() {
        return name;
    }
}
