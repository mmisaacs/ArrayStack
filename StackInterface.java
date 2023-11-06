public interface StackInterface<T> {
    //add new entry to stack
    public void push(T newEntry);

    //remove and returns the newest entry for the stack
    public T pop();

    //retrieves the newest entry
    public T peek();

    //checks if it is empty, true or false
    public boolean isEmpty();

    //removes all entries
    public void clear();
}
