package view.panels;

import javax.swing.*;
import java.awt.*;

public class PanelImage extends JPanel {

    private Image fondo;

    public PanelImage() {
        preInit();
        initComponents();
    }

    private void preInit() {
        fondo = new ImageIcon("resource/images/imagenLogin.png").getImage();
    }

    private void initComponents() {
    }
    public void paint(Graphics g){
        g.drawImage(fondo,0,0,getWidth(),getHeight(),this);


    }
}
