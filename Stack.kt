/**
 * A stack class.
 *
 * This class implements a stack that adheres to the Stack interface.
 *
 * @param T the type of the data in each stack node.
 *
 */
package org.example
import DoublyLinkedList
import MyQueue

interface Stack<T> {
    /**
     * Add [data] to the top of the stack
     */
    fun push(data: T)
    /**
     * Remove the element at the top of the stack.  If the stack is empty, it remains unchanged.
     * @return the value at the top of the stack or nil if none exists
     */
    fun pop(): T?
    /**
     * @return the value on the top of the stack or nil if none exists
     */
    fun peek(): T?
    /**
     * @return true if the stack is empty and false otherwise
     */
    fun isEmpty(): Boolean
}


/**
 * The MyStack class represents a simple stack
 * The stack supports push, pop, and isEmpty in O(1) time.
 * It also supports reversing the order of the nodes in
 * the stack.
 */
class MyStack<T>: Stack<T> {
    private var doublyLinkedList = DoublyLinkedList<T>()
    var size: Int = 0
    /**
     * Add [data] to the top of the stack.
     * @param data The information to be added to the stack.
     */
    override fun push(data: T) {
        doublyLinkedList.pushFront(data)
        size+=1
    }
    
    /**
     * Remove the element at the top of the stack.
     * If the stack is empty, it remains unchanged.
     * @return the value at the top of the stack or nil if none exists.
     */
    override fun pop(): T? {
        size-=1
        return doublyLinkedList.popFront()
    }
    
    /**
     * Look at the value on the top of the stack.
     * @return the value on the top of the stack or nil if none exists.
     */
    override fun peek(): T? {
        return doublyLinkedList.peekFront()
    }
    
    /**
     * Check if the stack is empty.
     * @return true if the stack is empty and false otherwise.
     */
    override fun isEmpty(): Boolean {
        return doublyLinkedList.isEmpty()
    }

    /**
     * Reverse the order of the nodes in the stack.
     */
    fun reverse() {
        val tempQueue: MyQueue<T> = MyQueue()
        val overallSize: Int = size
        for (i in 1.. overallSize) {
            val firstIn = this.pop()
            //println(first_in)
            if (firstIn != null) {
                tempQueue.enqueue(firstIn)
            }
        }
        for (i in 1.. overallSize) {
            val nextItem = tempQueue.dequeue()
            //println(next_item)
            if (nextItem != null) {
                this.push(nextItem)
            }
        }
    }

}
