package control;

import model.Group;
import model.Management;
import view.service.TypeUsers;

import java.util.ArrayList;

public class Control {
    private Management management;

    public Control() {
        this.management = new Management();
    }
    public boolean verifyUser(String[]data){
        switch (data[2]){
            case "Docente":{
                for (int i = 0; i < management.getTeachers().size(); i++) {
                    if (management.getTeachers().get(i).getUser().equals(data[0]) && management.getTeachers().get(i).getPassword().equals(data[1])){
                        return true;
                    }
                }
            }
            break;
            case "Estudiante":{
                for (int i = 0; i < management.getStudents().size(); i++) {
                    if (management.getStudents().get(i).getUser().equals(data[0]) && management.getStudents().get(i).getPassword().equals(data[1])){
                        return true;
                    }

                }
            }
        }
        return false;
    }
    public ArrayList<Group> groupsTeacher(String user){
        ArrayList<Group> groups = new ArrayList<>();
        for (int i = 0; i < management.getGroups().size(); i++) {
            if (management.getGroups().get(i).getTeacher().getUser().equals(user)){
                groups.add(management.getGroups().get(i));
            }

        }
        return groups;
    }

    public Management getManagement() {
        return management;
    }
    public String findNameUser(String user, String typeUser){
        if (typeUser.equals(String.valueOf(TypeUsers.Docente))){
            for (int i = 0; i < management.getTeachers().size(); i++) {
                if (management.getTeachers().get(i).getUser().equals(user)){
                    return management.getTeachers().get(i).getFirstName();
                }
            }
        }else if(typeUser.equals(String.valueOf(TypeUsers.Estudiante))){
            for (int i = 0; i < management.getStudents().size(); i++) {
                if (management.getStudents().get(i).getUser().equals(user)){
                    return management.getStudents().get(i).getFirstName();
                }
            }

        }
        return "";
    }
    public int findUser(String user){
        for (int i = 0; i < management.getTeachers().size(); i++) {
            if (management.getTeachers().get(i).getUser().equals(user)){
                return i;
            }

        }
        return -1;
    }
}
