package AC;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

import java.util.List;

public class Ident{
    Token tok;
    Type type;
    int nivel;
    int valor;
    boolean isInitialize;
    ParserRuleContext declCtx;
    List<ParamMethod> listaParams;

    public Ident(Token t, Type tp, int nivelActual, ParserRuleContext decl, List<ParamMethod> listParamas){
        tok = t;
        type = tp;
        nivel=nivelActual;
        valor = 0;
        isInitialize= false;
        declCtx=decl;
        listaParams = listParamas;
    }

    public void setValue(int v){
        valor = v;
    }

    public int getNivel() {
        return nivel;
    }
}


