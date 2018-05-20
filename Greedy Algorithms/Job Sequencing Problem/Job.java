class Job implements Comparable<Job> {

    Character id = 'a';
    Integer deadline = 0;
    Integer profit = 0; 

    Job(Character Jobid, Integer dl, Integer pr) {
        id = Jobid;
        deadline = dl;
        profit = pr;
    }

    @Override
    public int compareTo(Job job) {
        return job.profit.compareTo(this.profit);
    }

    @Override
    public String toString() {
        return "["+ id+ "], ";
    }

}