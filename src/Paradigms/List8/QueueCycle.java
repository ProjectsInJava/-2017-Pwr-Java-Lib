package Paradigms.List8;

import java.util.ArrayList;

public class QueueCycle<E> implements MyQueue<E>{
    private ArrayList<E> memory_;
    private int enqueueCounter_;
    private int dequeueCounter_;
    private int currentIdx;
    private final int size_;

    public QueueCycle(int size) {
        enqueueCounter_ = 0;
        dequeueCounter_ = 0;
        currentIdx = 0;
        size_ = size;
        memory_ = new ArrayList<>(size);
        for (int i = 0; i<size; i++){
            memory_.add(null);
        }
    }

    public int getIdxAndHandleCounter(){
        int newIdx = enqueueCounter_++%size_;
        return newIdx;
    }

    @Override
    public void enqueue(E newElem) throws FullException {
        if(size_ < 1){
            throw new FullException("Size of queue is lower than 1");
        }
        else{
            memory_.set(getIdxAndHandleCounter(), newElem);
        }
    }

    @Override
    public void dequeue() {
        dequeueCounter_++;
        memory_.set(calculateIdxOfFirst(), null);

        enqueueCounter_--;
        /*
        if(dequeueCounter_ == size_){
            dequeueCounter_ = 0;
            enqueueCounter_ = 0;
        }
        */
    }

    public int calculateIdxOfFirst(){
        int countDivSize = enqueueCounter_/size_;
        int countDivSizeMulSize = countDivSize*size_;
        int retEqueueCounter_1 = enqueueCounter_- countDivSizeMulSize;
        int retEqueueCounter_2 = enqueueCounter_ - ((enqueueCounter_/size_)*size_);
        return retEqueueCounter_1;
    }

    @Override
    public E first() throws EmptyException {
        try {
            return memory_.get(calculateIdxOfFirst());
        }catch(IndexOutOfBoundsException e){
            throw new EmptyException("Queue is Empty");
        }
    }

    @Override
    public boolean isEmpty() {
        return enqueueCounter_ <= 0;
    }

    @Override
    public boolean isFull() {
        return enqueueCounter_ > size_ - 1;
    }

    public ArrayList<E> toArrayList() {
        return memory_;
    }
}
