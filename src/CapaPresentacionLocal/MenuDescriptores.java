package CapaPresentacionLocal;

import java.io.IOException;
import java.util.TreeMap;
import java.util.Vector;

import CapaLogica.Descriptor;
import CapaLogica.Gestor;

public class MenuDescriptores extends Menu {
	public void mostrarMenu() throws java.io.IOException {
        int opcion;
        boolean volver = false;
        String[] listaMenu = {
        		"1. Crear descriptor",
        		"2. Modificar descriptor",
        		"3. Eliminar descriptor",
        		"4. Listar descriptores",
                "0. Volver al menu principal"
        };

        do {
        	out.println();
        	out.println(" MENU DESCRIPTORES");
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
                crearDescriptor();
                break;
            case 2:
                modificarDescriptor();
                break;                
            case 3:
                eliminarDescriptor();
                break;            
            case 4:
                listarDescriptores();
                break;        
            case 0: 
            	volver = true;
            	break;
            default: // Cualquier otro valor dado por el descriptor se considera invalido
                out.println("Opcion invalida.");
                out.println();
                break;
        }
        
        return volver;
    }
	
	public void crearDescriptor() throws IOException {
    	out.println("Ingrese el codigo: ");
    	String pcodigo = in.readLine();

    	out.println("Ingrese el nombre: ");
    	String pdescripcion = in.readLine();
    	
    	try {
			(new Gestor()).crearDescriptor(pcodigo, pdescripcion);
			mostrarMensaje("El descriptor se agrego con exito!");
		} catch (Exception e) {
			mostrarMensaje("El descriptor ya se encuentra registrado.");
			out.println(e);
		}
    }
    
	public void modificarDescriptor() throws IOException {
		out.println("Ingrese el codigo del descriptor a modificar: ");
		String pcodigo = in.readLine();

    	out.println("Ingrese el nombre: ");
    	String pdescripcion = in.readLine();
    	
    	try {
    		(new Gestor()).modificarDescriptor(pcodigo, pdescripcion);
			mostrarMensaje("El descriptor se modifico con exito!");
			
		} catch (Exception e) {
			mostrarMensaje("El descriptor no se encuentra registrado.");
		}
	}
    
	public void eliminarDescriptor() throws IOException {
		out.println("Ingrese el codigo del descriptor: ");
    	String pcodigo = in.readLine();
    	
    	try {
			(new Gestor()).eliminarDescriptor(pcodigo);
			mostrarMensaje("El descriptor se elimino con exito!");
		} catch (Exception e) {
			mostrarMensaje("El descriptor no se encuentra registrado.");
		}
	}
    
	public void listarDescriptores() throws IOException {
		try {
			Vector descriptores = (new Gestor()).listarDescriptores();
			TreeMap datos;
			
			out.println("");
			out.println("LISTA DE DESCRIPTORES");
			out.println("-----------------------------------------------------------------");
			
			for (int i = 0; i < descriptores.size(); i++) {
				datos = ((TreeMap) descriptores.get(i));				
				
				out.println("Codigo: \t" + datos.get("codigo"));
				out.println("Descripcion: \t" + datos.get("descripcion"));	
				out.println("-----------------------------------------------------------------");
			}			
			out.println("");
		} catch (Exception e) {
			mostrarMensaje("No se encontraron descriptores registrados.");
		}
	}
}
