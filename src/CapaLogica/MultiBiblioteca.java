package CapaLogica;

import java.sql.ResultSet;
import java.util.Vector;

import CapaAccesoBD.Conector;

public class MultiBiblioteca {
	public Biblioteca crear(int pmaxDiasPrestamo, double pmultaPorDiaMorosidad) throws java.sql.SQLException, Exception {
		Biblioteca autor=null;
		String sql;
		sql="INSERT INTO TBiblioteca "+
		"(maxDiasPrestamo, multaPorDiaMorosidad)"+
		"VALUES ('"+pmaxDiasPrestamo+"','"+pmultaPorDiaMorosidad+"');";
		Conector.getConector().ejecutarSQL(sql);

		autor = new Biblioteca(pmaxDiasPrestamo, pmultaPorDiaMorosidad);
		
		return autor;
	}
	
	public Biblioteca buscar(String pid) throws java.sql.SQLException,Exception{
		Biblioteca autor = null;
		ResultSet rs;
		String sql;
		
		sql = "SELECT * FROM TBiblioteca "+
		"WHERE id='"+pid+"';";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		if (rs.next()){
			autor = new Biblioteca(
				rs.getInt("id"),
				rs.getDouble("nombre"));
		} else {
			throw new Exception ("La biblioteca no esta registrada en el sistema.");
		}
		rs.close();
		
		return autor;
	}
	
	public void modificar(Biblioteca pbiblioteca) throws java.sql.SQLException, Exception {
		String sql;
		sql = "UPDATE TBiblioteca "+
				"SET maxDiasPrestamo='"+pbiblioteca.getMaxDiasPrestamo()+"', multaPorDiaMorosidad='"+pbiblioteca.getMultaPorMorosidad()+"' "+
				"WHERE id='"+pbiblioteca.getId()+"';";
		try {
			Conector.getConector().ejecutarSQL(sql);
		}
		catch (Exception e) {
			throw new Exception ("El autor no esta registrado.");
		}
	}
	
	public void eliminar(Biblioteca pbiblioteca) throws java.sql.SQLException,Exception {
		String sql;		
		sql= "DELETE FROM TBiblioteca WHERE id='" + pbiblioteca.getId() + "'";
		Conector.getConector().ejecutarSQL(sql);
	}
	
	
}
