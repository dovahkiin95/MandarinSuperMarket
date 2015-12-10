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

public class ManageProducts extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public static JDialog d;

	private static JTable table = new JTable();
	// protected static List<Products> ProductList1=null;
	private String search;
	private ProductInterface pi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			// ManageProducts dialog = new ManageProducts();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ManageProducts(ProductInterface pro) {

		this.pi = pro;

		Manage();
	}

	public void Manage() {
		d = new JDialog();
		d.setVisible(true);
		d.setTitle("Manage Products");
		d.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		d.setBounds(100, 100, 713, 518);
		d.getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		d.getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			d.getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				{
					JButton button = new JButton("Update");
					button.setFont(new Font("Ubuntu Medium", Font.BOLD, 14));
					button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							new UpdateProduct();
						}
					});
					JButton btnReferesh = new JButton("Referesh");
					btnReferesh
							.setFont(new Font("Ubuntu Medium", Font.BOLD, 14));
					btnReferesh.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							d.setVisible(false);
							d.dispose();
							Manage();

						}
					});
					buttonPane.add(btnReferesh);
					buttonPane.add(button);
				}
				{
					JButton btnUpdateHistory = new JButton("Update History");
					btnUpdateHistory.setFont(new Font("Ubuntu Medium",
							Font.BOLD, 14));
					btnUpdateHistory.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							TriggerInterface pr = new TriggerInterface();
							new TriggerDisplay(pr);
						}
					});
					buttonPane.add(btnUpdateHistory);
				}
			}
			{
				JButton okButton = new JButton("New Product Entry");
				okButton.setFont(new Font("Ubuntu Medium", Font.BOLD, 14));
				okButton.setActionCommand("entry");
				buttonPane.add(okButton);
				okButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						new InsertProduct();
					}
				});
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Remove Product");
				cancelButton.setFont(new Font("Ubuntu Medium", Font.BOLD, 14));
				cancelButton.setActionCommand("remove");
				cancelButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						new DeleteProduct();
					}
				});
				buttonPane.add(cancelButton);
			}

			{
				try {

					List<Products> ProductList1 = null;

					ProductList1 = pi.getAllProducts();

					// create the model and update the "table" */
					AllTableModel model = new AllTableModel(ProductList1);
					table.setModel(model);

					/*
					 * for (Complaint temp : Complaints) {
					 * System.out.println(temp); }
					 */

				} catch (Exception exc) {
					JOptionPane
							.showMessageDialog(ManageProducts.this, "Error: "
									+ exc, "Error", JOptionPane.ERROR_MESSAGE);
				}

			}
			{
				JScrollPane scrollPane = new JScrollPane();
				contentPanel.add(scrollPane, BorderLayout.CENTER);

				scrollPane.setViewportView(table);
			}
		}
		d.setVisible(true);

	}
}
