<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, entity.Farmer" %>

<html>
<head>
    <title>Farmers List - Smart Bee House</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: #fff8e1; /* light honey yellow */
            color: #5d3a00; /* dark honey brown */
            margin: 20px;
        }
        h2 {
            text-align: center;
            color: #b87e00; /* golden honey */
            margin-bottom: 20px;
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
        a.action-link {
            color: #b87e00;
            text-decoration: none;
            font-weight: bold;
            margin-right: 8px;
        }
        a.action-link:hover {
            text-decoration: underline;
            color: #d6a800;
        }
    </style>
</head>
<body>
    <h2>Farmers List</h2>
    <a class="add-btn" href="index.html">Return To Home Page</a>
    <a class="add-btn" href="farmers?action=new">Add New Farmer</a>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Farmer> farmers = (List<Farmer>) request.getAttribute("farmers");
                if (farmers != null) {
                    for (Farmer f : farmers) {
            %>
            <tr>
                <td><%= f.getId() %></td>
                <td><%= f.getFirstName() %></td>
                <td><%= f.getLastName() %></td>
                <td><%= f.getEmail() %></td>
                <td><%= f.getPhone() %></td>
                <td>
                    <a class="action-link" href="farmers?action=edit&id=<%= f.getId() %>">Edit</a>|
                    <a class="action-link" href="farmers?action=delete&id=<%= f.getId() %>" onclick="return confirm('Are you sure?')">Delete</a>
                </td>
            </tr>
            <% 
                    }
                } else { 
            %>
            <tr><td colspan="6" style="text-align:center; font-style:italic;">No farmers found</td></tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>
