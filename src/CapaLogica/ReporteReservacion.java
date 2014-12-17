package CapaLogica;

public class ReporteReservacion implements TipoTransaccion{

	public String obtenerTipo() {
		return "Reporte de reservacion de libro";
	}

	public String obtenerCondicion() {
		return "Reservado";
	}
}
