package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.EnumRol;
import model.Persona;

import utils.StringUtils;

public class PersonaDAOImpl implements PersonaDAO {


	private static final String ALL_PERSONAS = "SELECT * FROM PERSONA";
	private static final String FIND_MAX_ID = "SELECT MAX(ID_PERSONA) AS MAX_ID FROM PERSONA";
	private static final String INSERT_PERSONA = "INSERT INTO PERSONA (ID_PERSONA,DOCUMENTO, APELLIDO1, APELLIDO2, NOMBRE1, NOMBRE2, FECHA_NAC, CLAVE, ROL, MAIL) VALUES  (?,?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE_PERSONA = "UPDATE PERSONA SET APELLIDO1=?, APELLIDO2=?, NOMBRE1=?, NOMBRE2=?, FECHA_NAC=?, CLAVE=?, ROL=?, MAIL=? WHERE ID_PERSONA=?";
	private static final String DELETE_PERSONA = "DELETE FROM PERSONA WHERE ID_PERSONA=?";
	private static final String BUSCAR_PERSONA = "SELECT * FROM PERSONA WHERE DOCUMENTO=?";
	private static final String BUSCAR_PERSONA_BY_EMAIL = "SELECT * FROM PERSONA WHERE MAIL=?";
	public static LinkedList<Persona> personaArray = new LinkedList<Persona>();
	public static List<String> personaJlist = new ArrayList<String>();
	public static int id_login;
	public static EnumRol rol = EnumRol.OPERADOR;

