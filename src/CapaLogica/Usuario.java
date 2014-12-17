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
	 * @param id
	 * @param nombre
	 * @param apellido
	 * @param dirElectronica
	 * @param direccion
	 * @param telefono
	 * @param estado
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
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}
	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	/**
	 * @return the dirElectronica
	 */
	public String getDirElectronica() {
		return dirElectronica;
	}
	/**
	 * @param dirElectronica the dirElectronica to set
	 */
	public void setDirElectronica(String dirElectronica) {
		this.dirElectronica = dirElectronica;
	}
	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}
	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
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
