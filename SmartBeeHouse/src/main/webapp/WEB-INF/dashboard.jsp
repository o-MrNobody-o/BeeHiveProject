<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Farmer" %>
<%
    List<Farmer> farmers = (List<Farmer>) request.getAttribute("farmers");
    Integer selectedFarmerId = (Integer) request.getAttribute("selectedFarmerId");
    Integer siteCount = (Integer) request.getAttribute("siteCount");
    Integer hiveCount = (Integer) request.getAttribute("hiveCount");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Farmer Dashboard</title>
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
        form {
            background: #fffbee;
            padding: 20px;
            border-radius: 15px;
            box-shadow: 0 0 15px #f5c518aa;
            max-width: 500px;
            margin: 0 auto 30px auto;
        }
        label {
            font-weight: bold;
        }
        input[list], button {
            padding: 10px;
            border: 1px solid #f5c518;
            border-radius: 10px;
            font-size: 16px;
            margin-top: 10px;
            margin-right: 10px;
        }
        button {
            background: #f5c518;
            color: #5d3a00;
            font-weight: bold;
            cursor: pointer;
            box-shadow: 0 3px 0 #b87e00;
        }
        button:hover {
            background: #d6a800;
            color: white;
            box-shadow: none;
        }
        .results {
            background: #fffbee;
            border-radius: 15px;
            box-shadow: 0 0 15px #f5c518aa;
            padding: 20px;
            max-width: 500px;
            margin: 0 auto 30px auto;
            text-align: center;
        }
        .results h3 {
            color: #b87e00;
            margin-bottom: 15px;
        }
        .results p {
            font-size: 18px;
            margin: 8px 0;
        }
        .return-btn {
            display: block;
            width: fit-content;
            margin: 0 auto;
            background: #f5c518;
            color: #5d3a00;
            padding: 10px 20px;
            border-radius: 15px;
            text-decoration: none;
            font-weight: bold;
            box-shadow: 0 3px 0 #b87e00;
            transition: background 0.3s ease, box-shadow 0.3s ease;
        }
        .return-btn:hover {
            background: #d6a800;
            color: white;
            box-shadow: none;
        }
    </style>
</head>
<body>

<h2>Farmer Dashboard</h2>

<form method="post" action="dashboard">
    <label for="farmerId">Select Farmer:</label><br>
    <input list="farmerList" name="farmerId" id="farmerId" required>
    <datalist id="farmerList">
        <% for (Farmer f : farmers) { %>
            <option value="<%= f.getId() %>"><%= f.getFirstName() + " " + f.getLastName() %></option>
        <% } %>
    </datalist>
    <button type="submit">View</button>
</form>

<% if (selectedFarmerId != null) { %>
    <div class="results">
        <h3>Results for Farmer ID : <%= selectedFarmerId %></h3>
        <p><strong>Number of Sites:</strong> <%= siteCount %></p>
        <p><strong>Number of Beehives:</strong> <%= hiveCount %></p>
    </div>
<% } %>

<a href="index.html" class="return-btn">Return</a>

</body>
</html>
