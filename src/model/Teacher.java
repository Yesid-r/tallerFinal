package model;

import java.util.ArrayList;

public class Teacher {
    private String id;
    private String firstName;
    private String lastName;
    private String user;
    private String password;
    //private ArrayList<Enrolment> enrolments;
    private ArrayList<Group> groups;

    public Teacher(String id, String firstName, String lastName, String user, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.user = user;
        this.password = password;
        groups = new ArrayList<>();


    }
    public boolean addGroup(Group group){
        for (int i = 0; i < groups.size(); i++) {
            if (!group.getId().equals(groups.get(i).getId())){
                groups.add(group);
                return true;
            }
        }
        return false;
    }

    public int findGroup(String idGroup){
        for (int i = 0; i < groups.size(); i++) {
            if (groups.get(i).getId().equals(idGroup)){
                return i;
            }
        }
        return -1;
    }

    public ArrayList<Group> getGroups() {
        return groups;
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
}
