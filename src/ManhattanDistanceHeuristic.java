/**
 * Created by Simon on 2016-10-09.
 */
public class ManhattanDistanceHeuristic implements IHeuristic{

    public static int calculateHeuristic(State s, State goal) {
        int totalDistance = 0;

        char[][] sArr = s.getStateArr();
        char[][] goalArr = goal.getStateArr();

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

        return totalDistance;
    }
}
