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
        MyQueue<String> queue = new QueueCycle<>(size);

        assertTrue(queue.isEmpty());
        assertTrue(queue.isFull());
    }

    @Test
    public void shouldSize1QueueBeEmpty() {
        int size = 1;
        MyQueue<String> queue = new QueueCycle<>(size);
        ArrayList<String> expectedQueue = new ArrayList<>(size);
        expectedQueue.add(null);

        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());
    }

    @Test
    public void shouldInsertOneElemToSize0Queue(){
        int size = 0;
        boolean isExceptionHandled = false;
        MyQueue<String> queue = new QueueCycle<>(size);
        ArrayList<String> expectedQueue = new ArrayList(size);

        try {
            queue.enqueue("123");
        }catch(FullException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            assertTrue(queue.isEmpty());
            assertTrue(queue.isFull());
            assertEquals(expectedQueue, queue.toArrayList());
            isExceptionHandled = true;
        }

        if(!isExceptionHandled){
            assertFalse(true);
        }
    }

    @Test
    public void shouldInsertOneElemToSize1Queue() throws EmptyException {
        int size = 1;
        boolean isExceptionHandled = false;
        MyQueue<String> queue = new QueueCycle<>(size);
        String expectedFirst = "1";

        try {
            queue.enqueue("1");
        }catch(FullException e){
            System.out.println(e.getMessage());
            assertTrue(false);
            isExceptionHandled = true;
        }

        if(!isExceptionHandled){
            assertFalse(queue.isEmpty());
            //assertTrue(queue.isFull());
            String firstVal = queue.first();
            assertEquals(expectedFirst, firstVal);
        }
    }

    /*
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