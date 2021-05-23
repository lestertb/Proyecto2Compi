package INTPR;

import org.antlr.v4.runtime.ParserRuleContext;

public class Instancia{
    String nombre;
    Object valor;
    ParserRuleContext ctx;

    public Instancia(String nombre, Object valor) {
        this.nombre = nombre;
        this.valor = valor;
        this.ctx = null;
    }

    public Instancia(String nombre, Object valor, ParserRuleContext ctx) {
        this.nombre = nombre;
        this.valor = valor;
        this.ctx = ctx;
    }
}