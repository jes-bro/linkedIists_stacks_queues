/**
 * A doubly linked list interface
 *
 * This interface specifies a doubly linked list
 *
 * @param T the type of the data in each linked list node
 *
 */

interface DoublyLinkedListUniversal<T> {
    /**
     * Adds the element [data] to the front of the linked list.
     */
    fun pushFront(data: T)

    /**
     * Adds the element [data] to the back of the linked list.
     */
    fun pushBack(data: T)

    /**
     * Removes an element from the front of the list. If the list is empty, it is unchanged.
     * @return the value at the front of the list or nil if none exists
     */
    fun popFront(): T?

    /**
     * Removes an element from the back of the list. If the list is empty, it is unchanged.
     * @return the value at the back of the list or nil if none exists
     */
    fun popBack(): T?

    /**
     * @return the value at the front of the list or nil if none exists
     */
    fun peekFront(): T?

    /**
     * @return the value at the back of the list or nil if none exists
     */
    fun peekBack(): T?

    /**
     * @return true if the list is empty and false otherwise
     */
    fun isEmpty(): Boolean

}

/**
 * A doubly linked list class
 *
 * This class implements a doubly linked list
 *
 * @param T the type of the data in each linked list node
 *
 */
class DoublyLinkedList<T>: DoublyLinkedListUniversal<T> {
    internal var head: LinkedListNode<T>?=null
    internal var tail: LinkedListNode<T>?=null
    internal class LinkedListNode<T>(val data: T, var next: LinkedListNode<T>?, var prev: LinkedListNode<T>?)
    /**
     * Adds the element [data] to the front of the linked list
     * @param data The information being stored in the new head
     * linked list node.
     */
    override fun pushFront(data: T) {
        val new_node = LinkedListNode(data = data, next = this.head, prev = null)
        if (this.head == null) {
            this.tail = new_node
        } else {
            this.head?.prev = new_node
        }
        this.head = new_node
    }
    /**
     * Adds the element [data] to the back of the linked list
     * @param data The information being stored in the new tail
     * linked list node
     */
    override fun pushBack(data: T) {
        val new_node = LinkedListNode(data = data, next = null, prev = this.tail)
        if (this.head == null) {
            head = new_node
        } else {
            this.tail?.next = new_node
        }
        this.tail = new_node
    }
    /**
     * Removes an element from the front of the list. If the list is empty, it is unchanged
     * @return the value at the front of the list or nil if none exists
     */
    override fun popFront(): T? {
        if (this.isEmpty()) {
            return null
        } else {
            val value = this.head?.data
            if (this.head?.next == null) {
                this.tail = null
            }
            this.head = head?.next
            this.head?.prev = null
            return value
        }
    }
    /**
     * Removes an element from the back of the list. If the list is empty, it is unchanged
     * @return the value at the back of the list or nil if none exists
     */
    override fun popBack(): T? {
        if (this.isEmpty()) {
            return null
        } else {
            val new_last = this.tail?.prev
            if (this.tail?.prev == null) {
                this.head = null
            }
            val elem_at_back = this.tail?.data
            new_last?.next = null
            this.tail = new_last
            return elem_at_back
        }

    }
    /**
     * Shows the data stored at the front of the list
     * @return the value at the front of the list or nil if none exists
     */
    override fun peekFront(): T? {
        return this.head?.data
    }

    /**
     * Shows the data stored at the front of the list
     * @return the value at the back of the list or nil if none exists
     */
    override fun peekBack(): T? {
        return this.tail?.data
    }

    /**
     * Checks if the linked list is empty
     * @return true if the list is empty and false otherwise
     */
    override fun isEmpty(): Boolean {
        return this.head == null
    }

}