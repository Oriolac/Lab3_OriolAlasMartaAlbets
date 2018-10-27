import java.util.Iterator;
import java.util.List;

public class MutableEmployeeStack implements MutableStack<Employee> {

    private Node<Employee> topOfStack;

    //Subclasse Node<E>
    public class Node{
        public Employee elem;
        public Node next;

        public Node(Employee elem, Node<Employee> next){
            this.elem = elem;
            this.next = next;
        }

        @SuppressWarnings("unchecked")
        private void setElement(Employee emp){
            elem = emp;
        }

        public Employee getElement(){
            return elem;
        }

        public Node<Employee> getNext(){
            return next;
        }

    }

    public MutableEmployeeStack(){
        topOfStack = null;
    }

    private MutableEmployeeStack(Node<Employee> topOfStack){
        this.topOfStack = topOfStack;
    }

    // Mètode estàtic
    public static <Employee> MutableEmployeeStack<Employee> stackFromList(List<Employee> list){
        Iterator<Employee> it = list.iterator();
        MutableEmployeeStack<Employee> stack = new MutableEmployeeStack<>();
        while(it.hasNext()){
            Employee elem = it.next();
            stack = stack.push(elem);
        }
        return stack;
    }


    @Override
    public MutableEmployeeStack<Employee> push(Employee elem) {
        return new MutableEmployeeStack<Employee>(new Node<Employee>(elem, this.topOfStack));
    }

    @Override
    public MutableEmployeeStack<Employee> pop() throws StackError {
        return new MutableEmployeeStack<>(topOfStack.next);
    }

    @Override
    public Employee top() throws StackError {
        return topOfStack.elem;
    }

    @Override
    public boolean isEmpty() {
        return null == topOfStack;
    }

    @Override
    public void setTopOfStack(Employee employee) {
        topOfStack = new Node<>(employee, topOfStack.next);
    }

    public Node<Employee> getTopOfStack(){
        return topOfStack;
    }


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

    private String contentToString(Node<Employee> node){
        if(node.next == null){
            return "" + node.elem;
        }
        return node.elem + ", " + contentToString(node.next);
    }

    public static <E> boolean isSameAdress(MutableEmployeeStack<E> s1, MutableEmployeeStack<E> s2){
        return s1.adressToString().equals(s2.adressToString());
    }

    public String adressToString() {
        try{
            return "{(TOP) " + adressToString(topOfStack) + "}";
        } catch (NullPointerException ex){
            return "Pila buida";
        }
    }

    private String adressToString(Node<Employee> node) {
        if(node.next == null){
            return "@" + Integer.toHexString(node.hashCode());
        }
        return "@" + node.hashCode() + ", " + adressToString(node.next);
    }
}