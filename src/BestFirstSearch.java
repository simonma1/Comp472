import java.util.*;

/**
 * Created by Simon on 2016-10-09.
 */
public class BestFirstSearch<T> extends Tree<T>{
    private Map<String,Node> closedSet = new HashMap<String,Node>();
    private int numOfMoves = 0;
    private LinkedList<State> moves = new LinkedList();


    public BestFirstSearch(Node<T> root, State goalState){
        super(root, goalState);
        fringe = new PriorityQueue<>();
        root.setfValue(0);
        ((PriorityQueue)fringe).add(root);
    }


    public void traverse() {
        Node<T> currentNode;

        while(!((PriorityQueue)fringe).isEmpty() && !goalStateFound){

            currentNode = (Node<T>) ((PriorityQueue)fringe).poll();

            //System.out.println(currentNode.toString());

            if(currentNode.getParent() == null){
                int val = calculateHeuristic((State)currentNode.getData());
                currentNode.setfValue(val);
                currentNode.sethValue(val);
            }

            String key = ((State)currentNode.getData()).getStateOfPuzzle();
            closedSet.put(key, currentNode);
            if(currentNode.isGoalState(goalState)){
                goalStateFound = true;
                System.out.println("Goal state found");
                while(currentNode.getParent()!=null){
                    moves.add(((State)currentNode.getData()));
                    currentNode = currentNode.getParent();
                    numOfMoves++;
                }
                printSolution();
            }else{
                List<State> children = findPossibleMoves(currentNode);

                for(State child : children) {
                    Node<T> childNode = new Node(child);
                    int heuristicScore = calculateHeuristic(child);
                    childNode.sethValue(heuristicScore);
                    childNode.setfValue(heuristicScore);
                    childNode.setParent(currentNode);
                    if(!closedSet.containsKey(child.getStateOfPuzzle())){
                        ((PriorityQueue) fringe).add(childNode);
                    }

                }
            }

        }

    }

    @Override
    public void traverse(Node<T> root) {


    }


    public int calculateHeuristic(State state){
        //int heuristicValue = MisplacedTilesHeuristic.calculateHeuristic(state, goalState);
        int heuristicValue = ManhattanDistanceHeuristic.calculateHeuristic(state, goalState);
        return heuristicValue;
    }

    public void printSolution(){
        System.out.println("The solution was found in: " + numOfMoves + " moves");
        while(moves.size()>0){
            State move;
            move = moves.removeLast();
            System.out.println(move.toString());
        }
    }


}
