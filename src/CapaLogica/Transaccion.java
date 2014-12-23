package CapaLogica;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;


public class Transaccion {
	private int id;
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
	 * Constructor de Transaccion
	 * @param pid			Identificador de la transaccion
	 * @param ptipo			Tipo de transaccion
	 * @param pfecha		Fecha en que se realizo
	 * @param pdescripcion	Descripcion
	 * @param pidEjemplar 	Ejemplar sobre el que se realiza la transaccion
	 * @param pidUsuario	Usuario que realizo la transaccion
	 */
	public Transaccion(int pid, int ptipo, LocalDate pfecha, String pdescripcion, 
			String pidEjemplar, String pidUsuario) {
		setId(pid);
		setDescripcion(pdescripcion);
		setFecha(pfecha);
		setIdEjemplar(pidEjemplar);
		setIdUsuario(pidUsuario);
		establecerTipoTransaccion(ptipo);
		
		ejemplar = null;
		usuario = null;
	}
	
	/**
	 * getId
	 * @return int Identificador de la transaccion
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * setId
	 * @param pid Identificador de la transaccion
	 */
	private void setId(int pid) {
		id = pid;
	}
	
	/**
	 * obtenerTipoTransaccion
	 * @return String Tipo de transaccion
	 */
	public String obtenerTipoTransaccion() {
		return tipoTransaccion.obtenerTipo();
	}
	
	/**
	 * establecerTipoTransaccion
	 * @param ptipo tipo de transaccion
	 */
	private void establecerTipoTransaccion(int ptipo){
		FabricaTT objFabricaTT = new FabricaTT();
		tipoTransaccion = (objFabricaTT.obtenerTipostransaccion(ptipo));
	}
	
	/**
	 * getFecha
	 * @return LocalDate Fecha en que se realizo la transaccion
	 */
	public LocalDate getFecha() {
		return fecha;
	}
	/**
	 * setFecha
	 * @param fecha Fecha en que se realizo la transaccion
	 */
	private void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	/**
	 * getDescripcion
	 * @return String Descripcion de la transaccion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	
	/**
	 * setDescripcion
	 * @param descripcion Descripcion de la transaccion
	 */
	private void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	/**
	 * getIdEjemplar
	 * @return String Codigo del ejemplar
	 */
	public String getIdEjemplar() {
		return idEjemplar;
	}
	
	/**
	 * setIdEjemplar
	 * @param idEjemplar Codigo del ejemplar sobre el que realizo la transaccion
	 */
	private void setIdEjemplar(String idEjemplar) {
		this.idEjemplar = idEjemplar;
	}
	
	/**
	 * getIdUsuario
	 * @return String Identificacion del usuario que realizo la transaccion
	 */
	public String getIdUsuario() {
		return idUsuario;
	}
	
	/**
	 * setIdUsuario
	 * @param idUsuario Identificacion del usuario que realizo la transaccion
	 */
	private void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	/**
	 * obtenerEjemplar
	 * Retorna un objeto de tipo Ejemplar que contiene la informacion del ejemplar
	 * sobre el que se realizo la transaccion
	 * @return Ejemplar Ejemplar sobre el que se realizo la transaccion
	 * @throws SQLException
	 * @throws Exception
	 */
	public Ejemplar obtenerEjemplar() throws SQLException, Exception {
		ejemplar = (new MultiEjemplar()).buscar(idEjemplar);
		return ejemplar;
	}
	
	/**
	 * obtenerUsuario
	 * Retorna un objeto de tipo Usuario que contiene la informacion del usuario
	 * que realizo la transaccion
	 * @return Usuario Usuario que realizo la transaccion
	 * @throws SQLException
	 * @throws Exception
	 */
	public Usuario obtenerUsuario() throws SQLException, Exception {
		usuario = (new MultiUsuario()).buscar(idUsuario);
		return usuario;
	}
	
	/**
	 * obtenerCondicionTransaccion
	 * @return String Condicion actual que debe asignarse al ejemplar
	 */
	public String obtenerCondicionTransaccion() {
		return tipoTransaccion.obtenerCondicion();
	}
	
	@Override
	public String toString() {
		String estado = "Id: " + getId() + "\n" +
				"Tipo: " + obtenerTipoTransaccion() + "\n" +
				"Fecha: " + getFecha() + "\n" + 
				"Descripcion: " + getDescripcion() + "\n" + 
				"Ejemplar: " + getIdEjemplar() + "\n" +
				"Usuario:" + getIdUsuario();
		
		return estado;
	} 
}





