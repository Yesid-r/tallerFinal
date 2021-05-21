package view.panels;

import model.Activity;
import model.Teacher;
import view.frames.MainWindow;
import view.service.ResourceService;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ActivityTemplate extends JPanel{
    private JLabel lblIconAct;
    private JButton btnDescAct;
    private JLabel lblDateEnd;
    private MainWindow mainWindow;
    private ResourceService rService;
    private Image iAct;


    public ActivityTemplate(MainWindow mainWindow, Activity activity) {
        rService = ResourceService.getService();
        this.mainWindow = mainWindow;
        this.setBorder(rService.getbRedondeado());
        this.setBackground(Color.WHITE);
        this.setVisible(true);
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(200,50));
        createActivityTeacher(activity);
    }
    public void createActivityTeacher(Activity activity){
        iAct = new ImageIcon("resource/images/actividad.png").getImage();
        ImageIcon iAux = new ImageIcon(iAct.getScaledInstance(40,40, Image.SCALE_SMOOTH));
        lblIconAct = new JLabel();
        lblIconAct.setIcon(iAux);
        this.add(lblIconAct);
        add(new JLabel("descripcion de la actividad: "));

        //btnDescAct = new JButton( teacher.getEnrolments().get(pos).getActivities().get(posAct).getDescription());
        btnDescAct = new JButton(activity.getDescription());
        this.add(btnDescAct);
        this.add(new JLabel("Fecha de entrega:  " ));
        //lblDateEnd = new JLabel(""+teacher.getEnrolments().get(pos).getActivities().get(posAct).getDateEnd());
        lblDateEnd = new JLabel(""+activity.getDateEnd());
        if (activity.isStatus()== false){
            lblDateEnd.setBackground(rService.getColorAlert());
        }
        this.add(lblDateEnd);
    }
}
