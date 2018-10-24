import java.util.Iterator;
import java.util.List;

public class MutableStack<E> {

    private Node<E> topOfStack;

    //Subclasse Node<E>
    private static class Node<E>{
        private E elem;
        private Node<E> next;

        private Node(E elem, Node<E> next){
            this.elem = elem;
            this.next = next;
        }
    }

    public MutableStack(){
        topOfStack = null;
    }

    public static <E> MutableStack<E> stackFromList(List<E> list){
        Iterator<E> it = list.iterator();
        MutableStack<E> stack = new MutableStack<E>();
        while(it.hasNext()){
            E elem = it.next();
            stack.push(elem);
        }
        return stack;
    }

    public void push(E elem) {
        topOfStack = new Node<>(elem, topOfStack);
    }

    public E pop() throws StackError {
        E elem =  topOfStack.elem;
        topOfStack = topOfStack.next;
        return elem;
    }

    public E top() throws StackError {
        return topOfStack.elem;
    }

    public boolean isEmpty() {
        try{
            return topOfStack.equals(null);
        }catch(NullPointerException ex){
            return false;
        }
    }
}
