/**
 * You are given n activities with their start and finish times. 
 * Select the maximum number of activities that can be performed by a single person, 
 * assuming that a person can only work on a single activity at a time.
 * 
 * TIME COMPLEXITY : 
 * O(n log n) time if input activities may not be sorted. 
 * O(n) time when it is given that input activities are always sorted.
 * 
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ActivitySelectionProblem {
    
    public static void selectActivities() {

        ArrayList<Activity> activities = new ArrayList<Activity>();

        activities.add(new Activity(5,9));
        activities.add(new Activity(1,2));
        activities.add(new Activity(3,4));
        activities.add(new Activity(0,6));
        activities.add(new Activity(5,7));
        activities.add(new Activity(8,9));
        
        Collections.sort(activities);

        int st = -1;


        System.out.print("\nSelected Activities are: [");
        for (int i = 0; i < activities.size(); i++) {
            if (activities.get(i).startTime >= st) {
                System.out.print(activities.get(i));
                st = activities.get(i).finishTime;
            }
        }
        System.out.println("]\n");
    }

    public static void main(String[] args){
         selectActivities();
    }
}