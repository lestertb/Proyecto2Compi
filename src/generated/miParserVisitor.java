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
	 * Visit a parse tree produced by the {@code programAST}
	 * labeled alternative in {@link miParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramAST(miParser.ProgramASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variableDeclarationST}
	 * labeled alternative in {@link miParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarationST(miParser.VariableDeclarationSTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classDeclarationST}
	 * labeled alternative in {@link miParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclarationST(miParser.ClassDeclarationSTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignmentST}
	 * labeled alternative in {@link miParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentST(miParser.AssignmentSTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayAssignmentST}
	 * labeled alternative in {@link miParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAssignmentST(miParser.ArrayAssignmentSTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printStatementST}
	 * labeled alternative in {@link miParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatementST(miParser.PrintStatementSTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifStatementST}
	 * labeled alternative in {@link miParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatementST(miParser.IfStatementSTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileStatementST}
	 * labeled alternative in {@link miParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatementST(miParser.WhileStatementSTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnStatementST}
	 * labeled alternative in {@link miParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatementST(miParser.ReturnStatementSTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionDeclarationST}
	 * labeled alternative in {@link miParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclarationST(miParser.FunctionDeclarationSTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blockST}
	 * labeled alternative in {@link miParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockST(miParser.BlockSTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blockAST}
	 * labeled alternative in {@link miParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockAST(miParser.BlockASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionDeclarationAST}
	 * labeled alternative in {@link miParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclarationAST(miParser.FunctionDeclarationASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code formalParamsAST}
	 * labeled alternative in {@link miParser#formalParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParamsAST(miParser.FormalParamsASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code formalParamAST}
	 * labeled alternative in {@link miParser#formalParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParamAST(miParser.FormalParamASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileStatementAST}
	 * labeled alternative in {@link miParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatementAST(miParser.WhileStatementASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifStatementAST}
	 * labeled alternative in {@link miParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatementAST(miParser.IfStatementASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnStatementAST}
	 * labeled alternative in {@link miParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatementAST(miParser.ReturnStatementASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printStatementAST}
	 * labeled alternative in {@link miParser#printStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatementAST(miParser.PrintStatementASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classDeclarationAST}
	 * labeled alternative in {@link miParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclarationAST(miParser.ClassDeclarationASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classVariableDeclarationAST}
	 * labeled alternative in {@link miParser#classVariableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassVariableDeclarationAST(miParser.ClassVariableDeclarationASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variableDeclarationAST}
	 * labeled alternative in {@link miParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarationAST(miParser.VariableDeclarationASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simpleTypeTAST}
	 * labeled alternative in {@link miParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleTypeTAST(miParser.SimpleTypeTASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayTypeTAST}
	 * labeled alternative in {@link miParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayTypeTAST(miParser.ArrayTypeTASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idTAST}
	 * labeled alternative in {@link miParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdTAST(miParser.IdTASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanSTAST}
	 * labeled alternative in {@link miParser#simpleType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanSTAST(miParser.BooleanSTASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code charSTAST}
	 * labeled alternative in {@link miParser#simpleType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharSTAST(miParser.CharSTASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intSTAST}
	 * labeled alternative in {@link miParser#simpleType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntSTAST(miParser.IntSTASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringSTAST}
	 * labeled alternative in {@link miParser#simpleType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringSTAST(miParser.StringSTASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code realSTAST}
	 * labeled alternative in {@link miParser#simpleType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealSTAST(miParser.RealSTASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayTypeAST}
	 * labeled alternative in {@link miParser#arrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayTypeAST(miParser.ArrayTypeASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignmentAST}
	 * labeled alternative in {@link miParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentAST(miParser.AssignmentASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayAssignmentAST}
	 * labeled alternative in {@link miParser#arrayAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAssignmentAST(miParser.ArrayAssignmentASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionAST}
	 * labeled alternative in {@link miParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAST(miParser.ExpressionASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simpleExpressionAST}
	 * labeled alternative in {@link miParser#simpleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleExpressionAST(miParser.SimpleExpressionASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code termAST}
	 * labeled alternative in {@link miParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermAST(miParser.TermASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literalFAST}
	 * labeled alternative in {@link miParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralFAST(miParser.LiteralFASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idFAST}
	 * labeled alternative in {@link miParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdFAST(miParser.IdFASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionCallFAST}
	 * labeled alternative in {@link miParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallFAST(miParser.FunctionCallFASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayLookupFAST}
	 * labeled alternative in {@link miParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLookupFAST(miParser.ArrayLookupFASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayLengthFAST}
	 * labeled alternative in {@link miParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLengthFAST(miParser.ArrayLengthFASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subExpressionFAST}
	 * labeled alternative in {@link miParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubExpressionFAST(miParser.SubExpressionFASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayAllocationExpressionFAST}
	 * labeled alternative in {@link miParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAllocationExpressionFAST(miParser.ArrayAllocationExpressionFASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code allocationExpressionFAST}
	 * labeled alternative in {@link miParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllocationExpressionFAST(miParser.AllocationExpressionFASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryFAST}
	 * labeled alternative in {@link miParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryFAST(miParser.UnaryFASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryAST}
	 * labeled alternative in {@link miParser#unary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryAST(miParser.UnaryASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code allocationExpressionAST}
	 * labeled alternative in {@link miParser#allocationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllocationExpressionAST(miParser.AllocationExpressionASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayAllocationExpressionAST}
	 * labeled alternative in {@link miParser#arrayAllocationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAllocationExpressionAST(miParser.ArrayAllocationExpressionASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subExpressionAST}
	 * labeled alternative in {@link miParser#subExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubExpressionAST(miParser.SubExpressionASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionCallAST}
	 * labeled alternative in {@link miParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallAST(miParser.FunctionCallASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code actualParamsAST}
	 * labeled alternative in {@link miParser#actualParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActualParamsAST(miParser.ActualParamsASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayLookupAST}
	 * labeled alternative in {@link miParser#arrayLookup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLookupAST(miParser.ArrayLookupASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayLengthAST}
	 * labeled alternative in {@link miParser#arrayLength}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLengthAST(miParser.ArrayLengthASTContext ctx);
	/**
	 * Visit a parse tree produced by {@link miParser#boolLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolLiteral(miParser.BoolLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intLAST}
	 * labeled alternative in {@link miParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntLAST(miParser.IntLASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code realLAST}
	 * labeled alternative in {@link miParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealLAST(miParser.RealLASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolLAST}
	 * labeled alternative in {@link miParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolLAST(miParser.BoolLASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringLAST}
	 * labeled alternative in {@link miParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLAST(miParser.StringLASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code charLAST}
	 * labeled alternative in {@link miParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharLAST(miParser.CharLASTContext ctx);
}