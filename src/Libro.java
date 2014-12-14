import java.time.LocalDate;
import java.util.ArrayList;


/**
 * @author miguel
 *
 */
public class Libro {
	private String ISBN;
	private String titulo;
	private String volumen;
	private String editorial;
	private LocalDate fechaPublicacion;
	private int numEjemplares;
	private int tipo;
	private Autor autor;
	private Descriptor descriptor;
	private ArrayList<Ejemplar> listaEjemplares;
	private int idAutor;
	private int idDescriptor;
	
	
	public Libro(){
		
	}
	
	/**
	 * @param iSBN
	 */
	public void setISBN(String iSBN) {
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
	public void setVolumen(String volumen) {
		this.volumen = volumen;
	}
	
	/**
	 * @return
	 */
	public String getVolumen() {
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
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * @return
	 */
	public int getTipo() {
		return tipo;
	}
	
	/**
	 * @param idAutor
	 */
	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}
	
	/**
	 * @return
	 */
	public int getIdAutor() {
		return idAutor;
	}
	
	/**
	 * @param idDescriptor
	 */
	public void setIdDescriptor(int idDescriptor) {
		this.idDescriptor = idDescriptor;
	}
	
	/**
	 * @return
	 */
	public int getIdDescriptor() {
		return idDescriptor;
	}
	
	
	

}
