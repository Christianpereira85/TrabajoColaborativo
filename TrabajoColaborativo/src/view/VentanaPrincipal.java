package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class VentanaPrincipal {

	private JFrame frmMiniProyectocodesurfers;
	private JPanel panelLateral;
	boolean swch=true;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frmMiniProyectocodesurfers.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMiniProyectocodesurfers = new JFrame();
		frmMiniProyectocodesurfers.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/Images/logo chico.png")));
		frmMiniProyectocodesurfers.setResizable(false);
		frmMiniProyectocodesurfers.setTitle("Mini Proyecto \"CodeSurfers\"");
		frmMiniProyectocodesurfers.getContentPane().setBackground(new Color(255, 255, 255));
		frmMiniProyectocodesurfers.setBounds(100, 100, 800, 500);
		frmMiniProyectocodesurfers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMiniProyectocodesurfers.getContentPane().setLayout(null);
		
		panelLateral = new JPanel();
		panelLateral.setBorder(null);
		panelLateral.setBackground(new Color(153, 204, 255));
		panelLateral.setBounds(0, 0, 228, 461);
		frmMiniProyectocodesurfers.getContentPane().add(panelLateral);
		panelLateral.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(54, 11, 128, 128);
		lblNewLabel.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/Images/logo chico.png")));
		panelLateral.add(lblNewLabel);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmRegistro.main(null);
				frmMiniProyectocodesurfers.disable();
			}
		});
		btnRegister.setBackground(new Color(153, 204, 255));
		btnRegister.setForeground(new Color(0, 51, 51));
		btnRegister.setFont(new Font("Rubik", Font.PLAIN, 12));
		btnRegister.setBounds(54, 147, 128, 23);
		panelLateral.add(btnRegister);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrmLogin.main(null);
				frmMiniProyectocodesurfers.disable();
			}
		});
		btnLogin.setForeground(new Color(0, 51, 51));
		btnLogin.setFont(new Font("Rubik", Font.PLAIN, 12));
		btnLogin.setBackground(new Color(153, 204, 255));
		btnLogin.setBounds(54, 181, 128, 23);
		panelLateral.add(btnLogin);
		
		JLabel lblBgMid = new JLabel("New label");
		lblBgMid.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/Images/bg.jpg")));
		lblBgMid.setBounds(226, 0, 558, 461);
		frmMiniProyectocodesurfers.getContentPane().add(lblBgMid);
	}
}
