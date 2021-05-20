package view.frames;

import model.Activity;
import model.Enrolment;
import model.Teacher;
import model.TypeActivity;
import view.HandlingEvents.HandlingEvents;
import view.panels.*;
import view.service.ResourceService;
import view.service.TypeUsers;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class MainWindow extends JFrame {
    private PanelLogin panelLogin;
    private JLabel lblDescWindow;
    private ResourceService rService;
    private PanelImage panelImage;
    private PanelNavigationT panelNavigationT;

    private GroupsTemplate groupsTemplate;
    private JScrollPane scrollPane;
    private JPanel jPanel;
    private PanelManageActivity panelManageActivity;


    public MainWindow() {
    super("Gestion de asiganaturas universidad NN");
    setLayout(new BorderLayout());
    setSize(1000,500);
    rService = ResourceService.getService();
    beginComponents();
    addComponents();
    setVisible(true);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    assignActionListener();

    }
    public void assignActionListener(){
        panelLogin.assignHandlingEvents(this);
        panelNavigationT.assignHandlingEvents(this);
    }

    public void beginComponents(){
        lblDescWindow = new JLabel("PLATAFORMA INSTITUCIONAL");
        lblDescWindow.setFont(rService.getFontTProducto());
        lblDescWindow.setForeground(Color.WHITE);

        lblDescWindow.setHorizontalAlignment(SwingConstants.CENTER);
        panelLogin = new PanelLogin();
        panelImage = new PanelImage();
        panelNavigationT = new PanelNavigationT();
        groupsTemplate = new GroupsTemplate(this);
        jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());
        panelManageActivity = new PanelManageActivity();

    }

    public GroupsTemplate getGroupsTemplate() {
        return groupsTemplate;
    }

    private void addComponents() {

     add(panelImage,BorderLayout.CENTER);
     add(panelLogin, BorderLayout.EAST);
        //add(panelManageActivity, BorderLayout.CENTER);
        /*Teacher teacher = new Teacher("12","juan","pepe","user","password");
        teacher.getEnrolments().add(new Enrolment("12","12"));
        teacher.getEnrolments().get(0).getActivities().add(new Activity("Jm", LocalDate.now(), LocalDate.now(), TypeActivity.Evaluación));

        ActivityTemplate activityTemplate = new ActivityTemplate(this);
        activityTemplate.createActivityTeacher(teacher,0,0);
        add(activityTemplate,BorderLayout.SOUTH);

         */


    }
    public void activePanel(String seccion){
        if (seccion.equals(String.valueOf(TypeUsers.Docente))){
            this.setSize(1100,600);
            setLocationRelativeTo(null);
            panelNavigationT.setVisible(true);
            add(panelNavigationT,BorderLayout.WEST);
            scrollPane = new JScrollPane(groupsTemplate);
            scrollPane.setVisible(true);
            add(scrollPane,BorderLayout.CENTER);

        }else if (seccion.equals(String.valueOf(TypeUsers.Estudiante))){
            this.setSize(1100,600);
            setLocationRelativeTo(null);
            scrollPane = new JScrollPane(groupsTemplate);
            scrollPane.setVisible(true);
            add(scrollPane, BorderLayout.CENTER);

        }else if(seccion.equals(HandlingEvents.CLOSE_SESSION)){
            this.setSize(1000,500);
            setLocationRelativeTo(null);
            panelImage.setVisible(true);
            panelLogin.setVisible(true);
            add(panelImage, BorderLayout.CENTER);
            add(panelLogin, BorderLayout.EAST);

        }
        repaint();

    }
    public  void disablePanels(String seccion){
        if (seccion.equals(String.valueOf(TypeUsers.Docente))){
            panelImage.setVisible(false);
            remove(panelImage);
            panelLogin.setVisible(false);
            remove(panelLogin);

        }else if (seccion.equals(String.valueOf(TypeUsers.Estudiante))){

            panelImage.setVisible(false);
            remove(panelImage);
            panelLogin.setVisible(false);
            remove(panelLogin);


        }else if(seccion.equals(HandlingEvents.CLOSE_SESSION)){
            panelNavigationT.setVisible(false);
            scrollPane.setVisible(false);
            remove(scrollPane);
            remove(panelNavigationT);

        }
        repaint();
    }


    public String[] captureDate(String seccion) {
        if (seccion.equals(HandlingEvents.LOGIN)){
            String[] data = {panelLogin.getTxtUser().getText(),
                            panelLogin.getPasswordField().getText(),
                            ""+panelLogin.getTypeUser().getSelectedItem()
            };
            return data;

        }else if (seccion.equals("cursos")){

        }
        return null;
    }
    public void messageError(String message){

    }
    public int messageConfirm(){
        int confirmado = JOptionPane.showConfirmDialog(
                null,
                "¿Lo confirmas?");


        return confirmado;
    }

    public PanelNavigationT getPanelNavigationT() {
        return panelNavigationT;
    }

    public void setGroupsTemplate(GroupsTemplate groupsTemplate) {
        this.groupsTemplate = groupsTemplate;
    }
}
