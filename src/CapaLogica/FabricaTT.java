package CapaLogica;

public class FabricaTT {
	private TipoTransaccion objTipoTransaccion;
	
	/**
	 * obtenerTipostransaccion
	 * Retorna un objeto de tipo transaccion segun el parametro. 
	 * @param ptipo tipo de transaccion
	 * @return TipoTransaccion
	 */
	public TipoTransaccion obtenerTipostransaccion(int ptipo){
		switch (ptipo) {
		case 1:
			objTipoTransaccion = new ReporteSalida();
			break;
		case 2:
			objTipoTransaccion = new ReporteEntrada();
			break;
		case 3:
			objTipoTransaccion = new ReportePrestamo();
			break;
		case 4:
			objTipoTransaccion = new ReporteDevolucion();
			break;
		case 5:
			objTipoTransaccion = new ReporteReservacion();
			break;
		case 6:
			objTipoTransaccion = new ReporteFueraUso();
			break;

		default:
			break;
		}
		
		return objTipoTransaccion;
	}

	/**
	 * getObjTipoTransaccion
	 * @return TipoTransaccion Objeto con el tipo de la transaccion.
	 */
	public TipoTransaccion getObjTipoTransaccion() {
		return objTipoTransaccion;
	}

	/**
	 * setObjTipoTransaccion
	 * @param objTipoTransaccion Tipo de transaccion.
	 */
	public void setObjTipoTransaccion(TipoTransaccion objTipoTransaccion) {
		this.objTipoTransaccion = objTipoTransaccion;
	}
}
