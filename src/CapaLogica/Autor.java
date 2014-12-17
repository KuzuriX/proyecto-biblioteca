package CapaLogica;

public class Autor {
	private String id;
	private String nombre;
	private String apellido;
	private String dirElectronica;
	private String nacionalidad;
	private String paisOrigen;
	
	public Autor(String pid, String pnombre, String papellido, String pdirElectronica, String pnacionalidad, String ppaisOrigen){
		setId(pid);
		setNombre(pnombre);
		setApellido(papellido);
		setDirElectronica(pdirElectronica);
		setNacionalidad(pnacionalidad);
		setPaisOrigen(ppaisOrigen);
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
	 * @return the nacionalidad
	 */
	public String getNacionalidad() {
		return nacionalidad;
	}

	/**
	 * @param nacionalidad the nacionalidad to set
	 */
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	/**
	 * @return the paisOrigen
	 */
	public String getPaisOrigen() {
		return paisOrigen;
	}

	/**
	 * @param paisOrigen the paisOrigen to set
	 */
	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Autor [id=" + id + ", nombre=" + nombre + ", apellido="
				+ apellido + ", dirElectronica=" + dirElectronica
				+ ", nacionalidad=" + nacionalidad + ", paisOrigen="
				+ paisOrigen + "]";
	}
	
	
	
	

}
