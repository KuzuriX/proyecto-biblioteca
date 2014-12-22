package CapaPresentacionLocal;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Vector;

import CapaLogica.Ejemplar;
import CapaLogica.Gestor;

public class MenuEjemplares extends Menu {
	public void mostrarMenu() throws java.io.IOException {
        int opcion;
        boolean volver = false;
        String[] listaMenu = {
        		"1. Crear ejemplar",
        		"2. Modificar ejemplar",
        		"3. Eliminar ejemplar",
        		"4. Listar ejemplares",
        		"5. Consultar ejemplar por codigo",
        		"6. Consultar ejemplar por ISBN",
        		"7. Consultar ejemplar por titulo",
        		"8. Consultar ejemplar por autor",
        		"9. Consultar ejemplar por descriptor",
                "0. Volver al menu principal"
        };

        do {
        	clearConsole();
        	out.println();
        	out.println(" MENU EJEMPLARES");
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
                crearEjemplar();
                break;
            case 2:
                modificarEjemplar();
                break;                
            case 3:
                eliminarEjemplar();
                break;            
            case 4:
                listarEjemplares();
                break;
            case 5:
                consultarEjemplarPorCodigo();
                break;
            case 6:
                consultarEjemplarPorISBN();
                break;
            case 7:
                consultarEjemplarPorTitulo();
                break;
            case 8:
                consultarEjemplarPorAutor();
                break;
            case 9:
                consultarEjemplarPorDescriptor();
                break;
            case 0: 
            	volver = true;
            	break;
            default: // Cualquier otro valor dado por el ejemplar se considera invalido
                out.println("Opcion invalida.");
                out.println();
                break;
        }
        
        return volver;
    }
	
	public void crearEjemplar() throws IOException {
		out.println("Ingrese el ISBN del libro del cual es un ejemplar: ");
    	String isbn = in.readLine();
    	
		out.println("Ingrese el codigo del ejemplar: ");
    	String codigo = in.readLine();

    	out.println("Ingrese el estado fisico (0: Excelente, 1: Bueno, 2: Malo): ");
    	int estado = Integer.parseInt(in.readLine());
    	String estadoFisico;
    	switch (estado) {
			case 0:
				estadoFisico = "Excelente";
				break;
			case 1:
				estadoFisico = "Bueno";
				break;
			case 2:
				estadoFisico = "Malo";
				break;
			default:
				out.println("Debe seleccionar un estado fisico valido");
				return;
		}
    	
    	out.println("Ingrese la fecha de ingreso: (yyyy-MM-dd)");
    	String fecha = in.readLine();
    	LocalDate fechaIngreso = LocalDate.parse(fecha);
    	
    	out.println("Ingrese la condicion actual del ejemplar (0: Libre, 1: Prestado, 2: Reservado, 3: Reparacion, 4: Fuera de uso, 5: Perdido): ");
    	int condicion = Integer.parseInt(in.readLine());
    	String condicionActual;
    	switch (condicion) {
			case 0:
				condicionActual = "Libre";
				break;
			case 1:
				condicionActual = "Prestado";
				break;
			case 2:
				condicionActual = "Reservado";
				break;
			case 3:
				condicionActual = "Reparacion";
				break;
			case 4:
				condicionActual = "Fuera de uso";
				break;
			case 5:
				condicionActual = "Perdido";
				break;
			default:
				out.println("Debe seleccionar una condicion actual valida");
				return;
		}
    	
    	try {
			(new Gestor()).crearEjemplar(isbn, codigo, estadoFisico, fechaIngreso, condicionActual);
			mostrarMensaje("El ejemplar se agrego con exito!");
		} catch (Exception e) {
			mostrarMensaje("El ejemplar ya se encuentra registrado.");
			out.println(e);
		}
    }
    
