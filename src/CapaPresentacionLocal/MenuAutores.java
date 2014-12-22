package CapaPresentacionLocal;

import java.io.IOException;
import java.util.TreeMap;
import java.util.Vector;

import CapaLogica.Autor;
import CapaLogica.Gestor;

public class MenuAutores extends Menu {
	public void mostrarMenu() throws java.io.IOException {
        int opcion;
        boolean volver = false;
        String[] listaMenu = {
        		"1. Crear autor",
        		"2. Modificar autor",
        		"3. Eliminar autor",
        		"4. Listar autores",
                "0. Volver al menu principal"
        };

        do {
        	out.println();
        	out.println(" MENU AUTORES");
        	out.println("---------------------------");
            mostrarMenu(listaMenu);
            opcion = leerOpcion();
            volver = ejecutarSeleccion(opcion);
        } while (!volver);
    }
	
	public boolean ejecutarSeleccion(int popcion) throws java.io.IOException {
        boolean volver = false;

        switch (popcion) {
            case 1:
                crearAutor();
                break;
            case 2:
                modificarAutor();
                break;                
            case 3:
                eliminarAutor();
                break;            
            case 4:
                listarAutores();
                break;        
            case 0: 
            	volver = true;
            	break;
            default: // Cualquier otro valor dado por el usuario se considera invalido
                out.println("Opcion invalida.");
                out.println();
                break;
        }
        
        return volver;
    }
	
	public void crearAutor() throws IOException {
    	out.println("Ingrese la identificacion: ");
    	String pid = in.readLine();

    	out.println("Ingrese el nombre: ");
    	String pnombre = in.readLine();
    	
    	out.println("Ingrese el apellido: ");
    	String papellido = in.readLine();
    	
    	out.println("Ingrese la direccion electronica: ");
    	String pdirElectronica = in.readLine();
    	
    	out.println("Ingrese la nacionalidad: ");
		String pnacionalidad = in.readLine();
		
		out.println("Ingrese el pais de origen: ");
		String ppaisOrigen = in.readLine();
		
    	try {
			(new Gestor()).crearAutor(pid, pnombre, papellido, pdirElectronica, pnacionalidad, ppaisOrigen);
			mostrarMensaje("El autor se agrego con exito!");
		} catch (Exception e) {
			mostrarMensaje("El autor ya se encuentra registrado.");
		}
    }
    
	public void modificarAutor() throws IOException {
		out.println("Ingrese la identificacion del autor a modificar: ");
    	String pid = in.readLine();
    	
    	out.println("Ingrese el nombre: ");
    	String pnombre = in.readLine();
    	
    	out.println("Ingrese el apellido: ");
    	String papellido = in.readLine();
    	
    	out.println("Ingrese la direccion electronica: ");
    	String pdirElectronica = in.readLine();
    	
    	out.println("Ingrese la nacionalidad: ");
		String pnacionalidad = in.readLine();
		
		out.println("Ingrese el pais de origen: ");
		String ppaisOrigen = in.readLine();
    	
    	try {
			(new Gestor()).modificarAutor(pid, pnombre, papellido, pdirElectronica, pnacionalidad, ppaisOrigen);
			mostrarMensaje("El autor se modifico con exito!");
			
		} catch (Exception e) {
			mostrarMensaje("El autor no se encuentra registrado.");
		}
	}
    
	public void eliminarAutor() throws IOException {
		out.println("Ingrese la identificacion del autor: ");
    	String pid = in.readLine();
    	
    	try {
			(new Gestor()).eliminarAutor(pid);
			mostrarMensaje("El autor se elimino con exito!");
		} catch (Exception e) {
			mostrarMensaje("El autor no se encuentra registrado.");
		}
	}
    
	public void listarAutores() throws IOException {
		try {
			Vector autores = (new Gestor()).listarAutores();
			TreeMap datosAutor;
			
			out.println("");
			out.println("LISTA DE AUTORES");
			out.println("-----------------------------------------------------------------");
			
			for (int i = 0; i < autores.size(); i++) {
				datosAutor = ((TreeMap) autores.get(i));				
				
				out.println("Identificacion: \t" + datosAutor.get("id"));
				out.println("Nombre: \t\t" + datosAutor.get("nombre"));
				out.println("Apellido: \t\t" + datosAutor.get("apellido"));
				out.println("Direccion electronica: \t" + datosAutor.get("dirElectronica"));
				out.println("Nacionalidad: \t\t" + datosAutor.get("nacionalidad"));
				out.println("Pais de origen: \t" + datosAutor.get("paisOrigen"));	
				out.println("-----------------------------------------------------------------");
			}			
			out.println("");
		} catch (Exception e) {
			mostrarMensaje("No se encontraron autores registrados.");
		}
	}
}
