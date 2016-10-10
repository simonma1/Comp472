/**
 * Created by Simon on 2016-10-09.
 */

public class NilssonScoreHeuristic {

    //This is the inadmissable heuristic
    //It is inadmissible because it overestimates by considering the blank state for example

    public static int calculateHeuristic(State s, State goal) {
        int totalDistance = 0;

        char[][] sArr = s.getStateArr();
        char[][] goalArr = goal.getStateArr();
        String sString = s.getStateOfPuzzle();
        String goalString = goal.getStateOfPuzzle();

        for(int i=0;i<sArr.length;i++){
            for(int j=0; j<sArr[i].length;j++){
                int xPosition=0;
                int yPosition=0;
                char currentChar = sArr[i][j];
                for(int k=0;k<goalArr.length;k++){
                    for(int l=0;l<goalArr[k].length;l++){
                        if(currentChar == goalArr[k][l]){
                            xPosition=k;
                            yPosition=l;
                        }
                    }
                }

                int xDistance = xPosition - i;
                xDistance = Math.abs(xDistance);
                int yDistance = yPosition - j;
                yDistance = Math.abs(yDistance);
                totalDistance = totalDistance + xDistance + yDistance;
            }
        }

        for(int k=0; k<sString.length()-1;k++){
            if(sString.charAt(k+1) != goalString.charAt(k+1)){
                totalDistance+=2;
            }
        }

        if(sArr[1][1] !='B'){
            totalDistance++;
        }

        return totalDistance;
    }
}
