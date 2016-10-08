import java.util.PriorityQueue;

/**
 * Created by Simon on 2016-10-07.
 */
public class AStarTree<T> extends Tree<T> {

    public AStarTree(Node<T> root, State goalState){
        super(root, goalState);
        fringe = new PriorityQueue<>();
        root.setfValue(0);
        ((PriorityQueue)fringe).add(root);
    }


    public void traverse() {
        Node<T> currentNode;

        while(!((PriorityQueue)fringe).isEmpty() && !goalStateFound){

            currentNode = (Node<T>) ((PriorityQueue)fringe).poll();
            if(currentNode.isGoalState(goalState)){
                goalStateFound = true;
                System.out.println("Goal state found");
            }

        }

    }

    @Override
    public void traverse(Node<T> root) {


    }


    public int calculateHeuristic(){
        int heuristicValue= 0;

        return heuristicValue;
    }


}
