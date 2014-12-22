package CapaLogica;

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
}
