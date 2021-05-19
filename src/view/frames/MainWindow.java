package view.frames;

import control.Control;
import model.Group;
import model.Subject;
import model.Teacher;
import view.panels.*;
import view.service.ResourceService;

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
    private GroupTemplate groupTemplate;
    private GroupsTemplate groupsTemplate;


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
    control = new Control();
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
        Teacher teacher = new Teacher("123","juan","perez","user","password");
        Subject subject = new Subject("111","Programación II",(short)4);
        //groupTemplate = new GroupTemplate(new Group("12",teacher,subject));
        ArrayList<Group> groups = new ArrayList<>();
        groups.add(new Group("12",teacher,subject));
        groups.add(new Group("111",teacher,subject));
        groups.add(new Group("1312312",teacher,subject));
        groups.add(new Group("grupo 1", teacher,subject));


        groupsTemplate = new GroupsTemplate(groups,this);
    }

    public GroupsTemplate getGroupsTemplate() {
        return groupsTemplate;
    }

    private void addComponents() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(lblDescWindow, BorderLayout.NORTH);
        panel.setBackground(rService.getColorMain());
        panel.add(panelImage, BorderLayout.CENTER);
        add(panel,BorderLayout.CENTER);
        add(panelLogin, BorderLayout.EAST);
     //  // add(panelImage, BorderLayout.CENTER);
        //add(panelNavigationT, BorderLayout.WEST);
        //add(groupTemplate, BorderLayout.CENTER);
        //JScrollPane scrollPane = new JScrollPane(groupsTemplate);
        //add(scrollPane, BorderLayout.CENTER);

    }

    public void login() {
        String[] data ={
                panelLogin.getTxtUser().getText(),
                panelLogin.getPasswordField().getText(),
                ""+panelLogin.getTypeUser().getSelectedItem()
        };
        if (control.verifyUser(data)){
            setSize(1200,950);
            setLocationRelativeTo(null);
            panelLogin.setVisible(false);
            panelImage.setVisible(false);
        }else {
            JOptionPane.showMessageDialog(null,"error");
        }


    }
}
