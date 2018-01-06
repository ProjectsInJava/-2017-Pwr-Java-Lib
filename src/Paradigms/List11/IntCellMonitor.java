package Paradigms.List11;

public class IntCellMonitor {
    // function sets isSet on false and on the beggining checks
    // if isSet is false then stops the execution of the thread until another thread invokes the notify
    // then condition is checked one more time
    // it prevents from read the same value by two threads until first thread will call set function
    // the same history with set
    public synchronized int getN(){
        while(!isSet){
            waitForNotifying();
        }
        isSet=false;
        notifyAll();
        // Wakes up all threads that are waiting on this object's monitor
        return n;
    }

    // function sets isSet on true and on the beggining checks
    // if isSet is true then stops the execution of the thread until another thread invokes the notify
    // then condition is checked one more time
    // it prevents from set the same value by two threads until first thread will call get function
    // the same history with set
    public synchronized void setN(int n){
        while(isSet){
            waitForNotifying();
        }
        this.n = n;
        isSet = true;
        notifyAll();
    }

    // above approach protects from the replicated call of getN or setN between threads
    // it forces to call getN before setN everytime
    private void waitForNotifying(){
        try{
            wait();
            // causes the current thread to wait until
            // another thread invokes the notify/notifyAll() method for this obj
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    private boolean isSet = true;
    private int n = 0;
}

class CountMonitor extends Thread{
    static IntCellMonitor n = new IntCellMonitor();

    @Override
    public void run(){
        for (int i = 0; i < 200000; i++){
            int temp = n.getN();
            n.setN(temp+1);
        }
    }

    public static void main(String[] args){
        CountMonitor thread1 = new CountMonitor();
        CountMonitor thread2 = new CountMonitor();
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
        System.out.println("Monitor edition");
    }
}
