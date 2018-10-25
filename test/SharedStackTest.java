import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
            err.printStackTrace();
        }
    }

    @org.junit.Test
    public void pushEmptyStack(){
        assertEquals(expectedStack.contentToString(), stack.contentToString());
    }

    @org.junit.Test
    public void changingElement(){
        stack = new SharedStack();
        Employee emp =  new Employee("Oriol", "78099079A");
        stack = (SharedStack) stack.push(emp);
        SharedStack stack2 = (SharedStack) stack.push(2);
        emp.setName("Marta");
        expectedStack = new SharedStack();
        expectedStack = (SharedStack) expectedStack.push(emp);
        System.out.println(expectedStack.adressToString() + stack.adressToString() + stack2.adressToString());

        assertTrue(SharedStack.isSameContent(expectedStack,stack));
        assertFalse(SharedStack.isSameAdress(expectedStack,stack)); //Comparteixen element però no node
        try{
            assertTrue(SharedStack.isSameContent(expectedStack, (SharedStack<? extends Object>) stack2.pop()));
            assertTrue(SharedStack.isSameAdress(stack, (SharedStack<? extends Object>) stack2.pop()));
        } catch (StackError er){

        }
    }

}