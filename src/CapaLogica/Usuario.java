package CapaLogica;

public class Usuario {
	private String id;
	private String nombre;
	private String apellido;
	private String dirElectronica;
	private String direccion;
	private String telefono;
	private String estado;
	
	/**
	 * Constructor de Usuario
	 * @param pid				Identificacion del usuario.
	 * @param pnombre			Nombre del usuario.
	 * @param papellido			Apellido del usuario.
	 * @param pdirElectronica	Direccion electronica del usuario.
	 * @param pdireccion		Direccion fisica del usuario.
	 * @param ptelefono			Telefono del usuario.
	 * @param pestado			Estado del usuario. Puede ser "normal" o "moroso".
	 */
	public Usuario(String pid, String pnombre, String papellido,
			String pdirElectronica, String pdireccion, String ptelefono,
			String pestado) {
		setId(pid);
		setNombre(pnombre);
		setApellido(papellido);
		setDirElectronica(pdirElectronica);
		setDireccion(pdireccion);
		setTelefono(ptelefono);
		setEstado(pestado);
	}
	
	/**
	 * getId
	 * @return String identificacion del usuario.
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * setId 
	 * @param id identificacion del usuario.
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * getNombre
	 * @return String nombre del usuario.
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * setNombre
	 * @param nombre nombre del usuario.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * getApellido
	 * @return String apellido del usuario.
	 */
	public String getApellido() {
		return apellido;
	}
	
	/**
	 * setApellido
	 * @param apellido apellido del usuario.
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	/**
	 * getDirElectronica
	 * @return String direccion electronica del usuario.
	 */
	public String getDirElectronica() {
		return dirElectronica;
	}
	
	/**
	 * setDirElectronica
	 * @param dirElectronica direccion electronica del usuario.
	 */
	public void setDirElectronica(String dirElectronica) {
		this.dirElectronica = dirElectronica;
	}
	
	/**
	 * getDireccion
	 * @return String direccion fisica del usuario.
	 */
	public String getDireccion() {
		return direccion;
	}
	
	/**
	 * setDireccion
	 * @param direccion direccion fisica del usuario.
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	/**
	 * getTelefono
	 * @return String telefono del usuario.
	 */
	public String getTelefono() {
		return telefono;
	}
	
	/**
	 * setTelefono
	 * @param telefono numero telefonico del usuario.
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	/**
	 * getEstado
	 * @return 	String estado del usuario.
	 * 			Posible valores: "normal" o "moroso".
	 */
	public String getEstado() {
		return estado;
	}
	
	/**
	 * setEstado
	 * @param estado estado del usuario
	 * 				 Posible valores: "normal" o "moroso".
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido="
				+ apellido + ", dirElectronica=" + dirElectronica
				+ ", direccion=" + direccion + ", telefono=" + telefono
				+ ", estado=" + estado + "]";
	}
}
