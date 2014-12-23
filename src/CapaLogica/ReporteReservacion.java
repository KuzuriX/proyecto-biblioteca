package CapaLogica;

import java.sql.SQLException;
import java.time.LocalDate;

public class ReporteReservacion implements TipoTransaccion{

	public String obtenerTipo() {
		return "Reporte de reservacion de libro";
	}

	public String obtenerCondicion() {
		return "Reservado";
	}
	
	public void ejecutarTransaccion(LocalDate pfecha, String pdescripcion, String pidEjemplar, String pidUsuario) throws SQLException, Exception{
		Ejemplar ejemplar;
		ejemplar = (new MultiEjemplar()).buscar(pidEjemplar);
		// Actualizar el estado del ejemplar de Libre a el valor de retorno
					// del tipo de transaccion
					ejemplar.setCondicionActual(obtenerCondicion());
					(new MultiEjemplar()).modificar(ejemplar);
	}
}
