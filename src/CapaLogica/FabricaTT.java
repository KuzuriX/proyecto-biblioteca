package CapaLogica;

public class FabricaTT {
	private TipoTransaccion objTipoTransaccion; 	
	
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
	 * @return the objTipoTransaccion
	 */
	public TipoTransaccion getObjTipoTransaccion() {
		return objTipoTransaccion;
	}

	/**
	 * @param objTipoTransaccion the objTipoTransaccion to set
	 */
	public void setObjTipoTransaccion(TipoTransaccion objTipoTransaccion) {
		this.objTipoTransaccion = objTipoTransaccion;
	}
}
