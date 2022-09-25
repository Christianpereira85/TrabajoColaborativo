package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;

import dao.FuncionalidadDAO;
import dao.FuncionalidadDAOImpl;
import dao.PersonaDAO;
import dao.PersonaDAOImpl;
import dto.PersonaBO;
import dto.PersonaVO;
import model.EnumRol;
import model.Persona;

import javax.swing.event.ListSelectionEvent;

public class UserPanel {

	private JFrame frame;
	private JTextField txtNombre1;
	private JTextField txtNombre2;
	private JTextField txtApellido1;
	private JTextField txtApellido2;
	private JTextField txtDocumento;
	private JTextField txtFechaNac;
	private JTextField txtEmail;
	private JTextField txtContrasenia;
	private JTextField txtConfContrasenia;
	private JTextField txtSearchUser;
	private JButton btnSave;
	private JButton btnUpdateUser;
	private JButton btnDeleteUser;
	private JButton btnChangeRol;
	private JButton btnMostrarUsuarios;
	JList<?> list_1;
	private boolean activate=false;
	PersonaBO personaBO= new PersonaBO();
	FuncionalidadDAO funcionalidad=new FuncionalidadDAOImpl();
	private JButton btnFind;
	private int idPersonaBuscada = 0;
	private EnumRol rolPersonaBuscada = EnumRol.OPERADOR;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserPanel window = new UserPanel();
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
	public UserPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		//for (int i =0; i<PersonaDAOImpl.personaJlist.size();i++) {
			//personasJlist[i]=PersonaDAOImpl.personaJlist.get(i).getId_persona()+" "+PersonaDAOImpl.personaJlist.get(i).getNombre1()+" "+PersonaDAOImpl.personaJlist.get(i).getApellido1();
			//System.out.println(personasJlist[i]);
		//}
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setResizable(false);
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panelLateral = new JPanel();
		panelLateral.setLayout(null);
		panelLateral.setBorder(null);
		panelLateral.setBackground(new Color(153, 204, 255));
		panelLateral.setBounds(0, 0, 228, 461);
		frame.getContentPane().add(panelLateral);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(UserPanel.class.getResource("/Images/logo chico.png")));
		lblNewLabel.setBounds(54, 11, 128, 128);
		panelLateral.add(lblNewLabel);
		
		JList list = new JList();
		list.setBounds(0, 0, 1, 1);
		panelLateral.add(list);
		
		//USER PANEL!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		//USER PANEL!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		//USER PANEL!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		
		
		//Ejecucion del Update del usuario.
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				activate=true;
				txtNombre1.setEnabled(activate);
				txtNombre2.setEnabled(activate);
				txtApellido1.setEnabled(activate);
				txtApellido2.setEnabled(activate);
				txtDocumento.setEnabled(activate);
				txtFechaNac.setEnabled(activate);
				txtEmail.setEnabled(activate);
				txtContrasenia.setEnabled(activate);
				txtConfContrasenia.setEnabled(activate);
				btnSave.setEnabled(activate);
				System.out.println(activate);
				
			}
		});
		btnUpdate.setForeground(new Color(0, 51, 51));
		btnUpdate.setFont(new Font("Rubik", Font.PLAIN, 12));
		btnUpdate.setBackground(new Color(153, 204, 255));
		btnUpdate.setBounds(54, 150, 128, 23);
		panelLateral.add(btnUpdate);
		
		
		
		
		
		//EJECUCION DEL DELETE
		
		
		JButton btnDelete = new JButton("Delete My Account");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonaVO personaVO = new PersonaVO(null,null,null,null,null,null,null,null,null,PersonaDAOImpl.id_login);
				if(personaBO.delete(personaVO)) {
					JOptionPane.showMessageDialog(null, "Se ha borrado con exito el usuario");
				} else {
					JOptionPane.showMessageDialog(null, "Se ha borrado con exito el usuario");
				}
			}
		});
		btnDelete.setForeground(new Color(0, 51, 51));
		btnDelete.setFont(new Font("Rubik", Font.PLAIN, 11));
		btnDelete.setBackground(new Color(204, 51, 0));
		btnDelete.setBounds(54, 184, 128, 23);
		panelLateral.add(btnDelete);
		
		JLabel lblNewLabel_1 = new JLabel("Admin actions");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(102, 102, 153));
		lblNewLabel_1.setFont(new Font("Rubik", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(54, 245, 128, 14);
		panelLateral.add(lblNewLabel_1);
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 255));
		panel.setBounds(238, 11, 536, 439);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(251, 70, 40, 300);
		lblNewLabel_2.setIcon(new ImageIcon(UserPanel.class.getResource("/Images/barra.png")));
		panel.add(lblNewLabel_2);
		
		JLabel lblUserPanel = new JLabel("User Panel");
		lblUserPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserPanel.setFont(new Font("Rubik", Font.PLAIN, 16));
		lblUserPanel.setBounds(84, 11, 101, 14);
		panel.add(lblUserPanel);
		
		JLabel lblAdminPanel = new JLabel("AdminPanel");
		lblAdminPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminPanel.setFont(new Font("Rubik", Font.PLAIN, 16));
		lblAdminPanel.setBounds(355, 11, 101, 14);
		panel.add(lblAdminPanel);
		
		txtNombre1 = new JTextField();
		txtNombre1.setEnabled(activate);
		txtNombre1.setToolTipText("");
		txtNombre1.setText("Primer Nombre");
		txtNombre1.setForeground(Color.BLACK);
		txtNombre1.setFont(new Font("Rubik", Font.ITALIC, 12));
		txtNombre1.setColumns(10);
		txtNombre1.setBackground(new Color(153, 204, 255));
		txtNombre1.setBounds(84, 70, 128, 20);
		panel.add(txtNombre1);
		
		txtNombre2 = new JTextField();
		txtNombre2.setEnabled(activate);
		txtNombre2.setToolTipText("");
		txtNombre2.setText("SegundoNombre");
		txtNombre2.setForeground(Color.BLACK);
		txtNombre2.setFont(new Font("Rubik", Font.ITALIC, 12));
		txtNombre2.setColumns(10);
		txtNombre2.setBackground(new Color(153, 204, 255));
		txtNombre2.setBounds(84, 101, 128, 20);
		panel.add(txtNombre2);
		
		txtApellido1 = new JTextField();
		txtApellido1.setEnabled(activate);
		txtApellido1.setToolTipText("");
		txtApellido1.setText("Primer Apellido");
		txtApellido1.setForeground(Color.BLACK);
		txtApellido1.setFont(new Font("Rubik", Font.ITALIC, 12));
		txtApellido1.setColumns(10);
		txtApellido1.setBackground(new Color(153, 204, 255));
		txtApellido1.setBounds(84, 132, 128, 20);
		panel.add(txtApellido1);
		
		txtApellido2 = new JTextField();
		txtApellido2.setEnabled(activate);
		txtApellido2.setToolTipText("");
		txtApellido2.setText("Segundo Apellido");
		txtApellido2.setForeground(Color.BLACK);
		txtApellido2.setFont(new Font("Rubik", Font.ITALIC, 12));
		txtApellido2.setColumns(10);
		txtApellido2.setBackground(new Color(153, 204, 255));
		txtApellido2.setBounds(84, 163, 128, 20);
		panel.add(txtApellido2);
		
		txtDocumento = new JTextField();
		txtDocumento.setEnabled(activate);
		txtDocumento.setToolTipText("");
		txtDocumento.setText("C.I.");
		txtDocumento.setForeground(Color.BLACK);
		txtDocumento.setFont(new Font("Rubik", Font.ITALIC, 12));
		txtDocumento.setColumns(10);
		txtDocumento.setBackground(new Color(153, 204, 255));
		txtDocumento.setBounds(84, 193, 128, 20);
		panel.add(txtDocumento);
		
		txtFechaNac = new JTextField();
		txtFechaNac.setEnabled(activate);
		txtFechaNac.setToolTipText("");
		txtFechaNac.setText("dd/mm/aaaa");
		txtFechaNac.setForeground(Color.BLACK);
		txtFechaNac.setFont(new Font("Rubik", Font.ITALIC, 12));
		txtFechaNac.setColumns(10);
		txtFechaNac.setBackground(new Color(153, 204, 255));
		txtFechaNac.setBounds(84, 224, 128, 20);
		panel.add(txtFechaNac);
		
		txtEmail = new JTextField();
		txtEmail.setEnabled(activate);
		txtEmail.setToolTipText("");
		txtEmail.setText("Email");
		txtEmail.setForeground(Color.BLACK);
		txtEmail.setFont(new Font("Rubik", Font.ITALIC, 12));
		txtEmail.setColumns(10);
		txtEmail.setBackground(new Color(153, 204, 255));
		txtEmail.setBounds(84, 255, 128, 20);
		panel.add(txtEmail);
		
		txtContrasenia = new JTextField();
		txtContrasenia.setEnabled(activate);
		txtContrasenia.setToolTipText("");
		txtContrasenia.setText("Contraseña");
		txtContrasenia.setForeground(Color.BLACK);
		txtContrasenia.setFont(new Font("Rubik", Font.ITALIC, 12));
		txtContrasenia.setColumns(10);
		txtContrasenia.setBackground(new Color(153, 204, 255));
		txtContrasenia.setBounds(84, 286, 128, 20);
		panel.add(txtContrasenia);
		
		txtConfContrasenia = new JTextField();
		txtConfContrasenia.setEnabled(activate);
		txtConfContrasenia.setToolTipText("");
		txtConfContrasenia.setText("Conf. Contraseña");
		txtConfContrasenia.setForeground(Color.BLACK);
		txtConfContrasenia.setFont(new Font("Rubik", Font.ITALIC, 12));
		txtConfContrasenia.setColumns(10);
		txtConfContrasenia.setBackground(new Color(153, 204, 255));
		txtConfContrasenia.setBounds(84, 317, 128, 20);
		panel.add(txtConfContrasenia);
		
		
		//Guardado del update
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonaVO personaVO = new PersonaVO();
				
				personaVO.setApellido1(txtApellido1.getText());
				personaVO.setApellido2(txtApellido2.getText());
				personaVO.setNombre1(txtNombre1.getText());
				personaVO.setNombre2(txtNombre2.getText());
				personaVO.setDocumento(txtDocumento.getText());
				personaVO.setFechaNac(txtFechaNac.getText());
				personaVO.setClave(txtContrasenia.getText());
				personaVO.setMail(txtEmail.getText());
				
				if (idPersonaBuscada != 0) {
					System.out.println(idPersonaBuscada);
					personaVO.setRol(rolPersonaBuscada);
					personaVO.setId_persona(idPersonaBuscada);
					
				}else {
					personaVO.setId_persona(PersonaDAOImpl.id_login);
				}

				if(personaBO.update(personaVO)) {
					JOptionPane.showMessageDialog(null, "Cambios guardados");
					
				} else {
					JOptionPane.showMessageDialog(null, "No pudimos guardar los cambios");
				}
				
				
			}
		});
		btnSave.setEnabled(activate);
		btnSave.setForeground(new Color(0, 51, 51));
		btnSave.setFont(new Font("Rubik", Font.PLAIN, 12));
		btnSave.setBackground(new Color(153, 204, 255));
		btnSave.setBounds(84, 348, 128, 23);
		panel.add(btnSave);
		
		
		//ADMIN PANEL!!!!!!!!!!!!!!!!!!!
		
		btnUpdateUser = new JButton("Update User");
		btnUpdateUser.setEnabled(funcionalidad.activatePanel(PersonaDAOImpl.rol));
		btnUpdateUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!activate) {
					activate=true;
					txtNombre1.setEnabled(activate);
					txtNombre2.setEnabled(activate);
					txtApellido1.setEnabled(activate);
					txtApellido2.setEnabled(activate);
					txtDocumento.setEnabled(activate);
					txtFechaNac.setEnabled(activate);
					txtEmail.setEnabled(activate);
					txtContrasenia.setEnabled(activate);
					txtConfContrasenia.setEnabled(activate);
					btnSave.setEnabled(activate);
				}
				
			}
		});
		btnUpdateUser.setForeground(new Color(0, 51, 51));
		btnUpdateUser.setFont(new Font("Rubik", Font.PLAIN, 12));
		btnUpdateUser.setBackground(new Color(153, 204, 255));
		btnUpdateUser.setBounds(54, 270, 128, 23);
		panelLateral.add(btnUpdateUser);
		
		btnDeleteUser = new JButton("Delete User");
		btnDeleteUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnDeleteUser.setEnabled(funcionalidad.activatePanel(PersonaDAOImpl.rol));
		btnDeleteUser.setForeground(new Color(0, 51, 51));
		btnDeleteUser.setFont(new Font("Rubik", Font.PLAIN, 12));
		btnDeleteUser.setBackground(new Color(204, 51, 51));
		btnDeleteUser.setBounds(54, 304, 128, 23);
		panelLateral.add(btnDeleteUser);
		
		btnChangeRol = new JButton("Modify User Rol");
		btnChangeRol.setEnabled(funcionalidad.activatePanel(PersonaDAOImpl.rol));
		btnChangeRol.setForeground(new Color(0, 51, 51));
		btnChangeRol.setFont(new Font("Rubik", Font.PLAIN, 12));
		btnChangeRol.setBackground(new Color(153, 204, 255));
		btnChangeRol.setBounds(54, 338, 128, 23);
		panelLateral.add(btnChangeRol);
		
		btnChangeRol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnumRol[] roles = EnumRol.values(); 
				JComboBox jcd = new JComboBox(roles);

		        jcd.setEditable(true);

		        //create a JOptionPane
		        Object[] options = new Object[] {};
		        JOptionPane jop = new JOptionPane("Please Select the new role",
                    JOptionPane.QUESTION_MESSAGE,
                    JOptionPane.DEFAULT_OPTION,
                    null,options, null);

		        //add combos to JOptionPane
		        jop.add(jcd);
                    
		        JDialog diag = new JDialog();
                JButton jButtonUpdateRole = new JButton("Aceptar");
                jButtonUpdateRole.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						diag.setVisible(false);
						PersonaVO personaVO = new PersonaVO();
						personaVO.setApellido1(txtApellido1.getText());
						personaVO.setApellido2(txtApellido2.getText());
						personaVO.setNombre1(txtNombre1.getText());
						personaVO.setNombre2(txtNombre2.getText());
						personaVO.setDocumento(txtDocumento.getText());
						personaVO.setFechaNac(txtFechaNac.getText());
						personaVO.setClave(txtContrasenia.getText());
						personaVO.setMail(txtEmail.getText());
						personaVO.setId_persona(idPersonaBuscada);
						
						for (EnumRol rol: EnumRol.values()) {
							if (rol.name().equals(jcd.getSelectedItem().toString())) {
								personaVO.setRol(rol);
							}
						}
						
						if (personaBO.update(personaVO)) {
							JOptionPane.showMessageDialog(null, "Usuario actualizado correctamente");
						} else {
							JOptionPane.showMessageDialog(null, "No se pudo actualizar el rol");
						}
					}
                });
                jop.add(jButtonUpdateRole);
		        
		        
		        diag.getContentPane().add(jop);
		        diag.pack();
		        diag.setVisible(true);
			}
		});
		
		btnMostrarUsuarios = new JButton("Show users");
		btnMostrarUsuarios.setForeground(new Color(0, 51, 51));
		btnMostrarUsuarios.setFont(new Font("Rubik", Font.PLAIN, 12));
		btnMostrarUsuarios.setBounds(54, 374, 128, 23);
		panelLateral.add(btnMostrarUsuarios);
		btnMostrarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TablaPersonas showAll = new TablaPersonas();
				showAll.mostrar();
			}
		});
		
		
		txtSearchUser = new JTextField();
		txtSearchUser.setEnabled(funcionalidad.activatePanel(PersonaDAOImpl.rol));
		txtSearchUser.setHorizontalAlignment(SwingConstants.CENTER);
		txtSearchUser.setToolTipText("");
		txtSearchUser.setText("Search by document");
		txtSearchUser.setForeground(Color.BLACK);
		txtSearchUser.setFont(new Font("Rubik", Font.ITALIC, 12));
		txtSearchUser.setColumns(10);
		txtSearchUser.setBackground(new Color(153, 204, 255));
		txtSearchUser.setBounds(301, 71, 209, 20);
		panel.add(txtSearchUser);
		
		btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {	
				String input= txtSearchUser.getText();
				
				PersonaVO personaVO = new PersonaVO();
				
				Persona persona = personaBO.findPersona(input);
				System.out.println(persona);
			
				txtNombre1.setText(persona.getNombre1());
				txtNombre2.setText(persona.getNombre2());
				txtApellido1.setText(persona.getApellido1());
				txtApellido2.setText(persona.getApellido2());
				txtDocumento.setText(persona.getDocumento());
				txtContrasenia.setText(persona.getClave());
				txtFechaNac.setText(persona.getFechaNac());
				txtEmail.setText(persona.getMail());
				txtConfContrasenia.setText("");
				idPersonaBuscada = persona.getId_persona();
				rolPersonaBuscada = persona.getRol();
				
			}
			
		});
		
		btnFind.setForeground(new Color(0, 51, 51));
		btnFind.setFont(new Font("Rubik", Font.PLAIN, 12));
		btnFind.setEnabled(funcionalidad.activatePanel(PersonaDAOImpl.rol));
		btnFind.setBackground(new Color(153, 204, 255));
		btnFind.setBounds(342, 101, 128, 23);
		panel.add(btnFind);
		
	}
}
