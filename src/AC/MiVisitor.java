package AC;

import generated.miParser;
import generated.miParserBaseVisitor;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.tree.ParseTree;

import java.sql.SQLOutput;
import java.util.concurrent.ExecutionException;

public class MiVisitor extends miParserBaseVisitor<Object> {

    private TablaSimbolos tabla;

    public MiVisitor() {
        tabla = new TablaSimbolos();
    }

    @Override public Object visitProgramAST(miParser.ProgramASTContext ctx) {
        tabla.openScope();
        for( miParser.StatementContext context : ctx.statement()) {
            this.visit(context);
        }
        tabla.imprimir();
        tabla.closeScope();
        return null;
    }

    @Override public Object visitVariableDeclarationST(miParser.VariableDeclarationSTContext ctx) {
        this.visit(ctx.variableDeclaration());
        return null;
    }

    @Override public Object visitClassDeclarationST(miParser.ClassDeclarationSTContext ctx) {
        this.visit(ctx.classDeclaration());
        return null;
    }

    @Override public Object visitAssignmentST(miParser.AssignmentSTContext ctx) {
        this.visit(ctx.assignment());
        return null;
    }

    @Override public Object visitArrayAssignmentST(miParser.ArrayAssignmentSTContext ctx) {
        this.visit(ctx.arrayAssignment());
        return null;
    }

    @Override public Object visitPrintStatementST(miParser.PrintStatementSTContext ctx) {
        visit(ctx.printStatement());
        return null;
    }

    @Override public Object visitIfStatementST(miParser.IfStatementSTContext ctx) {
        visit(ctx.ifStatement());
        return null;
    }

    @Override public Object visitWhileStatementST(miParser.WhileStatementSTContext ctx) {
        visit(ctx.whileStatement());
        return null;
    }

    @Override public Object visitReturnStatementST(miParser.ReturnStatementSTContext ctx) {
        visit(ctx.returnStatement());
        return null;
    }

    @Override public Object visitFunctionDeclarationST(miParser.FunctionDeclarationSTContext ctx) {
        visit(ctx.functionDeclaration());
        return null;
    }

    @Override public Object visitBlockST(miParser.BlockSTContext ctx) {
        visit(ctx.block());
        return null;
    }

    @Override public Object visitBlockAST(miParser.BlockASTContext ctx) {
        for(miParser.StatementContext c: ctx.statement())
            this.visit(c);
        return null;
    }

    @Override public Object visitFunctionDeclarationAST(miParser.FunctionDeclarationASTContext ctx) {
        this.visit(ctx.type());
        this.visit(ctx.formalParams());
        this.visit(ctx.block());
        return null;
    }

    @Override public Object visitFormalParamsAST(miParser.FormalParamsASTContext ctx) {
        for(miParser.FormalParamContext c: ctx.formalParam()){
            this.visit(c);
        }
        return null;
    }

    @Override public Object visitFormalParamAST(miParser.FormalParamASTContext ctx) {
        this.visit(ctx.type());
        return null;
    }

    @Override public Object visitWhileStatementAST(miParser.WhileStatementASTContext ctx) {
        this.visit(ctx.expression());
        this.visit(ctx.block());
        return null;
    }

    @Override public Object visitIfStatementAST(miParser.IfStatementASTContext ctx) {
        this.visit(ctx.expression());
        this.visit(ctx.block(0));
        this.visit(ctx.block(1));
        return null;
    }

    @Override public Object visitReturnStatementAST(miParser.ReturnStatementASTContext ctx) {
        this.visit(ctx.expression());
        return null;
    }

    @Override public Object visitPrintStatementAST(miParser.PrintStatementASTContext ctx) {
        this.visit(ctx.expression());
        return null;
    }

    @Override public Object visitClassDeclarationAST(miParser.ClassDeclarationASTContext ctx) {
        for(miParser.ClassVariableDeclarationContext c : ctx.classVariableDeclaration())
            this.visit(c);
        return null;
    }

    @Override public Object visitClassVariableDeclarationAST(miParser.ClassVariableDeclarationASTContext ctx) {
        return null;
    }

