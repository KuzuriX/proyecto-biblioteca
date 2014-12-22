package CapaLogica;

public class Autor {
	private String id;
	private String nombre;
	private String apellido;
	private String dirElectronica;
	private String nacionalidad;
	private String paisOrigen;
	
	/**
	 * Constructor de Autor.
	 * @param pid				Identificador del autor.
	 * @param pnombre			Nombre del autor.
	 * @param papellido			Apellido del autor.
	 * @param pdirElectronica	Direccion electronica del autor.
	 * @param pnacionalidad		Nacionalidad del autor.
	 * @param ppaisOrigen		Pais de origen del autor.
	 */
	public Autor(String pid, String pnombre, String papellido, String pdirElectronica, 
			String pnacionalidad, String ppaisOrigen) {
		setId(pid);
		setNombre(pnombre);
		setApellido(papellido);
		setDirElectronica(pdirElectronica);
		setNacionalidad(pnacionalidad);
		setPaisOrigen(ppaisOrigen);
	}
	
	/**
	 * getId
	 * @return String identificador del autor.
	 */
	public String getId() {
		return id;
	}

	/**
	 * setId
	 * @param id identificador del autor.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * getNombre
	 * @return String nombre del autor.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * setNombre
	 * @param nombre Nombre del autor.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * getApellido
	 * @return String apellido del autor.
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * setApellido
	 * @param apellido Apellido del autor.
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * getDirElectronica
	 * @return String direccion electronica del autor.
	 */
	public String getDirElectronica() {
		return dirElectronica;
	}

	/**
	 * setDirElectronica
	 * @param dirElectronica la direccion electronica del autor.
	 */
	public void setDirElectronica(String dirElectronica) {
		this.dirElectronica = dirElectronica;
	}

	/**
	 * getNacionalidad
	 * @return String nacionalidad del autor.
	 */
	public String getNacionalidad() {
		return nacionalidad;
	}

	/**
	 * setNacionalidad
	 * @param nacionalidad la nacionalidad del autor.
	 */
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	/**
	 * getPaisOrigen
	 * @return String pais de origen del autor.
	 */
	public String getPaisOrigen() {
		return paisOrigen;
	}

	/**
	 * setPaisOrigen
	 * @param paisOrigen pais de origen del autor.
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
