package view.panels;

import view.HandlingEvents.HandlingEvents;
import view.frames.MainWindow;
import view.service.GraficosAvanzadosService;
import view.service.ResourceService;
import view.service.TypeUsers;

import javax.swing.*;
import java.awt.*;

public class PanelLogin extends JPanel {
    private JLabel lblDescrp;
    private JTextField txtUser;
    private JPasswordField passwordField;
    private JComboBox<String> typeUser;
    private JButton btnLogin;
    private JLabel lblInicioSesion;
    private ResourceService rService;

    public PanelLogin() {
        setSize(120,200);
        setLayout(new BorderLayout());
        rService = ResourceService.getService();
        beginComponents();
        addComponents();

    }

    private void beginComponents() {
        lblDescrp = new JLabel();
        lblDescrp.setSize(120,120);
        txtUser = new JTextField("Usuario");
        txtUser.setHorizontalAlignment(SwingConstants.CENTER);

        passwordField = new JPasswordField("contraseña");
        passwordField.setHorizontalAlignment(SwingConstants.CENTER);
        typeUser = new JComboBox<String>();
        typeUser.setModel(new DefaultComboBoxModel(TypeUsers.values()));
        typeUser.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnLogin = new JButton("LOGIN");
        btnLogin.setBorder(rService.getbRedondeado());
        btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnLogin.setBackground(rService.getColorMain());
        btnLogin.setForeground(Color.WHITE);
        lblInicioSesion = new JLabel("Inicio de sesión");
        lblInicioSesion.setFont(rService.getFontMediana());
        lblInicioSesion.setHorizontalAlignment(SwingConstants.CENTER);


    }

    private void addComponents() {
        JPanel pNorth = new JPanel();
        pNorth.setLayout(new FlowLayout());
        Image imageIcon = new ImageIcon("resource/images/login.png").getImage();
        ImageIcon imageIcon1 = new ImageIcon(imageIcon.getScaledInstance(60,60, Image.SCALE_SMOOTH));
        lblDescrp.setIcon(imageIcon1);

        pNorth.add(lblInicioSesion);
        add(pNorth, BorderLayout.NORTH);
        JPanel pCenter = new JPanel();
        pCenter.setLayout(new GridLayout(6,1,15,15));
        //pCenter.setLayout(new BoxLayout(pCenter, BoxLayout.Y_AXIS));
        lblDescrp.setHorizontalAlignment(SwingConstants.CENTER);
        pCenter.add(lblDescrp);
        pCenter.add(txtUser);
        pCenter.add(passwordField);
        pCenter.add(typeUser);
        pCenter.add(btnLogin);
        pCenter.add(new JLabel("¿Olvido su contraseña?"));
        add(pCenter, BorderLayout.CENTER);
        JPanel pSouth = new JPanel();
        pSouth.setLayout(new GridLayout(1,2));
        JButton btnAux1 = new JButton("GUARDAR regis ");
        JButton btnAux2 = new JButton("GUARDAR  ");
        btnAux1.setVisible(false);
        btnAux2.setVisible(false);
        pSouth.add(btnAux1);
        pSouth.add(btnAux2);
        add(pSouth, BorderLayout.SOUTH);

    }
    public void assignHandlingEvents(MainWindow mainWindow){
        btnLogin.addActionListener(new HandlingEvents(mainWindow));
        btnLogin.setActionCommand(HandlingEvents.LOGIN);


    }

    public JTextField getTxtUser() {
        return txtUser;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JComboBox<String> getTypeUser() {
        return typeUser;
    }
}
