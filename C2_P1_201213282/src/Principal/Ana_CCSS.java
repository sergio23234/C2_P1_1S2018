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
            System.out.println(Raiz.etiqueta+"__"+Raiz.valor+"__"+Raiz.hijos.size());
            
        } catch (Exception e) {
            System.out.println(e);
        }
     }
     
}
