package model;

import java.util.ArrayList;

public class Student {
    private String id;
    private String firstName;
    private String lastName;
    private String user;
    private String password;

    private double average;
    private ArrayList<Enrolment> enrolments;



    public Student(String id, String firstName, String lastName, String user, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.user = user;
        this.password = password;
        this.average = 0;
        enrolments = new ArrayList<>();
    }
    public int findEnrolment(String id){
        for (int i = 0; i < enrolments.size(); i++) {
            if (enrolments.get(i).getIdInscription().equals(id)){
                return i;
            }

        }
        return -1;

    }




    public void setAverage(double average) {
        this.average = average;
    }

    public String getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPassword() {
        return password;
    }

    public String getUser() {
        return user;
    }


    public ArrayList<Enrolment> getEnrolments() {
        return enrolments;
    }
}
