import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Simon on 2016-10-04.
 */
public class DepthFirstTree<T> extends Tree<T> {

    public DepthFirstTree(Node<T> root, State goalState){
        super(root, goalState);
        fringe = (Collection)new LinkedList<Node<T>>();
    }

    @Override
    public void traverse(Node<T> root) {
        System.out.println(root.toString());

        if(root.isGoalState(goalState)){

        }else {
            root.visit();

            try {

                addChildToNode(root);
                List<Node<T>> children = root.getChildren();
                for (Node child : children) {
                    if (!child.isVisited()) {
                        traverse(child);
                    }
                }

            } catch (Exception e) {
                System.out.println("Depth First Tree null pointer");
            }
        }
    }

}
