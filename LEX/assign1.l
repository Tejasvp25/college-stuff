/*
	Gr No - xxxxxxx
	Roll No - xxxxxx
	Name - Tejas Patil
	Div - xxxxx
	Batch - xxx
*/

%%
[ \t]+   ;
public |
private |
protected   {printf("%s : This is java access specifier\n",yytext);}
for |
while |
if  {printf("%s : This is java structure keywords\n",yytext);}
class |
static |
void    {printf("%s : This is java keywords\n",yytext);}
"{" |
"}" |
"(" |
")"     {printf("%s : This is brackets\n",yytext);}
"+" |
"-" |
"*" |
"/"     {printf("%s : This is arithmatic operator\n",yytext);}
[a-zA-z][a-zA-Z0-9]     {printf("%s : This is java variable\n",yytext);}
%%

int main(){
    yylex();
    return 0;
}

int yywrap()
{
    return 0;
}