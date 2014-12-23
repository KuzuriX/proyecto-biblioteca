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
	private String tipo; // Reserva o prestamo
	// Persistencia
	private Vector<String> idsAutores;
	private Vector<String> idsDescriptores;
	private Vector<String> idsEjemplares;
	// Atributos de relaciones
	private Vector<Autor> listaAutores;
	private Vector<Descriptor> listaDescriptores;
	private Vector<Ejemplar> listaEjemplares;
	
	
	/**
	 * Constructor de Libro
	 * @param pisbn				ISBN
	 * @param ptitulo			Titulo del libro
	 * @param pvolumen			Volumen
	 * @param peditorial		Editorial
	 * @param pfechaPublicacion	Fecha de publicacion de libro
	 * @param ptipo				Tipo de libro, ya sea "Reserva" o "Prestamo"
	 */
	public Libro(String pisbn, String ptitulo, int pvolumen, String peditorial, 
			LocalDate pfechaPublicacion, String ptipo) {
		setISBN(pisbn);
		setTitulo(ptitulo);
		setVolumen(pvolumen);
		setEditorial(peditorial);
		setFechaPublicacion(pfechaPublicacion);
		setTipo(ptipo);
		
		listaAutores = new Vector();
		listaDescriptores = new Vector();
		listaEjemplares = new Vector();
		
		// Persistencia
		idsAutores = new Vector();
		idsDescriptores = new Vector();
		idsEjemplares = new Vector();
	}
	
	/**
	 * setISBN
	 * @param iSBN ISBN del libro.
	 */
	private void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	
	/**
	 * getISBN
	 * @return String ISBN del libro
	 */
	public String getISBN() {
		return ISBN;
	}
	
	/**
	 * setTitulo
	 * @param titulo Titulo del libro.
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
	 * getVolumen
	 * @return int volumen del libro
	 */
	public int getVolumen() {
		return volumen;
	}
	
	/**
	 * setEditorial
	 * @param editorial Editorial del libro
	 */
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	
	/**
	 * getEditorial
	 * @return String editorial del libro
	 */
	public String getEditorial() {
		return editorial;
	}
	
	/**
	 * setFechaPublicacion
	 * @param fechaPublicacion fecha de publicacion del libro.
	 */
	public void setFechaPublicacion(LocalDate fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}
	
	/**
	 * getFechaPublicacion
	 * @return LocalDate fecha en que se publico el libro
	 */
	public LocalDate getFechaPublicacion() {
		return fechaPublicacion;
	}
	
	/**
	 * setTipo
	 * @param tipo Tipo de libro "reserva" o "prestamo"
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * getTipo
	 * @return String Tipo de libro "reserva" o "prestamo"
	 */
	public String getTipo() {
		return tipo;
	}
	
	/**
	 * obtenerNumEjemplares
	 * @return int total de ejemplares que tiene el libro.
	 */
	public int obtenerNumEjemplares() {
		return idsEjemplares.size();
	}
	
	/**
	 * asignarAutor
	 * Asignarle un autor al libro
	 * @param pidAutor identificacion del autor.
	 */
	public void asignarAutor(String pidAutor) {
		idsAutores.add(pidAutor);
	}
	
	/**
	 * obtenerAutores
	 * Retorna una lista de objetos de tipo de Autor asociados al libro.
	 * @return Vector<Autor> Lista de autores
	 * @throws SQLException
	 * @throws Exception
	 */
	public Vector<Autor> obtenerAutores() throws SQLException, Exception {
		for (int i = 0; i < idsAutores.size(); i++) {
			listaAutores.add((new MultiAutor()).buscar(idsAutores.get(i)));
		}
		
		return listaAutores;
	}
	
	/**
	 * asignarDescriptor
	 * @param pcodigo Codigo del descriptor del libro
	 */
	public void asignarDescriptor(String pcodigo) {
		idsDescriptores.add(pcodigo);
	}
	
	/**
	 * obtenerDescriptores
	 * Retorna una lista de objetos de tipo de Descriptor asociados al libro.
	 * @return Vector<Descriptor> Lista de descriptores asociados al libro.
	 * @throws SQLException
	 * @throws Exception
	 */
	public Vector<Descriptor> obtenerDescriptores() throws SQLException, Exception {
		for (int i = 0; i < idsDescriptores.size(); i++) {
			listaDescriptores.add((new MultiDescriptor()).buscar(idsDescriptores.get(i)));
		}
		
		return listaDescriptores;
	}
	
	/**
	 * obtenerEjemplares
	 * Retorna una lista de objetos de tipo de Ejemplar asociados al libro.
	 * @return Vector<Ejemplar> Vector con objetos de tipo Ejemplar
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public Vector<Ejemplar> obtenerEjemplares() throws SQLException, Exception {
		for (int i = 0; i < idsEjemplares.size(); i++) {
			listaEjemplares.add((new MultiEjemplar()).buscar(idsEjemplares.get(i)));
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
				+ fechaPublicacion + ", tipo=" + tipo + ", listaAutores=" + listaAutores
				+ ", listaDescriptor=" + listaDescriptores + ", listaEjemplares="
				+ listaEjemplares + ", idsAutores=" + idsAutores
				+ ", idsDescriptores=" + idsDescriptores + "]";
	}
}
