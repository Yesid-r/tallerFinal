package model;

import java.util.ArrayList;

public class Student {
    private String id;
    private String firstName;
    private String lastName;
    private String user;
    private String password;

    private double average;
    private ArrayList<Enrolment> enrolments;



    /**
     * Descripción: metodo constructor de la clase.
     * @param id (String): identificador del estudiante
     * @param firstName (String): nombre del estudiante
     * @param lastName (String): apellidos del estudiante
     * @param user (String): usuario del estudiante
     * @param password (String): contraseña del usuario asignada a la plataforma.
     */

    public Student(String id, String firstName, String lastName, String user, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.user = user;
        this.password = password;
        this.average = 0;
        enrolments = new ArrayList<>();
    }

    /**
     * Descripción: metodo que ubica la posición de una inscripción dentro de la coleccion de objetos Enrolment
     * @param id (String): identificador de la inscripción
     * @return int
     */
    public int findEnrolment(String id){
        for (int i = 0; i < enrolments.size(); i++) {
            if (enrolments.get(i).getIdInscription().equals(id)){
                return i;
            }

        }
        return -1;

    }




    /**
     * Descripción: metodo que calcula la nota final en el semestre del estudiante
     * @return double: valor con la nota final.
     */
    public double calcAverage(){
        double finalScore = 0;
        for (int i = 0; i < enrolments.size(); i++) {
            finalScore += enrolments.get(i).getScore();
        }
        return  finalScore/enrolments.size();

    }

    /**
     * Descripción: metodo que establece el promedio.
     */
    public void setAverage(double average) {
        this.average = average;
    }


    /**
     * metodo de acceso
     */
    public String getId() {
        return id;
    }


    /**
     * metodo de acceso
     */
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


    public ArrayList<Enrolment> getEnrolments() {
        return enrolments;
    }
}
