package view.panels;

import view.HandlingEvents.HandlingEvents;
import view.frames.MainWindow;
import view.service.ResourceService;

import javax.swing.*;
import java.awt.*;

public class PanelNavegationStdnt extends JPanel {
    private Image iUser, iCourses, iNotes,iCloseSession;
    private JLabel lblIconUser;
    private JLabel descUser;
    private JButton btnCourses;
    private JButton btnNotes;
    private JButton btnCloseSession;
    private ResourceService rService;

    public PanelNavegationStdnt() {
        setLayout(new BorderLayout());
        rService = ResourceService.getService();
        createIcons();
        beginComponents();
        addComponents();
        addObjDecorates();
        setBackground(rService.getColorMain());
    }

    private void createIcons() {
        iUser = new ImageIcon("resource/images/usuario_navegacion.png").getImage();
        iCourses = new ImageIcon("resource/images/courses.png").getImage();
        iNotes =  new ImageIcon("resource/images/score.png").getImage();
        iCloseSession = new ImageIcon("resource/images/exit.png").getImage();


    }

    private void beginComponents() {
        lblIconUser = new JLabel();
        ImageIcon iAux = new ImageIcon(iUser.getScaledInstance(90,90, Image.SCALE_SMOOTH));
        lblIconUser.setIcon(iAux);

        descUser = new JLabel("Usuario");
        descUser.setForeground(Color.WHITE);

        btnCourses = new JButton("Mis cursos");
        iAux = new ImageIcon(iCourses.getScaledInstance(30,30, Image.SCALE_SMOOTH));
        btnCourses.setIcon(iAux);
        btnCourses.setHorizontalAlignment(SwingConstants.LEFT);
        btnCourses.setForeground(Color.WHITE);
        btnCourses.setContentAreaFilled(false);


        btnNotes = new JButton("Mis notas");
        iAux = new ImageIcon(iNotes.getScaledInstance(30,30,Image.SCALE_SMOOTH));
        btnNotes.setIcon(iAux);
        btnNotes.setHorizontalAlignment(SwingConstants.LEFT);
        btnNotes.setForeground(Color.WHITE);
        btnNotes.setContentAreaFilled(false);

        btnCloseSession = new JButton("Cerrar sesión");
        iAux = new ImageIcon(iCloseSession.getScaledInstance(30,30,Image.SCALE_SMOOTH));
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
        pCenter.add(btnNotes, gbc);
        add(pCenter, BorderLayout.CENTER);

        add(btnCloseSession, BorderLayout.SOUTH);

    }

    private void addObjDecorates() {
        btnCloseSession.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCourses.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnNotes.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnCloseSession.setFocusable(false);
        btnCourses.setFocusable(false);
        btnNotes.setFocusable(false);

    }
    public void assignHandlingEvents(MainWindow mainWindow){
        btnCourses.setActionCommand(HandlingEvents.CURSOS_STUDENT);
        btnCourses.addActionListener(new HandlingEvents(mainWindow));

        btnNotes.setActionCommand(HandlingEvents.NOTES);
        btnNotes.addActionListener(new HandlingEvents(mainWindow));

        btnCloseSession.setActionCommand(HandlingEvents.CLOSE_SESSION);
        btnCloseSession.addActionListener(new HandlingEvents(mainWindow));


    }

    public JLabel getDescUser() {
        return descUser;
    }
}
