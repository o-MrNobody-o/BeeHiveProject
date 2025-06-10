package dao;

import entity.Farmer;

import utility.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FarmerDAO 
{

    private Connection connection;

    public FarmerDAO() 
    {
        connection = DBConnection.getConnection();
    }

    public boolean addFarmer(Farmer farmer) 
    {
        String sql = "INSERT INTO farmer (first_name, last_name, email, phone) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) 
        {
            stmt.setString(1, farmer.getFirstName());
            stmt.setString(2, farmer.getLastName());
            stmt.setString(3, farmer.getEmail());
            stmt.setString(4, farmer.getPhone());
            return stmt.executeUpdate() > 0;
        } 
        catch (SQLException e) 
        {
            System.err.println("Error adding farmer: " + e.getMessage());
            return false;
        }
    }

    public List<Farmer> getAllFarmers() 
    {
        List<Farmer> farmers = new ArrayList<>();
        String sql = "SELECT * FROM farmer";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) 
        {
            while (rs.next()) 
            {
                Farmer farmer = new Farmer(
                        rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getString("phone")
                );
                farmers.add(farmer);
            }
        } 
        catch (SQLException e) 
        {
            System.err.println("Error fetching farmers: " + e.getMessage());
        }
        return farmers;
    }

    public Farmer getFarmerById(int id) 
    {
        String sql = "SELECT * FROM farmer WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) 
        {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) 
            {
                if (rs.next()) 
                {
                    return new Farmer(
                            rs.getInt("id"),
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getString("email"),
                            rs.getString("phone")
                    );
                }
            }
        } 
        catch (SQLException e) 
        {
            System.err.println("Error getting farmer by ID: " + e.getMessage());
        }
        return null;
    }

    public boolean updateFarmer(Farmer farmer) 
    {
        String sql = "UPDATE farmer SET first_name = ?, last_name = ?, email = ?, phone = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) 
        {
            stmt.setString(1, farmer.getFirstName());
            stmt.setString(2, farmer.getLastName());
            stmt.setString(3, farmer.getEmail());
            stmt.setString(4, farmer.getPhone());
            stmt.setInt(5, farmer.getId());
            return stmt.executeUpdate() > 0;
        } 
        catch (SQLException e) 
        {
            System.err.println("Error updating farmer: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteFarmer(int id) 
    {
        String sql = "DELETE FROM farmer WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) 
        {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } 
        catch (SQLException e) 
        {
            System.err.println("Error deleting farmer: " + e.getMessage());
            return false;
        }
    }
}
