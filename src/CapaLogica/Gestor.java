package CapaLogica;

import java.time.LocalDate;
import java.util.TreeMap;
import java.util.Vector;

public class Gestor {
	/* -------------------------- Autor -------------------------- */
	public void crearAutor(String pid, String pnombre, String papellido, String pdirElectronica, 
			String pnacionalidad, String ppaisOrigen) throws Exception {
		
		Autor autor;
		autor = (new MultiAutor()).crear(pid, pnombre, papellido, pdirElectronica, pnacionalidad, ppaisOrigen);
	}
	
	public void modificarAutor(String pid, String pnombre, String papellido, String pdirElectronica, 
			String pnacionalidad, String ppaisOrigen) throws Exception {
		
		Autor autor;
		autor = (new MultiAutor()).buscar(pid);

		autor.setNombre(pnombre);
		autor.setApellido(papellido);
		autor.setDirElectronica(pdirElectronica);
		autor.setNacionalidad(pnacionalidad);
		autor.setPaisOrigen(ppaisOrigen);
		
		(new MultiAutor()).modificar(autor);
	}
	
	public void eliminarAutor(String pid) throws Exception {
		Autor autor;
		autor = (new MultiAutor()).buscar(pid);
		
		(new MultiAutor()).eliminar(autor);
	}
	
	public Vector listarAutores() throws Exception {
		Autor autor;
		Vector listaAutores = new Vector();		
		Vector autores = (new MultiAutor()).listar();
		
		for (int i = 0; i < autores.size(); i++) {
			autor = ((Autor) autores.get(i));
			TreeMap datosAutor = new TreeMap();
			datosAutor.put("id", autor.getId());
			datosAutor.put("nombre", autor.getNombre());
			datosAutor.put("apellido", autor.getApellido());
			datosAutor.put("dirElectronica", autor.getDirElectronica());
			datosAutor.put("nacionalidad", autor.getNacionalidad());
			datosAutor.put("paisOrigen", autor.getPaisOrigen());
			
			listaAutores.add(datosAutor);
		}
		
		return listaAutores;
	}

	/* -------------------------- Descriptor -------------------------- */
	
	
	/* -------------------------- Usuario -------------------------- */
	public void crearUsuario(String pid, String pnombre, String papellido, String pdirElectronica, 
			String pdireccion, String ptelefono) throws Exception {
		
		Usuario usuario;
		usuario = (new MultiUsuario()).crear(pid, pnombre, papellido, pdirElectronica, pdireccion, ptelefono, "normal");
	}
	
	public void modificarUsuario(String pid, String pnombre, String papellido, String pdirElectronica, 
			String pdireccion, String ptelefono, String pestado) throws Exception {
		
		Usuario usuario;
		usuario = (new MultiUsuario()).buscar(pid);

		usuario.setNombre(pnombre);
		usuario.setApellido(papellido);
		usuario.setDirElectronica(pdirElectronica);
		usuario.setDireccion(pdireccion);
		usuario.setTelefono(ptelefono);
		usuario.setEstado(pestado);
		
		(new MultiUsuario()).modificar(usuario);
	}
	
	public void eliminarUsuario(String pid) throws Exception {
		Usuario usuario;
		usuario = (new MultiUsuario()).buscar(pid);
		
		(new MultiUsuario()).eliminar(usuario);
	}
	
	public Vector listarUsuarios() throws Exception {
		Usuario usuario;
		Vector lista = new Vector();		
		Vector usuarios = (new MultiUsuario()).listar();
		
		for (int i = 0; i < usuarios.size(); i++) {
			usuario = ((Usuario) usuarios.get(i));
			TreeMap datos = new TreeMap();
			
			datos.put("id", usuario.getId());
			datos.put("nombre", usuario.getNombre());
			datos.put("apellido", usuario.getApellido());
			datos.put("dirElectronica", usuario.getDirElectronica());
			datos.put("direccion", usuario.getDireccion());
			datos.put("telefono", usuario.getTelefono());
			datos.put("estado", usuario.getEstado());
			
			lista.add(datos);
		}
		
		return lista;
	}
	
	/* -------------------------- Libro -------------------------- */
	
	public void libroAgregar(String pisbn, String ptitulo, int pvolumen, String peditorial, LocalDate pfechaPublicacion, String ptipo) throws Exception {
		Libro libro;
		libro = (new MultiLibro()).crear(pisbn, ptitulo, pvolumen, peditorial, pfechaPublicacion, ptipo);
	}
	
	public TreeMap libroBuscar(String pisbn) throws Exception {
		TreeMap datos = null;
		Libro libro=null;
		String nombre;
		datos = new TreeMap();
		libro = (new MultiLibro()).buscar(pisbn);
		datos.put("titulo", libro.getTitulo());
		datos.put("volumen", libro.getVolumen());
		datos.put("editorial", libro.getEditorial());
		datos.put("fechaPublicacion", libro.getFechaPublicacion());
		datos.put("tipo", libro.obtenerTipo());
		return datos;
	}
	
	public Vector libroBuscarPorTitulo(String ptitulo) throws Exception {
		Vector libros=null;
		Vector datosLibros=null;
		Libro libro;
		libros = (new MultiLibro()).buscarPorNombre(ptitulo);
		datosLibros = new Vector();
		for (int i=0; i<libros.size(); i++) {
			libro = ((Libro) libros.get(i));
			TreeMap datosLibro = new TreeMap();
			datosLibro.put("titulo", libro.getTitulo());
			datosLibro.put("volumen", libro.getVolumen());
			datosLibro.put("editorial", libro.getEditorial());
			datosLibro.put("fechaPublicacion", libro.getFechaPublicacion());
			datosLibro.put("tipo", libro.obtenerTipo());
			datosLibros.add(datosLibro);
		}
		return datosLibros;
	}
	
	/* -------------------------- Ejemplar -------------------------- */
	
	public void ejemplarAgregar(String pidEjemplar, String pcodigo, String pestadoFisico, LocalDate pfechaIngreso, String pcondicionActual) throws Exception {
		Ejemplar ejemplar;
		ejemplar = (new MultiEjemplar()).crear(pidEjemplar, pcodigo, pestadoFisico, pfechaIngreso, pcondicionActual);
	}
	
	public TreeMap ejemplarBuscar(String pcodigo) throws Exception {
		TreeMap datos = null;
		Ejemplar ejemplar=null;
		String nombre;
		datos = new TreeMap();
		ejemplar = (new MultiEjemplar()).buscar(pcodigo);
		datos.put("codigo", ejemplar.getCodigo());
		datos.put("estadoFisico", ejemplar.getEstadoFisico());
		datos.put("fechaIngreso", ejemplar.getFechaIngreso());
		datos.put("condicionActual", ejemplar.getCondicionActual());
		return datos;
	}
}
