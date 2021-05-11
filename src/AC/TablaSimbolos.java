package AC;

import generated.miParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

import java.util.LinkedList;

public class TablaSimbolos {

    LinkedList<Object> tabla;

    public int nivelActual;

    public String nombreClass;

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

    public void insertarClass(TablaSimbolos tablaClass)
    {
        tabla.addFirst(tablaClass);
    }

    public Ident buscar(String nombre)
    {
        Ident temp = null;
        try {
            for(Object id : tabla)
                if (((Ident)id).tok.getText().equals(nombre))
                    return ((Ident)id);
        } catch (Exception ignored){ }
        return temp;
    }

    public void openScope(){
        nivelActual++;
    }

    public void closeScope(){
        try{
            tabla.removeIf(n -> (((Ident)n).nivel == nivelActual));
            nivelActual--;
        }catch (Exception ignored){ }

    }

    //Aquí intentar devolver las variables que se crearon segun el nombre de la clase para asignarlas a una variable
    //Y poder accederla tipo var.x
    public void obtenerListaVariables(){

    }

    public void imprimir() {
        System.out.println("----- INICIO TABLA ------");
        for (int i = 0; i < tabla.size(); i++) {
            if (tabla.get(i).getClass() != TablaSimbolos.class){
                Token s = (Token) ((Ident) tabla.get(i)).tok;
                System.out.println("Nombre: " + s.getText() + " - " +"Nivel: " + ((Ident) tabla.get(i)).nivel + " - " +" Tipo: "+((Ident) tabla.get(i)).type);
            }
        }
        System.out.println("----- FIN TABLA ------\n");
    }

    public void imprimirTablaClass(String nombreClass) {
        System.out.println("----- INICIO TABLA " + nombreClass +" ------");
        for (int i = 0; i < tabla.size(); i++) {
            Token s = (Token) ((Ident) tabla.get(i)).tok;
            System.out.println("Nombre: " + s.getText() + " - " +"Nivel: " + ((Ident) tabla.get(i)).nivel + " - " +" Tipo: "+((Ident) tabla.get(i)).type);
        }
        System.out.println("----- FIN TABLA " + nombreClass +" ------\n");
    }

}
