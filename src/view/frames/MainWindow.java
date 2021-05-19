package view.frames;

import control.Control;
import model.Group;
import model.Subject;
import model.Teacher;
import view.panels.*;
import view.service.ResourceService;
import view.service.TypeUsers;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainWindow extends JFrame {
    private PanelLogin panelLogin;
    private JLabel lblDescWindow;
    private ResourceService rService;
    private PanelImage panelImage;
    private Control control;
    private PanelNavigationT panelNavigationT;

    private GroupsTemplate groupsTemplate;
    private JScrollPane scrollPane;


    public MainWindow(Control control) {
    super("Gestion de asiganaturas universidad NN");
    setLayout(new BorderLayout());
    setSize(1000,500);
    rService = ResourceService.getService();
    this.control = control;
    beginComponents();
    addComponents();
    setVisible(true);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    assignActionListener();

    }
    public void assignActionListener(){
        panelLogin.assignHandlingEvents(this);
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

    }

    public GroupsTemplate getGroupsTemplate() {
        return groupsTemplate;
    }

    private void addComponents() {
     add(panelNavigationT,BorderLayout.WEST);
     groupsTemplate.setGroups(control.getManagement().getGroups());
     groupsTemplate.crearProductos();
     System.out.println(control.getManagement().getGroups().size());
     scrollPane = new JScrollPane(groupsTemplate);
     add(scrollPane,BorderLayout.CENTER);

    }

    public void login() {
        String typeUser =""+panelLogin.getTypeUser().getSelectedItem();
        String user =panelLogin.getTxtUser().getText();
        String[] data ={
                user,
                panelLogin.getPasswordField().getText(),
                typeUser

        };
        if (control.verifyUser(data)){
            setSize(1100,870);
            setLocationRelativeTo(null);
            panelLogin.setVisible(false);
            panelImage.setVisible(false);
            lblDescWindow.setVisible(false);
            remove(lblDescWindow);
            remove(panelLogin);
            remove(panelImage);

            if (typeUser.equals("Docente")){
               setLayout(new BorderLayout());
               repaint();

            add(panelNavigationT, BorderLayout.EAST);
            //add(jScrollPane, BorderLayout.CENTER);

            }
        }else {
            JOptionPane.showMessageDialog(null,"error");
        }


    }
}
