package persistencia;

import model.Group;
import model.Student;
import model.Subject;
import model.Teacher;

import java.io.IOException;
import java.util.ArrayList;

public class ServicePersistence {
    private FileJsonTeacher fileJsonTeacher;
    private FileJsonStudent fileJsonStudent;
    private FileJsonSubject fileJsonSubject;
    private FileJsonGroup fileJsonGroup;

    public ServicePersistence() {
        this.fileJsonTeacher = new FileJsonTeacher();
        fileJsonTeacher.setPathFile("resource/files/");
        fileJsonTeacher.setNameFile("teachers.json");
        fileJsonTeacher.openFile();

        this.fileJsonStudent = new FileJsonStudent();
        fileJsonStudent.setPathFile("resource/files/");
        fileJsonStudent.setNameFile("students.json");
        fileJsonStudent.openFile();

        this.fileJsonSubject = new FileJsonSubject();
        fileJsonSubject.setPathFile("resource/files/");
        fileJsonSubject.setNameFile("subjects.json");
        fileJsonSubject.openFile();

        this.fileJsonGroup = new FileJsonGroup();
        fileJsonGroup.setPathFile("resource/files/");
        fileJsonGroup.setNameFile("groups.json");
        fileJsonGroup.openFile();


    }

    public boolean dumpTeachers(ArrayList<Teacher> teachers){
        try {
            fileJsonTeacher.dumpObjects(teachers);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    public boolean dumpStudents(ArrayList<Student> students){
        try {
            fileJsonStudent.dumpObjects(students);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    public boolean dumpSubjects(ArrayList<Subject> subjects){
        try {
            fileJsonSubject.dumpObjects(subjects);
            return true;
        } catch (IOException e) {
            return false;
        }

    }
    public boolean dumpGroups(ArrayList<Group> groups){
        try {
            fileJsonGroup.dumpObjects(groups);
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
    public ArrayList<Student> getStudents(){
        fileJsonStudent.setPathFile("resource/files/");
        fileJsonStudent.setNameFile("students.json");
        fileJsonStudent.openFile();

        try {
            ArrayList<Student> students = fileJsonStudent.getObjects();
            return students;
        } catch (IOException e) {
            return null;
        }

    }
    public ArrayList<Subject> getSubjects(){
        fileJsonSubject.setPathFile("resource/files/");
        fileJsonSubject.setNameFile("subjects.json");
        fileJsonSubject.openFile();

        ArrayList<Subject> subjects = null;
        try {
            subjects = fileJsonSubject.getSubjects();
        } catch (IOException e) {
            return null;
        }
        return subjects;

    }
    public ArrayList<Group> getGroups(){
        fileJsonGroup.setPathFile("resource/files/");
        fileJsonGroup.setNameFile("groups.json");
        fileJsonGroup.openFile();

        try {
            ArrayList<Group> groups = fileJsonGroup.getGroups();
            return groups;
        } catch (IOException e) {
            return null;
        }
    }

}
