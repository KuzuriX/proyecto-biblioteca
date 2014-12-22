package CapaLogica;

import java.time.LocalDate;

import CapaAccesoBD.Conector;

public class MultiEjemplar {
	public  Ejemplar crear(String pidEjemplar, String pcodigo, String pestadoFisico, LocalDate pfechaIngreso, String pcondicionActual) 
			throws java.sql.SQLException,Exception {
		Ejemplar ejemplar=null;
		String sql;
		sql="INSERT INTO TEjemplar "+
		"(codigo, estadoFisico, fechaIngreso, condicionActual, idEjemplar)"+
		"VALUES ('"+pcodigo+"','"+pestadoFisico+"','"+pfechaIngreso+"','"+pcondicionActual+"','"+pidEjemplar+"');";
		
		Conector.getConector().ejecutarSQL(sql);

		ejemplar = new Ejemplar(pidEjemplar, pcodigo, pestadoFisico, pfechaIngreso, pcondicionActual);
		
		return ejemplar;
	}
	
	public Ejemplar buscar(String pcodigo) throws
			java.sql.SQLException,Exception{
		Ejemplar ejemplar = null;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT * "+
		"FROM TEjemplar "+
		"WHERE codigo='"+pcodigo+"';";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		if (rs.next()){
			ejemplar = new Ejemplar(
				rs.getString("idEjemplar"),
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
	
	public  void actualizar(Ejemplar pejemplar) throws 
		java.sql.SQLException,Exception{
		String sql;
		sql = "UPDATE TEjemplar "+
				"SET  estadoFisico='"+pejemplar.getEstadoFisico()+"', fechaIngreso='"+pejemplar.getFechaIngreso()+"'"
						+ ", condicionActual='"+pejemplar.getCondicionActual()+"', idEjemplar='"+pejemplar.getIdLibro()+"' "+
				"WHERE codigo='"+pejemplar.getCodigo()+"';";
		try {
			Conector.getConector().ejecutarSQL(sql);
		}
		catch (Exception e) {
			throw new Exception ("El ejemplar no est� registrado.");
		}
	}
	
	public  void borrar(Ejemplar pejemplar) throws
			java.sql.SQLException,Exception{
		String sql;
		sql= "DELETE FROM TEjemplar "+
		"WHERE codigo='"+pejemplar.getCodigo()+"'";
		Conector.getConector().ejecutarSQL(sql);
	}

}
