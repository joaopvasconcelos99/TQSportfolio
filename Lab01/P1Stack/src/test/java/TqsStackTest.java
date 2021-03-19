import org.junit.jupiter.api.DisplayName;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class TqsStackTest {

    private TqsStack<String> stack01;
    private TqsStack<String> stack02;


    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        stack01 = new TqsStack<>(); //empty stack

        stack02 = new TqsStack<>(); //stack with some elements
        stack02.push("A");
        stack02.push("B");
        stack02.push("C");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @DisplayName("a) Empty stack on construction test")
    @org.junit.jupiter.api.Test
    void isEmpty() {
        TqsStack<String> stack = new TqsStack<>();
        assertTrue( stack.isEmpty(), "Empty stack should be empty!");
    }

    @DisplayName("b) Check if size is 0 on construction")
    @org.junit.jupiter.api.Test
    void sizeOnConstruction() {
        TqsStack<String> stack = new TqsStack<>();
        assertEquals(0, stack.size());
    }

    @DisplayName("c) After n pushes (5) check if stack is not empty and size = n (5)")
    @org.junit.jupiter.api.Test
    void pushNElements() {
        TqsStack<String> stack = new TqsStack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");

        assertFalse(stack.isEmpty());
        assertEquals(5,stack.size());
    }



    @DisplayName("d) If we push an element D and then pop, the value popped is D")
    @org.junit.jupiter.api.Test
    void popOnNoneEmptyStack() {
        stack02.push("D");
        assertEquals("D", stack02.pop());
    }

    @DisplayName("e) If we push an element E then peek, the value peeked is E and the size stays the same after peek")
    @org.junit.jupiter.api.Test
    void peekOnNoneEmptyStack() {
        stack02.push("E");
        int stackSizeAfterPush = stack02.size();
        assertEquals("E", stack02.peek());
        assertEquals(stackSizeAfterPush,stack02.size()); //size stays the same after peek
    }


    @DisplayName("f) if size = n (5) then after n=5 pops the stack is empty and size=0")
    @org.junit.jupiter.api.Test
    void popNElements() {
        TqsStack<String> stack = new TqsStack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");

        assertFalse(stack.isEmpty());
        assertEquals(5,stack.size()); // check size = 5

        //pop n=5 elements
        for(int i = 0 ; i < 5 ; i++){
            stack.pop();
        }

        assertTrue( stack.isEmpty(), "Empty stack should be empty!");
        assertEquals(0,stack.size());
    }

    @DisplayName("g) Popping empty stack throws exception")
    @org.junit.jupiter.api.Test
    void assertEmptyPop() {
        assertThrows(NoSuchElementException.class, () -> {
            stack01.pop();
        });
    }

    @DisplayName("g) Peeking empty stack throws exception")
    @org.junit.jupiter.api.Test
    void assertEmptyPeek() {
        assertThrows(NoSuchElementException.class, () -> {
            stack01.peek();
        });
    }

    @DisplayName("pushing onto a full stack (max size is set) throws exception")
    @org.junit.jupiter.api.Test
    void assertPushToFull() {
        TqsStack<String> stack = new TqsStack<>(1);
        stack.push("a");

        assertThrows(IllegalStateException.class, () -> {
            stack.push("b");
        });
    }
}