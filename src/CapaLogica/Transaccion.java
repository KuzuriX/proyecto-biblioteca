package CapaLogica;
import java.time.LocalDate;


public class Transaccion {
	private String id;
	private TipoTransaccion tipoTransaccion;
	private LocalDate fecha;
	private String descripcion;
	// Persistencia
	private String idEjemplar;
	private String idUsuario;
	// Atributos de relaciones
	private Ejemplar ejemplar;
	private Usuario usuario;
	
	
	/**
	 * @param tipo
	 * @param fecha
	 * @param descripcion
	 * @param idEjemplar
	 * @param idUsuario
	 */
	public Transaccion(int ptipo, LocalDate pfecha,
			String pdescripcion, String pidEjemplar, String pidUsuario) {
		setFecha(pfecha);
		setDescripcion(pdescripcion);
		setIdEjemplar(pidEjemplar);
		setIdUsuario(pidUsuario);
		establecerTipoTransaccion(ptipo);
		
		ejemplar = null;
	}
	
	/**
	 * @return the tipoTransaccion
	 */
	public String obtenerTipoTransaccion() {
		return tipoTransaccion.obtenerTipo();
	}
	
	private void establecerTipoTransaccion(int ptipo){
		FabricaTT objFabricaTT = new FabricaTT();
		tipoTransaccion = (objFabricaTT.obtenerTipostransaccion(ptipo));
	}
	
	/**
	 * @return the fecha
	 */
	public LocalDate getFecha() {
		return fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	private void setFecha(LocalDate fecha) {
		this.fecha = fecha;
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
	private void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return the idEjemplar
	 */
	public String getIdEjemplar() {
		return idEjemplar;
	}
	/**
	 * @param idEjemplar the idEjemplar to set
	 */
	private void setIdEjemplar(String idEjemplar) {
		this.idEjemplar = idEjemplar;
	}
	/**
	 * @return the idUsuario
	 */
	public String getIdUsuario() {
		return idUsuario;
	}
	/**
	 * @param idUsuario the idUsuario to set
	 */
	private void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public Ejemplar obtenerEjemplar() {
		ejemplar = (new MultiEjemplar()).buscar(idEjemplar);
		return ejemplar;
	}
	
	public Usuario obtenerUsuario() {
		usuario = (new MultiUsuario()).buscar(idUsuario);
		return usuario;
	}
}
