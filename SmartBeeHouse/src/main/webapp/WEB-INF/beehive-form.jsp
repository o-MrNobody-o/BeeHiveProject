<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="entity.Beehive" %>
<!DOCTYPE html>
<html>
<head>
    
    <title>Beehive Form</title>
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
        input[type="submit"]:hover {
            background: #d6a800;
            color: white;
            box-shadow: none;
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

<%
    Beehive beehive = (Beehive) request.getAttribute("beehive");
    boolean isEdit = (beehive != null && beehive.getId() > 0);
%>

<h2><%= isEdit ? "Edit Beehive" : "Add New Beehive" %></h2>
<a class="add-btn" href="beehives">← Back to Beehive List</a>
<form action="beehives" method="post">

    <% if (isEdit) { %>
        <input type="hidden" name="id" value="<%= beehive.getId() %>">
    <% } %>

    <label>Hive Name:</label>
    <input type="text" name="hiveName" value="<%= isEdit ? beehive.getHiveName() : "" %>">

    <label>Site ID:</label>
    <input type="number" name="siteId" value="<%= isEdit ? beehive.getSiteId() : "" %>">

    <label>Hive Type:</label>
    <input type="text" name="hiveType" value="<%= isEdit ? beehive.getHiveType() : "" %>">

    <label>Extension Count:</label>
    <input type="number" name="extensionCount" value="<%= isEdit ? beehive.getExtensionCount() : "" %>">

    <label>Responsible Agent:</label>
    <input type="text" name="responsibleAgent" value="<%= isEdit ? beehive.getResponsibleAgent() : "" %>">

    <input type="submit" value="Save">
</form>

<!--  <a class="add-btn" href="beehives">← Back to Beehive List</a> -->

</body>
</html>
