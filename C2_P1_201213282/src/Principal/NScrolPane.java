/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;
import java.awt.Color;
import java.awt.Dimension;
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
    JPanel General = new JPanel();
    ArrayList<NBoton> Botones = new ArrayList();    
    
    public NScrolPane(){
       super(VERTICAL_SCROLLBAR_AS_NEEDED,HORIZONTAL_SCROLLBAR_AS_NEEDED);
       this.setBounds(0,0,1000,600);
       panel.setBounds(0,0,this.getWidth(),40);
       General.setBounds(0,0,1000,600);
       General.setBackground(Color.WHITE);
       //this.setLayout(null);
       General.setLayout(null);
       panel.setLayout(null);
       General.add(panel);
       this.add(General);
       panel.setBackground(new Color(157,231,251));
       panel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
       Inicializar_botones();
       this.setViewportView(General);
       this.getViewport().setView(General);
       this.repaint();
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
        pos_y = 50;
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
    public void Add_boton(int altura,int anchura){
        NBoton nuevob = new NBoton();
        nuevob.setText("NUEVO BOTON");
        nuevob.addActionListener(this);
        nuevob.setBounds(pos_x, pos_y,anchura,altura);
        pos_x = pos_x+anchura;
        pos_y = pos_y+altura;
        General.add(nuevob);
        nuevob.setLayout(null);
        Botones.add(nuevob);
        this.repaint();
       General.setPreferredSize(new Dimension(pos_x,pos_y));
       if(pos_x>panel.getWidth()){
           panel.setBounds(0,0,pos_x,40);
       }
       panel.repaint();
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
        
        if(fuente==B_ant){
            presiono_anterior();
        }
        else if(fuente ==B_sig){
            presiono_siguiente();
        }else if(fuente ==B_car){
            Add_boton(40,50);
            //presiono_refrescar();
        }else if(fuente ==B_ir){
            presiono_ir();
        }
        else{
            if(!Botones.isEmpty()){
                for(int i=0;i<Botones.size();i++){
                    if(fuente==Botones.get(i)){
                        azar_color(Botones.get(i));
                    }
                }
            }
        }
    }
}
