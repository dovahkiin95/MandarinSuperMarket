import java.awt.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;


public class CustomerWindow {

	private JFrame frame;
	public static JPanel buttonPanel;
	public static GridBagConstraints constraint;
	public static  JScrollPane pane;
	public static JPanel Mainpanel;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public CustomerWindow() {
		
		initialize();
		System.out.println("entered cw");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 628, 343);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Mainpanel = new JPanel();
		Mainpanel.setBackground(Color.blue);
		
		
		JComboBox comboBox = new JComboBox(new CheckBoxPopulate().getCategory());
		
		comboBox.addActionListener(new ComboBoxListener());
		
		
		JLabel lblSelectCategory = new JLabel("Select Category");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addComponent(lblSelectCategory))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(37)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
					.addGap(27)
					.addComponent(Mainpanel, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(106, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(78)
							.addComponent(lblSelectCategory)
							.addGap(18)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(Mainpanel, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		// scroll button starts
		buttonPanel = new JPanel();
	    buttonPanel.setLayout(new GridBagLayout());
	    buttonPanel.setSize(new Dimension(400, 300)); // whatever

	    // the scrollpane
	    pane = new JScrollPane();
	    pane.setSize(new Dimension(400, 300)); // whatever

	    // GridBagConstraint for button
	    constraint = new GridBagConstraints();
	    constraint.anchor = GridBagConstraints.CENTER;
	    constraint.fill = GridBagConstraints.NONE;
	    constraint.gridx = 0;
	    constraint.gridy = GridBagConstraints.RELATIVE;
	    constraint.weightx = 1.0f;
	    constraint.weighty = 1.0f;

	  /*  int sizeOfButtons = 50;
	    for(int i = 0; i < sizeOfButtons; i++) {
	        JButton button = new JButton();

	        button.setText("Button #" + i);

	        // other attributes you will set

	        buttonPanel.add(button, constraint);
	    } */
	    new Allproducts();

	    pane.setViewportView(buttonPanel);
	    //this.frame.add(pane); // or other panel etc.
	   // pane.updateUI();
		
	///	JButton btnHaha = new JButton("haha");
		GroupLayout gl_Mainpanel = new GroupLayout(Mainpanel);
		gl_Mainpanel.setHorizontalGroup(
			gl_Mainpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_Mainpanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(pane, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_Mainpanel.setVerticalGroup(
			gl_Mainpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Mainpanel.createSequentialGroup()
					.addComponent(pane, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
					.addContainerGap())
		);
		Mainpanel.setLayout(gl_Mainpanel);
		frame.getContentPane().setLayout(groupLayout);
		
		
	}
}
