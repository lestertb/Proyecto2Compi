package AC;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

import java.util.LinkedList;

public class TablaSimbolos {

    LinkedList<Object> tabla;

    public int nivelActual;


    public TablaSimbolos() {
        tabla = new LinkedList<Object>();
        this.nivelActual=-1;
    }

    public void insertar(Token id, Type tipo, ParserRuleContext decl)
    {
        //no se puede insertar un elemento repetido en el mismo nivel
        Ident i = new Ident(id,tipo,nivelActual,decl);
        tabla.addFirst(i);
    }

    public void insertarIdentClass(String id, String tipo)
    {
        //no se puede insertar un elemento repetido en el mismo nivel
        IdentClass i = new IdentClass(id,tipo,nivelActual);
        tabla.addFirst(i);
    }


    public Ident buscar(String nombre)
    {
        Ident temp = null;
        try {
            for(Object id : tabla)
                if (id.getClass() != IdentClass.class){
                    if (((Ident)id).tok.getText().equals(nombre))
                        return ((Ident)id);
                }
        } catch (Exception ignored){ }
        return temp;
    }

    public IdentClass buscarClass(String nombre)
    {
        IdentClass temp = null;
        try {
            for(Object id : tabla)
                if (id.getClass() != Ident.class){
                    if (((IdentClass)id).nombre.equals(nombre))
                        return ((IdentClass)id);
                }
        } catch (Exception ignored){ }
        return temp;
    }


    public void openScope(){
        nivelActual++;
    }

    public void closeScope(){
        tabla.removeIf(n -> ( (n.getClass() != IdentClass.class) && (((Ident)n).nivel == nivelActual)));
        nivelActual--;
    }

    public void imprimir() {
        System.out.println("----- INICIO TABLA ------");
        for (int i = 0; i < tabla.size(); i++) {
            try {
                Token s = (Token) ((Ident) tabla.get(i)).tok;
                System.out.println("Nombre: " + s.getText() + " - " +"Nivel: " + ((Ident) tabla.get(i)).nivel + " - " +" Tipo: "+((Ident) tabla.get(i)).type);
            } catch (Exception e){
                String s = ((IdentClass) tabla.get(i)).nombre;
                System.out.println("Nombre: " + s + " - " +"Nivel: " + ((IdentClass) tabla.get(i)).nivel + " - " +" Tipo: "+((IdentClass) tabla.get(i)).type);
            }
        }
        System.out.println("----- FIN TABLA ------\n");
    }

}
