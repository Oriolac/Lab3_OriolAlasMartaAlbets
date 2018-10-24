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

    public static <E> Stack<E> stackFromList(List<E> list){
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

    //Mètodes de comprovació de contingut i d'adreça dels nodes

    public static <E> boolean isSameContent(SharedStack<E> s1, SharedStack<E> s2){
        return s1.contentToString().equals(s2.contentToString());
    }

    public String contentToString(){
        try{
            return "{(TOP) " + contentToString(topOfStack) + "}";
        } catch (NullPointerException ex){
            return "Pila buida";
        }
    }

    private String contentToString(Node<E> node){
        if(node.next == null){
            return "" + node.elem;
        }
        return node.elem + ", " + contentToString(node.next);
    }

    public static <E> boolean isSameAdress(SharedStack<E> s1, SharedStack<E> s2){
        return s1.adressToString().equals(s2.adressToString());
    }

    public String adressToString() {
        try{
            return "{(TOP) " + adressToString(topOfStack) + "}";
        } catch (NullPointerException ex){
            return "Pila buida";
        }
    }

    private String adressToString(Node<E> node) {
        if(node.next == null){
            return "@" + Integer.toHexString(node.hashCode());
        }
        return node.hashCode() + ", @" + contentToString(node.next);

    }
}
