package AC;

import generated.miParser;
import generated.miParserBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;

public class MiVisitor extends miParserBaseVisitor<Object> {


    @Override public Object visitProgramAST(miParser.ProgramASTContext ctx) {
        System.out.println("Estoy en programContext");
        visit(ctx.statement(0));
        for (int i=1; i<=ctx.statement().size()-1; i++){
            visit(ctx.statement(i));
        }
        return null;
    }

    @Override public Object visitVariableDeclarationST(miParser.VariableDeclarationSTContext ctx) {
        System.out.println("\t ---Estoy en Statement---");
        visit(ctx.variableDeclaration());
        return null;
    }

    @Override public Object visitClassDeclarationST(miParser.ClassDeclarationSTContext ctx) {
        return null;
    }

    @Override public Object visitAssignmentST(miParser.AssignmentSTContext ctx) {
        System.out.println("\t ---Estoy en Statement---");
        visit(ctx.assignment());
        return null;
    }

    @Override public Object visitArrayAssignmentST(miParser.ArrayAssignmentSTContext ctx) {
        System.out.println("\t ---Estoy en Statement---");
        return null;
    }

    @Override public Object visitPrintStatementST(miParser.PrintStatementSTContext ctx) {
        System.out.println("\t ---Estoy en Statement---");
        return null;
    }

    @Override public Object visitIfStatementST(miParser.IfStatementSTContext ctx) {
        System.out.println("\t ---Estoy en Statement---");
        return null;
    }

    @Override public Object visitWhileStatementST(miParser.WhileStatementSTContext ctx) {
        System.out.println("\t ---Estoy en Statement---");
        return null;
    }

    @Override public Object visitReturnStatementST(miParser.ReturnStatementSTContext ctx) {
        System.out.println("\t ---Estoy en Statement---");
        return null;
    }

    @Override public Object visitFunctionDeclarationST(miParser.FunctionDeclarationSTContext ctx) {
        System.out.println("\t ---Estoy en Statement---");
        return null;
    }

    @Override public Object visitBlockST(miParser.BlockSTContext ctx) {
        System.out.println("\t ---Estoy en Statement---");
        return null;
    }

    @Override public Object visitBlockAST(miParser.BlockASTContext ctx) { return null; }

    @Override public Object visitFunctionDeclarationAST(miParser.FunctionDeclarationASTContext ctx) { return null; }

    @Override public Object visitFormalParamsAST(miParser.FormalParamsASTContext ctx) { return null; }

    @Override public Object visitFormalParamAST(miParser.FormalParamASTContext ctx) { return null; }

    @Override public Object visitWhileStatementAST(miParser.WhileStatementASTContext ctx) { return null; }

    @Override public Object visitIfStatementAST(miParser.IfStatementASTContext ctx) { return null; }

    @Override public Object visitReturnStatementAST(miParser.ReturnStatementASTContext ctx) { return null; }

    @Override public Object visitPrintStatementAST(miParser.PrintStatementASTContext ctx) { return null; }

    @Override public Object visitClassDeclarationAST(miParser.ClassDeclarationASTContext ctx) { return null; }

    @Override public Object visitClassVariableDeclarationAST(miParser.ClassVariableDeclarationASTContext ctx) { return null; }

    @Override public Object visitVariableDeclarationAST(miParser.VariableDeclarationASTContext ctx) {
        System.out.println("\t\t Estoy en VariableDeclarationAST");
        System.out.println("\t\t ID: "+ ctx.ID().getSymbol().getText());
        visit(ctx.type());
        return null;
    }

    @Override public Object visitSimpleTypeTAST(miParser.SimpleTypeTASTContext ctx) {
        System.out.println("\t\t Type: "+ ctx.getText());
        return null;
    }

    @Override public Object visitArrayTypeTAST(miParser.ArrayTypeTASTContext ctx) {
        System.out.println("\t\t Type array: "+ ctx.getText());
        return null;
    }

    @Override public Object visitIdTAST(miParser.IdTASTContext ctx) {
        System.out.println("\t\t Type id: "+ ctx.getText());
        return null;
    }

    @Override public Object visitBooleanSTAST(miParser.BooleanSTASTContext ctx) { return null; }

    @Override public Object visitCharSTAST(miParser.CharSTASTContext ctx) { return null; }

    @Override public Object visitIntSTAST(miParser.IntSTASTContext ctx) { return null; }

    @Override public Object visitStringSTAST(miParser.StringSTASTContext ctx) { return null; }

    @Override public Object visitArrayTypeAST(miParser.ArrayTypeASTContext ctx) { return null; }

    @Override public Object visitAssignmentAST(miParser.AssignmentASTContext ctx) {
        System.out.println("\t\t Estoy en AssigmentAST");
        System.out.println("\t\t ID: " + ctx.ID());
        visit(ctx.expression());
        return null;
    }

    @Override public Object visitArrayAssignmentAST(miParser.ArrayAssignmentASTContext ctx) { return null; }

    @Override public Object visitExpressionAST(miParser.ExpressionASTContext ctx) {
        System.out.println("\t\t Asignación: " + ctx.getText());
        return null;
    }

    @Override public Object visitSimpleExpressionAST(miParser.SimpleExpressionASTContext ctx) { return null; }

    @Override public Object visitTermAST(miParser.TermASTContext ctx) { return null; }

    @Override public Object visitLiteralFAST(miParser.LiteralFASTContext ctx) { return null; }

    @Override public Object visitIdFAST(miParser.IdFASTContext ctx) { return null; }

    @Override public Object visitFunctionCallFAST(miParser.FunctionCallFASTContext ctx) { return null; }

    @Override public Object visitArrayLookupFAST(miParser.ArrayLookupFASTContext ctx) { return null; }

    @Override public Object visitArrayLengthFAST(miParser.ArrayLengthFASTContext ctx) { return null; }

    @Override public Object visitSubExpressionFAST(miParser.SubExpressionFASTContext ctx) { return null; }

    @Override public Object visitArrayAllocationExpressionFAST(miParser.ArrayAllocationExpressionFASTContext ctx) { return null; }

    @Override public Object visitUnaryFAST(miParser.UnaryFASTContext ctx) { return null; }

    @Override public Object visitUnaryAST(miParser.UnaryASTContext ctx) { return null; }

    @Override public Object visitAllocationExpressionAST(miParser.AllocationExpressionASTContext ctx) { return null; }

    @Override public Object visitArrayAllocationExpressionAST(miParser.ArrayAllocationExpressionASTContext ctx) { return null; }

    @Override public Object visitSubExpressionAST(miParser.SubExpressionASTContext ctx) { return null; }

    @Override public Object visitFunctionCallAST(miParser.FunctionCallASTContext ctx) { return null; }

    @Override public Object visitActualParamsAST(miParser.ActualParamsASTContext ctx) { return null; }

    @Override public Object visitArrayLookupAST(miParser.ArrayLookupASTContext ctx) { return null; }

    @Override public Object visitArrayLengthAST(miParser.ArrayLengthASTContext ctx) { return null; }

    @Override public Object visitBoolLiteral(miParser.BoolLiteralContext ctx) { return null; }

    @Override public Object visitIntLAST(miParser.IntLASTContext ctx) { return null; }

    @Override public Object visitRealLAST(miParser.RealLASTContext ctx) { return null; }

    @Override public Object visitBoolLAST(miParser.BoolLASTContext ctx) { return null; }

    @Override public Object visitStringLAST(miParser.StringLASTContext ctx) { return null; }
}
