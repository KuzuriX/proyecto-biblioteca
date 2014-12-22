package CapaLogica;

import java.io.IOException;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Vector;

import CapaAccesoBD.Conector;

public class MultiTransaccion {
	public Transaccion crear(int pid, int ptipo, LocalDate pfecha, String pdescripcion, 
			String pidEjemplar, String pidUsuario) throws java.sql.SQLException,Exception {
		Transaccion transaccion = null;
		String sql;
		
		sql="INSERT INTO TTransaccion "+
		"(id, tipo, fecha, descripcion, idEjemplar, idUsuario) "+
		"VALUES ('"+pid+"','"+ptipo+"','"+pfecha+"','"+pdescripcion+"','"+pidEjemplar+"','"+pidUsuario+"');";
		
		Conector.getConector().ejecutarSQL(sql);

		transaccion = new Transaccion(pid, ptipo, pfecha, pdescripcion, pidEjemplar, pidUsuario);
		
		return transaccion;
	}
	
	public Transaccion buscar(String pid) throws java.sql.SQLException,Exception{
		Transaccion transaccion = null;
		ResultSet rs;
		String sql;
		
		sql = "SELECT * FROM TTransaccion WHERE id='"+pid+"';";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		
		if (rs.next()){
			LocalDate fecha = LocalDate.parse(rs.getString("fecha"));
			transaccion = new Transaccion(
				rs.getInt("id"),
				rs.getInt("tipo"),
				fecha,
				rs.getString("descripcion"),
				rs.getString("idEjemplar"),
				rs.getString("idUsuario"));
		} else {
			throw new Exception ("La transaccion no esta registrada en el sistema.");
		}
		rs.close();
		return transaccion;
	}
	
	public Vector<Transaccion> buscarPorCodigoEjemplar(String pcodigo) 
			throws java.sql.SQLException,Exception {
		Vector<Transaccion> lista = new Vector<Transaccion>();
		Transaccion transaccion = null;
		ResultSet rs;
		String sql;
		
		sql = "SELECT * FROM TTransaccion WHERE idejemplar = '" + pcodigo + "';";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		
		if (rs.next()){
			do {
				transaccion = new Transaccion(
						rs.getInt("id"),
						rs.getInt("tipo"),
						LocalDate.parse(rs.getString("fecha")),
						rs.getString("descripcion"),
						rs.getString("idEjemplar"),
						rs.getString("idUsuario"));
					
				lista.add(transaccion);
				
			} while(rs.next());
		} else {
			throw new Exception ("No hay transacciones realizadas a ese ejemplar.");
		}
		rs.close();
		
		return lista;
	}
	
	public Vector<Transaccion> buscarPorIdUsuario(String pid) 
			throws java.sql.SQLException,Exception {
		Vector<Transaccion> lista = new Vector<Transaccion>();
		Transaccion transaccion = null;
		ResultSet rs;
		String sql;
		
		sql = "SELECT * FROM TTransaccion WHERE idusuario = '" + pid + "' " +
				"AND (tipo=3 OR tipo=4) ORDER BY fecha ASC;";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		
		if (rs.next()){
			do {
				transaccion = new Transaccion(
						rs.getInt("id"),
						rs.getInt("tipo"),
						LocalDate.parse(rs.getString("fecha")),
						rs.getString("descripcion"),
						rs.getString("idEjemplar"),
						rs.getString("idUsuario"));
				lista.add(transaccion);				
			} while(rs.next());
		} else {
			throw new Exception ("No hay transacciones realizadas a ese ejemplar.");
		}
		rs.close();
		
		return lista;
	}
	
	public void eliminar(Transaccion ptransaccion) throws java.sql.SQLException,Exception{
		String sql;
		sql= "DELETE FROM TTransaccion WHERE id='" + ptransaccion.getId() + "'";
		Conector.getConector().ejecutarSQL(sql);
	}
	
	public int obtenerUltimoId() throws java.sql.SQLException,Exception {
		int ultimoId = 0;
		String sql;
		ResultSet rs;
		sql = "SELECT * FROM TTransaccion ORDER BY id;";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		
		if (rs.next()){
			ultimoId = rs.getInt("id");
		}
		
		return ultimoId;
	}
}
