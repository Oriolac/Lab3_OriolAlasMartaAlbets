import java.util.Arrays;

import static org.junit.Assert.*;

public class SharedStackTest {

    Stack expectedStack = new SharedStack<>();
    Stack stack = new SharedStack<>();


    @org.junit.Test
    public void hello(){
        stack =  stack.push(4);
        stack = stack.push(3L);
        expectedStack = SharedStack.stackFromList(Arrays.asList(4,3L));
        assertEquals(expectedStack.toString(), stack.toString());
    }

}