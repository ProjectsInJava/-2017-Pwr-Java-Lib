package Paradigms.List8;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class QueueCycleTest {
    @Test
    public void shouldSize0QueueBeEmpty() {
        int size = 0;
        MyQueue<String> emptyQueue = new QueueCycle<>(size);
        ArrayList<String> expectedQueue = new ArrayList<>(size);

        assertTrue(emptyQueue.isEmpty());
        assertTrue(emptyQueue.isFull());
        assertEquals(expectedQueue, emptyQueue.toArrayList());
    }

    @Test
    public void shouldSize1QueueBeEmpty() {
        int size = 1;
        MyQueue<String> emptyQueue = new QueueCycle<>(size);
        ArrayList<String> expectedQueue = new ArrayList<>(size);
        expectedQueue.add(null);

        assertTrue(emptyQueue.isEmpty());
        assertFalse(emptyQueue.isFull());
        assertEquals(expectedQueue, emptyQueue.toArrayList());
    }
    /*
    @Test
    public void shouldSize3QueueBeEmpty() {
        int size = 3;
        MyQueue<String> emptyQueue = new QueueCycle<>(size);
        ArrayList<String> expectedQueue = new ArrayList(size);
        expectedQueue.add(null);
        expectedQueue.add(null);
        expectedQueue.add(null);

        assertTrue(emptyQueue.isEmpty());
        assertFalse(emptyQueue.isFull());
//        assertEquals(new ArrayList<String>(), emptyQueue.toArrayList());
    }

    @Test
    public void shouldInsertOneElemToSize0Queue(){
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

    @Test
    public void shouldInsertOneElemToSize1Queue(){
        int size = 1;
        boolean isExceptionHandled = false;
        MyQueue<String> queue = new QueueCycle<>(size);
        ArrayList<String> expectedQueue = new ArrayList<>(size);
        expectedQueue.add("1");

        try {
            queue.enqueue("1");
        }catch(FullException e){
            System.out.println(e.getMessage());
            assertTrue(false);
            isExceptionHandled = true;
        }

        if(!isExceptionHandled){
            assertTrue(queue.isFull());
            assertEquals(expectedQueue, queue.toArrayList());
        }
    }

    @Test
    public void shouldInsertTwoElemToSize1Queue(){
        int size = 1;
        boolean isExceptionHandled = false;
        MyQueue<String> queue = new QueueCycle<>(size);
        ArrayList<String> expectedQueue = new ArrayList<>(size);
        expectedQueue.add("2");

        try {
            queue.enqueue("1");
            queue.enqueue("2");
        }catch(FullException e){
            System.out.println(e.getMessage());
            assertTrue(false);
            isExceptionHandled = true;
        }

        if(!isExceptionHandled){
            assertTrue(queue.isFull());
            assertEquals(expectedQueue, queue.toArrayList());
        }
    }

    @Test
    public void shouldInsertThreeElemToSize1Queue(){
        int size = 1;
        boolean isExceptionHandled = false;
        MyQueue<String> queue = new QueueCycle<>(size);
        ArrayList<String> expectedQueue = new ArrayList<>(size);
        expectedQueue.add("3");

        try {
            queue.enqueue("1");
            queue.enqueue("2");
            queue.enqueue("3");
        }catch(FullException e){
            System.out.println(e.getMessage());
            assertTrue(false);
            isExceptionHandled = true;
        }

        if(!isExceptionHandled){
            assertTrue(queue.isFull());
            assertEquals(expectedQueue, queue.toArrayList());
        }
    }

    @Test
    public void shouldInsertThreeElemToSize4Queue(){
        int size = 4;
        boolean isExceptionHandled = false;
        MyQueue<String> queue = new QueueCycle<>(size);
        ArrayList<String> expectedQueue = new ArrayList<>(size);
        expectedQueue.add("1");
        expectedQueue.add("2");
        expectedQueue.add("3");
        expectedQueue.add(null);

        try {
            queue.enqueue("1");
            queue.enqueue("2");
            queue.enqueue("3");
        }catch(FullException e){
            System.out.println(e.getMessage());
            assertTrue(false);
            isExceptionHandled = true;
        }

        if(!isExceptionHandled){
            assertFalse(queue.isFull());
            ArrayList<String> toArrayList = queue.toArrayList();
            assertEquals(expectedQueue, queue.toArrayList());
        }
    }

    @Test
    public void shouldInsertFiveElemToSize3Queue(){
        int size = 3;
        boolean isExceptionHandled = false;
        MyQueue<String> queue = new QueueCycle<>(size);
        ArrayList<String> expectedQueue = new ArrayList<>(size);
        expectedQueue.add("4");
        expectedQueue.add("5");
        expectedQueue.add("3");

        try {
            queue.enqueue("1");
            queue.enqueue("2");
            queue.enqueue("3");
            queue.enqueue("4");
            queue.enqueue("5");
        }catch(FullException e){
            System.out.println(e.getMessage());
            assertTrue(false);
            isExceptionHandled = true;
        }

        if(!isExceptionHandled){
            assertTrue(queue.isFull());
            assertEquals(expectedQueue, queue.toArrayList());
        }
    }

    @Test
    public void shouldEnqueueElemAndDequeueElemFromSize1Queue() throws FullException{
        int size = 1;
        MyQueue<String> queue = new QueueCycle<>(size);
        ArrayList<String> expectedQueue = new ArrayList<>(size);

        queue.enqueue("1");
        queue.dequeue();

        assertFalse(queue.isFull());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void shouldEnqueue6ElemAndDequeue3ElemFromSize3Queue() throws FullException, EmptyException{
        int size = 3;
        MyQueue<String> queue = new QueueCycle<>(size);

        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.enqueue("5");
        queue.enqueue("6");
        String top = queue.first();

        queue.dequeue();
        queue.dequeue();
        //queue.dequeue();

        String top2 = queue.first();

        assertTrue(false);
    }
    */
}