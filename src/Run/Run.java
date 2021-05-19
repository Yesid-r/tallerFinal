package Run;

import control.Control;
import view.HandlingEvents.HandlingEvents;
import view.frames.MainWindow;

public class Run {
    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
        HandlingEvents handlingEvents = new HandlingEvents(mainWindow);
        mainWindow.setVisible(true);
    }
}
