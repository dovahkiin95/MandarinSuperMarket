import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Allproducts {
	int count=0; ProductInterface pi=new  ProductInterface();
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
	                final String product= r.getString(1);
	                final double price=r.getDouble(2);
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
			       ComboBoxListener.buttons[i].addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent event) {
							// TODO Auto-generated method stub
							System.out.println("Getting table for "+((JButton) event.getSource()).getText());
							if(count>0) ProductPriceTable1.d.setVisible(false);
						
							CustomerWindow.textField_1.setText(product);
							CustomerWindow.textField_2.setText(String.valueOf(price));
							CustomerWindow.frame.revalidate();
							CustomerWindow.frame.repaint();
						new ProductPriceTable1(((JButton) event.getSource()).getText(),pi);	
						count++;
						
						}
					});
	                System.out.println("making button "+product);
	                
	    		  
	                

	}
			    CustomerWindow.pane.setViewportView(CustomerWindow.buttonPanel);
			
	}catch(Exception ee) {
		ee.printStackTrace();
	}
	}
		
	}

	
	
	
	
	
	
	

