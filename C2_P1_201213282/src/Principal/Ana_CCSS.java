/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Analizadores.Sintactico_CCSS;
import Analizadores.Sintactico_CJS;
import Analizadores.lexico_CCSS;
import Analizadores.lexico_cjs;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author Sergio Fernando
 */
public class Ana_CCSS {
    public NCCSS Raiz;
     public Ana_CCSS(String archivo) {
        File file = new File(archivo);
        try {
            FileReader fr = new FileReader(file);
            lexico_CCSS lex = new lexico_CCSS(fr);
            Sintactico_CCSS miParser = new Sintactico_CCSS(lex);
            miParser.parse();
            Raiz=miParser.RCCSS;
            Analizar_CSS(Raiz,0);
            
        } catch (Exception e) {
            System.out.println(e);
        }
     }
     public void Analizar_CSS(NCCSS nodo,int num){
         System.out.println(num+1+"-"+nodo.etiqueta+"..."+nodo.hijos.size());
         num++;
         if(nodo.hijos.size()>1){
             System.out.println(".."+num+nodo.hijos.get(0).etiqueta+"___"+nodo.hijos.get(0).hijos.size());
             System.out.println(".."+num+nodo.hijos.get(1).etiqueta+"___"+nodo.hijos.get(1).hijos.size());
             if(nodo.hijos.get(0).etiqueta.equalsIgnoreCase("grupo")){
                 Analizar_G(nodo.hijos.get(0));
             }else if(nodo.hijos.get(0).etiqueta.equalsIgnoreCase("id")){
                
             }
             if(nodo.hijos.get(1).etiqueta.equalsIgnoreCase("inicio")){
                Analizar_CSS(nodo.hijos.get(1),num);
             }
         }else{
             System.out.println("..."+num+nodo.hijos.get(0).etiqueta+"___"+nodo.hijos.get(0).hijos.size());
             if(nodo.hijos.get(0).etiqueta.equalsIgnoreCase("grupo")){
                 Analizar_G(nodo.hijos.get(0));
             }else if(nodo.hijos.get(0).etiqueta.equalsIgnoreCase("id")){
                 
             }
         }
     }
     public void Analizar_G(NCCSS nodo){
         System.out.println(nodo.vecino.size()+"v");
         if(nodo.hijos.size()>1){
           System.out.println("G"+nodo.hijos.get(0).etiqueta);
           System.out.println("G"+nodo.hijos.get(1).etiqueta);
            }
         else{
           System.out.println("G"+nodo.hijos.get(0).etiqueta);
         }
      }
}

