package CapaLogica;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Vector;

public class ReporteDevolucion implements TipoTransaccion{

	public String obtenerTipo() {
		return "Reporte de devolucion";
	}

	public String obtenerCondicion() {
		return "Libre";
	}
	
	public void ejecutarTransaccion(LocalDate pfecha, String pdescripcion, String pidEjemplar, String pidUsuario) throws SQLException, Exception{
		Ejemplar ejemplar;
		Usuario usuario = null;
		double multa = calcularDeuda(pfecha, pidEjemplar);
		ejemplar = (new MultiEjemplar()).buscar(pidEjemplar);
		
		// Actualizar el estado del ejemplar de Libre a el valor de retorno
					// del tipo de transaccion
		ejemplar.setCondicionActual(obtenerCondicion());
		(new MultiEjemplar()).modificar(ejemplar);
		if (multa != 0) {
			usuario = (new MultiUsuario()).buscar(pidUsuario);
			usuario.setEstado("Moroso");
			(new MultiUsuario()).modificar(usuario);
		}
					
	}
	
	public double calcularDeuda(LocalDate pfecha,  String pidEjemplar) throws SQLException, Exception{
		LocalDate fechaPrestamo = null;
		double diasAtraso;
		 Biblioteca biblio = new MultiBiblioteca().buscar("1");
		 int maxDiasPrestamo = biblio.getMaxDiasPrestamo();
		 double montoMulta = biblio.getMultaPorMorosidad();
		 double multaPrestamo = 0;
		 
		Vector<Transaccion> transaccionesEjemplarVector = new MultiTransaccion().buscarPorCodigoEjemplar(pidEjemplar);
		
		Iterator<Transaccion> it = transaccionesEjemplarVector.iterator();
		
		while(it.hasNext()){
			if(it.next().obtenerCondicionTransaccion().equals("Prestado")){
				fechaPrestamo = it.next().getFecha();
			}
		}
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
		String fecha = formato.format(pfecha); 
		String[] fechaHoy = fecha.split("/"); 
		Integer diaHoy = Integer.parseInt(fechaHoy[0]); 
		Integer mesHoy = Integer.parseInt(fechaHoy[1]); 
		Integer anioHoy = Integer.parseInt(fechaHoy[2]); 
		
		
		String fechaAnterior = formato.format(fechaPrestamo); 
		String[] fechaAnt = fechaAnterior.split("/"); 
		Integer diaAnt = Integer.parseInt(fechaAnt[0]); 
		Integer mesAnt = Integer.parseInt(fechaAnt[1]); 
		Integer anioAnt = Integer.parseInt(fechaAnt[2]); 

		if(anioAnt == anioHoy){ 
			if(mesAnt == mesHoy){ 
				if((diaHoy - diaAnt) > maxDiasPrestamo ){ 
					diasAtraso = diaHoy - diaAnt;
					multaPrestamo = diasAtraso * montoMulta;
				}
			} 
		} 
		
		return multaPrestamo;
	}
	

}
