package INTPR;

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
        return super.visitVariableDeclarationST(ctx);
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
        return super.visitPrintStatementST(ctx);
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
        return super.visitPrintStatementAST(ctx);
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
        return super.visitVariableDeclarationAST(ctx);
    }

    @Override
    public Object visitSimpleTypeTAST(miParser.SimpleTypeTASTContext ctx) {
        return super.visitSimpleTypeTAST(ctx);
    }

    @Override
    public Object visitArrayTypeTAST(miParser.ArrayTypeTASTContext ctx) {
        return super.visitArrayTypeTAST(ctx);
    }

    @Override
    public Object visitIdTAST(miParser.IdTASTContext ctx) {
        return super.visitIdTAST(ctx);
    }

    @Override
    public Object visitBooleanSTAST(miParser.BooleanSTASTContext ctx) {
        return super.visitBooleanSTAST(ctx);
    }

    @Override
    public Object visitCharSTAST(miParser.CharSTASTContext ctx) {
        return super.visitCharSTAST(ctx);
    }

    @Override
    public Object visitIntSTAST(miParser.IntSTASTContext ctx) {
        return super.visitIntSTAST(ctx);
    }

    @Override
    public Object visitStringSTAST(miParser.StringSTASTContext ctx) {
        return super.visitStringSTAST(ctx);
    }

    @Override
    public Object visitArrayTypeAST(miParser.ArrayTypeASTContext ctx) {
        return super.visitArrayTypeAST(ctx);
    }

    @Override
    public Object visitAssignmentAST(miParser.AssignmentASTContext ctx) {
        return super.visitAssignmentAST(ctx);
    }

    @Override
    public Object visitArrayAssignmentAST(miParser.ArrayAssignmentASTContext ctx) {
        return super.visitArrayAssignmentAST(ctx);
    }

    @Override
    public Object visitExpressionAST(miParser.ExpressionASTContext ctx) {
        return super.visitExpressionAST(ctx);
    }

    @Override
    public Object visitSimpleExpressionAST(miParser.SimpleExpressionASTContext ctx) {
        return super.visitSimpleExpressionAST(ctx);
    }

    @Override
    public Object visitTermAST(miParser.TermASTContext ctx) {
        return super.visitTermAST(ctx);
    }

    @Override
    public Object visitLiteralFAST(miParser.LiteralFASTContext ctx) {
        return super.visitLiteralFAST(ctx);
    }

    @Override
    public Object visitIdFAST(miParser.IdFASTContext ctx) {
        return super.visitIdFAST(ctx);
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
        return super.visitSubExpressionAST(ctx);
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
        return super.visitIntLAST(ctx);
    }

    @Override
    public Object visitRealLAST(miParser.RealLASTContext ctx) {
        return super.visitRealLAST(ctx);
    }

    @Override
    public Object visitBoolLAST(miParser.BoolLASTContext ctx) {
        return super.visitBoolLAST(ctx);
    }

    @Override
    public Object visitStringLAST(miParser.StringLASTContext ctx) {
        return super.visitStringLAST(ctx);
    }

    @Override
    public Object visitCharLAST(miParser.CharLASTContext ctx) {
        return super.visitCharLAST(ctx);
    }
}
