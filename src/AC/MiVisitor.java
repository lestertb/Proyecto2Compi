package AC;

import generated.miParser;
import generated.miParserBaseVisitor;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.tree.ParseTree;

public class MiVisitor<Object> extends miParserBaseVisitor<Object> {

    private TablaSimbolos tabla;
    /*
    public MiVisitor() {
        tabla = new TablaSimbolos();
    }*/

    @Override public Object visitProgramAST(miParser.ProgramASTContext ctx) {
        for( miParser.StatementContext context : ctx.statement())
            this.visit(context);
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
        this.visit(ctx.expression());
        return null;
    }

    @Override public Object visitVariableDeclarationAST(miParser.VariableDeclarationASTContext ctx) {
        this.visit(ctx.type());
        if (ctx.expression() != null)
            this.visit(ctx.expression());
       /*
        miParser.SimpleTypeTASTContext idToken = ((miParser.SimpleTypeTASTContext) this.visit(ctx.type()));
        System.out.println(idToken);
        Ident id = tabla.buscar(idToken.getText());
        if (id != null){
            try {
                Object exprType = this.visit(ctx.expression());
                System.out.println(id.type);
                System.out.println(exprType);
            }catch (RuntimeException e){
                System.out.println("Error de asignación");
            }
        }*/
        return null;
    }

    @Override public Object visitSimpleTypeTAST(miParser.SimpleTypeTASTContext ctx) {
        return null;
    }

    @Override public Object visitArrayTypeTAST(miParser.ArrayTypeTASTContext ctx) {
        this.visit(ctx.arrayType());
        return null;
    }

    @Override public Object visitIdTAST(miParser.IdTASTContext ctx) {
        return null;
    }

    @Override public Object visitBooleanSTAST(miParser.BooleanSTASTContext ctx) { return null; }

    @Override public Object visitCharSTAST(miParser.CharSTASTContext ctx) { return null; }

    @Override public Object visitIntSTAST(miParser.IntSTASTContext ctx) { return null; }

    @Override public Object visitStringSTAST(miParser.StringSTASTContext ctx) {
        return super.visitStringSTAST(ctx);
    }

    @Override public Object visitArrayTypeAST(miParser.ArrayTypeASTContext ctx) { return null; }

    @Override public Object visitAssignmentAST(miParser.AssignmentASTContext ctx) {
        visit(ctx.expression());
        return null;
    }

    @Override public Object visitArrayAssignmentAST(miParser.ArrayAssignmentASTContext ctx) {
        this.visit(ctx.expression(0));
        this.visit(ctx.expression(1));
        return null;
    }

    @Override public Object visitExpressionAST(miParser.ExpressionASTContext ctx) {
        for (miParser.SimpleExpressionContext c: ctx.simpleExpression())
            this.visit(c);
        return null;
    }

    @Override public Object visitSimpleExpressionAST(miParser.SimpleExpressionASTContext ctx) {
        for (miParser.TermContext c: ctx.term())
            this.visit(c);
        return null;
    }

    @Override public Object visitTermAST(miParser.TermASTContext ctx) {
        for (miParser.FactorContext c: ctx.factor())
            this.visit(c);
        return null;
    }

    @Override public Object visitLiteralFAST(miParser.LiteralFASTContext ctx) {
        this.visit(ctx.literal());
        return null;
    }

    @Override public Object visitIdFAST(miParser.IdFASTContext ctx) { return null; }

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

    @Override public Object visitIntLAST(miParser.IntLASTContext ctx) { return null; }

    @Override public Object visitRealLAST(miParser.RealLASTContext ctx) { return null; }

    @Override public Object visitBoolLAST(miParser.BoolLASTContext ctx) { return null; }

    @Override public Object visitStringLAST(miParser.StringLASTContext ctx) { return null; }
}