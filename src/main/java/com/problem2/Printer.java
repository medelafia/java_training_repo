package com.problem2;

public class Printer {
    private String name ;
    private int ppm ;
    private JobType preferredJobType;



    public Printer(String name, int ppm, JobType preferredJobType) {
        this.name = name ;
        this.ppm = ppm ;
        this.preferredJobType = preferredJobType ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPpm() {
        return ppm;
    }

    public void setPpm(int ppm) {
        this.ppm = ppm;
    }

    public JobType getPreferredJobType() {
        return preferredJobType;
    }

    public void setPreferredJobType(JobType preferredJobType) {
        this.preferredJobType = preferredJobType;
    }
}
