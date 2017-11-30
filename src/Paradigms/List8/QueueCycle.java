package Paradigms.List8;

import java.util.ArrayList;

public class QueueCycle<E> implements MyQueue<E>{
    private ArrayList<E> memory_;

    public QueueCycle(int size, ArrayList<E> memory_)
    {

        this.memory_ = memory_;
    }

    @Override
    public void enqueue(E x) throws FullException {

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
        return false;
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
