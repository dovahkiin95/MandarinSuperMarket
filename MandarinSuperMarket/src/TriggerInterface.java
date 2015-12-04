import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TriggerInterface {
	TriggerClass tempProducts;
	
	
	
	
	public List<TriggerClass> getAllProducts() throws Exception {
		List<TriggerClass> list = new ArrayList<>();

		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		DBconnect ob=new DBconnect();

		try {
			System.out.println("inside getAllProducts");
			
			myStmt = ob.con.prepareStatement("select * from Product_Update");
		
			
			myRs = myStmt.executeQuery();
			
			while (myRs.next()) {
				
				TriggerClass tempProducts = convertRowToProduct1(myRs);
				list.add(tempProducts);
			}System.out.println("Returning");
			return list;
		}
		finally {
			ob.con.close();
		}
	}



private TriggerClass convertRowToProduct1(ResultSet r) throws SQLException {
	
	
	String item = r.getString("Item_Updated");
	String Updateno = r.getString("Update_no");
	String changed=r.getString("Changed_On");
	String id=r.getString("Item_Id");
	String old=r.getString("Old_price");
	String newp=r.getString("New_price");
	

	
	TriggerClass tempComplaint = new TriggerClass(Updateno,changed,item,id,old,newp);
	
	return tempComplaint;
}
}
