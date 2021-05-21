package view.frames;

import model.*;
import view.HandlingEvents.HandlingEvents;
import view.panels.*;
import view.service.ResourceService;
import view.service.TypeUsers;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class MainWindow extends JFrame {
    private PanelLogin panelLogin;
    private JLabel lblDescWindow;
    private ResourceService rService;
    private PanelImage panelImage;
    private PanelNavigationT panelNavigationT;
    private PanelNavegationStdnt panelNavegationStdnt;
    private GroupsTemplate groupsTemplate;
    private JScrollPane scrollPane;
    private JPanel jPanel;
    private PanelManageActivity panelManageActivity;

    private ActivitiesTemplate activitiesTemplate;


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
        panelNavegationStdnt.assignHandlingEvents(this);
        activitiesTemplate.addActionListener();
        panelManageActivity.assignHandlingEvents(this);

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
        panelNavegationStdnt = new PanelNavegationStdnt();
        activitiesTemplate = new ActivitiesTemplate(this);


    }

    public GroupsTemplate getGroupsTemplate() {
        return groupsTemplate;
    }



    private void addComponents() {


    add(panelImage,BorderLayout.CENTER);
    add(panelLogin, BorderLayout.EAST);

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
            System.out.println("panel");
            this.setSize(1100,600);
            setLocationRelativeTo(null);
            scrollPane = new JScrollPane(groupsTemplate);
            scrollPane.setVisible(true);
            add(scrollPane, BorderLayout.CENTER);
            panelNavegationStdnt.setVisible(true);
            add(panelNavegationStdnt, BorderLayout.WEST);

        }else if(seccion.equals(HandlingEvents.CLOSE_SESSION)){
            this.setSize(1000,500);
            setLocationRelativeTo(null);
            panelImage.setVisible(true);
            panelLogin.setVisible(true);
            add(panelImage, BorderLayout.CENTER);
            add(panelLogin, BorderLayout.EAST);

        }else if (seccion.equals(HandlingEvents.BTN_GROUP)){
            panelNavigationT.setVisible(true);
            add(panelNavigationT, BorderLayout.WEST);
            activitiesTemplate.setVisible(true);
            add(activitiesTemplate,BorderLayout.CENTER);
            panelManageActivity.setVisible(true);
            add(panelManageActivity,BorderLayout.EAST);

        }else if (seccion.equals(HandlingEvents.ADD_ACTIVITY)){

           // panelManageActivity.setVisible(true);
            //add(panelManageActivity,BorderLayout.CENTER);


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
            panelNavegationStdnt.setVisible(false);
            remove(panelNavegationStdnt);

        }
        else if(seccion.equals("all")){
            panelImage.setVisible(false);
            remove(panelImage);
            panelLogin.setVisible(false);
            remove(panelLogin);
            panelNavigationT.setVisible(false);

            remove(panelNavigationT);
            panelNavegationStdnt.setVisible(false);
            remove(panelNavegationStdnt);

        }else if (seccion.equals(HandlingEvents.BTN_GROUP)){
            activitiesTemplate.setVisible(false);
            remove(activitiesTemplate);
            panelManageActivity.setVisible(false);
            remove(panelManageActivity);
        }else if (seccion.equals(HandlingEvents.ADD_ACTIVITY))
        {
            activitiesTemplate.setVisible(false);
            remove(activitiesTemplate);
            groupsTemplate.setVisible(false);
            remove(groupsTemplate);
        }else if (seccion.equals(HandlingEvents.SAVE_ACTIVITY)){
            //panelManageActivity.setVisible(false);
            //remove(panelManageActivity);
        }else if (seccion.equals("est")){
            //panelManageActivity.setVisible(false);
            //remove(panelManageActivity);
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

        }else if (seccion.equals(HandlingEvents.SAVE_ACTIVITY))
        {
            String[] data={
                   // panelManageActivity.getTxtId().getText(),
                    //panelManageActivity.getTxtDescription().getText(),
                    //panelManageActivity.dateStart(),
                    //panelManageActivity.dateEnd(),
                    //""+panelManageActivity.getTypeActivity().getSelectedItem(),
                    "",
                    "0"

            };
            return  data;
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

    public PanelNavegationStdnt getPanelNavegationStdnt() {
        return panelNavegationStdnt;
    }

    public void setGroupsTemplate(GroupsTemplate groupsTemplate) {
        this.groupsTemplate = groupsTemplate;
    }

    public void setActivitiesTemplate(ActivitiesTemplate activitiesTemplate) {
        this.activitiesTemplate = activitiesTemplate;
    }
}
