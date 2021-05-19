package view.panels;

import view.HandlingEvents.HandlingEvents;
import view.frames.MainWindow;
import view.service.ResourceService;

import javax.swing.*;
import java.awt.*;

public class PanelNavigationT extends JPanel {
    private Image iUser, iCourses, iStudents,iCloseSession;
    private JLabel lblIconUser;
    private JLabel descUser;
    private JButton btnCourses;
    private JButton btnStudents;
    private JButton btnCloseSession;
    private ResourceService rService;

    public PanelNavigationT() {
        setLayout(new BorderLayout());
        rService = ResourceService.getService();
        createIcons();
        beginComponents();
        addComponents();
        addCursorBtns();
        setBackground(rService.getColorMain());

    }
    public void createIcons(){
        iUser = new ImageIcon("resource/images/usuario_navegacion.png").getImage();
        iCourses = new ImageIcon("resource/images/courses.png").getImage();
        iStudents = new ImageIcon("resource/images/estudiantes.png").getImage();
        iCloseSession = new ImageIcon("resource/images/exit.png").getImage();

    }

    private void beginComponents() {
        lblIconUser = new JLabel();
        ImageIcon iAux = new ImageIcon(iUser.getScaledInstance(90,90, Image.SCALE_SMOOTH));
        lblIconUser.setIcon(iAux);
        descUser = new JLabel("Usuario");
        descUser.setForeground(Color.WHITE);
        btnCourses = new JButton("Mis cursos");
        iAux = new ImageIcon(iCourses.getScaledInstance(20,20, Image.SCALE_SMOOTH));
        btnCourses.setIcon(iAux);
        btnCourses.setHorizontalAlignment(SwingConstants.LEFT);
        btnCourses.setForeground(Color.WHITE);
        btnCourses.setContentAreaFilled(false);


        btnStudents = new JButton("Estudiantes: ");
        iAux = new ImageIcon(iStudents.getScaledInstance(20,20,Image.SCALE_SMOOTH));
        btnStudents.setIcon(iAux);
        btnStudents.setHorizontalAlignment(SwingConstants.LEFT);
        btnStudents.setForeground(Color.WHITE);
        btnStudents.setContentAreaFilled(false);

        btnCloseSession = new JButton("Cerrar sesión");
        iAux = new ImageIcon(iCloseSession.getScaledInstance(20,20,Image.SCALE_SMOOTH));
        btnCloseSession.setIcon(iAux);
        btnCloseSession.setHorizontalAlignment(SwingConstants.LEFT);
        btnCloseSession.setForeground(Color.WHITE);
        btnCloseSession.setContentAreaFilled(false);


    }

    private void addComponents() {
        JPanel pNorth  = new JPanel(new GridLayout());
        pNorth.setBackground(rService.getColorMain());
        pNorth.add(lblIconUser, BorderLayout.CENTER);
        pNorth.add(descUser, BorderLayout.SOUTH);
        add(pNorth, BorderLayout.NORTH);

        JPanel pCenter = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        pCenter.setBackground(rService.getColorMain());
        gbc.gridx = 0;
        gbc.gridy =0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pCenter.add(btnCourses, gbc);

        gbc.gridy = 1;
        pCenter.add(btnStudents, gbc);
        add(pCenter, BorderLayout.CENTER);

        add(btnCloseSession, BorderLayout.SOUTH);

    }
    private void addCursorBtns(){
        btnCloseSession.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCourses.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnStudents.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnCloseSession.setFocusable(false);
        btnCourses.setFocusable(false);
        btnStudents.setFocusable(false);

        /*btnStudents.setBorder(null);
        btnCourses.setBorder(null);
        btnCloseSession.setBorder(null);

         */
    }
    public void assignHandlingEvents(MainWindow mainWindow){
        btnCourses.setActionCommand(HandlingEvents.CURSOS);
        btnCourses.addActionListener(new HandlingEvents(mainWindow));

        btnStudents.setActionCommand(HandlingEvents.STUDENTS);
        btnStudents.addActionListener(new HandlingEvents(mainWindow));

        btnCloseSession.setActionCommand(HandlingEvents.CLOSE_SESSION);
        btnCloseSession.addActionListener(new HandlingEvents(mainWindow));
    }

    public JLabel getDescUser() {
        return descUser;
    }
}
