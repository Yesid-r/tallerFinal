package model;

import java.util.ArrayList;

public class Enrolment {

    private String idInscription;
    private String idGroup;
    private String idStudent;
    private double score;
    private ArrayList<Activity> activities;

    public Enrolment(String idGroup, String idStudent) {
        idInscription = idStudent+"-"+idGroup;
        this.idGroup = idGroup;
        this.idStudent = idStudent;
        score = 0;
        activities = new ArrayList<>();
    }

    public String getIdInscription() {
        return idInscription;
    }

    public ArrayList<Activity> getActivities() {
        return activities;
    }

    public double getScore() {
        return score;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public String getIdGroup() {
        return idGroup;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
