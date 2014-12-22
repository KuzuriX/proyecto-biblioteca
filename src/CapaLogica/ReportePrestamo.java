package CapaLogica;

public class ReportePrestamo implements TipoTransaccion{

	public String obtenerTipo() {
		return "Reporte de prestamo";
	}

	public String obtenerCondicion() {
		return "Prestado";
	}
}
