<%-- 
    Document   : resultadoconsultartodos
    Created on : 30/11/2023, 12:06:35
    Author     : alunos
--%>

<%@page import="java.util.List"%>
<%@page import="model.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultar todos</title>
         <style>
        table {
            border-collapse: collapse;
            width: 100%;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }
    </style>
        
    </head>
    <body>
        <h1>Resultado consultar todos.</h1>
       <table>
        <thead>
            <tr>
                <th>Nome</th>
                <th>CPF</th>
                <th>RG</th>
                <th>Data de Nascimento</th>
                <th>Telefone</th>
                <th>CEP</th>
                <th>Endereço</th>
                <th>Email</th>
                <th>Gênero</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Cliente> lc = (List<Cliente>) request.getAttribute("listcliente");
                for (Cliente c : lc) {
            %>
            <tr>
                <td><%= c.getNome() %></td>
                <td><%= c.getCpf() %></td>
                <td><%= c.getRg() %></td>
                <td><%= c.getData_nascimento() %></td>
                <td><%= c.getTelefone() %></td>
                <td><%= c.getCep() %></td>
                <td><%= c.getEndereco() %></td>
                <td><%= c.getEmail() %></td>
                <td><%= c.getGenero() %></td>
            </tr>
            <%
                }
            %>
        </tbody>
        
    </table>
    </body>
</html>
