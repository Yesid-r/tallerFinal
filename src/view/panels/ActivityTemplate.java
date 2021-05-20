package view.panels;

import model.Teacher;
import view.frames.MainWindow;
import view.service.ResourceService;

import javax.swing.*;
import java.awt.*;

public class ActivityTemplate extends JPanel{
    private JLabel lblIconAct;
    private JButton btnDescAct;
    private JLabel lblDateEnd;
    private MainWindow mainWindow;
    private ResourceService rService;
    private Image iAct;

    public ActivityTemplate(MainWindow mainWindow) {
        rService = ResourceService.getService();
        this.mainWindow = mainWindow;
        this.setBorder(rService.getbRedondeado());
        this.setBackground(Color.WHITE);
        this.setVisible(true);
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(200,50));
    }
    public void createActivityTeacher(Teacher teacher, int pos, int posAct){
        iAct = new ImageIcon("resource/images/actividad.png").getImage();
        ImageIcon iAux = new ImageIcon(iAct.getScaledInstance(40,40, Image.SCALE_SMOOTH));
        lblIconAct = new JLabel();
        lblIconAct.setIcon(iAux);
        this.add(lblIconAct);
        add(new JLabel("descripcion de la actividad: "));
        btnDescAct = new JButton( teacher.getEnrolments().get(pos).getActivities().get(posAct).getDescription());
        this.add(btnDescAct);
        this.add(new JLabel("Fecha de entrega:"));
        lblDateEnd = new JLabel(""+teacher.getEnrolments().get(pos).getActivities().get(posAct).getDateEnd());
        this.add(lblDateEnd);
    }
}
