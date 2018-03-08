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
               case "si": Analizar_Si(nuevo);               break;
               case "impirmir": Analizar_imprimir(nuevo);   break;
               case "asignar": Analizar_Asignar(nuevo);     break;
               case "variable": Analizar_Declarar(nuevo);   break;
               case "seleccion":Analizar_Switch(nuevo);     break;
               case "mientras": Analizar_Mientras(nuevo);   break;
               case "mensaje":Analizar_imprimir(nuevo);     break;
               case "para": Analizar_Para(nuevo);           break;
               case "funcion": Analizar_Funcion(nuevo);     break;
           }
    }
    public void Analizar_Funcion(NCJS nodo){
      Nodo_TablaS nuevo = new Nodo_TablaS();
      nuevo.nodo = nodo;
      nuevo.nombre = nodo.valor;
      nuevo.tipo = nodo.etiqueta;
      nuevo.valor ="";
      tabla.add(nuevo);
      ambito.push(nodo.valor);
      System.out.println(nodo.hijos.size()+ambito.peek());
      if(nodo.hijos.size()>1){
          String dato = nodo.hijos.get(0).etiqueta;
          String dato1 = nodo.hijos.get(1).etiqueta;
          if(dato.equalsIgnoreCase("ID")){
              
          }
          if(dato1.equalsIgnoreCase("Cuerpo")){
              Analizar_Nodo(nodo.hijos.get(1));
          }
      }
      else{
          String dato = nodo.hijos.get(0).etiqueta;
          if(dato.equalsIgnoreCase("cuerpo")){
              Analizar_Nodo(nodo.hijos.get(0));
          }
      }
      ambito.pop();
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
    private String OPA(NCJS nodo){
          if(nodo.hijos.size()>1){
           String valor = OPA(nodo.hijos.get(0));
           NCJS temp = nodo.hijos.get(1);
           String accion = temp.hijos.get(0).etiqueta;
           String valor2 = OPA(temp.hijos.get(1));
           if(!valor2.equals("#*ERROR*#")&&!valor.equals("#*ERROR*#")){
           String tipo1 = tipo_valor(valor);
           String tipo2 = tipo_valor(valor2);
           if(operacion_valida(tipo1,tipo2,accion)){
               String a = Hacer_op(valor,valor2,tipo1,tipo2,accion);
               return a;
               
           }
           else{
               return "#*ERROR*#";
           }
           }
       }
       else{
       
     
       }
       return "";
    }
    
    private boolean  verificar_es_tipo_num(String dato){
       if(dato.contains("\"")){
             return false;
         }
       else if(dato.contains("'")){
             return false;
        }
       else if(dato.contains("true")||dato.contains("false")){
           return false;
       }
       return true;
   }
    private boolean  verificar_es_tipo_string(String dato){
       return dato.contains("\"");
   }
    private boolean  verificar_es_tipo_date(String dato){
       if(dato.contains("'")){
           return !dato.contains(":");
       }
       return false;
   }
    private boolean  verificar_es_tipo_datetime(String dato){
       if(dato.contains("'")){
           return dato.contains(":");
       }
       return false;
   }
    private boolean  verificar_es_tipo_bool(String dato){
       if(dato.equalsIgnoreCase("true")){
           return true;
       }
       else if(!dato.equalsIgnoreCase("false")){
       } else {
           return true;
       }
       return false;
   }
   private String   Hacer_op_sum(String valor1,String valor2,String tipo1,String tipo2){
     if(tipo1.equals("text")){
        if(tipo2.equals("text")){
            String retorno1 = valor1.replace("\"","");
            String retorno2 = valor2.replace("\"","");
            return "\""+retorno1+retorno2+"\"";
        }
        else{
            String retorno1 = valor1.replace("\"","");
            return "\""+retorno1+valor2+"\"";    
        }
     }
     if(tipo2.equals("text")){
      String retorno2 = valor2.replace("\"","");
      return "\""+valor1+retorno2+"\"";
     }
     if(tipo1.equals("bool")&&tipo2.equals("bool")){
         if(valor1.equalsIgnoreCase("true")||valor2.equalsIgnoreCase("true")){
             return "true";
         }
         else{
             return "false";
         }
     }
     if(tipo1.equals("num")){
        if(tipo2.equals("num")){
             double val1 = Double.valueOf(valor1);
             double val2 = Double.valueOf(valor2);
             double tot = val1+val2;
             return String.valueOf(tot);
         }
         if(tipo2.equals("bool")){
             double val1 = Double.valueOf(valor1);
             int val2 = 0;
             if(valor2.equalsIgnoreCase("true")){
                 val2=1;
             }
             double tot = val1+val2;
             return String.valueOf(tot);
         }
     }
     if(tipo1.equals("bool")){
         if(tipo2.equals("bool")){
             if(valor2.equalsIgnoreCase("true")||valor1.equals("true")){
                 return "true";
             }
             return "false";
         }
     }

   return "";
   }
   private String   Hacer_op_res(String valor1,String valor2,String tipo1,String tipo2){
        if(tipo1.equals("num")){
           if(tipo2.equals("num")){
             double val1 = Double.valueOf(valor1);
             double val2 = Double.valueOf(valor2);
             double tot = val1-val2;
             return String.valueOf(tot);
           }
           if(tipo2.equals("bool")){
             double val1 = Double.valueOf(valor1);
             int val2=0;
             if(valor2.equals("true")){
                 val2=1;
             }
             double tot = val1-val2;
             return String.valueOf(tot);
           }
       }
       if(tipo1.equals("bool")){
        if(tipo2.equals("num")){
             double val1 = 0;
             if(valor1.equals("true")){
                 val1 = 1;
             }double val2 = Double.valueOf(valor2);
             double tot = val1-val2;
             return String.valueOf(tot);
           }
       }
       return "";
   }
   private String   Hacer_op_mul(String valor1,String valor2,String tipo1,String tipo2){
     if(tipo1.equals("num")){
        if(tipo2.equals("num")){
             double val1 = Double.valueOf(valor1);
             double val2 = Double.valueOf(valor2);
             double tot = val1*val2;
             return String.valueOf(tot);
           }
           if(tipo2.equals("bool")){
             double val1 = Double.valueOf(valor1);
             int val2=0;
             if(valor2.equals("true")){
                 val2=1;
             }
             double tot = val1*val2;
             return String.valueOf(tot);
           }
       }
       if(tipo1.equals("bool")){
            if(tipo2.equals("num")){
             double val1 = 0;
             if(valor1.equals("true")){
                 val1 = 1;
             }double val2 = Double.valueOf(valor2);
             double tot = val1*val2;
             return String.valueOf(tot);
           }
           if(tipo2.equals("bool")){
               if(valor2.equalsIgnoreCase("true")&&valor1.equalsIgnoreCase("true")){
                   return "true";
               }
               else{
                   return "false";
               }
           }
       }
     return "";  
    }
   private String   Hacer_op_div(String valor1,String valor2,String tipo1,String tipo2){
     if(tipo1.equals("num")){
           if(tipo2.equals("num")){
             double val1 = Double.valueOf(valor1);
             double val2 = Double.valueOf(valor2);
             if(val2!=0){
             double tot = val1/val2;
             return String.valueOf(tot);    
             }
             return "#*ERROR*#";
           }
           if(tipo2.equals("bool")){
             double val1 = Double.valueOf(valor1);
             if(valor2.equals("true")){
                 return String.valueOf(val1);
             }
             return "#*ERROR*#";
           }
       }
        if(tipo1.equals("bool")){
            if(tipo2.equals("num")){
             double val2 = Double.valueOf(valor2);
             if(valor1.equals("true")){
                 return String.valueOf(val2);
             }
             return "#*ERROR*#";
           }
       }
       return "";
   }
   private String   Hacer_op_elv(String valor1,String valor2,String tipo1,String tipo2){
        if(tipo1.equals("num")){
           if(tipo2.equals("num")){
             double val1 = Double.valueOf(valor1);
             double val2 = Double.valueOf(valor2);
             double tot = Math.pow(val1, val2);
             return String.valueOf(tot);
           }
           if(tipo2.equals("bool")){
             double val1 = Double.valueOf(valor1);
             int val2=0;
             if(valor2.equals("true")){
                 val2=1;
             }
             double tot = Math.pow(val1, val2);
             return String.valueOf(tot);
           }
        }
        return "";
   }
    private String   Hacer_op_opc(String valor1,String valor2,String tipo1,String tipo2,String accion){
       switch(accion){
           case ">":
               return Hacer_op_may(valor1,valor2,tipo1,tipo2);
           case ">=":
               return Hacer_op_mai(valor1,valor2,tipo1,tipo2);
           case "<":
               return Hacer_op_men(valor1,valor2,tipo1,tipo2);
           case "<=":
               return Hacer_op_mei(valor1,valor2,tipo1,tipo2);
           case "!=":
               return Hacer_op_nig(valor1,valor2,tipo1,tipo2);
           case "==":
               return Hacer_op_igu(valor1,valor2,tipo1,tipo2);
           default:
               return "#*ERROR*#";
       }
   }
   private String   Hacer_op_opl(String valor1,String valor2,String tipo1,String tipo2,String accion){
       switch(accion){
           case "&&":
               return Hacer_op_and(valor1,valor2);
           case "||":
               return Hacer_op_or(valor1,valor2);
           case "!":
               return Hacer_op_not(valor1);
           default:
               return "ERROR";
       }
   }   
   private String   Hacer_op_may(String valor1,String valor2,String tipo1,String tipo2){
       if(tipo1.equals("text")){
          String a = valor1.replace("\"","");
          String b = valor2.replace("\"","");
          if(a.compareTo(b)>0){
              return "true";
          }
          else{
              return "false";
          }
       }
       if(tipo1.equals("int")){
           int a = Integer.valueOf(valor1);
          if(tipo2.equals("int")){
           int b = Integer.valueOf(valor2);
           if(a>b){
               return "true";
           }
           else{
               return "false";
           }
          }
          else if(tipo2.equals("double")){
           double b = Double.valueOf(valor2);
           if(a>b){
               return "true";
           }
           else{
               return "false";
           }
          }
          else{
            int dato = 0;
            if(tipo2.equals("true")){
                   dato =1;
              }
            if(a<dato){
                   return "true";
                   }
            else{
                   return "false";
                   }
           }
       }
       if(tipo1.equals("double")){
           double a = Double.valueOf(valor1);
          if(tipo2.equals("int")){
           int b = Integer.valueOf(valor2);
           if(a>b){
               return "true";
           }
           else{
               return "false";
           }
          }
          else if(tipo2.equals("double")){
           double b = Double.valueOf(valor2);
           if(a>b){
               return "true";
           }
           else{
               return "false";
           }
          }
          else{
            int dato = 0;
            if(tipo2.equals("true")){
                   dato =1;
              }
            if(a>dato){
                   return "true";
                   }
            else{
                   return "false";
                   }
           }
       }
       if(tipo1.equals("date")){
          String fecha1[] = valor1.replace("'","").split("-");
          String fecha2[] = valor2.replace("'","").split("-");
          int dia1  = Integer.valueOf(fecha1[0]);
          int mes1  = Integer.valueOf(fecha1[1]);
          int anio1 = Integer.valueOf(fecha1[2]);
          int dia2  = Integer.valueOf(fecha2[0]);
          int mes2  = Integer.valueOf(fecha2[1]);
          int anio2 = Integer.valueOf(fecha2[2]);
          if(anio1>anio2){
              return "true";
          }
          if(mes1>mes2){
              return "true";
          }
          if(dia1>dia2){
              return "true";
          }
          return "false";
       }
       if(tipo1.equals("datetime")){
          String phora1[] = valor1.replace("'","").split(" ");
          String phora2[] = valor2.replace("'","").split(" ");
          String fecha1[] = phora1[0].split("-");
          String fecha2[] = phora2[0].split("-");
          String hora1[]  = phora1[1].split(":");
          String hora2[]  = phora2[1].split(":");
          int dia1  = Integer.valueOf(fecha1[0]);
          int mes1  = Integer.valueOf(fecha1[1]);
          int anio1 = Integer.valueOf(fecha1[2]);
          int dia2  = Integer.valueOf(fecha2[0]);
          int mes2  = Integer.valueOf(fecha2[1]);
          int anio2 = Integer.valueOf(fecha2[2]);
          int hora_1 = Integer.valueOf(hora1[0]);
          int minuto_1 = Integer.valueOf(hora1[1]);
          int segundo_1 = Integer.valueOf(hora1[2]);
          int hora_2 = Integer.valueOf(hora2[0]);
          int minuto_2 = Integer.valueOf(hora2[1]);
          int segundo_2 = Integer.valueOf(hora2[2]);
          if(anio1>anio2){
              return "true";
          }
          if(mes1>mes2){
              return "true";
          }
          if(dia1>dia2){
              return "true";
          }
          if(hora_1>hora_2){
              return "true";
          }
          if(minuto_1>minuto_2){
              return "true";
          }
          if(segundo_1>segundo_2){
              return "true";
          }
          return "false";
       }
   return "";    
   }
   private String   Hacer_op_men(String valor1,String valor2,String tipo1,String tipo2){
       if(tipo1.equals("text")){
          String a = valor1.replace("\"","");
          String b = valor2.replace("\"","");
          if(a.compareTo(b)<0){
              return "true";
          }
          else{
              return "false";
          }
       }
       if(tipo1.equals("int")){
           int a = Integer.valueOf(valor1);
          if(tipo2.equals("int")){
           int b = Integer.valueOf(valor2);
           if(a<b){
               return "true";
           }
           else{
               return "false";
           }
          }
          else if(tipo2.equals("double")){
           double b = Double.valueOf(valor2);
           if(a<b){
               return "true";
           }
           else{
               return "false";
           }
          }
           else{
            int dato = 0;
            if(tipo2.equals("true")){
                   dato =1;
              }
            if(a<dato){
                   return "true";
                   }
            else{
                   return "false";
                   }
           }
          
       }
       if(tipo1.equals("double")){
           double a = Double.valueOf(valor1);
          if(tipo2.equals("int")){
           int b = Integer.valueOf(valor2);
           if(a<b){
               return "true";
           }
           else{
               return "false";
           }
          }
          else if(tipo2.equals("double")){
           double b = Double.valueOf(valor2);
           if(a<b){
               return "true";
           }
           else{
               return "false";
           }
          }
           else{
            int dato = 0;
            if(tipo2.equals("true")){
                   dato =1;
              }
            if(a<dato){
                   return "true";
                   }
            else{
                   return "false";
                   }
           }
       }
       if(tipo1.equalsIgnoreCase("bool")){
           int a = 0;
           if (valor1.equalsIgnoreCase("true")){a=1;}
           if(tipo2.equals("int")){
           int b = Integer.valueOf(valor2);
           if(a<b){
               return "true";
           }
           else{
               return "false";
           }
          }
          else if(tipo2.equals("double")){
           double b = Double.valueOf(valor2);
           if(a<b){
               return "true";
           }
           else{
               return "false";
           }
          }
           else{
            int dato = 0;
            if(tipo2.equals("true")){
                   dato =1;
              }
            if(a>dato){
                   return "true";
                   }
            else{
                   return "false";
                   }
          }
       }
       if(tipo1.equals("date")){
          String fecha1[] = valor1.replace("'","").split("-");
          String fecha2[] = valor2.replace("'","").split("-");
          int dia1  = Integer.valueOf(fecha1[0]);
          int mes1  = Integer.valueOf(fecha1[1]);
          int anio1 = Integer.valueOf(fecha1[2]);
          int dia2  = Integer.valueOf(fecha2[0]);
          int mes2  = Integer.valueOf(fecha2[1]);
          int anio2 = Integer.valueOf(fecha2[2]);
          if(anio1<anio2){
              return "true";
          }
          if(mes1<mes2){
              return "true";
          }
          if(dia1<dia2){
              return "true";
          }
          return "false";
       }
       if(tipo1.equals("datetime")){
          String phora1[] = valor1.replace("'","").split(" ");
          String phora2[] = valor2.replace("'","").split(" ");
          String fecha1[] = phora1[0].split("-");
          String fecha2[] = phora2[0].split("-");
          String hora1[]  = phora1[1].split(":");
          String hora2[]  = phora2[1].split(":");
          int dia1  = Integer.valueOf(fecha1[0]);
          int mes1  = Integer.valueOf(fecha1[1]);
          int anio1 = Integer.valueOf(fecha1[2]);
          int dia2  = Integer.valueOf(fecha2[0]);
          int mes2  = Integer.valueOf(fecha2[1]);
          int anio2 = Integer.valueOf(fecha2[2]);
          int hora_1 = Integer.valueOf(hora1[0]);
          int minuto_1 = Integer.valueOf(hora1[1]);
          int segundo_1 = Integer.valueOf(hora1[2]);
          int hora_2 = Integer.valueOf(hora2[0]);
          int minuto_2 = Integer.valueOf(hora2[1]);
          int segundo_2 = Integer.valueOf(hora2[2]);
          if(anio1<anio2){
              return "true";
          }
          if(mes1<mes2){
              return "true";
          }
          if(dia1<dia2){
              return "true";
          }
          if(hora_1<hora_2){
              return "true";
          }
          if(minuto_1<minuto_2){
              return "true";
          }
          if(segundo_1<segundo_2){
              return "true";
          }
          return "false";
       }
   return "";    
   }
   private String   Hacer_op_mai(String valor1,String valor2,String tipo1,String tipo2){
       if(tipo1.equals("text")){
          String a = valor1.replace("\"","");
          String b = valor2.replace("\"","");
          if(a.compareTo(b)>=0){
              return "true";
          }
          else{
              return "false";
          }
       }
       if(tipo1.equals("int")){
           int a = Integer.valueOf(valor1);
          if(tipo2.equals("int")){
           int b = Integer.valueOf(valor2);
           if(a>=b){
               return "true";
           }
           else{
               return "false";
           }
          }
          else if(tipo2.equals("int")){
           double b = Double.valueOf(valor2);
           if(a>=b){
               return "true";
           }
           else{
               return "false";
           }
          }
       }
       if(tipo1.equals("double")){
           double a = Double.valueOf(valor1);
          if(tipo2.equals("int")){
           int b = Integer.valueOf(valor2);
           if(a>=b){
               return "true";
           }
           else{
               return "false";
           }
          }
          else if(tipo2.equals("int")){
           double b = Double.valueOf(valor2);
           if(a>=b){
               return "true";
           }
           else{
               return "false";
           }
          }
       }
       if(tipo1.equals("date")){
          String fecha1[] = valor1.replace("'","").split("-");
          String fecha2[] = valor2.replace("'","").split("-");
          int dia1  = Integer.valueOf(fecha1[0]);
          int mes1  = Integer.valueOf(fecha1[1]);
          int anio1 = Integer.valueOf(fecha1[2]);
          int dia2  = Integer.valueOf(fecha2[0]);
          int mes2  = Integer.valueOf(fecha2[1]);
          int anio2 = Integer.valueOf(fecha2[2]);
          if(anio1>=anio2){
              return "true";
          }
          if(mes1>=mes2){
              return "true";
          }
          if(dia1>=dia2){
              return "true";
          }
          return "false";
       }
       if(tipo1.equals("datetime")){
          String phora1[] = valor1.replace("'","").split(" ");
          String phora2[] = valor2.replace("'","").split(" ");
          String fecha1[] = phora1[0].split("-");
          String fecha2[] = phora2[0].split("-");
          String hora1[]  = phora1[1].split(":");
          String hora2[]  = phora2[1].split(":");
          int dia1  = Integer.valueOf(fecha1[0]);
          int mes1  = Integer.valueOf(fecha1[1]);
          int anio1 = Integer.valueOf(fecha1[2]);
          int dia2  = Integer.valueOf(fecha2[0]);
          int mes2  = Integer.valueOf(fecha2[1]);
          int anio2 = Integer.valueOf(fecha2[2]);
          int hora_1 = Integer.valueOf(hora1[0]);
          int minuto_1 = Integer.valueOf(hora1[1]);
          int segundo_1 = Integer.valueOf(hora1[2]);
          int hora_2 = Integer.valueOf(hora2[0]);
          int minuto_2 = Integer.valueOf(hora2[1]);
          int segundo_2 = Integer.valueOf(hora2[2]);
          if(anio1>=anio2){
              return "true";
          }
          if(mes1>=mes2){
              return "true";
          }
          if(dia1>=dia2){
              return "true";
          }
          if(hora_1>=hora_2){
              return "true";
          }
          if(minuto_1>=minuto_2){
              return "true";
          }
          if(segundo_1>=segundo_2){
              return "true";
          }
          return "false";
       }
   return "";    
   }
   private String   Hacer_op_mei(String valor1,String valor2,String tipo1,String tipo2){
       if(tipo1.equals("text")){
          String a = valor1.replace("\"","");
          String b = valor2.replace("\"","");
          if(a.compareTo(b)<=0){
              return "true";
          }
          else{
              return "false";
          }
       }
       if(tipo1.equals("int")){
           int a = Integer.valueOf(valor1);
          if(tipo2.equals("int")){
           int b = Integer.valueOf(valor2);
           if(a<=b){
               return "true";
           }
           else{
               return "false";
           }
          }
          else if(tipo2.equals("int")){
           double b = Double.valueOf(valor2);
           if(a<=b){
               return "true";
           }
           else{
               return "false";
           }
          }
       }
       if(tipo1.equals("double")){
           double a = Double.valueOf(valor1);
          if(tipo2.equals("int")){
           int b = Integer.valueOf(valor2);
           if(a<=b){
               return "true";
           }
           else{
               return "false";
           }
          }
          else if(tipo2.equals("int")){
           double b = Double.valueOf(valor2);
           if(a<=b){
               return "true";
           }
           else{
               return "false";
           }
          }
       }
       if(tipo1.equals("date")){
          String fecha1[] = valor1.replace("'","").split("-");
          String fecha2[] = valor2.replace("'","").split("-");
          int dia1  = Integer.valueOf(fecha1[0]);
          int mes1  = Integer.valueOf(fecha1[1]);
          int anio1 = Integer.valueOf(fecha1[2]);
          int dia2  = Integer.valueOf(fecha2[0]);
          int mes2  = Integer.valueOf(fecha2[1]);
          int anio2 = Integer.valueOf(fecha2[2]);
          if(anio1<=anio2){
              return "true";
          }
          if(mes1<=mes2){
              return "true";
          }
          if(dia1<=dia2){
              return "true";
          }
          return "false";
       }
       if(tipo1.equals("datetime")){
          String phora1[] = valor1.replace("'","").split(" ");
          String phora2[] = valor2.replace("'","").split(" ");
          String fecha1[] = phora1[0].split("-");
          String fecha2[] = phora2[0].split("-");
          String hora1[]  = phora1[1].split(":");
          String hora2[]  = phora2[1].split(":");
          int dia1  = Integer.valueOf(fecha1[0]);
          int mes1  = Integer.valueOf(fecha1[1]);
          int anio1 = Integer.valueOf(fecha1[2]);
          int dia2  = Integer.valueOf(fecha2[0]);
          int mes2  = Integer.valueOf(fecha2[1]);
          int anio2 = Integer.valueOf(fecha2[2]);
          int hora_1 = Integer.valueOf(hora1[0]);
          int minuto_1 = Integer.valueOf(hora1[1]);
          int segundo_1 = Integer.valueOf(hora1[2]);
          int hora_2 = Integer.valueOf(hora2[0]);
          int minuto_2 = Integer.valueOf(hora2[1]);
          int segundo_2 = Integer.valueOf(hora2[2]);
          if(anio1<=anio2){
              return "true";
          }
          if(mes1<=mes2){
              return "true";
          }
          if(dia1<=dia2){
              return "true";
          }
          if(hora_1<=hora_2){
              return "true";
          }
          if(minuto_1<=minuto_2){
              return "true";
          }
          if(segundo_1<=segundo_2){
              return "true";
          }
          return "false";
       }
   return "";    
   }
   private String   Hacer_op_igu(String valor1,String valor2,String tipo1,String tipo2){
       if(tipo1.equals("text")){
          String a = valor1.replace("\"","");
          String b = valor2.replace("\"","");
          if(a.compareTo(b)==0){
              return "true";
          }
          else{
              return "false";
          }
       }
       if(tipo1.equals("int")){
           int a = Integer.valueOf(valor1);
          if(tipo2.equals("int")){
           int b = Integer.valueOf(valor2);
           if(a==b){
               return "true";
           }
           else{
               return "false";
           }
          }
          else if(tipo2.equals("int")){
           double b = Double.valueOf(valor2);
           if(a==b){
               return "true";
           }
           else{
               return "false";
           }
          }
       }
       if(tipo1.equals("double")){
           double a = Double.valueOf(valor1);
          if(tipo2.equals("int")){
           int b = Integer.valueOf(valor2);
           if(a==b){
               return "true";
           }
           else{
               return "false";
           }
          }
          else if(tipo2.equals("int")){
           double b = Double.valueOf(valor2);
           if(a==b){
               return "true";
           }
           else{
               return "false";
           }
          }
       }
       if(tipo1.equals("date")){
          String fecha1[] = valor1.replace("'","").split("-");
          String fecha2[] = valor2.replace("'","").split("-");
          int dia1  = Integer.valueOf(fecha1[0]);
          int mes1  = Integer.valueOf(fecha1[1]);
          int anio1 = Integer.valueOf(fecha1[2]);
          int dia2  = Integer.valueOf(fecha2[0]);
          int mes2  = Integer.valueOf(fecha2[1]);
          int anio2 = Integer.valueOf(fecha2[2]);
          if(anio1!=anio2){
              return "false";
          }
          if(mes1!=mes2){
              return "false";
          }
          if(dia1!=dia2){
              return "false";
          }
          return "true";
       }
       if(tipo1.equals("datetime")){
          String phora1[] = valor1.replace("'","").split(" ");
          String phora2[] = valor2.replace("'","").split(" ");
          String fecha1[] = phora1[0].split("-");
          String fecha2[] = phora2[0].split("-");
          String hora1[]  = phora1[1].split(":");
          String hora2[]  = phora2[1].split(":");
          int dia1  = Integer.valueOf(fecha1[0]);
          int mes1  = Integer.valueOf(fecha1[1]);
          int anio1 = Integer.valueOf(fecha1[2]);
          int dia2  = Integer.valueOf(fecha2[0]);
          int mes2  = Integer.valueOf(fecha2[1]);
          int anio2 = Integer.valueOf(fecha2[2]);
          int hora_1 = Integer.valueOf(hora1[0]);
          int minuto_1 = Integer.valueOf(hora1[1]);
          int segundo_1 = Integer.valueOf(hora1[2]);
          int hora_2 = Integer.valueOf(hora2[0]);
          int minuto_2 = Integer.valueOf(hora2[1]);
          int segundo_2 = Integer.valueOf(hora2[2]);
          if(anio1!=anio2){
              return "false";
          }
          if(mes1!=mes2){
              return "false";
          }
          if(dia1!=dia2){
              return "false";
          }
          if(hora_1!=hora_2){
              return "false";
          }
          if(minuto_1!=minuto_2){
              return "false";
          }
          if(segundo_1!=segundo_2){
              return "false";
          }
          return "true";
       }
   return "";    
   }
   private String   Hacer_op_nig(String valor1,String valor2,String tipo1,String tipo2){
       if(tipo1.equals("text")){
          String a = valor1.replace("\"","");
          String b = valor2.replace("\"","");
          if(a.compareTo(b)!=0){
              return "true";
          }
          else{
              return "false";
          }
       }
       if(tipo1.equals("int")){
           int a = Integer.valueOf(valor1);
          if(tipo2.equals("int")){
           int b = Integer.valueOf(valor2);
           if(a!=b){
               return "true";
           }
           else{
               return "false";
           }
          }
          else if(tipo2.equals("int")){
           double b = Double.valueOf(valor2);
           if(a!=b){
               return "true";
           }
           else{
               return "false";
           }
          }
       }
       if(tipo1.equals("double")){
           double a = Double.valueOf(valor1);
          if(tipo2.equals("int")){
           int b = Integer.valueOf(valor2);
           if(a!=b){
               return "true";
           }
           else{
               return "false";
           }
          }
          else if(tipo2.equals("int")){
           double b = Double.valueOf(valor2);
           if(a!=b){
               return "true";
           }
           else{
               return "false";
           }
          }
       }
       if(tipo1.equals("date")){
          String fecha1[] = valor1.replace("'","").split("-");
          String fecha2[] = valor2.replace("'","").split("-");
          int dia1  = Integer.valueOf(fecha1[0]);
          int mes1  = Integer.valueOf(fecha1[1]);
          int anio1 = Integer.valueOf(fecha1[2]);
          int dia2  = Integer.valueOf(fecha2[0]);
          int mes2  = Integer.valueOf(fecha2[1]);
          int anio2 = Integer.valueOf(fecha2[2]);
          if(anio1==anio2){
              return "false";
          }
          if(mes1==mes2){
              return "false";
          }
          if(dia1==dia2){
              return "false";
          }
          return "true";
       }
       if(tipo1.equals("datetime")){
          String phora1[] = valor1.replace("'","").split(" ");
          String phora2[] = valor2.replace("'","").split(" ");
          String fecha1[] = phora1[0].split("-");
          String fecha2[] = phora2[0].split("-");
          String hora1[]  = phora1[1].split(":");
          String hora2[]  = phora2[1].split(":");
          int dia1  = Integer.valueOf(fecha1[0]);
          int mes1  = Integer.valueOf(fecha1[1]);
          int anio1 = Integer.valueOf(fecha1[2]);
          int dia2  = Integer.valueOf(fecha2[0]);
          int mes2  = Integer.valueOf(fecha2[1]);
          int anio2 = Integer.valueOf(fecha2[2]);
          int hora_1 = Integer.valueOf(hora1[0]);
          int minuto_1 = Integer.valueOf(hora1[1]);
          int segundo_1 = Integer.valueOf(hora1[2]);
          int hora_2 = Integer.valueOf(hora2[0]);
          int minuto_2 = Integer.valueOf(hora2[1]);
          int segundo_2 = Integer.valueOf(hora2[2]);
          if(anio1==anio2){
              return "false";
          }
          if(mes1==mes2){
              return "false";
          }
          if(dia1==dia2){
              return "false";
          }
          if(hora_1==hora_2){
              return "false";
          }
          if(minuto_1==minuto_2){
              return "false";
          }
          if(segundo_1==segundo_2){
              return "false";
          }
          return "true";
       }
   return "";    
   }   
   private String   Hacer_op_and(String valor1,String valor2){
      if(valor1.equalsIgnoreCase("true")&&valor2.equalsIgnoreCase("true")){
          return "true";
      }
      else{
          return "false";
      }
   }
   private String   Hacer_op_or(String valor1,String valor2){
      if(valor1.equalsIgnoreCase("true")||valor2.equalsIgnoreCase("true")){
          return "true";
      }
      else{
          return "false";
      }
   }
   private String   Hacer_op_not(String valor1){
      if(valor1.equalsIgnoreCase("true")){
          return "false";
      }
      else if(valor1.equalsIgnoreCase("false")){
          return "true";
      }
      else{
          return "#*ERROR*#";
      }
   }
}
