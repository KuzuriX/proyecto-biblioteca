package CapaLogica;

import CapaAccesoBD.Conector;

public class MultiAutor {
	
	public  Autor crear(String pid, String pnombre, String papellido, String pdirElectronica, String pnacionalidad, String ppaisOrigen) 
			throws java.sql.SQLException,Exception{
		Autor autor=null;
		String sql;
		sql="INSERT INTO TAutor "+
		"(id, nombre, apellido, dirElectronica, nacionalidad, paisOrigen)"+
		"VALUES ('"+pid+"','"+pnombre+"','"+papellido+"','"+pdirElectronica+"','"+pnacionalidad+"','"+ppaisOrigen+"');";
		Conector.getConector().ejecutarSQL(sql);

		autor = new Autor(pid, pnombre, papellido, pdirElectronica, pnacionalidad, ppaisOrigen);
		
		return autor;
	}
	
	public Autor buscar(String pid) throws
			java.sql.SQLException,Exception{
		Autor autor = null;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT * "+
		"FROM TAutor "+
		"WHERE id='"+pid+"';";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		if (rs.next()){
			autor = new Autor(
				rs.getString("id"),
				rs.getString("nombre"),
				rs.getString("apellido"),
				rs.getString("dirElectronica"),
				rs.getString("nacionalidad"),
				rs.getString("paisOrigen"));
		} else {
			throw new Exception ("El abono no est� registrado en el sistema.");
		}
		rs.close();
		return autor;
	}
	
	public  void actualizar(Autor pautor) throws 
		java.sql.SQLException,Exception{
		String sql;
		sql = "UPDATE TAutor "+
				"SET nombre='"+pautor.getNombre()+"', apellido='"+pautor.getApellido()+"', dirElectronica='"+pautor.getDirElectronica()+"'"
						+ ", nacionalidad='"+pautor.getNacionalidad()+"', paisOrigen='"+pautor.getPaisOrigen()+"' "+
				"WHERE id='"+pautor.getId()+"';";
		try {
			Conector.getConector().ejecutarSQL(sql);
		}
		catch (Exception e) {
			throw new Exception ("El autor no est� registrado.");
		}
	}
	
	public  void borrar(Autor pautor) throws
			java.sql.SQLException,Exception{

		String sql;
		sql= "DELETE FROM TAutor "+
		"WHERE id='"+pautor.getId()+"'";
		Conector.getConector().ejecutarSQL(sql);
	}

}
