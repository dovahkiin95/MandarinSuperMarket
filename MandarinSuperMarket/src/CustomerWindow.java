import java.awt.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerWindow {

	public static JFrame frame;
	public static JPanel buttonPanel;
	public static GridBagConstraints constraint;
	public static JScrollPane pane;
	public static JPanel Mainpanel;
	public static JTextField textField;
	private JSeparator separator;
	public static JTextField textField_1;
	public static JTextField textField_2;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public CustomerWindow() {

		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Customer Purchase");
		frame.setResizable(false);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height
				/ 2 - frame.getSize().height / 2);
		frame.setVisible(true);
		frame.setBounds(100, 100, 712, 437);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		Mainpanel = new JPanel(new BorderLayout());
		Mainpanel.setBackground(Color.LIGHT_GRAY);

		JComboBox comboBox = new JComboBox(new CheckBoxPopulate().getCategory());
		comboBox.setFont(new Font("Ubuntu Medium", Font.BOLD, 14));

		comboBox.addActionListener(new ComboBoxListener());

		JLabel lblSelectCategory = new JLabel("Select Category");
		lblSelectCategory.setFont(new Font("Ubuntu Medium", Font.BOLD, 14));

		JLabel lblProducts = new JLabel("Products");
		lblProducts.setFont(new Font("Ubuntu Medium", Font.BOLD, 14));

		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Ubuntu Medium", Font.BOLD, 14));

		textField = new JTextField();
		textField.setText("0");
		textField.setColumns(10);

		separator = new JSeparator();

		JButton btnPay = new JButton("PAY");
		btnPay.setForeground(Color.GREEN);
		btnPay.setFont(new Font("Ubuntu Light", Font.BOLD, 14));
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ProductPriceTable1();
			}
		});

		JLabel lblRs = new JLabel("RS");
		lblRs.setFont(new Font("Ubuntu Medium", Font.ITALIC, 14));

		JLabel lblSelectedItem = new JLabel("Selected Item :");

		textField_1 = new JTextField();

		textField_1.setColumns(10);
		textField_1.setEditable(false);

		JLabel lblPrice = new JLabel("Price :");

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setEditable(false);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGap(29)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING,
																false)
														.addComponent(
																separator,
																GroupLayout.PREFERRED_SIZE,
																1,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(18)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								comboBox,
																								GroupLayout.PREFERRED_SIZE,
																								109,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								lblSelectCategory,
																								GroupLayout.DEFAULT_SIZE,
																								124,
																								Short.MAX_VALUE))))
										.addPreferredGap(
												ComponentPlacement.RELATED, 39,
												Short.MAX_VALUE)
										.addComponent(Mainpanel,
												GroupLayout.PREFERRED_SIZE,
												216, GroupLayout.PREFERRED_SIZE)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(30)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.TRAILING)
																						.addComponent(
																								lblTotal,
																								GroupLayout.PREFERRED_SIZE,
																								80,
																								GroupLayout.PREFERRED_SIZE)
																						.addGroup(
																								groupLayout
																										.createSequentialGroup()
																										.addComponent(
																												lblRs)
																										.addGap(12)
																										.addGroup(
																												groupLayout
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addComponent(
																																textField_2,
																																GroupLayout.PREFERRED_SIZE,
																																GroupLayout.DEFAULT_SIZE,
																																GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																textField,
																																GroupLayout.PREFERRED_SIZE,
																																GroupLayout.DEFAULT_SIZE,
																																GroupLayout.PREFERRED_SIZE)))))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(77)
																		.addComponent(
																				btnPay,
																				GroupLayout.PREFERRED_SIZE,
																				78,
																				GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(114, Short.MAX_VALUE))
						.addGroup(
								groupLayout.createSequentialGroup().addGap(263)
										.addComponent(lblProducts)
										.addContainerGap(383, Short.MAX_VALUE))
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGap(84)
										.addComponent(lblSelectedItem)
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addComponent(textField_1,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(70).addComponent(lblPrice)
										.addContainerGap(276, Short.MAX_VALUE)));
		groupLayout
				.setVerticalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(30)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.TRAILING)
																						.addGroup(
																								groupLayout
																										.createSequentialGroup()
																										.addComponent(
																												lblSelectCategory)
																										.addPreferredGap(
																												ComponentPlacement.UNRELATED)
																										.addComponent(
																												comboBox,
																												GroupLayout.PREFERRED_SIZE,
																												38,
																												GroupLayout.PREFERRED_SIZE)
																										.addGap(103)
																										.addComponent(
																												separator,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE)
																										.addGap(18))
																						.addComponent(
																								Mainpanel,
																								GroupLayout.PREFERRED_SIZE,
																								260,
																								GroupLayout.PREFERRED_SIZE)))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(72)
																		.addComponent(
																				lblTotal,
																				GroupLayout.PREFERRED_SIZE,
																				50,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(18)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								textField,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								lblRs))
																		.addGap(30)
																		.addComponent(
																				btnPay,
																				GroupLayout.PREFERRED_SIZE,
																				43,
																				GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addComponent(lblProducts)
										.addGap(52)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblSelectedItem)
														.addComponent(
																textField_1,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblPrice)
														.addComponent(
																textField_2,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap(48, Short.MAX_VALUE)));
		// scroll button starts
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridBagLayout());
		buttonPanel.setSize(new Dimension(500, 300)); // whatever

		// the scrollpane
		pane = new JScrollPane();
		pane.setViewportBorder(new SoftBevelBorder(BevelBorder.LOWERED, null,
				null, null, null));
		pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pane.setSize(new Dimension(500, 500)); // whatever

		// GridBagConstraint for button
		constraint = new GridBagConstraints();
		constraint.anchor = GridBagConstraints.CENTER;
		constraint.fill = GridBagConstraints.NONE;
		constraint.gridx = 0;
		constraint.gridy = GridBagConstraints.RELATIVE;
		constraint.weightx = 1.0f;
		constraint.weighty = 1.0f;

		/*
		 * int sizeOfButtons = 50; for(int i = 0; i < sizeOfButtons; i++) {
		 * JButton button = new JButton();
		 * 
		 * button.setText("Button #" + i);
		 * 
		 * // other attributes you will set
		 * 
		 * buttonPanel.add(button, constraint); }
		 */
		new Allproducts();

		pane.setViewportView(buttonPanel);
		// this.frame.add(pane); // or other panel etc.
		// pane.updateUI();

		// / JButton btnHaha = new JButton("haha");
		GroupLayout gl_Mainpanel = new GroupLayout(Mainpanel);
		gl_Mainpanel.setHorizontalGroup(gl_Mainpanel.createParallelGroup(
				Alignment.LEADING).addGroup(
				Alignment.TRAILING,
				gl_Mainpanel
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(pane, GroupLayout.DEFAULT_SIZE, 82,
								Short.MAX_VALUE).addContainerGap()));
		gl_Mainpanel.setVerticalGroup(gl_Mainpanel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_Mainpanel
						.createSequentialGroup()
						.addComponent(pane, GroupLayout.DEFAULT_SIZE, 128,
								Short.MAX_VALUE).addContainerGap()));
		Mainpanel.setLayout(gl_Mainpanel);
		frame.getContentPane().setLayout(groupLayout);

	}
}
