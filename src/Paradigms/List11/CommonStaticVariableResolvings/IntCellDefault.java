package Paradigms.List11.CommonStaticVariableResolvings;

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
            int temp = n.getN();
            n.setN(temp+1);
        }
    }

    public static void main(String[] args){
        Count thread1 = new Count();
        Count thread2 = new Count();
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

    // First of all thread1 and thread2 starts in various times
    // Secondly each thread makes a copy to their local caches
    // It implies that when thread1 modifies the static variable
    // The thread2 can contain old value of static variable
    // And will increase basing on old value
    // Then finally cause that the value of n.n has lower value then expected 400000
}
