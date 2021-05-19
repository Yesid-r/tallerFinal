package model;

import java.awt.*;

public class Subject {
    private String id;
    private String description;
    private short numberCredits;
    private Image image;

    public Subject(String id, String description, short numberCredits) {
        this.id = id;
        this.description = description;
        this.numberCredits = numberCredits;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public short getNumberCredits() {
        return numberCredits;
    }
}
