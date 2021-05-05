package AC;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

import java.util.LinkedList;

public class TablaSimbolos {

    LinkedList<Object> tabla;

    private int nivelActual;

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

    public Ident buscar(String nombre)
    {
        Ident temp=null;
        for(Object id : tabla)
            if (((Ident)id).tok.getText().equals(nombre))
                return ((Ident)id);
        return temp;
    }

    public void openScope(){
        nivelActual++;
    }

    public void closeScope(){
        tabla.removeIf(n -> (((Ident)n).nivel == nivelActual));
        nivelActual--;
    }

    public void imprimir() {
        System.out.println("----- INICIO TABLA ------");
        for (int i = 0; i < tabla.size(); i++) {
            Token s = (Token) ((Ident) tabla.get(i)).tok;
            System.out.println("Nombre: " + s.getText() + " - " +"Nivel: " + ((Ident) tabla.get(i)).nivel + " - " +" Tipo: "+((Ident) tabla.get(i)).type);
        }
        System.out.println("----- FIN TABLA ------");
    }

}
