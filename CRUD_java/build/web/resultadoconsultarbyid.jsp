<%-- 
    Document   : resultadoconsultarbyid
    Created on : 30/11/2023, 11:36:03
    Author     : alunos
--%>

<%@page import="model.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultar by id</title>
        
        <style>
        table {
            border-collapse: collapse;
            width: 50%;
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
        <h1>Resultado Consultar By ID</h1>
        
   <table>
        <thead>
            <tr>
                <th>ID</th>
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
                Cliente clin = (Cliente) request.getAttribute("clin");
                if (clin != null && clin.getNome() != null) {
            %>
            <tr>
                <td><%= clin.getId() %></td>
                <td><%= clin.getNome() %></td>
                <td><%= clin.getCpf() %></td>
                <td><%= clin.getRg() %></td>
                <td><%= clin.getData_nascimento() %></td>
                <td><%= clin.getTelefone() %></td>
                <td><%= clin.getCep() %></td>
                <td><%= clin.getEndereco() %></td>
                <td><%= clin.getEmail() %></td>
                <td><%= clin.getGenero() %></td>
            </tr>
            <%
                } else {
            %>
            <tr>
                <td colspan="10">ID não encontrado</td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
    </body>
</html>
