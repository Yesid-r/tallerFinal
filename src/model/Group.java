package model;

import java.util.ArrayList;

public class Group {
    private String id;
    private Teacher teacher;
    private Subject subject;
    private ArrayList<Student> students;
    private ArrayList<Activity> activities ;
    private double score;

    public Group(String id, Teacher teacher, Subject subject) {
        this.id = id;
        this.teacher = teacher;
        this.subject = subject;
        this.students = new ArrayList<Student>();
        this.activities = new ArrayList<Activity>();
        this.score = 0;

    }

    public double getScore() {
        return score;
    }

    public double finalScore(){
        double score = 0;
        for (int i = 0; i < activities.size(); i++) {
        score += activities.get(i).getScore();
        }
        this.score = score/activities.size();
        return score/activities.size();
    }

    public ArrayList<Activity> getActivities() {
        return activities;
    }
    public void addActivity(Activity activity){
        this.activities.add(activity);

    }
    public boolean findActivity(String desc){
        for (int i = 0; i < activities.size(); i++) {
            if (activities.get(i).getDescription().equals(desc)){
                return true;
            }

        }
        return false;
    }

    public int findStudent(String idStudent){
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(idStudent)){
                return i;
            }

        }
        return -1;
    }
    public ArrayList<Student> getStudents() {
        return students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public String getId() {
        return id;
    }

    public Subject getSubject() {
        return subject;
    }

}
