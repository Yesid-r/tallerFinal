package model;

import java.util.ArrayList;

public class Student {
    private String id;
    private String firstName;
    private String lastName;
    private String user;
    private String password;

    private double average;
    private ArrayList<Group> groups;



    public Student(String id, String firstName, String lastName, String user, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.user = user;
        this.password = password;
        this.average = 0;

        groups = new ArrayList<Group>();
    }
    public int sumCredits(){
        int sumCredits =0;
        for (int i = 0; i < groups.size(); i++) {
            sumCredits += groups.get(i).getSubject().getNumberCredits();

        }
        return sumCredits;
    }
    public double noteFinalGroups(){

        return 0;
    }
    public int findActivity(String idGroup, String desActivity){
        for (int i = 0; i < groups.get(findGroup(idGroup)).getActivities().size(); i++) {
            if (groups.get(findGroup(idGroup)).getActivities().get(i).getDescription().equals(desActivity)){
                return i;

            }

        }
        return -1;
    }
    public int findGroup(String id){
        for (int i = 0; i < groups.size(); i++) {
            if (groups.get(i).getId().equals(id)){
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



    public ArrayList<Group> getGroups() {
        return groups;
    }
}
