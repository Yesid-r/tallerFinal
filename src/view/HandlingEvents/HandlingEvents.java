package view.HandlingEvents;

import control.Control;
import model.Group;
import view.frames.MainWindow;
import view.panels.ActivitiesTemplate;
import view.panels.GroupTemplate;
import view.panels.GroupsTemplate;
import view.panels.PanelNotes;
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
    public static final String ADD_ACTIVITY = "añadir actividad";
    public static final String SAVE_ACTIVITY = "GUARDAR ACTIVIDAD";
    public static final String QUALIFY_ACTIVITY = "calificar actividad";
    private  MainWindow mainWindow;
    private Control control;
    private GroupsTemplate groupsTemplate;
    private ActivitiesTemplate activitiesTemplate;
    private JScrollPane jScrollPane;
    private String user="";
    private String typeUser="";
    private JButton btnGroup = new JButton();
    private String grp[] = new String[10];

    public HandlingEvents(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        this.control = new Control();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(BTN_GROUP)){
            System.out.println("ingreso");
            JButton btn = (JButton) e.getSource();
            int cantGrpups = 0;
            grp[cantGrpups] = btn.getText();
            cantGrpups++;
        }



        switch (e.getActionCommand()){


        case LOGIN:
        String [] data = mainWindow.captureDate(LOGIN);
            System.out.println(data[0]+ data[1]+ data[2]);
        this.user = mainWindow.captureDate(LOGIN)[0];
        this.typeUser= data[2];

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

             System.out.println("iddel grupo:"+ btn.getText());

           String[] dataG = mainWindow.captureDate(LOGIN);
           if (dataG[2].equals(String.valueOf(TypeUsers.Docente))){
               activitiesTemplate = new ActivitiesTemplate(mainWindow);
               activitiesTemplate.setActivities(control.activities(dataG[0], dataG[2], btn.getText()));
               activitiesTemplate.createActivities();
               mainWindow.setActivitiesTemplate(activitiesTemplate);

               mainWindow.disablePanels(CLOSE_SESSION);
               mainWindow.activePanel(BTN_GROUP);
           }


            break;
        case CLOSE_SESSION:{
            mainWindow.disablePanels(CLOSE_SESSION);
            mainWindow.disablePanels(BTN_GROUP);
            mainWindow.disablePanels("est");
            mainWindow.disablePanels(NOTES);
            mainWindow.activePanel(CLOSE_SESSION);
            break;


        }
            case ADD_ACTIVITY: {
                System.out.println("btn añadir actividad");
                // mainWindow.registerActivity();
                mainWindow.disablePanels(ADD_ACTIVITY);
                mainWindow.activePanel(ADD_ACTIVITY);
            }
            break;
            case SAVE_ACTIVITY:
                for (int i = 0; i < grp.length; i++) {

                    System.out.println("id del grupo: "+i+" "+grp[i]);
                }

                String[] dataActivity = mainWindow.captureDate(SAVE_ACTIVITY);
                //if (control.saveActivity(dataActivity, btnGroup.getText(), mainWindow.captureDate(LOGIN)[0])){
                    //JOptionPane.showMessageDialog(null,"GUARDADO CORRECTAMENTE");

                //}else {
                  //  JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
               // }


            break;
            case NOTES:
                String[][] dataTable = control.notesStudent(mainWindow.captureDate(LOGIN));
                PanelNotes panelNotes = new PanelNotes();
                mainWindow.disablePanels("grupos");
                panelNotes.showTable(dataTable);
                mainWindow.setPanelNotes(panelNotes);

                mainWindow.activePanel(NOTES);
                break;
        }
    }
    public void activities(String[]data){

    }
}
