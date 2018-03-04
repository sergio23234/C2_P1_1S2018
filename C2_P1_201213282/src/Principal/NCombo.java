/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

/**
 *
 * @author sergi
 */
public class NCombo extends JComboBox {
    public String id;
    public String grupo;
    public String clic;
    private Font Fuente=new Font(null,0,12);
    private int tam_letra;
    private String tipo_letra;
    public NCombo(){
        id ="";
        grupo ="";
        clic ="";
        
    }
    public void cambiar_tipo_letra(String tipo){
        Fuente = new Font(tipo,0,tam_letra);
        this.setFont(Fuente);
        tipo_letra = tipo;
        repaint();
        
    }
    
    
}
