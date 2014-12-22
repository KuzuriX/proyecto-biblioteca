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
		Vector autores = (new MultiAutor()).listarAutores();
		
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
	
}
