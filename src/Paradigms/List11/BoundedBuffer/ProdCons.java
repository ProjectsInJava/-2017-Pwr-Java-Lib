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

    // Used notify rather than notifyAll
    // Deadlocks is about Google Nexus release
    // A lot of consumers
    // Google starts to produce them with delay
    // ASAP filled up the magazines and producers went on holiday
    // Consumers are still waiting on product but there is noone to notif them about it

    // Notifs always received by consumers

}
