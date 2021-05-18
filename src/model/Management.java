package model;

import persistencia.ServiceTeachers;

import java.time.LocalDate;
import java.util.ArrayList;

public class Management {
    private ArrayList<Student> students;
    private ArrayList<Teacher> teachers;
    private ArrayList<Group> groups;
    private ArrayList<Subject> subjects;
    private ServiceTeachers serviceTeachers;

    public Management() {
        students = new ArrayList<>();
        teachers = new ArrayList<>();
        groups = new ArrayList<>();
        subjects = new ArrayList<>();
        serviceTeachers = new ServiceTeachers();
        loadData();
    }
    public void dumpObjects(ArrayList<Teacher> teachers){
        serviceTeachers.dumpTeachers(teachers);
    }
    public void loadData(){
        teachers.addAll(serviceTeachers.getTeachers());
    }
    public boolean addStudent(String id, String firstName, String lastName, String user, String password){
        if (findStudent(id) == -1){
            students.add(new Student(id,firstName,lastName,user,password));
            return true;
        }
        return false;
    }
    public boolean addTeacher(String id, String firstName, String lastName, String user, String password){
        if (findTeacher( id) == -1){
            teachers.add(new Teacher(id, firstName, lastName, user, password));
            return true;
        }
        return false;
    }
    public boolean addGroup(String id, String idTeacher, String idSubject){
        if (findTeacher(idTeacher) != -1 && findSubject(idSubject) != -1){
            groups.add(new Group(id, teachers.get(findTeacher(idTeacher)), subjects.get(findSubject(idSubject)) ));
            return true;
        }

        return false;
    }
    public boolean addActivity(String description, LocalDate dateStart, LocalDate dateEnd, TypeActivity typeActivity,String idGroup){
        int posGroup = findGroup(idGroup);
        if (posGroup != -1){
            if (groups.get(posGroup).findActivity(description) == false){

                // groups.get(posGroup).assignActivity(new Activity(description, dateStart,dateEnd,typeActivity,groups.get(posGroup)));
                for (int i = 0; i < groups.get(posGroup).getStudents().size(); i++) {
                    groups.get(posGroup).getStudents().get(i).getGroups().get(findGroup(idGroup)).addActivity(new Activity(description, dateStart,dateEnd,typeActivity,groups.get(posGroup)));
                    System.out.println("pos:"+i);

                }
                return true;
            }

        }

    return false;
    }
    public boolean addScore(String idGroup, String idStudent, String descriptionActivity, double score){

       int posStudent = findStudent(idStudent);
       int posGroup = findGroup(idGroup);
       if (groups.get(posGroup).findStudent(idStudent)!=-1){
       students.get(posStudent).getGroups().get(findGroup(idGroup)).getActivities().get(students.get(posStudent).findActivity(idGroup,descriptionActivity)).setScore(score);
       return true;
       }




        return false;
    }
    public  int findGroup(String id){
        for (int i = 0; i < groups.size(); i++) {
            if (groups.get(i).getId().equals(id)){
                return i;
            }
        }
        return -1;
    }
    public int findSubject(String id){
        for (int i = 0; i < subjects.size(); i++) {
            if (subjects.get(i).getId().equals(id)){
                return i;
            }

        }
        return -1;
    }
    public int findTeacher(String id){
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId().equals(id)){
                return i;
            }

        }
        return -1;

    }
    public int findStudent(String id){
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)){
                return  i;

            }

        }
        return -1;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }
}
