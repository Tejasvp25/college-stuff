%{
    #include "y.tab.h"
%}

%%
int |
char | 
float | 
String | 
double   { return TYPE;}
";"     {return SC;}
"," {return COMMA;}
[a-zA-Z]*+[a-zA-Z0-9]*     {return ID;}
"=" {return AS;}
%%