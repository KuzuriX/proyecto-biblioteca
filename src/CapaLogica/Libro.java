package CapaLogica;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Vector;

/**
 * @author miguel
 *
 */
public class Libro {
	private String ISBN;
	private String titulo;
	private int volumen;
	private String editorial;
	private LocalDate fechaPublicacion;
	private int numEjemplares;
	private String tipo; // Reserva o prestamo
	
	// Atributos de relaciones
	private Vector<Autor> listaAutores;
	private Vector<Descriptor> listaDescriptores;
	private Vector<Ejemplar> listaEjemplares;
	
	// Persistencia
	private Vector<String> idsAutores;
	private Vector<String> idsDescriptores;
	private Vector<String> idsEjemplares;
	
	public Libro(String pisbn, String ptitulo, int pvolumen, String peditorial, LocalDate pfechaPublicacion, String ptipo){
		setISBN(pisbn);
		setTitulo(ptitulo);
		setVolumen(pvolumen);
		setEditorial(peditorial);
		setFechaPublicacion(pfechaPublicacion);
		setTipo(ptipo);
		
		listaAutores = null;
		listaDescriptores = null;
		listaEjemplares = null;
		
		// Persistencia
		idsAutores = null;
		idsDescriptores = null;
		idsEjemplares = null;
	}
	
	/**
	 * @param iSBN
	 */
	private void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	
	/**
	 * @return
	 */
	public String getISBN() {
		return ISBN;
	}
	
	/**
	 * @param titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	/**
	 * @return
	 */
	public String getTitulo() {
		return titulo;
	}
	
	/**
	 * @param volumen
	 */
	public void setVolumen(int volumen) {
		this.volumen = volumen;
	}
	
	/**
	 * @return
	 */
	public int getVolumen() {
		return volumen;
	}
	
	/**
	 * @param editorial
	 */
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	
	/**
	 * @return
	 */
	public String getEditorial() {
		return editorial;
	}
	
	/**
	 * @param fechaPublicacion
	 */
	public void setFechaPublicacion(LocalDate fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}
	
	/**
	 * @return
	 */
	public LocalDate getFechaPublicacion() {
		return fechaPublicacion;
	}
	
	/**
	 * @param numEjemplares
	 */
	public void setNumEjemplares(int numEjemplares) {
		this.numEjemplares = numEjemplares;
	}
	
	/**
	 * @return
	 */
	public int getNumEjemplares() {
		return numEjemplares;
	}
	
	/**
	 * @param tipo
	 */
	public void establecerTipo(String tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * @return
	 */
	public String obtenerTipo() {
		return tipo;
	}
	
	public void asignarAutor(String pidAutor) {
		idsAutores.add(pidAutor);
	}
	
	public Vector<Autor> obtenerAutores() throws SQLException, Exception {
		for (int i = 0; i < idsAutores.size(); i++) {
			listaAutores.add((new MultiAutor()).buscar(idsAutores.get(i)));
		}
		
		return listaAutores;
	}
	
	public void asignarDescriptor(String pcodigo) {
		idsDescriptores.add(pcodigo);
	}
	
	public Vector<Descriptor> obtenerDescriptores() throws SQLException, Exception {
		for (int i = 0; i < idsDescriptores.size(); i++) {
			listaDescriptores.add((new MultiDescriptor()).buscar(idsDescriptores.get(i)));
		}
		
		return listaDescriptores;
	}
	
	public Vector<Ejemplar> obtenerEjemplares() {
		for (int i = 0; i < idsDescriptores.size(); i++) {
			listaEjemplares.add((new MultiEjemplar()).buscar(idsDescriptores.get(i)));
		}
		
		return listaEjemplares;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {	
		return "Libro [ISBN=" + ISBN + ", titulo=" + titulo + ", volumen="
				+ volumen + ", editorial=" + editorial + ", fechaPublicacion="
				+ fechaPublicacion + ", numEjemplares=" + numEjemplares
				+ ", tipo=" + tipo + ", listaAutores=" + listaAutores
				+ ", listaDescriptor=" + listaDescriptores + ", listaEjemplares="
				+ listaEjemplares + ", idsAutores=" + idsAutores
				+ ", idsDescriptores=" + idsDescriptores + "]";
	}
}
