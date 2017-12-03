package Paradigms.List8;

import java.util.ArrayList;
import java.util.List;

public class QueueCycle<E> implements MyQueue<E>{
    private List<E> memory_;
    private int f = 0;
    private int writeIdx = 0;

    public QueueCycle(int size) {
        memory_ = new ArrayList<>(size);
        for (int i = 0; i<size; i++){
            memory_.add(null);
        }
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
        return f == writeIdx;
    }

    @Override
    public boolean isFull() {
        return writeIdx >= memory_.size();
        /*
        if (memory_.size() == 0){
            return true;
        }
        else{
            return f == writeIdx;
        }
        */
    }

    public ArrayList<E> toArrayList() {
        return (ArrayList<E>) memory_;
    }
}
