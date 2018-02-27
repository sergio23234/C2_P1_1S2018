/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

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
    JButton B_sig = new JButton();
    JButton B_ant = new JButton();
    private String direc_ant =""; 
    public Nodo_clase(){
     JButton boton = new JButton();
     direccion.setText("");
     boton.setText("TEXTO DEL BOTON");
     this.add(boton);
     this.setBounds(0,0,100,200);
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
}