    @Override public Object visitVariableDeclarationAST(miParser.VariableDeclarationASTContext ctx) {
        Object attr = this.visit(ctx.type());
        if(attr != null){
            tabla.insertar(ctx.ID().getSymbol(), (Type) attr,ctx);
        }
        Object typeAssign = this.visit(ctx.expression());
        if (typeAssign != null){
            if ( attr == Type.BOOLEAN){
                if (typeAssign != Type.TRUE){
                    if (typeAssign != Type.FALSE)
                        System.out.println("Tipos incompatibles para la asignación ( " + attr+ ", "+typeAssign + " )");
                }
            }
            else if (attr != typeAssign){
                System.out.println("Tipos incompatibles para la asignación ( " + attr+ ", "+typeAssign + " )");
            }
        }else {
            System.out.println("Tipos incompatibles para la asignación ( " + attr+ ", "+ " Dato no reconocido" + " )");
        }
        return null;
    }

    @Override public Object visitSimpleTypeTAST(miParser.SimpleTypeTASTContext ctx) {
        return this.visit(ctx.simpleType());
    }

    @Override public Object visitArrayTypeTAST(miParser.ArrayTypeTASTContext ctx) {
        this.visit(ctx.arrayType());
        return null;
    }

    @Override public Object visitIdTAST(miParser.IdTASTContext ctx) {
        return ctx.ID();
    }

    @Override public Object visitBooleanSTAST(miParser.BooleanSTASTContext ctx) { return Type.BOOLEAN; }

    @Override public Object visitCharSTAST(miParser.CharSTASTContext ctx) { return null; }

    @Override public Object visitIntSTAST(miParser.IntSTASTContext ctx) {
        return Type.INT;
    }

    @Override public Object visitStringSTAST(miParser.StringSTASTContext ctx) {
        return Type.STRING;
    }

    @Override public Object visitArrayTypeAST(miParser.ArrayTypeASTContext ctx) { return Type.ARRAY; }

    @Override public Object visitAssignmentAST(miParser.AssignmentASTContext ctx) {
        Ident id = tabla.buscar(ctx.ID().get(0).toString());
        if (id == null){
            System.out.println("\""+ctx.ID().get(0).toString()+"\" no ha sido declarado");
            //throw new RuntimeException();
        }
        visit(ctx.expression());
        return null;
    }

