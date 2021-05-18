package model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GroupTest {

    private String id;
    private Teacher teacher;
    private Subject subject;
    private ArrayList<Student> students;
    private ArrayList<Activity> activities ;
    private Group group;
    public void setup(){
        this.id = "60";
        this.teacher = new Teacher("123","Javier","Ramirez", "jramirez@gmail.com","jrami");
        this.subject = new Subject("1","Programación",(short)4);
        students = new ArrayList<Student>();
        students.add(new Student("12345","Juan","Torrez","jtorres@gmail.com","jt"));
        this.group = new Group(id,teacher,subject);
        group.getStudents().addAll(students);

        activities = new ArrayList<>();
        activities.add(new Activity("jm", LocalDate.now(),LocalDate.now(),TypeActivity.Evaluación,group));
        activities.add(new Activity("12",LocalDate.now(),LocalDate.now(),TypeActivity.Evaluación,group));
        activities.get(0).setScore(4);
        activities.get(1).setScore(3);
        group.getActivities().addAll(activities);

    }
    @Test
    public  void test(){
        setup();
        assertEquals(3.5,group.finalScore());
    }

}