import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;


public class AdminLogin {

	private JFrame frame;
	private JPasswordField pwdPassword;
	private JLabel lblInvalidPassword;
	ProductInterface pro=new ProductInterface();

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public AdminLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame("Administrator Login");
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel label = new JLabel("Enter Admin Password : ");
		label.setFont(new Font("Ubuntu Medium", Font.BOLD, 14));
		
		pwdPassword = new JPasswordField();
		pwdPassword.setText("");
		pwdPassword.setEchoChar('*');
		
        
        
		
		
		lblInvalidPassword = new JLabel("INVALID PASSWORD");
		lblInvalidPassword.setFont(new Font("Loma", Font.BOLD, 14));
		lblInvalidPassword.setForeground(Color.RED);
		lblInvalidPassword.setVisible(false);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Ubuntu Medium", Font.BOLD, 14));
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String strPassword = new String(pwdPassword.getPassword());
				System.out.println("password="+strPassword);
				if(strPassword.equals("admin")){
					new ManageProducts(pro);
					frame.setVisible(false);
					frame.dispose();}
				else
					lblInvalidPassword.setVisible(true);
				//lblInvalidPassword.setVisible(true);
				}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblInvalidPassword)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(pwdPassword, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)))
					.addGap(33)
					.addComponent(btnLogin)
					.addContainerGap(53, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(111)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(pwdPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLogin))
					.addGap(57)
					.addComponent(lblInvalidPassword)
					.addContainerGap(91, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
