/**
 * Given an array of jobs where every job has a deadline and 
 * associated profit if the job is finished before the deadline. 
 * It is also given that every job takes single unit of time, 
 * so the minimum possible deadline for any job is 1. 
 * How to maximize total profit if only one job can be scheduled at a time.
 * 
 * 
 * TIME COMPLEXITY : O(n^2) 
 * It can be optimized using Disjoint Set Data Structure
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class JobSequencingProblem {
    
    public static void selectJobs() {

        ArrayList<Job> jobs = new ArrayList<Job>();

        jobs.add(new Job('a',2,100));
        jobs.add(new Job('b',1,19));
        jobs.add(new Job('c',2,27));
        jobs.add(new Job('d',1,25));
        jobs.add(new Job('e',3,15));
        
        Collections.sort(jobs);

        int size = jobs.size();

        int[] result = new int[size];
        boolean[] slot = new boolean[size];

        for(int i=0; i<size; i++){
            int dl = jobs.get(i).deadline;
            for(int j= Math.min(size, dl)-1; j>=0; j--){
                if(slot[j] == false){
                    result[j] = i;
                    slot[j] = true;
                    break;
                }
            }
        }

        for(int i=0; i<size; i++){
            if(slot[i]){
                System.out.println(jobs.get(result[i]).id);
            }
        }
    }

    public static void main(String[] args){
         selectJobs();
    }
}