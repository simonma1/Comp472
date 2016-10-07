import java.util.ArrayList;
import java.util.List;

/**
 * Created by Simon on 2016-09-28.
 */
public class State {

    /*Maybe have a State class that will contain the state of the puzzle
    * the state could be a string or an array
    * That State object would be the data contained in the Node object
    * It would only be initialized when  putting the Node in the fringe
    * Would require computation to generate the state of the child nodes
    * That computation could be generated as a heuristic
    * */

    private String stateOfPuzzle;
    private char[][] stateArr = new char[3][3];
    private int[] blankPosition = {-1,-1};

    public State(String stateOfPuzzle){
        this.stateOfPuzzle = stateOfPuzzle;
        stateArr = convertStringToArray(stateOfPuzzle);
    }

    public State(char[][] stateArr){
        this.stateArr = stateArr;
    }

    public State(char[][] stateArr, int[] blankPosition){
        this.stateArr = stateArr;
        this.blankPosition = blankPosition;
    }

    public char[][] convertStringToArray(String state){
        int index = 0;
        for(int i=0;i<stateArr.length;i++){
            for(int j=0;j<stateArr[i].length;j++){
               char nextChar=  state.charAt(index++);
                if (nextChar == 'B'){
                    blankPosition[0]=i;
                    blankPosition[1]=j;
                }

               stateArr[i][j] = nextChar ;
            }
        }
        return stateArr;
    }

    //Convert the stateOfPuzzle variable automatically
    public char[][] returnDefault(){
        return convertStringToArray(this.stateOfPuzzle);
    }

    public String toString(){
        String content="";
        for(int i=0;i<stateArr.length;i++){
            for(int j=0; j<stateArr[i].length;j++){
                content += stateArr[i][j];
            }
        }return content;
    }

    //Moves the blank to the desired row and column
    private char[][] swap(int row, int col){
        char[][] stateArrCopy = copy();
        char toMoveWithBlank = stateArrCopy[row][col];
        int blankRow = blankPosition[0];
        int blankCol = blankPosition[1];
        stateArrCopy[row][col] = stateArrCopy[blankRow][blankCol];
        stateArrCopy[blankRow][blankCol] = toMoveWithBlank;

        return stateArrCopy;
    }

    public List<State> possibleMoves(){
        List<State> moves = new ArrayList();
        int blankRow = blankPosition[0];
        int blankCol = blankPosition[1];

        if(blankRow > 0 && blankRow <=2){//Move up
            State movedUp =moveUp(blankPosition);
            moves.add(movedUp);

        }if(blankRow >= 0 && blankRow < 2){//Move down
            State movedDown =moveDown(blankPosition);
            moves.add(movedDown);

        }if(blankCol > 0 && blankCol <= 2){//Move left
            State movedLeft =moveLeft(blankPosition);
            moves.add(movedLeft);

        }if(blankCol >= 0 && blankCol <2){//Move right
            State movedRight =moveRight(blankPosition);
            moves.add(movedRight);
        }

        return moves;
    }



    public boolean isGoalState(State goalState){
        char[][] goalStateArr = goalState.stateArr;
        boolean equals = false;

        for(int i=0; i<goalStateArr.length;i++){
            for (int j=0;j<goalStateArr[i].length;j++){
                if(goalStateArr[i][j] != stateArr[i][j]){
                    return false;
                }
            }
        }
        return true; //all elements of the array are equals to those of the goal state
    }

    private State moveUp(int[] blankPos){
        int blankRow = blankPos[0];
        int blankCol = blankPos[1];
        int[] newBlankPos = {blankRow, blankCol};
        char[][] stateAfterArr = swap(blankRow-1,blankCol);
        newBlankPos[0]-=1;
        State stateAfter = new State(stateAfterArr, newBlankPos);
        return stateAfter;
    }

    private State moveDown(int[] blankPos) {
        int blankRow = blankPos[0];
        int blankCol = blankPos[1];
        int[] newBlankPos = {blankRow, blankCol};
        char[][] stateAfterArr = swap(blankRow+1,blankCol);
        newBlankPos[0]+=1;
        State stateAfter = new State(stateAfterArr, newBlankPos);
        return stateAfter;
    }

    private State moveLeft(int[] blankPos) {
        int blankRow = blankPos[0];
        int blankCol = blankPos[1];
        int[] newBlankPos = {blankRow, blankCol};
        char[][] stateAfterArr = swap(blankRow,blankCol-1);
        newBlankPos[1]-=1;
        State stateAfter = new State(stateAfterArr, newBlankPos);
        return stateAfter;
    }

    private State moveRight(int[] blankPos) {
        int blankRow = blankPos[0];
        int blankCol = blankPos[1];
        int[] newBlankPos = {blankRow, blankCol};
        char[][] stateAfterArr = swap(blankRow,blankCol+1);
        newBlankPos[1]+=1;
        State stateAfter = new State(stateAfterArr, newBlankPos);
        return stateAfter;
    }

    public char[][] copy(){
        char[][] copiedArr = new char[this.stateArr.length][this.stateArr[0].length];

        for(int i=0; i<stateArr.length;i++){
            for(int j=0; j<stateArr[i].length;j++){
                copiedArr[i][j] = stateArr[i][j];
            }
        }return copiedArr;
    }

}
