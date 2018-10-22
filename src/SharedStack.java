import java.util.Iterator;
import java.util.List;

public class SharedStack<E> implements Stack<E>{
    //Atributs
    private final Node<E> topOfStack;

    //Subclasse Node<E>
    private static class Node<E>{
        private final E elem;
        private final Node<E> next;

        private Node(E elem, Node<E> next){
            this.elem = elem;
            this.next = next;
        }
    }

    //Constructors
    public SharedStack(){
        topOfStack = null;
    }

    public SharedStack(Node<E> topOfStack){
        this.topOfStack = topOfStack;
    }

    public static <E> Stack<E> asList(List<E> list){
        Iterator<E> it = list.iterator();
        Stack<E> stack = new SharedStack<>();
        while(it.hasNext()){
            E elem = it.next();
            stack = stack.push(elem);
        }
        return stack;
    }

    //Mètodes de Stack<E>
    @Override
    public Stack<E> push(E elem) {
        return new SharedStack<E>(new Node<E>(elem, this.topOfStack));
    }

    @Override
    public Stack<E> pop() throws StackError {
        return new SharedStack<>(topOfStack.next);
    }

    @Override
    public E top() throws StackError {
        return topOfStack.elem;
    }

    @Override
    public boolean isEmpty() {
        try{
            return topOfStack.equals(null);
        }catch(NullPointerException ex){
            return false;
        }
    }
}
