package AC;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

public class IdentClass{
    String nombre;
    String type;
    int nivel;

    public IdentClass(String name, String tp, int nivelActual){
        nombre = name;
        type = tp;
        nivel=nivelActual;
    }

}
