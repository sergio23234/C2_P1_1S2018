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
    Stack<String>       anterior    = new Stack<String>();
    Stack<String>       siguiente   = new Stack<String>();
    JLabel direccion = new JLabel();
    JPanel panel = new JPanel();
    JButton B_sig = new JButton();
    JButton B_ant = new JButton();
    private String direc_ant =""; 
    public Nodo_clase(){

    }
  
}
