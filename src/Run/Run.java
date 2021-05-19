package Run;

import control.Control;
import view.frames.MainWindow;

public class Run {
    public static void main(String[] args) {
        Control control = new Control();

        MainWindow mainWindow = new MainWindow(control);
        mainWindow.setVisible(true);
    }
}
