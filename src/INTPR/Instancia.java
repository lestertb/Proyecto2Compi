package INTPR;

import org.antlr.v4.runtime.ParserRuleContext;

public class Instancia{
    String nombre;
    Object valor;
    ParserRuleContext ctx;
    int nivel;

    public Instancia(String nombre, Object valor, int nivelActual) {
        this.nombre = nombre;
        this.valor = valor;
        this.ctx = null;
        this.nivel = nivelActual;
    }

    public Instancia(String nombre, Object valor, ParserRuleContext ctx) {
        this.nombre = nombre;
        this.valor = valor;
        this.ctx = ctx;
    }
}