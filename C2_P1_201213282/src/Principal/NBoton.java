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
import javax.swing.JButton;

/**
 *
 * @author sergi
 */
public class NBoton extends JButton{
    public String ID;
    public String Grupo;
    public String clic;
    private Font Fuente;
    private String letra;
    private int tam;
    private int tipol;
    public NBoton(){
        super();
        ID ="";
        Grupo="";
        clic="";
        Fuente=new Font("Arial",0,12);
        setFont(Fuente);
        repaint();
        letra ="Arial";
        tam = 12;
        tipol=0;
    }
    public void Set_Tam(int anchura,int altura){
        this.setBounds(0,0,anchura,altura);
    }
    public void Set_color(String color){
        this.setBackground(Color.decode(color));
    }
    public void Set_COLOR(int rojo,int azul,int verde){
        this.setBackground(new Color(rojo,azul,verde));
    }
    public void Set_texto(String texto,int tipo,int color){
        switch(tipo){
            case 0: break;
            case 1: texto=texto.toLowerCase(); break;
            case 2: texto=texto.toUpperCase(); break;
            case 3: texto=cambiar_letra(texto);break;
        }
        tipol = color;
        Fuente = new Font(letra,tipol,tam);
        this.setText(texto);
    }
    private String cambiar_letra(String cadena){
        char[] caracteres = cadena.toCharArray();
        for (int i = 0; i < cadena.length()- 2; i++){ 
            if (caracteres[i] == ' ' || caracteres[i] == '.' || caracteres[i] == ','){
                caracteres[i + 1] = Character.toUpperCase(caracteres[i + 1]);}
        }
        return new String(caracteres);
    }
}