	public int findMaxId() {
		int result = 0;
		try {
			PreparedStatement statement = model.DatabaseManager.getConnection()
					.prepareStatement(FIND_MAX_ID);
			ResultSet rSet = statement.executeQuery();
			
			while (rSet.next()) {
				result =rSet.getInt("MAX_ID");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(result);
		
		return result;
	}
	
	public boolean insert(Persona persona) throws SQLException {

		PreparedStatement statement = model.DatabaseManager.getConnection()
				.prepareStatement(INSERT_PERSONA);
		
		int id_persona = findMaxId() + 1;
		statement.setLong(1, id_persona);
		statement.setString(5, persona.getNombre1());
		statement.setString(6, persona.getNombre2());
		statement.setString(3, persona.getApellido1());
		statement.setString(4, persona.getApellido2());
		statement.setString(2, persona.getDocumento());
		statement.setString(7, persona.getFechaNac());
		statement.setString(8, persona.getClave());
		statement.setString(10, persona.getMail());
		
		// ** Seteamos el rol por defecto
		statement.setString(9, EnumRol.OPERADOR.name());

		int Retorno = statement.executeUpdate();

		return Retorno > 0;
	}

	public boolean update(Persona persona) throws SQLException {
		PreparedStatement statement = model.DatabaseManager.getConnection().prepareStatement(UPDATE_PERSONA);

		statement.setString(1, persona.getApellido1());
		statement.setString(2, persona.getApellido2());
		statement.setString(3, persona.getNombre1());
		statement.setString(4, persona.getNombre2());
		statement.setString(5, persona.getFechaNac());
		statement.setString(6, persona.getClave());
		statement.setString(7, persona.getRol().name());
		statement.setString(8, persona.getMail());
		statement.setLong(9, persona.getId_persona());
		
		int result = statement.executeUpdate();

		return result > 0;

	}

	public boolean delete(Persona persona) throws SQLException {
		int result = 0;
		PreparedStatement statement = model.DatabaseManager.getConnection()
				.prepareStatement(DELETE_PERSONA);
		
		statement.setLong(1, persona.getId_persona());
		
		result = statement.executeUpdate();

		return result > 0;
	}

	public LinkedList<Persona> findAll() {
		LinkedList<Persona> personaArray = new LinkedList<Persona>();

		PreparedStatement statement;
		try {
			statement = model.DatabaseManager.getConnection().prepareStatement(ALL_PERSONAS);

			ResultSet statementRS = statement.executeQuery();
			personaArray = rSetToLinkedList(statementRS);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return personaArray;

	}

	public boolean Login(String Email, String Contrasenia) throws SQLException {

		boolean login = false;
		Persona persona = findPersonaByEmail(Email);
		if (persona!=null) {
			login = persona.getClave().equals(Contrasenia);			
		} else {
			return false;
		}

		id_login = persona.getId_persona();
		rol = persona.getRol();
		
		return login;
	}
	
	public Persona findPersonaByEmail(String email) throws SQLException {
		Persona persona = new Persona(null, null, null, null, null, null, null, null, null, 0);
		try {
			PreparedStatement statement = model.DatabaseManager.getConnection()
					.prepareStatement(BUSCAR_PERSONA_BY_EMAIL);
			statement.setString(1, email);
			
			ResultSet rSet = statement.executeQuery();
			
			while (rSet.next()) {
				persona.setApellido1(rSet.getString("APELLIDO1"));
				persona.setApellido2(rSet.getString("APELLIDO2"));
				persona.setNombre1(rSet.getString("NOMBRE1"));
				persona.setNombre2(rSet.getString("NOMBRE2"));
				persona.setDocumento(rSet.getString("DOCUMENTO"));
				persona.setId_persona(rSet.getInt("ID_PERSONA"));
				persona.setFechaNac(rSet.getString("FECHA_NAC"));
				persona.setRol(getEnumRoleFromName(rSet.getString("ROL")));
				persona.setClave(rSet.getString("CLAVE"));
				persona.setMail(rSet.getString("MAIL"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(persona);
		
		return persona;
	}

	public Persona findPersona(Persona persona) throws SQLException {

		PreparedStatement statement = model.DatabaseManager.getConnection().prepareStatement(BUSCAR_PERSONA);
		statement.setString(1, persona.getDocumento());
		ResultSet statementRS = statement.executeQuery();

		statementRS.next();

		if (statementRS.getString("documento").equals(persona.getDocumento())) {
			persona.setApellido1(statementRS.getString("apellido1"));
			persona.setApellido2(statementRS.getString("apellido2"));
			persona.setNombre1(statementRS.getString("nombre1"));
			persona.setNombre2(statementRS.getString("nombre2"));
			String fechaNacimientoSQL = statementRS.getString("Fecha_nac");
			persona.setFechaNac(parseFecha(fechaNacimientoSQL));
			persona.setClave(statementRS.getString("clave"));
			persona.setMail(statementRS.getString("mail"));
			persona.setRol(getEnumRoleFromName(statementRS.getString("rol")));
			persona.setId_persona(Integer.valueOf(statementRS.getString("id_persona")));
			
			personaJlist.add(statementRS.getString("id_persona") +" "+statementRS.getString("documento") + " " + statementRS.getString("Apellido1"));
		}

		return persona;

	}
	
	public LinkedList<Persona> rSetToLinkedList(ResultSet statementRS) {
		LinkedList<Persona> listaPersonas = new LinkedList<Persona>();
		try {
			
			while (statementRS.next()) {
				Persona persona = new Persona(null, null, null, null, null, null, null, null, null, 0);
				
				persona.setDocumento(statementRS.getString("documento"));
				persona.setApellido1(statementRS.getString("apellido1"));
				persona.setApellido2(statementRS.getString("apellido2"));
				persona.setNombre1(statementRS.getString("nombre1"));
				persona.setNombre2(statementRS.getString("nombre2"));
				persona.setFechaNac(statementRS.getString("Fecha_nac"));
				persona.setClave(statementRS.getString("clave"));
				persona.setMail(statementRS.getString("mail"));
				persona.setRol(getEnumRoleFromName(statementRS.getString("rol")));
				persona.setId_persona(Integer.valueOf(statementRS.getString("id_persona")));
				
				listaPersonas.add(persona);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaPersonas;
	}
	
	public String parseFecha(String fechaVieja) {
		if (!fechaVieja.isEmpty() && fechaVieja != null) {
			String fechaNacimiento = fechaVieja.split(" ")[0];
			String[] stringArrayFechNac = fechaNacimiento.split("-");
			String[] reversedString = StringUtils.reverseArray(stringArrayFechNac);
			
			String fechaFinal = reversedString[0]+"/"+reversedString[1] + "/" +reversedString[2];
			
			return fechaFinal;
		} else {
			return "dd/mm/aaaa";
		}
	}
	
	public EnumRol getEnumRoleFromName(String name) {
		EnumRol foundRol = null;
		System.out.println("Nombre rol: " + name);
		for (EnumRol rol: EnumRol.values()) {
			System.out.println("For rol name: " + rol.name());
			if (rol.name().equals(name)) {
				foundRol = rol;
			}
		}
		return foundRol != null ? foundRol : EnumRol.OPERADOR;
	}

}
