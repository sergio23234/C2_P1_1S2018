/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

/**
 *
 * @author sergi
 */
public class NBoton extends JButton {

    public String ID;
    public String Grupo;
    public String clic;
    private Font Fuente;
    private String letra;
    private int tam;
    private int tipol;
    private int tipo_t;

    public NBoton() {
        super();
        ID = "";
        Grupo = "";
        clic = "";
        Fuente = new Font("Arial", 0, 12);
        setFont(Fuente);
        repaint();
        letra = "Arial";
        tam = 12;
        tipol = 0;
    }

    public void Set_Tam(int anchura, int altura) {
        this.setBounds(0, 0, anchura, altura);
    }

    public void Set_color(String color) {
        this.setBackground(Color.decode(color));
    }

    public void Set_COLOR(int rojo, int azul, int verde) {
        this.setBackground(new Color(rojo, azul, verde));
    }

    public void Set_texto(String texto, int tipo, int color) {
        switch (tipo) {
            case 0:
               tipo_t=0; break;
            case 1:
                tipo_t=1;
                texto = texto.toLowerCase();
                break;
            case 2:
                tipo_t=2;
                texto = texto.toUpperCase();
                break;
            case 3:
                tipo_t=3;
                texto = cambiar_letra_CAPT(texto);
                break;
        }
        tipol = color;
        Actualizar_fuente();
        this.setText(texto);
    }

    private String cambiar_letra_CAPT(String cadena) {
        char[] caracteres = cadena.toCharArray();
        for (int i = 0; i < cadena.length() - 2; i++) {
            if (caracteres[i] == ' ' || caracteres[i] == '.' || caracteres[i] == ',') {
                caracteres[i + 1] = Character.toUpperCase(caracteres[i + 1]);
            }
        }
        return new String(caracteres);
    }

    public void cambiar_letra(int num) {
        tam = num;
        Actualizar_fuente();
    }

    private void Actualizar_fuente() {
        Fuente = new Font(letra, tipol, tam);
        setFont(Fuente);
        repaint();
    }

    /*Alineado*/
    public void cambiar_alineado(int num) {
        this.setHorizontalAlignment(num);
        repaint();
    }

    /*Color */
    public void set_Fondo_Color(String Color) {
        Color nuevo = decodificador(Color);
        this.setBackground(nuevo);
        repaint();
    }

    /*Color letra*/
    public void set_Color_Letra(String Color) {
        Color nuevo = decodificador(Color);
        this.setForeground(nuevo);
        repaint();
    }

    /*Visible*/
    public void Set_visible(int num) {
        if (num == 1) {
            this.setVisible(true);
        } else {
            this.setVisible(false);
        }
        repaint();
    }
    
    /*OPAque*/
    public void Set_opaque(int num) {
        if (num == 1) {
            this.setEnabled(true);
        } else {
            this.setEnabled(false);
        }
        repaint();
    }
    
    
    /*Borde*/
    public void Set_Borde(String color, int num, int circular) {
        Color nuevocolor = decodificador(color);
        if (circular > 0) {
            this.setBorder(BorderFactory.createLineBorder(nuevocolor, num, true));
        } else {
            this.setBorder(BorderFactory.createLineBorder(nuevocolor, num, false));
        }
    }

    private Color decodificador(String tipo) {
        return Color.decode(tipo);
    }
}
