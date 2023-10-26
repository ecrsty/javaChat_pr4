package work4_2;

import java.util.LinkedList;
import java.util.Queue;

public class PolyclinicSimulation {
    public static void main(String[] args) {

        Reception reception = new Reception();

        Queue<Patient> patients = new LinkedList<>();
        for (int i = 0; i <= 15; i++){
            patients.add(new Patient("Пациент "+i, reception));
        }

        while (!patients.isEmpty()){
            Patient patient = patients.poll();
            Thread patientThread = new Thread(patient);
            patientThread.start();
        }

        System.out.println("Пациенты закончились, рабочий день завершен!");
    }
}
