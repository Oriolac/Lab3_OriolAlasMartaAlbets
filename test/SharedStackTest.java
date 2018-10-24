import java.util.Arrays;

import static org.junit.Assert.*;

public class SharedStackTest {

    Stack expectedStack = new SharedStack<>();
    Stack stack = new SharedStack<>();


    @org.junit.Test
    public void hello(){
        stack =  stack.push(4);
        stack = stack.push(3L);
        stack = stack.push(null);
        expectedStack = SharedStack.stackFromList(Arrays.asList(4,3L, null));


        stack = new SharedStack<>();

    }

    @org.junit.Test
    public void testSameAdress(){
        SharedStack s1 = (SharedStack) SharedStack.stackFromList(Arrays.asList(1,3));
        SharedStack s2 = (SharedStack) s1.push(4);
        try{
            SharedStack s3 = (SharedStack) s2.pop();
            assertTrue(SharedStack.isSameAdress(s1,s3));
        }catch(StackError err){

        }

    }

}