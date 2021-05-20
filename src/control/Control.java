package control;

import model.*;
import persistencia.ServicePersistence;
import view.service.TypeUsers;

import javax.swing.*;
import java.util.ArrayList;

public class Control {
    private Management management;
    private ServicePersistence servicePersistence;

    public Control() {

        servicePersistence = new ServicePersistence();
        this.management = new Management();
        loadData();

    }


    public void loadData(){


        this.management.getTeachers().addAll(servicePersistence.getTeachers());
        this.management.getSubjects().addAll(servicePersistence.getSubjects());
        this.management.getGroups().addAll(servicePersistence.getGroups());
        this.management.getStudents().addAll(servicePersistence.getStudents());
        System.out.println("cant studiantes: "+ management.getStudents().size());


        servicePersistence.dumpTeachers(management.getTeachers());
        servicePersistence.dumpStudents(management.getStudents());


    }
    public boolean verifyUser(String[]data){
        switch (data[2]){
            case "Docente":{
                int posTeacher = findTeacherbyUser(data[0]);
                if (posTeacher!= -1  ){
                    if (management.getTeachers().get(posTeacher).getPassword().equals(data[1])){
                        return true;
                    }
                }
            }
            break;
            case "Estudiante":{
                for (int i = 0; i < management.getStudents().size(); i++) {
                    if (management.getStudents().get(i).getUser().equals(data[0]) && management.getStudents().get(i).getPassword().equals(data[1])){
                        System.out.println(true);
                        return true;
                    }

                }
            }
        }
        return false;
    }
    public ArrayList<Group> groupsTeacher(String user){
        ArrayList<Group> groups = new ArrayList<>();
        Teacher teacher = management.getTeachers().get(findTeacherbyUser(user));
        /*
        for (int i = 0; i < management.getGroups().size(); i++) {
            for (int j = 0; j < teacher.getEnrolments().size(); j++) {
                if (management.getGroups().get(i).getId().equals(teacher.getEnrolments().get(j).getIdGroup())){

                    groups.add(management.getGroups().get(i));
                }
            }

        }

         */
        if (teacher !=null){
            return teacher.getGroups();
        }
        return groups;
    }
    public int findTeacherbyUser(String user){
        for (int i = 0; i < management.getTeachers().size(); i++) {
            if (management.getTeachers().get(i).getUser().equals(user)){
                return i;
            }

        }
        return -1;
    }
    public ArrayList<Group> groupsStudent(String user){
        ArrayList<Group> groups = new ArrayList<>();
        Student student = management.getStudents().get(findStudentByUser(user));
        for (int i = 0; i < management.getGroups().size(); i++) {
            for (int j = 0; j < student.getEnrolments().size(); j++) {
                if (student.getEnrolments().get(j).getIdGroup().equals(management.getGroups().get(i).getId())){
                groups.add(management.getGroups().get(i));
                }
            }


        }

        return groups;
    }
    public int findStudentByUser(String user){
        for (int i = 0; i < management.getStudents().size(); i++) {
            if (management.getStudents().get(i).getUser().equals(user)){
                return i;
            }

        }
        return -1;
    }


    public Management getManagement() {

        return management;
    }
    public String findNameUser(String user, String typeUser){
        if (typeUser.equals(String.valueOf(TypeUsers.Docente))){
            return management.getTeachers().get(findTeacherbyUser(user)).getFirstName();
        }else if(typeUser.equals(String.valueOf(TypeUsers.Estudiante))){
            return management.getStudents().get(findStudentByUser(user)).getFirstName();
        }
        return "";
    }



}
