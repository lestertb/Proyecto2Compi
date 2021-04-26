import AC.MiVisitor;
import generated.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import javax.swing.*;
import java.io.IOException;
import java.util.concurrent.ExecutionException;


public class Main {
    public static void main(String[] args) {
        miScanner inst = null;
        miParser parser = null;
        ParseTree tree=null;
        CharStream input=null;
        CommonTokenStream tokens = null;
        try {
            input = CharStreams.fromFileName("test.txt");
            inst = new miScanner(input);
            tokens = new CommonTokenStream(inst);
            parser = new miParser(tokens);
            tree = parser.program();
            //PrettyPrintAST pp = new PrettyPrintAST();

            //MiParserMANUAL parse2 = new MiParserMANUAL(inst);
            //parse2.parseProgram();
            System.out.println("Compilación Terminada!!\n");
            java.util.concurrent.Future<JFrame> treeGUI = org.antlr.v4.gui.Trees.inspect(tree, parser);
            //treeGUI.get().setVisible(true);

            MiVisitor mv = new MiVisitor();
            mv.visit(tree);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}