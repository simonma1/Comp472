import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by Simon on 2016-10-07.
 */
public class AStarTree<T> extends Tree<T> {

    private Map<String,Node> closedSet = new HashMap<String,Node>();

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

            System.out.println(currentNode.toString());

            if(currentNode.getParent() == null){
                int val = calculateHeuristic();
                currentNode.setfValue(val);
                currentNode.sethValue(val);
            }

            String key = ((State)currentNode.getData()).getStateOfPuzzle();
            closedSet.put(key, currentNode);
            if(currentNode.isGoalState(goalState)){
                goalStateFound = true;
                System.out.println("Goal state found");
            }else{
                List<State> children = findPossibleMoves(currentNode);
                int currentGValue;
                if(currentNode.getParent() == null){
                    currentGValue = 0;
                }else {
                    currentGValue = currentNode.getParent().getgValue() + 1;
                }

                for(State child : children) {
                    Node<T> childNode = new Node(child);
                    childNode.setgValue(currentGValue);
                    int heuristicScore = calculateHeuristic();
                    childNode.setfValue(heuristicScore);
                    childNode.sethValue(currentGValue + heuristicScore);
                    childNode.setParent(currentNode);
                    ((PriorityQueue) fringe).add(childNode);

                    /*
                    * To do
                    * find out what the priority queue output is like
                    * build a heuristic static class
                    * create object in the class
                    * use that object to generate the heuristic value
                    * Maybe have map so as to not create the same object twice
                    * */
                }
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
