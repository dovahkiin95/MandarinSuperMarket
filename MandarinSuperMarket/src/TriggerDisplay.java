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
		 
		d.setBounds(100, 100, 450, 300);
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
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			
			{	
				try {
				
					List<TriggerClass> ProductList1 = null;
					System.out.println("trying to get trigger products");
				ProductList1=pi.getAllProducts();
				System.out.println("got all trigger products");
				// create the model and update the "table"  */
				TriggerTableModel model = new TriggerTableModel(ProductList1);							
				table.setModel(model);
				System.out.println("CReated table model lol");
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
