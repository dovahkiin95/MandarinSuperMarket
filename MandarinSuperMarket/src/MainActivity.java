import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MainActivity {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainActivity window = new MainActivity();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainActivity() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Mandarin Super Market");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton CustomerPurchase = new JButton("Customer Purchase");
		CustomerPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("CustomerPurchase");
				new CustomerWindow();
			}
		});
		
		JButton AdministratorLogin = new JButton("Administrator Login");
		AdministratorLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//new CustomerWindow;
				System.out.println("Admin");
				new AdminLogin();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(44)
					.addComponent(CustomerPurchase)
					.addGap(18)
					.addComponent(AdministratorLogin)
					.addContainerGap(42, Short.MAX_VALUE))
					
		);
	//	AdministratorLogin.addActionListener(new ButtonClickListener());
		//CustomerPurchase.addActionListener(new ButtonClickListener());

		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(132)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(CustomerPurchase)
						.addComponent(AdministratorLogin))
					.addContainerGap(115, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
		
	}
	

}
