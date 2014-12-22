package CapaPresentacionLocal;

import java.io.IOException;
import java.util.TreeMap;
import java.util.Vector;

import CapaLogica.Usuario;
import CapaLogica.Gestor;

public class MenuUsuarios extends Menu {
	public void mostrarMenu() throws java.io.IOException {
        int opcion;
        boolean volver = false;
        String[] listaMenu = {
        		"1. Crear usuario",
        		"2. Modificar usuario",
        		"3. Eliminar usuario",
        		"4. Listar usuarios",
        		"5. Cambiar estado",
        		"6. Consultar usuario",
                "0. Volver al menu principal"
        };

        do {
        	out.println();
        	out.println(" MENU USUARIOS");
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
                crearUsuario();
                break;
            case 2:
                modificarUsuario();
                break;                
            case 3:
                eliminarUsuario();
                break;            
            case 4:
                listarUsuarios();
                break;
            case 5:
                cambiarEstado();
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
	
	public void crearUsuario() throws IOException {
    	out.println("Ingrese la identificacion: ");
    	String pid = in.readLine();
    	if (pid.equals("")) {
			mostrarMensaje("La identificacion del usuario no puede estar vacia.");
			return;
		}
    	out.println("Ingrese el nombre: ");
    	String pnombre = in.readLine();
    	if (pnombre.equals("")) {
			mostrarMensaje("El nombre del usuario no puede estar vacio.");
			return;
		}    	
    	out.println("Ingrese el apellido: ");
    	String papellido = in.readLine();
    	if (papellido.equals("")) {
			mostrarMensaje("El apellido del usuario no puede estar vacio.");
			return;
		} 
    	out.println("Ingrese la direccion electronica: ");
    	String pdirElectronica = in.readLine();
    	if (pdirElectronica.equals("")) {
			mostrarMensaje("La direccion electronica del usuario no puede estar vacia.");
			return;
		} 
    	out.println("Ingrese la direccion fisica: ");
    	String pdireccion = in.readLine();
    	if (pdireccion.equals("")) {
			mostrarMensaje("La direccion fisica del usuario no puede estar vacia.");
			return;
		}    	
    	out.println("Ingrese el telefono: ");
		String ptelefono = in.readLine();
		if (ptelefono.equals("")) {
			mostrarMensaje("El telefono del usuario no puede estar vacio.");
			return;
		}
		
    	try {
			(new Gestor()).crearUsuario(pid, pnombre, papellido, pdirElectronica, pdireccion, ptelefono);
			mostrarMensaje("El usuario se agrego con exito!");
		} catch (Exception e) {
			mostrarMensaje("El usuario ya se encuentra registrado.");
			out.println(e);
		}
    }
    
	public void modificarUsuario() throws IOException {
		out.println("Ingrese la identificacion del usuario a modificar: ");
		String pid = in.readLine();
    	if (pid.equals("")) {
			mostrarMensaje("Debe ingresar una identificacion.");
			return;
		}
    	out.println("Ingrese el nombre: ");
    	String pnombre = in.readLine();
    	if (pnombre.equals("")) {
			mostrarMensaje("El nombre del usuario no puede estar vacio.");
			return;
		}    	
    	out.println("Ingrese el apellido: ");
    	String papellido = in.readLine();
    	if (papellido.equals("")) {
			mostrarMensaje("El apellido del usuario no puede estar vacio.");
			return;
		} 
    	out.println("Ingrese la direccion electronica: ");
    	String pdirElectronica = in.readLine();
    	if (pdirElectronica.equals("")) {
			mostrarMensaje("La direccion electronica del usuario no puede estar vacia.");
			return;
		} 
    	out.println("Ingrese la direccion fisica: ");
    	String pdireccion = in.readLine();
    	if (pdireccion.equals("")) {
			mostrarMensaje("La direccion fisica del usuario no puede estar vacia.");
			return;
		}    	
    	out.println("Ingrese el telefono: ");
		String ptelefono = in.readLine();
		if (ptelefono.equals("")) {
			mostrarMensaje("El telefono del usuario no puede estar vacio.");
			return;
		}
    	
    	try {
    		(new Gestor()).modificarUsuario(pid, pnombre, papellido, pdirElectronica, pdireccion, ptelefono);
			mostrarMensaje("El usuario se modifico con exito!");
			
		} catch (Exception e) {
			mostrarMensaje("El usuario no se encuentra registrado.");
		}
	}
    
	public void eliminarUsuario() throws IOException {
		out.println("Ingrese la identificacion del usuario: ");
    	String pid = in.readLine();
    	if (pid.equals("")) {
			mostrarMensaje("Debe ingresar una identificacion del usuario a eliminar.");
			return;
		}
    	
    	try {
			(new Gestor()).eliminarUsuario(pid);
			mostrarMensaje("El usuario se elimino con exito!");
		} catch (Exception e) {
			mostrarMensaje("El usuario no se encuentra registrado.");
		}
	}
    
	public void listarUsuarios() throws IOException {
		try {
			Vector usuarios = (new Gestor()).listarUsuarios();
			TreeMap datosUsuario;
			
			out.println("");
			out.println("LISTA DE USUARIOS");
			out.println("-----------------------------------------------------------------");
			
			for (int i = 0; i < usuarios.size(); i++) {
				datosUsuario = ((TreeMap) usuarios.get(i));				
				
				out.println("Identificacion: \t" + datosUsuario.get("id"));
				out.println("Nombre: \t\t" + datosUsuario.get("nombre"));
				out.println("Apellido: \t\t" + datosUsuario.get("apellido"));
				out.println("Direccion electronica: \t" + datosUsuario.get("dirElectronica"));
				out.println("Direccion: \t\t" + datosUsuario.get("direccion"));
				out.println("Telefono: \t\t" + datosUsuario.get("telefono"));
				out.println("Estado: \t\t" + datosUsuario.get("estado"));	
				out.println("-----------------------------------------------------------------");
			}			
			out.println("");
		} catch (Exception e) {
			mostrarMensaje("No se encontraron usuarios registrados.");
		}
	}

	public void cambiarEstado() throws IOException {
		out.println("Ingrese la identificacion del usuario a modificar: ");
		String pid = in.readLine();
		if (pid.equals("")) {
			mostrarMensaje("Debe ingresar la identificacion del usuario a modificar.");
			return;
		}

    	out.println("Ingrese el estado: (0: Normal, 1:Moroso) ");
    	int estado = -1;
    	try {
    		estado = Integer.parseInt(in.readLine());
    	} catch (Exception e) {
    		mostrarMensaje("No se ingreso un numero.");
    		return;
    	}
		String pestado = "";
		switch (estado) {
			case 0:
				pestado = "Normal";
				break;
			case 1:
				pestado = "Moroso";
				break;
			default:
				mostrarMensaje("Debe seleccionar una opcion valida, ya sea 0 o 1.");
				break;
		}				
    	
		if (!pestado.equals("")) {
	    	try {
	    		(new Gestor()).cambiarEstadoUsuario(pid, pestado);
				mostrarMensaje("El usuario se modifico con exito!");
			} catch (Exception e) {
				mostrarMensaje("El usuario no se encuentra registrado.");
			}
		}
	}
}

