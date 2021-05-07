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

//fragments
fragment DIGIT : '0'..'9';
fragment LETTER: 'a'..'z' | 'A'..'Z';
fragment PRINTABLE  : DIGIT | LETTER | ' ' | INTERROGATION  | '#' | '$' | '%' | '&'
                             | '\'' | PIZQ | PDER | MUL | SUM | COMA | SUB | POINT | DIV | DOSPUN | PyComa
                             | MENOR | ASSIGN | MAYOR | '?' | '@' | PCIZQ | PCDER | '^' | UNDERSC | '`'
                             | LLAIZQ | '|' | LLADER | VIR;

WS  :   [ \t\n\r]+ -> skip ;

