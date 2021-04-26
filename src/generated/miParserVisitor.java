// Generated from C:/Users/Lester Trejos/Documents/Compi/proyecto2compi\miParser.g4 by ANTLR 4.9.1
package generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link miParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface miParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link miParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(miParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link miParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(miParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link miParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(miParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link miParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(miParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link miParser#formalParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParams(miParser.FormalParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link miParser#formalParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParam(miParser.FormalParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link miParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(miParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link miParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(miParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link miParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(miParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link miParser#printStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatement(miParser.PrintStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link miParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(miParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link miParser#classVariableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassVariableDeclaration(miParser.ClassVariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link miParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(miParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link miParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(miParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link miParser#simpleType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleType(miParser.SimpleTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link miParser#arrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(miParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link miParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(miParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link miParser#arrayAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAssignment(miParser.ArrayAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link miParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(miParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link miParser#simpleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleExpression(miParser.SimpleExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link miParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(miParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link miParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(miParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link miParser#unary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary(miParser.UnaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link miParser#allocationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllocationExpression(miParser.AllocationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link miParser#arrayAllocationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAllocationExpression(miParser.ArrayAllocationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link miParser#subExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubExpression(miParser.SubExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link miParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(miParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link miParser#actualParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActualParams(miParser.ActualParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link miParser#arrayLookup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLookup(miParser.ArrayLookupContext ctx);
	/**
	 * Visit a parse tree produced by {@link miParser#arrayLength}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLength(miParser.ArrayLengthContext ctx);
	/**
	 * Visit a parse tree produced by {@link miParser#boolLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolLiteral(miParser.BoolLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link miParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(miParser.LiteralContext ctx);
}