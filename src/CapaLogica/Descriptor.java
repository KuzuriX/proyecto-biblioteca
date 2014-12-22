package CapaLogica;

public class Descriptor {
	private String codigo;
	private String descripcion;
	
	/**
	 * Constructor de Descriptor
	 * @param pcodigo		Codigo del descriptor.
	 * @param pdescripcion	Descripcion.
	 */
	public Descriptor(String pcodigo, String pdescripcion){
		setCodigo(pcodigo);
		setDescripcion(pdescripcion);
	}

	/**
	 * getCodigo
	 * @return String codigo del descriptor.
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * setCodigo
	 * @param codigo codigo del descriptor del libro.
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * getDescripcion
	 * @return String Descripcion del descriptor del libro.
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * setDescripcion
	 * @param descripcion del descriptor del libro.
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Descriptor [codigo=" + codigo + ", descripcion=" + descripcion
				+ "]";
	}
}
