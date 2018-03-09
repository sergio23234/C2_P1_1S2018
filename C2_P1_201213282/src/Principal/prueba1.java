/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Analizadores.*;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author Sergio Fernando
 */
public class prueba1 {
         public void metodo(){
        Ana_CJS ana = new Ana_CJS("src/Principal/Prueba_cjs.txt");
        ana.Analizar_Nodo(ana.retornar_raiz());
     }
         public void metodo2(){
             File file = new File("src/Principal/Prueba_chtml.txt");
        try {
            FileReader fr = new FileReader(file);
            lexico_chtml lex = new lexico_chtml(fr);
            Sintactico_CHTML miParser = new Sintactico_CHTML(lex);
            miParser.parse();
            
        } catch (Exception e) {
            System.out.println(e);
        }
         }
         public void metodo3(){
             File file = new File("src/Principal/Prueba_ccss.txt");
        try {
            FileReader fr = new FileReader(file);
            lexico_CCSS lex = new lexico_CCSS(fr);
            Sintactico_CCSS miParser = new Sintactico_CCSS(lex);
            miParser.parse();
            NCCSS Raiz=miParser.RCCSS;
            System.out.println(Raiz.etiqueta+"__"+Raiz.valor+"__"+Raiz.hijos.size());
            
        } catch (Exception e) {
            System.out.println(e);
        }     
         }
}
