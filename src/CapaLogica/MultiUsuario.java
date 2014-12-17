package CapaLogica;

import CapaAccesoBD.Conector;

public class MultiUsuario {
	
	public  Usuario crear(String pid, String pnombre, String papellido, String pdirElectronica, String pdireccion, String ptelefono, String pestado) 
			throws java.sql.SQLException,Exception{
		Usuario usuario=null;
		String sql;
		sql="INSERT INTO TUsuario "+
		"(id, nombre, apellido, dirElectronica, direccion, telefono, estado)"+
		"VALUES ('"+pid+"','"+pnombre+"','"+papellido+"','"+pdirElectronica+"','"+pdireccion+"','"+ptelefono+"','"+pestado+"');";
		
		Conector.getConector().ejecutarSQL(sql, true);

		usuario = new Usuario(pid, pnombre, papellido, pdirElectronica, pdireccion, ptelefono, pestado);

		return usuario;
	}
	
	public  Usuario buscar(String pid) throws
			java.sql.SQLException,Exception{
		Usuario usuario = null;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT * "+
		"FROM TUsuario "+
		"WHERE id='"+pid+"';";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		if (rs.next()){
			usuario = new Usuario(
				rs.getString("id"),
				rs.getString("nombre"),
				rs.getString("apellido"),
				rs.getString("dirElectronica"),
				rs.getString("direccion"),
				rs.getString("telefono"),
				rs.getString("estado"));
		} else {
			throw new Exception ("El usuario no est� registrado en el sistema.");
		}
		rs.close();
		return usuario;
	}
	
	public  void actualizar(Usuario pusuario) throws 
		java.sql.SQLException,Exception{
		String sql;
		sql = "UPDATE TUsuario "+
				"SET nombre='"+pusuario.getNombre()+"', apellido='"+pusuario.getApellido()+"', dirElectronica='"+pusuario.getDirElectronica()+"'"
						+ ", direccion='"+pusuario.getDireccion()+"', telefono='"+pusuario.getTelefono()+"', estado='"+pusuario.getEstado()+"' "+
				"WHERE id='"+pusuario.getId()+"';";
		try {
			Conector.getConector().ejecutarSQL(sql);
		}
		catch (Exception e) {
			throw new Exception ("El usuario no est� registrado.");
		}
	}
	
	public  void borrar(Usuario pusuario) throws
			java.sql.SQLException,Exception{
		String sql;
		sql= "DELETE FROM TUsuario "+
		"WHERE id='"+pusuario.getId()+"'";
		Conector.getConector().ejecutarSQL(sql);
	}

}