	public void modificarEjemplar() throws IOException {
		out.println("Ingrese el codigo del ejemplar que desea modificar: ");
    	String codigo = in.readLine();

    	out.println("Ingrese el ISBN del libro del cual es un ejemplar: ");
    	String isbn = in.readLine();
    	
    	out.println("Ingrese el estado fisico (0: Excelente, 1: Bueno, 2: Malo): ");
    	int estado = Integer.parseInt(in.readLine());
    	String estadoFisico;
    	switch (estado) {
			case 0:
				estadoFisico = "Excelente";
				break;
			case 1:
				estadoFisico = "Bueno";
				break;
			case 2:
				estadoFisico = "Malo";
				break;
			default:
				out.println("Debe seleccionar un estado fisico valido");
				return;
		}
    	
    	out.println("Ingrese la fecha de ingreso: (yyyy-MM-dd)");
    	String fecha = in.readLine();
    	LocalDate fechaIngreso = LocalDate.parse(fecha);
    	
    	out.println("Ingrese la condicion actual del ejemplar (0: Libre, 1: Prestado, 2: Reservado, 3: Reparacion, 4: Fuera de uso, 5: Perdido): ");
    	int condicion = Integer.parseInt(in.readLine());
    	String condicionActual;
    	switch (condicion) {
			case 0:
				condicionActual = "Libre";
				break;
			case 1:
				condicionActual = "Prestado";
				break;
			case 2:
				condicionActual = "Reservado";
				break;
			case 3:
				condicionActual = "Reparacion";
				break;
			case 4:
				condicionActual = "Fuera de uso";
				break;
			case 5:
				condicionActual = "Perdido";
				break;
			default:
				out.println("Debe seleccionar una condicion actual valida");
				return;
		}
    	
    	try {
			(new Gestor()).modificarEjemplar(isbn, codigo, estadoFisico, fechaIngreso, condicionActual);
			mostrarMensaje("El ejemplar se modifico con exito!");
		} catch (Exception e) {
			mostrarMensaje("El ejemplar no se encuentra registrado.");
		}
	}
    
	public void eliminarEjemplar() throws IOException {
		out.println("Ingrese el codigo del ejemplar: ");
    	String codigo = in.readLine();
    	
    	try {
			(new Gestor()).eliminarEjemplar(codigo);
			mostrarMensaje("El ejemplar se elimino con exito!");
		} catch (Exception e) {
			mostrarMensaje("El ejemplar no se encuentra registrado.");
		}
	}
    
	public void listarEjemplares() throws IOException {
		try {
			Vector ejemplares = (new Gestor()).listarEjemplares();
			TreeMap datosEjemplar;
			
			out.println("");
			out.println("LISTA DE EJEMPLARES");
			out.println("-----------------------------------------------------------------");
			
			for (int i = 0; i < ejemplares.size(); i++) {
				datosEjemplar = ((TreeMap) ejemplares.get(i));
				imprimirEjemplar(datosEjemplar);
			}
		} catch (Exception e) {
			out.println(e);
			mostrarMensaje("No se encontraron ejemplares registrados.");
		}
	}
	
	public void consultarEjemplarPorCodigo() throws IOException {
		out.println("Ingrese el codigo del ejemplar a buscar: ");
    	String codigo = in.readLine();
		
		try {
			TreeMap datosEjemplar = (new Gestor()).buscarEjemplar(codigo);
			
			out.println("");
			out.println("BUSQUEDA DE EJEMPLAR POR CODIGO: " + codigo);
			out.println("-----------------------------------------------------------------");				
			imprimirEjemplar(datosEjemplar);
		} catch (Exception e) {
			out.println(e);
			mostrarMensaje("No se encontro el ejemplar consultado.");
		}
	}
	
	public void consultarEjemplarPorISBN() throws IOException {
		out.println("Ingrese el ISBN del ejemplar a buscar: ");
    	String isbn = in.readLine();
		
		try {
			TreeMap datosEjemplar = (new Gestor()).buscarEjemplarPorISBN(isbn);
			
			out.println("");
			out.println("BUSQUEDA DE EJEMPLAR POR IBSN: " + isbn);
			out.println("-----------------------------------------------------------------");				
			imprimirEjemplar(datosEjemplar);
		} catch (Exception e) {
			out.println(e);
			mostrarMensaje("No se encontro el ejemplar consultado.");
		}
	}
	
