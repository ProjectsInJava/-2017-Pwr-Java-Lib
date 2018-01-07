package Paradigms.List11.BoundedBuffer;

public class ProdCons {
    public static void main(String args[]){
        final int bufferCapacity = 5;
        final int numberOfConsumedElems = 3;
        final int numberOfProducedElems = 3;
        BoundedBuffer buf = new BoundedBuffer(bufferCapacity);
        Consumer[] cons = new Consumer[numberOfConsumedElems];
        Producer[] prods = new Producer[numberOfProducedElems];

        for (int i = 0; i < numberOfProducedElems; i++){
            prods[i] = new Producer("Producer " + (i+1), buf);
            prods[i].start();
        }

        for (int i = 0; i < numberOfConsumedElems; i++){
            cons[i] = new Consumer("Consumer " + (i+1), buf);
            cons[i].start();
        }
    }
}
