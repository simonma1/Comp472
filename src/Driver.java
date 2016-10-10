import java.util.*;

/**
 * Created by Simon on 2016-09-26.
 */

public class Driver {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        String goalStateString;
        String initialState = "12345678B";
        long startTime;
        long endTime;

        /*
        System.out.println("Please enter the goal state of the 8 puzzle");
        System.out.println("The Syntax should be a string starting with the first square on the upper left," +
                    "going row by row, with a B to represent the blank space. ");

        goalStateString = keyboard.next();
        */

        goalStateString="1238B4765";


        //initialState = generateInitialState("2317B8654");
        initialState = "2317B8654";//For testing
        System.out.println("The initial state is: " + initialState);
        System.out.println("The goal state is: " + goalStateString);


        startTime = System.currentTimeMillis();
        State rootState = new State(initialState);
        State goalState = new State(goalStateString);
        Node<State> rootNode = new Node<State>(rootState);
        //BreadthFirstTree<Node<State>> tree = new BreadthFirstTree(rootNode, goalState);
        //DepthFirstTree<Node<State>> tree = new DepthFirstTree(rootNode,goalState);
        BestFirstSearch<Node<State>> tree = new BestFirstSearch(rootNode,goalState);

        tree.traverse();

        endTime = System.currentTimeMillis();

        long totalTime = (endTime - startTime);

        System.out.println("It took " + totalTime + " milliseconds to find the solution");

    }


    //Shuffles the possible elements to get a random state
    public static String generateInitialState(String values){
        List<Character> stateArr = new ArrayList<>();

        System.out.println("Generating an initial state");
        for(char c : values.toCharArray()){
            stateArr.add(c);
        }

        Collections.shuffle(stateArr);

        StringBuilder stringBuilder = new StringBuilder();
        for(char c : stateArr){
            stringBuilder.append(c);
        }

        return stringBuilder.toString();

    }
}
