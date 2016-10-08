import java.util.ArrayList;
import java.util.List;

/**
 * Created by Simon on 2016-09-26.
 */
public class Node<T> implements Comparable<T>{

    private T data;
    private List<Node<T>> children = new ArrayList<>();
    private Node<T> parent;
    private int fValue = 0;
    private boolean visited = false;

    public Node(T data){
        this.data = data;
    }

    public Node(T data, int fValue){
        this.data = data;
        this.fValue = fValue;
    }

    public void setfValue(int fValue) {
        this.fValue = fValue;
    }

    public List<Node<T>> getChildren(){
        return this.children;
    }

    public Node<T> getParent(){
        return parent;
    }

    public void addChild(Node<T> el){
        children.add(el);
    }

    public void addParent(Node<T> parent){

    }

    public T getData() {
        return data;
    }

    public boolean isGoalState(State goalState) {
        State dataState = (State) data;
        return dataState.isGoalState(goalState);
    }

    public void visit(){
        visited = true;
    }

    public boolean isVisited(){
        return visited;
    }

    public String toString(){
        return data.toString();
    }

    @Override
    public int compareTo(T o) {
       return ((Node<T>)o).fValue - this.fValue;

    }
}
