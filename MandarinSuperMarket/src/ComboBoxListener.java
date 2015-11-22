import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;


public class ComboBoxListener implements ActionListener {
	 public static JButton[] buttons  = new JButton[18];
	@Override
	public void actionPerformed(ActionEvent e) {
		CustomerWindow.buttonPanel.removeAll();
		CustomerWindow.Mainpanel.revalidate();
		CustomerWindow.Mainpanel.repaint();
		CustomerWindow.buttonPanel.revalidate();
		CustomerWindow.buttonPanel.repaint();
		CustomerWindow.pane.revalidate();
		CustomerWindow.pane.repaint();
		// TODO Auto-generated method stub
		DBconnect ob=new DBconnect();
		 JComboBox combo = (JComboBox)e.getSource();
		 String dep=(String)combo.getSelectedItem();
         PreparedStatement populate;
			try {
				populate = ob.con.prepareStatement("SELECT Item,Price from Products where D_num in (select D_no from Category where Department=?)");
			    populate.setString(1,dep);
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
			        
			        buttons[i] = new JButton("" + product); //create button & add to array
			        buttons[i].setPreferredSize(new Dimension(190,30));
			    //    buttons[i].addActionListener(this); //add an action listener to the current button     
			        // other attributes you will set

			       CustomerWindow.buttonPanel.add(buttons[i], CustomerWindow.constraint);
			           
	                System.out.println("making button "+product);
	                
	    		   // buttons[i].addActionListener(
	                

	}
			    CustomerWindow.pane.setViewportView(CustomerWindow.buttonPanel);
			
	}catch(Exception ee) {
		ee.printStackTrace();
	}
}
}

