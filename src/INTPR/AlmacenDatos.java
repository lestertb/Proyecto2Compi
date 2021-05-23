package INTPR;

import org.antlr.v4.runtime.ParserRuleContext;

import java.util.LinkedList;

public class AlmacenDatos {
    LinkedList<Instancia> almacen;

    public AlmacenDatos() {
        this.almacen = new LinkedList<Instancia>();
    }

    public void agregarInstancia(String n, Object v){
        this.almacen.add(new Instancia(n,v));
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
            if (((Instancia)id).nombre.equals(n))
                ((Instancia) id).valor = v;
    }
}
