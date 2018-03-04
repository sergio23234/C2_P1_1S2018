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
        File file=new File("src/Principal/Prueba_cjs.txt");
        try{
        
        FileReader fr=new FileReader(file);
        //lexico_chtml lex=new lexico_chtml(fr);
        lexico_cjs lex=new lexico_cjs(fr);
        Sintactico_CJS miParser = new Sintactico_CJS(lex);
       // Sintactico_CHTML miParser=new Sintactico_CHTML(lex);
        miParser.parse();
        
	}catch(Exception e){ 
            System.out.println(e);
        } 
     }

}
