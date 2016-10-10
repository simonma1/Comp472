/**
 * Created by Simon on 2016-10-09.
 */
public class MisplacedTilesHeuristic implements IHeuristic{


    public static int calculateHeuristic(State s, State goal) {
        int numOfMisplacedTiles = 0;
        String sData = s.getStateOfPuzzle();
        String goalData = goal.getStateOfPuzzle();
        for(int i=0; i<sData.length();i++){
            if (sData.charAt(i) != goalData.charAt(i))
                numOfMisplacedTiles++;
        }
        return numOfMisplacedTiles;
    }
}
