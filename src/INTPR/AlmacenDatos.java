package INTPR;

import AC.Ident;
import AC.IdentClass;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.LinkedList;

public class AlmacenDatos {
    LinkedList<Instancia> almacen;

    int nivelActual;

    public AlmacenDatos() {
        this.almacen = new LinkedList<Instancia>();
        this.nivelActual=-1;
    }

    public void agregarInstancia(String n, Object v){
        this.almacen.addFirst(new Instancia(n,v,nivelActual));
    }

    public void agregarInstancia(String n, Object v,ParserRuleContext c ){
        this.almacen.add(new Instancia(n,v,c));
    }

    public Instancia getInstancia(String n){
        for(Instancia id : almacen)
            if (id.nombre.equals(n))
                return id;
        return null;
    }

    public void setInstancia(String n, Object v){
        for(Object id : almacen)
            if (((Instancia)id).nombre.equals(n)){
                ((Instancia) id).valor = v;
                return;
            }
    }

    public void openScope(){
        nivelActual++;
    }

    public void closeScope(){
        almacen.removeIf(n -> (n.nivel == nivelActual));
        nivelActual--;
    }

}
