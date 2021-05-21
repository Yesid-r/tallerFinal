package control;

import model.*;
import persistencia.ServicePersistence;
import view.service.TypeUsers;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Control {
    private Management management;
    private ServicePersistence servicePersistence;
    /**
     * Descripción: metodo constructor de la clase:
     *
     */

    public Control() {

        servicePersistence = new ServicePersistence();
        this.management = new Management();
        loadData();

    }

    /**
     * Descripción: metodo que carga los datos al sistema desde archivos Json     *
     *
     */
    public void loadData(){
        this.management.getTeachers().addAll(servicePersistence.getTeachers());
        this.management.getSubjects().addAll(servicePersistence.getSubjects());
        this.management.getGroups().addAll(servicePersistence.getGroups());
        this.management.getStudents().addAll(servicePersistence.getStudents());
        servicePersistence.dumpTeachers(management.getTeachers());
        servicePersistence.dumpStudents(management.getStudents());

    }
    /**
     * Descripción: metodo que verifica usuario y contraseña de un docente o estudiante
     * @param data (String[]): vector de estring con los datos de inicio de sesión
     * @return boolean
     */
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
    /**
     * Descripción: metodo que retorna una lista de los grupos pertenecientes a un docente
     * @param user (String): usuario a buscar
     * @return ArrayList
     */
    public ArrayList<Group> groupsTeacher(String user){
        ArrayList<Group> groups = new ArrayList<>();
        Teacher teacher = management.getTeachers().get(findTeacherbyUser(user));
        if (teacher !=null){
            return teacher.getGroups();
        }
        return groups;
    }
    /**
     * Descripción: metodo que consulta si eexiste un docente con base al usuario
     * @param user (String): usuario.
     * @return ArrayList
     */
    public int findTeacherbyUser(String user){
        for (int i = 0; i < management.getTeachers().size(); i++) {
            if (management.getTeachers().get(i).getUser().equals(user)){
                return i;
            }

        }
        return -1;
    }
    /**
     * Descripción: metodo que devuelve una lista de los grupos asignados a un estudiante.
     * @param user (String): usuario.
     * @return ArrayList
     */
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
    /**
     * Descripción: metodo que consulta si eexiste un docente con base al usuario
     * @param user (String): usuario.
     * @return ArrayList
     */
    public int findStudentByUser(String user){
        for (int i = 0; i < management.getStudents().size(); i++) {
            if (management.getStudents().get(i).getUser().equals(user)){
                return i;
            }

        }
        return -1;
    }



    /**
     * Descripción: metodo que consulta el nombre de un usuario registrado en el sistema
     * @param user (String): usuario.
     * @param typeUser (String): tipo de usuario
     * @return String
     */
    public String findNameUser(String user, String typeUser){
        if (typeUser.equals(String.valueOf(TypeUsers.Docente))){
            return management.getTeachers().get(findTeacherbyUser(user)).getFirstName();
        }else if(typeUser.equals(String.valueOf(TypeUsers.Estudiante))){
            return management.getStudents().get(findStudentByUser(user)).getFirstName();
        }
        return "";
    }

    /**
     * Descripción: metodo que devuelve una lista de las actvidades asignadas a un usuario
     * @param user (String): usuario.
     * @param typeUser (String): tipo de usuario.
     * @param idGroup (String): id del grupo
     * @return ArrayList
     */

    public ArrayList<Activity> activities(String user, String typeUser, String idGroup) {
        ArrayList<Activity> activities = new ArrayList<>();
        if (typeUser.equals(String.valueOf(TypeUsers.Docente))){
            int posGroup = management.getTeachers().get(findTeacherbyUser(user)).findGroup(idGroup);
            return management.getTeachers().get(findTeacherbyUser(user)).getGroups().get(posGroup).getActivities();
        }else if(typeUser.equals(String.valueOf(TypeUsers.Estudiante))){

        }
        return activities;
    }


    /**
     * Descripción: metodo que asigna una actividad a un grupo de estudiantes.
     * @param dataActivity (String[]): vector de string con datos para registrar la actividad.
     * @param userTeacher (String): usuario del docente
     * @param idGroupA (String): id del grupo al cual se va a asignar la actividad
     * @return boolean
     */
    public boolean saveActivity(String[] dataActivity, String idGroupA, String userTeacher) {
        Activity activity = null;
        try {
             activity = new Activity(dataActivity[1],  changeToLocalDate(dataActivity[2]), changeToLocalDate(dataActivity[3]), TypeActivity.valueOf(dataActivity[4]));
        }catch (Exception e){
            return false;
        }


        management.addActivity(idGroupA,userTeacher,activity);

        return false;

    }
    /**
     * Descripción: metodo que convierte un string a LocalDate
     * @param date (String): fecha en formato string
     * @return LocalDate
     */
    public LocalDate changeToLocalDate(String date){
        return  LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    /**
     * Descripción: metodo que consulta si existe un grupo en el sistema.
     * @param id (String): identificador del grupo
     * @return int
     */
    public int findGroup(String id){
        for (int i = 0; i < management.getGroups().size(); i++) {
            if (management.getGroups().get(i).getId().equals(id)){
                return i;
            }

        }
        return -1;

    }
    /**
     * Descripción: metodo que consulta las notas de un estudiante.
     * @param data (String[]): información para consultar.
     * @return String[][]
     */
    public String[][] notesStudent(String[] data) {
    int posStudent = findStudentByUser(data[0]);
        String [][] out = new String[management.getStudents().get(posStudent).getEnrolments().size()][3];
        for (int i = 0; i < out.length; i++) {
            out[i][0] = management.getStudents().get(posStudent).getEnrolments().get(i).getIdGroup();
            out[i][1] = ""+ management.getGroups().get(findGroup(management.getStudents().get(posStudent).getEnrolments().get(i).getIdGroup())).getSubject().getDescription();
            out[i][2] = ""+management.getStudents().get(posStudent).getEnrolments().get(i).getScore();

        }
        return out;

    }
    public Management getManagement() {

        return management;
    }
}
