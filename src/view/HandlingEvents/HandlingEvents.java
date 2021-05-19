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
    switch (e.getActionCommand()){
        case LOGIN: {
            String[] data = mainWindow.captureDate(LOGIN);
            String user = control.findNameUser(data[0], data[2]);
            int posUser = control.findUser(data[0]);

            if (control.verifyUser(data)) {
                if (data[2].equals(String.valueOf(TypeUsers.Docente))) {
                    groupsTemplate = new GroupsTemplate(mainWindow);
                    groupsTemplate.setGroups(control.getManagement().getTeachers().get(posUser).getGroups());
                    groupsTemplate.crearProductos();
                    mainWindow.setGroupsTemplate(groupsTemplate);
                    mainWindow.disablePanels(data[2]);
                    mainWindow.activePanel(data[2]);
                    mainWindow.getPanelNavigationT().getDescUser().setText(user);


                }
            }

        }
            break;
        case BTN_GROUP:
            break;
        case CLOSE_SESSION:{
            mainWindow.disablePanels(CLOSE_SESSION);
            mainWindow.activePanel(CLOSE_SESSION);

        }
            break;
        }
    }
}
