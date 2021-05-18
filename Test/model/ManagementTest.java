package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ManagementTest {
private Management management;
    public void setup(){
    management = new Management();
    //management.getTeachers().add(new Teacher("123","Juan","Perez","jperez@gmail.com","das"));
    }
    @Test
    public void testAddTeacher(){
        setup();
        assertEquals("123", management.getTeachers().get(0).getId());
        ArrayList<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher("123","Juan","Perez","jperez@gmail.com","1234"));

        management.dumpObjects(teachers);
    }

}