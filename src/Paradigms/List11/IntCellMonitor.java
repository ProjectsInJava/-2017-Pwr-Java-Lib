package Paradigms.List11;

public class IntCellMonitor {
    public synchronized int getN(){
        while(!isSet){
            waitForNotifying();
        }
        isSet=false;
        notifyAll();
        return n;
    }

    public synchronized void setN(int n){
        while(isSet){
            waitForNotifying();
        }
        this.n = n;
        isSet = true;
        notifyAll();
    }

    private void waitForNotifying(){
        try{
            wait();
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
