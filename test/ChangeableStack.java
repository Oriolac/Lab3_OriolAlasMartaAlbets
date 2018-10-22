public class ChangeableStack<E> {

    private Node<E> topOfStack;

    private static class Node<E>{
        private E elem;
        private Node<E> next;

        private Node(E elem, Node<E> next){
            this.elem = elem;
            this.next = next;
        }
    }

    public ChangeableStack(){
        topOfStack = null;
    }

    public ChangeableStack(Node<E> topOfStack){
        this.topOfStack = topOfStack;
    }

    public void push(E elem) {
        Node<E> newNode = new Node<>(elem,topOfStack);
        topOfStack = newNode;
    }

    public void pop() throws StackError {
       topOfStack = topOfStack.next;
    }

    public E top() throws StackError {
        return topOfStack.elem;
    }

    public boolean isEmpty() {
        return topOfStack.equals(null);
    }
}
