import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;

public class SharedStackTest {

    SharedStack expectedStack = new SharedStack<>();
    SharedStack stack = new SharedStack<>();

    @org.junit.Test
    public void testSameContent(){
        stack = stack.push(4);
        stack = stack.push(3L);
        stack = stack.push(null);
        expectedStack = SharedStack.stackFromList(Arrays.asList(4,3L, null));
        assertTrue(SharedStack.isSameContent(expectedStack, stack));
    }

    @org.junit.Test
    public void testSameAdress(){
        SharedStack s1 = SharedStack.stackFromList(Arrays.asList(1,3));
        SharedStack s2 = s1.push(4);
        try{
            SharedStack s3 = s2.pop();
            assertTrue(SharedStack.isSameAdress(s1,s3));
        }catch(StackError err){
            err.printStackTrace();
        }
    }

    @org.junit.Test
    public void testEmptyStack(){
        assertEquals(expectedStack.contentToString(), stack.contentToString());
    }

    @org.junit.Test
    public void changingElement(){
        Employee emp =  new Employee("Oriol", "78099079A");
        stack = stack.push(emp);
        SharedStack stack2 = stack.push(2);
        emp.setName("Marta");
        expectedStack = expectedStack.push(emp);
        assertTrue(SharedStack.isSameContent(expectedStack,stack));
        assertFalse(SharedStack.isSameAdress(expectedStack,stack)); //Comparteixen element però no node
        try{
            assertTrue(SharedStack.isSameContent(expectedStack, (SharedStack<? extends Object>) stack2.pop()));
            assertTrue(SharedStack.isSameAdress(stack, (SharedStack<? extends Object>) stack2.pop()));
        } catch (StackError er){

        }
    }

    @org.junit.Test
    public void pop(){
        stack = SharedStack.stackFromList(Arrays.asList(4,3L,8));
        try{
            stack = stack.pop();
            expectedStack = SharedStack.stackFromList(Arrays.asList(4,3L));
            assertTrue(SharedStack.isSameContent(expectedStack, stack));
        } catch(StackError er){
            er.printStackTrace();
        }
    }


    @Test
    public void isEmpty() {
        stack = new SharedStack();
        assertTrue(stack.isEmpty());
        stack = stack.push(2);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void sharingMemory(){
        MutableEmployeeStack m = MutableEmployeeStack.stackFromList(Arrays.asList(new Employee("hol", "hol")));
        SharedStack s = new SharedStack(m.getTopOfStack());
        m.setTopOfStack(2);
        assertEquals(m.contentToString(), s.contentToString());

    }
}