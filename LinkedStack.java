import java.util.EmptyStackException;

public class LinkedStack<T> implements StackInterface<T>{
    //the newest entry
    private Node topNode;

    //default constructor
    public LinkedStack(){
        topNode = null;
    }
    public void push(T newEntry) {
        Node newNode = new Node(newEntry, topNode);
        topNode = newNode;
    }

    @Override
    public T pop() {
        T top = peek();
        topNode = topNode.getNextNode();

        return top;
    }

    @Override
    public T peek() {
        if(isEmpty())
            throw new EmptyStackException();
        else
            return topNode.getData();
    }

    @Override
    public boolean isEmpty() {
        return topNode == null;
    }

    @Override
    public void clear() {
        topNode = null;
    }

    private class Node{
        private T data; //entry in set
        private Node next; //link to next node

        //standard constructor
        private Node(T dataPortion){
            this(dataPortion, null);
        }
        //constructor with two data fields
        private Node(T dataPortion, Node nextNode){
            data = dataPortion;
            next = nextNode;
        }

        private T getData(){
            return data;
        }
        private void setData(T newData){
            data = newData;
        }

        private Node getNextNode(){
            return next;
        }

        private void setNextNode(Node nextNode){
            next = nextNode;
        }
    }
}
