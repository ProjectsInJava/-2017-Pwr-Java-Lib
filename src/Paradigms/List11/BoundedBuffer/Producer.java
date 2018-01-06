package Paradigms.List11.BoundedBuffer;

public class Producer extends Thread{
    private final Produce buf_;

    public Producer(String inName, Produce inBuf){
        super(inName);
        buf_ = inBuf;
    }

    @Override
    public void run(){
        for(int i = 1; i<=100; i++){
            System.out.println(getName() + " producing " + i);
            buf_.put(i);
        }
    }
}
