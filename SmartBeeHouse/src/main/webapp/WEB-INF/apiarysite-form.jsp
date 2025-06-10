<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="entity.ApiarySite" %>

<html>
<head>
    <title><%= request.getAttribute("apiarySite") == null ? "Add Apiary Site" : "Edit Apiary Site" %> - Smart Bee House</title>
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
        form {
            max-width: 600px;
            margin: auto;
            background: #fffbee;
            padding: 25px 30px;
            border-radius: 12px;
            box-shadow: 0 0 15px #f5c518aa;
        }
        label {
            display: block;
            font-weight: 600;
            margin-bottom: 6px;
            margin-top: 15px;
        }
        input[type="text"], input[type="number"], input[type="date"] {
            width: 100%;
            padding: 10px 12px;
            border: 1.8px solid #f5c518;
            border-radius: 8px;
            box-sizing: border-box;
            font-size: 16px;
            color: #5d3a00;
            background: #fff;
        }
        input[type="submit"] {
            margin-top: 25px;
            background: #f5c518;
            border: none;
            padding: 12px 18px;
            color: #5d3a00;
            font-size: 17px;
            font-weight: bold;
            border-radius: 25px;
            cursor: pointer;
            box-shadow: 0 5px 0 #b87e00;
            transition: background-color 0.3s ease;
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
        input[type="submit"]:hover {
            background: #d6a800;
            color: white;
            box-shadow: none;
        }
        a.cancel-link {
            display: inline-block;
            margin-left: 15px;
            color: #b87e00;
            text-decoration: none;
            font-weight: bold;
        }
        a.cancel-link:hover {
            text-decoration: underline;
            color: #d6a800;
        }
    </style>
</head>
<body>

    <h2><%= request.getAttribute("apiarySite") == null ? "Add New Apiary Site" : "Edit Apiary Site" %></h2>
<a class="add-btn" href="apiarysites">← Back to Apiary site list</a>
    <form action="apiarysites" method="post">
        <%
            ApiarySite site = (ApiarySite) request.getAttribute("apiarySite");
            boolean isEdit = (site != null);
        %>

        <% if (isEdit) { %>
            <input type="hidden" name="id" value="<%= site.getId() %>">
        <% } %>

        <label>Site Name:</label>
        <input type="text" name="siteName" value="<%= isEdit ? site.getSiteName() : "" %>" required>

        <label>Latitude:</label>
        <input type="number" step="0.000001" name="latitude" value="<%= isEdit ? site.getLatitude() : "" %>" required>

        <label>Longitude:</label>
        <input type="number" step="0.000001" name="longitude" value="<%= isEdit ? site.getLongitude() : "" %>" required>

        <label>Altitude (m):</label>
        <input type="number" step="0.1" name="altitude" value="<%= isEdit ? site.getAltitude() : "" %>" required>

        <label>Setup Date:</label>
        <input type="date" name="setupDate" value="<%= isEdit && site.getSetupDate() != null ? site.getSetupDate().toString() : "" %>">

        <label>Closure Date:</label>
        <input type="date" name="closureDate" value="<%= isEdit && site.getClosureDate() != null ? site.getClosureDate().toString() : "" %>">

        <label>Farmer ID:</label>
        <input type="number" name="farmerId" value="<%= isEdit ? site.getFarmerId() : "" %>" required>

        <input type="submit" value="<%= isEdit ? "Update" : "Create" %> Site">
        <a class="cancel-link" href="apiarysites">Cancel</a>
    </form>
</body>
</html>
