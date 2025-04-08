<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="models.*" %>
<%
    String message = (String) request.getAttribute("message");
    List<List<Object>> list= (List<List<Object>>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: Arial, sans-serif;
        }

        body {
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        th , td {
            border: 2px black solid;
            padding: 10px;
        }
        
        table{
            width: 30%;
            height: 30px;
            border-collapse: collapse;
            border: 2px black solid;
        }
    </style>
</head>
<body>
    <table>
        <tr>
            <th>Prevision</th>
            <th>Montant</th>
            <th>Reste</th>
        </tr>
        <%
            for (List<Object> l : list) {
        %>
        <% Prevision c = (Prevision) l.get(0);  %>
            <td><%= c.getLibelle() %></td>
            <td><%= l.get(1).toString() %></td>
            <td><%= c.getMontant() %></td>
        <%
            }
        %>
    </table>
</body>
</html>