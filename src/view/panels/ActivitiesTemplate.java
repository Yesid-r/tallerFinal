package view.panels;

import model.Activity;
import view.HandlingEvents.HandlingEvents;
import view.frames.MainWindow;
import view.service.ResourceService;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ActivitiesTemplate extends JPanel {
    private ResourceService rService;

    private JLabel lblTitle;
    private JButton btnAddActivity;
    private MainWindow mainWindow;
    private ArrayList<Activity> activities;

    public ActivitiesTemplate(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        this.rService = ResourceService.getService();
        lblTitle = new JLabel("Actividades:");
        lblTitle.setFont(rService.getFontTProducto());
        lblTitle.setForeground(rService.getColorMain());

        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.add(Box.createRigidArea(new Dimension(0,60)));
        this.setVisible(true);
        JPanel pNorth = new JPanel(new FlowLayout());
        pNorth.add(lblTitle);
        btnAddActivity = new JButton("AÑADIR ACTIVIDAD");
        //pNorth.add(btnAddActivity);
        //btnAddActivity.setActionCommand(HandlingEvents.ADD_ACTIVITY);
        //btnAddActivity.addActionListener(new HandlingEvents(mainWindow));

        this.add(pNorth);

    }
    public void createActivities(){
        for (int i = 0; i < activities.size(); i++) {
            ActivityTemplate activityTemplate = new ActivityTemplate(mainWindow, activities.get(i));

            this.add(activityTemplate);

        }

    }
    public void addActionListener(){


    }

    public ArrayList<Activity> getActivities() {
        return activities;
    }

    public void setActivities(ArrayList<Activity> activities) {
        this.activities = activities;
    }
}
