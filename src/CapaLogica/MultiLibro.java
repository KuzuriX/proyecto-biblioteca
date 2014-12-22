package CapaLogica;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Vector;

import CapaAccesoBD.Conector;

public class MultiLibro {
	public Libro crear(String pisbn, String ptitulo, int pvolumen, String peditorial, 
			LocalDate pfechaPublicacion, String ptipo) throws java.sql.SQLException,Exception {
		Libro libro=null;
		String sql;
		sql="INSERT INTO TLibro "+
		"(isbn, titulo, volumen, editorial, fechaPublicacion, tipo)"+
		"VALUES ('"+pisbn+"','"+ptitulo+"','"+pvolumen+"','"+peditorial+"','"+pfechaPublicacion+"','"+ptipo+"');";
		
		Conector.getConector().ejecutarSQL(sql);

		libro = new Libro(pisbn, ptitulo, pvolumen, peditorial, pfechaPublicacion, ptipo);
		
		return libro;
	}
	
	public Libro buscar(String pisbn) throws java.sql.SQLException,Exception{
		Libro libro = null;
		ResultSet rs;
		String sql;
		
		sql = "SELECT * FROM TLibro WHERE isbn='"+pisbn+"';";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		
		if (rs.next()){
			LocalDate fechaPublicacion = LocalDate.parse(rs.getString("fechaPublicacion"));
			libro = new Libro(
				rs.getString("isbn"),
				rs.getString("titulo"),
				rs.getInt("volumen"),
				rs.getString("editorial"),
				fechaPublicacion,
				rs.getString("tipo"));
			
			// Obtener los autores del libro.
			sql = "SELECT idautor FROM TAutoresXLibro WHERE idlibro='"+pisbn+"';";
			ResultSet rsAutores = Conector.getConector().ejecutarSQL(sql, true);				
			if (rsAutores.next()) {
				do {
					libro.asignarAutor(rsAutores.getString("idautor"));
				} while (rsAutores.next());
			}
			
			// Obtener los descriptores del libro.
			sql = "SELECT iddescriptor FROM TDescriptoresXLibro WHERE idlibro='"+pisbn+"';";
			ResultSet rsDescriptores = Conector.getConector().ejecutarSQL(sql, true);				
			if (rsDescriptores.next()) {
				do {
					libro.asignarDescriptor(rsDescriptores.getString("iddescriptor"));
				} while (rsDescriptores.next());
			}			
		} else {
			throw new Exception ("El libro no est� registrado en el sistema.");
		}
		rs.close();
		return libro;
	}
	
	public Vector buscarPorNombre(String ptitulo) throws java.sql.SQLException,Exception {
		Libro libro=null;
		Vector libros=null;
		java.sql.ResultSet rs;
		String sql;
		
		sql = "SELECT * FROM TLibro "+
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
			throw new Exception ("No hay libros con ese titulo.");
		}
		rs.close();
		return libros;
	}
	
	public void modificar(Libro plibro) throws java.sql.SQLException,Exception{
		String sql;
		sql = "UPDATE TLibro "+
				"SET titulo='"+plibro.getTitulo()+"', volumen='"+plibro.getVolumen()+"', editorial='"+plibro.getEditorial()+"'"
						+ ", fechaPublicacion='"+plibro.getFechaPublicacion()+"', tipo='"+plibro.getTipo()+"' "+
				"WHERE isbn='"+plibro.getISBN()+"';";
		try {
			Conector.getConector().ejecutarSQL(sql);
		}
		catch (Exception e) {
			throw new Exception ("El libro no est� registrado.");
		}
	}
	
	public void eliminar(Libro plibro) throws java.sql.SQLException,Exception{
		String sql;
		sql= "DELETE FROM TLibro WHERE isbn='"+plibro.getISBN()+"'";
		Conector.getConector().ejecutarSQL(sql);
	}
	
	public Vector<Libro> listar() throws java.sql.SQLException,Exception {
		Vector<Libro> lista = new Vector<Libro>();
		String sql;
		ResultSet rs, rsAutores, rsDescriptores;
		Libro libro;
		
		sql = "SELECT * FROM TLibro;";
		rs = Conector.getConector().ejecutarSQL(sql, true);
		
		if (rs.next()) {
			do {
				LocalDate fechaPublicacion = LocalDate.parse(rs.getString("fechaPublicacion"));				
				libro = new Libro(
					rs.getString("isbn"),
					rs.getString("titulo"),
					rs.getInt("volumen"),
					rs.getString("editorial"),
					fechaPublicacion,
					rs.getString("tipo"));
				
				// Obtener los autores del libro.
				sql = "SELECT idautor FROM TAutoresXLibro;";
				rsAutores = Conector.getConector().ejecutarSQL(sql, true);				
				if (rsAutores.next()) {
					do {
						libro.asignarAutor(rsAutores.getString("idautor"));
					} while (rsAutores.next());
				}
				
				// Obtener los descriptores del libro.
				sql = "SELECT iddescriptor FROM TDescriptoresXLibro;";
				rsDescriptores = Conector.getConector().ejecutarSQL(sql, true);				
				if (rsDescriptores.next()) {
					do {
						libro.asignarDescriptor(rsDescriptores.getString("iddescriptor"));
					} while (rsDescriptores.next());
				}
				
				lista.add(libro);
			} while (rs.next());
		} else {
			throw new Exception ("No hay libros registrados en el sistema.");
		}
		rs.close();

		return lista;
	}

	public void asociarAutor(String pisbn, String pidAutor) 
			throws java.sql.SQLException, Exception {
		String sql;
		
		sql="INSERT INTO TAutoresXLibro (idautor, idlibro) VALUES ('" + pidAutor +"','"+ pisbn +"');";
		
		try {
			Conector.getConector().ejecutarSQL(sql);
		} catch (Exception e) {
			throw new Exception ("No se pudo asociar el autor al libro.");
		}		
	}
	
	public void asociarDescriptor(String pisbn, String pcodigoDesc) 
			throws java.sql.SQLException, Exception {
		String sql;
		
		sql="INSERT INTO TDescriptoresXLibro (iddescriptor, idlibro) VALUES ('" + pcodigoDesc +"','"+ pisbn +"');";
		
		try {
			Conector.getConector().ejecutarSQL(sql);
		} catch (Exception e) {
			throw new Exception ("No se pudo asociar el descriptor al libro.");
		}		
	}
}
