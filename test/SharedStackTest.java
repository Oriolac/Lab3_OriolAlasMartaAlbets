import org.junit.Test;

import static org.junit.Assert.*;

public class SharedStackTest {

    SharedStack stack = new SharedStack<>();
    SharedStack expectedStack = new SharedStack<>();

    @Test
    public void push() {
    }

    @Test
    public void pop() {
        try{
            expectedStack.top();
        }catch(StackError er){

        }
    }


    @Test
    public void topWhenStackIsNull(){
        try{
            assertEquals(null, stack.top());
        }catch(StackError er){

        }
    }
    @Test
    public void isEmpty() {
    }
}