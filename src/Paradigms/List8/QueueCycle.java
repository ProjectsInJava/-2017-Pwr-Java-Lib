package Paradigms.List8;

import java.util.ArrayList;

public class QueueCycle<E> implements MyQueue<E>{
    private ArrayList<E> memory_;
    private int size_;
    private int counter_;

    public QueueCycle(int size)
    {
        counter_ = 0;
        size_ = size;
        memory_ = new ArrayList<>(size);
    }

    private int getIdxForNewElem() throws FullException
    {
        return 0;
    }

    @Override
    public void enqueue(E newElem) throws FullException {
        int newIdx = -1;
        if(size_ < 1){
            throw new FullException("Size of queue is lower than 1");
        }
        else{
            newIdx = counter_++%size_;
            memory_.add(newIdx, newElem);
        }
    }

    @Override
    public void dequeue() {

    }

    @Override
    public E first() throws EmptyException {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return memory_.isEmpty();
    }

    @Override
    public boolean isFull() {
        return size_ == memory_.size();
    }

    public ArrayList<E> toArrayList()
    {
        return memory_;
    }
}
