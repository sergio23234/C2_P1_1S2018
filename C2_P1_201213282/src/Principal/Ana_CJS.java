/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Analizadores.Sintactico_CJS;
import Analizadores.lexico_cjs;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author sergi
 */
public class Ana_CJS {
    public NCJS Raiz;
    ArrayList<Nodo_TablaS> tabla = new ArrayList();
    Stack<String> ambito = new Stack<String>();
    public Ana_CJS(String archivo){
        File file=new File(archivo);
        try{
        
        FileReader fr=new FileReader(file);
        lexico_cjs lex=new lexico_cjs(fr);
        Sintactico_CJS miParser = new Sintactico_CJS(lex);
        miParser.parse();
        Raiz=miParser.RCJS;
	}catch(Exception e){ 
            System.out.println(e);
        } 
    }
    public NCJS retornar_raiz(){
        return Raiz;
    }
    public void Analizar_Nodo(NCJS nodo){
        System.out.println(nodo.etiqueta);
        NCJS nuevo = null;
        if(nodo.hijos.size()>1){
            if(nodo.hijos.get(0).etiqueta.equalsIgnoreCase("cuerpo")){
                Analizar_Nodo(nodo.hijos.get(0));
            }
            nuevo = nodo.hijos.get(1);
           
        }else{
            nuevo = nodo.hijos.get(0);
        }
        switch(nuevo.etiqueta.toLowerCase()){
               case "si": Analizar_Si(nuevo); break;
               case "impirmir": Analizar_imprimir(nuevo);   break;
               case "asignar": Analizar_Asignar(nuevo);    break;
               case "variable": Analizar_Declarar(nuevo);   break;
               case "seleccion":Analizar_Switch(nuevo);   break;
               case "mientras": Analizar_Mientras(nuevo);   break;
               case "mensaje":Analizar_imprimir(nuevo);     break;
               case "para": Analizar_Para(nuevo);       break;
               case "funcion": Analizar_Funcion(nuevo);    break;
           }
    }
    public void Analizar_Funcion(NCJS nodo){
        
    }
    public void Analizar_Declarar(NCJS nodo){
        
    }
    public void Analizar_imprimir(NCJS nodo){
        
    }
    public void Analizar_Si(NCJS nodo){
        
    }
    public void Analizar_Para(NCJS nodo){
        
    }
    public void Analizar_Mientras(NCJS nodo){
        
    }
    public void Analizar_Switch(NCJS nodo){
        
    }
    public void Analizar_Asignar(NCJS nodo){
        
    }
    private void OPA(NCJS nodo){
        
    }
}
