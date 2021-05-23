package INTPR;

import AC.Type;
import generated.miParser;
import generated.miParserBaseVisitor;

import java.util.Stack;

public class MiInterprete extends miParserBaseVisitor {

    private Stack<Object> pilaExpresiones;
    private AlmacenDatos almacenDatos;

    public MiInterprete(){
        this.pilaExpresiones= new Stack<Object>();
        this.almacenDatos = new AlmacenDatos();
    }

    @Override
    public Object visitProgramAST(miParser.ProgramASTContext ctx) {
        return super.visitProgramAST(ctx);
    }

    @Override
    public Object visitVariableDeclarationST(miParser.VariableDeclarationSTContext ctx) {
        this.visit(ctx.variableDeclaration());
        return null;
    }

    @Override
    public Object visitClassDeclarationST(miParser.ClassDeclarationSTContext ctx) {
        return super.visitClassDeclarationST(ctx);
    }

    @Override
    public Object visitAssignmentST(miParser.AssignmentSTContext ctx) {
        return super.visitAssignmentST(ctx);
    }

    @Override
    public Object visitArrayAssignmentST(miParser.ArrayAssignmentSTContext ctx) {
        return super.visitArrayAssignmentST(ctx);
    }

    @Override
    public Object visitPrintStatementST(miParser.PrintStatementSTContext ctx) {
        return this.visit(ctx.printStatement());
    }

    @Override
    public Object visitIfStatementST(miParser.IfStatementSTContext ctx) {
        return super.visitIfStatementST(ctx);
    }

    @Override
    public Object visitWhileStatementST(miParser.WhileStatementSTContext ctx) {
        return super.visitWhileStatementST(ctx);
    }

    @Override
    public Object visitReturnStatementST(miParser.ReturnStatementSTContext ctx) {
        return super.visitReturnStatementST(ctx);
    }

    @Override
    public Object visitFunctionDeclarationST(miParser.FunctionDeclarationSTContext ctx) {
        return super.visitFunctionDeclarationST(ctx);
    }

    @Override
    public Object visitBlockST(miParser.BlockSTContext ctx) {
        return super.visitBlockST(ctx);
    }

    @Override
    public Object visitBlockAST(miParser.BlockASTContext ctx) {
        return super.visitBlockAST(ctx);
    }

    @Override
    public Object visitFunctionDeclarationAST(miParser.FunctionDeclarationASTContext ctx) {
        return super.visitFunctionDeclarationAST(ctx);
    }

    @Override
    public Object visitFormalParamsAST(miParser.FormalParamsASTContext ctx) {
        return super.visitFormalParamsAST(ctx);
    }

    @Override
    public Object visitFormalParamAST(miParser.FormalParamASTContext ctx) {
        return super.visitFormalParamAST(ctx);
    }

    @Override
    public Object visitWhileStatementAST(miParser.WhileStatementASTContext ctx) {
        return super.visitWhileStatementAST(ctx);
    }

    @Override
    public Object visitIfStatementAST(miParser.IfStatementASTContext ctx) {
        return super.visitIfStatementAST(ctx);
    }

    @Override
    public Object visitReturnStatementAST(miParser.ReturnStatementASTContext ctx) {
        return super.visitReturnStatementAST(ctx);
    }

    @Override
    public Object visitPrintStatementAST(miParser.PrintStatementASTContext ctx) {
        System.out.println("-> " + visit(ctx.expression()));
        return ctx;
    }

    @Override
    public Object visitClassDeclarationAST(miParser.ClassDeclarationASTContext ctx) {
        return super.visitClassDeclarationAST(ctx);
    }

    @Override
    public Object visitClassVariableDeclarationAST(miParser.ClassVariableDeclarationASTContext ctx) {
        return super.visitClassVariableDeclarationAST(ctx);
    }

