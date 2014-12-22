package CapaPresentacionLocal;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Vector;

import CapaLogica.Gestor;

public class MenuLibros extends Menu {
	public void mostrarMenu() throws java.io.IOException {
        int opcion;
        boolean volver = false;
        String[] listaMenu = {
        		"1. Crear libro",
        		"2. Modificar libro",
        		"3. Eliminar libro",
        		"4. Listar libros",
        		"5. Asociar un autor a un libro",
        		"6. Asociar un descriptor a un libro",
        		"7. Consultar libro por ISBN",
                "0. Volver al menu principal"
        };

        do {
        	out.println();
        	out.println(" MENU LIBROS");
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
                crearLibro();
                break;
            case 2:
                modificarLibro();
                break;                
            case 3:
                eliminarLibro();
                break;            
            case 4:
                listarLibros();
                break;
            case 5:
                asociarAutorLibro();
                break;
            case 6:
                asociarDescriptorLibro();
                break;
            case 0: 
            	volver = true;
            	break;
            default: // Cualquier otro valor dado por el libro se considera invalido
                out.println("Opcion invalida.");
                out.println();
                break;
        }
        
        return volver;
    }
	
	public void crearLibro() throws IOException {
    	out.println("Ingrese el ISBN: ");
    	String isbn = in.readLine();
    	if (isbn.equals("")) {
			mostrarMensaje("El ISBN del libro no puede estar vacia.");
			return;
		}
    	out.println("Ingrese el titulo: ");
    	String titulo = in.readLine();
    	if (titulo.equals("")) {
			mostrarMensaje("El titulo del libro no puede estar vacio.");
			return;
		}
    	out.println("Ingrese el volumen: ");
    	int volumen = -1;
    	try {
    		volumen = Integer.parseInt(in.readLine());
    	} catch (Exception e) {
    		mostrarMensaje("El volumen del libro debe ser un numero.");
    		return;
    	}
    	
    	out.println("Ingrese la editorial: ");
    	String editorial = in.readLine();
    	if (editorial.equals("")) {
			mostrarMensaje("La editorial del libro no puede estar vacia.");
			return;
		}    	
    	out.println("Ingrese la fecha de publicacion: (yyyy-MM-dd)");
    	String fecha = in.readLine();
    	LocalDate fechaPublicacion;
    	try {
    		fechaPublicacion = LocalDate.parse(fecha);
    	} catch (Exception e) {
    		mostrarMensaje("La fecha de publicacion debe respetar el formato indicado.");
    		return;
    	}   	
    	
    	out.println("Ingrese el tipo de libro (0: Reserva, 1: Prestamo): ");
    	int tipo = -1;
    	try {
    		tipo = Integer.parseInt(in.readLine());
    	} catch (Exception e) {
    		mostrarMensaje("El tipo de libro debe ser uno de los numeros indicados anteriormente.");
    		return;
    	}
		String tipoLibro = "";
		switch (tipo) {
			case 0:
				tipoLibro = "Reserva";
				break;
			case 1:
				tipoLibro = "Prestamo";
				break;
			default:
				mostrarMensaje("Debe seleccionar una opcion valida, ya sea 0 o 1.");
				break;
		}
		
    	try {
			(new Gestor()).crearLibro(isbn, titulo, volumen, editorial, fechaPublicacion, tipoLibro);
			mostrarMensaje("El libro se agrego con exito!");
		} catch (Exception e) {
			mostrarMensaje("El libro ya se encuentra registrado.");
			out.println(e);
		}
    }
    
	public void modificarLibro() throws IOException {
		out.println("Ingrese el ISBN del libro a modificar: ");
		String isbn = in.readLine();
    	if (isbn.equals("")) {
			mostrarMensaje("Debe ingresar el ISBN del libro que desea modificar.");
			return;
		}
    	out.println("Ingrese el titulo: ");
    	String titulo = in.readLine();
    	if (titulo.equals("")) {
			mostrarMensaje("El titulo del libro no puede estar vacio.");
			return;
		}
    	out.println("Ingrese el volumen: ");
    	int volumen = -1;
    	try {
    		volumen = Integer.parseInt(in.readLine());
    	} catch (Exception e) {
    		mostrarMensaje("El volumen del libro debe ser un numero.");
    		return;
    	}
    	
    	out.println("Ingrese la editorial: ");
    	String editorial = in.readLine();
    	if (editorial.equals("")) {
			mostrarMensaje("La editorial del libro no puede estar vacia.");
			return;
		}    	
    	out.println("Ingrese la fecha de publicacion: (yyyy-MM-dd)");
    	String fecha = in.readLine();
    	LocalDate fechaPublicacion;
    	try {
    		fechaPublicacion = LocalDate.parse(fecha);
    	} catch (Exception e) {
    		mostrarMensaje("La fecha de publicacion debe respetar el formato indicado.");
    		return;
    	}   	
    	
    	out.println("Ingrese el tipo de libro (0: Reserva, 1: Prestamo): ");
    	int tipo = -1;
    	try {
    		tipo = Integer.parseInt(in.readLine());
    	} catch (Exception e) {
    		mostrarMensaje("El tipo de libro debe ser uno de los numeros indicados anteriormente.");
    		return;
    	}
		String tipoLibro = "";
		switch (tipo) {
			case 0:
				tipoLibro = "Reserva";
				break;
			case 1:
				tipoLibro = "Prestamo";
				break;
			default:
				mostrarMensaje("Debe seleccionar una opcion valida, ya sea 0 o 1.");
				break;
		}
    	
    	try {
    		(new Gestor()).modificarLibro(isbn, titulo, volumen, editorial, fechaPublicacion, tipoLibro);
			mostrarMensaje("El libro se modifico con exito!");
			
		} catch (Exception e) {
			mostrarMensaje("El libro no se encuentra registrado.");
		}
	}
    
