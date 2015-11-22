import java.sql.*;
import java.awt.*;

import javax.swing.*;


public class Allproducts {
	
	public Allproducts() {
		// TODO Auto-generated constructor stub
		CustomerWindow.buttonPanel.removeAll();
		CustomerWindow.Mainpanel.revalidate();
		CustomerWindow.Mainpanel.repaint();
		CustomerWindow.buttonPanel.revalidate();
		CustomerWindow.buttonPanel.repaint();
		CustomerWindow.pane.revalidate();
		CustomerWindow.pane.repaint();
		// TODO Auto-generated method stub
		DBconnect ob=new DBconnect();
		 
		
	     PreparedStatement populate;
			try {
				populate = ob.con.prepareStatement("SELECT Item,Price from Products");
			    
			    ResultSet r =populate.executeQuery();
			  
			    while (r.next()) {
			    	int i=0;
	                String product= r.getString(1);
	                double price=r.getDouble(2);
	              //  getPrice.put(product,price);
	                System.out.print(product+":");
	                System.out.println(price);
	                //button = new JButton();
	                //button.setActionCommand(product);

			        //button.setText(product);
			        
			       ComboBoxListener.buttons[i] = new JButton("" + product); //create button & add to array
			    //    buttons[i].addActionListener(this); //add an action listener to the current button     
			        // other attributes you will set
			       ComboBoxListener.buttons[i].setPreferredSize(new Dimension(190,30));
			       CustomerWindow.buttonPanel.add(ComboBoxListener.buttons[i], CustomerWindow.constraint);
			           
	                System.out.println("making button "+product);
	                
	    		  
	                

	}
			    CustomerWindow.pane.setViewportView(CustomerWindow.buttonPanel);
			
	}catch(Exception ee) {
		ee.printStackTrace();
	}
	}
		
	}

	
	
	
	
	
	
	