    @Override
    public Object visitVariableDeclarationAST(miParser.VariableDeclarationASTContext ctx) {
        Type tipo = (Type) visit(ctx.type());
        if (ctx.expression() != null){
            Object valor = visit(ctx.expression());
            if( tipo == Type.INT)
                this.almacenDatos.agregarInstancia(ctx.ID().getText(), valor);
            else if ( tipo == Type.STRING)
                this.almacenDatos.agregarInstancia(ctx.ID().getText(), valor);
            else if ( tipo == Type.BOOLEAN)
                this.almacenDatos.agregarInstancia(ctx.ID().getText(), valor);
            else if ( tipo == Type.CHAR)
                this.almacenDatos.agregarInstancia(ctx.ID().getText(), valor);
            else if ( tipo == Type.REAL)
                this.almacenDatos.agregarInstancia(ctx.ID().getText(), valor);
        }else {
            if( tipo == Type.INT)
                this.almacenDatos.agregarInstancia(ctx.ID().getText(), 0);
            else if ( tipo == Type.STRING)
                this.almacenDatos.agregarInstancia(ctx.ID().getText(), "");
            else if ( tipo == Type.BOOLEAN)
                this.almacenDatos.agregarInstancia(ctx.ID().getText(), false);
            else if ( tipo == Type.CHAR)
                this.almacenDatos.agregarInstancia(ctx.ID().getText(), '\u0000');
            else if ( tipo == Type.REAL)
                this.almacenDatos.agregarInstancia(ctx.ID().getText(), 0.0);
        }
        return ctx.ID().getText();
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

    @Override public Object visitCharSTAST(miParser.CharSTASTContext ctx) { return Type.CHAR; }

    @Override public Object visitIntSTAST(miParser.IntSTASTContext ctx) {
        return Type.INT;
    }

    @Override public Object visitStringSTAST(miParser.StringSTASTContext ctx) {
        return Type.STRING;
    }

    @Override public Object visitRealSTAST(miParser.RealSTASTContext ctx) { return Type.REAL; }

    @Override public Object visitArrayTypeAST(miParser.ArrayTypeASTContext ctx) {
        if(ctx.getText().equals("int[]"))
            return Type.INTARREGLO;
        if(ctx.getText().equals("string[]"))
            return Type.STRINGARREGLO;
        if(ctx.getText().equals("boolean[]"))
            return Type.BOOLEANARREGLO;
        return null;
    }

    @Override
    public Object visitAssignmentAST(miParser.AssignmentASTContext ctx) {
        String nombre = ctx.ID(0).getText();
        Object valor = visit(ctx.expression());
        almacenDatos.setInstancia(nombre,valor);
        return null;
    }

    @Override
    public Object visitArrayAssignmentAST(miParser.ArrayAssignmentASTContext ctx) {
        return super.visitArrayAssignmentAST(ctx);
    }

    @Override
    public Object visitExpressionAST(miParser.ExpressionASTContext ctx) {
        Object v1 = this.visit(ctx.simpleExpression(0));
        for(int i=1; i< ctx.simpleExpression().size(); i++) {
            String op = ctx.REOPERATOR(i-1).getText();
            Object v2 = this.visit(ctx.simpleExpression(i));
            v1 = REOPERATOR(v1,v2,op);
        }
        return v1;
    }

    @Override
    public Object visitSimpleExpressionAST(miParser.SimpleExpressionASTContext ctx) {
        Object v1 = this.visit(ctx.term(0));
        for(int i=1; i< ctx.term().size(); i++) {
            String op = ctx.ADDITIVEOP(i-1).getText();
            Object v2 = this.visit(ctx.term(i));
            v1 = ADDITIVEOP(v1,v2,op);
        }
        return v1;
    }

    @Override
    public Object visitTermAST(miParser.TermASTContext ctx) {
        Object v1 = this.visit(ctx.factor(0));
        for(int i=1; i< ctx.factor().size(); i++) {
            String op = ctx.MULTIPLICATEOP(i-1).getText();
            Object v2 = this.visit(ctx.factor(i));
            v1 = MULTIPLICATEOP(v1,v2,op);
        }
        return v1;
    }

    private Object REOPERATOR(Object v1, Object v2, String op){
        Object result=null;
        if (op.equals("<"))
            result = ((Integer)v1) < ((Integer)v2);
        else if (op.equals(">"))
            result = ((Integer)v1) > ((Integer)v2);
        else if (op.equals("=="))
            result = (v1).equals(v2);
        else if (op.equals("!="))
            result = !(v1).equals(v2);
        else if (op.equals("<="))
            result = ((Integer)v1) <= ((Integer)v2);
        else if (op.equals(">="))
            result = ((Integer)v1) >= ((Integer)v2);
        return result;
    }
    private Object ADDITIVEOP(Object v1, Object v2, String op){
        Object result=null;
        if (op.equals("+")){
            try{
                result = ((Integer)v1) + ((Integer)v2);
            }catch (Exception e){
                result = v1 + ((String)v2);
            }
        }
        else if (op.equals("-"))
            result = ((Integer)v1) - ((Integer)v2);
        else if (op.equals("||"))
            result = ((Boolean)v1) || ((Boolean)v2);
        return result;
    }
    private Object MULTIPLICATEOP(Object v1, Object v2, String op){
        Object result=null;
        if (op.equals("*"))
            result = ((Integer)v1) * ((Integer)v2);
        else if (op.equals("/"))
            try{
                result = ((Integer)v1) / ((Integer)v2);
            }catch (ArithmeticException AE){
                System.out.println("Arithmetic Exception: No se puede dividir por 0");
            }
        else if (op.equals("&&")){
            result = ((Boolean)v1) && ((Boolean)v2);
        }
        return result;
    }

    @Override
    public Object visitLiteralFAST(miParser.LiteralFASTContext ctx) {
        return super.visitLiteralFAST(ctx);
    }

    @Override
    public Object visitIdFAST(miParser.IdFASTContext ctx) {
        return (almacenDatos.getInstancia(ctx.ID(0).getText())).valor;
    }

    @Override
    public Object visitFunctionCallFAST(miParser.FunctionCallFASTContext ctx) {
        return super.visitFunctionCallFAST(ctx);
    }

    @Override
    public Object visitArrayLookupFAST(miParser.ArrayLookupFASTContext ctx) {
        return super.visitArrayLookupFAST(ctx);
    }

    @Override
    public Object visitArrayLengthFAST(miParser.ArrayLengthFASTContext ctx) {
        return super.visitArrayLengthFAST(ctx);
    }

    @Override
    public Object visitSubExpressionFAST(miParser.SubExpressionFASTContext ctx) {
        return super.visitSubExpressionFAST(ctx);
    }

    @Override
    public Object visitArrayAllocationExpressionFAST(miParser.ArrayAllocationExpressionFASTContext ctx) {
        return super.visitArrayAllocationExpressionFAST(ctx);
    }

    @Override
    public Object visitAllocationExpressionFAST(miParser.AllocationExpressionFASTContext ctx) {
        return super.visitAllocationExpressionFAST(ctx);
    }

    @Override
    public Object visitUnaryFAST(miParser.UnaryFASTContext ctx) {
        return super.visitUnaryFAST(ctx);
    }

    @Override
    public Object visitUnaryAST(miParser.UnaryASTContext ctx) {
        return super.visitUnaryAST(ctx);
    }

    @Override
    public Object visitAllocationExpressionAST(miParser.AllocationExpressionASTContext ctx) {
        return super.visitAllocationExpressionAST(ctx);
    }

    @Override
    public Object visitArrayAllocationExpressionAST(miParser.ArrayAllocationExpressionASTContext ctx) {
        return super.visitArrayAllocationExpressionAST(ctx);
    }

    @Override
    public Object visitSubExpressionAST(miParser.SubExpressionASTContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public Object visitFunctionCallAST(miParser.FunctionCallASTContext ctx) {
        return super.visitFunctionCallAST(ctx);
    }

    @Override
    public Object visitActualParamsAST(miParser.ActualParamsASTContext ctx) {
        return super.visitActualParamsAST(ctx);
    }

    @Override
    public Object visitArrayLookupAST(miParser.ArrayLookupASTContext ctx) {
        return super.visitArrayLookupAST(ctx);
    }

    @Override
    public Object visitArrayLengthAST(miParser.ArrayLengthASTContext ctx) {
        return super.visitArrayLengthAST(ctx);
    }

    @Override
    public Object visitBoolLiteral(miParser.BoolLiteralContext ctx) {
        return super.visitBoolLiteral(ctx);
    }

    @Override
    public Object visitIntLAST(miParser.IntLASTContext ctx) {
        return Integer.parseInt(ctx.INTLITERAL().getText());
    }

    @Override
    public Object visitRealLAST(miParser.RealLASTContext ctx) {
        return Double.parseDouble(ctx.REALLITERAL().getText());
    }

    @Override
    public Object visitBoolLAST(miParser.BoolLASTContext ctx) {
        return Boolean.parseBoolean(ctx.boolLiteral().getText());
    }

    @Override
    public Object visitStringLAST(miParser.StringLASTContext ctx) {
        return ctx.STRINGLITERAL().getText().replace("\"","");
    }

    @Override
    public Object visitCharLAST(miParser.CharLASTContext ctx) {
        return ctx.CHARLITERAL().getText().charAt(1);
    }
}
