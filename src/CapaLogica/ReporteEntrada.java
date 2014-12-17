package CapaLogica;

public class ReporteEntrada implements TipoTransaccion{

	public String obtenerTipo() {
		return "Reporte de entrada";
	}

	public String obtenerCondicion() {
		return "Libre";
	}
}
