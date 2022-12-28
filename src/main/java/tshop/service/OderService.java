package tshop.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import tshop.config.Connect;
import tshop.entity.Cart;

public class OderService {
	public void insertOder(Cart cart) {
		Connection conn = Connect.openConnect();
		String query = "INSERT INTO oder(uID) VALUES (?)";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, cart.getUser().getId());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void updateProductDetail(int quantity, int pId) {
		Connection conn = Connect.openConnect();
		String query = "UPDATE pdetail SET sold = (sold + ?), available = (available - ?) WHERE pID = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, quantity);
			ps.setInt(2, quantity);
			ps.setInt(3, pId);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public int getNumberOder(int uID) {
		Connection conn = Connect.openConnect();
		String query = "SELECT * FROM oder WHERE uID = ? ORDER BY oID DESC LIMIT 1";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, uID);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
}
