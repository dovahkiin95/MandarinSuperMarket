import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Products {
	private String item;
	private Double price;
	
	
	
	public Products(String item, Double price) {
		this.item=item;
		this.price=price;
	}
	public Products() {
		
	}
	
	public String getItem() {
		return this.item;
	}

	public Double getPrice() {
		return this.price;
	}
	
	public List<Products> searchProducts(String search) throws Exception {
		List<Products> list = new ArrayList<>();

		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		DBconnect ob=new DBconnect();

		try {
			search += "%";
			
			myStmt = ob.con.prepareStatement("select * from Complaint where CompID like ?");
			
			myStmt.setString(1, search);
			
			myRs = myStmt.executeQuery();
			
			while (myRs.next()) {
				
				Products tempProducts = convertRowToProduct(myRs);
				list.add(tempProducts);
			}
			return list;
		}
		finally {
			ob.con.close();
		}
	}
	
private Products convertRowToProduct(ResultSet r) throws SQLException {
		
		
		String item = r.getString(1);
		Double price = r.getDouble(2);
		System.out.println("Item="+item+" Price="+price);
		
		Products tempComplaint = new Products(item,price);
		
		return tempComplaint;
	}




}

