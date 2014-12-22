package CapaPresentacionLocal;

import java.io.*;

public class IU extends Menu {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    
    static MenuAutores menuAutores = new MenuAutores();
    static MenuDescriptores menuDescriptores = new MenuDescriptores();
    static MenuLibros menuLibros = new MenuLibros();
    static MenuUsuarios menuUsuarios = new MenuUsuarios();
    static MenuEjemplares menuEjemplares = new MenuEjemplares();

    public static void main(String[] args) throws java.io.IOException {
        int opcion;
        boolean salir = false;
        String[] listaMenu = {
        		"1.  Autores",
        		"2.  Descriptores",
        		"3.  Libros",
        		"4.  Ejemplares",
        		"5.  Usuarios",
                "0.  Salir"
        };

        do {
        	out.println();
        	out.println(" MENU PRINCIPAL");
        	out.println("---------------------------");
            mostrarMenu(listaMenu);
            opcion = leerOpcion();
            
            switch (opcion) {
	            case 1:
	                menuAutores.mostrarMenu();
	                break;
	            case 2:
	                menuDescriptores.mostrarMenu();
	                break;
	            case 3:
	                menuLibros.mostrarMenu();
	                break;
	            case 4:
	                menuEjemplares.mostrarMenu();
	                break;
	            case 5:
	                menuUsuarios.mostrarMenu();
	                break;
	                
	            case 0:
	                salir = true;
	                out.println("Adios.");
	                break;
	
	            default: // Cualquier otro valor dado por el usuario se considera invalido
	                out.println("Opcion invalida.");
	                out.println();
	                break;
	        }
        } while (!salir);
    }
}




