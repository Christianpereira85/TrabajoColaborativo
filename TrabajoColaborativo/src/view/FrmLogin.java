package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dao.*;
import dto.PersonaBO;

import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class FrmLogin {

	private JFrame frmLogin;
	private JTextField txtEmail;
	private JTextField txtClave;
	FuncionalidadDAO funcionalidad = new FuncionalidadDAOImpl();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogin window = new FrmLogin();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrmLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setResizable(false);
		frmLogin.setTitle("Login");
		frmLogin.setIconImage(Toolkit.getDefaultToolkit().getImage(FrmLogin.class.getResource("/Images/logo chico.png")));
		frmLogin.setBounds(100, 100, 800, 500);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JPanel panelLateral = new JPanel();
		panelLateral.setLayout(null);
		panelLateral.setBorder(null);
		panelLateral.setBackground(new Color(153, 204, 255));
		panelLateral.setBounds(0, 0, 228, 461);
		frmLogin.getContentPane().add(panelLateral);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrmLogin.class.getResource("/Images/logo chico.png")));
		lblNewLabel.setBounds(54, 11, 128, 128);
		panelLateral.add(lblNewLabel);
		
		txtEmail = new JTextField();
		txtEmail.setToolTipText("");
		txtEmail.setText("Email");
		txtEmail.setForeground(Color.BLACK);
		txtEmail.setFont(new Font("Rubik", Font.ITALIC, 12));
		txtEmail.setColumns(10);
		txtEmail.setBackground(new Color(153, 204, 255));
		txtEmail.setBounds(54, 150, 128, 20);
		panelLateral.add(txtEmail);
		
		txtClave = new JTextField();
		txtClave.setToolTipText("");
		txtClave.setText("Contraseña");
		txtClave.setForeground(Color.BLACK);
		txtClave.setFont(new Font("Rubik", Font.ITALIC, 12));
		txtClave.setColumns(10);
		txtClave.setBackground(new Color(153, 204, 255));
		txtClave.setBounds(54, 181, 128, 20);
		panelLateral.add(txtClave);
		
		JList list = new JList();
		list.setBounds(0, 0, 1, 1);
		panelLateral.add(list);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				PersonaBO persona=new PersonaBO();
				boolean loginIn;
			
				loginIn = persona.Login(txtEmail.getText(), txtClave.getText());
				if (loginIn==true) {
					
					if(funcionalidad.activatePanel(PersonaDAOImpl.rol)) {
						JOptionPane.showMessageDialog(null, "Usted ha iniciado como administrador");
					}
					
					
					UserPanel.main(null);
					frmLogin.setVisible(false);
					
				}else {
					
					JOptionPane.showMessageDialog(null, "Los datos ingresados son incorrectos");	
				}
				
			}
		});
		btnLogin.setForeground(new Color(0, 51, 51));
		btnLogin.setFont(new Font("Rubik", Font.PLAIN, 12));
		btnLogin.setBackground(new Color(153, 204, 255));
		btnLogin.setBounds(54, 212, 128, 23);
		panelLateral.add(btnLogin);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(FrmLogin.class.getResource("/Images/login.jpg")));
		lblNewLabel_1.setBounds(226, 0, 558, 461);
		frmLogin.getContentPane().add(lblNewLabel_1);
	}

}
