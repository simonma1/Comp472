import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.Collection;
import java.util.List;

/**
 * Created by Simon on 2016-09-26.
 */
public abstract class Tree<T> {
    protected Node<T> root;
    protected Collection<Node<T>> fringe;
    protected State  goalState;
    protected boolean goalStateFound = false;

    public Tree(Node<T> root){
        this.root = root;
    }

    public Tree(Node<T> root, State goalState){
        this.root = root;
        this.goalState = goalState;
    }


    public void add(Node<T> current,Node<T> child){
        current.addChild(child);
    }

    public void traverse(){
        traverse(root);
    }

    public abstract void traverse(Node<T> root);

    protected  void addChildToNode(Node<T> node){
        State rootState = (State)node.getData();
        List<State> states = rootState.possibleMoves();

        for (State s : states  ) {
            Node<T> children = new Node(s);
            node.addChild(children);
        }
    }



}
