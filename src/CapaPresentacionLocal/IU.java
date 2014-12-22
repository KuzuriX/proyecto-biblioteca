package CapaPresentacionLocal;

import java.io.*;

public class IU extends Menu {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    static MenuAutores menuAutores = new MenuAutores();

    public static void main(String[] args) throws java.io.IOException {
        int opcion;
        boolean salir = false;
        String[] listaMenu = {
        		"1.  Autores",
        		"2.  Descriptores",
        		"3.  Usuarios",
        		"4.  Libros",
        		"5.  Ejemplares",
                "0.  Salir"
        };

        do {
            mostrarMenu(listaMenu);
            opcion = leerOpcion();
            
            switch (opcion) {
	            case 1:
	                menuAutores.mostrarMenuAutores();
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




