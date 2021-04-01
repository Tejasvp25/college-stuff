%{
    #include<stdio.h>
    void yyerror();
    int yylex();
%}

%token TYPE ID SC COMMA AS

%%
Start: TYPE ID SC {printf("Valid Variable Declaration");}
|
TYPE varlist SC {printf("Valid Variable Declaration");};
varlist:varlist COMMA ID|ID;

%%

int yywrap(){return 0;}
void yyerror(){
    printf("Invalid Variable Declaration");
}
int main(){
    yyparse();
    yywrap();
    return 0;
}