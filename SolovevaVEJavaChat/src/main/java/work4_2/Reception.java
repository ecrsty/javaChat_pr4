package work4_2;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Reception {

    private Semaphore semaphore_therap = new Semaphore(1);
    private Semaphore semaphore_mri = new Semaphore(1);


    public synchronized void Therapist(Patient patient){
        try{
            semaphore_therap.acquire();
            System.out.println(patient.getName() + " занял кабинет терапевта.");
            Thread.sleep(new Random().nextInt(1000));
            semaphore_therap.release();
            System.out.println(patient.getName() + " освободил кабинет терапевта.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        MRI(patient);
    }

    public synchronized void MRI(Patient patient){
        try{
            semaphore_mri.acquire();
            System.out.println(patient.getName() + " занял кабинет МРТ.");
            Thread.sleep(new Random().nextInt(1000));
            semaphore_mri.release();
            System.out.println(patient.getName() + " освободил кабинет МРТ.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
