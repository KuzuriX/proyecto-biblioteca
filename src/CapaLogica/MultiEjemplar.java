package CapaLogica;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Vector;

import CapaAccesoBD.Conector;

public class MultiEjemplar {
	public Ejemplar crear(String pisbn, String pcodigo, String pestadoFisico, LocalDate pfechaIngreso, String pcondicionActual) 
			throws java.sql.SQLException,Exception {
		Ejemplar ejemplar=null;
		String sql;
		
		sql="INSERT INTO TEjemplar "+
		"(codigo, estadoFisico, fechaIngreso, condicionActual, idLibro)"+
		"VALUES ('"+pcodigo+"','"+pestadoFisico+"','"+pfechaIngreso+"','"+pcondicionActual+"','"+pisbn+"');";
		
		Conector.getConector().ejecutarSQL(sql);

		ejemplar = new Ejemplar(pisbn, pcodigo, pestadoFisico, pfechaIngreso, pcondicionActual);
		
		return ejemplar;
	}
	
	public Ejemplar buscar(String pcodigo) throws java.sql.SQLException,Exception {
		Ejemplar ejemplar = null;
		java.sql.ResultSet rs;
		String sql;
		
		sql = "SELECT * FROM TEjemplar "+
			  "WHERE codigo='"+pcodigo+"';";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		
		if (rs.next()){
			ejemplar = new Ejemplar(
				rs.getString("idLibro"),
				rs.getString("codigo"),
				rs.getString("estadoFisico"),
				LocalDate.parse(rs.getString("fechaIngreso")),
				rs.getString("condicionActual"));
		} else {
			throw new Exception ("El ejemplar no est� registrado en el sistema.");
		}
		rs.close();
		return ejemplar;
	}
	
	public void modificar(Ejemplar pejemplar) throws java.sql.SQLException,Exception {
		String sql;
		sql = "UPDATE TEjemplar "+
				"SET estadoFisico='"+pejemplar.getEstadoFisico()+"', fechaIngreso='"+pejemplar.getFechaIngreso()+"'"
						+ ", condicionActual='"+pejemplar.getCondicionActual()+"', idLibro='"+pejemplar.getIdLibro()+"' "+
				"WHERE codigo='"+pejemplar.getCodigo()+"';";
		try {
			Conector.getConector().ejecutarSQL(sql);
		}
		catch (Exception e) {
			throw new Exception ("El ejemplar no est� registrado.");
		}
	}
	
	public void eliminar(Ejemplar pejemplar) throws java.sql.SQLException,Exception {
		String sql;
		sql= "DELETE FROM TEjemplar WHERE codigo='"+pejemplar.getCodigo()+"'";
		Conector.getConector().ejecutarSQL(sql);
	}
	
	public Vector<Ejemplar> listar() throws java.sql.SQLException,Exception {
		Vector<Ejemplar> lista = new Vector<Ejemplar>();
		String sql;
		ResultSet rs;
		Ejemplar ejemplar;
		
		sql = "SELECT * FROM TEjemplar;";
		rs = Conector.getConector().ejecutarSQL(sql, true);
		
		if (rs.next()) {
			do {
				LocalDate fechaIngreso = LocalDate.parse(rs.getString("fechaIngreso"));				
				ejemplar = new Ejemplar(
					rs.getString("idLibro"),
					rs.getString("codigo"),
					rs.getString("estadoFisico"),
					fechaIngreso,
					rs.getString("condicionActual"));
				
				lista.add(ejemplar);
			} while (rs.next());
		} else {
			throw new Exception ("No hay ejemplares registrados en el sistema.");
		}
		rs.close();

		return lista;
	}
}
