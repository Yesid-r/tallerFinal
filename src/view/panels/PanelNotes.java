package view.panels;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PanelNotes extends JPanel {
    private JScrollPane jScrollPane;
    private DefaultTableModel tableModel;
    private JTable jTableNotes;

    public PanelNotes() {
        setLayout(new BorderLayout());
        beginComponents();
        addComponents();

    }

    private void beginComponents() {
        String[] header = {"Grupo","Asignatura","Nota Final"};
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(header);

        jTableNotes = new JTable(tableModel);
        jTableNotes.setRowHeight(40);
        jScrollPane= new JScrollPane(jTableNotes);
    }
    public void cleanTable(){
        for (int i = 0; i < tableModel.getRowCount(); i++) {
        tableModel.removeRow(i);
        i--;

        }
    }
    public void showTable(String[][] data){
        for (int i = 0; i < data.length; i++) {
            tableModel.addRow(data[i]);

        }

    }

    private void addComponents() {
        add(jScrollPane);
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public JScrollPane getjScrollPane() {
        return jScrollPane;
    }

    public JTable getjTableNotes() {
        return jTableNotes;
    }
}
