package AC;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

public class Ident{
    Token tok;
    Type type;
    int nivel;
    int valor;
    boolean isInitialize;
    ParserRuleContext declCtx;

    public Ident(Token t, Type tp, int nivelActual, ParserRuleContext decl){
        tok = t;
        type = tp;
        nivel=nivelActual;
        valor = 0;
        isInitialize= false;
        declCtx=decl;
    }

    public void setValue(int v){
        valor = v;
    }

    public int getNivel() {
        return nivel;
    }
}


