<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body bgcolor= "#000000" text= "gold">
<form name="calculator" action="ws" method="post" >
<br>      Número 1 <input type="text" name="val1" value="">
<br>
<br>      Número 2 <input type="text" name="val2" value="">
<br>
<br> <input type="submit" value="+" onClick="document.calculator.ans.value+='+'">
<input type="submit" value="-" onClick="document.calculator.ans.value+='-'">
<input type="submit" value="*" onClick="document.calculator.ans.value+='*'">
<input type="submit" value="/" onClick="document.calculator.ans.value+='/'">
<input type="reset" value="Reset">
<br>
<input type="text" name="ans" readonly value="" hidden="">
<% Float resp = (Float)(request.getAttribute("resp")); 
    if (resp== null){
        resp=0f;
    }
%>
<br> Resultado <input type="text" name="ans3" readonly value="<%= resp %>">
</form>
    </body>
</html>
