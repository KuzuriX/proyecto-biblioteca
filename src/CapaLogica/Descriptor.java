package CapaLogica;

public class Descriptor {
	private String codigo;
	private String descripcion;
	
	public Descriptor(String pcodigo, String pdescripcion){
		setCodigo(pcodigo);
		setDescripcion(pdescripcion);
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
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
