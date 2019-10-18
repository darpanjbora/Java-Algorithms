/**
 * Time Complexity: O(nk^2)
 * Auxiliary Space: O(nk)
 */


class EggDroppingPuzzle {

    public static int EggDrops(int noOfEggs, int noOfFloors){
        int [][] resultantMatrix = new int[noOfEggs+1][noOfFloors+1];

        for(int i=1; i<=noOfEggs; i++){
            resultantMatrix[i][0] = 0;
            resultantMatrix[i][1] = 1;
        }

        for(int j=1; j<=noOfFloors; j++)
            resultantMatrix[1][j] = j;
            
        for(int i=2; i<=noOfEggs; i++){
            for(int j=2; j<=noOfFloors; j++){
                resultantMatrix[i][j] = Integer.MAX_VALUE;
                for(int k=1; k<=j ; k++)
                {
                    int value = 1 + Math.max(resultantMatrix[i-1][k-1], resultantMatrix[i][j-k]); 
                    if(value < resultantMatrix[i][j])
                        resultantMatrix[i][j] = value;
                }
            }
        }
        return resultantMatrix[noOfEggs][noOfFloors] ;
    }

    public static void main(String[] args) {
        int noOfEggs = 2;
        int noOfFloors = 18;

        System.out.println("Minimum number of trials in worst case is: "+EggDrops(noOfEggs, noOfFloors));
    }
}