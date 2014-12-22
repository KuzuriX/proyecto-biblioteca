package CapaLogica;

import java.time.LocalDate;
import java.util.Vector;

import CapaAccesoBD.Conector;

public class MultiLibro {
	public  Libro crear(String pisbn, String ptitulo, int pvolumen, String peditorial, LocalDate pfechaPublicacion, String ptipo) 
			throws java.sql.SQLException,Exception {
		Libro libro=null;
		String sql;
		sql="INSERT INTO TLibro "+
		"(isbn, titulo, volumen, editorial, fechaPublicacion, tipo)"+
		"VALUES ('"+pisbn+"','"+ptitulo+"','"+pvolumen+"','"+peditorial+"','"+pfechaPublicacion+"','"+ptipo+"');";
		
		Conector.getConector().ejecutarSQL(sql);

		libro = new Libro(pisbn, ptitulo, pvolumen, peditorial, pfechaPublicacion, ptipo);
		
		return libro;
	}
	
	public Libro buscar(String pisbn) throws
			java.sql.SQLException,Exception{
		Libro libro = null;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT * "+
		"FROM TLibro "+
		"WHERE isbn='"+pisbn+"';";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		if (rs.next()){
			libro = new Libro(
				rs.getString("isbn"),
				rs.getString("titulo"),
				rs.getInt("volumen"),
				rs.getString("editorial"),
				LocalDate.parse(rs.getString("fechaPublicacion")),
				rs.getString("tipo"));
		} else {
			throw new Exception ("El libro no est� registrado en el sistema.");
		}
		rs.close();
		return libro;
	}
	
	public  Vector buscarPorNombre(String ptitulo) throws 
		java.sql.SQLException,Exception{
		Libro libro=null;
		Vector libros=null;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT * "+
		"FROM TLibro "+
		"WHERE titulo LIKE '%"+ptitulo+"%';";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		libros = new Vector ();
		if (rs.next()) {
			do {
				libro = new Libro(
						rs.getString("isbn"),
						rs.getString("titulo"),
						rs.getInt("volumen"),
						rs.getString("editorial"),
						LocalDate.parse(rs.getString("fechaPublicacion")),
						rs.getString("tipo"));
				libros.add(libro);
			} while (rs.next());
		} else {
			throw new Exception ("No hay clientes con ese nombre.");
		}
		rs.close();
		return libros;
	}
	
	public  void actualizar(Libro plibro) throws 
		java.sql.SQLException,Exception{
		String sql;
		sql = "UPDATE TLibro "+
				"SET titulo='"+plibro.getTitulo()+"', volumen='"+plibro.getVolumen()+"', editorial='"+plibro.getEditorial()+"'"
						+ ", fechaPublicacion='"+plibro.getFechaPublicacion()+"', tipo='"+plibro.obtenerTipo()+"' "+
				"WHERE isbn='"+plibro.getISBN()+"';";
		try {
			Conector.getConector().ejecutarSQL(sql);
		}
		catch (Exception e) {
			throw new Exception ("El libro no est� registrado.");
		}
	}
	
	public  void borrar(Libro plibro) throws
			java.sql.SQLException,Exception{
		String sql;
		sql= "DELETE FROM TLibro "+
		"WHERE isbn='"+plibro.getISBN()+"'";
		Conector.getConector().ejecutarSQL(sql);
	}

}
