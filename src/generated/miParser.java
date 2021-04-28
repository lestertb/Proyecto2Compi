// Generated from C:/Users/Lester Trejos/Documents/Compi/proyecto2compi\miParser.g4 by ANTLR 4.9.1
package generated;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class miParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PyComa=1, COMA=2, UNDERSC=3, POINT=4, COMIDOBLES=5, ASSIGN=6, VIR=7, DOSPUN=8, 
		PIZQ=9, PDER=10, LLAIZQ=11, LLADER=12, PCIZQ=13, PCDER=14, REOPERATOR=15, 
		ADDITIVEOP=16, MULTIPLICATEOP=17, BOOLEAN=18, CHAR=19, INT=20, STRING=21, 
		TRUE=22, FALSE=23, SUM=24, SUB=25, OR=26, MUL=27, DIV=28, AND=29, INTERROGATION=30, 
		UNARY=31, IF=32, ELSE=33, WHILE=34, RETURN=35, CLASS=36, PRINT=37, NEW=38, 
		LENGTH=39, ID=40, INTLITERAL=41, REALLITERAL=42, STRINGLITERAL=43, WS=44;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_block = 2, RULE_functionDeclaration = 3, 
		RULE_formalParams = 4, RULE_formalParam = 5, RULE_whileStatement = 6, 
		RULE_ifStatement = 7, RULE_returnStatement = 8, RULE_printStatement = 9, 
		RULE_classDeclaration = 10, RULE_classVariableDeclaration = 11, RULE_variableDeclaration = 12, 
		RULE_type = 13, RULE_simpleType = 14, RULE_arrayType = 15, RULE_assignment = 16, 
		RULE_arrayAssignment = 17, RULE_expression = 18, RULE_simpleExpression = 19, 
		RULE_term = 20, RULE_factor = 21, RULE_unary = 22, RULE_allocationExpression = 23, 
		RULE_arrayAllocationExpression = 24, RULE_subExpression = 25, RULE_functionCall = 26, 
		RULE_actualParams = 27, RULE_arrayLookup = 28, RULE_arrayLength = 29, 
		RULE_boolLiteral = 30, RULE_literal = 31;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "block", "functionDeclaration", "formalParams", 
			"formalParam", "whileStatement", "ifStatement", "returnStatement", "printStatement", 
			"classDeclaration", "classVariableDeclaration", "variableDeclaration", 
			"type", "simpleType", "arrayType", "assignment", "arrayAssignment", "expression", 
			"simpleExpression", "term", "factor", "unary", "allocationExpression", 
			"arrayAllocationExpression", "subExpression", "functionCall", "actualParams", 
			"arrayLookup", "arrayLength", "boolLiteral", "literal"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "','", "'_'", "'.'", "'\"'", "'='", "'~'", "':'", "'('", 
			"')'", "'{'", "'}'", "'['", "']'", null, null, null, "'boolean'", "'char'", 
			"'int'", "'string'", "'true'", "'false'", "'+'", "'-'", "'or'", "'*'", 
			"'/'", "'and'", "'!'", null, "'if'", "'else'", "'while'", "'return'", 
			"'class'", "'print'", "'new'", "'length'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PyComa", "COMA", "UNDERSC", "POINT", "COMIDOBLES", "ASSIGN", "VIR", 
			"DOSPUN", "PIZQ", "PDER", "LLAIZQ", "LLADER", "PCIZQ", "PCDER", "REOPERATOR", 
			"ADDITIVEOP", "MULTIPLICATEOP", "BOOLEAN", "CHAR", "INT", "STRING", "TRUE", 
			"FALSE", "SUM", "SUB", "OR", "MUL", "DIV", "AND", "INTERROGATION", "UNARY", 
			"IF", "ELSE", "WHILE", "RETURN", "CLASS", "PRINT", "NEW", "LENGTH", "ID", 
			"INTLITERAL", "REALLITERAL", "STRINGLITERAL", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "miParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public miParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	 
		public ProgramContext() { }
		public void copyFrom(ProgramContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ProgramASTContext extends ProgramContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramASTContext(ProgramContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitProgramAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			_localctx = new ProgramASTContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LLAIZQ) | (1L << BOOLEAN) | (1L << CHAR) | (1L << INT) | (1L << STRING) | (1L << IF) | (1L << WHILE) | (1L << RETURN) | (1L << CLASS) | (1L << PRINT) | (1L << ID))) != 0)) {
				{
				{
				setState(64);
				statement();
				}
				}
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VariableDeclarationSTContext extends StatementContext {
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public TerminalNode PyComa() { return getToken(miParser.PyComa, 0); }
		public VariableDeclarationSTContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitVariableDeclarationST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfStatementSTContext extends StatementContext {
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public IfStatementSTContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitIfStatementST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnStatementSTContext extends StatementContext {
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public TerminalNode PyComa() { return getToken(miParser.PyComa, 0); }
		public ReturnStatementSTContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitReturnStatementST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrintStatementSTContext extends StatementContext {
		public PrintStatementContext printStatement() {
			return getRuleContext(PrintStatementContext.class,0);
		}
		public TerminalNode PyComa() { return getToken(miParser.PyComa, 0); }
		public PrintStatementSTContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitPrintStatementST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockSTContext extends StatementContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BlockSTContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitBlockST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionDeclarationSTContext extends StatementContext {
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public FunctionDeclarationSTContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitFunctionDeclarationST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayAssignmentSTContext extends StatementContext {
		public ArrayAssignmentContext arrayAssignment() {
			return getRuleContext(ArrayAssignmentContext.class,0);
		}
		public TerminalNode PyComa() { return getToken(miParser.PyComa, 0); }
		public ArrayAssignmentSTContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitArrayAssignmentST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ClassDeclarationSTContext extends StatementContext {
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public TerminalNode PyComa() { return getToken(miParser.PyComa, 0); }
		public ClassDeclarationSTContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitClassDeclarationST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignmentSTContext extends StatementContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public TerminalNode PyComa() { return getToken(miParser.PyComa, 0); }
		public AssignmentSTContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitAssignmentST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileStatementSTContext extends StatementContext {
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public WhileStatementSTContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitWhileStatementST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(92);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new VariableDeclarationSTContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				variableDeclaration();
				setState(71);
				match(PyComa);
				}
				break;
			case 2:
				_localctx = new ClassDeclarationSTContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				classDeclaration();
				setState(74);
				match(PyComa);
				}
				break;
			case 3:
				_localctx = new AssignmentSTContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(76);
				assignment();
				setState(77);
				match(PyComa);
				}
				break;
			case 4:
				_localctx = new ArrayAssignmentSTContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(79);
				arrayAssignment();
				setState(80);
				match(PyComa);
				}
				break;
			case 5:
				_localctx = new PrintStatementSTContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(82);
				printStatement();
				setState(83);
				match(PyComa);
				}
				break;
			case 6:
				_localctx = new IfStatementSTContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(85);
				ifStatement();
				}
				break;
			case 7:
				_localctx = new WhileStatementSTContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(86);
				whileStatement();
				}
				break;
			case 8:
				_localctx = new ReturnStatementSTContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(87);
				returnStatement();
				setState(88);
				match(PyComa);
				}
				break;
			case 9:
				_localctx = new FunctionDeclarationSTContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(90);
				functionDeclaration();
				}
				break;
			case 10:
				_localctx = new BlockSTContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(91);
				block();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	 
		public BlockContext() { }
		public void copyFrom(BlockContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BlockASTContext extends BlockContext {
		public TerminalNode LLAIZQ() { return getToken(miParser.LLAIZQ, 0); }
		public TerminalNode LLADER() { return getToken(miParser.LLADER, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockASTContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitBlockAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_block);
		int _la;
		try {
			_localctx = new BlockASTContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(LLAIZQ);
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LLAIZQ) | (1L << BOOLEAN) | (1L << CHAR) | (1L << INT) | (1L << STRING) | (1L << IF) | (1L << WHILE) | (1L << RETURN) | (1L << CLASS) | (1L << PRINT) | (1L << ID))) != 0)) {
				{
				{
				setState(95);
				statement();
				}
				}
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(101);
			match(LLADER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDeclarationContext extends ParserRuleContext {
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
	 
		public FunctionDeclarationContext() { }
		public void copyFrom(FunctionDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FunctionDeclarationASTContext extends FunctionDeclarationContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(miParser.ID, 0); }
		public TerminalNode PIZQ() { return getToken(miParser.PIZQ, 0); }
		public TerminalNode PDER() { return getToken(miParser.PDER, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FormalParamsContext formalParams() {
			return getRuleContext(FormalParamsContext.class,0);
		}
		public FunctionDeclarationASTContext(FunctionDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitFunctionDeclarationAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_functionDeclaration);
		int _la;
		try {
			_localctx = new FunctionDeclarationASTContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			type();
			setState(104);
			match(ID);
			setState(105);
			match(PIZQ);
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << CHAR) | (1L << INT) | (1L << STRING) | (1L << ID))) != 0)) {
				{
				setState(106);
				formalParams();
				}
			}

			setState(109);
			match(PDER);
			setState(110);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalParamsContext extends ParserRuleContext {
		public FormalParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParams; }
	 
		public FormalParamsContext() { }
		public void copyFrom(FormalParamsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FormalParamsASTContext extends FormalParamsContext {
		public List<FormalParamContext> formalParam() {
			return getRuleContexts(FormalParamContext.class);
		}
		public FormalParamContext formalParam(int i) {
			return getRuleContext(FormalParamContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(miParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(miParser.COMA, i);
		}
		public FormalParamsASTContext(FormalParamsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitFormalParamsAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParamsContext formalParams() throws RecognitionException {
		FormalParamsContext _localctx = new FormalParamsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_formalParams);
		int _la;
		try {
			_localctx = new FormalParamsASTContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			formalParam();
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(113);
				match(COMA);
				setState(114);
				formalParam();
				}
				}
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalParamContext extends ParserRuleContext {
		public FormalParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParam; }
	 
		public FormalParamContext() { }
		public void copyFrom(FormalParamContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FormalParamASTContext extends FormalParamContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(miParser.ID, 0); }
		public FormalParamASTContext(FormalParamContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitFormalParamAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParamContext formalParam() throws RecognitionException {
		FormalParamContext _localctx = new FormalParamContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_formalParam);
		try {
			_localctx = new FormalParamASTContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			type();
			setState(121);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileStatementContext extends ParserRuleContext {
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
	 
		public WhileStatementContext() { }
		public void copyFrom(WhileStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class WhileStatementASTContext extends WhileStatementContext {
		public TerminalNode WHILE() { return getToken(miParser.WHILE, 0); }
		public TerminalNode PIZQ() { return getToken(miParser.PIZQ, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PDER() { return getToken(miParser.PDER, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileStatementASTContext(WhileStatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitWhileStatementAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_whileStatement);
		try {
			_localctx = new WhileStatementASTContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(WHILE);
			setState(124);
			match(PIZQ);
			setState(125);
			expression();
			setState(126);
			match(PDER);
			setState(127);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStatementContext extends ParserRuleContext {
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
	 
		public IfStatementContext() { }
		public void copyFrom(IfStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IfStatementASTContext extends IfStatementContext {
		public TerminalNode IF() { return getToken(miParser.IF, 0); }
		public TerminalNode PIZQ() { return getToken(miParser.PIZQ, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PDER() { return getToken(miParser.PDER, 0); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(miParser.ELSE, 0); }
		public IfStatementASTContext(IfStatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitIfStatementAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_ifStatement);
		int _la;
		try {
			_localctx = new IfStatementASTContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(IF);
			setState(130);
			match(PIZQ);
			setState(131);
			expression();
			setState(132);
			match(PDER);
			setState(133);
			block();
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(134);
				match(ELSE);
				setState(135);
				block();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnStatementContext extends ParserRuleContext {
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
	 
		public ReturnStatementContext() { }
		public void copyFrom(ReturnStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ReturnStatementASTContext extends ReturnStatementContext {
		public TerminalNode RETURN() { return getToken(miParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementASTContext(ReturnStatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitReturnStatementAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_returnStatement);
		try {
			_localctx = new ReturnStatementASTContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(RETURN);
			setState(139);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrintStatementContext extends ParserRuleContext {
		public PrintStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStatement; }
	 
		public PrintStatementContext() { }
		public void copyFrom(PrintStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PrintStatementASTContext extends PrintStatementContext {
		public TerminalNode PRINT() { return getToken(miParser.PRINT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrintStatementASTContext(PrintStatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitPrintStatementAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintStatementContext printStatement() throws RecognitionException {
		PrintStatementContext _localctx = new PrintStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_printStatement);
		try {
			_localctx = new PrintStatementASTContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(PRINT);
			setState(142);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDeclarationContext extends ParserRuleContext {
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
	 
		public ClassDeclarationContext() { }
		public void copyFrom(ClassDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ClassDeclarationASTContext extends ClassDeclarationContext {
		public TerminalNode CLASS() { return getToken(miParser.CLASS, 0); }
		public TerminalNode ID() { return getToken(miParser.ID, 0); }
		public TerminalNode LLAIZQ() { return getToken(miParser.LLAIZQ, 0); }
		public TerminalNode LLADER() { return getToken(miParser.LLADER, 0); }
		public List<ClassVariableDeclarationContext> classVariableDeclaration() {
			return getRuleContexts(ClassVariableDeclarationContext.class);
		}
		public ClassVariableDeclarationContext classVariableDeclaration(int i) {
			return getRuleContext(ClassVariableDeclarationContext.class,i);
		}
		public ClassDeclarationASTContext(ClassDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitClassDeclarationAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_classDeclaration);
		int _la;
		try {
			_localctx = new ClassDeclarationASTContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(CLASS);
			setState(145);
			match(ID);
			setState(146);
			match(LLAIZQ);
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << CHAR) | (1L << INT) | (1L << STRING))) != 0)) {
				{
				{
				setState(147);
				classVariableDeclaration();
				}
				}
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(153);
			match(LLADER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassVariableDeclarationContext extends ParserRuleContext {
		public ClassVariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classVariableDeclaration; }
	 
		public ClassVariableDeclarationContext() { }
		public void copyFrom(ClassVariableDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ClassVariableDeclarationASTContext extends ClassVariableDeclarationContext {
		public SimpleTypeContext simpleType() {
			return getRuleContext(SimpleTypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(miParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(miParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ClassVariableDeclarationASTContext(ClassVariableDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitClassVariableDeclarationAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassVariableDeclarationContext classVariableDeclaration() throws RecognitionException {
		ClassVariableDeclarationContext _localctx = new ClassVariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_classVariableDeclaration);
		int _la;
		try {
			_localctx = new ClassVariableDeclarationASTContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			simpleType();
			setState(156);
			match(ID);
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(157);
				match(ASSIGN);
				setState(158);
				expression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDeclarationContext extends ParserRuleContext {
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
	 
		public VariableDeclarationContext() { }
		public void copyFrom(VariableDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VariableDeclarationASTContext extends VariableDeclarationContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(miParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(miParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableDeclarationASTContext(VariableDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitVariableDeclarationAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_variableDeclaration);
		int _la;
		try {
			_localctx = new VariableDeclarationASTContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			type();
			setState(162);
			match(ID);
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(163);
				match(ASSIGN);
				setState(164);
				expression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SimpleTypeTASTContext extends TypeContext {
		public SimpleTypeContext simpleType() {
			return getRuleContext(SimpleTypeContext.class,0);
		}
		public SimpleTypeTASTContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitSimpleTypeTAST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdTASTContext extends TypeContext {
		public TerminalNode ID() { return getToken(miParser.ID, 0); }
		public IdTASTContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitIdTAST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayTypeTASTContext extends TypeContext {
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public ArrayTypeTASTContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitArrayTypeTAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_type);
		try {
			setState(170);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new SimpleTypeTASTContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(167);
				simpleType();
				}
				break;
			case 2:
				_localctx = new ArrayTypeTASTContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(168);
				arrayType();
				}
				break;
			case 3:
				_localctx = new IdTASTContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(169);
				match(ID);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpleTypeContext extends ParserRuleContext {
		public SimpleTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleType; }
	 
		public SimpleTypeContext() { }
		public void copyFrom(SimpleTypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IntSTASTContext extends SimpleTypeContext {
		public TerminalNode INT() { return getToken(miParser.INT, 0); }
		public IntSTASTContext(SimpleTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitIntSTAST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringSTASTContext extends SimpleTypeContext {
		public TerminalNode STRING() { return getToken(miParser.STRING, 0); }
		public StringSTASTContext(SimpleTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitStringSTAST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CharSTASTContext extends SimpleTypeContext {
		public TerminalNode CHAR() { return getToken(miParser.CHAR, 0); }
		public CharSTASTContext(SimpleTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitCharSTAST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanSTASTContext extends SimpleTypeContext {
		public TerminalNode BOOLEAN() { return getToken(miParser.BOOLEAN, 0); }
		public BooleanSTASTContext(SimpleTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitBooleanSTAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleTypeContext simpleType() throws RecognitionException {
		SimpleTypeContext _localctx = new SimpleTypeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_simpleType);
		try {
			setState(176);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
				_localctx = new BooleanSTASTContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(172);
				match(BOOLEAN);
				}
				break;
			case CHAR:
				_localctx = new CharSTASTContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(173);
				match(CHAR);
				}
				break;
			case INT:
				_localctx = new IntSTASTContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(174);
				match(INT);
				}
				break;
			case STRING:
				_localctx = new StringSTASTContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(175);
				match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayTypeContext extends ParserRuleContext {
		public ArrayTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayType; }
	 
		public ArrayTypeContext() { }
		public void copyFrom(ArrayTypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArrayTypeASTContext extends ArrayTypeContext {
		public SimpleTypeContext simpleType() {
			return getRuleContext(SimpleTypeContext.class,0);
		}
		public TerminalNode PCIZQ() { return getToken(miParser.PCIZQ, 0); }
		public TerminalNode PCDER() { return getToken(miParser.PCDER, 0); }
		public ArrayTypeASTContext(ArrayTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitArrayTypeAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayTypeContext arrayType() throws RecognitionException {
		ArrayTypeContext _localctx = new ArrayTypeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_arrayType);
		try {
			_localctx = new ArrayTypeASTContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			simpleType();
			setState(179);
			match(PCIZQ);
			setState(180);
			match(PCDER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	 
		public AssignmentContext() { }
		public void copyFrom(AssignmentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AssignmentASTContext extends AssignmentContext {
		public List<TerminalNode> ID() { return getTokens(miParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(miParser.ID, i);
		}
		public TerminalNode ASSIGN() { return getToken(miParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode POINT() { return getToken(miParser.POINT, 0); }
		public AssignmentASTContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitAssignmentAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_assignment);
		int _la;
		try {
			_localctx = new AssignmentASTContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			match(ID);
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==POINT) {
				{
				setState(183);
				match(POINT);
				setState(184);
				match(ID);
				}
			}

			setState(187);
			match(ASSIGN);
			setState(188);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayAssignmentContext extends ParserRuleContext {
		public ArrayAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayAssignment; }
	 
		public ArrayAssignmentContext() { }
		public void copyFrom(ArrayAssignmentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArrayAssignmentASTContext extends ArrayAssignmentContext {
		public TerminalNode ID() { return getToken(miParser.ID, 0); }
		public TerminalNode PCIZQ() { return getToken(miParser.PCIZQ, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode PCDER() { return getToken(miParser.PCDER, 0); }
		public TerminalNode ASSIGN() { return getToken(miParser.ASSIGN, 0); }
		public ArrayAssignmentASTContext(ArrayAssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitArrayAssignmentAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayAssignmentContext arrayAssignment() throws RecognitionException {
		ArrayAssignmentContext _localctx = new ArrayAssignmentContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_arrayAssignment);
		try {
			_localctx = new ArrayAssignmentASTContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(ID);
			setState(191);
			match(PCIZQ);
			setState(192);
			expression();
			setState(193);
			match(PCDER);
			setState(194);
			match(ASSIGN);
			setState(195);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExpressionASTContext extends ExpressionContext {
		public List<SimpleExpressionContext> simpleExpression() {
			return getRuleContexts(SimpleExpressionContext.class);
		}
		public SimpleExpressionContext simpleExpression(int i) {
			return getRuleContext(SimpleExpressionContext.class,i);
		}
		public List<TerminalNode> REOPERATOR() { return getTokens(miParser.REOPERATOR); }
		public TerminalNode REOPERATOR(int i) {
			return getToken(miParser.REOPERATOR, i);
		}
		public ExpressionASTContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitExpressionAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_expression);
		try {
			int _alt;
			_localctx = new ExpressionASTContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			simpleExpression();
			setState(202);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(198);
					match(REOPERATOR);
					setState(199);
					simpleExpression();
					}
					} 
				}
				setState(204);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpleExpressionContext extends ParserRuleContext {
		public SimpleExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleExpression; }
	 
		public SimpleExpressionContext() { }
		public void copyFrom(SimpleExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SimpleExpressionASTContext extends SimpleExpressionContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> ADDITIVEOP() { return getTokens(miParser.ADDITIVEOP); }
		public TerminalNode ADDITIVEOP(int i) {
			return getToken(miParser.ADDITIVEOP, i);
		}
		public SimpleExpressionASTContext(SimpleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitSimpleExpressionAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleExpressionContext simpleExpression() throws RecognitionException {
		SimpleExpressionContext _localctx = new SimpleExpressionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_simpleExpression);
		try {
			int _alt;
			_localctx = new SimpleExpressionASTContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			term();
			setState(210);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(206);
					match(ADDITIVEOP);
					setState(207);
					term();
					}
					} 
				}
				setState(212);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	 
		public TermContext() { }
		public void copyFrom(TermContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TermASTContext extends TermContext {
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<TerminalNode> MULTIPLICATEOP() { return getTokens(miParser.MULTIPLICATEOP); }
		public TerminalNode MULTIPLICATEOP(int i) {
			return getToken(miParser.MULTIPLICATEOP, i);
		}
		public TermASTContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitTermAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_term);
		try {
			int _alt;
			_localctx = new TermASTContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			factor();
			setState(218);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(214);
					match(MULTIPLICATEOP);
					setState(215);
					factor();
					}
					} 
				}
				setState(220);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FactorContext extends ParserRuleContext {
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	 
		public FactorContext() { }
		public void copyFrom(FactorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FunctionCallFASTContext extends FactorContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public FunctionCallFASTContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitFunctionCallFAST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayAllocationExpressionFASTContext extends FactorContext {
		public ArrayAllocationExpressionContext arrayAllocationExpression() {
			return getRuleContext(ArrayAllocationExpressionContext.class,0);
		}
		public AllocationExpressionContext allocationExpression() {
			return getRuleContext(AllocationExpressionContext.class,0);
		}
		public ArrayAllocationExpressionFASTContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitArrayAllocationExpressionFAST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LiteralFASTContext extends FactorContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LiteralFASTContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitLiteralFAST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdFASTContext extends FactorContext {
		public List<TerminalNode> ID() { return getTokens(miParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(miParser.ID, i);
		}
		public TerminalNode POINT() { return getToken(miParser.POINT, 0); }
		public IdFASTContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitIdFAST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubExpressionFASTContext extends FactorContext {
		public SubExpressionContext subExpression() {
			return getRuleContext(SubExpressionContext.class,0);
		}
		public SubExpressionFASTContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitSubExpressionFAST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryFASTContext extends FactorContext {
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public UnaryFASTContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitUnaryFAST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayLookupFASTContext extends FactorContext {
		public ArrayLookupContext arrayLookup() {
			return getRuleContext(ArrayLookupContext.class,0);
		}
		public ArrayLookupFASTContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitArrayLookupFAST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayLengthFASTContext extends FactorContext {
		public ArrayLengthContext arrayLength() {
			return getRuleContext(ArrayLengthContext.class,0);
		}
		public ArrayLengthFASTContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitArrayLengthFAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_factor);
		int _la;
		try {
			setState(234);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				_localctx = new LiteralFASTContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(221);
				literal();
				}
				break;
			case 2:
				_localctx = new IdFASTContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(222);
				match(ID);
				setState(225);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==POINT) {
					{
					setState(223);
					match(POINT);
					setState(224);
					match(ID);
					}
				}

				}
				break;
			case 3:
				_localctx = new FunctionCallFASTContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(227);
				functionCall();
				}
				break;
			case 4:
				_localctx = new ArrayLookupFASTContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(228);
				arrayLookup();
				}
				break;
			case 5:
				_localctx = new ArrayLengthFASTContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(229);
				arrayLength();
				}
				break;
			case 6:
				_localctx = new SubExpressionFASTContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(230);
				subExpression();
				}
				break;
			case 7:
				_localctx = new ArrayAllocationExpressionFASTContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(231);
				arrayAllocationExpression();
				}
				break;
			case 8:
				_localctx = new ArrayAllocationExpressionFASTContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(232);
				allocationExpression();
				}
				break;
			case 9:
				_localctx = new UnaryFASTContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(233);
				unary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryContext extends ParserRuleContext {
		public UnaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary; }
	 
		public UnaryContext() { }
		public void copyFrom(UnaryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class UnaryASTContext extends UnaryContext {
		public TerminalNode UNARY() { return getToken(miParser.UNARY, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public UnaryASTContext(UnaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitUnaryAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryContext unary() throws RecognitionException {
		UnaryContext _localctx = new UnaryContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_unary);
		try {
			int _alt;
			_localctx = new UnaryASTContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			match(UNARY);
			setState(240);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(237);
					expression();
					}
					} 
				}
				setState(242);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AllocationExpressionContext extends ParserRuleContext {
		public AllocationExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_allocationExpression; }
	 
		public AllocationExpressionContext() { }
		public void copyFrom(AllocationExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AllocationExpressionASTContext extends AllocationExpressionContext {
		public TerminalNode NEW() { return getToken(miParser.NEW, 0); }
		public TerminalNode ID() { return getToken(miParser.ID, 0); }
		public TerminalNode PIZQ() { return getToken(miParser.PIZQ, 0); }
		public TerminalNode PDER() { return getToken(miParser.PDER, 0); }
		public AllocationExpressionASTContext(AllocationExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitAllocationExpressionAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AllocationExpressionContext allocationExpression() throws RecognitionException {
		AllocationExpressionContext _localctx = new AllocationExpressionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_allocationExpression);
		try {
			_localctx = new AllocationExpressionASTContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			match(NEW);
			setState(244);
			match(ID);
			setState(245);
			match(PIZQ);
			setState(246);
			match(PDER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayAllocationExpressionContext extends ParserRuleContext {
		public ArrayAllocationExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayAllocationExpression; }
	 
		public ArrayAllocationExpressionContext() { }
		public void copyFrom(ArrayAllocationExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArrayAllocationExpressionASTContext extends ArrayAllocationExpressionContext {
		public TerminalNode NEW() { return getToken(miParser.NEW, 0); }
		public SimpleTypeContext simpleType() {
			return getRuleContext(SimpleTypeContext.class,0);
		}
		public TerminalNode PCIZQ() { return getToken(miParser.PCIZQ, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PCDER() { return getToken(miParser.PCDER, 0); }
		public ArrayAllocationExpressionASTContext(ArrayAllocationExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitArrayAllocationExpressionAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayAllocationExpressionContext arrayAllocationExpression() throws RecognitionException {
		ArrayAllocationExpressionContext _localctx = new ArrayAllocationExpressionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_arrayAllocationExpression);
		try {
			_localctx = new ArrayAllocationExpressionASTContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			match(NEW);
			setState(249);
			simpleType();
			setState(250);
			match(PCIZQ);
			setState(251);
			expression();
			setState(252);
			match(PCDER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubExpressionContext extends ParserRuleContext {
		public SubExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subExpression; }
	 
		public SubExpressionContext() { }
		public void copyFrom(SubExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SubExpressionASTContext extends SubExpressionContext {
		public TerminalNode PIZQ() { return getToken(miParser.PIZQ, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PDER() { return getToken(miParser.PDER, 0); }
		public SubExpressionASTContext(SubExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitSubExpressionAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubExpressionContext subExpression() throws RecognitionException {
		SubExpressionContext _localctx = new SubExpressionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_subExpression);
		try {
			_localctx = new SubExpressionASTContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			match(PIZQ);
			setState(255);
			expression();
			setState(256);
			match(PDER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionCallContext extends ParserRuleContext {
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
	 
		public FunctionCallContext() { }
		public void copyFrom(FunctionCallContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FunctionCallASTContext extends FunctionCallContext {
		public TerminalNode ID() { return getToken(miParser.ID, 0); }
		public TerminalNode PIZQ() { return getToken(miParser.PIZQ, 0); }
		public TerminalNode PDER() { return getToken(miParser.PDER, 0); }
		public ActualParamsContext actualParams() {
			return getRuleContext(ActualParamsContext.class,0);
		}
		public FunctionCallASTContext(FunctionCallContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitFunctionCallAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_functionCall);
		int _la;
		try {
			_localctx = new FunctionCallASTContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			match(ID);
			setState(259);
			match(PIZQ);
			setState(261);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PIZQ) | (1L << TRUE) | (1L << FALSE) | (1L << UNARY) | (1L << NEW) | (1L << ID) | (1L << INTLITERAL) | (1L << REALLITERAL) | (1L << STRINGLITERAL))) != 0)) {
				{
				setState(260);
				actualParams();
				}
			}

			setState(263);
			match(PDER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ActualParamsContext extends ParserRuleContext {
		public ActualParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actualParams; }
	 
		public ActualParamsContext() { }
		public void copyFrom(ActualParamsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ActualParamsASTContext extends ActualParamsContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(miParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(miParser.COMA, i);
		}
		public ActualParamsASTContext(ActualParamsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitActualParamsAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActualParamsContext actualParams() throws RecognitionException {
		ActualParamsContext _localctx = new ActualParamsContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_actualParams);
		int _la;
		try {
			_localctx = new ActualParamsASTContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			expression();
			setState(270);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(266);
				match(COMA);
				setState(267);
				expression();
				}
				}
				setState(272);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayLookupContext extends ParserRuleContext {
		public ArrayLookupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayLookup; }
	 
		public ArrayLookupContext() { }
		public void copyFrom(ArrayLookupContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArrayLookupASTContext extends ArrayLookupContext {
		public TerminalNode ID() { return getToken(miParser.ID, 0); }
		public TerminalNode PCIZQ() { return getToken(miParser.PCIZQ, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PCDER() { return getToken(miParser.PCDER, 0); }
		public ArrayLookupASTContext(ArrayLookupContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitArrayLookupAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayLookupContext arrayLookup() throws RecognitionException {
		ArrayLookupContext _localctx = new ArrayLookupContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_arrayLookup);
		try {
			_localctx = new ArrayLookupASTContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			match(ID);
			setState(274);
			match(PCIZQ);
			setState(275);
			expression();
			setState(276);
			match(PCDER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayLengthContext extends ParserRuleContext {
		public ArrayLengthContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayLength; }
	 
		public ArrayLengthContext() { }
		public void copyFrom(ArrayLengthContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArrayLengthASTContext extends ArrayLengthContext {
		public TerminalNode ID() { return getToken(miParser.ID, 0); }
		public TerminalNode POINT() { return getToken(miParser.POINT, 0); }
		public TerminalNode LENGTH() { return getToken(miParser.LENGTH, 0); }
		public ArrayLengthASTContext(ArrayLengthContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitArrayLengthAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayLengthContext arrayLength() throws RecognitionException {
		ArrayLengthContext _localctx = new ArrayLengthContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_arrayLength);
		try {
			_localctx = new ArrayLengthASTContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			match(ID);
			setState(279);
			match(POINT);
			setState(280);
			match(LENGTH);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolLiteralContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(miParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(miParser.FALSE, 0); }
		public BoolLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolLiteral; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitBoolLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolLiteralContext boolLiteral() throws RecognitionException {
		BoolLiteralContext _localctx = new BoolLiteralContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_boolLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(282);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	 
		public LiteralContext() { }
		public void copyFrom(LiteralContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RealLASTContext extends LiteralContext {
		public TerminalNode REALLITERAL() { return getToken(miParser.REALLITERAL, 0); }
		public RealLASTContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitRealLAST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolLASTContext extends LiteralContext {
		public BoolLiteralContext boolLiteral() {
			return getRuleContext(BoolLiteralContext.class,0);
		}
		public BoolLASTContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitBoolLAST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntLASTContext extends LiteralContext {
		public TerminalNode INTLITERAL() { return getToken(miParser.INTLITERAL, 0); }
		public IntLASTContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitIntLAST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringLASTContext extends LiteralContext {
		public TerminalNode STRINGLITERAL() { return getToken(miParser.STRINGLITERAL, 0); }
		public StringLASTContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miParserVisitor ) return ((miParserVisitor<? extends T>)visitor).visitStringLAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_literal);
		try {
			setState(288);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTLITERAL:
				_localctx = new IntLASTContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(284);
				match(INTLITERAL);
				}
				break;
			case REALLITERAL:
				_localctx = new RealLASTContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(285);
				match(REALLITERAL);
				}
				break;
			case TRUE:
			case FALSE:
				_localctx = new BoolLASTContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(286);
				boolLiteral();
				}
				break;
			case STRINGLITERAL:
				_localctx = new StringLASTContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(287);
				match(STRINGLITERAL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3.\u0125\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\7\2D\n\2\f\2\16\2G\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3_\n\3\3\4\3\4\7"+
		"\4c\n\4\f\4\16\4f\13\4\3\4\3\4\3\5\3\5\3\5\3\5\5\5n\n\5\3\5\3\5\3\5\3"+
		"\6\3\6\3\6\7\6v\n\6\f\6\16\6y\13\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u008b\n\t\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\f\7\f\u0097\n\f\f\f\16\f\u009a\13\f\3\f\3\f\3\r\3\r\3\r"+
		"\3\r\5\r\u00a2\n\r\3\16\3\16\3\16\3\16\5\16\u00a8\n\16\3\17\3\17\3\17"+
		"\5\17\u00ad\n\17\3\20\3\20\3\20\3\20\5\20\u00b3\n\20\3\21\3\21\3\21\3"+
		"\21\3\22\3\22\3\22\5\22\u00bc\n\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\24\3\24\3\24\7\24\u00cb\n\24\f\24\16\24\u00ce\13\24"+
		"\3\25\3\25\3\25\7\25\u00d3\n\25\f\25\16\25\u00d6\13\25\3\26\3\26\3\26"+
		"\7\26\u00db\n\26\f\26\16\26\u00de\13\26\3\27\3\27\3\27\3\27\5\27\u00e4"+
		"\n\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u00ed\n\27\3\30\3\30\7\30"+
		"\u00f1\n\30\f\30\16\30\u00f4\13\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\34\3\34\3\34\5\34\u0108\n\34"+
		"\3\34\3\34\3\35\3\35\3\35\7\35\u010f\n\35\f\35\16\35\u0112\13\35\3\36"+
		"\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3 \3 \3!\3!\3!\3!\5!\u0123\n"+
		"!\3!\2\2\"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\66"+
		"8:<>@\2\3\3\2\30\31\2\u012d\2E\3\2\2\2\4^\3\2\2\2\6`\3\2\2\2\bi\3\2\2"+
		"\2\nr\3\2\2\2\fz\3\2\2\2\16}\3\2\2\2\20\u0083\3\2\2\2\22\u008c\3\2\2\2"+
		"\24\u008f\3\2\2\2\26\u0092\3\2\2\2\30\u009d\3\2\2\2\32\u00a3\3\2\2\2\34"+
		"\u00ac\3\2\2\2\36\u00b2\3\2\2\2 \u00b4\3\2\2\2\"\u00b8\3\2\2\2$\u00c0"+
		"\3\2\2\2&\u00c7\3\2\2\2(\u00cf\3\2\2\2*\u00d7\3\2\2\2,\u00ec\3\2\2\2."+
		"\u00ee\3\2\2\2\60\u00f5\3\2\2\2\62\u00fa\3\2\2\2\64\u0100\3\2\2\2\66\u0104"+
		"\3\2\2\28\u010b\3\2\2\2:\u0113\3\2\2\2<\u0118\3\2\2\2>\u011c\3\2\2\2@"+
		"\u0122\3\2\2\2BD\5\4\3\2CB\3\2\2\2DG\3\2\2\2EC\3\2\2\2EF\3\2\2\2F\3\3"+
		"\2\2\2GE\3\2\2\2HI\5\32\16\2IJ\7\3\2\2J_\3\2\2\2KL\5\26\f\2LM\7\3\2\2"+
		"M_\3\2\2\2NO\5\"\22\2OP\7\3\2\2P_\3\2\2\2QR\5$\23\2RS\7\3\2\2S_\3\2\2"+
		"\2TU\5\24\13\2UV\7\3\2\2V_\3\2\2\2W_\5\20\t\2X_\5\16\b\2YZ\5\22\n\2Z["+
		"\7\3\2\2[_\3\2\2\2\\_\5\b\5\2]_\5\6\4\2^H\3\2\2\2^K\3\2\2\2^N\3\2\2\2"+
		"^Q\3\2\2\2^T\3\2\2\2^W\3\2\2\2^X\3\2\2\2^Y\3\2\2\2^\\\3\2\2\2^]\3\2\2"+
		"\2_\5\3\2\2\2`d\7\r\2\2ac\5\4\3\2ba\3\2\2\2cf\3\2\2\2db\3\2\2\2de\3\2"+
		"\2\2eg\3\2\2\2fd\3\2\2\2gh\7\16\2\2h\7\3\2\2\2ij\5\34\17\2jk\7*\2\2km"+
		"\7\13\2\2ln\5\n\6\2ml\3\2\2\2mn\3\2\2\2no\3\2\2\2op\7\f\2\2pq\5\6\4\2"+
		"q\t\3\2\2\2rw\5\f\7\2st\7\4\2\2tv\5\f\7\2us\3\2\2\2vy\3\2\2\2wu\3\2\2"+
		"\2wx\3\2\2\2x\13\3\2\2\2yw\3\2\2\2z{\5\34\17\2{|\7*\2\2|\r\3\2\2\2}~\7"+
		"$\2\2~\177\7\13\2\2\177\u0080\5&\24\2\u0080\u0081\7\f\2\2\u0081\u0082"+
		"\5\6\4\2\u0082\17\3\2\2\2\u0083\u0084\7\"\2\2\u0084\u0085\7\13\2\2\u0085"+
		"\u0086\5&\24\2\u0086\u0087\7\f\2\2\u0087\u008a\5\6\4\2\u0088\u0089\7#"+
		"\2\2\u0089\u008b\5\6\4\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b"+
		"\21\3\2\2\2\u008c\u008d\7%\2\2\u008d\u008e\5&\24\2\u008e\23\3\2\2\2\u008f"+
		"\u0090\7\'\2\2\u0090\u0091\5&\24\2\u0091\25\3\2\2\2\u0092\u0093\7&\2\2"+
		"\u0093\u0094\7*\2\2\u0094\u0098\7\r\2\2\u0095\u0097\5\30\r\2\u0096\u0095"+
		"\3\2\2\2\u0097\u009a\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099"+
		"\u009b\3\2\2\2\u009a\u0098\3\2\2\2\u009b\u009c\7\16\2\2\u009c\27\3\2\2"+
		"\2\u009d\u009e\5\36\20\2\u009e\u00a1\7*\2\2\u009f\u00a0\7\b\2\2\u00a0"+
		"\u00a2\5&\24\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\31\3\2\2"+
		"\2\u00a3\u00a4\5\34\17\2\u00a4\u00a7\7*\2\2\u00a5\u00a6\7\b\2\2\u00a6"+
		"\u00a8\5&\24\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\33\3\2\2"+
		"\2\u00a9\u00ad\5\36\20\2\u00aa\u00ad\5 \21\2\u00ab\u00ad\7*\2\2\u00ac"+
		"\u00a9\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ab\3\2\2\2\u00ad\35\3\2\2"+
		"\2\u00ae\u00b3\7\24\2\2\u00af\u00b3\7\25\2\2\u00b0\u00b3\7\26\2\2\u00b1"+
		"\u00b3\7\27\2\2\u00b2\u00ae\3\2\2\2\u00b2\u00af\3\2\2\2\u00b2\u00b0\3"+
		"\2\2\2\u00b2\u00b1\3\2\2\2\u00b3\37\3\2\2\2\u00b4\u00b5\5\36\20\2\u00b5"+
		"\u00b6\7\17\2\2\u00b6\u00b7\7\20\2\2\u00b7!\3\2\2\2\u00b8\u00bb\7*\2\2"+
		"\u00b9\u00ba\7\6\2\2\u00ba\u00bc\7*\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc"+
		"\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00be\7\b\2\2\u00be\u00bf\5&\24\2\u00bf"+
		"#\3\2\2\2\u00c0\u00c1\7*\2\2\u00c1\u00c2\7\17\2\2\u00c2\u00c3\5&\24\2"+
		"\u00c3\u00c4\7\20\2\2\u00c4\u00c5\7\b\2\2\u00c5\u00c6\5&\24\2\u00c6%\3"+
		"\2\2\2\u00c7\u00cc\5(\25\2\u00c8\u00c9\7\21\2\2\u00c9\u00cb\5(\25\2\u00ca"+
		"\u00c8\3\2\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2"+
		"\2\2\u00cd\'\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00d4\5*\26\2\u00d0\u00d1"+
		"\7\22\2\2\u00d1\u00d3\5*\26\2\u00d2\u00d0\3\2\2\2\u00d3\u00d6\3\2\2\2"+
		"\u00d4\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5)\3\2\2\2\u00d6\u00d4\3"+
		"\2\2\2\u00d7\u00dc\5,\27\2\u00d8\u00d9\7\23\2\2\u00d9\u00db\5,\27\2\u00da"+
		"\u00d8\3\2\2\2\u00db\u00de\3\2\2\2\u00dc\u00da\3\2\2\2\u00dc\u00dd\3\2"+
		"\2\2\u00dd+\3\2\2\2\u00de\u00dc\3\2\2\2\u00df\u00ed\5@!\2\u00e0\u00e3"+
		"\7*\2\2\u00e1\u00e2\7\6\2\2\u00e2\u00e4\7*\2\2\u00e3\u00e1\3\2\2\2\u00e3"+
		"\u00e4\3\2\2\2\u00e4\u00ed\3\2\2\2\u00e5\u00ed\5\66\34\2\u00e6\u00ed\5"+
		":\36\2\u00e7\u00ed\5<\37\2\u00e8\u00ed\5\64\33\2\u00e9\u00ed\5\62\32\2"+
		"\u00ea\u00ed\5\60\31\2\u00eb\u00ed\5.\30\2\u00ec\u00df\3\2\2\2\u00ec\u00e0"+
		"\3\2\2\2\u00ec\u00e5\3\2\2\2\u00ec\u00e6\3\2\2\2\u00ec\u00e7\3\2\2\2\u00ec"+
		"\u00e8\3\2\2\2\u00ec\u00e9\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00eb\3\2"+
		"\2\2\u00ed-\3\2\2\2\u00ee\u00f2\7!\2\2\u00ef\u00f1\5&\24\2\u00f0\u00ef"+
		"\3\2\2\2\u00f1\u00f4\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3"+
		"/\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f5\u00f6\7(\2\2\u00f6\u00f7\7*\2\2\u00f7"+
		"\u00f8\7\13\2\2\u00f8\u00f9\7\f\2\2\u00f9\61\3\2\2\2\u00fa\u00fb\7(\2"+
		"\2\u00fb\u00fc\5\36\20\2\u00fc\u00fd\7\17\2\2\u00fd\u00fe\5&\24\2\u00fe"+
		"\u00ff\7\20\2\2\u00ff\63\3\2\2\2\u0100\u0101\7\13\2\2\u0101\u0102\5&\24"+
		"\2\u0102\u0103\7\f\2\2\u0103\65\3\2\2\2\u0104\u0105\7*\2\2\u0105\u0107"+
		"\7\13\2\2\u0106\u0108\58\35\2\u0107\u0106\3\2\2\2\u0107\u0108\3\2\2\2"+
		"\u0108\u0109\3\2\2\2\u0109\u010a\7\f\2\2\u010a\67\3\2\2\2\u010b\u0110"+
		"\5&\24\2\u010c\u010d\7\4\2\2\u010d\u010f\5&\24\2\u010e\u010c\3\2\2\2\u010f"+
		"\u0112\3\2\2\2\u0110\u010e\3\2\2\2\u0110\u0111\3\2\2\2\u01119\3\2\2\2"+
		"\u0112\u0110\3\2\2\2\u0113\u0114\7*\2\2\u0114\u0115\7\17\2\2\u0115\u0116"+
		"\5&\24\2\u0116\u0117\7\20\2\2\u0117;\3\2\2\2\u0118\u0119\7*\2\2\u0119"+
		"\u011a\7\6\2\2\u011a\u011b\7)\2\2\u011b=\3\2\2\2\u011c\u011d\t\2\2\2\u011d"+
		"?\3\2\2\2\u011e\u0123\7+\2\2\u011f\u0123\7,\2\2\u0120\u0123\5> \2\u0121"+
		"\u0123\7-\2\2\u0122\u011e\3\2\2\2\u0122\u011f\3\2\2\2\u0122\u0120\3\2"+
		"\2\2\u0122\u0121\3\2\2\2\u0123A\3\2\2\2\27E^dmw\u008a\u0098\u00a1\u00a7"+
		"\u00ac\u00b2\u00bb\u00cc\u00d4\u00dc\u00e3\u00ec\u00f2\u0107\u0110\u0122";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}