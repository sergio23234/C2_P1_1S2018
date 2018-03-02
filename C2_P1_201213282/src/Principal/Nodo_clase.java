/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.*;

/**
 *
 * @author Sergio Fernando
 */
public class Nodo_clase extends JPanel{
    ArrayList<String>   historial   = new ArrayList();
    Stack<String>       anterior    = new Stack<String>();
    Stack<String>       siguiente   = new Stack<String>();
    JLabel direccion = new JLabel();
    JPanel panel = new JPanel();
    JButton B_sig = new JButton();
    JButton B_ant = new JButton();
    private String direc_ant =""; 
    public Nodo_clase(){
     direccion.setText("");
     B_sig.setText("->");
     this.add(B_sig);
     this.setBackground(Color.ORANGE);
     this.setLayout(null);
     B_sig.setBounds(0,1,50,50);
     B_sig.setBackground(Color.BLUE);
     B_sig.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e) {
                Cambiar_panel_color(Color.blue);
         }
     
     });
    }
    public void presiono_anterior(){
        String ante = anterior.pop();
        String actual = direccion.getText();
        siguiente.push(actual);
        direccion.setText(ante);
        if(anterior.isEmpty()){
            B_ant.setEnabled(false);
        }
        if(!siguiente.isEmpty()){
            B_sig.setEnabled(true);
        }
    }
    public void presiono_siguiente(){
        String sig = siguiente.pop();
        String actual = direccion.getText();
        anterior.push(actual);
        direccion.setText(sig);
        if(!anterior.isEmpty()){
            B_ant.setEnabled(true);
        }
        if(siguiente.isEmpty()){
            B_sig.setEnabled(false);
        }
    }
    private void presiono_refrescar(){
        
    }
    private void presiono_ir(){
        if(direc_ant.equals("")){
            
        }
        else{
            
        }
    }
    public void Cambiar_panel_color(Color color){
        this.setBackground(color);
    }
    public void Azar_color(){
        for(int i=0;i<Menu.clases.size();i++){
            Nodo_clase clas = Menu.clases.get(i);
            int numero = (int) (Math.random() *4) + 1;
            System.out.println("NUM"+numero);
            switch(numero){
                case 1: clas.Cambiar_panel_color(Color.GRAY); break;
                case 2: clas.Cambiar_panel_color(Color.RED); break;
                case 3: clas.Cambiar_panel_color(Color.GREEN); break;
                case 4: clas.Cambiar_panel_color(Color.MAGENTA); break;
                default: clas.Cambiar_panel_color(Color.LIGHT_GRAY); break;
            }
        }
        
    }
}
