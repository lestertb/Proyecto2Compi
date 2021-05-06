parser grammar miParser;
options {
    tokenVocab = miScanner;
}

program : ( statement )*                                                    #programAST;

statement           : variableDeclaration PyComa                            #variableDeclarationST
                    | classDeclaration PyComa                               #classDeclarationST
                    | assignment PyComa                                     #assignmentST
	                | arrayAssignment PyComa                                #arrayAssignmentST
                    | printStatement PyComa                                 #printStatementST
                    | ifStatement                                           #ifStatementST
                    | whileStatement                                        #whileStatementST
                    | returnStatement PyComa                                #returnStatementST
                    | functionDeclaration                                   #functionDeclarationST
                    | block                                                 #blockST;

block :   LLAIZQ (statement)* LLADER                                        #blockAST;
functionDeclaration     :  type ID PIZQ (formalParams)? PDER block          #functionDeclarationAST;
formalParams     : formalParam (COMA formalParam)*                          #formalParamsAST;
formalParam      : type ID                                                  #formalParamAST;
whileStatement   : WHILE PIZQ expression PDER block                         #whileStatementAST;
ifStatement      : IF PIZQ expression PDER block (ELSE block)?              #ifStatementAST;
returnStatement  : RETURN expression                                        #returnStatementAST;
printStatement   : PRINT expression                                         #printStatementAST;
classDeclaration    : CLASS ID LLAIZQ  (classVariableDeclaration)* LLADER   #classDeclarationAST;
classVariableDeclaration       : simpleType ID (ASSIGN expression)? PyComa  #classVariableDeclarationAST;
variableDeclaration     : type ID  (ASSIGN expression)?                     #variableDeclarationAST;

type       : simpleType                                                     #simpleTypeTAST
           | arrayType                                                      #arrayTypeTAST
           | ID                                                             #idTAST;
simpleType : BOOLEAN                                                        #booleanSTAST
	       | CHAR                                                           #charSTAST
	       | INT                                                            #intSTAST
	       | STRING                                                         #stringSTAST;

arrayType         : simpleType PCIZQ PCDER                                  #arrayTypeAST;
assignment        : ID (POINT ID)? ASSIGN expression                        #assignmentAST;
arrayAssignment   : ID PCIZQ expression PCDER ASSIGN expression             #arrayAssignmentAST;
expression        : simpleExpression (REOPERATOR simpleExpression)*         #expressionAST;
simpleExpression  : term  (ADDITIVEOP term)*                                #simpleExpressionAST;

term              : factor (MULTIPLICATEOP factor)*                         #termAST;

factor            : literal                                                 #literalFAST
                  | ID  (POINT ID)?                                         #idFAST
                  | functionCall                                            #functionCallFAST
                  | arrayLookup                                             #arrayLookupFAST
                  | arrayLength                                             #arrayLengthFAST
                  | subExpression                                           #subExpressionFAST
                  | arrayAllocationExpression                               #arrayAllocationExpressionFAST
                  | allocationExpression                                    #allocationExpressionFAST
                  | unary                                                   #unaryFAST;
unary             : UNARY (expression)*                                     #unaryAST;
allocationExpression    : NEW ID  PIZQ PDER                                 #allocationExpressionAST;
arrayAllocationExpression        : NEW simpleType PCIZQ expression PCDER    #arrayAllocationExpressionAST;
subExpression    : PIZQ expression PDER                                     #subExpressionAST;
functionCall     : ID PIZQ (actualParams)? PDER                             #functionCallAST;
actualParams     : expression (COMA expression)*                            #actualParamsAST;
arrayLookup       : ID PCIZQ expression PCDER                               #arrayLookupAST;
arrayLength       : ID POINT LENGTH                                         #arrayLengthAST;
boolLiteral      : TRUE | FALSE                                             #boolLiteralAST;
literal          : INTLITERAL                                               #intLAST
                    | REALLITERAL                                           #realLAST
                    | boolLiteral                                           #boolLAST
                    | STRINGLITERAL                                         #stringLAST;


