package CapaLogica;

import java.sql.ResultSet;
import java.util.Vector;

import CapaAccesoBD.Conector;

public class MultiDescriptor {
	
	public Descriptor crear(String pcodigo, String pdescripcion) throws java.sql.SQLException,Exception{
		Descriptor descriptor=null;
		String sql;
		
		sql = "INSERT INTO TDescriptor "+
			  "(codigo, descripcion)"+
		      "VALUES ('"+pcodigo+"','"+pdescripcion+"');";
		
		Conector.getConector().ejecutarSQL(sql);

		descriptor = new Descriptor(pcodigo, pdescripcion);

		return descriptor;
	}
	
	public Descriptor buscar(String pcodigo) throws java.sql.SQLException,Exception{
		Descriptor descriptor = null;
		java.sql.ResultSet rs;
		String sql;
		
		sql = "SELECT * FROM TDescriptor "+
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
	
	public void modificar(Descriptor pdescriptor) throws java.sql.SQLException,Exception{
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
	
	public void eliminar(Descriptor pdescriptor) throws java.sql.SQLException,Exception{
		String sql;
		sql= "DELETE FROM TDescriptor WHERE codigo='"+pdescriptor.getCodigo()+"'";
		Conector.getConector().ejecutarSQL(sql);
	}

	public Vector<Descriptor> listar() throws java.sql.SQLException,Exception {
		Vector<Descriptor> lista = new Vector<Descriptor>();
		String sql;
		ResultSet rs;
		Descriptor descriptor;
		
		sql = "SELECT * FROM TDescriptor;";
		rs = Conector.getConector().ejecutarSQL(sql, true);
		
		if (rs.next()) {
			do {
				descriptor = new Descriptor(
					rs.getString("codigo"),
					rs.getString("descripcion"));
					
				lista.add(descriptor);
			} while (rs.next());
		} else {
			throw new Exception ("No hay descriptores registrados en el sistema.");
		}
		rs.close();

		return lista;
	}
}
