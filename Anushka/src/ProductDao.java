import java.util.*;
import java.sql.*;

public class ProductDao {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public static int Save(Product e) {
		int status = 0;
		try {
			Connection con =ProductDao.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into Product(ProductId,ProductName,ProductPrice,Description) values (?,?,?,?)");
			ps.setInt(1, e.getProductId());
			ps.setString(2, e.getProductName());
			ps.setString(3, e.getProductPrice());
			ps.setString(4, e.getDescription());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int update(Product e) {
		int status = 0;
		try {
			Connection con = ProductDao.getConnection();
			PreparedStatement ps = con.prepareStatement("update Product set ProductName=?,ProductPrice=?,Description=? where ProductId=?");
			ps.setString(1, e.getProductName());
			ps.setString(2, e.getProductPrice());
			ps.setString(3, e.getDescription());
			ps.setInt(4, e.getProductId());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int delete(int id) {
		int status = 0;
		try {
			Connection con =  ProductDao.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from Product where productid=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public static Product getProductById(int id) {
		Product e = new Product();

		try {
			Connection con =  ProductDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from Product where productid=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				e.setProductId(rs.getInt(1));
				e.setProductName(rs.getString(2));
				e.setProductPrice(rs.getString(3));
				e.setDescription(rs.getString(4));

			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return e;
	}

	public static List<Product> getAllProducts() {
		List<Product> list = new ArrayList<Product>();

		try {
			Connection con =  ProductDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from Product");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product e = new Product();
				e.setProductId(rs.getInt(1));
				e.setProductName(rs.getString(2));
				e.setProductPrice(rs.getString(3));
				e.setDescription(rs.getString(4));

				list.add(e);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}
