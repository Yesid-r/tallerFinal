package view.service;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ResourceService {

    private Color colorMain, colorAlert, colorGrisClaro;
    private Font fontTPrincipal, fontTitulo, fontSubtitulo;
    private Font fontMediana, fontLigera, fontTProducto;
    private Border bInferiorAzul, bInferiorRed;
    private Border bCircular, bRedondeado, bDifuminado, bGris;
    private static ResourceService servicio;
    private GraficosAvanzadosService sGraficosAvanzados;

    private ResourceService(){

    sGraficosAvanzados = new GraficosAvanzadosService().getService();
    this.createColors();
    this.crearFuentes();
    this.crearBordes();
        
    }

    public Font getFontTProducto() {
        return fontTProducto;
    }

    private void createColors() {
        this.colorMain = new Color(89, 129, 178);
        this.colorAlert = new Color(221, 79, 67);
        colorGrisClaro = new Color(247, 247, 247);
    }

    public static ResourceService getService() {
        if (servicio == null) servicio = new ResourceService();
        return servicio;
    }
    private void crearFuentes() {
        fontTPrincipal = new Font("Rockwell Extra Bold", Font.PLAIN, 20);
        fontTProducto = new Font("LuzSans-Book", Font.BOLD, 28);
        fontTitulo = new Font("Calibri (Cuerpo)", Font.BOLD, 17);
        fontSubtitulo = new Font("Comic Sans MS", Font.PLAIN, 13);
        fontMediana = new Font("LuzSans-Book", Font.BOLD, 20);
        fontLigera = new Font("LuzSans-Book", Font.PLAIN, 12);
    }
    private void crearBordes() {
        bInferiorAzul = BorderFactory.createMatteBorder(0, 0, 2, 0, colorMain);
        bInferiorRed = BorderFactory.createMatteBorder(0,0,2,0,Color.RED);
       // bLateralAzul = BorderFactory.createMatteBorder(2, 0, 2, 2, colorPrincipal);
       // bInferiorGris = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY);
       bGris = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true);
        //bAzul = BorderFactory.createLineBorder(colorPrincipal, 2, true);
        //bCircular = sGraficosAvanzados.DibujarBordeCircular(null, false, false, null);
        bRedondeado = sGraficosAvanzados.DibujarBordeRedondeado(null, 45, false, false, null);
        bDifuminado = sGraficosAvanzados.devolverBordeDifuminado(new Color(215, 215, 215), 8);
    }

    public Color getColorMain() {
        return colorMain;
    }

    public Color getColorAlert() {
        return colorAlert;
    }

    public Font getFontTPrincipal() {
        return fontTPrincipal;
    }


    public Font getFontTitulo() {
        return fontTitulo;
    }

    public Font getFontSubtitulo() {
        return fontSubtitulo;
    }

    public Font getFontMediana() {
        return fontMediana;
    }

    public Font getFontLigera() {
        return fontLigera;
    }

    public Border getbInferiorAzul() {
        return bInferiorAzul;
    }

    public Border getbInferiorRed() {
        return bInferiorRed;
    }

    public Border getbCircular() {
        return bCircular;
    }

    public Border getbRedondeado() {
        return bRedondeado;
    }

    public Border getbDifuminado() {
        return bDifuminado;
    }



    public GraficosAvanzadosService getsGraficosAvanzados() {
        return sGraficosAvanzados;
    }

    public Color getColorGrisClaro() {
        return colorGrisClaro;
    }
}
