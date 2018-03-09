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
public class NCCSS {
       public String etiqueta;
       public String valor;
       public ArrayList<NCCSS> hijos;
       public ArrayList<NCCSS> vecino;
    public NCCSS(){
        hijos = new ArrayList();
        etiqueta ="";
        valor ="";
        vecino = new ArrayList();
    }
}
