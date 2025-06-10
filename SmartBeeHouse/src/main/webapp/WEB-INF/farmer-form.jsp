<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="entity.Farmer" %>

<html>
<head>
    <title><%= request.getAttribute("farmer") == null ? "Add New Farmer" : "Edit Farmer" %> - Smart Bee House</title>
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
            max-width: 500px;
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
        input[type="text"], input[type="email"] {
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
    </style>
</head>
<body>
    <h2><%= request.getAttribute("farmer") == null ? "Add New Farmer" : "Edit Farmer" %></h2>
<a class="add-btn" href="farmers">← Back to farmer list</a>
    <form action="farmers" method="post">
        <%
            Farmer f = (Farmer) request.getAttribute("farmer");
            boolean isEdit = (f != null);
        %>

        <% if (isEdit) { %>
            <input type="hidden" name="id" value="<%= f.getId() %>" />
        <% } %>

        <label>First Name:</label>
        <input type="text" name="firstName" value="<%= isEdit ? f.getFirstName() : "" %>" required>

        <label>Last Name:</label>
        <input type="text" name="lastName" value="<%= isEdit ? f.getLastName() : "" %>" required>

        <label>Email:</label>
        <input type="email" name="email" value="<%= isEdit ? f.getEmail() : "" %>" required>

        <label>Phone:</label>
        <input type="text" name="phone" value="<%= isEdit ? f.getPhone() : "" %>" required>

        <input type="submit" value="<%= isEdit ? "Update" : "Create" %> Farmer">
        <a class="cancel-link" href="farmers">Cancel</a>
    </form>
</body>
</html>
