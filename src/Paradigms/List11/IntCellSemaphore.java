package Paradigms.List11;

import java.util.concurrent.Semaphore;

class CountSemaphore extends Thread{
    static IntCellDefault n = new IntCellDefault();
    private Semaphore mutex = new Semaphore(1, true);
    // first arg permit = liczba pozwolen, definiuje liczbe watkow ktora w jednym czasie moze uzyskac dostep do
    // sekcji krytycznej
    // second arg fair = uczciowosc, polegajaca na szeregowaniu watkow oczekujacych na dostep do sekcji krytycznej
    // przy pomocy kolejki FIFO
    // nazwa zmiennej mutex poniewaz semaphore z umozliwiajacy tylko jedno pozwolenie jest semaforem binarnym czyli
    // tzw. mutexem

    @Override
    public void run(){
        for (int i = 0; i < 200000; i++){
            int temp = n.getN();
            n.setN(temp+1);
        }
    }

    public static void main(String[] args){
        CountSemaphore thread1 = new CountSemaphore();
        CountSemaphore thread2 = new CountSemaphore();
        thread1.start();
        thread2.start();
        try{
            thread1.join();
            thread2.join();
        }catch(InterruptedException e){
            System.out.println(e.getStackTrace());
            System.out.println("Catched exception");
        }
        System.out.println("The value of n is " + n.getN());
    }
}
