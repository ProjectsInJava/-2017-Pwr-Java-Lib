package Paradigms.List11;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class IntCellDefault {
    public int getN(){
        return n;
    }

    public void setN(int n){
        this.n = n;
    }

    private int n = 0;
}

class Count extends Thread{
    static IntCellDefault n = new IntCellDefault();

    @Override
    public void run(){
        for (int i = 0; i < 200000; i++){
//            tryAcquire();
            int temp = n.getN();
            n.setN(temp+1);
//            semaphore.release();
        }
    }

/*
    private void tryAcquire(){
        try{
            semaphore.acquire();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
*/

    public static void main(String[] args){
        Count counterFst = new Count();
        Count counterSnd = new Count();
        counterFst.start();
        counterSnd.start();
        try{
            counterFst.join();
            counterSnd.join();
        }catch(InterruptedException e){
            System.out.println(e.getStackTrace());
            System.out.println("Catched exception");
        }
        System.out.println("The value of n is " + n.getN());
    }
}
