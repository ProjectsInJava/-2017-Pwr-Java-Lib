package Paradigms.List11.BoundedBuffer;

public class Consumer extends Thread {
    private final Consume buf_;

    public Consumer(String inName, Consume inBuf){
        super(inName);
        buf_ = inBuf;
    }

    @Override
    public void run(){
        for (int i = 0; i<=100; i++){
            System.out.println(getName() + " consumed " + buf_.take());
        }
    }
}
