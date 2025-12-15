package com.library.dao;

import com.library.model.User;
import com.library.util.DBConnection;
import java.sql.*;

public class UserDAO {
    public User authenticate(String username, String passwordHash) throws Exception {
        String sql = "SELECT id,username,full_name,role FROM users WHERE username=? AND password_hash=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, passwordHash);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    User u = new User();
                    u.setId(rs.getInt("id"));
                    u.setUsername(rs.getString("username"));
                    u.setFullName(rs.getString("full_name"));
                    u.setRole(rs.getString("role"));
                    return u;
                }
                return null;
            }
        }
    }

	public User validateUser(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

    // createUser, findById etc. (similar prepared statements)
}
