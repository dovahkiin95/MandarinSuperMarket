import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProductInterface {
	Products tempProducts;
	
	
	
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



public Products getProductObjects(String search) throws Exception {
	

	PreparedStatement myStmt = null;
	ResultSet myRs = null;
	DBconnect ob=new DBconnect();
	String product1;
	Double price1;
	
	PreparedStatement populate;
	


	try {
		//search += "%";
		System.out.println("Before haha Query");
		//myStmt = ob.con.prepareStatement("SELECT Item,Price from Products");
		
		//myStmt.setString(1, search);
		
		//myRs = myStmt.executeQuery();
		
		//String item = myRs.getString("Item");
		//Double price = myRs.getDouble("Price");
		//System.out.println("Item="+item+" Price="+price);
		
		populate = ob.con.prepareStatement("SELECT Item,Price from Products WHERE Item=?");
	    populate.setString(1,search);
	    populate.setMaxRows(1); 
	    ResultSet r =populate.executeQuery();
	    System.out.println("executed query");
	  
	   while (r.next()) {
	    	int i=0;
             product1= r.getString(1);
             price1=r.getDouble(2);
          //  getPrice.put(product,price);
         	tempProducts = convertRowToProduct(r);
            System.out.print(product1+" LOL :");
            System.out.println(price1);
            
	    }return tempProducts;
            
	    
	  
		
		
	}catch(Exception e){};
	return tempProducts;


}
}
