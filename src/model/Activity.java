package model;

import java.time.LocalDate;

public class Activity {
    private String id;
    private String description;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private TypeActivity typeActivity;
    private double score;

    public Activity(String description, LocalDate dateStar, LocalDate dateEnd, TypeActivity typeActivity) {
        this.description = description;
        this.dateStart = dateStar;
        this.dateEnd = dateEnd;
        this.typeActivity = typeActivity;
        this.score = 0;
    }

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
}
