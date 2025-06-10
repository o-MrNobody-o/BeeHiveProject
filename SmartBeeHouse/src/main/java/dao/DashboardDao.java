package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Farmer;
import utility.DBConnection;

public class DashboardDao {
 private Connection conn;

 public DashboardDao() {
     conn = DBConnection.getConnection();
 }

 public int getSiteCountByFarmerId(int farmerId) throws SQLException {
     String sql = "SELECT COUNT(*) FROM apiarysite WHERE farmer_id = ?";
     PreparedStatement ps = conn.prepareStatement(sql);
     ps.setInt(1, farmerId);
     ResultSet rs = ps.executeQuery();
     return rs.next() ? rs.getInt(1) : 0;
 }

 public int getHiveCountByFarmerId(int farmerId) throws SQLException {
     String sql = "SELECT COUNT(*) FROM beehive h JOIN apiarysite s ON h.site_id = s.id WHERE s.farmer_id = ?";
     PreparedStatement ps = conn.prepareStatement(sql);
     ps.setInt(1, farmerId);
     ResultSet rs = ps.executeQuery();
     return rs.next() ? rs.getInt(1) : 0;
 }

 public List<Farmer> getAllFarmers() throws SQLException {
     List<Farmer> farmers = new ArrayList<>();
     String sql = "SELECT * FROM farmer";
     PreparedStatement ps = conn.prepareStatement(sql);
     ResultSet rs = ps.executeQuery();
     while (rs.next()) {
         farmers.add(new Farmer(
        		 rs.getInt("id"),
                 rs.getString("first_name"),
                 rs.getString("last_name"),
                 rs.getString("email"),
                 rs.getString("phone")
         ));
     }
     return farmers;
 }
}
