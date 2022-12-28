package tshop.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import tshop.config.Connect;
import tshop.entity.User;

public class AdminService {
	public List<User> getAllUser() {
		Connection conn = Connect.openConnect();
		String query = "SELECT * FROM `user` WHERE isAdmin = 0 OR isAdmin IS NULL";
		List<User> listUser = new ArrayList<User>();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				listUser.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getInt(6)));
			}
			return listUser;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return Collections.emptyList();
	}

	public void onIsSell(String userID) {
		Connection conn = Connect.openConnect();
		String query = "UPDATE `user` SET isSell = 1 WHERE uID = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, userID);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void offIsSell(String userID) {
		Connection conn = Connect.openConnect();
		String query = "UPDATE `user` SET isSell = 0 WHERE uID = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, userID);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void onEnable(String userID) {
		Connection conn = Connect.openConnect();
		String query = "UPDATE `user` SET enable = 1 WHERE uID = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, userID);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void offEnable(String userID) {
		Connection conn = Connect.openConnect();
		String query = "UPDATE `user` SET enable = 0 WHERE uID = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, userID);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
