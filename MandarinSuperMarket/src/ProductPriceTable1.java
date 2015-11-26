import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class ProductPriceTable1 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public static JDialog d;


	private static JTable table = new JTable();
	protected static  List<Products> ProductList= new ArrayList<Products>();
	private String search;
	private ProductInterface pi;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			System.out.println("Inside main");
			ProductInterface p=new ProductInterface();
			ProductPriceTable1 dialog = new ProductPriceTable1("haha",p);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
public ProductPriceTable1(String x,ProductInterface pro) {
	
	    d=new JDialog();
	
		d.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
	
		this.search=x;
		this.pi=pro;
		
		System.out.println("Inside ppt constuctr 1");
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
				System.out.println("CReated table model lol");
				/*
				for (Complaint temp : Complaints) {
					System.out.println(temp);
				}*/
				
			} catch (Exception exc) {
				JOptionPane.showMessageDialog(ProductPriceTable1.this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE); 
			}	
			
		}
		{
		JScrollPane scrollPane = new JScrollPane();
		contentPanel.add(scrollPane, BorderLayout.CENTER);
		
		
		scrollPane.setViewportView(table);
		}
		}
		d.setVisible(true);
		CustomerWindow.textField.setText(Double.toString(ProductInterface.total));
		CustomerWindow.frame.revalidate();
		//(ProductInterface.total);
		
	}

	/**
	 * Create the dialog.
	 */
	public ProductPriceTable1() {
		
		}
	}
