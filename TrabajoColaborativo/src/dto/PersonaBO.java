package dto;

import java.sql.SQLException;
import java.util.LinkedList;

import dao.PersonaDAO;
import dao.PersonaDAOImpl;
import model.Persona;

public class PersonaBO {
	
	private PersonaDAO personaDAO = new PersonaDAOImpl();
	public PersonaBO() {}
	
	public boolean insert(PersonaVO personaVO) {
		
		boolean result = false;
		try {
			Persona persona = getPersonaFromVO(personaVO);
			
			result = personaDAO.insert(persona);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return result;
	}

	public boolean update(PersonaVO personaVO) {
		
		boolean result = false;
		try {
			
			Persona persona = getPersonaFromVO(personaVO);
			result = personaDAO.update(persona);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return result;

	}

	public boolean delete(PersonaVO personaVO) {
		
		boolean result = false;
		try {
			
			Persona persona = getPersonaFromVO(personaVO);
			
			result = personaDAO.delete(persona);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		return result;
	}

	public LinkedList<Persona> findAll() {
		LinkedList<Persona> listaPersonas = new LinkedList<Persona>();
		
		try {
			listaPersonas = personaDAO.findAll();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return listaPersonas;

	}

	public boolean Login(String Email, String Contrasenia) {
		boolean result = false;
		try {
			result = personaDAO.Login(Email, Contrasenia);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public Persona findPersona(String Documento) {
		Persona persona = new Persona();
		
		try {
			persona.setDocumento(Documento);
			persona = personaDAO.findPersona(persona);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return persona;

	}
	
	private Persona getPersonaFromVO(PersonaVO personaVO) {
		return new Persona(
				personaVO.getDocumento(),
				personaVO.getApellido1(),
				personaVO.getApellido2(),
				personaVO.getNombre1(),
				personaVO.getNombre2(),
				personaVO.getFechaNac(),
				personaVO.getClave(),
				personaVO.getMail(),
				personaVO.getRol(),
				personaVO.getId_persona()
		);
	}
}
