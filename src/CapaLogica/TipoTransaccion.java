package CapaLogica;

import java.sql.SQLException;
import java.time.LocalDate;

public abstract interface TipoTransaccion {
	
	public String obtenerTipo();
	
	public String obtenerCondicion();
	
	public void ejecutarTransaccion(LocalDate pfecha, String pdescripcion, String pidEjemplar, String pidUsuario) throws SQLException, Exception;

}
