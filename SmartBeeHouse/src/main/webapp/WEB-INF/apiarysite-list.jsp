<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, entity.ApiarySite" %>

<html>
<head>
    <title>Apiary Sites - Smart Bee House</title>
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
        .add-btn {
            display: inline-block;
            width: 180px;
            margin: 0 auto 25px;
            background: #f5c518;
            color: #5d3a00;
            text-align: center;
            padding: 12px 20px;
            border-radius: 25px;
            font-weight: bold;
            text-decoration: none;
            box-shadow: 0 5px 0 #b87e00;
        }
        .add-btn:hover {
            background: #d6a800;
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
    <h2>Apiary Site List</h2>
    <a class="add-btn" href="index.html">Return To Home Page</a>
    <a class="add-btn" href="apiarysites?action=new">Add New Site</a>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Site Name</th>
                <th>Latitude</th>
                <th>Longitude</th>
                <th>Altitude</th>
                <th>Setup Date</th>
                <th>Closure Date</th>
                <th>Farmer ID</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<ApiarySite> list = (List<ApiarySite>) request.getAttribute("apiarySites");
                if (list != null && !list.isEmpty()) {
                    for (ApiarySite site : list) {
            %>
            <tr>
                <td><%= site.getId() %></td>
                <td><%= site.getSiteName() %></td>
                <td><%= site.getLatitude() %></td>
                <td><%= site.getLongitude() %></td>
                <td><%= site.getAltitude() %></td>
                <td><%= site.getSetupDate() %></td>
                <td><%= site.getClosureDate() %></td>
                <td><%= site.getFarmerId() %></td>
                <td>
                    <a href="apiarysites?action=edit&id=<%= site.getId() %>">Edit</a> |
                    <a href="apiarysites?action=delete&id=<%= site.getId() %>"
                       onclick="return confirm('Are you sure you want to delete this site?')">Delete</a>
                </td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="9">No apiary sites found.</td>
            </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>
