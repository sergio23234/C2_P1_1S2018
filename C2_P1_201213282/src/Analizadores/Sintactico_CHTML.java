
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20140808 (SVN rev 54)
//----------------------------------------------------

package Analizadores;

import java.io.FileReader;
import java_cup.runtime.Symbol;
import Principal.NCHTML;
import Principal.Nodo_error;
import java_cup.runtime.*;
import java.util.ArrayList;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20140808 (SVN rev 54) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class Sintactico_CHTML extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  public Sintactico_CHTML() {super();}

  /** Constructor which sets the default scanner. */
  public Sintactico_CHTML(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public Sintactico_CHTML(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\032\000\002\002\004\000\002\003\003\000\002\013" +
    "\010\000\002\023\004\000\002\005\006\000\002\002\006" +
    "\000\002\024\004\000\002\024\004\000\002\024\003\000" +
    "\002\024\003\000\002\026\014\000\002\057\003\000\002" +
    "\057\003\000\002\057\003\000\002\057\003\000\002\030" +
    "\011\000\002\033\005\000\002\033\004\000\002\032\005" +
    "\000\002\054\003\000\002\054\003\000\002\054\003\000" +
    "\002\054\003\000\002\054\003\000\002\054\003\000\002" +
    "\054\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\054\000\004\010\006\001\002\000\004\002\000\001" +
    "\002\000\004\002\056\001\002\000\004\004\010\001\002" +
    "\000\004\010\013\001\002\000\004\011\011\001\002\000" +
    "\004\010\ufffe\001\002\000\004\010\053\001\002\000\004" +
    "\006\014\001\002\000\004\011\015\001\002\000\004\010" +
    "\022\001\002\000\004\010\ufffd\001\002\000\004\010\ufff8" +
    "\001\002\000\004\010\ufff9\001\002\000\004\010\050\001" +
    "\002\000\014\013\030\014\026\015\025\016\023\017\024" +
    "\001\002\000\006\011\ufff5\063\ufff5\001\002\000\004\011" +
    "\041\001\002\000\006\011\ufff6\063\ufff6\001\002\000\006" +
    "\011\ufff3\063\ufff3\001\002\000\004\063\031\001\002\000" +
    "\006\011\ufff4\063\ufff4\001\002\000\004\021\032\001\002" +
    "\000\004\023\033\001\002\000\004\022\034\001\002\000" +
    "\004\011\035\001\002\000\004\010\036\001\002\000\012" +
    "\013\030\014\026\015\025\016\023\001\002\000\004\011" +
    "\040\001\002\000\004\010\ufff7\001\002\000\004\024\042" +
    "\001\002\000\004\010\043\001\002\000\004\020\044\001" +
    "\002\000\004\011\045\001\002\000\004\010\ufff2\001\002" +
    "\000\004\010\ufffb\001\002\000\004\010\ufffa\001\002\000" +
    "\016\012\051\013\030\014\026\015\025\016\023\017\024" +
    "\001\002\000\004\011\052\001\002\000\004\010\ufffc\001" +
    "\002\000\004\005\054\001\002\000\004\011\055\001\002" +
    "\000\004\002\uffff\001\002\000\004\002\001\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\054\000\006\003\004\013\003\001\001\000\002\001" +
    "\001\000\002\001\001\000\004\023\006\001\001\000\004" +
    "\005\011\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\012" +
    "\002\015\024\020\026\016\030\017\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\006\026\045" +
    "\030\046\001\001\000\004\057\026\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\004\057\036\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\004\057\026\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$Sintactico_CHTML$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$Sintactico_CHTML$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$Sintactico_CHTML$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



    public static ArrayList<Nodo_error> Errores = new ArrayList<Nodo_error>();
    public static boolean errores=false;
    protected int error_sync_size () {
       return 1;   
    }

    public void syntax_error(Symbol s){
        System.out.println("Error sintactico lexema \"" + s.value+"\" en la Columna: "+(s.right) +", Linea: "+(s.left+1)+ " no esperado");
        Nodo_error nuevo = new Nodo_error();
        nuevo.dato = String.valueOf(s.value);
        nuevo.linea = (s.left+1);
        nuevo.columna=(s.right);
        Errores.add(nuevo);
        errores=true;
    }

    
    public void unrecovered_syntax_error(Symbol s) throws java.lang.Exception{
        System.out.println("Error sintactico \"" + s.value+"\" en la Linea: "+(s.right+1) +", Columna: "+(s.left+1)+ "");
        Nodo_error nuevo = new Nodo_error();
        nuevo.dato = String.valueOf(s.value);
        nuevo.linea = (s.left+1);
        nuevo.columna=(s.right);
        Errores.add(nuevo);
        errores=true;
    }

 /*codig de usuario */
 String total = "";
 public NCHTML Raiz_CHTML=null;
 //public ArrayList<Nodo> e = new ArrayList<Nodo>();


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$Sintactico_CHTML$actions {


    public String estado="";

  private final Sintactico_CHTML parser;

  /** Constructor */
  CUP$Sintactico_CHTML$actions(Sintactico_CHTML parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$Sintactico_CHTML$do_action_part00000000(
    int                        CUP$Sintactico_CHTML$act_num,
    java_cup.runtime.lr_parser CUP$Sintactico_CHTML$parser,
    java.util.Stack            CUP$Sintactico_CHTML$stack,
    int                        CUP$Sintactico_CHTML$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$Sintactico_CHTML$result;

      /* select the action based on the action number */
      switch (CUP$Sintactico_CHTML$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= Start EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.elementAt(CUP$Sintactico_CHTML$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.elementAt(CUP$Sintactico_CHTML$top-1)).right;
		NCHTML start_val = (NCHTML)((java_cup.runtime.Symbol) CUP$Sintactico_CHTML$stack.elementAt(CUP$Sintactico_CHTML$top-1)).value;
		RESULT = start_val;
              CUP$Sintactico_CHTML$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.elementAt(CUP$Sintactico_CHTML$top-1)), ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$Sintactico_CHTML$parser.done_parsing();
          return CUP$Sintactico_CHTML$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // Start ::= UNO 
            {
              NCHTML RESULT =null;

              CUP$Sintactico_CHTML$result = parser.getSymbolFactory().newSymbol("Start",1, ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()), RESULT);
            }
          return CUP$Sintactico_CHTML$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // UNO ::= INI CUERPO_CHTML ES_EN INI FHTML FIN 
            {
              NCHTML RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.elementAt(CUP$Sintactico_CHTML$top-4)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.elementAt(CUP$Sintactico_CHTML$top-4)).right;
		NCHTML e1 = (NCHTML)((java_cup.runtime.Symbol) CUP$Sintactico_CHTML$stack.elementAt(CUP$Sintactico_CHTML$top-4)).value;
		Raiz_CHTML = e1;
              CUP$Sintactico_CHTML$result = parser.getSymbolFactory().newSymbol("UNO",9, ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.elementAt(CUP$Sintactico_CHTML$top-5)), ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()), RESULT);
            }
          return CUP$Sintactico_CHTML$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // CUERPO_CHTML ::= IHTML FIN 
            {
              NCHTML RESULT =null;
		RESULT = null;
              CUP$Sintactico_CHTML$result = parser.getSymbolFactory().newSymbol("CUERPO_CHTML",17, ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.elementAt(CUP$Sintactico_CHTML$top-1)), ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()), RESULT);
            }
          return CUP$Sintactico_CHTML$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // ES_EN ::= INI IENCA FIN CUERPO_ENCA1 
            {
              NCHTML RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()).right;
		NCHTML e1 = (NCHTML)((java_cup.runtime.Symbol) CUP$Sintactico_CHTML$stack.peek()).value;
		RESULT =e1;
              CUP$Sintactico_CHTML$result = parser.getSymbolFactory().newSymbol("ES_EN",3, ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.elementAt(CUP$Sintactico_CHTML$top-3)), ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()), RESULT);
            }
          return CUP$Sintactico_CHTML$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // CUERPO_ENCA1 ::= CUERPO_ENCA INI FENCA FIN 
            {
              NCHTML RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.elementAt(CUP$Sintactico_CHTML$top-3)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.elementAt(CUP$Sintactico_CHTML$top-3)).right;
		NCHTML e1 = (NCHTML)((java_cup.runtime.Symbol) CUP$Sintactico_CHTML$stack.elementAt(CUP$Sintactico_CHTML$top-3)).value;
		RESULT=e1;
              CUP$Sintactico_CHTML$result = parser.getSymbolFactory().newSymbol("CUERPO_ENCA1",0, ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.elementAt(CUP$Sintactico_CHTML$top-3)), ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()), RESULT);
            }
          return CUP$Sintactico_CHTML$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // CUERPO_ENCA ::= CUERPO_ENCA ESTRUCTURA_CCSS 
            {
              NCHTML RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.elementAt(CUP$Sintactico_CHTML$top-1)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.elementAt(CUP$Sintactico_CHTML$top-1)).right;
		NCHTML e1 = (NCHTML)((java_cup.runtime.Symbol) CUP$Sintactico_CHTML$stack.elementAt(CUP$Sintactico_CHTML$top-1)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()).right;
		NCHTML e2 = (NCHTML)((java_cup.runtime.Symbol) CUP$Sintactico_CHTML$stack.peek()).value;
		NCHTML nuevo=new NCHTML(); nuevo.etiqueta ="encabezado"; NCHTML uno=e1; NCHTML dos=e2; nuevo.hijos.add(uno); nuevo.hijos.add(dos); RESULT = nuevo;
              CUP$Sintactico_CHTML$result = parser.getSymbolFactory().newSymbol("CUERPO_ENCA",18, ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.elementAt(CUP$Sintactico_CHTML$top-1)), ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()), RESULT);
            }
          return CUP$Sintactico_CHTML$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // CUERPO_ENCA ::= CUERPO_ENCA ESTRUCTURA_TITU 
            {
              NCHTML RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.elementAt(CUP$Sintactico_CHTML$top-1)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.elementAt(CUP$Sintactico_CHTML$top-1)).right;
		NCHTML e1 = (NCHTML)((java_cup.runtime.Symbol) CUP$Sintactico_CHTML$stack.elementAt(CUP$Sintactico_CHTML$top-1)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()).right;
		NCHTML e2 = (NCHTML)((java_cup.runtime.Symbol) CUP$Sintactico_CHTML$stack.peek()).value;
		NCHTML nuevo=new NCHTML(); nuevo.etiqueta ="encabezado"; NCHTML uno=e1; NCHTML dos=e2; nuevo.hijos.add(uno); nuevo.hijos.add(dos); RESULT = nuevo;
              CUP$Sintactico_CHTML$result = parser.getSymbolFactory().newSymbol("CUERPO_ENCA",18, ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.elementAt(CUP$Sintactico_CHTML$top-1)), ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()), RESULT);
            }
          return CUP$Sintactico_CHTML$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // CUERPO_ENCA ::= ESTRUCTURA_TITU 
            {
              NCHTML RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()).right;
		NCHTML e1 = (NCHTML)((java_cup.runtime.Symbol) CUP$Sintactico_CHTML$stack.peek()).value;
		RESULT = e1;
              CUP$Sintactico_CHTML$result = parser.getSymbolFactory().newSymbol("CUERPO_ENCA",18, ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()), RESULT);
            }
          return CUP$Sintactico_CHTML$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // CUERPO_ENCA ::= ESTRUCTURA_CCSS 
            {
              NCHTML RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()).right;
		NCHTML e1 = (NCHTML)((java_cup.runtime.Symbol) CUP$Sintactico_CHTML$stack.peek()).value;
		RESULT = e1;
              CUP$Sintactico_CHTML$result = parser.getSymbolFactory().newSymbol("CUERPO_ENCA",18, ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()), RESULT);
            }
          return CUP$Sintactico_CHTML$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // ESTRUCTURA_CCSS ::= INI TIPO_ENCA PRUT SIGU PCOM SPYC FIN INI TIPO_ENCA FIN 
            {
              NCHTML RESULT =null;
		int e2left = ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.elementAt(CUP$Sintactico_CHTML$top-8)).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.elementAt(CUP$Sintactico_CHTML$top-8)).right;
		String e2 = (String)((java_cup.runtime.Symbol) CUP$Sintactico_CHTML$stack.elementAt(CUP$Sintactico_CHTML$top-8)).value;
		int e1left = ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.elementAt(CUP$Sintactico_CHTML$top-5)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.elementAt(CUP$Sintactico_CHTML$top-5)).right;
		Object e1 = (Object)((java_cup.runtime.Symbol) CUP$Sintactico_CHTML$stack.elementAt(CUP$Sintactico_CHTML$top-5)).value;
		NCHTML nuevo=new NCHTML(); nuevo.etiqueta =e2; nuevo.contenido=e1.toString(); RESULT = nuevo;
              CUP$Sintactico_CHTML$result = parser.getSymbolFactory().newSymbol("ESTRUCTURA_CCSS",20, ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.elementAt(CUP$Sintactico_CHTML$top-9)), ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()), RESULT);
            }
          return CUP$Sintactico_CHTML$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // TIPO_ENCA ::= ICCS 
            {
              String RESULT =null;
		RESULT ="CCSS";
              CUP$Sintactico_CHTML$result = parser.getSymbolFactory().newSymbol("TIPO_ENCA",45, ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()), RESULT);
            }
          return CUP$Sintactico_CHTML$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // TIPO_ENCA ::= FCCS 
            {
              String RESULT =null;
		RESULT="CCSS";
              CUP$Sintactico_CHTML$result = parser.getSymbolFactory().newSymbol("TIPO_ENCA",45, ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()), RESULT);
            }
          return CUP$Sintactico_CHTML$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // TIPO_ENCA ::= ICJS 
            {
              String RESULT =null;
		RESULT="CJS";
              CUP$Sintactico_CHTML$result = parser.getSymbolFactory().newSymbol("TIPO_ENCA",45, ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()), RESULT);
            }
          return CUP$Sintactico_CHTML$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // TIPO_ENCA ::= FCJS 
            {
              String RESULT =null;
		RESULT="CJS";
              CUP$Sintactico_CHTML$result = parser.getSymbolFactory().newSymbol("TIPO_ENCA",45, ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()), RESULT);
            }
          return CUP$Sintactico_CHTML$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // ESTRUCTURA_TITU ::= INI ITIT FIN PNOR INI FTIT FIN 
            {
              NCHTML RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.elementAt(CUP$Sintactico_CHTML$top-3)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.elementAt(CUP$Sintactico_CHTML$top-3)).right;
		Object e1 = (Object)((java_cup.runtime.Symbol) CUP$Sintactico_CHTML$stack.elementAt(CUP$Sintactico_CHTML$top-3)).value;
		NCHTML nuevo=new NCHTML(); nuevo.etiqueta ="Titulo"; nuevo.contenido=e1.toString(); RESULT = nuevo;
              CUP$Sintactico_CHTML$result = parser.getSymbolFactory().newSymbol("ESTRUCTURA_TITU",22, ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.elementAt(CUP$Sintactico_CHTML$top-6)), ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()), RESULT);
            }
          return CUP$Sintactico_CHTML$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // ESTRUCTURA_G_CUERPO ::= ESTRUCTURA_G_CUERPO1 SPYC ESTRUCTURA_G_CUERPO 
            {
              NCHTML RESULT =null;
		int e2left = ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.elementAt(CUP$Sintactico_CHTML$top-2)).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.elementAt(CUP$Sintactico_CHTML$top-2)).right;
		NCHTML e2 = (NCHTML)((java_cup.runtime.Symbol) CUP$Sintactico_CHTML$stack.elementAt(CUP$Sintactico_CHTML$top-2)).value;
		int e1left = ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()).right;
		NCHTML e1 = (NCHTML)((java_cup.runtime.Symbol) CUP$Sintactico_CHTML$stack.peek()).value;
		 System.out.println("entro aqui");e2.hijos.add(e1); RESULT = e2;
              CUP$Sintactico_CHTML$result = parser.getSymbolFactory().newSymbol("ESTRUCTURA_G_CUERPO",25, ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.elementAt(CUP$Sintactico_CHTML$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()), RESULT);
            }
          return CUP$Sintactico_CHTML$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // ESTRUCTURA_G_CUERPO ::= ESTRUCTURA_G_CUERPO1 SPYC 
            {
              NCHTML RESULT =null;
		int e2left = ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.elementAt(CUP$Sintactico_CHTML$top-1)).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.elementAt(CUP$Sintactico_CHTML$top-1)).right;
		NCHTML e2 = (NCHTML)((java_cup.runtime.Symbol) CUP$Sintactico_CHTML$stack.elementAt(CUP$Sintactico_CHTML$top-1)).value;
		RESULT = e2;
              CUP$Sintactico_CHTML$result = parser.getSymbolFactory().newSymbol("ESTRUCTURA_G_CUERPO",25, ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.elementAt(CUP$Sintactico_CHTML$top-1)), ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()), RESULT);
            }
          return CUP$Sintactico_CHTML$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // ESTRUCTURA_G_CUERPO1 ::= SUB_ES_G_CUERPO1 SIGU PCOM 
            {
              NCHTML RESULT =null;
		int e2left = ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.elementAt(CUP$Sintactico_CHTML$top-2)).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.elementAt(CUP$Sintactico_CHTML$top-2)).right;
		String e2 = (String)((java_cup.runtime.Symbol) CUP$Sintactico_CHTML$stack.elementAt(CUP$Sintactico_CHTML$top-2)).value;
		int e1left = ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()).right;
		Object e1 = (Object)((java_cup.runtime.Symbol) CUP$Sintactico_CHTML$stack.peek()).value;
		NCHTML nuevo=new NCHTML(); nuevo.etiqueta =e2; nuevo.contenido=e1.toString(); RESULT = nuevo;
              CUP$Sintactico_CHTML$result = parser.getSymbolFactory().newSymbol("ESTRUCTURA_G_CUERPO1",24, ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.elementAt(CUP$Sintactico_CHTML$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()), RESULT);
            }
          return CUP$Sintactico_CHTML$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // SUB_ES_G_CUERPO1 ::= PGRP 
            {
              String RESULT =null;
		RESULT = "grupo";
              CUP$Sintactico_CHTML$result = parser.getSymbolFactory().newSymbol("SUB_ES_G_CUERPO1",42, ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()), RESULT);
            }
          return CUP$Sintactico_CHTML$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // SUB_ES_G_CUERPO1 ::= PID 
            {
              String RESULT =null;
		RESULT = "id";
              CUP$Sintactico_CHTML$result = parser.getSymbolFactory().newSymbol("SUB_ES_G_CUERPO1",42, ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()), RESULT);
            }
          return CUP$Sintactico_CHTML$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // SUB_ES_G_CUERPO1 ::= PALI 
            {
              String RESULT =null;
		RESULT = "alineado";
              CUP$Sintactico_CHTML$result = parser.getSymbolFactory().newSymbol("SUB_ES_G_CUERPO1",42, ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()), RESULT);
            }
          return CUP$Sintactico_CHTML$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // SUB_ES_G_CUERPO1 ::= PALT 
            {
              String RESULT =null;
		RESULT = "alto";
              CUP$Sintactico_CHTML$result = parser.getSymbolFactory().newSymbol("SUB_ES_G_CUERPO1",42, ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()), RESULT);
            }
          return CUP$Sintactico_CHTML$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // SUB_ES_G_CUERPO1 ::= PANC 
            {
              String RESULT =null;
		RESULT = "ancho";
              CUP$Sintactico_CHTML$result = parser.getSymbolFactory().newSymbol("SUB_ES_G_CUERPO1",42, ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()), RESULT);
            }
          return CUP$Sintactico_CHTML$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // SUB_ES_G_CUERPO1 ::= PRUT 
            {
              String RESULT =null;
		RESULT ="ruta";
              CUP$Sintactico_CHTML$result = parser.getSymbolFactory().newSymbol("SUB_ES_G_CUERPO1",42, ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()), RESULT);
            }
          return CUP$Sintactico_CHTML$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // SUB_ES_G_CUERPO1 ::= PCLI 
            {
              String RESULT =null;
		RESULT ="clic";
              CUP$Sintactico_CHTML$result = parser.getSymbolFactory().newSymbol("SUB_ES_G_CUERPO1",42, ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico_CHTML$stack.peek()), RESULT);
            }
          return CUP$Sintactico_CHTML$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$Sintactico_CHTML$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$Sintactico_CHTML$do_action(
    int                        CUP$Sintactico_CHTML$act_num,
    java_cup.runtime.lr_parser CUP$Sintactico_CHTML$parser,
    java.util.Stack            CUP$Sintactico_CHTML$stack,
    int                        CUP$Sintactico_CHTML$top)
    throws java.lang.Exception
    {
              return CUP$Sintactico_CHTML$do_action_part00000000(
                               CUP$Sintactico_CHTML$act_num,
                               CUP$Sintactico_CHTML$parser,
                               CUP$Sintactico_CHTML$stack,
                               CUP$Sintactico_CHTML$top);
    }
}

}
