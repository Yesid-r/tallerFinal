package model;

public class Subject {
    private String id;
    private String description;
    private short numberCredits;

    public Subject(String id, String description, short numberCredits) {
        this.id = id;
        this.description = description;
        this.numberCredits = numberCredits;
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
