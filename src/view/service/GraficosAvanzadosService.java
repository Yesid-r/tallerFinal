package view.service;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RectangularShape;
import java.awt.geom.RoundRectangle2D;

public class GraficosAvanzadosService {

    public static GraficosAvanzadosService service;
    protected GraficosAvanzadosService(){

    }
    public DefaultTableCellRenderer devolverTablaPersonalizada(
            Color colorPrincipal, Color colorSecundario, Color colorSeleccion, Color colorFuente, Font fuente
    ) {
        return new DefaultTableCellRenderer() {
            private static final long serialVersionUID = -8946942932242371111L;

            @Override
            public Component getTableCellRendererComponent(
                    JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column
            ) {
                JLabel celda = (JLabel) super.getTableCellRendererComponent(
                        table, value, isSelected, hasFocus, row, column
                );
                celda.setOpaque(true);
                celda.setFont(fuente);
                celda.setForeground(colorFuente);
                celda.setHorizontalAlignment(SwingConstants.CENTER);
                if (row % 2 != 0) celda.setBackground(colorPrincipal);
                else celda.setBackground(colorSecundario);
                if (isSelected) {
                    celda.setBackground(colorSeleccion);
                    celda.setForeground(Color.WHITE);
                }
                return celda;
            }
        };
    }
    public Border devolverBordeDifuminado(Color colorBase, int grosor) {
        Border bordeFinal = null;
        Border bordeInicial = BorderFactory.createLineBorder(colorBase, 1, true);
        Color siguienteColor = new Color(
                colorBase.getRed() + 5, colorBase.getGreen() + 5, colorBase.getBlue() + 5
        );
        int contador = 0;
        while (
                siguienteColor.getRed() < 251 &&
                        siguienteColor.getGreen() < 251 &&
                        siguienteColor.getBlue() < 251 &&
                        contador < grosor
        ) {
            Border bordeExterno = BorderFactory.createLineBorder(
                    siguienteColor, 1, true
            );
            if (contador == 0)
                bordeFinal = BorderFactory.createCompoundBorder(bordeExterno, bordeInicial);
            else
                bordeFinal = BorderFactory.createCompoundBorder(bordeExterno, bordeFinal);
            siguienteColor = new Color(
                    siguienteColor.getRed() + 5, siguienteColor.getGreen() + 5, siguienteColor.getBlue() + 5
            );
            contador++;
        }
        return bordeFinal;
    }
    public AbstractBorder DibujarBordeCircular(
            Color colorBorde, boolean esLineal, boolean esSolido, Image imagenFondo
    ) {
        AbstractBorder bordeCircular = new AbstractBorder() {
            private static final long serialVersionUID = 2009875951859777681L;

            @Override
            public void paintBorder(
                    Component c, Graphics g, int x, int y, int ancho, int alto
            ) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(
                        RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON
                );
                Area area;
                Component padreContenedor = c.getParent();
                Ellipse2D circulo = new Ellipse2D.Double();
                circulo.setFrameFromCenter(
                        new Point(x + ancho / 2, y + alto / 2),
                        new Point(ancho, alto)
                );
                if (esLineal) {
                    dibujarFondo(c, padreContenedor, imagenFondo, g2, ancho, alto);
                    if(esSolido) {
                        g2.setColor(c.getBackground());
                        g2.fill(circulo);
                    }
                    area = dibujarBorde(c, g2, colorBorde, x, y, ancho, alto, circulo);
                } else {
                    area = dibujarBorde(c, g2, colorBorde, x, y, ancho, alto, circulo);
                    dibujarFondo(c, padreContenedor, imagenFondo, g2, ancho, alto);
                }
                g2.setClip(null);
                g2.draw(area);
            }
        };
        return bordeCircular;
    }
    private void dibujarFondo(
            Component c, Component padreContenedor, Image imagen, Graphics2D g2, int ancho, int alto
    ) {
        if (imagen != null)
            g2.drawImage(
                    imagen,
                    0, 0,
                    imagen.getWidth(null), imagen.getHeight(null),
                    c.getX(), c.getY(),
                    imagen.getWidth(null) + c.getX(),
                    imagen.getHeight(null) + c.getY(),
                    c
            );
        else {
            g2.setColor(padreContenedor.getBackground());
            g2.fillRect(0, 0, ancho, alto);
        }
    }
    private Area dibujarBorde(
            Component c, Graphics2D g2, Color color, int x, int y, int ancho, int alto, RectangularShape figura
    ) {
        if (color == null) g2.setPaint(c.getBackground());
        else g2.setPaint(color);
        Area area = new Area(figura);
        Rectangle rectangulo = new Rectangle(0, 0, ancho, alto);
        Area regionBorde = new Area(rectangulo);
        regionBorde.subtract(area);
        g2.setClip(regionBorde);
        return area;
    }
    public Border DibujarBordeRedondeado(
            Color colorBorde, int radio, boolean esLineal, boolean esSolido, Image imagenFondo
    ) {
        Border bordeRedondeado = new Border() {

            @Override
            public void paintBorder(
                    Component c, Graphics g, int x, int y, int ancho, int alto
            ) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(
                        RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON
                );
                Area area;
                Component padreContenedor = c.getParent();
                RoundRectangle2D rectanguloBordeado = new RoundRectangle2D.Double();
                rectanguloBordeado.setRoundRect(
                        x, y, ancho - 1, alto - 1, radio, radio
                );
                if (esLineal) {
                    dibujarFondo(c, padreContenedor, imagenFondo, g2, ancho, alto);
                    if(esSolido) {
                        g2.setColor(c.getBackground());
                        g2.fill(rectanguloBordeado);
                    }
                    area = dibujarBorde(c, g2, colorBorde, x, y, ancho, alto, rectanguloBordeado);
                } else {
                    area = dibujarBorde(c, g2, colorBorde, x, y, ancho, alto, rectanguloBordeado);
                    dibujarFondo(c, padreContenedor, imagenFondo, g2, ancho, alto);
                }
                g2.setClip(null);
                g2.draw(area);
            }

            @Override
            public Insets getBorderInsets(Component c) {
                return new Insets(2, 2, 2, 2);
            }

            @Override
            public boolean isBorderOpaque() {
                return false;
            }
        };
        return bordeRedondeado;
    }
    public BasicScrollBarUI devolverScrollPersonalizado(
            int grosor, int radio, Color colorFondo, Color colorBarraNormal, Color colorBarraArrastrada
    ) {
        return new BasicScrollBarUI() {
            private Dimension d = new Dimension();

            @Override
            protected JButton createDecreaseButton(int orientation) {
                JButton boton = new JButton();
                boton.setPreferredSize(d);
                return boton;
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                JButton boton = new JButton();
                boton.setPreferredSize(d);
                return boton;
            }

            @Override
            protected void paintTrack(Graphics g, JComponent c, Rectangle r) {
                g.setColor(colorFondo);
                g.fillRect(r.x, r.y, r.width, r.height);
            }

            @Override
            protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(
                        RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON
                );
                JScrollBar sb = (JScrollBar) c;
                if (!sb.isEnabled()) return;
                else if (isDragging) g2.setPaint(colorBarraArrastrada);
                else if (isThumbRollover()) g2.setPaint(colorBarraNormal);
                else g2.setPaint(colorBarraNormal);

                if (r.width < r.height) g2.fillRoundRect(
                        (r.width - grosor) / 2, r.y, grosor, r.height, radio, radio
                );
                else
                    g2.fillRoundRect(
                            r.x, (r.height - grosor) / 2, r.width, grosor, radio, radio
                    );
            }
        };
    }
    public static GraficosAvanzadosService getService() {
        if (service == null) service = new GraficosAvanzadosService();
        return service;
    }
}
