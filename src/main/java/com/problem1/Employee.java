package com.problem1;

public class Employee {
    private int id ;
    private String name;
    private boolean inWork ;

    public Employee() {}
    public Employee(int id, String name, boolean inWork) {
        this.id = id;
        this.name = name;
        this.inWork = inWork;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isInWork() {
        return inWork;
    }

    public void setInWork(boolean inWork) {
        this.inWork = inWork;
    }
}
