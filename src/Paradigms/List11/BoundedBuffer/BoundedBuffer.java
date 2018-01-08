package Paradigms.List11.BoundedBuffer;

public class BoundedBuffer implements Consume, Produce {
    public BoundedBuffer(int N){
        this.SIZE_ = N;
        elems_ = new int[SIZE_];
    }

    @Override
    public synchronized void put(int inVal) {
        while (elemsCounter_ >= SIZE_){
            try{
                System.out.println(Thread.currentThread().getName() + " waiting with put the " + inVal);
                wait();
            } catch (InterruptedException e){ System.out.println(e); }

        }
        elems_[idxToPut_] = inVal;
        idxToPut_ = (idxToPut_ + 1) % SIZE_;
        elemsCounter_ += 1;
        System.out.println(Thread.currentThread().getName() + " produced: " + inVal);
        if (elemsCounter_ == 1){
            System.out.println("Put notify");
            notify();
        }
    }

    @Override
    public synchronized int take() {
        while (elemsCounter_ == 0){
            try {
                System.out.println(Thread.currentThread().getName() + " waiting on take");
                wait();
            } catch( InterruptedException e){ System.out.print(e); }
        }
        int x = elems_[idxToTake_];
        idxToTake_ = (idxToTake_ + 1) % SIZE_;
        elemsCounter_ -= 1;
        System.out.println(Thread.currentThread().getName()+ " consuming: " + x);
        if (elemsCounter_ == SIZE_-1){
            System.out.println("Take notify");
            notify();
        }
        // It occurs when buffor was full and threads was stopped at the begginning of put
        // Then consumer took one elem from the buffer, so empty slot appeared
        // So awake prodcuents
        return x;
    }

    private int[] elems_;
    private int idxToPut_ = 0;
    private int idxToTake_ = 0;
    private int elemsCounter_ = 0;
    private final int SIZE_;
}
