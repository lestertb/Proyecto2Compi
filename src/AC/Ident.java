package AC;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

public class Ident{
    //esta clase se puede separar para después hacer herencia para meter una lista de los parametros de un método o clases por ejemplo.
    Token tok;
    Type type;
    int nivel;
    int valor;
    ParserRuleContext declCtx;

    public Ident(Token t, Type tp, int nivelActual, ParserRuleContext decl){
        tok = t;
        type = tp;
        nivel=nivelActual;
        valor = 0;
        declCtx=decl;
    }

    public void setValue(int v){
        valor = v;
    }

    public int getNivel() {
        return nivel;
    }
}


