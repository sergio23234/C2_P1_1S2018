/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.*;

/**
 *
 * @author sergi
 */
public class NScrolPane extends JScrollPane implements ActionListener{
    public String Sdireccion ="";
    Stack<String>       anterior    = new Stack<String>();
    Stack<String>       siguiente   = new Stack<String>();
    JTextField direccion = new JTextField();
    JPanel panel = new JPanel();
    JButton B_sig = new JButton();
    JButton B_ant = new JButton();
    JButton B_ir = new JButton();
    JButton B_car = new JButton();  
    public int pos_x =0;
    public int pos_y=0;
   
    public NScrolPane(){
       super(VERTICAL_SCROLLBAR_AS_NEEDED,HORIZONTAL_SCROLLBAR_AS_NEEDED);
       this.setBounds(0,0,840,400);
       panel.setBounds(0,0,this.getWidth(),40);
       this.setLayout(null);
       this.add(panel);
       panel.setBackground(new Color(157,231,251));
       panel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
       Inicializar_botones();
       
    }
    private void Inicializar_botones(){
        ImageIcon icono = new ImageIcon("src\\Imagenes\\ant.png");
        B_ant.setIcon(icono);
        B_ant.setBounds(1,0,40,40);
        B_ant.setText("");
        B_ant.setBackground(new Color(20,185,229));
        panel.add(B_ant);
        ImageIcon icono1 = new ImageIcon("src\\Imagenes\\sig.png");
        B_sig.setIcon(icono1);
        B_sig.setBounds(42,0,40,40);
        B_sig.setText("");
        B_sig.setBackground(new Color(20,185,229));
        panel.add(B_sig);
        direccion.setBounds(83,0,600,40);
        direccion.setText("");
        direccion.setBackground(Color.WHITE);
        panel.add(direccion);
        icono = new ImageIcon("src\\Imagenes\\Ir.png");
        B_ir.setIcon(icono);
        B_ir.setBounds(683,0,40,40);
        B_ir.setText("");
        B_ir.setBackground(new Color(20,185,229));
        panel.add(B_ir);
        icono1 = new ImageIcon("src\\Imagenes\\Recargar.png");
        B_car.setIcon(icono1);
        B_car.setBounds(724,0,40,40);
        B_car.setText("");
        B_car.setBackground(new Color(20,185,229));
        panel.add(B_car);
        panel.setLayout(null);
        //this.repaint();
        pos_y = 40;
        B_ant.setEnabled(false);
        B_sig.setEnabled(false);
        B_ant.addActionListener(this);
        B_sig.addActionListener(this);
        B_ir.addActionListener(this);
        B_car.addActionListener(this);
    }
    public void crear_boton(String S_id,String S_grupo){
        
    }
    private void presiono_anterior(){
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
    private void presiono_siguiente(){
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
        if(!direccion.getText().equals("")){
            anterior.push(Sdireccion);
            Sdireccion = direccion.getText();
        }
    }
    private void presiono_ir(){
        if(!direccion.getText().equals("")){
            if(Sdireccion.equals("")){
                Sdireccion = direccion.getText();
            }
            else{
                anterior.push(Sdireccion);
                Sdireccion = direccion.getText();
                if(!B_ant.isEnabled()){
                    B_ant.setEnabled(true);
                }
            }   
         }
    }
    public void add_panel(int largo,int ancho){
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object fuente= e.getSource();
        
        if(fuente==B_ant){
            presiono_anterior();
        }
        else if(fuente ==B_sig){
            presiono_siguiente();
        }else if(fuente ==B_car){
            presiono_refrescar();
        }else if(fuente ==B_ir){
          
            presiono_ir();
        }
    }
}
