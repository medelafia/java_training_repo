package com.problem2;

public class PrintJob {
    private long submitTime;
    private float duration ;
    private int nbOfPages ;
    private JobType jobType;

    public PrintJob(long submitTime, float duration, int nbOfPages, JobType jobType) {
        this.submitTime = submitTime;
        this.duration = duration;
        this.nbOfPages = nbOfPages;
        this.jobType = jobType;
    }

    public long getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(long submitTime) {
        this.submitTime = submitTime;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public int getNbOfPages() {
        return nbOfPages;
    }

    public void setNbOfPages(int nbOfPages) {
        this.nbOfPages = nbOfPages;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }
}
