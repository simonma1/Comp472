import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Created by Simon on 2016-09-27.
 */
public class MyQueue<T> extends LinkedList {

    LinkedList queue = new LinkedList<T>();

    public boolean enqueue(T el){
        int size = queue.size();
        queue.add(el);
        if(queue.size() == ++size)
            return true;
        else
            return false;
    }

    public Collection<T> dequeue(){
        return (Collection<T>) queue.remove();
    }
}
