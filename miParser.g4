parser grammar miParser;
options {
    tokenVocab = miScanner;
}

program : ( statement )*;

statement           :   variableDeclaration PyComa
                    | classDeclaration PyComa
                    | assignment PyComa
	                | arrayAssignment PyComa
                    | printStatement PyComa
                    | ifStatement
                    | whileStatement
                    | returnStatement PyComa
                    | functionDeclaration
                    | block;

block :   LLAIZQ (statement)* LLADER;
functionDeclaration     :  type ID PIZQ (formalParams)? PDER block;
formalParams     : formalParam (COMA formalParam)*;
formalParam      : type ID;
whileStatement   : WHILE PIZQ expression PDER block;
ifStatement      : IF PIZQ expression PDER block (ELSE block)?;
returnStatement  : RETURN expression;
printStatement   : PRINT expression;
classDeclaration    : CLASS ID LLAIZQ  (classVariableDeclaration)* LLADER;
classVariableDeclaration       : simpleType ID (ASSIGN expression)?;
variableDeclaration     : type ID  (ASSIGN expression)?;

type       : simpleType| arrayType | ID;
simpleType: BOOLEAN
	| CHAR
	| INT
	| STRING;

arrayType      : simpleType PCIZQ PCDER;
assignment     : ID (POINT ID)? ASSIGN expression;
arrayAssignment        : ID PCIZQ expression PCDER ASSIGN expression;
expression        : simpleExpression (REOPERATOR simpleExpression)*;
simpleExpression : term  (ADDITIVEOP term)*;

term              : factor (MULTIPLICATEOP factor)*;
factor            : literal
                    | ID  (POINT ID)?
                    | functionCall
                    | arrayLookup
                    | arrayLength
                    | subExpression
                    | arrayAllocationExpression
                    | allocationExpression
                    | unary;
unary            : UNARY (expression)*;
allocationExpression    : NEW ID  PIZQ PDER;
arrayAllocationExpression        : NEW simpleType PCIZQ expression PCDER;
subExpression    : PIZQ expression PDER;
functionCall     : ID PIZQ (actualParams)? PDER;
actualParams     : expression (COMA expression)*;
arrayLookup       : ID PCIZQ expression PCDER;
arrayLength       : ID POINT LENGTH;
boolLiteral      : TRUE | FALSE;
literal          : INTLITERAL
                    | REALLITERAL
                    | boolLiteral
                    | STRINGLITERAL;


