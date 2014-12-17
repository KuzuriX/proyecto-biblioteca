package CapaLogica;

import java.time.LocalDate;
import java.util.Vector;

import CapaAccesoBD.Conector;

public class MultiLibro {
	
	public  Libro crear(String pisbn, String ptitulo, int pvolumen, String peditorial, LocalDate pfechaPublicacion, String ptipo) 
			throws java.sql.SQLException,Exception{
		java.sql.ResultSet rs;
		Libro libro=null;
		int numeroAbono=0;
		String sql;
		sql="INSERT INTO TLibro "+
		"(numCuenta, monto, fecha)"+
		"VALUES ('"+pnumeroCuenta+"',"+pmonto+",'"+pfecha+"');";
		Conector.getConector().ejecutarSQL(sql);

		sql = "SELECT max(numero) AS nuevoNumero from TAbono;";

		rs = Conector.getConector().ejecutarSQL(sql, true);
		if (rs.next()) {
			numeroAbono = rs.getInt("nuevoNumero");
			abono = new Abono(numeroAbono, pfecha, pmonto,pnumeroCuenta);
		} else {
			throw new java.sql.SQLException ("Error en la BD.");
		}
		rs.close();
		return abono;
	}
	
	public Libro buscar(String pISBN) throws
			java.sql.SQLException,Exception{
		Libro libro = null;
		java.sql.ResultSet rs;
		String sql;
		
		sql = "SELECT * "+
		"FROM TLibro "+
		"WHERE ISBN='"+pISBN+"';";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		if (rs.next()){
			libro = new Libro(
				rs.getInt("numero"),
				rs.getString("fecha"),
				rs.getDouble("monto"),
				rs.getString("numCuenta"));
		} else {
			throw new Exception ("El abono no est� registrado en el sistema.");
		}
		rs.close();
		return libro;
	}
	
	public  Vector buscarPorCuenta(String pnumeroCuenta) throws java.sql.SQLException,Exception{
			java.sql.ResultSet rs;
		String sql;
		Abono abono=null;
		Vector abonos=null;
		sql="SELECT * "+
		"FROM TAbono "+
		"WHERE numCuenta='"+pnumeroCuenta+"';";
		Conector.getConector().ejecutarSQL(sql);
		rs = Conector.getConector().ejecutarSQL(sql,true);
		abonos = new Vector();
		while (rs.next()){
			abono = new Abono(
				rs.getInt("numero"),
				rs.getString("fecha"),
				rs.getDouble("monto"),
				rs.getString("numCuenta"));
				abonos.add(abono);
		}
		rs.close();
		return abonos;
	}
	
	public  void borrar(Libro plibro) throws
			java.sql.SQLException,Exception{
		java.sql.ResultSet rs;
		String sql;
		sql= "DELETE FROM TLibro "+
		"WHERE isbn='"+plibro.getISBN()+"'";
		Conector.getConector().ejecutarSQL(sql);
	}

}
