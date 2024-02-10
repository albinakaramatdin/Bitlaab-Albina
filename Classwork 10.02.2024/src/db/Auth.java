package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Auth {
    public List<Items> getAllItems() throws SQLException {
        List<Items> itemsList = new ArrayList<>();
        String query = "SELECT * FROM items";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Items item = new Items();
                item.setId(rs.getLong("id"));
                item.setName(rs.getString("name"));
                item.setDescription(rs.getString("description"));
                item.setPrice(rs.getDouble("price"));
                itemsList.add(item);
            }
        }

        return itemsList;
    }
}

public Users getUserByEmail(String email) throws SQLException {
    Users user = null;
    String query = "SELECT * FROM users WHERE email = ?";

    try (PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setString(1, email);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                user = new Users();
                user.setId(rs.getLong("id"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setFullName(rs.getString("full_name"));
            }
        }
    }

    return user;
}

