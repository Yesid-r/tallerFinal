package view.frames;

import view.HandlingEvents.HandlingEvents;
import view.panels.*;
import view.service.ResourceService;
import view.service.TypeUsers;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private PanelLogin panelLogin;
    private JLabel lblDescWindow;
    private ResourceService rService;
    private PanelImage panelImage;
    private PanelNavigationT panelNavigationT;

    private GroupsTemplate groupsTemplate;
    private JScrollPane scrollPane;
    private JPanel jPanel;


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
            panelNavigationT.setVisible(true);
            add(panelNavigationT,BorderLayout.WEST);
            scrollPane = new JScrollPane(groupsTemplate);
            scrollPane.setVisible(true);
            add(scrollPane,BorderLayout.CENTER);

        }else if(seccion.equals(HandlingEvents.CLOSE_SESSION)){
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

    public PanelNavigationT getPanelNavigationT() {
        return panelNavigationT;
    }

    public void setGroupsTemplate(GroupsTemplate groupsTemplate) {
        this.groupsTemplate = groupsTemplate;
    }
}
