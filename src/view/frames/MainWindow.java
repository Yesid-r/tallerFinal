package view.frames;

import control.Control;
import view.panels.PanelImage;
import view.panels.PanelLogin;
import view.panels.PanelNavigationT;
import view.service.ResourceService;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private PanelLogin panelLogin;
    private JLabel lblDescWindow;
    private ResourceService rService;
    private PanelImage panelImage;
    private Control control;
    private PanelNavigationT panelNavigationT;


    public MainWindow() {
    super("Gestion de asiganaturas universidad NN");
    setLayout(new BorderLayout());
    setSize(1000, 500);
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
    }

    private void addComponents() {
        //JPanel panel = new JPanel(new BorderLayout());
        //panel.add(lblDescWindow, BorderLayout.NORTH);
        //panel.setBackground(rService.getColorMain());
        //panel.add(panelImage, BorderLayout.CENTER);
        //add(panel,BorderLayout.CENTER);
        //add(panelLogin, BorderLayout.EAST);
     //  // add(panelImage, BorderLayout.CENTER);
        add(panelNavigationT, BorderLayout.WEST);

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
