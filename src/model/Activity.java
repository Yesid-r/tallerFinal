package model;

import java.time.LocalDate;
/** @author Dairo Yesid Rincón carreño*/


public class Activity implements Cloneable{

    private String id;
    private String description;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private TypeActivity typeActivity;
    private double score;
    private boolean status;
    /**
        *Descripción: Metodo constructor de la clase Actividad
     * @param description (String): atributo que define la descripción de la actividad
     * @param dateStar (LocalDate): indica fecha en que se creo la actividad
     * @param dateEnd (LocalDate): indica fecha limite de entrega
     * @param typeActivity (TypeActivity): atrributo que define el tipo de actividad.
     */

    public Activity(String description, LocalDate dateStar, LocalDate dateEnd, TypeActivity typeActivity) {
        this.description = description;
        this.dateStart = dateStar;
        this.dateEnd = dateEnd;
        this.typeActivity = typeActivity;
        this.score = 0;
        this.status = false;
    }


    /**
     * Descripción: metodo que retorna el estado de la actividad como boolean
     * @return boolean
     */
    public boolean isStatus() {
        return status;
    }


    /**
     * descripcion:metodo que establece el estado de la actividad
     * @param status (boolean): estado de la actividad
     *
     */
    public void setStatus(boolean status) {
        this.status = status;
    }


    /**
     * Descripción metodo que retorna el tipo de actividad
     * @return typeActivity
     */
    public TypeActivity getTypeActivity() {
        return typeActivity;
    }

    public String getDescription() {
        return description;
    }

    public double getScore() {
        return score;
    }



    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
