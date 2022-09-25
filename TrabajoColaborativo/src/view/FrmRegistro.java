package view;

import java.awt.EventQueue;
import dao.*;
import dto.PersonaBO;
import dto.PersonaVO;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class FrmRegistro {

	private JFrame frmRegister;
	private JTextField txtNombre1;
	private JTextField txtNombre2;
	private JTextField txtApellido1;
	private JTextField txtDocumento;
	private JTextField txtFechaNac;
	private JTextField txtEmail;
	private JTextField txtContrasenia;
	private JTextField txtCOnfContrasenia;
	private JTextField txtApellido2;
	private PersonaBO personaBO = new PersonaBO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistro window = new FrmRegistro();
					window.frmRegister.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrmRegistro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegister = new JFrame();
		frmRegister.setTitle("Register");
		frmRegister.setIconImage(Toolkit.getDefaultToolkit().getImage(FrmRegistro.class.getResource("/Images/logo chico.png")));
		frmRegister.setResizable(false);
		frmRegister.setBounds(100, 100, 800, 500);
		frmRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegister.getContentPane().setLayout(null);
		
		JPanel panelLateral = new JPanel();
		panelLateral.setLayout(null);
		panelLateral.setBorder(null);
		panelLateral.setBackground(new Color(153, 204, 255));
		panelLateral.setBounds(0, 0, 228, 461);
		frmRegister.getContentPane().add(panelLateral);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrmRegistro.class.getResource("/Images/logo chico.png")));
		lblNewLabel.setBounds(54, 11, 128, 128);
		panelLateral.add(lblNewLabel);
		
		txtNombre1 = new JTextField();
		txtNombre1.setFont(new Font("Rubik", Font.ITALIC, 12));
		txtNombre1.setForeground(new Color(0, 0, 0));
		txtNombre1.setText("Primer Nombre");
		txtNombre1.setToolTipText("");
		txtNombre1.setBackground(new Color(153, 204, 255));
		txtNombre1.setBounds(54, 150, 128, 20);
		panelLateral.add(txtNombre1);
		txtNombre1.setColumns(10);
		
		txtNombre2 = new JTextField();
		txtNombre2.setToolTipText("");
		txtNombre2.setText("SegundoNombre");
		txtNombre2.setForeground(Color.BLACK);
		txtNombre2.setFont(new Font("Rubik", Font.ITALIC, 12));
		txtNombre2.setColumns(10);
		txtNombre2.setBackground(new Color(153, 204, 255));
		txtNombre2.setBounds(54, 181, 128, 20);
		panelLateral.add(txtNombre2);
		
		txtApellido1 = new JTextField();
		txtApellido1.setToolTipText("");
		txtApellido1.setText("Primer Apellido");
		txtApellido1.setForeground(Color.BLACK);
		txtApellido1.setFont(new Font("Rubik", Font.ITALIC, 12));
		txtApellido1.setColumns(10);
		txtApellido1.setBackground(new Color(153, 204, 255));
		txtApellido1.setBounds(54, 212, 128, 20);
		panelLateral.add(txtApellido1);
		
		txtApellido2 = new JTextField();
		txtApellido2.setToolTipText("");
		txtApellido2.setText("Segundo Apellido");
		txtApellido2.setForeground(Color.BLACK);
		txtApellido2.setFont(new Font("Rubik", Font.ITALIC, 12));
		txtApellido2.setColumns(10);
		txtApellido2.setBackground(new Color(153, 204, 255));
		txtApellido2.setBounds(54, 243, 128, 20);
		panelLateral.add(txtApellido2);
		
		txtDocumento = new JTextField();
		txtDocumento.setToolTipText("");
		txtDocumento.setText("C.I.");
		txtDocumento.setForeground(Color.BLACK);
		txtDocumento.setFont(new Font("Rubik", Font.ITALIC, 12));
		txtDocumento.setColumns(10);
		txtDocumento.setBackground(new Color(153, 204, 255));
		txtDocumento.setBounds(54, 273, 128, 20);
		panelLateral.add(txtDocumento);
		
		txtFechaNac = new JTextField();
		txtFechaNac.setToolTipText("");
		txtFechaNac.setText("dd/mm/aaaa");
		txtFechaNac.setForeground(Color.BLACK);
		txtFechaNac.setFont(new Font("Rubik", Font.ITALIC, 12));
		txtFechaNac.setColumns(10);
		txtFechaNac.setBackground(new Color(153, 204, 255));
		txtFechaNac.setBounds(54, 304, 128, 20);
		panelLateral.add(txtFechaNac);
		
		txtEmail = new JTextField();
		txtEmail.setToolTipText("");
		txtEmail.setText("Email");
		txtEmail.setForeground(Color.BLACK);
		txtEmail.setFont(new Font("Rubik", Font.ITALIC, 12));
		txtEmail.setColumns(10);
		txtEmail.setBackground(new Color(153, 204, 255));
		txtEmail.setBounds(54, 335, 128, 20);
		panelLateral.add(txtEmail);
		
		txtContrasenia = new JTextField();
		txtContrasenia.setToolTipText("");
		txtContrasenia.setText("Contraseña");
		txtContrasenia.setForeground(Color.BLACK);
		txtContrasenia.setFont(new Font("Rubik", Font.ITALIC, 12));
		txtContrasenia.setColumns(10);
		txtContrasenia.setBackground(new Color(153, 204, 255));
		txtContrasenia.setBounds(54, 366, 128, 20);
		panelLateral.add(txtContrasenia);
		
		txtCOnfContrasenia = new JTextField();
		txtCOnfContrasenia.setToolTipText("");
		txtCOnfContrasenia.setText("Conf. Contraseña");
		txtCOnfContrasenia.setForeground(Color.BLACK);
		txtCOnfContrasenia.setFont(new Font("Rubik", Font.ITALIC, 12));
		txtCOnfContrasenia.setColumns(10);
		txtCOnfContrasenia.setBackground(new Color(153, 204, 255));
		txtCOnfContrasenia.setBounds(54, 397, 128, 20);
		panelLateral.add(txtCOnfContrasenia);
		
		JList list = new JList();
		list.setBounds(0, 0, 1, 1);
		panelLateral.add(list);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txtContrasenia.getText().equals(txtCOnfContrasenia.getText())) {

					PersonaVO personaVO = new PersonaVO(
							txtDocumento.getText(), 
							txtApellido1.getText(), 
							txtApellido2.getText(), 
							txtNombre1.getText(), 
							txtNombre2.getText(), 
							txtFechaNac.getText(), 
							txtContrasenia.getText(), 
							txtEmail.getText(),
							null,
							0
					);
					if(personaBO.insert(personaVO)) {
						JOptionPane.showMessageDialog(null, "Usuario creado");
						
					} else {
						JOptionPane.showMessageDialog(null, "No se pudo crear el usuario");
						
					}
				}else {
					
					System.out.println("las contraseñas no coinciden");
				}
				
				frmRegister.dispatchEvent(new WindowEvent(frmRegister, WindowEvent.WINDOW_CLOSING));
			}
		});
		btnRegister.setForeground(new Color(0, 51, 51));
		btnRegister.setFont(new Font("Rubik", Font.PLAIN, 12));
		btnRegister.setBackground(new Color(153, 204, 255));
		btnRegister.setBounds(54, 427, 128, 23);
		panelLateral.add(btnRegister);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(FrmRegistro.class.getResource("/Images/registro.jpg")));
		lblNewLabel_1.setBounds(225, 0, 559, 461);
		frmRegister.getContentPane().add(lblNewLabel_1);
		
		
	}
}
