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
        Teacher teacher = new Teacher("123","Juan","Perez","jperez@gmail.com","1234");
        teachers.add(teacher);
        ArrayList<Student> students = new ArrayList<>();
        Student student =new Student("1232","Eden","Hazard","ehazard@hotmail.com","edhazard");
        students.add(student);


        ArrayList<Subject> subjects = new ArrayList<Subject>();
        Subject subject = new Subject("60","Programación II",(short)4);
        subjects.add(subject);
        assertEquals(true, management.getServicePersistence().dumpSubjects(subjects));

        ArrayList<Group> groups = new ArrayList<>();
        Group group = new Group("80",teacher,subject);
        groups.add(group);
        student.getGroups().addAll(groups);
        management.getServicePersistence().dumpStudents(students);
        teachers.get(0).getGroups().add(group);
        System.out.println(teacher.getGroups().get(0).getId());
        //management.dumpObjects(teachers);
        assertEquals("80", management.getServicePersistence().getTeachers().get(0).getGroups().get(0).getId());
        assertEquals(2, management.getServicePersistence().getTeachers().size());
        ArrayList<Teacher> teachers1 = management.getServicePersistence().getTeachers();
        assertEquals(true,management.getServicePersistence().dumpTeachers(teachers1));
        //management.getServicePersistence().dumpTeachers(teachers);
       // assertEquals(true, management.getServicePersistence().dumpGroups(groups));
        //assertEquals(true,management.getServicePersistence().dumpStudents(students));
        //teacher.getGroups().add(group);
        //management.dumpObjects(teachers);
    }

}