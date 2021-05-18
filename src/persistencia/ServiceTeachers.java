package persistencia;

import model.Teacher;

import java.io.IOException;
import java.util.ArrayList;

public class ServiceTeachers {
    private FileJsonTeacher fileJsonTeacher;

    public ServiceTeachers() {
        this.fileJsonTeacher = new FileJsonTeacher();
        fileJsonTeacher.setPathFile("resource/files/");
        fileJsonTeacher.setNameFile("teachers.json");
        fileJsonTeacher.openFile();
    }

    public boolean dumpTeachers(ArrayList<Teacher> teachers){
        try {
            fileJsonTeacher.dumpObjects(teachers);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    public ArrayList<Teacher> getTeachers(){
        fileJsonTeacher.setPathFile("resource/files/");
        fileJsonTeacher.setNameFile("teachers.json");
        fileJsonTeacher.openFile();

        try {
            ArrayList<Teacher>teachers = fileJsonTeacher.getTeachers();
            return teachers;
        } catch (IOException e) {
            return null;
        }
    }
}
