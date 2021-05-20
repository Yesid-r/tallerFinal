package model;

import persistencia.ServicePersistence;


import java.time.LocalDate;
import java.util.ArrayList;

public class Management {
    private ArrayList<Student> students;
    private ArrayList<Teacher> teachers;
    private ArrayList<Group> groups;
    private ArrayList<Subject> subjects;


    public Management() {
        students = new ArrayList<>();
        teachers = new ArrayList<>();
        groups = new ArrayList<>();
        subjects = new ArrayList<>();
       // servicePersistence = new ServicePersistence();
       // loadData();
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
    public boolean addEnrolment(String idStudent, String idGroup, String idTeacher){
        int posStudent = findStudent(idStudent);
        int posGroup = findGroup(idGroup);
        int posTeacher = findTeacher(idTeacher);
        Enrolment enrolment = new Enrolment(idGroup,idStudent);
        if (posGroup != -1 && posStudent!= -1 && posTeacher !=-1){
            if (students.get(posStudent).findEnrolment(enrolment.getIdInscription()) ==-1 ){
                groups.get(posGroup).getEnrolments().add(enrolment);
                System.out.println("pos inscripción: "+ students.get(posStudent).findEnrolment(idStudent));
                students.get(posStudent).getEnrolments().add(enrolment);
                System.out.println("añadiendo grupo al docente"+teachers.get(posTeacher).addGroup(groups.get(posGroup)));

                return true;

            }
        }
       return false;
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
