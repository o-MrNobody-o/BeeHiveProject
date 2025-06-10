<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="entity.Beehive" %>
<!DOCTYPE html>
<html>
<head>
    
    <title>Beehive List</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: #fff8e1;
            color: #5d3a00;
            margin: 20px;
        }
        h2 {
            text-align: center;
            color: #b87e00;
            margin-bottom: 25px;
            text-shadow: 1px 1px 0 #fff3b0;
        }
        a.add-btn {
            display: inline-block;
            background: #f5c518;
            color: #5d3a00;
            padding: 8px 15px;
            margin-bottom: 15px;
            text-decoration: none;
            border-radius: 15px;
            font-weight: bold;
            box-shadow: 0 3px 0 #b87e00;
        }
        a.add-btn:hover {
            background: #d6a800;
            box-shadow: none;
            color: white;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            background: #fffbee;
            box-shadow: 0 0 15px #f5c518aa;
        }
        th, td {
            padding: 12px;
            border: 1px solid #f5c518;
            text-align: center;
        }
        th {
            background-color: #fff3b0;
            color: #5d3a00;
        }
        td a {
            color: #b87e00;
            text-decoration: none;
            font-weight: bold;
        }
        td a:hover {
            text-decoration: underline;
            color: #d6a800;
        }
    </style>
</head>
<body>

<h2>Beehive List</h2>
<a class="add-btn" href="index.html">Return To Home Page</a>
<a class="add-btn" href="beehives?action=new">Add New Hive</a>

<table>
    <tr>
        <th>ID</th>
        <th>Hive Name</th>
        <th>Site ID</th>
        <th>Hive Type</th>
        <th>Extension Count</th>
        <th>Responsible Agent</th>
        <th>Actions</th>
    </tr>

<%
    List<Beehive> beehives = (List<Beehive>) request.getAttribute("beehives");
    if (beehives != null) {
        for (Beehive b : beehives) {
%>
    <tr>
        <td><%= b.getId() %></td>
        <td><%= b.getHiveName() %></td>
        <td><%= b.getSiteId() %></td>
        <td><%= b.getHiveType() %></td>
        <td><%= b.getExtensionCount() %></td>
        <td><%= b.getResponsibleAgent() %></td>
        <td class="action-link">
            <a href="beehives?action=edit&id=<%= b.getId() %>"> Edit</a> | 
            <a href="beehives?action=delete&id=<%= b.getId() %>" onclick="return confirm('Are you sure?')"> Delete</a>
        </td>
    </tr>
<%
        }
    }
%>

</table>

</body>
</html>
