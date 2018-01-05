package Paradigms.List8;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
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

        try {
            queue.enqueue("123");
        }catch(FullException e){
            System.out.println(e.getMessage());
            assertTrue(queue.isEmpty());
            assertTrue(queue.isFull());
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
        String expectedTop = "1";

        try {
            queue.enqueue("1");
        }catch(FullException e){
            System.out.println(e.getMessage());
            assertTrue(false);
            isExceptionHandled = true;
        }

        if(!isExceptionHandled){
            assertFalse(queue.isEmpty());
            assertTrue(queue.isFull());
            assertEquals(expectedTop, queue.first());
        }
    }

    @Test
    public void shouldInsertTwoElemToSize1Queue() throws EmptyException {
        int size = 1;
        boolean isExceptionHandled = false;
        MyQueue<String> queue = new QueueCycle<>(size);
        String expectedTop = "1";

        try {
            queue.enqueue("1");
            queue.enqueue("2");
        }catch(FullException e){
            System.out.println(e.getMessage());
            assertFalse(queue.isEmpty());
            assertTrue(queue.isFull());
            assertEquals(expectedTop, queue.first());
            isExceptionHandled = true;
        }

        if(!isExceptionHandled){
            assertTrue(false);
        }
    }

    @Test
    public void shouldInsertTwoElemThenDequeueThenInsertToSize1Queue() throws EmptyException, FullException {
        int size = 1;
        boolean isExceptionHandled = false;
        MyQueue<String> queue = new QueueCycle<>(size);
        String expectedFirstTop = "1";
        String expectedSecondTop = "2";

        try {
            queue.enqueue("1");
            queue.enqueue("2");
        }catch(FullException e){
            System.out.println(e.getMessage());
            assertEquals(expectedFirstTop, queue.first());
            queue.dequeue();
            assertTrue(queue.isEmpty());
            assertFalse(queue.isFull());

            queue.enqueue("2");
            assertFalse(queue.isEmpty());
            assertTrue(queue.isFull());
            assertEquals(expectedSecondTop, queue.first());
            isExceptionHandled = true;
        }

        if(!isExceptionHandled){
            assertTrue(false);
        }
    }

    @Test
    public void shouldInsertThreeElemToSize1Queue() throws EmptyException, FullException {
        int size = 3;
        MyQueue<String> queue = new QueueCycle<>(size);
        String fstVal = "1";
        String sndVal = "2";
        String thirdVal = "3";
        String fourthVal = "4";

        queue.enqueue(fstVal);
        assertEquals(fstVal, queue.first());
        queue.enqueue(sndVal);
        assertEquals(fstVal, queue.first());
        queue.enqueue(thirdVal);
        assertEquals(fstVal, queue.first());

        queue.dequeue();
        assertEquals(sndVal, queue.first());

        queue.enqueue(fourthVal);
        assertEquals(sndVal, queue.first());

        queue.dequeue();
        assertEquals(thirdVal, queue.first());

        queue.dequeue();
        assertEquals(fourthVal, queue.first());

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        try{
            assertEquals(fourthVal, queue.first());
        }catch(EmptyException e){
            System.out.println(e.getMessage());
            assertTrue(queue.isEmpty());
            assertFalse(queue.isFull());

            queue.enqueue(fstVal);
            assertFalse(queue.isEmpty());
            assertFalse(queue.isFull());

            assertEquals(fstVal, queue.first());
        }
    }

    @Test
    public void shouldInsertThreeElemToSize4Queue() throws FullException, EmptyException {
        int size = 4;
        MyQueue<String> queue = new QueueCycle<>(size);
        String fstVal = "1";
        String sndVal = "2";
        String thirdVal = "3";

        queue.enqueue(fstVal);
        queue.enqueue(sndVal);
        queue.enqueue(thirdVal);

        assertFalse(queue.isEmpty());
        assertFalse(queue.isFull());
        assertEquals(fstVal, queue.first());
    }

    @Test
    public void shouldBehaveProperWhenManyEnqueuesAndDequeues() throws FullException, EmptyException {
        int size = 4;
        MyQueue<String> queue = new QueueCycle<>(size);
        String fstVal = "1";
        String sndVal = "2";
        String thirdVal = "3";
        String fourthVal = "4";
        String fifthVal = "5";

        queue.enqueue(fstVal);
        queue.enqueue(sndVal);
        assertEquals(fstVal, queue.first());

        queue.enqueue(thirdVal);
        queue.dequeue();
        assertEquals(sndVal, queue.first());

        queue.enqueue(fourthVal);
        queue.dequeue();
        assertEquals(thirdVal, queue.first());

        queue.enqueue(fifthVal);
        queue.dequeue();
        assertEquals(fourthVal, queue.first());

        queue.dequeue();
        assertEquals(fifthVal, queue.first());

        queue.dequeue();
        try{
            queue.first();
        }catch(EmptyException e){
            System.out.println(e.getMessage());
            assertTrue(queue.isEmpty());
            assertFalse(queue.isFull());

            queue.enqueue(fstVal);
            queue.enqueue(sndVal);
            assertFalse(queue.isEmpty());
            assertFalse(queue.isFull());
            assertEquals(fstVal, queue.first());
        }
    }
}
