%%
[a-z]+  {printf("this is word");}
.|\n   { ECHO;}
%%

int main()
{
    yylex();
}
int yywrap()
{
    return 0;
}