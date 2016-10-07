import java.util.*;

/**
 * Created by Simon on 2016-09-27.
 */
public class BreadthFirstTree<T> extends Tree<T> {

    /*
    * dequeue elements as they are reached
    * add base case
    * Add recursion
    * */

    public BreadthFirstTree(Node<T> root, State goalState){
        super(root, goalState);
        fringe = (Collection)new LinkedList<Node<T>>();

    }


    @Override
    public void traverse(Node<T> root) {
        try {
            System.out.println(root.toString());
            if(root.isGoalState(goalState)) {//checks to see if root might be a goal state
                System.out.println("Goal State Found");

            }else {

                addChildToNode(root);

                List<Node<T>> children = root.getChildren();
                for (Node<T> el : children) {
                    ((LinkedList<Node<T>>) fringe).add(el);

                }

                //dequeues the first element in the fringe and passes it as a parameter for the traversal
                if (!goalStateFound) {
                    traverse(((LinkedList<Node<T>>) fringe).remove());
                }
            }
        }catch (Exception e){
            System.out.println("Trying to add element to fringe with null pointer");
        }

    }


}
