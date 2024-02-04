/**
 * A class for testing the doubly linked list.
 *
 * This class tests all of the functions associated with the
 * DoublyLinkedList class
 *
 */
import org.junit.Assert.*
import org.junit.Test

class TestDoublyLinkedList {
    val linkedList = DoublyLinkedList<Int>()

    /**
     * Test that the data field works as expected and that
     * the pushFront method correctly adds the new data
     * to the head of the linked list
     */
    @Test
    fun testPushFront() {
        // Test data
        val data = 15
        // Test that linkedlist head gets correctly updated after pushFront
        linkedList.pushFront(data)
        // Ensuring that head.data stores the information
        assertEquals("Data is what we expect", 15, linkedList.head?.data)
    }

    /**
     * Test that pushBack stores new data at the back of the list
     * Test that the new data becomes the data at the tail
     * Test that this doesn't affect the head unless there is only
     * one node in the list
     */
    @Test
    fun testPushBack() {
        val data = 15
        linkedList.pushBack(data)
        // Test that tail is head for linked list with one node
        assertEquals("Head is what we expect", 15, linkedList.head?.data)
        val data2 = 20
        linkedList.pushBack(data2)
        // Test that data is correct for the tail
        assertEquals("Tail is what we expect", 20, linkedList.tail?.data)
        // Test that tail.next doesn't point to any other node
        assertEquals("Tail next is null", null, linkedList.tail?.next)
        // Test that head stays same when new node is added to back
        assertEquals("Head is what we expect", 15, linkedList.head?.data)

    }

    /**
     * Test that pop back removes the last node from the list
     * and makes the tail the next last value
     * Test that the correct value gets returned
     */
    @Test
    fun testPopBack() {
        val data = 15
        linkedList.pushFront(data)
        val data2 = 20
        linkedList.pushBack(data2)
        // Test that popback returns the value at the tail
        assertEquals("Pop back returns the correct data", linkedList.tail?.data, linkedList.popBack())
        // Test that the tail is now the second to last data we inputted
        // Test that when back is popped head equals tail
        assertEquals("Tail is what we expect", 15, linkedList.tail?.data)
        linkedList.popBack()
        // Test that when last node is popped head equals tail
        assertEquals("Tail is what we expect", null, linkedList.head?.data)
        assertEquals("Head is what we expect", null, linkedList.tail?.data)
    }

    /**
     * Test that popFront removes the top node from the list
     * and makes the next value in the head
     * Test that the correct value gets returned
     */
    @Test
    fun testPopFront() {
        val data = 15
        linkedList.pushFront(data)
        val data2 = 20
        linkedList.pushBack(data2)
        assertEquals("Head is what we expect", linkedList.head?.data, linkedList.popFront())
        // Make sure that second element in is now head
        assertEquals("Head is what we expect", 20, linkedList.head?.data)
        // Make sure that because there is one element
        // in the list the head is also the tail
        assertEquals("Tail is what we expect", 20, linkedList.tail?.data)
        linkedList.popFront()
        // Make sure that an empty list has head null and tail null
        assertEquals("Head is what we expect", null, linkedList.head?.data)
        assertEquals("Tail is what we expect", null, linkedList.tail?.data)
    }

    /**
     * Make sure that popFront shows the data at the head of the
     * list but does not remove that data
     */
    @Test
    fun testPeekFront() {
        val data = 15
        linkedList.pushFront(data)
        val data2 = 20
        linkedList.pushBack(data2)
        assertEquals("peekFront returns correct info", linkedList.peekFront(), linkedList.head?.data)
        //Make sure peekFront didn't modify the data at the head of the class or the linkedlist
        //structure
        assertEquals("Head is what we expect", 15, linkedList.head?.data)
        linkedList.popFront()
        // Make sure peekFront returns the new data at the top of the list
        assertEquals("Head is what we expect", linkedList.peekFront(), linkedList.head?.data)
        assertEquals("Head is what we expect", linkedList.peekFront(), linkedList.tail?.data)
        linkedList.popFront()
        // Make sure peekFront returns null for an empty list
        assertEquals("Head is what we expect", null, linkedList.peekFront())
    }

    /**
     * Make sure that popBack shows the data at the head of the
     * list but does not remove that data
     */
    @Test
    fun testPeekBack() {
        val data = 15
        linkedList.pushFront(data)
        // Make sure peak back returns head data when list has one node
        assertEquals("peekBack returns correct info", linkedList.head?.data, linkedList.peekBack())
        // and the same thing for tail data
        assertEquals("peekBack returns correct info", linkedList.tail?.data, linkedList.peekBack())
        val data2 = 20
        linkedList.pushBack(data2)
        // Make sure that peekBack shows tail data when list has multiple nodes
        assertEquals("Tail is what we expect", linkedList.peekBack(), linkedList.tail?.data)
        // Make sure it doesn't affect the head
        assertEquals("Head is what we expect",15, linkedList.head?.data)
        linkedList.popFront()
        linkedList.popBack()
        // Make sure peekBack returns null when the list is empty
        assertEquals("Head is what we expect", null, linkedList.peekBack())
    }

    /**
     * Make sure that when the list is empty
     * isEmpty returns true
     * Make sure that when the list is not
     * empty, isEmpty returns false
     */
    @Test
    fun testIsEmpty() {
        val data = 15
        linkedList.pushFront(data)
        val data2 = 20
        linkedList.pushBack(data2)
        linkedList.popFront()
        linkedList.popBack()
        // Make sure it returns true when list is empty
        assertEquals("isEmpty returns what we expect", true, linkedList.isEmpty())
        linkedList.pushFront(data)
        // Make sure it returns false when list is not empty
        assertEquals("isEmpty returns what we expect", false, linkedList.isEmpty())
    }
}