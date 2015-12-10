import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Dimension;


public class TriggerDisplay extends JDialog {

	private final JPanel contentPanel = new JPanel();
 
    private static JTable table = new JTable();private TriggerInterface pi;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
		//	TriggerDisplay dialog = new TriggerDisplay();
			//dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			//dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
public TriggerDisplay(TriggerInterface pro) {
		
		
	    this.pi=pro;
	    System.out.println("leaving const 1");
	    Display();
		}

	public void Display() {
		JDialog d=new JDialog();
		d.setTitle("Update History"); 
		d.setBounds(100, 100, 1247, 365);
		d.getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		d.getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			d.getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setFont(new Font("Ubuntu Medium", Font.BOLD, 14));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			
			{	
				try {
				
					List<TriggerClass> ProductList1 = null;
					System.out.println("trying to get trigger products");
				ProductList1=pi.getAllProducts();
				System.out.println("got all trigger products");
				// create the model and update the "table"  */
				TriggerTableModel model = new TriggerTableModel(ProductList1);		
				table.setPreferredScrollableViewportSize(new Dimension(1200, 400));
				table.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
				
				table.setModel(model);
				int columnCount = table.getColumnCount();
				int width = 200,i;
				for(i=0;i<columnCount;i++){
					if(i==1 || i==2)
					   table.getColumnModel().getColumn(i).setPreferredWidth(500);
					else
						table.getColumnModel().getColumn(i).setPreferredWidth(100);
				}
			 
			
				/*
				for (Complaint temp : Complaints) {
					System.out.println(temp);
				}*/
				
			} catch (Exception exc) {
				JOptionPane.showMessageDialog(TriggerDisplay.this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE); 
			}	
			
		}
			
			{
				JScrollPane scrollPane = new JScrollPane();
				contentPanel.add(scrollPane, BorderLayout.CENTER);
				
				
				scrollPane.setViewportView(table);
				}
		
		}d.setVisible(true);
	}

}
