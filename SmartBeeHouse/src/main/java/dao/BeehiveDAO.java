package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import entity.Beehive;
import utility.DBConnection;

public class BeehiveDAO {

    private Connection connection;

    public BeehiveDAO() {
        connection = DBConnection.getConnection();
    }

    public void addBeehive(Beehive beehive) {
        String sql = "INSERT INTO beehive (hive_name, site_id, hive_type, extension_count, responsible_agent) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, beehive.getHiveName());
            stmt.setInt(2, beehive.getSiteId());
            stmt.setString(3, beehive.getHiveType());
            stmt.setInt(4, beehive.getExtensionCount());
            stmt.setString(5, beehive.getResponsibleAgent());
            stmt.executeUpdate();
        }catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public List<Beehive> getAllBeehives()  {
        List<Beehive> beehives = new ArrayList<>();
        String sql = "SELECT * FROM beehive";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Beehive beehive = new Beehive(
                    rs.getInt("id"),
                    rs.getString("hive_name"),
                    rs.getInt("site_id"),
                    rs.getString("hive_type"),
                    rs.getInt("extension_count"),
                    rs.getString("responsible_agent")
                );
                beehives.add(beehive);
            }
        }catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return beehives;
    }

    public Beehive getBeehiveById(int id) {
        String sql = "SELECT * FROM beehive WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Beehive(
                    		rs.getInt("id"),
                            rs.getString("hive_name"),
                            rs.getInt("site_id"),
                            rs.getString("hive_type"),
                            rs.getInt("extension_count"),
                            rs.getString("responsible_agent")
                    );
                }
            }
        }catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }

    public void updateBeehive(Beehive beehive) {
        String sql = "UPDATE beehive SET hive-name = ?, site_id = ?, hive_type = ?, extension_count = ?, responsible_agent = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, beehive.getHiveName());
            stmt.setInt(2, beehive.getSiteId());
            stmt.setString(3, beehive.getHiveType());
            stmt.setInt(4, beehive.getExtensionCount());
            stmt.setString(5, beehive.getResponsibleAgent());
            stmt.setInt(6, beehive.getId());
            stmt.executeUpdate();
        }catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void deleteBeehive(int id)  {
        String sql = "DELETE FROM beehive WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
