package Paradigms.List8;

import java.util.ArrayList;
import java.util.List;

public class QueueCycle<E> implements MyQueue<E>{
    private List<E> memory_;
    private int readIdx = 0;
    private int writeIdx = 0;
    private int elemCounter = 0;

    public QueueCycle(int size) {
        memory_ = new ArrayList<>(size);
        for (int i = 0; i<size; i++){
            memory_.add(null);
        }
    }

    @Override
    public void enqueue(E newElem) throws FullException {
        if (isFull()){
            throw new FullException("QueueCycle is full");
        }
        else{
            memory_.set(writeIdx, newElem);
            writeIdx = (writeIdx+1)%memory_.size();
            elemCounter++;
        }
    }

    @Override
    public void dequeue() {
        if (!isEmpty()) {
            readIdx=(readIdx+1)%memory_.size();
            elemCounter--;
        }
    }

    @Override
    public E first() throws EmptyException {
        if (isEmpty()){
            throw new EmptyException("QueueCycle is empty");
        }
        else{
            return memory_.get(readIdx);
        }
    }

    @Override
    public boolean isEmpty() {
        return readIdx == writeIdx && (elemCounter==0);
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
