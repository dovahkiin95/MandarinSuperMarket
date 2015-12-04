import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TriggerClass {
	private String update,changed,item,id,oldPrice,newPrice;
	
	
	
	
	public TriggerClass(String update, String changed, String item, String id, String oldPrice, String newPrice) {
		this.update=update;
		this.changed=changed;
		this.item=item;
		this.id=id;
		this.oldPrice=oldPrice;
		this.newPrice=newPrice;
	}
	
	
	public TriggerClass() {
		
	}
	
	public String getId() {
		return this.id;
	}
	
	public  String getUpdate() {
		return this.update;
	}
	
	public String getItem() {
		return this.item;
	}

	public String getChanged() {
		return this.changed;
	}
	
	public  String getOldPrice(){
		return this.oldPrice;
	}
	
	public String getNewPrice(){
		return this.newPrice;
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

