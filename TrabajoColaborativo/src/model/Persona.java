package model;

public class Persona {

	private String documento;
	private String apellido1;
	private String apellido2;
	private String nombre1;
	private String nombre2;
	private String fechaNac;
	private String clave;
	private String mail;
	private EnumRol rol;
	private int id_persona;
	
	public Persona() {}
	
	public Persona(String documento, String apellido1, String apellido2, String nombre1, String nombre2,
			String fechaNac, String clave, String mail,EnumRol rol,int id_persona) {
		super();
		this.documento = documento;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.nombre1 = nombre1;
		this.nombre2 = nombre2;
		this.fechaNac = fechaNac;
		this.clave = clave;
		this.mail = mail;
		this.rol=rol;
		this.id_persona=id_persona;
	}

	public EnumRol getRol() {
		return rol;
	}

	public void setRol(EnumRol rol) {
		this.rol = rol;
	}

	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getNombre1() {
		return nombre1;
	}
	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}
	public String getNombre2() {
		return nombre2;
	}
	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}
	public String getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(String string) {
		this.fechaNac = string;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getId_persona() {
		return id_persona;
	}

	public void setId_persona(int id_persona) {
		this.id_persona = id_persona;
	}

	@Override
	public String toString() {
		return "Persona [documento=" + documento + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
				+ ", nombre1=" + nombre1 + ", nombre2=" + nombre2 + ", fechaNac=" + fechaNac + ", clave=" + clave
				+ ", mail=" + mail + ", rol=" + rol + ", id_persona=" + id_persona + "]";
	}

}