    @Override public Object visitArrayAssignmentAST(miParser.ArrayAssignmentASTContext ctx) {
        this.visit(ctx.expression(0));
        this.visit(ctx.expression(1));
        return null;
    }
    int cantImErr = 0;
    @Override public Object visitExpressionAST(miParser.ExpressionASTContext ctx) {
        Type exprType = null;
        Type exprType2 = null;
        try {
            exprType = (Type) this.visit(ctx.simpleExpression(0));
            for (int i = 1; i <ctx.simpleExpression().size() ; i++) {
                exprType2 = (Type) this.visit(ctx.simpleExpression(i));
                if(
                        ctx.REOPERATOR().get(0).toString().equals("<") || ctx.REOPERATOR().get(0).toString().equals(">")
                        || ctx.REOPERATOR().get(0).toString().equals("<=") || ctx.REOPERATOR().get(0).toString().equals(">=")
                ){
                    if(exprType != Type.INT || exprType2 != Type.INT){
                        System.out.println("Error en uso de operadores relacionales( < , > , <= , >= ) para: ( " + exprType+ ", "+exprType2 + " )");
                    }
                }else if(ctx.REOPERATOR().get(0).toString().equals("==") || ctx.REOPERATOR().get(0).toString().equals("!=")) {
                    if (exprType == Type.TRUE || exprType == Type.FALSE){
                        if(exprType2 != Type.TRUE){
                            if (exprType2 != Type.FALSE)
                                System.out.println("Error en uso de operadores relacionales para: ( " + exprType+ ", "+exprType2 + " )");
                        }
                    }else if (exprType2 == Type.TRUE || exprType2 == Type.FALSE){
                        System.out.println("Error en uso de operadores relacionales para: ( " + exprType+ ", "+exprType2 + " )");
                    }else if (exprType != exprType2)
                        System.out.println("Error en uso de operadores relacionales( == , != ) para: ( " + exprType+ ", "+exprType2 + " )");
                }
            }
        }
        catch(Exception e) {
            Object exprDiffType =  this.visit(ctx.simpleExpression(0));
            Object exprDiffType2 = null;
            int sonVariables = 0;
            Ident id1 = tabla.buscar(exprDiffType.toString());
            for (int i = 1; i <ctx.simpleExpression().size() ; i++) {
                exprDiffType2 = this.visit(ctx.simpleExpression(i));
                Ident id2 = tabla.buscar(exprDiffType2.toString());
                if (id1 == null){
                    sonVariables=2;
                    try{ Type test = (Type)exprDiffType;}
                    catch (Exception e2){
                        cantImErr++;
                        System.out.println("Error en uso de operadores relacionales para: ( " + exprDiffType+ ", "+ exprDiffType2 + " )");
                        System.out.println("Error: " + exprDiffType + ": No se reconoce");
                    }
                }
                if (id2 == null){
                    sonVariables=1;
                    try{
                        Type test = (Type)exprDiffType2;
                    }catch (Exception e2){
                        if (cantImErr < 1)
                            System.out.println("Error en uso de operadores relacionales para: ( " + exprDiffType+ ", "+ exprDiffType2 + " )");
                        System.out.println("Error: " + exprDiffType2 + ": No se reconoce");
                    }
                }
                if (sonVariables == 0){ //Ambas variables
                    if(ctx.REOPERATOR().get(0).toString().equals("<") || ctx.REOPERATOR().get(0).toString().equals(">") || ctx.REOPERATOR().get(0).toString().equals("<=") || ctx.REOPERATOR().get(0).toString().equals(">=")){
                        if(id1.type != Type.INT || id2.type != Type.INT)
                            System.out.println("Error en uso de operadores relacionales( < , > , <= , >= ) para: ( " + id1.tok.getText()+ ": "+ id1.type + ", "+id2.tok.getText() +": "+ id2.type + " )");

                    }else if(ctx.REOPERATOR().get(0).toString().equals("==") || ctx.REOPERATOR().get(0).toString().equals("!=")) {
                        if (id1.type == Type.BOOLEAN){
                            if(id2.type != Type.BOOLEAN)
                                System.out.println("Error en uso de operadores relacionales( == , != ) para: ( " + id1.tok.getText()+ ": "+ id1.type + ", "+id2.tok.getText() +": "+ id2.type + " )");
                        }else if (id2.type  == Type.BOOLEAN){
                            System.out.println("Error en uso de operadores relacionales( == , != ) para: ( " + id1.tok.getText()+ ": "+ id1.type + ", "+id2.tok.getText() +": "+ id2.type + " )");
                        }else if (id1.type != id2.type)
                            System.out.println("Error en uso de operadores relacionales( == , != ) para: ( " + id1.tok.getText()+ ": "+ id1.type + ", "+id2.tok.getText() +": "+ id2.type + " )");
                    }
                }
                if (sonVariables == 1){ //La primera es variable
                    if(ctx.REOPERATOR().get(0).toString().equals("<") || ctx.REOPERATOR().get(0).toString().equals(">") || ctx.REOPERATOR().get(0).toString().equals("<=") || ctx.REOPERATOR().get(0).toString().equals(">=")){
                        assert id1 != null;
                        if(id1.type != Type.INT || exprDiffType2 != Type.INT)
                            System.out.println("Error en uso de operadores relacionales( < , > , <= , >= ) para: ( " + id1.tok.getText()+ ": "+ id1.type + ", "+exprDiffType2 + " )");
                    }else if(ctx.REOPERATOR().get(0).toString().equals("==") || ctx.REOPERATOR().get(0).toString().equals("!=")) {
                        assert id1 != null;
                        if (id1.type == Type.BOOLEAN){
                            if(exprDiffType2 != Type.TRUE){
                                if (exprDiffType2 != Type.FALSE)
                                    System.out.println("Error en uso de operadores relacionales( == , != ) para: ( " + id1.tok.getText()+ ": "+ id1.type + ", "+exprDiffType2 + " )");
                            }
                        }else if (exprDiffType2  == Type.TRUE || exprDiffType2  == Type.FALSE){
                            System.out.println("Error en uso de operadores relacionales( == , != ) para: ( " + id1.tok.getText()+ ": "+ id1.type + ", "+exprDiffType2 + " )");
                        }else if (id1.type != exprDiffType2)
                            System.out.println("Error en uso de operadores relacionales( == , != ) para: ( " + id1.tok.getText()+ ": "+ id1.type + ", "+exprDiffType2 + " )");
                    }

                }
                if (sonVariables == 2){ //La segunda es variable

                    if(ctx.REOPERATOR().get(0).toString().equals("<") || ctx.REOPERATOR().get(0).toString().equals(">") || ctx.REOPERATOR().get(0).toString().equals("<=") || ctx.REOPERATOR().get(0).toString().equals(">=")){

                        if(exprDiffType != Type.INT || id2.type != Type.INT)
                            System.out.println("Error en uso de operadores relacionales( < , > , <= , >= ) para: ( " +exprDiffType + ", " + id2.tok.getText()+ ": "+ id2.type + " )");

                    }else if(ctx.REOPERATOR().get(0).toString().equals("==") || ctx.REOPERATOR().get(0).toString().equals("!=")) {
                        if (exprDiffType == Type.TRUE || exprDiffType == Type.FALSE){
                            if(id2.type != Type.BOOLEAN){
                                    System.out.println("Error en uso de operadores relacionales( == , != ) para: ( " +exprDiffType + ", " + id2.tok.getText()+ ": "+ id2.type + " )");
                            }
                        }else if (id2.type  == Type.BOOLEAN){
                            System.out.println("Error en uso de operadores relacionales( == , != ) para: ( " +exprDiffType + ", " + id2.tok.getText()+ ": "+ id2.type + " )");
                        }else if (exprDiffType != id2.type)
                            System.out.println("Error en uso de operadores relacionales( == , != ) para: ( " +exprDiffType + ", " + id2.tok.getText()+ ": "+ id2.type + " )");
                    }
                }
            }
        }
        return exprType; //Posible error ver que retorno en visitSimpleExpressionAST
    }
    int cantImp;
    int cantImpErrorSE;
    @Override public Object visitSimpleExpressionAST(miParser.SimpleExpressionASTContext ctx) {
        Type termType = null;
        Type termType2 = null;
        try {
            termType = (Type) this.visit(ctx.term(0));
            for (int i = 1; i <ctx.term().size() ; i++) {
                termType2 = (Type) this.visit(ctx.term(i));
                switch (ctx.ADDITIVEOP().get(0).toString()) {
                    case "or":
                        if (termType != Type.INT) {
                            if (termType != Type.TRUE)
                                if (termType != Type.FALSE) {
                                    if (cantImpErrorSE < 1) {
                                        cantImpErrorSE++;
                                        System.out.println("Error en uso de operadores aditivos( or ) para: ( " + termType + ", " + termType2 + " )");
                                    }
                                }
                        }
                        if (termType2 != Type.INT) {
                            if (termType2 != Type.TRUE)
                                if (termType2 != Type.FALSE){
                                    if (cantImpErrorSE < 1) {
                                        cantImpErrorSE++;
                                        System.out.println("Error en uso de operadores aditivos( or ) para: ( " + termType + ", " + termType2 + " )");
                                    }
                                }
                        }
                        break;
                    case "+":
                        if (termType == Type.INT && termType2 != Type.INT)
                            System.out.println("Error en uso de operadores aditivos( + ) para: ( " + termType + ", " + termType2 + " )");
                        if (termType == Type.STRING && termType2 != Type.STRING)
                            System.out.println("Error en uso de operadores aditivos( + ) para: ( " + termType + ", " + termType2 + " )");
                        break;
                    case "-":
                        if (termType != Type.INT || termType2 != Type.INT) {
                            System.out.println("Error en uso de operadores aditivos( - ) para: ( " + termType + ", " + termType2 + " )");
                        }
                        break;
                }
            }
        }catch(Exception e){
            Object termDiffType =  this.visit(ctx.term(0));
            Object termDiffType2 = null;
            int sonVariables = 0;
            Ident id1 = tabla.buscar(termDiffType.toString());
            for (int i = 1; i <ctx.term().size() ; i++) {
                termDiffType2 = this.visit(ctx.term(i));
                Ident id2 = tabla.buscar(termDiffType2.toString());
                if (id1 == null){
                    sonVariables=2;
                    try{ Type test = (Type)termDiffType;}
                    catch (Exception e2){
                        cantImp++;
                        System.out.println("Error en uso de operadores aditivos para: ( " + termDiffType+ ", "+ termDiffType2 + " )");
                        System.out.println("Error, " + termDiffType + ": No se reconoce");
                    }
                }
                if (id2 == null){
                    sonVariables=1;
                    try{
                        Type test = (Type)termDiffType2;
                    }catch (Exception e2){
                        if (cantImp < 1)
                            System.out.println("Error en uso de operadores aditivos para: ( " + termDiffType+ ", "+ termDiffType2 + " )");
                        System.out.println("Error, " + termDiffType2 + ": No se reconoce");
                    }
                }
                if (sonVariables == 0){//Ambas variables
                    switch (ctx.ADDITIVEOP().get(0).toString()) {
                        case "or":
                            if (id1.type != Type.INT) {
                                if (id1.type != Type.BOOLEAN){
                                    if(cantImpErrorSE < 1){
                                        cantImpErrorSE++;
                                        System.out.println("Error, en uso de operadores aditivos( or ) para: ( " + id1.tok.getText()+ ": "+ id1.type + ", "+id2.tok.getText() +": "+ id2.type + " )");
                                    }
                                }
                            }
                            if (id2.type != Type.INT) {
                                if (id2.type != Type.BOOLEAN){
                                    if(cantImpErrorSE < 1){
                                        cantImpErrorSE++;
                                        System.out.println("Error en uso de operadores aditivos( or ) para: ( " + id1.tok.getText()+ ": "+ id1.type + ", "+id2.tok.getText() +": "+ id2.type + " )");
                                    }
                                }
                            }
                            break;
                        case "+":
                            if (id1.type == Type.INT && id2.type != Type.INT){
                                if(cantImpErrorSE < 1){
                                    cantImpErrorSE++;
                                    System.out.println("Error en uso de operadores aditivos( + ) para: ( " + id1.tok.getText()+ ": "+ id1.type + ", "+id2.tok.getText() +": "+ id2.type + " )");
                                }
                            }
                            if (id1.type == Type.STRING && id2.type != Type.STRING){
                                if(cantImpErrorSE < 1){
                                    cantImpErrorSE++;
                                    System.out.println("Error en uso de operadores aditivos( + ) para: ( " + id1.tok.getText()+ ": "+ id1.type + ", "+id2.tok.getText() +": "+ id2.type + " )");
                                }
                            }
                            break;
                        case "-":
                            if (id1.type != Type.INT || id2.type != Type.INT) {
                                if(cantImpErrorSE < 1){
                                    cantImpErrorSE++;
                                    System.out.println("Error en uso de operadores aditivos( - ) para: ( " + id1.tok.getText()+ ": "+ id1.type + ", "+id2.tok.getText() +": "+ id2.type + " )");
                                }
                            }
                            break;
                        }

                    }
                if (sonVariables == 1){ //La primera es variable

                    switch (ctx.ADDITIVEOP().get(0).toString()) {
                        case "or" -> {
                            assert id1 != null;
                            if (id1.type != Type.INT) {
                                if (id1.type != Type.BOOLEAN) {
                                    if (cantImpErrorSE < 1) {
                                        cantImpErrorSE++;
                                        System.out.println("Error en uso de operadores aditivos( or ) para: ( " + id1.tok.getText() + ": " + id1.type + ", " + termDiffType2 + " )");
                                    }
                                }
                            } if (termDiffType2 != Type.INT) {
                                if (termDiffType2 != Type.TRUE) {
                                    if(termDiffType2 != Type.FALSE){
                                        if (cantImpErrorSE < 1) {
                                            cantImpErrorSE++;
                                            System.out.println("Error en uso de operadores aditivos( or ) para: ( " + id1.tok.getText() + ": " + id1.type + ", " + termDiffType2 + " )");
                                        }
                                    }
                                }
                            }
                        }
                        case "+" -> {
                            assert id1 != null;
                            if (id1.type == Type.INT && termDiffType2 != Type.INT) {
                                if (cantImpErrorSE < 1) {
                                    cantImpErrorSE++;
                                    System.out.println("Error en uso de operadores aditivos( + ) para: ( " + id1.tok.getText() + ": " + id1.type + ", " + termDiffType2 + " )");
                                }
                            }
                            if (id1.type == Type.STRING && termDiffType2 != Type.STRING) {
                                if (cantImpErrorSE < 1) {
                                    cantImpErrorSE++;
                                    System.out.println("Error en uso de operadores aditivos( + ) para: ( " + id1.tok.getText() + ": " + id1.type + ", " + termDiffType2 + " )");
                                }
                            }
                        }
                        case "-" -> {
                            assert id1 != null;
                            if (id1.type != Type.INT || termDiffType2 != Type.INT) {
                                if (cantImpErrorSE < 1) {
                                    cantImpErrorSE++;
                                    System.out.println("Error en uso de operadores aditivos( - ) para: ( " + id1.tok.getText() + ": " + id1.type + ", " + termDiffType2 + " )");
                                }
                            }
                        }
                    }

                }

                if (sonVariables == 2){ //La segunda es variable

                    switch (ctx.ADDITIVEOP().get(0).toString()) {
                        case "or":
                            if (termDiffType != Type.INT) {
                                if (termDiffType != Type.TRUE){
                                    if(termDiffType != Type.FALSE){
                                        if(cantImpErrorSE < 1){
                                            cantImpErrorSE++;
                                            System.out.println("Error en uso de operadores aditivos( or ) para: ( " + termDiffType + ", "+id2.tok.getText() +": "+ id2.type + " )");
                                        }
                                    }
                                }
                            }
                            if (id2.type != Type.INT) {
                                if (id2.type != Type.BOOLEAN){
                                    if(cantImpErrorSE < 1){
                                        cantImpErrorSE++;
                                        System.out.println("Error en uso de operadores aditivos( or ) para: ( " + termDiffType + ", "+id2.tok.getText() +": "+ id2.type + " )");
                                    }
                                }
                            }
                            break;
                        case "+":
                            if (termDiffType == Type.INT && id2.type != Type.INT){
                                if(cantImpErrorSE < 1){
                                    cantImpErrorSE++;
                                    System.out.println("Error en uso de operadores aditivos( + ) para: ( " + termDiffType + ", "+id2.tok.getText() +": "+ id2.type + " )");
                                }
                            }
                            if (termDiffType == Type.STRING && id2.type != Type.STRING){
                                if(cantImpErrorSE < 1){
                                    cantImpErrorSE++;
                                    System.out.println("Error en uso de operadores aditivos( + ) para: ( " + termDiffType + ", "+id2.tok.getText() +": "+ id2.type + " )");
                                }
                            }
                            break;
                        case "-":
                            if (termDiffType != Type.INT || id2.type != Type.INT) {
                                if(cantImpErrorSE < 1){
                                    cantImpErrorSE++;
                                    System.out.println("Error en uso de operadores aditivos( - ) para: ( " + termDiffType + ", "+id2.tok.getText() +": "+ id2.type + " )");
                                }
                            }
                            break;
                    }

                }

            }
        }
        return this.visit(ctx.term(0));
    }
    int cantImp2;
    int cantImp3;
    int cantImpErrorT;
    int cantImpVE;
    @Override public Object visitTermAST(miParser.TermASTContext ctx) {
        Type factType = null;
        Type factType2 = null;
        try {
            factType = (Type) this.visit(ctx.factor(0));
            for (int i = 1; i <ctx.factor().size() ; i++) {
                cantImp2++;
                factType2 = (Type) this.visit(ctx.factor(i));
                if(ctx.MULTIPLICATEOP().get(0).toString().equals("and")){
                    if(factType != Type.INT ){
                        if (factType != Type.TRUE)
                            if (factType != Type.FALSE)
                                if (cantImp2 < 2)
                                    System.out.println("Error en uso de operadores multiplicativos ( and ) para: ( " + factType+ ", "+factType2 + " )");
                    }
                    if(factType2 != Type.INT ){
                        if (factType2 != Type.TRUE)
                            if (factType2 != Type.FALSE)
                                if (cantImp2 < 2)
                                    System.out.println("Error en uso de operadores multiplicativos ( and ) para: ( " + factType+ ", "+factType2 + " )");
                    }
                }else{
                    if (ctx.MULTIPLICATEOP().get(0).toString().equals("*") || ctx.MULTIPLICATEOP().get(0).toString().equals("/")) {
                        if (factType != Type.INT || factType2 != Type.INT){
                            if (cantImp2 < 2)
                                System.out.println("Error en uso de operadores multiplicativos ( * , / ) para: ( " + factType + ", " + factType2 + " )");
                        }
                    }
                }
            }

        } catch (Exception e){
            Object factDiffType =  this.visit(ctx.factor(0));
            Object factDiffType2 = null;
            int sonVariables = 0;
            Ident id1 = tabla.buscar(factDiffType.toString());
            for (int i = 1; i <ctx.factor().size() ; i++) {
                cantImp2++;
                factDiffType2 = this.visit(ctx.factor(i));
                Ident id2 = tabla.buscar(factDiffType2.toString());
                if (id1 == null){
                    sonVariables=2;
                    try{ Type test = (Type)factDiffType;}
                    catch (Exception e2){
                        if (cantImpErrorT < 1){
                            cantImpErrorT++;
                            cantImp3++;
                            System.out.println("Error en uso de operadores multiplicativos para: ( " + factDiffType+ ", "+ factDiffType2 + " )");
                            System.out.println("Error, " + factDiffType + ": No se reconoce");
                        }
                    }
                }
                if (id2 == null){
                    sonVariables=1;
                    try{
                        Type test = (Type)factDiffType2;
                    }catch (Exception e2){
                        if (cantImpErrorT < 2){
                            if (cantImp3 < 1)
                                System.out.println("Error en uso de operadores multiplicativos para: ( " + factDiffType+ ", "+ factDiffType2 + " )");
                            if(cantImpVE < 1) {
                                cantImpVE++;
                                System.out.println("Error, " + factDiffType2 + ": No se reconoce");
                            }
                        }
                    }
                }

                if (sonVariables == 0){//Ambas variables

                    if(ctx.MULTIPLICATEOP().get(0).toString().equals("and")){
                        if(id1.type != Type.INT ){
                            if (id1.type != Type.BOOLEAN)
                                    if (cantImp2 < 2)
                                        System.out.println("Error, en uso de operadores multiplicativos ( and ) para: ( " + id1.tok.getText()+ ": "+ id1.type + ", "+id2.tok.getText() +": "+ id2.type + " )");
                        }
                        if(id2.type != Type.INT ){
                            if (id2.type != Type.BOOLEAN)
                                    if (cantImp2 < 2)
                                        System.out.println("Error en uso de operadores multiplicativos ( and ) para: ( " + id1.tok.getText()+ ": "+ id1.type + ", "+id2.tok.getText() +": "+ id2.type + " )");
                        }
                    }else{
                        if (ctx.MULTIPLICATEOP().get(0).toString().equals("*") || ctx.MULTIPLICATEOP().get(0).toString().equals("/")) {
                            if (id1.type != Type.INT || id2.type != Type.INT){
                                if (cantImp2 < 2)
                                    System.out.println("Error en uso de operadores multiplicativos ( * , / ) para: ( " + id1.tok.getText()+ ": "+ id1.type + ", "+id2.tok.getText() +": "+ id2.type + " )");
                            }
                        }
                    }

                }

                if (sonVariables == 1){ //La primera es variable

                    if(ctx.MULTIPLICATEOP().get(0).toString().equals("and")){
                        assert id1 != null;
                        if(id1.type != Type.INT ){
                            if (id1.type != Type.BOOLEAN)
                                if (cantImp2 < 2)
                                    System.out.println("Error, en uso de operadores multiplicativos ( and ) para: ( " + id1.tok.getText()+ ": "+ id1.type + ", "+ factDiffType2 + " )");
                        }
                        if(factDiffType2 != Type.INT ){
                            if (factDiffType2 != Type.TRUE)
                                if (factDiffType2 != Type.FALSE)
                                    if (cantImp2 < 2)
                                        System.out.println("Error en uso de operadores multiplicativos ( and ) para: ( " + id1.tok.getText()+ ": "+ id1.type + ", "+ factDiffType2 + " )");
                        }
                    }else{
                        if (ctx.MULTIPLICATEOP().get(0).toString().equals("*") || ctx.MULTIPLICATEOP().get(0).toString().equals("/")) {
                            assert id1 != null;
                            if (id1.type != Type.INT || factDiffType2 != Type.INT){
                                if (cantImp2 < 2)
                                    System.out.println("Error en uso de operadores multiplicativos ( * , / ) para: ( " + id1.tok.getText()+ ": "+ id1.type + ", "+ factDiffType2 + " )");
                            }
                        }
                    }

                }

                if (sonVariables == 2){ //La segunda es variable

                    if(ctx.MULTIPLICATEOP().get(0).toString().equals("and")){
                        if(factDiffType != Type.INT ){
                            if (factDiffType!= Type.TRUE)
                                if(factDiffType != Type.FALSE)
                                    if (cantImp2 < 2)
                                        System.out.println("Error, en uso de operadores multiplicativos ( and ) para: ( " + factDiffType + ", "+id2.tok.getText() +": "+ id2.type + " )");
                        }
                        if(id2.type != Type.INT ){
                            if (id2.type != Type.BOOLEAN)
                                if (cantImp2 < 2)
                                    System.out.println("Error en uso de operadores multiplicativos ( and ) para: ( " + factDiffType + ", "+id2.tok.getText() +": "+ id2.type + " )");
                        }
                    }else{
                        if (ctx.MULTIPLICATEOP().get(0).toString().equals("*") || ctx.MULTIPLICATEOP().get(0).toString().equals("/")) {
                            if (factDiffType != Type.INT || id2.type != Type.INT){
                                if (cantImp2 < 2)
                                    System.out.println("Error en uso de operadores multiplicativos ( * , / ) para: ( " + factDiffType + ", "+id2.tok.getText() +": "+ id2.type + " )");
                            }
                        }
                    }

                }

            }

        }
        if(this.visit(ctx.factor(0)) == null )
            return ctx.getText();
        return this.visit(ctx.factor(0));
    }

