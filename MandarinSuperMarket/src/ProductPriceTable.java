import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;






public class ProductPriceTable extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table = new JTable();
	protected static  List<Products> ProductList= new ArrayList<Products>();
	private String search;
	private ProductInterface pi;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ProductPriceTable dialog = new ProductPriceTable();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			System.out.println("Inside main ppt");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * Create the dialog.
	 */
	
	public ProductPriceTable(String x,ProductInterface pro) {

		this();
		this.search=x;
		this.pi=pro;
		
		System.out.println("leaving ppt constuctr 1");
		
	}
	public ProductPriceTable() {
		try {
			ProductPriceTable dialog = new ProductPriceTable();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			System.out.println("Inside main ppt");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Inside ppt constuctr 2");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				try {
				
				//String CompID = CompIDtextField.getText();
				//long CompID= Long.parseLong(tCompID);
				//long tCompID= Long.parseLong(CompID);
				
				Products tempProduct=pi.getProductObjects(search);
				System.out.println("got product object !!");
				System.out.println(tempProduct.getItem() + ":"+ tempProduct.getPrice());
				ProductList.add(tempProduct);
				System.out.println("added to product list");
	
				
				// create the model and update the "table"  */
				TableModel model = new TableModel(ProductList);							
				table.setModel(model);
				System.out.println("CReated table model");
				/*
				for (Complaint temp : Complaints) {
					System.out.println(temp);
				}*/
				
			} catch (Exception exc) {
				JOptionPane.showMessageDialog(ProductPriceTable.this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE); 
			}	
			
		}
		{
		JScrollPane scrollPane = new JScrollPane();
		contentPanel.add(scrollPane, BorderLayout.CENTER);
		
		
		scrollPane.setViewportView(table);
		
		}
		}
		

	}
}
