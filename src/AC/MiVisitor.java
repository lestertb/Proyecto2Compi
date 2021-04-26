package AC;

import generated.miParser;
import generated.miParserBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;

public class MiVisitor extends miParserBaseVisitor<Object> {

    @Override public Object visitProgram(miParser.ProgramContext ctx) {
        System.out.println("Estoy en programContext");
        visit(ctx.statement(0));
        for (int i=1; i<=ctx.statement().size()-1; i++){
            visit(ctx.statement(i));
        }
        return null;
    }

    @Override public Object visitStatement(miParser.StatementContext ctx) {
        System.out.println("\t ---Estoy en Statement---");
        visit(ctx.variableDeclaration());
        return null;
    }

    @Override public Object visitBlock(miParser.BlockContext ctx) {
        return null;
    }

    @Override public Object visitFunctionDeclaration(miParser.FunctionDeclarationContext ctx) {
        return null;
    }

    @Override public Object visitFormalParams(miParser.FormalParamsContext ctx) {
        return null;
    }

    @Override public Object visitFormalParam(miParser.FormalParamContext ctx) {
        return null;
    }

    @Override public Object visitWhileStatement(miParser.WhileStatementContext ctx) {
        return null;
    }

    @Override public Object visitIfStatement(miParser.IfStatementContext ctx) {
        return null;
    }

    @Override public Object visitReturnStatement(miParser.ReturnStatementContext ctx) {
        return null;
    }

    @Override public Object visitPrintStatement(miParser.PrintStatementContext ctx) {
        return null;
    }

    @Override public Object visitClassDeclaration(miParser.ClassDeclarationContext ctx) {
        return null;
    }

    @Override public Object visitClassVariableDeclaration(miParser.ClassVariableDeclarationContext ctx) {
        return null;
    }

    @Override public Object visitVariableDeclaration(miParser.VariableDeclarationContext ctx) {
        System.out.println("\t\t Estoy en VariableDeclaration");
        System.out.println("\t\t ID: "+ ctx.ID().getSymbol().getText());
        visit(ctx.type());
        return null;
    }

    @Override public Object visitType(miParser.TypeContext ctx) {
        System.out.println("\t\t Estoy en Type");
        System.out.println("\t\t Type: "+ ctx.getText());
        return null;
    }

    @Override public Object visitSimpleType(miParser.SimpleTypeContext ctx) {
        return null;
    }

    @Override public Object visitArrayType(miParser.ArrayTypeContext ctx) {
        return null;
    }

    @Override public Object visitAssignment(miParser.AssignmentContext ctx) {
        System.out.println("Estoy en assigment");
        return null;
    }

    @Override public Object visitArrayAssignment(miParser.ArrayAssignmentContext ctx) {
        return null;
    }

    @Override public Object visitExpression(miParser.ExpressionContext ctx) {
        return null;
    }

    @Override public Object visitSimpleExpression(miParser.SimpleExpressionContext ctx) {
        return null;
    }

    @Override public Object visitTerm(miParser.TermContext ctx) {
        return null;
    }

    @Override public Object visitFactor(miParser.FactorContext ctx) {
        return null;
    }

    @Override public Object visitUnary(miParser.UnaryContext ctx) {
        return null;
    }

    @Override public Object visitAllocationExpression(miParser.AllocationExpressionContext ctx) {
        return null;
    }

    @Override public Object visitArrayAllocationExpression(miParser.ArrayAllocationExpressionContext ctx) {
        return null;
    }

    @Override public Object visitSubExpression(miParser.SubExpressionContext ctx) {
        return null;
    }

    @Override public Object visitFunctionCall(miParser.FunctionCallContext ctx) {
        return null;
    }

    @Override public Object visitActualParams(miParser.ActualParamsContext ctx) {
        return null;
    }

    @Override public Object visitArrayLookup(miParser.ArrayLookupContext ctx) {
        return null;
    }

    @Override public Object visitArrayLength(miParser.ArrayLengthContext ctx) {
        return null;
    }

    @Override public Object visitBoolLiteral(miParser.BoolLiteralContext ctx) {
        return null;
    }

    @Override public Object visitLiteral(miParser.LiteralContext ctx) {
        return null;
    }

}