	public void eliminarLibro() throws IOException {
		out.println("Ingrese el ISBN del libro: ");
		String isbn = in.readLine();
    	if (isbn.equals("")) {
			mostrarMensaje("Debe ingresar el ISBN del libro que desea eliminar.");
			return;
		}
    	
    	try {
			(new Gestor()).eliminarLibro(isbn);
			mostrarMensaje("El libro se elimino con exito!");
		} catch (Exception e) {
			mostrarMensaje("El libro no se encuentra registrado.");
		}
	}
    
	public void listarLibros() throws IOException {
		try {
			Vector libros = (new Gestor()).listarLibros();
			TreeMap datosLibro;
			
			out.println("");
			out.println("LISTA DE LIBROS");
			out.println("-----------------------------------------------------------------");
			
			for (int i = 0; i < libros.size(); i++) {
				datosLibro = ((TreeMap) libros.get(i));				
				
				out.println("ISBN: \t\t\t" + datosLibro.get("isbn"));
				out.println("Titulo: \t\t" + datosLibro.get("titulo"));
				out.println("Volumen: \t\t" + datosLibro.get("volumen"));
				out.println("Editorial: \t\t" + datosLibro.get("editorial"));
				out.println("Fecha de publicacion: \t" + datosLibro.get("fechaPublicacion"));
				out.println("Tipo: \t\t\t" + datosLibro.get("tipo"));
				
				// Imprimir el autor(es) del libro
				out.println("Autores:");
				ArrayList<String> autores = (ArrayList<String>) datosLibro.get("idsAutores");
				for (int j = 0; j < autores.size(); j++) {
					out.println("\t\t\t" + autores.get(j));
				}
				
				// Imprimir el descriptor(es) del libro
				out.println("Descriptores:");
				ArrayList<String> descriptores = (ArrayList<String>) datosLibro.get("idsDescriptores");
				for (int k = 0; k < descriptores.size(); k++) {
					out.println("\t\t\t" + descriptores.get(k));
				}				
				out.println("-----------------------------------------------------------------");
			}			
			out.println("");
		} catch (Exception e) {
			mostrarMensaje("No se encontraron libros registrados.");
		}
	}
	
	public void asociarAutorLibro() throws IOException {
		out.println("Ingrese el ISBN del libro: ");
		String isbn = in.readLine();
    	if (isbn.equals("")) {
			mostrarMensaje("Debe ingresar el ISBN del libro.");
			return;
		}

    	out.println("Ingrese el identificador del autor: ");
    	String idAutor = in.readLine();
    	if (idAutor.equals("")) {
			mostrarMensaje("Debe ingresar el identificador del autor que se va a asociar al libro.");
			return;
		}
    	
		try {
			mostrarMensaje((new Gestor()).asociarAutorLibro(isbn, idAutor));
		} catch (Exception e) {
			mostrarMensaje("No se pudo asociar el autor al libro.");
		}
	}
	
	public void asociarDescriptorLibro() throws IOException {
		out.println("Ingrese el ISBN del libro: ");
		String isbn = in.readLine();
    	if (isbn.equals("")) {
			mostrarMensaje("Debe ingresar el ISBN del libro.");
			return;
		}
    	out.println("Ingrese el codigo del descriptor: ");
    	String codigoDesc = in.readLine();
    	if (codigoDesc.equals("")) {
			mostrarMensaje("Debe ingresar el codigo del descriptor que se va a asociar al libro.");
			return;
		}
    	
		try {
			mostrarMensaje((new Gestor()).asociarDescriptorLibro(isbn, codigoDesc));
		} catch (Exception e) {
			mostrarMensaje("No se pudo asociar el descriptor al libro.");
		}
	}
}



