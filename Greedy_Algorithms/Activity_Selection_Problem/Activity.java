package Greedy_Algorithms.Activity_Selection_Problem;

class Activity implements Comparable<Activity> {
     
    Integer startTime = 0;
    Integer finishTime = 0;

     Activity(Integer st, Integer ft) {
        startTime = st;
        finishTime = ft;
    }

    @Override
    public int compareTo(Activity activity) {
        return this.finishTime.compareTo(activity.finishTime);
    }

    @Override
    public String toString() {
        return "(" + startTime + "," + finishTime + "), ";
    }
}
