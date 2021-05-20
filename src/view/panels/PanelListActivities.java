package view.panels;

import view.HandlingEvents.HandlingEvents;
import view.frames.MainWindow;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PanelListActivities extends JPanel {
    private JButton btnSaveNotes;
    private JScrollPane jScrollPane;
    private DefaultTableModel tableModel;
    private JTable jTableActivities;

    public PanelListActivities() {
        setLayout(new BorderLayout());
        beginComponents();
        addComponents();
    }

    private void beginComponents() {
        String[] cabecera = {"codigoEstudiante","descripcion", "Entrega","fechaEntrega","nota"};
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(cabecera);
        jTableActivities = new JTable(tableModel);
        jTableActivities.setRowHeight(40);
        jScrollPane = new JScrollPane(jTableActivities);
        btnSaveNotes = new JButton("GUARDAR CALIFICACIONES");
    }

    private void addComponents() {
        add(jScrollPane, BorderLayout.CENTER);
        JPanel pSouth = new JPanel(new FlowLayout());
        pSouth.add(btnSaveNotes);
        add(pSouth, BorderLayout.SOUTH);
    }
    public void assignHandlingEvents(MainWindow mainWindow){
        btnSaveNotes.setActionCommand(HandlingEvents.SAVE_NOTES);
        btnSaveNotes.addActionListener(new HandlingEvents(mainWindow));
    }
}