	public void consultarEjemplarPorTitulo() throws IOException {
		out.println("Ingrese el titulo del ejemplar a buscar: ");
    	String titulo = in.readLine();
		
		try {
			Vector resultados = (new Gestor()).buscarEjemplarPorTitulo(titulo);
			
			out.println("");
			out.println("BUSQUEDA DE EJEMPLAR POR TITULO: '" + titulo + "'");
			out.println("Resultados encontrados: " + resultados.size());
			out.println("-----------------------------------------------------------------");
			for (int i = 0; i < resultados.size(); i++) {
				imprimirEjemplar((TreeMap) resultados.get(i));
			}
			
		} catch (Exception e) {
			out.println(e);
			mostrarMensaje("No se encontro el ejemplar consultado.");
		}
	}
	
	public void consultarEjemplarPorAutor() throws IOException {
		out.println("Ingrese el nombre del autor del ejemplar a buscar: ");
    	String autor = in.readLine();
		
		try {
			Vector resultados = (new Gestor()).buscarEjemplarPorAutor(autor);
			
			out.println("");
			out.println("BUSQUEDA DE EJEMPLAR POR AUTOR: '" + autor + "'");
			out.println("Resultados encontrados: " + resultados.size());
			out.println("-----------------------------------------------------------------");
			for (int i = 0; i < resultados.size(); i++) {
				imprimirEjemplar((TreeMap) resultados.get(i));
			}
		} catch (Exception e) {
			out.println(e);
			mostrarMensaje("No se encontro el ejemplar consultado.");
		}
	}
	
	public void consultarEjemplarPorDescriptor() throws IOException {
		out.println("Ingrese el descriptor (descripcion) del ejemplar a buscar: ");
    	String descriptor = in.readLine();
		
		try {
			Vector resultados = (new Gestor()).buscarEjemplarPorDescriptor(descriptor);
			
			out.println("");
			out.println("BUSQUEDA DE EJEMPLAR POR DESCRIPTOR: '" + descriptor + "'");
			out.println("Resultados encontrados: " + resultados.size());
			out.println("-----------------------------------------------------------------");
			for (int i = 0; i < resultados.size(); i++) {
				imprimirEjemplar((TreeMap) resultados.get(i));
			}
		} catch (Exception e) {
			out.println(e);
			mostrarMensaje("No se encontro el ejemplar consultado.");
		}
	}
	
	private void imprimirEjemplar(TreeMap datosEjemplar) {
		out.println("Codigo: \t\t" + datosEjemplar.get("codigo"));
		out.println("Estado Fisico: \t\t" + datosEjemplar.get("estadoFisico"));
		out.println("Fecha ingreso: \t\t" + datosEjemplar.get("fechaIngreso"));
		out.println("Condicion actual: \t" + datosEjemplar.get("condicionActual"));
		out.println();
			
		// Imprimir la informacion del libro
		out.println("Es un ejemplar del libro:");
		out.println("\tISBN: \t\t\t" + datosEjemplar.get("isbn"));
		out.println("\tTitulo: \t\t" + datosEjemplar.get("titulo"));
		out.println("\tVolumen: \t\t" + datosEjemplar.get("volumen"));
		out.println("\tEditorial: \t\t" + datosEjemplar.get("editorial"));
		out.println("\tFecha de publicacion: \t" + datosEjemplar.get("fechaPublicacion"));
		out.println("\tTipo: \t\t\t" + datosEjemplar.get("tipo"));
			
		// Imprimir el autor(es) del libro
		ArrayList<String> autores = (ArrayList<String>) datosEjemplar.get("idsAutores");
		String listaAutores = "";
		for (int j = 0; j < autores.size(); j++) {
			listaAutores += autores.get(j) + " / ";
		}
		out.println("\tAutores:\t\t" + listaAutores);
			
		// Imprimir el descriptor(es) del libro
		ArrayList<String> descriptores = (ArrayList<String>) datosEjemplar.get("idsDescriptores");
		String listaDescriptores = "";
		for (int k = 0; k < descriptores.size(); k++) {
			listaDescriptores += descriptores.get(k) + " / ";
		}
		out.println("\tDescriptores:\t\t" + listaDescriptores);
		out.println("-----------------------------------------------------------------");			
		out.println();
	}
}




