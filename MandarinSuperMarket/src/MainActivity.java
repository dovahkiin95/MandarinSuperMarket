import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JLabel;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.plaf.synth.SynthLookAndFeel;

import com.alee.laf.WebLookAndFeel;
import com.birosoft.liquid.LiquidLookAndFeel;
import com.jgoodies.looks.plastic.Plastic3DLookAndFeel;
import com.jgoodies.looks.plastic.PlasticLookAndFeel;
import com.jgoodies.looks.plastic.theme.DarkStar;
import com.seaglasslookandfeel.SeaGlassLookAndFeel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

public class MainActivity {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
					        if ("Nimbus".equals(info.getName())) {
					            UIManager.setLookAndFeel(info.getClassName());
					        	//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					        	//UIManager.setLookAndFeel ( new WebLookAndFeel () );
					        	//UIManager.setLookAndFeel ( new SynthLookAndFeel () );
					        	//UIManager.setLookAndFeel ( new LiquidLookAndFeel() );
					        	//UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
					        	

					            break;
					        }
					    }
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
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 361);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton CustomerPurchase = new JButton("Customer Purchase");
		CustomerPurchase.setFont(new Font("Ubuntu Medium", Font.BOLD, 14));
		CustomerPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("CustomerPurchase");
				new CustomerWindow();
				frame.setVisible(false);
			}
		});
		
		JButton AdministratorLogin = new JButton("Administrator Login");
		AdministratorLogin.setFont(new Font("Ubuntu Medium", Font.BOLD, 14));
		AdministratorLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//new CustomerWindow;
				System.out.println("Admin");
				new AdminLogin();
				frame.setVisible(false);
			}
		});
		
		JLabel lblWelcomeToMandarin = new JLabel("WELCOME TO MANDARIN ");
		lblWelcomeToMandarin.setFont(new Font("Ubuntu Medium", Font.BOLD, 16));
		
		JLabel lblMarket = new JLabel("SUPERMARKET");
		lblMarket.setFont(new Font("Ubuntu Medium", Font.BOLD, 17));
		
		JLabel lblNewLabel = new JLabel("v 1.0");
		lblNewLabel.setFont(new Font("Ubuntu Medium", Font.ITALIC, 12));
		
		JLabel lblByDovahkiin = new JLabel("");
		lblByDovahkiin.setFont(new Font("Ubuntu Medium", Font.ITALIC, 12));
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("/home/aqeel/Downloads/download.jpg"));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(103)
							.addComponent(lblWelcomeToMandarin, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(144)
							.addComponent(lblMarket))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblByDovahkiin, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(32)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 376, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(CustomerPurchase)
									.addGap(35)
									.addComponent(AdministratorLogin)))))
					.addContainerGap(715, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addComponent(lblWelcomeToMandarin, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblMarket)
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(CustomerPurchase)
						.addComponent(AdministratorLogin))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblByDovahkiin)
					.addGap(19))
		);
		frame.getContentPane().setLayout(groupLayout);
		
	}
}
