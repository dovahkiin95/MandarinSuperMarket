import java.sql.*;
import java.util.Vector;



public class CheckBoxPopulate {
	 Vector v = new Vector();
	public CheckBoxPopulate() {
		 try {
		    	DBconnect ob=new DBconnect();
				System.out.println("Connected to the database");
		    	Statement st=(Statement)ob. con.createStatement();
		    	//ResultSet rs = st.executeQuery(q);
		    	st = ob.con.createStatement();
	           ResultSet rs = st.executeQuery("select Department from Category");
	           
	            while (rs.next()) {
	                String category= rs.getString(1);
	                System.out.println(category);
	                v.add(category);
	            }
		// TODO Auto-generated constructor stub
	   }catch (Exception e) {
     	e.printStackTrace();

	    }
	}
	Vector getCategory() {
		return v;
	}
	
	String getAll() {
		return "all";
	}
}
