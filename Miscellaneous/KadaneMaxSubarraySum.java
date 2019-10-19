/* Algorithm to find the Max sum formed from subarray of given array */

public class KadaneMaxSubarraySum {
	
	private void kadaneAlgo(int arr[]) {
		int maxCurrent,maxGlobal;
		maxCurrent=maxGlobal= arr[0];
		
		for(int i=1;i<arr.length;i++) {
      
      //Core logic of calculating max sum
			maxCurrent = Math.max(arr[i], maxCurrent+arr[i]);

			if ( maxCurrent>maxGlobal) {
				maxGlobal = maxCurrent;
			}
		}
		System.out.println("Max sum = " + maxGlobal);
	}

	public static void main(String[] args) {
    //input array
		int[] arr = new int[]{3,-2,1,4,-1};
		KadaneMaxSubarraySum subArray = new KadaneMaxSubarraySum();
		subArray.kadaneAlgo(arr);
		
	}

}
