// Generated from C:/Users/Lester Trejos/Documents/Compi/proyecto2compi\miScanner.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class miScanner extends Lexer {
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
		LENGTH=39, ID=40, INTLITERAL=41, REALLITERAL=42, STRINGLITERAL=43, CHARLITERAL=44, 
		WS=45;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PyComa", "COMA", "UNDERSC", "POINT", "COMIDOBLES", "ASSIGN", "VIR", 
			"DOSPUN", "PIZQ", "PDER", "LLAIZQ", "LLADER", "PCIZQ", "PCDER", "MENOR", 
			"MAYOR", "IGUAL", "DIFERENTE", "MENORIGUAL", "MAYORIGUAL", "REOPERATOR", 
			"ADDITIVEOP", "MULTIPLICATEOP", "BOOLEAN", "CHAR", "INT", "STRING", "TRUE", 
			"FALSE", "SUM", "SUB", "OR", "MUL", "DIV", "AND", "INTERROGATION", "UNARY", 
			"IF", "ELSE", "WHILE", "RETURN", "CLASS", "PRINT", "NEW", "LENGTH", "ID", 
			"INTLITERAL", "REALLITERAL", "STRINGLITERAL", "CHARLITERAL", "DIGIT", 
			"LETTER", "PRINTABLE", "CharContenido", "CharInicial", "WS"
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
			"INTLITERAL", "REALLITERAL", "STRINGLITERAL", "CHARLITERAL", "WS"
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


	public miScanner(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "miScanner.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2/\u017d\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\3\2\3\2\3\3\3\3\3\4\3\4"+
		"\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r"+
		"\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\23\3\23"+
		"\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\5\26"+
		"\u00a6\n\26\3\27\3\27\3\27\5\27\u00ab\n\27\3\30\3\30\3\30\5\30\u00b0\n"+
		"\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3"+
		"\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3"+
		"\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3!\3\"\3"+
		"\"\3#\3#\3$\3$\3$\3$\3%\3%\3&\3&\3&\5&\u00e9\n&\3\'\3\'\3\'\3(\3(\3(\3"+
		"(\3(\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3,\3,\3"+
		",\3,\3,\3,\3-\3-\3-\3-\3.\3.\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\7/\u011c\n"+
		"/\f/\16/\u011f\13/\5/\u0121\n/\3\60\3\60\7\60\u0125\n\60\f\60\16\60\u0128"+
		"\13\60\3\61\3\61\7\61\u012c\n\61\f\61\16\61\u012f\13\61\3\61\3\61\7\61"+
		"\u0133\n\61\f\61\16\61\u0136\13\61\3\61\3\61\3\61\7\61\u013b\n\61\f\61"+
		"\16\61\u013e\13\61\5\61\u0140\n\61\3\62\3\62\7\62\u0144\n\62\f\62\16\62"+
		"\u0147\13\62\3\62\3\62\3\63\3\63\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3"+
		"\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3"+
		"\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\5\66\u016f"+
		"\n\66\3\67\3\67\5\67\u0173\n\67\38\38\39\69\u0178\n9\r9\169\u0179\39\3"+
		"9\2\2:\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17"+
		"\35\20\37\2!\2#\2%\2\'\2)\2+\21-\22/\23\61\24\63\25\65\26\67\279\30;\31"+
		"=\32?\33A\34C\35E\36G\37I K!M\"O#Q$S%U&W\'Y([)]*_+a,c-e.g\2i\2k\2m\2o"+
		"\2q/\3\2\6\4\2C\\c|\7\2\62;aa\u00b9\u00b9\u0302\u0371\u2041\u2042\17\2"+
		"C\\c|\u00c2\u00d8\u00da\u00f8\u00fa\u0301\u0372\u037f\u0381\u2001\u200e"+
		"\u200f\u2072\u2191\u2c02\u2ff1\u3003\ud801\uf902\ufdd1\ufdf2\uffff\5\2"+
		"\13\f\17\17\"\"\2\u01a3\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2"+
		"\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2"+
		"Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3"+
		"\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2q\3\2\2\2\3s\3\2\2"+
		"\2\5u\3\2\2\2\7w\3\2\2\2\ty\3\2\2\2\13{\3\2\2\2\r}\3\2\2\2\17\177\3\2"+
		"\2\2\21\u0081\3\2\2\2\23\u0083\3\2\2\2\25\u0085\3\2\2\2\27\u0087\3\2\2"+
		"\2\31\u0089\3\2\2\2\33\u008b\3\2\2\2\35\u008d\3\2\2\2\37\u008f\3\2\2\2"+
		"!\u0091\3\2\2\2#\u0093\3\2\2\2%\u0096\3\2\2\2\'\u0099\3\2\2\2)\u009c\3"+
		"\2\2\2+\u00a5\3\2\2\2-\u00aa\3\2\2\2/\u00af\3\2\2\2\61\u00b1\3\2\2\2\63"+
		"\u00b9\3\2\2\2\65\u00be\3\2\2\2\67\u00c2\3\2\2\29\u00c9\3\2\2\2;\u00ce"+
		"\3\2\2\2=\u00d4\3\2\2\2?\u00d6\3\2\2\2A\u00d8\3\2\2\2C\u00db\3\2\2\2E"+
		"\u00dd\3\2\2\2G\u00df\3\2\2\2I\u00e3\3\2\2\2K\u00e8\3\2\2\2M\u00ea\3\2"+
		"\2\2O\u00ed\3\2\2\2Q\u00f2\3\2\2\2S\u00f8\3\2\2\2U\u00ff\3\2\2\2W\u0105"+
		"\3\2\2\2Y\u010b\3\2\2\2[\u010f\3\2\2\2]\u0120\3\2\2\2_\u0122\3\2\2\2a"+
		"\u013f\3\2\2\2c\u0141\3\2\2\2e\u014a\3\2\2\2g\u014e\3\2\2\2i\u0150\3\2"+
		"\2\2k\u016e\3\2\2\2m\u0172\3\2\2\2o\u0174\3\2\2\2q\u0177\3\2\2\2st\7="+
		"\2\2t\4\3\2\2\2uv\7.\2\2v\6\3\2\2\2wx\7a\2\2x\b\3\2\2\2yz\7\60\2\2z\n"+
		"\3\2\2\2{|\7$\2\2|\f\3\2\2\2}~\7?\2\2~\16\3\2\2\2\177\u0080\7\u0080\2"+
		"\2\u0080\20\3\2\2\2\u0081\u0082\7<\2\2\u0082\22\3\2\2\2\u0083\u0084\7"+
		"*\2\2\u0084\24\3\2\2\2\u0085\u0086\7+\2\2\u0086\26\3\2\2\2\u0087\u0088"+
		"\7}\2\2\u0088\30\3\2\2\2\u0089\u008a\7\177\2\2\u008a\32\3\2\2\2\u008b"+
		"\u008c\7]\2\2\u008c\34\3\2\2\2\u008d\u008e\7_\2\2\u008e\36\3\2\2\2\u008f"+
		"\u0090\7>\2\2\u0090 \3\2\2\2\u0091\u0092\7@\2\2\u0092\"\3\2\2\2\u0093"+
		"\u0094\7?\2\2\u0094\u0095\7?\2\2\u0095$\3\2\2\2\u0096\u0097\7#\2\2\u0097"+
		"\u0098\7?\2\2\u0098&\3\2\2\2\u0099\u009a\7>\2\2\u009a\u009b\7?\2\2\u009b"+
		"(\3\2\2\2\u009c\u009d\7@\2\2\u009d\u009e\7?\2\2\u009e*\3\2\2\2\u009f\u00a6"+
		"\5\37\20\2\u00a0\u00a6\5!\21\2\u00a1\u00a6\5#\22\2\u00a2\u00a6\5%\23\2"+
		"\u00a3\u00a6\5\'\24\2\u00a4\u00a6\5)\25\2\u00a5\u009f\3\2\2\2\u00a5\u00a0"+
		"\3\2\2\2\u00a5\u00a1\3\2\2\2\u00a5\u00a2\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5"+
		"\u00a4\3\2\2\2\u00a6,\3\2\2\2\u00a7\u00ab\5=\37\2\u00a8\u00ab\5? \2\u00a9"+
		"\u00ab\5A!\2\u00aa\u00a7\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00a9\3\2\2"+
		"\2\u00ab.\3\2\2\2\u00ac\u00b0\5C\"\2\u00ad\u00b0\5E#\2\u00ae\u00b0\5G"+
		"$\2\u00af\u00ac\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00ae\3\2\2\2\u00b0"+
		"\60\3\2\2\2\u00b1\u00b2\7d\2\2\u00b2\u00b3\7q\2\2\u00b3\u00b4\7q\2\2\u00b4"+
		"\u00b5\7n\2\2\u00b5\u00b6\7g\2\2\u00b6\u00b7\7c\2\2\u00b7\u00b8\7p\2\2"+
		"\u00b8\62\3\2\2\2\u00b9\u00ba\7e\2\2\u00ba\u00bb\7j\2\2\u00bb\u00bc\7"+
		"c\2\2\u00bc\u00bd\7t\2\2\u00bd\64\3\2\2\2\u00be\u00bf\7k\2\2\u00bf\u00c0"+
		"\7p\2\2\u00c0\u00c1\7v\2\2\u00c1\66\3\2\2\2\u00c2\u00c3\7u\2\2\u00c3\u00c4"+
		"\7v\2\2\u00c4\u00c5\7t\2\2\u00c5\u00c6\7k\2\2\u00c6\u00c7\7p\2\2\u00c7"+
		"\u00c8\7i\2\2\u00c88\3\2\2\2\u00c9\u00ca\7v\2\2\u00ca\u00cb\7t\2\2\u00cb"+
		"\u00cc\7w\2\2\u00cc\u00cd\7g\2\2\u00cd:\3\2\2\2\u00ce\u00cf\7h\2\2\u00cf"+
		"\u00d0\7c\2\2\u00d0\u00d1\7n\2\2\u00d1\u00d2\7u\2\2\u00d2\u00d3\7g\2\2"+
		"\u00d3<\3\2\2\2\u00d4\u00d5\7-\2\2\u00d5>\3\2\2\2\u00d6\u00d7\7/\2\2\u00d7"+
		"@\3\2\2\2\u00d8\u00d9\7q\2\2\u00d9\u00da\7t\2\2\u00daB\3\2\2\2\u00db\u00dc"+
		"\7,\2\2\u00dcD\3\2\2\2\u00dd\u00de\7\61\2\2\u00deF\3\2\2\2\u00df\u00e0"+
		"\7c\2\2\u00e0\u00e1\7p\2\2\u00e1\u00e2\7f\2\2\u00e2H\3\2\2\2\u00e3\u00e4"+
		"\7#\2\2\u00e4J\3\2\2\2\u00e5\u00e9\5=\37\2\u00e6\u00e9\5? \2\u00e7\u00e9"+
		"\5I%\2\u00e8\u00e5\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e8\u00e7\3\2\2\2\u00e9"+
		"L\3\2\2\2\u00ea\u00eb\7k\2\2\u00eb\u00ec\7h\2\2\u00ecN\3\2\2\2\u00ed\u00ee"+
		"\7g\2\2\u00ee\u00ef\7n\2\2\u00ef\u00f0\7u\2\2\u00f0\u00f1\7g\2\2\u00f1"+
		"P\3\2\2\2\u00f2\u00f3\7y\2\2\u00f3\u00f4\7j\2\2\u00f4\u00f5\7k\2\2\u00f5"+
		"\u00f6\7n\2\2\u00f6\u00f7\7g\2\2\u00f7R\3\2\2\2\u00f8\u00f9\7t\2\2\u00f9"+
		"\u00fa\7g\2\2\u00fa\u00fb\7v\2\2\u00fb\u00fc\7w\2\2\u00fc\u00fd\7t\2\2"+
		"\u00fd\u00fe\7p\2\2\u00feT\3\2\2\2\u00ff\u0100\7e\2\2\u0100\u0101\7n\2"+
		"\2\u0101\u0102\7c\2\2\u0102\u0103\7u\2\2\u0103\u0104\7u\2\2\u0104V\3\2"+
		"\2\2\u0105\u0106\7r\2\2\u0106\u0107\7t\2\2\u0107\u0108\7k\2\2\u0108\u0109"+
		"\7p\2\2\u0109\u010a\7v\2\2\u010aX\3\2\2\2\u010b\u010c\7p\2\2\u010c\u010d"+
		"\7g\2\2\u010d\u010e\7y\2\2\u010eZ\3\2\2\2\u010f\u0110\7n\2\2\u0110\u0111"+
		"\7g\2\2\u0111\u0112\7p\2\2\u0112\u0113\7i\2\2\u0113\u0114\7v\2\2\u0114"+
		"\u0115\7j\2\2\u0115\\\3\2\2\2\u0116\u0121\5\7\4\2\u0117\u011d\5i\65\2"+
		"\u0118\u011c\5\7\4\2\u0119\u011c\5i\65\2\u011a\u011c\5g\64\2\u011b\u0118"+
		"\3\2\2\2\u011b\u0119\3\2\2\2\u011b\u011a\3\2\2\2\u011c\u011f\3\2\2\2\u011d"+
		"\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u0121\3\2\2\2\u011f\u011d\3\2"+
		"\2\2\u0120\u0116\3\2\2\2\u0120\u0117\3\2\2\2\u0121^\3\2\2\2\u0122\u0126"+
		"\5g\64\2\u0123\u0125\5g\64\2\u0124\u0123\3\2\2\2\u0125\u0128\3\2\2\2\u0126"+
		"\u0124\3\2\2\2\u0126\u0127\3\2\2\2\u0127`\3\2\2\2\u0128\u0126\3\2\2\2"+
		"\u0129\u012d\5g\64\2\u012a\u012c\5g\64\2\u012b\u012a\3\2\2\2\u012c\u012f"+
		"\3\2\2\2\u012d\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u0130\3\2\2\2\u012f"+
		"\u012d\3\2\2\2\u0130\u0134\5\t\5\2\u0131\u0133\5g\64\2\u0132\u0131\3\2"+
		"\2\2\u0133\u0136\3\2\2\2\u0134\u0132\3\2\2\2\u0134\u0135\3\2\2\2\u0135"+
		"\u0140\3\2\2\2\u0136\u0134\3\2\2\2\u0137\u0138\5\t\5\2\u0138\u013c\5g"+
		"\64\2\u0139\u013b\5g\64\2\u013a\u0139\3\2\2\2\u013b\u013e\3\2\2\2\u013c"+
		"\u013a\3\2\2\2\u013c\u013d\3\2\2\2\u013d\u0140\3\2\2\2\u013e\u013c\3\2"+
		"\2\2\u013f\u0129\3\2\2\2\u013f\u0137\3\2\2\2\u0140b\3\2\2\2\u0141\u0145"+
		"\5\13\6\2\u0142\u0144\5k\66\2\u0143\u0142\3\2\2\2\u0144\u0147\3\2\2\2"+
		"\u0145\u0143\3\2\2\2\u0145\u0146\3\2\2\2\u0146\u0148\3\2\2\2\u0147\u0145"+
		"\3\2\2\2\u0148\u0149\5\13\6\2\u0149d\3\2\2\2\u014a\u014b\7)\2\2\u014b"+
		"\u014c\5m\67\2\u014c\u014d\7)\2\2\u014df\3\2\2\2\u014e\u014f\4\62;\2\u014f"+
		"h\3\2\2\2\u0150\u0151\t\2\2\2\u0151j\3\2\2\2\u0152\u016f\5g\64\2\u0153"+
		"\u016f\5i\65\2\u0154\u016f\7\"\2\2\u0155\u016f\5I%\2\u0156\u016f\4%)\2"+
		"\u0157\u016f\5\23\n\2\u0158\u016f\5\25\13\2\u0159\u016f\5C\"\2\u015a\u016f"+
		"\5=\37\2\u015b\u016f\5\5\3\2\u015c\u016f\5? \2\u015d\u016f\5\t\5\2\u015e"+
		"\u016f\5E#\2\u015f\u016f\5\21\t\2\u0160\u016f\5\3\2\2\u0161\u016f\5\37"+
		"\20\2\u0162\u016f\5\r\7\2\u0163\u016f\5!\21\2\u0164\u016f\4AB\2\u0165"+
		"\u016f\5\33\16\2\u0166\u016f\5\35\17\2\u0167\u016f\7`\2\2\u0168\u016f"+
		"\5\7\4\2\u0169\u016f\7b\2\2\u016a\u016f\5\27\f\2\u016b\u016f\7~\2\2\u016c"+
		"\u016f\5\31\r\2\u016d\u016f\5\17\b\2\u016e\u0152\3\2\2\2\u016e\u0153\3"+
		"\2\2\2\u016e\u0154\3\2\2\2\u016e\u0155\3\2\2\2\u016e\u0156\3\2\2\2\u016e"+
		"\u0157\3\2\2\2\u016e\u0158\3\2\2\2\u016e\u0159\3\2\2\2\u016e\u015a\3\2"+
		"\2\2\u016e\u015b\3\2\2\2\u016e\u015c\3\2\2\2\u016e\u015d\3\2\2\2\u016e"+
		"\u015e\3\2\2\2\u016e\u015f\3\2\2\2\u016e\u0160\3\2\2\2\u016e\u0161\3\2"+
		"\2\2\u016e\u0162\3\2\2\2\u016e\u0163\3\2\2\2\u016e\u0164\3\2\2\2\u016e"+
		"\u0165\3\2\2\2\u016e\u0166\3\2\2\2\u016e\u0167\3\2\2\2\u016e\u0168\3\2"+
		"\2\2\u016e\u0169\3\2\2\2\u016e\u016a\3\2\2\2\u016e\u016b\3\2\2\2\u016e"+
		"\u016c\3\2\2\2\u016e\u016d\3\2\2\2\u016fl\3\2\2\2\u0170\u0173\5o8\2\u0171"+
		"\u0173\t\3\2\2\u0172\u0170\3\2\2\2\u0172\u0171\3\2\2\2\u0173n\3\2\2\2"+
		"\u0174\u0175\t\4\2\2\u0175p\3\2\2\2\u0176\u0178\t\5\2\2\u0177\u0176\3"+
		"\2\2\2\u0178\u0179\3\2\2\2\u0179\u0177\3\2\2\2\u0179\u017a\3\2\2\2\u017a"+
		"\u017b\3\2\2\2\u017b\u017c\b9\2\2\u017cr\3\2\2\2\23\2\u00a5\u00aa\u00af"+
		"\u00e8\u011b\u011d\u0120\u0126\u012d\u0134\u013c\u013f\u0145\u016e\u0172"+
		"\u0179\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}