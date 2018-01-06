package Paradigms.List11.BoundedBuffer;

public class BoundedBuffer implements Consume, Produce {

    public BoundedBuffer(int N){
        this.N_ = N;
        elems_ = new int[N_];
    }

    @Override
    public synchronized void put(int inVal) {
        while (n_ >= N_){
            try{
                System.out.println(Thread.currentThread().getName() + " waiting with " + inVal);
                wait();
            } catch (InterruptedException e){ System.out.println(e); }

        }
        elems_[in_] = inVal;
        in_ = (in_ + 1) % N_;
        n_ += 1;
        System.out.println(Thread.currentThread().getName() + " produced: " + inVal);
        if (n_ == 1){
            notifyAll();
        }
    }

    @Override
    public synchronized int take() {
        while (n_ == 0){
            try {
                System.out.println(Thread.currentThread().getName() + " waiting");
                wait();
            } catch( InterruptedException e){ System.out.print(e); }
        }
        int x = elems_[out_];
        out_ = (out_ + 1) % N_;
        n_ -= 1;
        System.out.println(Thread.currentThread().getName()+ " consuming: " + x);
        if (n_ == N_-1){
            notifyAll();
        }
        return x;
    }

    private int[] elems_;
    private int in_ = 0;
    private int out_ = 0;
    private int n_ = 0;
    private final int N_;
}
