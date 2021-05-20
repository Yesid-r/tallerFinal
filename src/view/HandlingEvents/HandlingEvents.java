package view.HandlingEvents;

import control.Control;
import view.frames.MainWindow;
import view.panels.GroupsTemplate;
import view.service.TypeUsers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HandlingEvents implements ActionListener {
    public static final String LOGIN = "iniciar sesión";
    public static final String BTN_GROUP = "boton grupo";
    public static final String CURSOS = "cursos";
    public static final String STUDENTS = "lista de estudiantes";
    public static final String CLOSE_SESSION = "cerrar sesion";
    public static final String NOTES = "calificaciones estudiante";
    public static final String CURSOS_STUDENT = "cursos del estudiante";
    public static final String SAVE_NOTES = "Guardar notas";
    private  MainWindow mainWindow;
    private Control control;
    private GroupsTemplate groupsTemplate;
    private JScrollPane jScrollPane;
    public HandlingEvents(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        this.control = new Control();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String userGlobal = "";
        String typeUser = "";
        switch (e.getActionCommand()){


        case LOGIN:
        String [] data = mainWindow.captureDate(LOGIN);

            userGlobal = data[0];
            typeUser = data[2];

            if (control.verifyUser(data)) {
                String user = control.findNameUser(data[0], data[2]);
                if (data[2].equals(String.valueOf(TypeUsers.Docente))) {
                    groupsTemplate = new GroupsTemplate(mainWindow);
                    System.out.println("tamaño:" +control.groupsTeacher(data[0]).size());
                    groupsTemplate.setGroups(control.groupsTeacher(data[0]));
                    groupsTemplate.crearProductos();
                    mainWindow.setGroupsTemplate(groupsTemplate);
                    mainWindow.disablePanels(data[2]);
                    mainWindow.activePanel(data[2]);
                    mainWindow.getPanelNavigationT().getDescUser().setText(user);


                }else if (data[2].equals(String.valueOf(TypeUsers.Estudiante))){
                    String user2 = control.findNameUser(data[0], data[2] );
                    groupsTemplate = new GroupsTemplate(mainWindow);
                    groupsTemplate.setGroups(control.groupsStudent(data[0]));
                    groupsTemplate.crearProductos();
                    mainWindow.setGroupsTemplate(groupsTemplate);
                    mainWindow.disablePanels("all");
                    mainWindow.activePanel(String.valueOf(TypeUsers.Estudiante));
                    mainWindow.getPanelNavegationStdnt().getDescUser().setText(user2);

                    //pendiente disable y enable panels y añadir panel de navegación del estudiante.

                }
            }else {
                //Joption con advertencia usuario o contraseña incorrecto.
                JOptionPane.showMessageDialog(null,"Algo quedo mal");
            }


            break;
        case BTN_GROUP:
            JButton btn = (JButton) e.getSource();
            String idGroup = btn.getText();
            if (typeUser.equals(String.valueOf(TypeUsers.Docente))){

            }

            break;
        case CLOSE_SESSION:{
            mainWindow.disablePanels(CLOSE_SESSION);
            mainWindow.activePanel(CLOSE_SESSION);

        }
            break;
        }
    }
}
