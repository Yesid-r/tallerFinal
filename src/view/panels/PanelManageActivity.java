package view.panels;

import com.toedter.calendar.JDateChooser;
import model.TypeActivity;
import view.HandlingEvents.HandlingEvents;
import view.frames.MainWindow;
import view.service.ResourceService;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    private Image iAct;
    private JLabel lblIconAct;

    public PanelManageActivity() {
        setLayout(new BorderLayout());
        beginComponents();
        addComponents();

    }
    public  void  beginComponents(){
        txtId = new JTextField("id actividad:");
        txtDescription = new JTextField("Descripción");
        jDateStart = new JDateChooser("dd/MM/yyyy", "##/##/####", '-');
        jDateStart.setDate(new Date());
        jDateEnd = new JDateChooser("dd/MM/yyyy", "##/##/####", '-');
        jDateEnd.setDate(new Date());
        typeActivity = new JComboBox<String>();
        typeActivity.setModel(new DefaultComboBoxModel(TypeActivity.values()));
        txtDelivery = new JTextField("Entrega");
        txtScore = new JTextField("calificación");
        btnSave = new JButton("GUARDAR");
        btnQualify = new JButton("CALIFICAR:");


    }

    private void addComponents() {
        iAct =new ImageIcon("resource/images/fondocurso.png").getImage();
        ImageIcon iAux = new ImageIcon(iAct.getScaledInstance(400,148, Image.SCALE_SMOOTH));
        lblIconAct = new JLabel();
        lblIconAct.setIcon(iAux);
        JLabel lblDesc =  new JLabel("Registro de actividad");
        lblDesc.setFont(ResourceService.getService().getFontTProducto());
        lblDesc.setBorder(ResourceService.getService().getbInferiorAzul());

        add(lblDesc,BorderLayout.NORTH);
        JPanel pCenter = new JPanel(new GridLayout(10,1,10,10));
        //pCenter.add(lblIconAct);
        pCenter.add(txtId);
        pCenter.add(txtDescription);
        pCenter.add(jDateStart);
        pCenter.add(new JLabel("fecha de entrega:"));
        pCenter.add(jDateEnd);
        pCenter.add(typeActivity);
        pCenter.add(txtDelivery);
        pCenter.add(txtScore);
        JPanel pOptions= new JPanel(new GridLayout(1,2,5,5));
        pOptions.add(btnSave);
        pOptions.add(btnQualify);
        pOptions.setVisible(true);
        pCenter.add(pOptions);

        add(pCenter, BorderLayout.CENTER);



        //add(lblIconAct,BorderLayout.SOUTH);
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(50,50));
        add(panel,BorderLayout.SOUTH);




    }
    public void assignHandlingEvents(MainWindow mainWindow){
        btnSave.setActionCommand(HandlingEvents.SAVE_ACTIVITY);
        btnSave.addActionListener(new HandlingEvents(mainWindow));

        btnQualify.setActionCommand(HandlingEvents.QUALIFY_ACTIVITY);
        btnQualify.addActionListener(new HandlingEvents(mainWindow));

    }

    public JTextField getTxtId() {
        return txtId;
    }

    public JTextField getTxtDescription() {
        return txtDescription;
    }

    public JDateChooser getjDateStart() {
        return jDateStart;
    }

    public JDateChooser getjDateEnd() {
        return jDateEnd;
    }

    public JComboBox<String> getTypeActivity() {
        return typeActivity;
    }

    public JTextField getTxtScore() {
        return txtScore;
    }

    public JTextField getTxtDelivery() {
        return txtDelivery;
    }
    public String dateStart(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = "";
        try {
            Date date = simpleDateFormat.parse(""+ DateFormat.getDateInstance().format(jDateStart.getDate()));
            fecha = simpleDateFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return fecha;
    }
    public String dateEnd(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = "";
        try {
            Date date = simpleDateFormat.parse(""+ DateFormat.getDateInstance().format(jDateEnd.getDate()));
            fecha = simpleDateFormat.format(date);
        } catch (ParseException e) {

        }
        return fecha;
    }
}
