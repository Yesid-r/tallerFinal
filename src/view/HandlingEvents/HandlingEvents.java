package view.HandlingEvents;

import view.frames.MainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HandlingEvents implements ActionListener {
    public static final String LOGIN = "iniciar sesión";
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
        }
    }
}
