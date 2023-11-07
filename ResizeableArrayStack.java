import java.util.Arrays;
import java.util.EmptyStackException;

public class ResizeableArrayStack<T> implements StackInterface<T> {
    private T[] stack;
    private int topIndex;
    private static int defaultCap = 25;

    public ResizeableArrayStack(){
        this(defaultCap);
    }

    public ResizeableArrayStack(int initialCapacity){
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[]) new Object[initialCapacity];
        stack = tempStack;
        topIndex = -1;
    }

    private void checkCapacity(){
        if(topIndex >= stack.length -1){
            int newLength = 2 * stack.length;
            stack = Arrays.copyOf(stack, newLength);
        }
    }
    public void push(T newEntry) {
        checkCapacity();
        stack[topIndex + 1] = newEntry;
        topIndex++;
    } //end push

    public T pop() {
        if(isEmpty())
            throw new EmptyStackException();
        else {
            T top = stack[topIndex];
            stack[topIndex] = null;
            topIndex--;
            return top;
        } //end else
    } //end pop

    public T peek() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        else
            return stack[topIndex];
    }

    public boolean isEmpty() {
        return topIndex < 0;
    }

    public void clear() {
        while(topIndex > -1){
            stack[topIndex] = null;
            topIndex--;
        } //end while
    } //end clear
}
