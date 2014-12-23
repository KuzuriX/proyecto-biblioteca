package CapaLogica;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Vector;

public class Ejemplar {
	private String codigo;
	private String estadoFisico; // 0: Excelente, 1: Bueno, 2: Malo
	private LocalDate fechaIngreso;
	private String condicionActual; // 0: Libre, 1: Prestado, 2: Reservado, 3: Reparacion, 4: Fuera de uso, 5: Perdido
	// Atributos de relaciones
	private Libro libro;
	// Persistencia
	private String idLibro;
	
	public Ejemplar(String pidLibro, String pcodigo, String pestadoFisico, LocalDate pfechaIngreso, 
			String pcondicionActual) {
		setIdLibro(pidLibro);
		setCodigo(pcodigo);
		setEstadoFisico(pestadoFisico);
		setFechaIngreso(pfechaIngreso);
		setCondicionActual(pcondicionActual);
		
		libro = null;
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
	public String getEstadoFisico() {
		return estadoFisico;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstadoFisico(String estado) {
		this.estadoFisico = estado;
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
	public String obtenerISBN() {
		return idLibro;
	}

	/**
	 * @param idLibro the idLibro to set
	 */
	public void setIdLibro(String idLibro) {
		this.idLibro = idLibro;
	}
	
	public Libro obtenerLibro() throws SQLException, Exception {
		libro = new MultiLibro().buscar(obtenerISBN());
		return libro;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Ejemplar [codigo=" + codigo + ", estadoFisico=" + estadoFisico
				+ ", fechaIngreso=" + fechaIngreso + ", condicionActual="
				+ condicionActual + ", idLibro=" + idLibro
				+ "]";
	}
}
