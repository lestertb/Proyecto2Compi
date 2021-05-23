lexer grammar miScanner;

//symbols
PyComa: ';';
COMA: ',';
UNDERSC: '_';
POINT: '.';
COMIDOBLES: '"';

//assigns
ASSIGN: '=';
VIR: '~';
DOSPUN: ':';

//parenthesis
PIZQ: '(';
PDER: ')';
LLAIZQ: '{';
LLADER: '}';
PCIZQ: '[';
PCDER: ']';


//operators
 fragment MENOR: '<';
 fragment MAYOR: '>';
 fragment IGUAL: '==';
 fragment DIFERENTE:'!=';
 fragment MENORIGUAL: '<=';
 fragment MAYORIGUAL: '>=';
 REOPERATOR: MENOR | MAYOR | IGUAL | DIFERENTE | MENORIGUAL| MAYORIGUAL;
 ADDITIVEOP: SUM| SUB| OR;
 MULTIPLICATEOP : MUL | DIV | AND;
 BOOLEAN: 'boolean';
 CHAR:'char';
 INT:'int';
 STRING: 'string';
 TRUE: 'true';
 FALSE:'false';
 SUM: '+';
 SUB: '-';
 OR: 'or';
 MUL: '*';
 DIV: '/';
 AND: 'and';
 INTERROGATION:'!';
UNARY: SUM | SUB | INTERROGATION;



//reserved words
IF: 'if';
ELSE: 'else';
WHILE: 'while';
RETURN: 'return';
CLASS: 'class';
PRINT: 'print';
NEW: 'new';
LENGTH: 'length';

ID: UNDERSC | LETTER (UNDERSC | LETTER | DIGIT)*;

INTLITERAL: DIGIT (DIGIT)*;
REALLITERAL      : DIGIT (DIGIT)* POINT (DIGIT)*
                   | POINT DIGIT (DIGIT)*;
STRINGLITERAL    : COMIDOBLES (PRINTABLE)* COMIDOBLES;
CHARLITERAL      : '\''CharContenido'\'' ;
//fragments
fragment DIGIT : '0'..'9';
fragment LETTER: 'a'..'z' | 'A'..'Z';
fragment PRINTABLE  : DIGIT | LETTER | ' ' | INTERROGATION  | '#' | '$' | '%' | '&'
                             | '\'' | PIZQ | PDER | MUL | SUM | COMA | SUB | POINT | DIV | DOSPUN | PyComa
                             | MENOR | ASSIGN | MAYOR | '?' | '@' | PCIZQ | PCDER | '^' | UNDERSC | '`'
                             | LLAIZQ | '|' | LLADER | VIR;
fragment
CharContenido : CharInicial | '0'..'9' | '_' | '\u00B7' | '\u0300'..'\u036F' | '\u203F'..'\u2040';

fragment
CharInicial : 'A'..'Z' | 'a'..'z' | '\u00C0'..'\u00D6' | '\u00D8'..'\u00F6' | '\u00F8'..'\u02FF' | '\u0370'..'\u037D'
   | '\u037F'..'\u1FFF' | '\u200C'..'\u200D' | '\u2070'..'\u218F' | '\u2C00'..'\u2FEF' | '\u3001'..'\uD7FF'
   | '\uF900'..'\uFDCF' | '\uFDF0'..'\uFFFD';

WS  :   [ \t\n\r]+ -> skip ;

