/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Sergio Fernando
 */
public class NPanel extends JPanel implements ActionListener{
    public String ID;
    public String Grupo;
    public String clic;
    public int pos_x=0,pos_y=0;
    private int altura_prev=0,anchura_prev=0;
    ArrayList<NBoton> Botones = new ArrayList();
    public NPanel(){
        this.setLayout(null);
    }
  public void Add_boton(int altura,int anchura){
        NBoton nuevob = new NBoton();
        nuevob.setText("NUEVO BOTON");
        nuevob.addActionListener(this);
        nuevob.setBounds(pos_x, pos_y,anchura,altura);
        altura_prev=altura;
        anchura_prev=anchura;
        pos_x = pos_x+anchura;
        add(nuevob);
        nuevob.setLayout(null);
        Botones.add(nuevob);
        repaint();
    }
  public void Salto_Linea(){
      pos_y = pos_y+altura_prev;
      pos_x=0;
  }
    public void azar_color(NBoton boton){
        int azul = (int) (Math.random() * 255);
        int rojo = (int) (Math.random() * 255);
        int verde =(int) (Math.random() * 255);
        boton.Set_COLOR(rojo, azul, verde);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object fuente= e.getSource();
        if(!Botones.isEmpty()){
                for(int i=0;i<Botones.size();i++){
                    if(fuente==Botones.get(i)){
                        azar_color(Botones.get(i));
                    }
                }
            }
    }
}
