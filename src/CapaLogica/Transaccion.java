package CapaLogica;
import java.time.LocalDate;


public class Transaccion {
	private TipoTransaccion tipoTransaccion;
	private LocalDate fecha;
	private String descripcion;
	private String idEjemplar;
	private String idUsuario;
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
		crearTipoTransaccion(ptipo);
	}
	
	
	/**
	 * @return the tipoTransaccion
	 */
	public TipoTransaccion getTipoTransaccion() {
		return tipoTransaccion;
	}
	/**
	 * @param tipoTransaccion the tipoTransaccion to set
	 */
	public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
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
	public void setFecha(LocalDate fecha) {
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
	public void setDescripcion(String descripcion) {
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
	public void setIdEjemplar(String idEjemplar) {
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
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public void crearTipoTransaccion(int ptipo){
		FabricaTT objFabricaTT = new FabricaTT();
		setTipoTransaccion(objFabricaTT.obtenerTipostransaccion(ptipo));
	}
	
	

}
