/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.awt.Color;
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
    public NBoton(){
        super();
        ID ="";
        Grupo="";
        clic="";
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
    public void Set_texto(String texto){
        this.setText(texto);
    }


}
