package Paradigms.List8;

import java.util.ArrayList;
import java.util.List;

public class QueueCycle<E> implements MyQueue<E>{
    private List<E> memory_;
    private int readIdx_;
    private int writeIdx_;
    private int elemCounter_;

    public QueueCycle(int size) {
        elemCounter_ = 0;
        readIdx_ = 0;
        writeIdx_ = 0;
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
            memory_.set(writeIdx_, newElem);
            writeIdx_ = (writeIdx_+1)%memory_.size();
            elemCounter_++;
        }
    }

    @Override
    public void dequeue() {
        if (!isEmpty()) {
            readIdx_ = (readIdx_ + 1) % memory_.size();
            elemCounter_--;
        }
        else{
            System.out.println("log: QueueCycle is empty");
        }
    }

    @Override
    public E first() throws EmptyException {
        if (isEmpty()){
            throw new EmptyException("QueueCycle is empty");
        }
        else{
            return memory_.get(readIdx_);
        }
    }

    @Override
    public boolean isEmpty() {
        return elemCounter_<=0;
    }

    @Override
    public boolean isFull() {
        return elemCounter_ >= memory_.size();
    }
}
