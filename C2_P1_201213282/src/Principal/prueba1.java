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

}