    @Override public Object visitLiteralFAST(miParser.LiteralFASTContext ctx) {
        return this.visit(ctx.literal());
    }

    @Override public Object visitIdFAST(miParser.IdFASTContext ctx) {
        if(ctx.ID().size() == 1)
            return ctx.ID().get(0);
        return null; //Aquí hay que ver que hacer para cuando se use id.algo, cuando size sea 2
    }

    @Override public Object visitFunctionCallFAST(miParser.FunctionCallFASTContext ctx) {
        this.visit(ctx.functionCall());
        return null;
    }

    @Override public Object visitArrayLookupFAST(miParser.ArrayLookupFASTContext ctx) {
        this.visit(ctx.arrayLookup());
        return null;
    }

    @Override public Object visitArrayLengthFAST(miParser.ArrayLengthFASTContext ctx) {
        this.visit(ctx.arrayLength());
        return null;
    }

    @Override public Object visitSubExpressionFAST(miParser.SubExpressionFASTContext ctx) {
        this.visit(ctx.subExpression());
        return null;
    }

    @Override public Object visitArrayAllocationExpressionFAST(miParser.ArrayAllocationExpressionFASTContext ctx) {
        this.visit(ctx.arrayAllocationExpression());
        return null;
    }

    @Override public Object visitAllocationExpressionFAST(miParser.AllocationExpressionFASTContext ctx) {
        this.visit(ctx.allocationExpression());
        return null;
    }

