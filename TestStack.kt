/**
 * A class to test myStack, a class
 * representing a simple stack
 * with pushing, popping, empty checking,
 * and reversing functionalities
 */
import org.example.MyStack
import org.junit.Assert.*
import org.junit.Test

class TestStack {
    val stack = MyStack<Int>()

    /**
     * Test whether push puts the new node on the top
     * of the stack
     */
    @Test
    // Test that pushing to a stack and peeking yields the stack node at the top
    // AKA the last one to go in
    fun testPush() {
        stack.push(20)
        stack.push(15)
        stack.push(30)
        assertEquals("Stack peek equals the last data pushed", 30, stack.peek())
    }

    /**
     * Test whether pop removes the item at the top of the stack
     * (the last node to be added)
     * Test if after popping the new item on top is the one added
     * second to last
     */
    @Test
    // Test that pop removes the last node to be pushed
    // so the second to last node pushed shows up during peek
    fun testPop() {
        stack.push(20)
        stack.push(15)
        stack.push(30)
        stack.push(40)
        // Test if pop returns the latest node added
        assertEquals("Pop returns the data from the correct node", 40, stack.pop())
        assertEquals("Stack peek yields second to last node added", 30, stack.peek())
        stack.pop()
        stack.pop()
        stack.pop()
        assertEquals("Check if pop returns null when the stack is empty", null, stack.pop())
    }

    /**
     * Test that peek returns the last node added to the stack
     * and null if the stack is empty
     */
    @Test
    // Test that peek yields the last thing first
    // I know this is tested implicitly in other tests
    fun testPeek() {
        stack.push(20)
        assertEquals("Stack peek yields last node added", 20, stack.peek())
        stack.push(15)
        assertEquals("Stack peek yields last thing added", 15, stack.peek())
        stack.pop()
        stack.pop()
        assertEquals("Check if peek returns null when stack is empty", null, stack.peek())
    }

    /**
     * Test that isEmpty returns true when the stack is empty
     * and false when the stack is not empty
     */
    @Test
    // Test that the stack empties after pushing and popping
    fun testIsEmpty() {
        stack.push(10)
        stack.pop()
        assertEquals("Check if isEmpty is tue", true, stack.peek())
    }

    /**
     * Test that reverse puts the bottom of the stack at the top
     */
    @Test
    // Test that peeking after a reversal shows the bottom of the original stack at the top
    fun testReverse() {
        stack.push(20)
        //println(stack.size)
        stack.push(30)
        //println(stack.size)
        stack.push(40)
        //println(stack.peek())
        //println(stack.size)
        stack.reverse()
        // Test that reversal puts the bottom of the stack at the top
        assertEquals("Top of stack is what would be bottom", 20, stack.peek())
        //println(stack.peek())
    }
}