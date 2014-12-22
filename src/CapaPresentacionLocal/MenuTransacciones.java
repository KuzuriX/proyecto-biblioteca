package CapaPresentacionLocal;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Vector;

import CapaLogica.Gestor;
import CapaLogica.Transaccion;

public class MenuTransacciones extends Menu {
	public void mostrarMenu() throws java.io.IOException {
        int opcion;
        boolean volver = false;
        String[] listaMenu = {
        		"1. Crear transaccion",
        		"2. Consultar transacciones por codigo de ejemplar",
        		"0. Volver al menu principal"
        };

        do {
        	out.println();
        	out.println(" MENU TRANSACCIONES");
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
                crearTransaccion();
                break;
            case 2:
            	buscarTransaccionPorCodigoEjemplar();
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
	
	public void crearTransaccion() throws IOException {
    	out.println("Seleccione el tipo de transaccion:");
    	out.println("1. Reporte de salida de libro");
    	out.println("2. Reporte de entrada de libro");
    	out.println("3. Reporte de préstamo de libro");
    	out.println("4. Reporte de devolución de libro");
    	out.println("5. Reporte de reservación de libro");
    	out.println("6. Reporte de libro fuera de uso");
    	int tipo = -1;
    	try {
    		tipo = Integer.parseInt(in.readLine());
    	} catch (Exception e) {
    		mostrarMensaje("Debe ingresar un numero para el tipo de transaccion.");
    		return;
    	}
    	
    	out.println("Ingrese el codigo del ejemplar: ");
    	String idEjemplar = in.readLine();
    	if (idEjemplar.equals("")) {
			mostrarMensaje("El codigo del ejemplar no puede estar vacio.");
			return;
		}
    	
    	out.println("Ingrese una descripcion: ");
    	String descripcion = in.readLine();
    	
    	out.println("Ingrese el identificador del usuario que realiza la transaccion: ");
    	String idUsuario = in.readLine();
    	if (idUsuario.equals("")) {
			mostrarMensaje("La identificacion del usuario no puede estar vacia.");
			return;
		}
		
    	try {
    		mostrarMensaje((new Gestor()).crearTransaccion(tipo, descripcion, idEjemplar, idUsuario));
		} catch (Exception e) {
			mostrarMensaje("Hubo problemas al crear la transaccion.");
			out.println(e);
		}
    }
    
	public void buscarTransaccionPorCodigoEjemplar() throws IOException {
		out.println("Ingrese el codigo del ejemplar: ");
    	String codigo = in.readLine();
    	
		try {
			Vector transacciones = (new Gestor()).buscarTransaccionPorCodigoEjemplar(codigo);
			TreeMap datosTransaccion;
			
			out.println("");
			out.println("CONSULTA DE TRANSACCIONES POR CODIGO DE EJEMPLAR: " + codigo);
			out.println("Resultados encontrados: " + transacciones.size());
			out.println("-----------------------------------------------------------------");			
			for (int i = 0; i < transacciones.size(); i++) {
				datosTransaccion = ((TreeMap) transacciones.get(i));				
				
				out.println("Tipo de transaccion: \t" + datosTransaccion.get("tipo"));
				out.println("Fecha: \t\t\t" + datosTransaccion.get("fecha"));
				out.println("Descripcion: \t\t" + datosTransaccion.get("descripcion"));
				out.println("Ejemplar: \t\t" + datosTransaccion.get("ejemplarCodigo") + " " + 
						datosTransaccion.get("ejemplarTitulo"));
				out.println("Usuario:\t\t" + datosTransaccion.get("usuarioId") + " " + 
						datosTransaccion.get("usuarioNombreCompleto"));
				out.println("-----------------------------------------------------------------");
			}			
			out.println("");
		} catch (Exception e) {
			mostrarMensaje("No se encontraron libros registrados.");
		}
	}
}




