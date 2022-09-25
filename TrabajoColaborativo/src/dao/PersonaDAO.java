package dao;

import java.sql.SQLException;
import java.util.LinkedList;

import model.Persona;

public interface PersonaDAO  {
	public boolean insert (Persona persona) throws SQLException;
	public boolean update (Persona persona) throws SQLException;
	public boolean delete (Persona persona) throws SQLException;
	public LinkedList<Persona> findAll() throws SQLException;
	public boolean Login(String Email,String Contrasenia) throws SQLException;
	public Persona findPersona(Persona persona) throws SQLException;
}
