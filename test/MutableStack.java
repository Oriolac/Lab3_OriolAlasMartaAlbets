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
        return false;
    }
}
