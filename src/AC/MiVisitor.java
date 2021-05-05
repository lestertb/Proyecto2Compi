package AC;

import generated.miParser;
import generated.miParserBaseVisitor;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.tree.ParseTree;

import java.sql.SQLOutput;

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
        this.visit(ctx.expression());
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

    @Override public Object visitBooleanSTAST(miParser.BooleanSTASTContext ctx) { return null; }

    @Override public Object visitCharSTAST(miParser.CharSTASTContext ctx) { return null; }

    @Override public Object visitIntSTAST(miParser.IntSTASTContext ctx) {
        return Type.INT;
    }

    @Override public Object visitStringSTAST(miParser.StringSTASTContext ctx) {
        return super.visitStringSTAST(ctx);
    }

    @Override public Object visitArrayTypeAST(miParser.ArrayTypeASTContext ctx) { return null; }

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

    @Override public Object visitExpressionAST(miParser.ExpressionASTContext ctx) {
        Type exprType;
        Type exprType2 = null;
        exprType = (Type) this.visit(ctx.simpleExpression(0));
        for (int i = 1; i <ctx.simpleExpression().size() ; i++) {
            exprType2 = (Type) this.visit(ctx.simpleExpression(i));
            if(exprType != exprType2)
                System.out.println("Error tipos incompatibles");
        }
        System.out.println("----------------");
        System.out.println(exprType);
        System.out.println(exprType2);
        System.out.println("----------------");
        return null;
    }

    @Override public Object visitSimpleExpressionAST(miParser.SimpleExpressionASTContext ctx) {
        for (miParser.TermContext c: ctx.term()){
            this.visit(c);
        }
        return null;
    }

    @Override public Object visitTermAST(miParser.TermASTContext ctx) {
        for (miParser.FactorContext c: ctx.factor()){
            this.visit(c);
        }
        return ctx;
    }

    @Override public Object visitLiteralFAST(miParser.LiteralFASTContext ctx) {
        System.out.println(this.visit(ctx.literal()));
        return this.visit(ctx.literal());
    }

    @Override public Object visitIdFAST(miParser.IdFASTContext ctx) {
        return null;
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

    @Override public Object visitBoolLiteral(miParser.BoolLiteralContext ctx) { return null; }

    @Override public Object visitIntLAST(miParser.IntLASTContext ctx) {
        return Type.INT;
    }

    @Override public Object visitRealLAST(miParser.RealLASTContext ctx) { return null; }

    @Override public Object visitBoolLAST(miParser.BoolLASTContext ctx) { return null; }

    @Override public Object visitStringLAST(miParser.StringLASTContext ctx) { return Type.STRING; }
}
