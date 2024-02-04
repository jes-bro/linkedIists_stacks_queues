/**
 * A class to test MyQueue, a class
 * that represents a simple queue
 * with enqueueing, dequeueing, and empty checking
 * functionalities
 */

import org.junit.Test
import org.junit.Assert.*

class TestQueue {
    val queue = MyQueue<Int>()

    /**
     * Test that enqueue puts keeps the first element in at the top
     * and grows downward
     */
    @Test
    // Test that enqueue queues top down
    fun testEnqueue() {
        queue.enqueue(20)
        queue.enqueue(40)
        assertEquals("Check enqueue queues top down", 20, queue.peek())
    }

    /**
     * Test that the first element to go into the queue
     * will be the first out
     * Test that dequeue will return null if the queue
     * is empty
     */
    @Test
    // Check that dequeue dequeues from the top
    fun testDequeue() {
        queue.enqueue(20)
        queue.enqueue(40)
        queue.dequeue()
        assertEquals("Check enqueue dequeues things bottom up", 40, queue.peek())
        queue.dequeue()
        assertEquals("Check that dequeue returns null when the queue is empty", null, queue.dequeue())
    }

    /**
     * Test that peek shows the front of the queue
     * and that peek returns null when the queue
     * is empty
     */
    @Test
    // Test that peek shows the front of the queue
    fun testPeek() {
        queue.enqueue(20)
        queue.enqueue(40)
        queue.enqueue(60)
        queue.dequeue()
        assertEquals("Check that peek shows the front of the queue", 40, queue.peek())
        queue.dequeue()
        queue.dequeue()
        assertEquals("Check that peek is null when the queue is empty", null, queue.peek())

    }

    /**
     * Test that isEmpty returns true if the queue is empty
     * and false if it is not
     */
    @Test
    // Check that after queueing and dequeueing the queue is empty
    fun testIsEmpty() {
        queue.enqueue(20)
        queue.enqueue(40)
        queue.dequeue()
        // Test when queue is empty
        assertEquals("Check that the isEmpty is false", false, queue.isEmpty())
        queue.dequeue()
        // Test when queue is not empty
        assertEquals("Check that the isEmpty is true", true, queue.isEmpty())
    }
}