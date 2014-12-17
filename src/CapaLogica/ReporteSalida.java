package CapaLogica;

public class ReporteSalida implements TipoTransaccion{

	public String obtenerTipo() {
		return "Reporte de salida";
	}

	public String obtenerCondicion() {
		return "Perdido";
	}
}
