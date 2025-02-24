<%-- 
    Document   : resultadoatualizar
    Created on : 30/11/2023, 11:36:40
    Author     : alunos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado atualizar</title>
    </head>
    <body>
        <h1>Resultado Atualizar</h1>
        <%
               String msg = (String) request.getAttribute("msg");
               out.println(msg);
            %>
    </body>
</html>
