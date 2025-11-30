package com.problem1;

import java.util.*;

public class TaskScheduler {

    private List<Employee> employees;
    private List<Task> tasks;
    private final Object employeesLock = new Object();


    public TaskScheduler() {

    }

    public TaskScheduler(List<Employee> employees, List<Task> tasks) {
        this.employees = employees;
        this.tasks = tasks;
    }

    public Task getHighestPriorityTask() {
        Collections.sort(this.tasks);
        return this.tasks.getFirst();
    }
    public List<Employee> getAvailableEmployees() {
        return employees.stream().filter(employee -> !employee.isInWork()).toList();
    }

    public void addEmployee(Employee employee) {
        synchronized (employeesLock) {
            this.employees.add(employee);
            this.employeesLock.notify();
        }
    }
    public void addTask(Task task) {
        this.tasks.add(task);
    }
    public void process() {
        while(true) {
            if(!this.tasks.isEmpty()) {
                Task task = this.getHighestPriorityTask() ;
                synchronized (this.employeesLock) {
                    while(this.getAvailableEmployees().isEmpty()) {
                        try {
                            System.out.println("waiting for the task to complete ...");
                            this.employeesLock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    Employee employee = this.getAvailableEmployees().get(new Random().nextInt(this.getAvailableEmployees().size()));
                    employee.setInWork(true);

                    task.setStartTime(System.currentTimeMillis());
                    System.out.println(task.getId() + " begin in " + task.getStartTime() + " by " + employee.getName());
                    task.setEndTime(System.currentTimeMillis());
                    System.out.println(task.getId() + " end in " + task.getEndTime() + " by " + employee.getName());

                    this.tasks.remove(task);

                    employee.setInWork(false);
                    this.employeesLock.notify();
                }

            }
        }
    }

}
