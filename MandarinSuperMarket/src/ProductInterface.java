import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductInterface {
	Products tempProducts;
	public static double total = 0;

	public List<Products> searchProducts(String search) throws Exception {
		List<Products> list = new ArrayList<>();

		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		DBconnect ob = new DBconnect();

		try {
			search += "%";

			myStmt = ob.con
					.prepareStatement("select * from Complaint where CompID like ?");

			myStmt.setString(1, search);

			myRs = myStmt.executeQuery();

			while (myRs.next()) {

				Products tempProducts = convertRowToProduct(myRs);
				list.add(tempProducts);
			}
			return list;
		} finally {
			ob.con.close();
		}
	}

	public List<Products> getAllProducts() throws Exception {
		List<Products> list = new ArrayList<>();

		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		DBconnect ob = new DBconnect();

		try {

			myStmt = ob.con.prepareStatement("select * from Products");

			myRs = myStmt.executeQuery();

			while (myRs.next()) {

				Products tempProducts = convertRowToProduct1(myRs);
				list.add(tempProducts);
			}
			return list;
		} finally {
			ob.con.close();
		}
	}

	private Products convertRowToProduct(ResultSet r) throws SQLException {

		String item = r.getString("Item");
		Double price = r.getDouble("Price");

		total += price;

		Products tempComplaint = new Products(item, price);

		return tempComplaint;
	}

	public Products getProductObjects(String search) throws Exception {

		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		DBconnect ob = new DBconnect();
		String product1;
		Double price1;

		PreparedStatement populate;

		try {

			populate = ob.con
					.prepareStatement("SELECT Item,Price from Products WHERE Item=?");
			populate.setString(1, search);
			populate.setMaxRows(1);
			ResultSet r = populate.executeQuery();

			while (r.next()) {
				int i = 0;
				product1 = r.getString(1);
				price1 = r.getDouble(2);
				// getPrice.put(product,price);
				tempProducts = convertRowToProduct(r);

			}
			return tempProducts;

		} catch (Exception e) {
		}
		;
		return tempProducts;

	}

	private Products convertRowToProduct1(ResultSet r) throws SQLException {

		String item = r.getString("Item");
		Double price = r.getDouble("Price");
		int dno = r.getInt("D_num");
		String id = r.getString("Product_Id");

		Products tempComplaint = new Products(item, price, id, dno);

		return tempComplaint;
	}
}
