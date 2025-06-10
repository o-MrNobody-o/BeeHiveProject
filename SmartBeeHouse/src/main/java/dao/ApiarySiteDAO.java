package dao;

import entity.ApiarySite;
import utility.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ApiarySiteDAO {

    private Connection connection;

    public ApiarySiteDAO() {
        connection = DBConnection.getConnection();
    }

    // CREATE
    public boolean addApiarySite(ApiarySite site) {
        String sql = "INSERT INTO apiarysite (site_name, latitude, longitude, altitude, setup_date, closure_date, farmer_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, site.getSiteName());
            stmt.setDouble(2, site.getLatitude());
            stmt.setDouble(3, site.getLongitude());
            stmt.setDouble(4, site.getAltitude());
            stmt.setDate(5, new java.sql.Date(site.getSetupDate().getTime()));
            stmt.setDate(6, site.getClosureDate() != null ? new java.sql.Date(site.getClosureDate().getTime()) : null);
            stmt.setInt(7, site.getFarmerId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // READ ALL
    public List<ApiarySite> getAllApiarySites() {
        List<ApiarySite> list = new ArrayList<>();
        String sql = "SELECT * FROM apiarysite";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                ApiarySite site = new ApiarySite();
                site.setId(rs.getInt("id"));
                site.setSiteName(rs.getString("site_name"));
                site.setLatitude(rs.getDouble("latitude"));
                site.setLongitude(rs.getDouble("longitude"));
                site.setAltitude(rs.getDouble("altitude"));
                site.setSetupDate(rs.getDate("setup_date"));
                site.setClosureDate(rs.getDate("closure_date"));
                site.setFarmerId(rs.getInt("farmer_id"));
                list.add(site);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // READ BY ID
    public ApiarySite getApiarySiteById(int id) {
        String sql = "SELECT * FROM apiarysite WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    ApiarySite site = new ApiarySite();
                    site.setId(rs.getInt("id"));
                    site.setSiteName(rs.getString("site_name"));
                    site.setLatitude(rs.getDouble("latitude"));
                    site.setLongitude(rs.getDouble("longitude"));
                    site.setAltitude(rs.getDouble("altitude"));
                    site.setSetupDate(rs.getDate("setup_date"));
                    site.setClosureDate(rs.getDate("closure_date"));
                    site.setFarmerId(rs.getInt("farmer_id"));
                    return site;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // UPDATE
    public boolean updateApiarySite(ApiarySite site) {
        String sql = "UPDATE apiarysite SET site_name = ?, latitude = ?, longitude = ?, altitude = ?, setup_date = ?, closure_date = ?, farmer_id = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, site.getSiteName());
            stmt.setDouble(2, site.getLatitude());
            stmt.setDouble(3, site.getLongitude());
            stmt.setDouble(4, site.getAltitude());
            stmt.setDate(5, new java.sql.Date(site.getSetupDate().getTime()));
            stmt.setDate(6, site.getClosureDate() != null ? new java.sql.Date(site.getClosureDate().getTime()) : null);
            stmt.setInt(7, site.getFarmerId());
            stmt.setInt(8, site.getId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // DELETE
    public boolean deleteApiarySite(int id) {
        String sql = "DELETE FROM apiarysite WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
