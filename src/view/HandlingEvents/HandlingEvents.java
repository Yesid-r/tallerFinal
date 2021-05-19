package view.HandlingEvents;

import view.frames.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HandlingEvents implements ActionListener {
    public static final String LOGIN = "iniciar sesión";
    public static final String BTN_GROUP = "boton grupo";
    private  MainWindow mainWindow;
    public HandlingEvents(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()){
        case LOGIN:mainWindow.login();
            System.out.println("login");
            break;
        case BTN_GROUP:
            String id = e.getSource().toString();
            JButton btn = (JButton) e.getSource();
            System.out.println("texto del btn: "+btn.getText());
           // System.out.println("btn"+ id);
            break;
        }
    }
}
