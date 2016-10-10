import java.util.*;

/**
 * Created by Simon on 2016-09-27.
 */
public class BreadthFirstTree<T> extends Tree<T> {



    public BreadthFirstTree(Node<T> root, State goalState){
        super(root, goalState);
        fringe = (Collection)new LinkedList<Node<T>>();

    }

    public void traverse(Node<T> root){
        Node currentNode = null;
        try {
            while(!goalStateFound) {
                if(currentNode == null){
                    currentNode = root;
                }else{
                    currentNode = ((LinkedList<Node<T>>) fringe).remove();
                }

                System.out.println((((State) currentNode.getData()).getStateOfPuzzle()));
                if (currentNode.isGoalState(goalState)) {//checks to see if root might be a goal state
                    System.out.println("Goal State Found");
                    goalStateFound = true;
                    while(currentNode.getParent()!=null){
                        moves.add(((State)currentNode.getData()));
                        currentNode = currentNode.getParent();
                        numOfMoves++;
                    }
                    printSolution();

                } else {

                    addChildToNode(currentNode);

                    List<Node<T>> children = currentNode.getChildren();
                    for (Node<T> el : children) {
                        fringe.add(el);
                        el.setParent(currentNode);

                    }

                }
            }
        }catch (Exception e){
            System.out.println("Trying to add element to fringe with null pointer");
        }
    }

    public void printSolution(){
        System.out.println("The solution was found in: " + numOfMoves + " moves");
        while(moves.size()>0){
            State move;
            move = moves.removeLast();
            System.out.println(move.toString());
        }
    }


    /*
    @Override
    public void traverse(Node<T> root) {
        try {
            System.out.println((((State)root.getData()).getStateOfPuzzle()));
            if(root.isGoalState(goalState)) {//checks to see if root might be a goal state
                System.out.println("Goal State Found");

            }else {

                addChildToNode(root);

                List<Node<T>> children = root.getChildren();
                for (Node<T> el : children) {
                     fringe.add(el);

                }

                //dequeues the first element in the fringe and passes it as a parameter for the traversal
                if (!goalStateFound) {
                    traverse(((LinkedList<Node<T>>) fringe).remove());
                }
            }
        }catch (Exception e){
            System.out.println("Trying to add element to fringe with null pointer");
        }

    }*/


}
