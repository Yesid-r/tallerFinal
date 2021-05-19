package view.panels;


import model.Group;
import view.HandlingEvents.HandlingEvents;
import view.frames.MainWindow;
import view.service.ResourceService;

import javax.swing.*;
import java.awt.*;

public class GroupTemplate extends JPanel {
    private GroupComponent groupComponent;
    private ResourceService rService;
    private Group group;

    private GridBagLayout lGrid;
    private GridBagConstraints gbc;

    private JButton btnGroup;
    private JLabel lblImage, lblGroup;
    private Image iCourses;
    private JLabel lblParrafo, lblTeacher;
    private MainWindow mainWindow;



    public GroupTemplate(Group group, MainWindow mainWindow) {
        this.mainWindow = mainWindow;
       // this.groupComponent = groupComponent;
       // this.groupComponent.getClass();
        this.rService = ResourceService.getService();
        this.group = group;

        lGrid = new GridBagLayout();
        gbc = new GridBagConstraints();
        this.setLayout(lGrid);

        this.createComponents();

        this.setPreferredSize(new Dimension(262, 330));
        this.setBorder(rService.getbRedondeado());
        this.setBackground(Color.WHITE);
        this.setVisible(true);
        btnGroup.setActionCommand(HandlingEvents.BTN_GROUP);
        btnGroup.addActionListener(new HandlingEvents(mainWindow));


    }
    public void createComponents(){
        iCourses = new ImageIcon("resource/images/programación.jpg").getImage();
        btnGroup = new JButton(group.getId());
        btnGroup.setCursor(rService.getcMano());
        lblGroup = new JLabel("Grupo: ");
        add(lblGroup);
        modificarGbc(0, 0, 3, 1, 0, 10, 10, 0, 0, 0, 0, 0, 0, 0);
        this.add(btnGroup, gbc);

        ImageIcon iAux = new ImageIcon(iCourses.getScaledInstance(250,148, Image.SCALE_SMOOTH));
        lblImage = new JLabel();
        lblImage.setIcon(iAux);
        lblImage.setBorder(rService.getbRedondeado());
        modificarGbc(0, 1, 3, 1, 2, 10, 10, 3, 10, 3, 0, 0, 0, 0);
        this.add(lblImage, gbc);

        lblParrafo = new JLabel("Asignatura: "+ group.getSubject().getDescription());
        modificarGbc(0, 2, 3, 1, 2, 10, 10, 15, 10, 15, 0, 0, 0, 0);
        this.add(lblParrafo, gbc);

        lblTeacher = new JLabel("Docente: "+group.getTeacher().getFirstName()+ " "+ group.getTeacher().getLastName());
        modificarGbc(0, 3, 1, 1, 0, 10, 10, 5, 15, 5, 10, 10, 0, 0);
        this.add(lblTeacher, gbc);










    }
    public void modificarGbc(
            int posColumna, int posFila, int numColumnas, int numFilas, int tipoEstirado, int posicionInterna,
            int marginArriba, int marginDerecha, int marginAbajo, int marginIzquierda, int paddingX, int paddingY,
            int estiramientoColumna, int estiramientoFila
    ){
        gbc.gridx = posColumna;
        gbc.gridy = posFila;
        gbc.gridwidth = numColumnas;
        gbc.gridheight = numFilas;
        gbc.fill = tipoEstirado;
        gbc.anchor = posicionInterna;
        gbc.insets.top = marginArriba;
        gbc.insets.right = marginDerecha;
        gbc.insets.bottom = marginAbajo;
        gbc.insets.left = marginIzquierda;
        gbc.ipadx = paddingX;
        gbc.ipady = paddingY;
        gbc.weightx = estiramientoColumna;
        gbc.weighty = estiramientoFila;
    }

}
