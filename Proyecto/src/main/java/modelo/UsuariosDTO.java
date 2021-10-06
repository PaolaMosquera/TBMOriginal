package modelo;

public class UsuariosDTO {
	private long cedulausuario ;
	private String emailusuario;
	private String nombreusuario;
	private String password;
	private String usuario;
	
	public UsuariosDTO(long cedulausuario, String emailusuario, String nombreusuario, String password, String usuario) {
		this.cedulausuario = cedulausuario;
		this.emailusuario = emailusuario;
		this.nombreusuario = nombreusuario;
		this.password = password;
		this.usuario = usuario;
	}

	public UsuariosDTO(long cedulausuario) {
		this.cedulausuario = cedulausuario;
	}

	public long getCedulausuario() {
		return cedulausuario;
	}

	public void setCedulausuario(long cedulausuario) {
		this.cedulausuario = cedulausuario;
	}

	public String getEmailusuario() {
		return emailusuario;
	}

	public void setEmailusuario(String emailusuario) {
		this.emailusuario = emailusuario;
	}

	public String getNombreusuario() {
		return nombreusuario;
	}

	public void setNombreusuario(String nombreusuario) {
		this.nombreusuario = nombreusuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	

}
