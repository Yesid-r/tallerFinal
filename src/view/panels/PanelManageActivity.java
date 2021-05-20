package view.panels;

import com.toedter.calendar.JDateChooser;
import model.TypeActivity;

import javax.swing.*;
import java.awt.*;

public class PanelManageActivity extends JPanel {
    private JTextField txtId;
    private JTextField txtDescription;
    private JDateChooser jDateStart;
    private JDateChooser jDateEnd;
    private JComboBox<String> typeActivity;
    private JTextField txtScore;
    private JTextField txtDelivery;
    private JButton btnSave;
    private JButton btnQualify;

    public PanelManageActivity() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(600,400));
        beginComponents();
        addComponents();

    }
    public  void  beginComponents(){
        txtId = new JTextField("id actividad:");
        txtDescription = new JTextField("Descripción");
        jDateStart = new JDateChooser("dd/MM/yyyy", "##/##/####", '-');
        jDateEnd = new JDateChooser("dd/MM/yyyy", "##/##/####", '-');
        typeActivity = new JComboBox<String>();
        typeActivity.setModel(new DefaultComboBoxModel(TypeActivity.values()));
        txtDelivery = new JTextField("Entrega");
        txtScore = new JTextField("calificación");
        btnSave = new JButton("GUARDAR");
        btnQualify = new JButton("CALIFICAR:");


    }

    private void addComponents() {
        JPanel pCenter = new JPanel(new GridLayout(8,1,5,5));
        pCenter.add(txtId);
        pCenter.add(txtDescription);
        pCenter.add(jDateStart);
        pCenter.add(new JLabel("Fecha de entrega:"));
        pCenter.add(jDateEnd);
        pCenter.add(typeActivity);
        pCenter.add(txtScore);
        pCenter.add(txtDelivery);
        this.add(pCenter, BorderLayout.CENTER);

        JPanel pSouth = new JPanel(new GridLayout(1,2));
        pSouth.add(btnSave);
        pSouth.add(btnQualify);
        this.add(pSouth,BorderLayout.SOUTH);
    }

}
