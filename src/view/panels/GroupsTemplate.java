package view.panels;

import model.Group;
import view.frames.MainWindow;
import view.service.ResourceService;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GroupsTemplate extends JPanel {

    private ResourceService rService;

    private GridBagLayout lGrid;
    private GridBagConstraints gbc;
    private JLabel lTitulo;
    private ArrayList<Group> groups;
    private MainWindow mainWindow;



    public GroupsTemplate(ArrayList<Group> groups, MainWindow mainWindow) {
        this.mainWindow = mainWindow;

        this.rService = ResourceService.getService();
        this.groups = groups;
        lGrid = new GridBagLayout();
        gbc = new GridBagConstraints();

        lTitulo = new JLabel("Mis Cursos");
        lTitulo.setFont(rService.getFontTProducto());
        lTitulo.setForeground(rService.getColorMain());
        lTitulo.setBorder(rService.getbInferiorAzul());

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets.top = 15;
        gbc.insets.bottom = 15;
        gbc.insets.left = 15;
        gbc.insets.right = 15;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        lGrid.setConstraints(lTitulo, gbc);
        this.add(lTitulo);

        this.crearProductos();

        this.setLayout(lGrid);
        this.setBackground(rService.getColorGrisClaro());
        this.setVisible(true);


    }

    private void crearProductos() {
        int numGroup = 0, fila = 1;
        Group group = groups.get(numGroup);
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridwidth = 1;
        gbc.insets.right = 0;
        while (group!= null){
        GroupTemplate groupTemplate = new GroupTemplate(group, mainWindow);
            gbc.gridx = numGroup % 3;
            gbc.gridy = fila;
            lGrid.setConstraints(groupTemplate, gbc);
            this.add(groupTemplate);
            if(numGroup % 3 == 2)
                fila ++;

            numGroup ++;
            try{
                group = groups.get(numGroup);
            } catch (Exception e) {
                break;
            }


        }


    }

}
