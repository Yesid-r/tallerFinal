package model;

import java.util.ArrayList;

/**
 * @author dairo
 */

public class Group {
    private String id;
    private String idTeacher;
    private String nameTeacher;
    private Subject subject;
    private ArrayList<Enrolment> enrolments;
    private ArrayList<Activity> activities ;
    private double score;

    /**
     * Descripción: metodo constructor de la calse Group
     * @param id (String): id del grupo a quien pertenece
     * @param idTeacher (String): id del docente asignado al grupo
     * @param nameTeacher (String): nombre del docente
     * @param subject (Subject): Objeto subject
     */
    public Group(String id, String idTeacher,String nameTeacher, Subject subject) {
        this.id = id;
        this.idTeacher = idTeacher;
        this.nameTeacher = nameTeacher;
        this.subject = subject;
        this.enrolments = new ArrayList<>();
        this.activities = new ArrayList<Activity>();
        this.score = 0;

    }


    /**
     * metodo de acceso
     */
    public String getIdTeacher() {
        return idTeacher;
    }



    /**
     * metodo de acceso
     */
    public String getNameTeacher() {
        return nameTeacher;
    }


    /**m
     * metodo de acceso
     */
    public double getScore() {
        return score;
    }



    /**
     * Descripción: metodo acceso a lista de actividades pertenecientes al grupo.
     * @return ArrayList
     */
    public ArrayList<Activity> getActivities() {
        return activities;
    }
    public void addActivity(Activity activity){
        this.activities.add(activity);

    }

    /**
     * Descripción: metodo que ubica la posicion en la cual se encuentra una actividad dentro del Array
     * @param desc (String): valor que indica la descripción de la actividad
     * @return int: posición de la actividad dentro del Array
     */
    public boolean findActivity(String desc){
        for (int i = 0; i < activities.size(); i++) {
            if (activities.get(i).getDescription().equals(desc)){
                return true;
            }

        }
        return false;
    }

    /**
     * metodo de acceso
     */
    public ArrayList<Enrolment> getEnrolments() {
        return enrolments;
    }

    public String getId() {
        return id;
    }

    public Subject getSubject() {
        return subject;
    }


}
