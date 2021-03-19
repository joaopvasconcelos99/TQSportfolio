import java.util.ArrayList;
import java.util.NoSuchElementException;

public class TqsStack <T>{

    private ArrayList<T> stack;
    private int max_size;

    public TqsStack(){
        this.stack = new ArrayList<>();
    }

    public TqsStack(int max_size){
        this.stack = new ArrayList<>();
        this.max_size = max_size;
    }

    public boolean isEmpty() {
        //stack.add((T) "element 1");
        //System.out.println(stack);
        return this.stack.isEmpty(); //return true if empty
    }

    public void push(T element) {
        if(this.max_size > 0){
            if (this.max_size > this.stack.size()){
                this.stack.add(element); //add element
            }
            else
                throw new IllegalStateException();
        }
        else {
            this.stack.add(element);
        }

    }

    public T pop() {
        if(this.stack.isEmpty()){
            throw new NoSuchElementException();
        }else{
            return this.stack.remove(this.stack.size()-1); //remove the item at the top
        }
    }

    public T peek() {
        if(this.stack.isEmpty()){
            throw new NoSuchElementException();
        }else{
            return this.stack.get(this.stack.size()-1); //return the item at the top
        }
    }

    public int size(){
        return this.stack.size(); //return size
    }


}
