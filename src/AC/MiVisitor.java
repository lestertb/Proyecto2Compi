package AC;

import generated.miParser;
import generated.miParserBaseVisitor;
import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MiVisitor extends miParserBaseVisitor<Object> {

    private TablaSimbolos tabla;
    private TablaSimbolosClass tablaClass;
    private LinkedList<TablaSimbolosClass> listClasses;
    List<ParamMethod> listParam = new ArrayList<ParamMethod>();
    List<Type> listParamCall = new ArrayList<Type>();

    public MiVisitor() {
        tabla = new TablaSimbolos();
        listClasses = new LinkedList<TablaSimbolosClass>();
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
        return this.visit(ctx.classDeclaration());
    }

    @Override public Object visitAssignmentST(miParser.AssignmentSTContext ctx) {
        this.visit(ctx.assignment());
        return null;
    }

    @Override public Object visitArrayAssignmentST(miParser.ArrayAssignmentSTContext ctx) {
        return this.visit(ctx.arrayAssignment());
    }

    @Override public Object visitPrintStatementST(miParser.PrintStatementSTContext ctx) {
        Object returnExpr = this.visit(ctx.printStatement());
        boolean exist = false;
        for (Type type: Type.values()){
            if (returnExpr == type) {
                exist = true;
                break;
            }
        }
        if (!exist)
            System.out.println("\"" + returnExpr + "\"" + " No se reconoce");
        return this.visit(ctx.printStatement());
    }

    @Override public Object visitIfStatementST(miParser.IfStatementSTContext ctx) {
        this.visit(ctx.ifStatement());
        return ctx;
    }

    @Override public Object visitWhileStatementST(miParser.WhileStatementSTContext ctx) {
        this.visit(ctx.whileStatement());
        return ctx;
    }

    @Override public Object visitReturnStatementST(miParser.ReturnStatementSTContext ctx) {
        Object returnExpr = this.visit(ctx.returnStatement());
        boolean exist = false;
        for (Type type: Type.values()){
            if (returnExpr == type) {
                exist = true;
                break;
            }
        }
        if (!exist)
            System.out.println("\"" + returnExpr + "\"" + " No se reconoce");
        return this.visit(ctx.returnStatement());
    }

    @Override public Object visitFunctionDeclarationST(miParser.FunctionDeclarationSTContext ctx) {
        visit(ctx.functionDeclaration());
        return null;
    }

    @Override public Object visitBlockST(miParser.BlockSTContext ctx) {
        return this.visit(ctx.block());
    }

    @Override public Object visitBlockAST(miParser.BlockASTContext ctx) {
        tabla.openScope();
        for(miParser.StatementContext c: ctx.statement()){
                this.visit(c);
        }
        tabla.imprimir();
        tabla.closeScope();
        return ctx;
    }

    @Override public Object visitFunctionDeclarationAST(miParser.FunctionDeclarationASTContext ctx) {
        Object attr = null;
        if (ctx.type() != null){
            attr = this.visit(ctx.type());
            if (attr == Type.INT || attr == Type.STRING || attr == Type.BOOLEAN){
                tabla.insertarMethod(ctx.ID().getSymbol(),(Type) attr,ctx, listParam);
            }else
                System.out.println("No se pueden crear métodos de el tipo: "+ "( " + attr +" )");
        }
        tabla.openScope();
        if (ctx.formalParams() != null)
            this.visit(ctx.formalParams());
        this.visit(ctx.block());
        tabla.imprimir();
        tabla.closeScope();
        return ctx;
    }

    @Override public Object visitFormalParamsAST(miParser.FormalParamsASTContext ctx) {
        listParam.clear();
        for (int i = 0; i < ctx.formalParam().size(); i++) {
            listParam.add((ParamMethod) this.visit(ctx.formalParam(i)));
        }
        ctx.cantParams = ctx.formalParam().size();
        return listParam;
    }

    @Override public Object visitFormalParamAST(miParser.FormalParamASTContext ctx) {
        Object type = this.visit(ctx.type());
        return new ParamMethod( ctx.ID().getText(), (Type) type);
    }

    @Override public Object visitWhileStatementAST(miParser.WhileStatementASTContext ctx) {
        this.visit(ctx.expression());
        this.visit(ctx.block());
        return ctx;
    }

    @Override public Object visitIfStatementAST(miParser.IfStatementASTContext ctx) {
        Object expre = this.visit(ctx.expression());
        boolean exist = false;
        for (Type type: Type.values()){
            if (expre == type) {
                exist = true;
                break;
            }
        }
        if (!exist)
            System.out.println("\"" + expre + "\"" + " No se reconoce");
        this.visit(ctx.block(0));
        if (ctx.block(1) != null)
            this.visit(ctx.block(1));
        return ctx;
    }

    @Override public Object visitReturnStatementAST(miParser.ReturnStatementASTContext ctx) {
        return  this.visit(ctx.expression());
    }

    @Override public Object visitPrintStatementAST(miParser.PrintStatementASTContext ctx) {
        return this.visit(ctx.expression());
    }
    @Override public Object visitClassDeclarationAST(miParser.ClassDeclarationASTContext ctx) {
        tablaClass = new TablaSimbolosClass();
        tablaClass.nombreClass = ctx.ID().getText();
        tablaClass.openScope();
        for(miParser.ClassVariableDeclarationContext c : ctx.classVariableDeclaration())
            this.visit(c);
        tablaClass.imprimir();
        listClasses.addFirst(tablaClass);
        return ctx;
    }

    @Override public Object visitClassVariableDeclarationAST(miParser.ClassVariableDeclarationASTContext ctx) {
        Object typeDeclaration = null;
        Object typeAssign = null;
        try {
            typeDeclaration = this.visit(ctx.simpleType());
            if(typeDeclaration != null){
                Ident id = tablaClass.buscar(ctx.ID().getText());
                if (id != null && id.nivel == tablaClass.nivelActual){
                    System.out.println("Declaración duplicada: Ya existe una declaración en el nivel: " + tablaClass.nivelActual + " con el nombre \"" + ctx.ID().getText() + "\"");
                }else
                    tablaClass.insertar(ctx.ID().getSymbol(), (Type) typeDeclaration,ctx);
            }
            typeAssign = this.visit(ctx.expression());
            if (typeAssign != null){
                Ident idVar = tablaClass.buscar(typeAssign.toString());
                if (idVar != null){
                    if ( typeDeclaration == Type.BOOLEAN){
                        if (idVar.type != Type.TRUE){
                            if (idVar.type != Type.FALSE)
                                if (idVar.type != Type.BOOLEAN)
                                    System.out.println("Tipos incompatibles para la asignación: ( " + typeDeclaration+ ", "+ idVar.tok.getText() + ": " + idVar.type +  " )");
                        }
                    }
                    else if (typeDeclaration != idVar.type){
                        System.out.println("Tipos incompatibles para la asignación ( " + typeDeclaration+ ", "+ idVar.tok.getText() + ": " + idVar.type + " )");
                    }
                }else{
                    if ( typeDeclaration == Type.BOOLEAN){
                        if (typeAssign != Type.TRUE){
                            if (typeAssign != Type.FALSE)
                                if (typeAssign != Type.BOOLEAN)
                                    System.out.println("Tipos incompatibles para la asignación: ( " + typeDeclaration+ ", "+typeAssign + " )");
                        }
                    }
                    else if (typeDeclaration != typeAssign){
                        System.out.println("Tipos incompatibles para la asignación ( " + typeDeclaration+ ", "+typeAssign + " )");
                    }
                }

            }else {
                System.out.println("Tipos incompatibles para la asignación ( " + typeDeclaration+ ", "+ " Dato no reconocido" + " )");
            }

        } catch (Exception e){
            boolean exist = false;
            for (Type type: Type.values()){
                if (this.visit(ctx.simpleType()) == type)
                    exist = true;
            }
            if (!exist)
                System.out.println("\"" +this.visit(ctx.simpleType()) + "\"" + " No es tipo reconocido");
        }
        return typeDeclaration;
    }

    @Override public Object visitVariableDeclarationAST(miParser.VariableDeclarationASTContext ctx) {
        Object attr = null;
        Object typeAssign = null;
        try {
            attr = this.visit(ctx.type());
            if(attr != null){
                Ident id = tabla.buscar(ctx.ID().getText());
                if (id != null && id.nivel == tabla.nivelActual){
                    System.out.println("Declaración duplicada: Ya existe una declaración en el nivel " + tabla.nivelActual + " con el nombre \"" + ctx.ID().getText() + "\"");
                }else
                    tabla.insertar(ctx.ID().getSymbol(), (Type) attr,ctx);
            }
            typeAssign = this.visit(ctx.expression());

            if (typeAssign != null){

                boolean pasa = false;
                try{
                    String[] parts = (typeAssign.toString()).split("\\.");
                    String partClassName = parts[0];
                    String partVarInClassName = parts[1];
                    IdentClass classId = tabla.buscarClass(partClassName);
                    pasa = true;
                }catch (Exception ignored){}

                if (pasa){

                    try{
                        Object expre = this.visit(ctx.expression());
                        String[] parts = (expre.toString()).split("\\.");
                        String partClassName = parts[0];
                        String partVarInClassName = parts[1];
                        IdentClass idClassExpr = tabla.buscarClass(partClassName);
                        boolean existVarInClass2 = false;
                        for (TablaSimbolosClass clase : listClasses) {
                            if ((idClassExpr.type).equals(clase.nombreClass)) {
                                for (int i = 0; i < clase.tablaClass.size(); i++) {
                                    if ((partVarInClassName).equals(((Ident) clase.tablaClass.get(i)).tok.getText())) {
                                        existVarInClass2 = true;
                                        Type expreDer = ((Ident) clase.tablaClass.get(i)).type;
                                        if (expreDer != null) {
                                            if (attr == Type.BOOLEAN) {
                                                if (expreDer != Type.TRUE) {
                                                    if (expreDer != Type.FALSE)
                                                        if (expreDer != Type.BOOLEAN)
                                                            System.out.println("Tipos incompatibles para la asignación: ( " + attr + ", " + expreDer + " )");
                                                }
                                            } else if (attr != expreDer) {
                                                System.out.println("Tipos incompatibles para la asignación ( " + attr + ", " + expreDer + " )");
                                            }
                                        } else {
                                            System.out.println("Tipos incompatibles para la asignación ( " + attr+ ", " + " Dato no reconocido" + " )");
                                        }

                                    }

                                }
                            }
                        }
                        if (!existVarInClass2)
                            System.out.println("\"" + partVarInClassName + "\"" + " no se reconoce como variable de la instancia: " + partClassName);
                    }catch (Exception e2){
                        System.out.println("Error en la asignación");
                    }

                }else {

                    if(typeAssign == Type.INTARREGLO || typeAssign == Type.STRINGARREGLO || typeAssign == Type.BOOLEANARREGLO){
                        Ident arrayId = tabla.buscar(ctx.ID().getText());
                        arrayId.isInitialize = true;
                    }
                    if ( attr == Type.BOOLEAN){
                        if (typeAssign != Type.TRUE){
                            if (typeAssign != Type.FALSE)
                                if (typeAssign != Type.BOOLEAN)
                                    System.out.println("Tipos incompatibles para la asignación ( " + attr+ ", "+typeAssign + " )");
                        }
                    }
                    else if (attr != typeAssign){
                        System.out.println("Tipos incompatibles para la asignación ( " + attr+ ", "+typeAssign + " )");
                    }

                }

            }else {
                System.out.println("Tipos incompatibles para la asignación ( " + attr+ ", "+ " Dato no reconocido" + " )");
            }
       }catch (Exception e){
            Object expre = ctx.expression();
                for (TablaSimbolosClass clase: listClasses) {
                    if ((this.visit(ctx.type()).toString()).equals(clase.nombreClass)){
                        tabla.insertarIdentClass(ctx.ID().getText(),clase.nombreClass);
                        if (expre != null){
                            String expreIzq = ctx.type().getText();
                            String test1 = ctx.expression().getText();
                            String test2 = test1.replace("new", "");
                            String expreDer = test2.replace("()", "");
                            if (expreIzq.equals(expreDer)){
                                IdentClass classId = tabla.buscarClass(ctx.ID().getText());
                                classId.isInitialize = true;
                            }else
                                System.out.println("Error en la inicialización de la instancia, no coincide ( " + expreIzq +", " + expreDer +" )");
                        }
                    }
                }
            boolean exist = false;
            for (Type type: Type.values()){
                if ( this.visit(ctx.type()) == type)
                    exist = true;
            }
            for (TablaSimbolosClass clase: listClasses) {
                if (this.visit(ctx.type()).toString().equals(clase.nombreClass))
                    exist = true;
            }
            if (!exist){
                System.out.println("\"" +this.visit(ctx.type()) + "\"" + " No es tipo reconocido");
            }
        }
        return ctx;
    }

    @Override public Object visitSimpleTypeTAST(miParser.SimpleTypeTASTContext ctx) {
        return this.visit(ctx.simpleType());
    }

    @Override public Object visitArrayTypeTAST(miParser.ArrayTypeTASTContext ctx) {
        return this.visit(ctx.arrayType());
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

    @Override public Object visitArrayTypeAST(miParser.ArrayTypeASTContext ctx) {
        if(ctx.getText().equals("int[]"))
            return Type.INTARREGLO;
        if(ctx.getText().equals("string[]"))
            return Type.STRINGARREGLO;
        if(ctx.getText().equals("boolean[]"))
            return Type.BOOLEANARREGLO;
        return null;
    }

    @Override public Object visitAssignmentAST(miParser.AssignmentASTContext ctx) {
        Ident id = tabla.buscar(ctx.ID().get(0).toString());
        IdentClass idClass = tabla.buscarClass(ctx.ID().get(0).toString());
        if (id == null){
            if (idClass == null){
                System.out.println("\""+ctx.ID().get(0).toString()+"\" no ha sido declarado");
                //throw new RuntimeException();
            }else {
                IdentClass classId = tabla.buscarClass(idClass.nombre);
                for (TablaSimbolosClass clase: listClasses) {
                    if ((classId.type).equals(clase.nombreClass)){
                            String expreIzq = classId.type;
                            String test1 = ctx.expression().getText();
                            String test2 = test1.replace("new", "");
                            String expreDer = test2.replace("()", "");
                            if (expreIzq.equals(expreDer)){
                                classId.isInitialize = true;
                            }else
                                System.out.println("Error en la inicialización de la instancia, no coincide ( " + expreIzq +", " + expreDer +" )");
                    }
                }
                if (classId.isInitialize) {
                    Object varInClass = ctx.ID(1);
                    if (varInClass == null) {
                        try {
                            Object test1 = this.visit(ctx.expression());
                            String test2 = ((String) test1).replace("new", "");
                            String assignExpr = test2.replace("()", "");
                            boolean exist = false;
                            for (TablaSimbolosClass clase : listClasses) {
                                if (assignExpr.equals(clase.nombreClass)) {
                                    exist = true;
                                    break;
                                }
                            }
                            if (!exist)
                                System.out.println("\"" + assignExpr + "\" no se reconoce como clase");
                        } catch (Exception e) {
                            System.out.println("Error con la minipulación de la instancia");
                        }
                    } else {
                        Type expreIzq1 = null;
                        try {
                            boolean existVarInClass = false;
                            for (TablaSimbolosClass clase : listClasses) {
                                if ((idClass.type).equals(clase.nombreClass)) {
                                    for (int i = 0; i < clase.tablaClass.size(); i++) {
                                        if ((varInClass.toString()).equals(((Ident) clase.tablaClass.get(i)).tok.getText())) {
                                            existVarInClass = true;
                                            expreIzq1 = ((Ident) clase.tablaClass.get(i)).type;
                                            Type expreDer = (Type) this.visit(ctx.expression());
                                            if (expreDer != null) {
                                                if (expreIzq1 == Type.BOOLEAN) {
                                                    if (expreDer != Type.TRUE) {
                                                        if (expreDer != Type.FALSE)
                                                            if (expreDer != Type.BOOLEAN)
                                                                System.out.println("Tipos incompatibles para la asignación: ( " + expreIzq1 + ", " + expreDer + " )");
                                                    }
                                                } else if (expreIzq1 != expreDer) {
                                                    System.out.println("Tipos incompatibles para la asignación ( " + expreIzq1 + ", " + expreDer + " )");
                                                }
                                            } else {
                                                System.out.println("Tipos incompatibles para la asignación ( " + expreIzq1 + ", " + " Dato no reconocido" + " )");
                                            }
                                        }

                                    }
                                }
                            }
                            if (!existVarInClass)
                                System.out.println("\"" + varInClass + "\"" + " no se reconoce como variable de la instancia: " + idClass.nombre);
                        }catch (Exception e) {
                            try{
                                Object expre = this.visit(ctx.expression());
                                String[] parts = (expre.toString()).split("\\.");
                                String partClassName = parts[0];
                                String partVarInClassName = parts[1];
                                IdentClass idClassExpr = tabla.buscarClass(partClassName);
                                boolean existVarInClass2 = false;
                                for (TablaSimbolosClass clase : listClasses) {
                                    if ((idClassExpr.type).equals(clase.nombreClass)) {
                                        for (int i = 0; i < clase.tablaClass.size(); i++) {
                                            if ((partVarInClassName).equals(((Ident) clase.tablaClass.get(i)).tok.getText())) {
                                                existVarInClass2 = true;
                                                Type expreDer = ((Ident) clase.tablaClass.get(i)).type;
                                                if (expreDer != null) {
                                                    if (expreIzq1 == Type.BOOLEAN) {
                                                        if (expreDer != Type.TRUE) {
                                                            if (expreDer != Type.FALSE)
                                                                if (expreDer != Type.BOOLEAN)
                                                                    System.out.println("Tipos incompatibles para la asignación: ( " + expreIzq1 + ", " + expreDer + " )");
                                                        }
                                                    } else if (expreIzq1 != expreDer) {
                                                        System.out.println("Tipos incompatibles para la asignación ( " + expreIzq1 + ", " + expreDer + " )");
                                                    }
                                                } else {
                                                    System.out.println("Tipos incompatibles para la asignación ( " + expreIzq1 + ", " + " Dato no reconocido" + " )");
                                                }

                                            }

                                        }
                                    }
                                }
                                if (!existVarInClass2)
                                    System.out.println("\"" + partVarInClassName + "\"" + " no se reconoce como variable de la instancia: " + partClassName);
                            }catch (Exception e2){
                                System.out.println("Error en la asignación de clases");
                            }

                        }
                    }
                }else{
                    System.out.println("La instancia: " + idClass.nombre + " No ha sido inicializada");
                }
            }

        }else{
            Object assignExpr = this.visit(ctx.expression());
            if (assignExpr != null){
                boolean pasa = false;
                try{
                    String[] parts = (assignExpr.toString()).split("\\.");
                    String partClassName = parts[0];
                    String partVarInClassName = parts[1];
                    IdentClass classId = tabla.buscarClass(partClassName);
                    pasa = true;
                }catch (Exception ignored){}

                if (pasa){

                    try{
                        Object expre = this.visit(ctx.expression());
                        String[] parts = (expre.toString()).split("\\.");
                        String partClassName = parts[0];
                        String partVarInClassName = parts[1];
                        IdentClass idClassExpr = tabla.buscarClass(partClassName);
                        boolean existVarInClass2 = false;
                        for (TablaSimbolosClass clase : listClasses) {
                            if ((idClassExpr.type).equals(clase.nombreClass)) {
                                for (int i = 0; i < clase.tablaClass.size(); i++) {
                                    if ((partVarInClassName).equals(((Ident) clase.tablaClass.get(i)).tok.getText())) {
                                        existVarInClass2 = true;
                                        Type expreDer = ((Ident) clase.tablaClass.get(i)).type;
                                        if (expreDer != null) {
                                            if (id.type == Type.BOOLEAN) {
                                                if (expreDer != Type.TRUE) {
                                                    if (expreDer != Type.FALSE)
                                                        if (expreDer != Type.BOOLEAN)
                                                            System.out.println("Tipos incompatibles para la asignación: ( " + id.type + ", " + expreDer + " )");
                                                }
                                            } else if (id.type != expreDer) {
                                                System.out.println("Tipos incompatibles para la asignación ( " + id.type + ", " + expreDer + " )");
                                            }
                                        } else {
                                            System.out.println("Tipos incompatibles para la asignación ( " + id.type + ", " + " Dato no reconocido" + " )");
                                        }

                                    }

                                }
                            }
                        }
                        if (!existVarInClass2)
                            System.out.println("\"" + partVarInClassName + "\"" + " no se reconoce como variable de la instancia: " + partClassName);
                    }catch (Exception e2){
                        System.out.println("Error en la asignación de clases");
                    }

                }else{

                    if(assignExpr == Type.INTARREGLO || assignExpr == Type.STRINGARREGLO || assignExpr == Type.BOOLEANARREGLO){
                        Ident arrayId = tabla.buscar(ctx.ID(0).getText());
                        arrayId.isInitialize = true;
                    }

                    if ( id.type == Type.BOOLEAN){
                        if (assignExpr != Type.TRUE){
                            if (assignExpr != Type.FALSE)
                                if (assignExpr != Type.BOOLEAN)
                                    System.out.println("Tipos incompatibles para la asignación ( " + id.type+ ", "+assignExpr + " )");
                        }
                    }
                    else if (id.type != assignExpr){
                        System.out.println("Tipos incompatibles para la asignación ( " + id.type+ ", "+assignExpr + " )");
                    }
                }

            }else {
                System.out.println("Tipos incompatibles para la asignación ( " + id.type+ ", "+ " Dato no reconocido" + " )");
            }
        }
        return null;
    }

    int cantImpArray;
    @Override public Object visitArrayAssignmentAST(miParser.ArrayAssignmentASTContext ctx) {
        Type exprType = null;
        Type exprType2 = null;
        Ident id = null;
        try { exprType = (Type) this.visit(ctx.expression(0)); }catch (Exception e){
            System.out.println("\""+this.visit(ctx.expression(0))+"\": " + "No se reconoce");
        }
        id = tabla.buscar(ctx.ID().getText());
        for (int i = 1; i < ctx.expression().size(); i++) {
            try {
                exprType2 = (Type) this.visit(ctx.expression(i));
            }catch (Exception e){
                try{
                    if (id != null) {
                        Object expre = this.visit(ctx.expression(i));
                        String[] parts = (expre.toString()).split("\\.");
                        String partClassName = parts[0];
                        String partVarInClassName = parts[1];
                        IdentClass idClassExpr = tabla.buscarClass(partClassName);
                        boolean existVarInClass2 = false;
                        for (TablaSimbolosClass clase : listClasses) {
                            if ((idClassExpr.type).equals(clase.nombreClass)) {
                                for (int index = 0; index < clase.tablaClass.size(); index++) {
                                    if ((partVarInClassName).equals(((Ident) clase.tablaClass.get(index)).tok.getText())) {
                                        existVarInClass2 = true;
                                        Type expreDer = ((Ident) clase.tablaClass.get(index)).type;
                                        if (expreDer != null) {
                                            if (id.isInitialize){

                                                if (id.type == Type.INTARREGLO)
                                                    if (expreDer != Type.INT)
                                                        System.out.println("Tipos incompatibles para la asignación: ( " + id.tok.getText() + ": " + id.type + ", " + expreDer + " )");
                                                if (id.type == Type.STRINGARREGLO)
                                                    if (expreDer != Type.STRING)
                                                        System.out.println("Tipos incompatibles para la asignación: ( " + id.tok.getText() + ": " + id.type + ", " + expreDer + " )");
                                                if (id.type == Type.BOOLEANARREGLO)
                                                    if (expreDer != Type.BOOLEAN)
                                                        if (expreDer != Type.TRUE)
                                                            if (expreDer != Type.FALSE)
                                                                System.out.println("Tipos incompatibles para la asignación: ( " + id.tok.getText() + ": " + id.type + ", " + expreDer + " )");

                                            }else
                                                System.out.println("\""+id.tok.getText()+"\": " + "No ha sido inicializado");
                                        } else {
                                            System.out.println("Tipos incompatibles para la asignación ( " + id.type + ", " + " Dato no reconocido" + " )");
                                        }

                                    }

                                }
                            }
                        }
                        if (!existVarInClass2)
                            System.out.println("\"" + partVarInClassName + "\"" + " no se reconoce como variable de la instancia: " + partClassName);
                    }else
                        System.out.println("\""+ctx.ID().getText()+"\": " + "No se reconoce");

                }catch (Exception e2){
                    System.out.println("\""+this.visit(ctx.expression(i))+"\": " + "No se reconoce");
                }

            }
            if (exprType != null){
                if (exprType != Type.INT)
                    if (cantImpArray < 1){
                        cantImpArray++;
                        System.out.println("Error en el índice del arreglo, se usó ( " + exprType + " ), " + "debería ser ( INT )");
                    }
            }
            if (id != null) {
                if (id.isInitialize){
                    if (exprType2 != null) {
                        if (id.type == Type.INTARREGLO)
                            if (exprType2 != Type.INT)
                                System.out.println("Tipos incompatibles para la asignación ( " + id.tok.getText() + ": " + id.type + ", " + exprType2 + " )");
                        if (id.type == Type.STRINGARREGLO)
                            if (exprType2 != Type.STRING)
                                System.out.println("Tipos incompatibles para la asignación ( " + id.tok.getText() + ": " + id.type + ", " + exprType2 + " )");
                        if (id.type == Type.BOOLEANARREGLO)
                            if (exprType2 != Type.BOOLEAN)
                                if (exprType2 != Type.TRUE)
                                    if (exprType2 != Type.FALSE)
                                        System.out.println("Tipos incompatibles para la asignación ( " + id.tok.getText() + ": " + id.type + ", " + exprType2 + " )");
                    }
                }else
                    System.out.println("\""+id.tok.getText()+"\": " + "No ha sido inicializado");
            }else
                System.out.println("\""+ctx.ID().getText()+"\": " + "No se reconoce");

        }
        return ctx;
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
                    }else
                        return Type.BOOLEAN;
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
                    else
                        return Type.BOOLEAN;
                }
            }
            return exprType;
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
                        return exprDiffType;
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
                        return exprDiffType2;
                    }
                }
                if (sonVariables == 0){ //Ambas variables
                    if(ctx.REOPERATOR().get(0).toString().equals("<") || ctx.REOPERATOR().get(0).toString().equals(">") || ctx.REOPERATOR().get(0).toString().equals("<=") || ctx.REOPERATOR().get(0).toString().equals(">=")){
                        if(id1.type != Type.INT || id2.type != Type.INT)
                            System.out.println("Error en uso de operadores relacionales( < , > , <= , >= ) para: ( " + id1.tok.getText()+ ": "+ id1.type + ", "+id2.tok.getText() +": "+ id2.type + " )");
                        else
                            return Type.BOOLEAN;
                    }else if(ctx.REOPERATOR().get(0).toString().equals("==") || ctx.REOPERATOR().get(0).toString().equals("!=")) {
                        if (id1.type == Type.BOOLEAN){
                            if(id2.type != Type.BOOLEAN)
                                System.out.println("Error en uso de operadores relacionales( == , != ) para: ( " + id1.tok.getText()+ ": "+ id1.type + ", "+id2.tok.getText() +": "+ id2.type + " )");
                        }else if (id2.type  == Type.BOOLEAN){
                            System.out.println("Error en uso de operadores relacionales( == , != ) para: ( " + id1.tok.getText()+ ": "+ id1.type + ", "+id2.tok.getText() +": "+ id2.type + " )");
                        }else if (id1.type != id2.type)
                            System.out.println("Error en uso de operadores relacionales( == , != ) para: ( " + id1.tok.getText()+ ": "+ id1.type + ", "+id2.tok.getText() +": "+ id2.type + " )");
                        else
                            return Type.BOOLEAN;
                    }
                }
                if (sonVariables == 1){ //La primera es variable
                    if(ctx.REOPERATOR().get(0).toString().equals("<") || ctx.REOPERATOR().get(0).toString().equals(">") || ctx.REOPERATOR().get(0).toString().equals("<=") || ctx.REOPERATOR().get(0).toString().equals(">=")){
                        assert id1 != null;
                        if(id1.type != Type.INT || exprDiffType2 != Type.INT)
                            System.out.println("Error en uso de operadores relacionales( < , > , <= , >= ) para: ( " + id1.tok.getText()+ ": "+ id1.type + ", "+exprDiffType2 + " )");
                        else
                            return Type.BOOLEAN;
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
                        else
                            return Type.BOOLEAN;
                    }

                }
                if (sonVariables == 2){ //La segunda es variable

                    if(ctx.REOPERATOR().get(0).toString().equals("<") || ctx.REOPERATOR().get(0).toString().equals(">") || ctx.REOPERATOR().get(0).toString().equals("<=") || ctx.REOPERATOR().get(0).toString().equals(">=")){

                        if(exprDiffType != Type.INT || id2.type != Type.INT)
                            System.out.println("Error en uso de operadores relacionales( < , > , <= , >= ) para: ( " +exprDiffType + ", " + id2.tok.getText()+ ": "+ id2.type + " )");
                        else
                            return Type.BOOLEAN;

                    }else if(ctx.REOPERATOR().get(0).toString().equals("==") || ctx.REOPERATOR().get(0).toString().equals("!=")) {
                        if (exprDiffType == Type.TRUE || exprDiffType == Type.FALSE){
                            if(id2.type != Type.BOOLEAN){
                                    System.out.println("Error en uso de operadores relacionales( == , != ) para: ( " +exprDiffType + ", " + id2.tok.getText()+ ": "+ id2.type + " )");
                            }
                        }else if (id2.type  == Type.BOOLEAN){
                            System.out.println("Error en uso de operadores relacionales( == , != ) para: ( " +exprDiffType + ", " + id2.tok.getText()+ ": "+ id2.type + " )");
                        }else if (exprDiffType != id2.type)
                            System.out.println("Error en uso de operadores relacionales( == , != ) para: ( " +exprDiffType + ", " + id2.tok.getText()+ ": "+ id2.type + " )");
                        else
                            return Type.BOOLEAN;
                    }
                }
            }
            if (id1 != null)
                return id1.type;
            else{
                return ctx.simpleExpression().get(0).getText();
            }
        }
       //return exprType; //Posible error ver que retorno en visitSimpleExpressionAST
    }
    int cantImp;
    int cantImpErrorSE;
    int cantImpErrorSEMA;
    int cantImpErrorSEME;
    @Override public Object visitSimpleExpressionAST(miParser.SimpleExpressionASTContext ctx) {
        Type termType = null;
        Type termType2 = null;
        try {
            termType = (Type) this.visit(ctx.term(0));
            for (int i = 1; i <ctx.term().size() ; i++) {
                termType2 = (Type) this.visit(ctx.term(i));
                switch (ctx.ADDITIVEOP().get(0).toString()) {
                    case "or":
                        boolean isErr = false;
                        if (termType != Type.INT) {
                            if (termType != Type.TRUE)
                                if (termType != Type.FALSE) {
                                    if (cantImpErrorSE < 1) {
                                        cantImpErrorSE++;
                                        isErr=true;
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
                                        isErr=true;
                                    }
                                }
                        }
                        if (!isErr)
                            return Type.BOOLEAN;
                        else
                            return termType;
                    case "+":
                        if (termType == Type.INT && termType2 == Type.INT){
                            return Type.INT;
                        }else if (termType == Type.STRING && termType2 == Type.STRING)
                            return Type.STRING;
                        else{
                            if (cantImpErrorSEMA < 1) {
                                cantImpErrorSEMA++;
                                System.out.println("Error en uso de operadores aditivos( + ) para: ( " + termType + ", " + termType2 + " )");
                            }
                            return termType;
                        }
                    case "-":
                        if (termType == Type.INT && termType2 == Type.INT) {
                            return Type.INT;
                        }else{
                            if (cantImpErrorSEME < 1) {
                                cantImpErrorSEME++;
                                System.out.println("Error en uso de operadores aditivos( - ) para: ( " + termType + ", " + termType2 + " )");
                            }
                            return termType;
                        }
                }
            }
            return termType;
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
                        if (cantImp < 1) {
                            cantImp++;
                            System.out.println("Error en uso de operadores aditivos para: ( " + termDiffType + ", " + termDiffType2 + " )");
                            System.out.println("Error, " + termDiffType + ": No se reconoce");
                        }
                        return termDiffType;
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
                        return termDiffType2;
                    }
                }
                if (sonVariables == 0){//Ambas variables
                    switch (ctx.ADDITIVEOP().get(0).toString()) {
                        case "or":
                            boolean isErr = false;
                            if (id1.type != Type.INT) {
                                if (id1.type != Type.BOOLEAN){
                                    if(cantImpErrorSE < 1){
                                        cantImpErrorSE++;
                                        isErr=true;
                                        System.out.println("Error, en uso de operadores aditivos( or ) para: ( " + id1.tok.getText()+ ": "+ id1.type + ", "+id2.tok.getText() +": "+ id2.type + " )");
                                    }
                                }
                            }
                            if (id2.type != Type.INT) {
                                if (id2.type != Type.BOOLEAN){
                                    if(cantImpErrorSE < 1){
                                        cantImpErrorSE++;
                                        System.out.println("Error en uso de operadores aditivos( or ) para: ( " + id1.tok.getText()+ ": "+ id1.type + ", "+id2.tok.getText() +": "+ id2.type + " )");
                                        isErr=true;
                                    }
                                }
                            }
                            if (!isErr)
                                return Type.BOOLEAN;
                            else
                                return id1.type;
                        case "+":
                            if (id1.type == Type.INT && id2.type == Type.INT)
                                return Type.INT;
                            else if (id1.type == Type.STRING && id2.type == Type.STRING)
                                return Type.STRING;
                            else{
                                if (cantImpErrorSEMA < 1) {
                                    cantImpErrorSEMA++;
                                    System.out.println("Error en uso de operadores aditivos( + ) para: ( " + id1.tok.getText() + ": " + id1.type + ", " + id2.tok.getText() + ": " + id2.type + " )");
                                }
                                return id1.type;
                            }
                        case "-":
                            if (id1.type == Type.INT && id2.type == Type.INT) {
                                return Type.INT;
                            }else{
                                if (cantImpErrorSEME < 1) {
                                    cantImpErrorSEME++;
                                    System.out.println("Error en uso de operadores aditivos( - ) para: ( " + id1.tok.getText() + ": " + id1.type + ", " + id2.tok.getText() + ": " + id2.type + " )");
                                }return id1.type;
                            }
                        }
                    }
                if (sonVariables == 1){ //La primera es variable

                    switch (ctx.ADDITIVEOP().get(0).toString()) {
                        case "or" -> {
                            boolean isErr = false;
                            assert id1 != null;
                            if (id1.type != Type.INT) {
                                if (id1.type != Type.BOOLEAN) {
                                    if (cantImpErrorSE < 1) {
                                        cantImpErrorSE++;
                                        isErr=true;
                                        System.out.println("Error en uso de operadores aditivos( or ) para: ( " + id1.tok.getText() + ": " + id1.type + ", " + termDiffType2 + " )");
                                    }
                                }
                            } if (termDiffType2 != Type.INT) {
                                if (termDiffType2 != Type.TRUE) {
                                    if(termDiffType2 != Type.FALSE){
                                        if (cantImpErrorSE < 1) {
                                            cantImpErrorSE++;
                                            System.out.println("Error en uso de operadores aditivos( or ) para: ( " + id1.tok.getText() + ": " + id1.type + ", " + termDiffType2 + " )");
                                            isErr=true;
                                        }
                                    }
                                }
                            }
                            if (!isErr)
                                return Type.BOOLEAN;
                            else
                                return id1.type;
                        }
                        case "+" -> {
                            assert id1 != null;
                            if (id1.type == Type.INT && termDiffType2 == Type.INT){
                                return Type.INT;
                            }else if (id1.type == Type.STRING && termDiffType2 == Type.STRING)
                                return Type.STRING;
                            else{
                                if (cantImpErrorSEMA < 1) {
                                    cantImpErrorSEMA++;
                                    System.out.println("Error en uso de operadores aditivos( + ) para: ( " + id1.tok.getText() + ": " + id1.type + ", " + termDiffType2 + " )");
                                }
                                return id1.type;
                            }
                        }
                        case "-" -> {
                            assert id1 != null;
                            if (id1.type == Type.INT && termDiffType2 == Type.INT) {
                                return Type.INT;
                            }else{
                                if (cantImpErrorSEME < 1) {
                                    cantImpErrorSEME++;
                                    System.out.println("Error en uso de operadores aditivos( - ) para: ( " + id1.tok.getText() + ": " + id1.type + ", " + termDiffType2 + " )");
                                }
                                return id1.type;
                            }

                        }
                    }

                }

                if (sonVariables == 2){ //La segunda es variable

                    switch (ctx.ADDITIVEOP().get(0).toString()) {
                        case "or":
                            boolean isErr = false;
                            if (termDiffType != Type.INT) {
                                if (termDiffType != Type.TRUE){
                                    if(termDiffType != Type.FALSE){
                                        if(cantImpErrorSE < 1){
                                            cantImpErrorSE++;
                                            isErr=true;
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
                                        isErr=true;
                                    }
                                }
                            }
                            if (!isErr)
                                return Type.BOOLEAN;
                            else
                                return termDiffType;
                        case "+":
                            if (termDiffType == Type.INT && id2.type == Type.INT){
                                return Type.INT;
                            }
                            if (termDiffType == Type.STRING && id2.type == Type.STRING){
                                return Type.STRING;
                            }else {
                                if (cantImpErrorSEMA < 1) {
                                    cantImpErrorSEMA++;
                                    System.out.println("Error en uso de operadores aditivos( + ) para: ( " + termDiffType + ", " + id2.tok.getText() + ": " + id2.type + " )");
                                }
                                return termDiffType;
                            }
                        case "-":
                            if (termDiffType == Type.INT && id2.type == Type.INT) {
                                return Type.INT;
                            }else {
                                if (cantImpErrorSEME < 1) {
                                    cantImpErrorSEME++;
                                    System.out.println("Error en uso de operadores aditivos( - ) para: ( " + termDiffType + ", " + id2.tok.getText() + ": " + id2.type + " )");
                                }
                                return termDiffType;
                            }
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
                    boolean isErr = false;
                    if(factType != Type.INT ){
                        if (factType != Type.TRUE)
                            if (factType != Type.FALSE)
                                if (cantImp2 < 2){
                                    isErr=true;
                                    System.out.println("Error en uso de operadores multiplicativos ( and ) para: ( " + factType+ ", "+factType2 + " )");
                                }
                    }
                    if(factType2 != Type.INT ){
                        if (factType2 != Type.TRUE)
                            if (factType2 != Type.FALSE)
                                if (cantImp2 < 2){
                                    System.out.println("Error en uso de operadores multiplicativos ( and ) para: ( " + factType+ ", "+factType2 + " )");
                                    isErr=true;
                                }
                    }
                    if (!isErr)
                        return Type.BOOLEAN;
                    else
                        return factType;
                }else{
                    if (ctx.MULTIPLICATEOP().get(0).toString().equals("*") || ctx.MULTIPLICATEOP().get(0).toString().equals("/")) {
                        if (factType == Type.INT && factType2 == Type.INT){
                            return Type.INT;
                        }else {
                            System.out.println("Error en uso de operadores multiplicativos ( * , / ) para: ( " + factType + ", " + factType2 + " )");
                            return factType;
                        }
                    }
                }
            }
            return factType;

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
                            return factDiffType;
                        }
                    }
                }
                if (id2 == null){
                    sonVariables=1;
                    try{
                        Type test = (Type)factDiffType2;
                    }catch (Exception e2){
                        if (cantImpErrorT < 2){
                            if (cantImp3 < 1){
                                cantImp3++;
                                System.out.println("Error en uso de operadores multiplicativos para: ( " + factDiffType+ ", "+ factDiffType2 + " )");
                            }
                            if(cantImpVE < 1) {
                                cantImpVE++;
                                System.out.println("Error, " + factDiffType2 + ": No se reconoce");
                                return factDiffType2;
                            }
                        }
                    }
                }

                if (sonVariables == 0){//Ambas variables

                    if(ctx.MULTIPLICATEOP().get(0).toString().equals("and")){
                        boolean isErr = false;
                        if(id1.type != Type.INT ){
                            if (id1.type != Type.BOOLEAN)
                                    if (cantImp2 < 2){
                                        isErr=true;
                                        System.out.println("Error, en uso de operadores multiplicativos ( and ) para: ( " + id1.tok.getText()+ ": "+ id1.type + ", "+id2.tok.getText() +": "+ id2.type + " )");
                                    }
                        }
                        if(id2.type != Type.INT ){
                            if (id2.type != Type.BOOLEAN)
                                    if (cantImp2 < 2){
                                        System.out.println("Error en uso de operadores multiplicativos ( and ) para: ( " + id1.tok.getText()+ ": "+ id1.type + ", "+id2.tok.getText() +": "+ id2.type + " )");
                                        isErr=true;
                                    }
                        }
                        if (!isErr)
                            return Type.BOOLEAN;
                        else
                            return id1.type;
                    }else{
                        if (ctx.MULTIPLICATEOP().get(0).toString().equals("*") || ctx.MULTIPLICATEOP().get(0).toString().equals("/")) {
                            if (id1.type == Type.INT || id2.type == Type.INT){
                                return Type.INT;
                            }else {
                                System.out.println("Error en uso de operadores multiplicativos ( * , / ) para: ( " + id1.tok.getText()+ ": "+ id1.type + ", "+id2.tok.getText() +": "+ id2.type + " )");
                                return id1.type;
                            }
                        }
                    }

                }

                if (sonVariables == 1){ //La primera es variable

                    if(ctx.MULTIPLICATEOP().get(0).toString().equals("and")){
                        boolean isErr = false;
                        assert id1 != null;
                        if(id1.type != Type.INT ){
                            if (id1.type != Type.BOOLEAN)
                                if (cantImp2 < 2){
                                    cantImp2++;
                                    isErr=true;
                                    System.out.println("Error, en uso de operadores multiplicativos ( and ) para: ( " + id1.tok.getText()+ ": "+ id1.type + ", "+ factDiffType2 + " )");
                                }
                        }
                        if(factDiffType2 != Type.INT ){
                            if (factDiffType2 != Type.TRUE)
                                if (factDiffType2 != Type.FALSE)
                                    if (cantImp2 < 2){
                                        System.out.println("Error en uso de operadores multiplicativos ( and ) para: ( " + id1.tok.getText()+ ": "+ id1.type + ", "+ factDiffType2 + " )");
                                        isErr=true;
                                    }
                        }
                        if (!isErr)
                            return Type.BOOLEAN;
                        else
                            return id1.type;
                    }else{
                        if (ctx.MULTIPLICATEOP().get(0).toString().equals("*") || ctx.MULTIPLICATEOP().get(0).toString().equals("/")) {
                            assert id1 != null;
                            if (id1.type == Type.INT && factDiffType2 == Type.INT){
                                return Type.INT;
                            }else{
                                System.out.println("Error en uso de operadores multiplicativos ( * , / ) para: ( " + id1.tok.getText()+ ": "+ id1.type + ", "+ factDiffType2 + " )");
                                return id1.type;
                            }
                        }
                    }

                }

                if (sonVariables == 2){ //La segunda es variable

                    if(ctx.MULTIPLICATEOP().get(0).toString().equals("and")){
                        boolean isErr = false;
                        if(factDiffType != Type.INT ){
                            if (factDiffType!= Type.TRUE)
                                if(factDiffType != Type.FALSE)
                                    if (cantImp2 < 2){
                                        isErr=true;
                                        System.out.println("Error, en uso de operadores multiplicativos ( and ) para: ( " + factDiffType + ", "+id2.tok.getText() +": "+ id2.type + " )");
                                    }
                        }
                        if(id2.type != Type.INT ){
                            if (id2.type != Type.BOOLEAN)
                                if (cantImp2 < 2){
                                    System.out.println("Error en uso de operadores multiplicativos ( and ) para: ( " + factDiffType + ", "+id2.tok.getText() +": "+ id2.type + " )");
                                    isErr=true;
                                }
                        }
                        if (!isErr)
                            return Type.BOOLEAN;
                        else
                            return factDiffType;
                    }else{
                        if (ctx.MULTIPLICATEOP().get(0).toString().equals("*") || ctx.MULTIPLICATEOP().get(0).toString().equals("/")) {
                            if (factDiffType == Type.INT && id2.type == Type.INT){
                                return Type.INT;
                            }else {
                                System.out.println("Error en uso de operadores multiplicativos ( * , / ) para: ( " + factDiffType + ", "+id2.tok.getText() +": "+ id2.type + " )");
                                return factDiffType;
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
        return ctx; //Aquí hay que ver que hacer para cuando se use id.algo, cuando size sea 2
    }

    @Override public Object visitFunctionCallFAST(miParser.FunctionCallFASTContext ctx) {
        return this.visit(ctx.functionCall());
    }

    @Override public Object visitArrayLookupFAST(miParser.ArrayLookupFASTContext ctx) {
        return this.visit(ctx.arrayLookup());
    }

    @Override public Object visitArrayLengthFAST(miParser.ArrayLengthFASTContext ctx) {
        return this.visit(ctx.arrayLength());
    }

    @Override public Object visitSubExpressionFAST(miParser.SubExpressionFASTContext ctx) {
        return this.visit(ctx.subExpression());
    }

    @Override public Object visitArrayAllocationExpressionFAST(miParser.ArrayAllocationExpressionFASTContext ctx) {
        return this.visit(ctx.arrayAllocationExpression());
    }

    @Override public Object visitAllocationExpressionFAST(miParser.AllocationExpressionFASTContext ctx) {
        return this.visit(ctx.allocationExpression());
    }

    @Override public Object visitUnaryFAST(miParser.UnaryFASTContext ctx) {
        return this.visit(ctx.unary());
    }

    @Override public Object visitUnaryAST(miParser.UnaryASTContext ctx) {
        for (miParser.ExpressionContext c: ctx.expression())
            this.visit(c);
        return ctx;
    }

    @Override public Object visitAllocationExpressionAST(miParser.AllocationExpressionASTContext ctx) {
        return ctx.ID();
    }
    int impCantErr;
    @Override public Object visitArrayAllocationExpressionAST(miParser.ArrayAllocationExpressionASTContext ctx) {
        Object attr = this.visit(ctx.expression());
        if (attr != null){
            boolean pasa = false;
            try{
                String[] parts = (attr.toString()).split("\\.");
                String partClassName = parts[0];
                String partVarInClassName = parts[1];
                IdentClass classId = tabla.buscarClass(partClassName);
                pasa = true;
            }catch (Exception ignored){}

            if (pasa){

                try{
                    Object expre = this.visit(ctx.expression());
                    String[] parts = (expre.toString()).split("\\.");
                    String partClassName = parts[0];
                    String partVarInClassName = parts[1];
                    IdentClass idClassExpr = tabla.buscarClass(partClassName);
                    if(idClassExpr.isInitialize){
                        boolean existVarInClass2 = false;
                        for (TablaSimbolosClass clase : listClasses) {
                            if ((idClassExpr.type).equals(clase.nombreClass)) {
                                for (int i = 0; i < clase.tablaClass.size(); i++) {
                                    if ((partVarInClassName).equals(((Ident) clase.tablaClass.get(i)).tok.getText())) {
                                        existVarInClass2 = true;
                                        Type expreDer = ((Ident) clase.tablaClass.get(i)).type;
                                        if (expreDer != null) {
                                            if (expreDer != Type.INT){
                                                if (impCantErr < 1){
                                                    impCantErr++;
                                                    System.out.println("Error en la inicialización del arreglo, se usó ( " + partClassName +"."+((Ident) clase.tablaClass.get(i)).tok.getText() + ": " + expreDer + " ), " + "debería ser ( INT )");
                                                }
                                            }
                                        }
                                    }

                                }
                            }
                        }
                        if (!existVarInClass2)
                            System.out.println("\"" + partVarInClassName + "\"" + " no se reconoce como variable de la instancia: " + partClassName);
                    }else
                        System.out.println("La instancia: " + idClassExpr.nombre + " No ha sido inicializada");

                }catch (Exception e2){
                    System.out.println("Error no se reconoce la variable en el índice del arreglo");
                }


            }else{
                if (attr != Type.INT){
                    if (impCantErr < 1){
                        impCantErr++;
                        System.out.println("Error en la inicialización del arreglo, se usó ( " + attr + " ), " + "debería ser ( INT )");
                    }
                }
            }


        }
        String newCtx = ctx.simpleType().getText() + ctx.PCIZQ() + ctx.PCDER().getText() ;
        if(newCtx.equals("int[]"))
            return Type.INTARREGLO;
        if(newCtx.equals("string[]"))
            return Type.STRINGARREGLO;
        if(newCtx.equals("boolean[]"))
            return Type.BOOLEANARREGLO;
        return this.visit(ctx.simpleType());
    }

    @Override public Object visitSubExpressionAST(miParser.SubExpressionASTContext ctx) {
        return this.visit(ctx.expression());
    }

    @Override public Object visitFunctionCallAST(miParser.FunctionCallASTContext ctx) {
        Ident id = tabla.buscar(ctx.ID().getText());
        if (id == null){
            System.out.println("\""+ctx.ID().getText()+"\" No es un método declarado!!!");
        }else{
            Object test = ctx.actualParams();
            if (test != null){
                this.visit(ctx.actualParams());
                Object test2 = (( ((miParser.FunctionDeclarationASTContext) id.declCtx).formalParams()));
                if (test2 != null){
                    if (ctx.actualParams().cantParams != ( ((miParser.FunctionDeclarationASTContext) id.declCtx).formalParams()).cantParams){
                        System.out.println("Error en la llamada del método, cantidad de parámetros diferente a la declaración");
                        return id.type;
                    }
                }else{
                    if (ctx.actualParams().cantParams > 0){
                        System.out.println("Error en la llamada del método, cantidad de parámetros diferente a la declaración");
                        return id.type;
                    }
                }
            }else{
                if ((((miParser.FunctionDeclarationASTContext) id.declCtx).formalParams()).cantParams > 0){
                    System.out.println("Error en la llamada del método, cantidad de parámetros diferente a la declaración");
                    return id.type;
                }
            }

            for (int i = 0; i < id.listaParams.size(); i++) {
                if(id.listaParams.get(i).type == Type.BOOLEAN){
                    if(listParamCall.get(i) != Type.BOOLEAN){
                        if(listParamCall.get(i) != Type.TRUE){
                            if(listParamCall.get(i) != Type.FALSE){
                                System.out.println("El tipo de los parametros no coincide");
                            }
                        }
                    }
                }
                else if(id.listaParams.get(i).type != listParamCall.get(i)){
                    System.out.println("El tipo de los parametros no coincide");
                }
            }
            return id.type;
        }
        return ctx.ID();
    }

    @Override public Object visitActualParamsAST(miParser.ActualParamsASTContext ctx) {
        listParamCall.clear();
        for (int i = 0; i < ctx.expression().size() ; i++) {
            listParamCall.add( (Type) this.visit(ctx.expression(i)));
        }
        ctx.cantParams = ctx.expression().size();
        return ctx;
    }
    int cantImpErrArray;
    @Override public Object visitArrayLookupAST(miParser.ArrayLookupASTContext ctx) {
        Ident id = tabla.buscar(ctx.ID().getText());
        if (id != null){
            if (id.isInitialize) {
                if (id.type == Type.INTARREGLO)
                    return Type.INT;
                if (id.type == Type.STRINGARREGLO)
                    return Type.STRING;
                if (id.type == Type.BOOLEANARREGLO)
                    return Type.BOOLEAN;
            }else{
                if (cantImpErrArray < 1){
                    cantImpErrArray++;
                    System.out.println("\""+id.tok.getText()+"\": " + "No ha sido inicializado");
                }
                return ctx.ID();
            }
        }
        return ctx.ID();
    }
    int cantImpErrArray2;
    @Override public Object visitArrayLengthAST(miParser.ArrayLengthASTContext ctx) {
        Ident id = tabla.buscar(ctx.ID().getText());
        if (id != null){
            if (id.isInitialize)
                return Type.INT;
            else{
                if (cantImpErrArray2 < 1){
                    cantImpErrArray2++;
                    System.out.println("\""+id.tok.getText()+"\": " + "No ha sido inicializado");
                }
                return ctx.ID();
            }

        }
        return ctx.ID();
    }

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
