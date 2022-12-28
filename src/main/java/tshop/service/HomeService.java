package tshop.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import tshop.config.Connect;
import tshop.entity.Banner;
import tshop.entity.BannerC;
import tshop.entity.BannerM;
import tshop.entity.CategoryItem;
import tshop.entity.KeySearch;
import tshop.entity.Product;
import tshop.entity.ProductDeTail;
import tshop.entity.Shipping;
import tshop.entity.User;

public class HomeService {

	public List<Banner> getAllBannerL() {
		Connection conn = Connect.openConnect();
		List<Banner> list = new ArrayList<Banner>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM banner_l");
			while (rs.next()) {
				list.add(new Banner(rs.getString(1)));
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return Collections.emptyList();
	}

	public int getNumberBannerL() {
		Connection conn = Connect.openConnect();
		String query = "SELECT COUNT(*) FROM banner_l";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	public List<BannerC> getAllBannerC() {
		Connection conn = Connect.openConnect();
		List<BannerC> list = new ArrayList<BannerC>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM banner_c");
			while (rs.next()) {
				list.add(new BannerC(rs.getString(1), rs.getString(2)));
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return Collections.emptyList();
	}

	public List<BannerM> getAllBannerM() {
		Connection conn = Connect.openConnect();
		List<BannerM> list = new ArrayList<BannerM>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM banner_m");
			while (rs.next()) {
				list.add(new BannerM(rs.getString(1)));
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return Collections.emptyList();
	}

	public CategoryItem getCategoryByCID(String cID) {
		Connection conn = Connect.openConnect();
		String query = "SELECT * FROM category WHERE cID = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, cID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return new CategoryItem(rs.getInt(1), rs.getString(3), rs.getString(2));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public List<CategoryItem> getAllCategoryItem() {
		Connection conn = Connect.openConnect();
		List<CategoryItem> list = new ArrayList<CategoryItem>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM category");
			while (rs.next()) {
				list.add(new CategoryItem(rs.getInt(1), rs.getString(3), rs.getString(2)));
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return Collections.emptyList();
	}

	public List<Product> getAllProduct() {
		Connection conn = Connect.openConnect();
		List<Product> list = new ArrayList<Product>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM product ORDER BY `pID` DESC LIMIT 0,18");

			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5),
						rs.getInt(6)));
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return Collections.emptyList();
	}

	public List<Product> getAllProductByAdmin(int index) {
		Connection conn = Connect.openConnect();
		List<Product> list = new ArrayList<Product>();
		String query = "SELECT * FROM product LIMIT ?,5";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, (index - 1) * 5);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5),
						rs.getInt(6)));
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return Collections.emptyList();
	}

	public int getNumberProductByAdmin() {
		Connection conn = Connect.openConnect();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM product");

			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	public List<Product> getAllProductByName(String keyword) {
		Connection conn = Connect.openConnect();
		String query = "SELECT * FROM product WHERE `describe` LIKE ?";
		List<Product> list = new ArrayList<Product>();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, "%" + keyword + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5),
						rs.getInt(6)));
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return Collections.emptyList();
	}

	public User checkLogin(String username, String password) {
		Connection conn = Connect.openConnect();
		User user = new User();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM `user` WHERE `user` = ? AND `pass` = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user.setId(rs.getInt(1));
				user.setUser(rs.getString(2));
				user.setPass(rs.getString(3));
				user.setIsSell(rs.getInt(4));
				user.setIsAdmin(rs.getInt(5));
				user.setEnable(rs.getInt(6));
				return user;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public User register(String username, String password) {
		Connection conn = Connect.openConnect();
		String query = "INSERT INTO `user`(`user`,`pass`) VALUES (?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.executeUpdate();
			User user = new User();
			user.setUser(username);
			user.setPass(password);
			return user;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public void deleteProductByID(String pid) {
		Connection conn = Connect.openConnect();
		String query = "DELETE FROM product WHERE `pID` = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, pid);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void insertProduct(String image, String describe, double price, int cID, int sellID) {
		Connection conn = Connect.openConnect();
		String query = "INSERT INTO product(image,`describe`,price,cID,sellID) VALUES(?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, image);
			ps.setString(2, describe);
			ps.setDouble(3, price);
			ps.setInt(4, cID);
			ps.setInt(5, sellID);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public Product getProductByID(String id) {
		Connection conn = Connect.openConnect();
		String query = "SELECT * FROM product WHERE `pID` = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5),
						rs.getInt(6));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public ProductDeTail getProductDetailByID(String id) {
		Connection conn = Connect.openConnect();
		String query = "SELECT * FROM product AS p JOIN pdetail AS pd\r\n" + "WHERE p.pID = pd.pID\r\n"
				+ "HAVING p.pID = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductDeTail product = new ProductDeTail();
				product.setpID(rs.getInt(1));
				product.setImage(rs.getString(2));
				product.setDescribe(rs.getString(3));
				product.setPrice(rs.getDouble(4));
				product.setcID(rs.getInt(5));
				product.setSellID(rs.getInt(6));
				product.setImage2(rs.getString(8));
				product.setImage3(rs.getString(9));
				product.setImage4(rs.getString(10));
				product.setImage5(rs.getString(11));
				product.setSold(rs.getInt(12));
				product.setAvailable(rs.getInt(13));
				return product;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public void updateProduct(String id, String image, String describe, double price, int cID, int sellID) {
		Connection conn = Connect.openConnect();
		String query = "UPDATE product SET `image` = ?, `describe` = ?, `price` = ?, `cID` = ?, `sellID` = ? WHERE `pID` = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, image);
			ps.setString(2, describe);
			ps.setDouble(3, price);
			ps.setInt(4, cID);
			ps.setInt(5, sellID);
			ps.setString(6, id);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public int getPaging(int sellID) {
		Connection conn = Connect.openConnect();
		String query = "SELECT COUNT(*) FROM product WHERE sellID = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, sellID);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	public List<Product> getProductByIndex(int sellID, int index) {
		Connection conn = Connect.openConnect();
		List<Product> list = new ArrayList<Product>();
		String query = "SELECT * FROM product WHERE sellID = ? LIMIT ?,5";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, sellID);
			ps.setInt(2, (index - 1) * 5);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5),
						rs.getInt(6)));
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return Collections.emptyList();
	}

	public int getUID(String user) {
		Connection conn = Connect.openConnect();
		List<Product> list = new ArrayList<Product>();
		String query = "SELECT uID FROM `user` WHERE `user` = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	public int checkKeySearch(String keyword, int uID) {
		Connection conn = Connect.openConnect();
		String query = "SELECT COUNT(*) FROM key_search WHERE keyword LIKE ? AND uID = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, keyword);
			ps.setInt(2, uID);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	public void insertKeySearch(int uID, String keyword) {
		Connection conn = Connect.openConnect();
		String query = "INSERT INTO key_search(uID,keyword) VALUES(?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, uID);
			ps.setString(2, keyword);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public List<KeySearch> getKeySearchByUID(int uID) {
		Connection conn = Connect.openConnect();
		String query = "SELECT * FROM key_search WHERE uID = ? ORDER BY stt DESC LIMIT 0,8";
		List<KeySearch> list = new ArrayList<KeySearch>();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, uID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new KeySearch(rs.getString(3)));
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return Collections.emptyList();
	}

	public List<Product> searchProductByCID(String cID) {
		Connection conn = Connect.openConnect();
		List<Product> list = new ArrayList<Product>();
		String query = "SELECT * FROM product WHERE cID = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, cID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5),
						rs.getInt(6)));
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return Collections.emptyList();
	}

	public List<Shipping> getAllShipping() {
		Connection conn = Connect.openConnect();
		String query = "SELECT * FROM shipping";
		List<Shipping> list = new ArrayList<Shipping>();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Shipping(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return Collections.emptyList();
	}

	public Shipping getShippingBySID(String sID) {
		Connection conn = Connect.openConnect();
		String query = "SELECT * FROM shipping WHERE sID = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, sID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return new Shipping(rs.getInt(1), rs.getString(2), rs.getDouble(3));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
