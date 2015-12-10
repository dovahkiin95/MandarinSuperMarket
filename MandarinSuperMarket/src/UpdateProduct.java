import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.mysql.jdbc.PreparedStatement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.Font;

public class UpdateProduct extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	String price, item;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UpdateProduct dialog = new UpdateProduct();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public UpdateProduct() {
		final DBconnect ob = new DBconnect();
		JDialog d = new JDialog();
		d.setResizable(false);

		d.setVisible(true);
		d.setBounds(100, 100, 450, 300);
		d.getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		d.getContentPane().add(contentPanel, BorderLayout.CENTER);

		textField = new JTextField();
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		JLabel lblItem = new JLabel("Item");
		lblItem.setFont(new Font("Ubuntu Medium", Font.BOLD, 14));

		JLabel lblNewPrice = new JLabel("New Price");
		lblNewPrice.setFont(new Font("Ubuntu Medium", Font.BOLD, 14));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel
				.setHorizontalGroup(gl_contentPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPanel
										.createSequentialGroup()
										.addGap(30)
										.addGroup(
												gl_contentPanel
														.createParallelGroup(
																Alignment.TRAILING)
														.addGroup(
																gl_contentPanel
																		.createSequentialGroup()
																		.addComponent(
																				lblItem)
																		.addGap(48))
														.addGroup(
																gl_contentPanel
																		.createSequentialGroup()
																		.addComponent(
																				lblNewPrice)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)))
										.addGroup(
												gl_contentPanel
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																textField_1,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																textField,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap(169, Short.MAX_VALUE)));
		gl_contentPanel
				.setVerticalGroup(gl_contentPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPanel
										.createSequentialGroup()
										.addGap(56)
										.addGroup(
												gl_contentPanel
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																textField,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblItem))
										.addGap(51)
										.addGroup(
												gl_contentPanel
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																textField_1,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblNewPrice))
										.addContainerGap(82, Short.MAX_VALUE)));
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			d.getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("UPDATE");
				okButton.setFont(new Font("Ubuntu Medium", Font.BOLD, 14));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						PreparedStatement ps;
						item = textField.getText();
						price = textField_1.getText();

						Double x = Double.parseDouble(price);

						try {

							// ps=ob.con.prepareStatement("update Products SET Price=? where Item=?;");
							PreparedStatement ps1 = (PreparedStatement) ob.con
									.prepareStatement("update Products SET Price=? where Item=?;");

							ps1.setDouble(1, x);
							ps1.setString(2, item);
							int i = ps1.executeUpdate();
							if (i > 0) {
								JOptionPane.showMessageDialog(null,
										"Updated Successfully !");
							}

						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
