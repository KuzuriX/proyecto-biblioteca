package CapaLogica;

public class ReporteFueraUso implements TipoTransaccion{

	public String obtenerTipo() {
		return "Reporte de libro fuera de uso";
	}

	public String obtenerCondicion() {
		return "Fuera de uso";
	}
}
