/**
 * The Queue interface represents a queue implementation
 * that supports enqueue, dequeue, and, and isEmpty
 */
interface Queue<T> {
    /**
     * Add [data] to the end of the queue.
     */
    fun enqueue(data: T)
    /**
     * Remove the element at the front of the queue.  If the queue is empty, it remains unchanged.
     * @return the value at the front of the queue or nil if none exists
     */
    fun dequeue(): T?
    /**
     * @return the value at the front of the queue or nil if none exists
     */
    fun peek(): T?
    /**
     * @return true if the queue is empty and false otherwise
     */
    fun isEmpty(): Boolean
}

/**
 * The MyQueue class represents a simple queue
 * The queue supports enqueue, dequeue, and, and isEmpty
 */
class MyQueue<T> : Queue<T> {
    private var linked_list = DoublyLinkedList<T>()
    /**
     * Add [data] to the end of the queue.
     * @param data The information to be added to the queue
     */
    override fun enqueue(data: T) {
        linked_list.pushBack(data)
    }
    /**
     * Remove the element at the front of the queue.  If the queue is empty, it remains unchanged.
     * @return the value at the front of the queue or nil if none exists
     */
    override fun dequeue(): T? {
        return linked_list.popFront()
    }
    /**
     * Show the value at the top of the queue
     * @return the value at the front of the queue or nil if none exists
     */
    override fun peek(): T? {
        return linked_list.peekFront()
    }
    /**
     * Show whether the queue is empty or not
     * @return true if the queue is empty and false otherwise
     */
    override fun isEmpty(): Boolean {
        return linked_list.isEmpty()
    }
}
