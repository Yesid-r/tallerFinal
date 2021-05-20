package model;

import java.util.ArrayList;

public class Group {
    private String id;
    private String idTeacher;
    private String nameTeacher;
    private Subject subject;
    private ArrayList<Enrolment> enrolments;
    private ArrayList<Activity> activities ;
    private double score;

    public Group(String id, String idTeacher,String nameTeacher, Subject subject) {
        this.id = id;
        this.idTeacher = idTeacher;
        this.nameTeacher = nameTeacher;
        this.subject = subject;
        this.enrolments = new ArrayList<>();
        this.activities = new ArrayList<Activity>();
        this.score = 0;

    }

    public String getIdTeacher() {
        return idTeacher;
    }


    public String getNameTeacher() {
        return nameTeacher;
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

    public ArrayList<Enrolment> getEnrolments() {
        return enrolments;
    }

    public String getId() {
        return id;
    }

    public Subject getSubject() {
        return subject;
    }


}
