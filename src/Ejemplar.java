import java.time.LocalDate;


public class Ejemplar {
	private String codigo;
	private String estado;
	private LocalDate fechaIngreso;
	private String condicionActual;
	private Libro libro;
	private int idLibro;
	
	public Ejemplar(){
		
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

	/**
	 * @return the fechaIngreso
	 */
	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	/**
	 * @param fechaIngreso the fechaIngreso to set
	 */
	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	/**
	 * @return the condicionActual
	 */
	public String getCondicionActual() {
		return condicionActual;
	}

	/**
	 * @param condicionActual the condicionActual to set
	 */
	public void setCondicionActual(String condicionActual) {
		this.condicionActual = condicionActual;
	}

	/**
	 * @return the idLibro
	 */
	public int getIdLibro() {
		return idLibro;
	}

	/**
	 * @param idLibro the idLibro to set
	 */
	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}
	
	

}
