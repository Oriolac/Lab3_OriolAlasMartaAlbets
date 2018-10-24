import java.util.Arrays;

import static org.junit.Assert.*;

public class SharedStackTest {

    SharedStack expectedStack = new SharedStack<>();
    SharedStack stack = new SharedStack<>();


    @org.junit.Test
    public void testSameContent(){
        stack = (SharedStack) stack.push(4);
        stack = (SharedStack) stack.push(3L);
        stack = (SharedStack) stack.push(null);
        expectedStack = (SharedStack) SharedStack.stackFromList(Arrays.asList(4,3L, null));
        assertTrue(SharedStack.isSameContent((SharedStack) expectedStack, (SharedStack) stack));
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

    @org.junit.Test
    public void pushEmptyStack(){
        assertEquals(expectedStack.contentToString(), stack.contentToString());
    }

}