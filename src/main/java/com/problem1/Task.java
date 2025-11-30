package com.problem1;

public class Task implements Comparable<Task> {

    private int id ;
    private long startTime;
    private long endTime;
    private PRIORITY priority ;


    public Task() {}
    public Task(int id , PRIORITY priority) {
        this.id = id ;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }
    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public PRIORITY getPriority() {
        return priority;
    }

    public void setPriority(PRIORITY priority) {
        this.priority = priority;
    }

    @Override
    public int compareTo(Task o) {
        return this.priority.compareTo(o.getPriority());
    }

}
