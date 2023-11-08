import java.util.Arrays;
import java.util.EmptyStackException;

public class ResizeableArrayStack<T> implements StackInterface<T> {
    private T[] stack;
    private int topIndex = -1;
    private static int defaultCap = 25;

    //default constructor
    public ResizeableArrayStack(){
        this(defaultCap);
    }

    //constructor with provided capacity
    public ResizeableArrayStack(int initialCapacity){
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[]) new Object[initialCapacity];
        stack = tempStack;
        topIndex = -1;
    }

    //checks if capacity is reached, if so, it doubles in size
    private void checkCapacity(){
        if(topIndex >= stack.length -1){
            int newLength = 2 * stack.length;
            stack = Arrays.copyOf(stack, newLength);
        }
    }

    //"pushes" (adds) new entry to top of stack
    public void push(T newEntry) {
        checkCapacity();
        stack[topIndex + 1] = newEntry;
        topIndex++;
    } //end push

    //retrieves top entry from stack
    public T pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        else {
            T top = stack[topIndex];
            stack[topIndex] = null;
            topIndex--;
            return top;
        } //end else
    } //end pop

    //looks at what the top entry for stack is
    public T peek() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        else
            return stack[topIndex];
    }

    //checks if stack is empty (true or false)
    public boolean isEmpty() {
        return topIndex < 0;
    }

    //remove all entries
    public void clear() {
        while(topIndex > -1){
            stack[topIndex] = null;
            topIndex--;
        } //end while
    } //end clear
}
