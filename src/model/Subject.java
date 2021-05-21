package model;

import java.awt.*;

public class Subject {
    private String id;
    private String description;
    private short numberCredits;
    private Image image;


    /**
     * Descripción: metodo constructor de la clase
     * @param id (String): identificador de la materia.
     * @param description (String): descripción o nombre de la asignatura.
     * @param numberCredits (short): número de creditos de la materia
     */
    public Subject(String id, String description, short numberCredits) {
        this.id = id;
        this.description = description;
        this.numberCredits = numberCredits;
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
    public String getDescription() {
        return description;
    }

    /**
     * metodo de acceso
     */
    public short getNumberCredits() {
        return numberCredits;
    }
}
