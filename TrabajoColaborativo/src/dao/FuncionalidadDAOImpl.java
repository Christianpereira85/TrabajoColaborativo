package dao;

import model.EnumRol;

public class FuncionalidadDAOImpl implements FuncionalidadDAO {

	public boolean activatePanel(EnumRol rol) {
//		PersonaDAO persona = new PersonaDAOImpl();
		
		switch (rol.name()) {
			case "ADMIN":
				return true;
			default:
				return false;
		}

	}


}
