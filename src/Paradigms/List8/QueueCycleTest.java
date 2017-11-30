package Paradigms.List8;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class QueueCycleTest {
    @Test
    public void shouldSize0QueueBeEmpty() {
        int size = 0;
        MyQueue<String> emptyQueue = new QueueCycle<>(size);

        assertTrue(emptyQueue.isEmpty());
        assertTrue(emptyQueue.isFull());
        assertEquals(new ArrayList<String>(), emptyQueue.toArrayList());
    }

    @Test
    public void shouldSize3QueueBeEmpty() {
        int size = 3;
        MyQueue<String> emptyQueue = new QueueCycle<>(size);

        assertTrue(emptyQueue.isEmpty());
        assertFalse(emptyQueue.isFull());
        assertEquals(new ArrayList<String>(), emptyQueue.toArrayList());
    }

    @Test
    public void shouldInsertOneElemSize0Queue(){
        int size = 0;
        boolean isExceptionHandled = false;
        MyQueue<String> emptyQueue = new QueueCycle<>(size);
        ArrayList<String> expectedQueue = new ArrayList(size);

        try {
            emptyQueue.enqueue("123");
        }catch(FullException e){
            System.out.println(e.getMessage());
            assertTrue(true);
            isExceptionHandled = true;
        }

        if(!isExceptionHandled){
            assertFalse(true);
        }
    }
}