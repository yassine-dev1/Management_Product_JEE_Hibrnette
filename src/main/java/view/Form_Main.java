package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;

public class Form_Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form_Main frame = new Form_Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Form_Main() {
		setResizable(false);
		setTitle("Gestion Commerciale");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(29, 50, 511, 105);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ce projet est réalisé dans le cadre de la formation assurée au cycle d'ingénieur ILISI. ");
		lblNewLabel.setBounds(23, 20, 478, 13);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Module JEE/ Framework Hibernate.");
		lblNewLabel_1.setBounds(23, 44, 309, 13);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("réalisé et enseigné par Pr. Omar EL BEGGAR.");
		lblNewLabel_2.setBounds(23, 67, 374, 13);
		panel.add(lblNewLabel_2);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 144, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Gestion Commerciale >");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Gestion Client");
		mntmNewMenuItem.setSelected(true);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Form_Client().setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Gestion Commande");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new Form_Commande().setVisible(true);	
				
			
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);

		 JMenuItem mntmNewMenuItem_2 = new JMenuItem("Gestion Produit");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new Form_Produit().setVisible(true);	
				
			
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);

		JMenuItem mntmFournisseur = new JMenuItem("Gestion Fournisseur");
		mntmFournisseur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Form_Fournisseur().setVisible(true);
			}
		});
		mnNewMenu.add(mntmFournisseur);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Fermer");
		mnNewMenu.add(mntmNewMenuItem_3);
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
	}
}
