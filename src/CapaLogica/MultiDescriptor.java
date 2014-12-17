package CapaLogica;

import CapaAccesoBD.Conector;

public class MultiDescriptor {
	
	public  Descriptor crear(String pcodigo, String pdescripcion) 
			throws java.sql.SQLException,Exception{
		Descriptor descriptor=null;
		String sql;
		sql="INSERT INTO TDescriptor "+
		"(codigo, descripcion)"+
		"VALUES ('"+pcodigo+"','"+pdescripcion+"');";
		Conector.getConector().ejecutarSQL(sql);

		descriptor = new Descriptor(pcodigo, pdescripcion);

		return descriptor;
	}
	
	public  Descriptor buscar(String pcodigo) throws
			java.sql.SQLException,Exception{
		Descriptor descriptor = null;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT * "+
		"FROM TDescriptor "+
		"WHERE codigo='"+pcodigo+"';";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		if (rs.next()){
			descriptor = new Descriptor(
				rs.getString("codigo"),
				rs.getString("descripcion"));
		} else {
			throw new Exception ("El descriptor no est� registrado en el sistema.");
		}
		rs.close();
		return descriptor;
	}
	
	public  void actualizar(Descriptor pdescriptor) throws 
		java.sql.SQLException,Exception{
		String sql;
		sql = "UPDATE TDescriptor "+
				"SET descripcion='"+pdescriptor.getDescripcion()+"' "+
				"WHERE codigo='"+pdescriptor.getCodigo()+"';";
		try {
			Conector.getConector().ejecutarSQL(sql);
		}
		catch (Exception e) {
			throw new Exception ("El descriptor no est� registrado.");
		}
	}
	
	public  void borrar(Descriptor pdescriptor) throws
			java.sql.SQLException,Exception{
		String sql;
		sql= "DELETE FROM TDescriptor "+
		"WHERE codigo='"+pdescriptor.getCodigo()+"'";
		Conector.getConector().ejecutarSQL(sql);
	}

}