    @Override public Object visitUnaryFAST(miParser.UnaryFASTContext ctx) {
        this.visit(ctx.unary());
        return null;
    }

    @Override public Object visitUnaryAST(miParser.UnaryASTContext ctx) {
        for (miParser.ExpressionContext c: ctx.expression())
            this.visit(c);
        return null;
    }

    @Override public Object visitAllocationExpressionAST(miParser.AllocationExpressionASTContext ctx) {
        return null;
    }

    @Override public Object visitArrayAllocationExpressionAST(miParser.ArrayAllocationExpressionASTContext ctx) {
        this.visit(ctx.expression());
        return null;
    }

    @Override public Object visitSubExpressionAST(miParser.SubExpressionASTContext ctx) {
        this.visit(ctx.expression());
        return null;
    }

    @Override public Object visitFunctionCallAST(miParser.FunctionCallASTContext ctx) {
        this.visit(ctx.actualParams());
        return null;
    }

    @Override public Object visitActualParamsAST(miParser.ActualParamsASTContext ctx) {
        for (miParser.ExpressionContext c: ctx.expression())
            this.visit(c);
        return null;
    }

    @Override public Object visitArrayLookupAST(miParser.ArrayLookupASTContext ctx) {
        this.visit(ctx.expression());
        return null;
    }

    @Override public Object visitArrayLengthAST(miParser.ArrayLengthASTContext ctx) { return null; }

    @Override public Object visitBoolLiteral(miParser.BoolLiteralContext ctx) {
        return ctx.getText();
    }

    @Override public Object visitIntLAST(miParser.IntLASTContext ctx) {
        return Type.INT;
    }

    @Override public Object visitRealLAST(miParser.RealLASTContext ctx) { return null; }

    @Override public Object visitBoolLAST(miParser.BoolLASTContext ctx) {
        if (this.visit(ctx.boolLiteral()).toString().equals("true")){
            return Type.TRUE;
        }else {
            return Type.FALSE;
        }
    }

    @Override public Object visitStringLAST(miParser.StringLASTContext ctx) { return Type.STRING; }
}
