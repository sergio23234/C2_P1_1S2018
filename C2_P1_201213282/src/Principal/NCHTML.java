/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.util.ArrayList;

/**
 *
 * @author sergi
 */
public class NCHTML {
    public String etiqueta;
    public String contenido;
    public ArrayList<NCHTML> hijos;
    public ArrayList<NCHTML> atributos;
    public NCHTML(){
        hijos = null;
        atributos=null;
        etiqueta ="";
        contenido ="";
    }
}
