package model;

import persistencia.ServicePersistence;


import java.time.LocalDate;
import java.util.ArrayList;

public class Management {
    private ArrayList<Student> students;
    private ArrayList<Teacher> teachers;
    private ArrayList<Group> groups;
    private ArrayList<Subject> subjects;
    /**
     * Descripción: metodo constructor de la clase Management
     */

    public Management() {
        students = new ArrayList<>();
        teachers = new ArrayList<>();
        groups = new ArrayList<>();
        subjects = new ArrayList<>();
    }

    /**
     * Descripción: metodo que agrega un estudiante al array
     *@param id (String): identificador del estudiante
     *@param firstName (String): nombre del estudiante
     *@param lastName (String): apellidos del estudiante
     *@param user (String): usuario del estudiante
     *@param password (String): contraseña del usuario asignada a la plataforma.
     * @return boolean
     */
    public boolean addStudent(String id, String firstName, String lastName, String user, String password){
        if (findStudent(id) == -1){
            students.add(new Student(id,firstName,lastName,user,password));
            return true;
        }
        return false;
    }
    /**
     * Descripción: metodo que agrega un docente a la colección
     * @param id (String): identificador del docente
     * @param firstName (String): nombre del docente
     * @param lastName (String): apellidos del docente
     * @param user (String): usuario asignado al docente
     * @param password (String): contraseña
     * @return  boolean
     */
    public boolean addTeacher(String id, String firstName, String lastName, String user, String password){
        if (findTeacher( id) == -1){
            teachers.add(new Teacher(id, firstName, lastName, user, password));
            return true;
        }
        return false;
    }

    /**
     * Descripción: metodo que consulta si existe un grupo dentro de la colección:
     * @param id (String): identificador del grupo
     * @return int
     */
    public  int findGroup(String id){
        for (int i = 0; i < groups.size(); i++) {
            if (groups.get(i).getId().equals(id)){
                return i;
            }
        }
        return -1;
    }
    /**
     * Descripción: metodo que consulta si existe una asignatura dentro de la colección:
     * @param id (String): identificador de la asignatura
     * @return int
     */

    public int findSubject(String id){
        for (int i = 0; i < subjects.size(); i++) {
            if (subjects.get(i).getId().equals(id)){
                return i;
            }

        }
        return -1;
    }
    /**
     * Descripción: metodo que agrega una actividad a un grupo
     * @param idGroup (String): identificador del grupo al cual se va a asignar la asignatura.
     * @param userTeacher (String): usuario del docente asignado al grupo
     * @param activity (String): actividad para asignar al grupo
     * @return boolean
     */
    public boolean addActivity(String idGroup, String userTeacher, Activity activity){
        int posGroup = findGroup(idGroup);
        groups.get(posGroup).getActivities().add(activity);
        Group group = groups.get(posGroup);
        for (int i = 0; i < group.getEnrolments().size(); i++) {
            int posStudent  = findStudent(group.getEnrolments().get(i).getIdStudent());
            Student student = students.get(posStudent);
            int posEnrollment = student.findEnrolment(student.getId()+"-"+idGroup);

            try {
                students.get(posStudent).getEnrolments().get(posEnrollment).getActivities().add((Activity) activity.clone());
            } catch (CloneNotSupportedException e) {
                return false;
            }
        }
        return false;

    }
    /**
     * Descripción: metodo que agrega una inscripción a un estudiante en especifico a un grupo ya existente.
     * @param idStudent (String): identificador del estudiante
     * @param idGroup (String): identificador del grupo
     * @param idTeacher (String): identificador del docente.
     * @return boolean
     */
    public boolean addEnrolment(String idStudent, String idGroup, String idTeacher){
        int posStudent = findStudent(idStudent);
        int posGroup = findGroup(idGroup);
        int posTeacher = findTeacher(idTeacher);
        Enrolment enrolment = new Enrolment(idGroup,idStudent);
        if (posGroup != -1 && posStudent!= -1 && posTeacher !=-1){
            if (students.get(posStudent).findEnrolment(enrolment.getIdInscription()) ==-1 ){
                groups.get(posGroup).getEnrolments().add(enrolment);
                students.get(posStudent).getEnrolments().add(enrolment);
                return true;

            }
        }
       return false;
    }
    /**
     * Descripción: metodo que busca si existe un docente
     * @param id (String): identificador del docente
     * @return int
     */

    public int findTeacher(String id){
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId().equals(id)){
                return i;
            }

        }
        return -1;

    }
    /**
     * Descripción: metodo que consulta un estudiante
     * @param id (String): identificador del estudiante
     * @return int
     */
    public int findStudent(String id){
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)){
                return  i;

            }

        }
        return -1;
    }
    /**
     * Descripción: metodo de acceso
     *
     * @return ArrayList
     */
    public ArrayList<Student> getStudents() {
        return students;
    }
    /**
     * Descripción: metodo de acceso
     *
     * @return ArrayList
     */
    public ArrayList<Group> getGroups() {
        return groups;
    }
    /**
     * Descripción: metodo de acceso
     *
     * @return ArrayList
     */

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    /**
     * Descripción: metodo de acceso
     *
     * @return ArrayList
     */
    public ArrayList<Subject> getSubjects() {
        return subjects;
    }
}
