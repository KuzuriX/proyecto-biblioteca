package CapaPresentacionLocal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Menu {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    
	static void mostrarMenu(String[] plista) {
        out.println();

        for (int i=0;i<plista.length;i++) {
            out.println(plista[i]);
        }
        out.println();
    }

    static int leerOpcion() throws java.io.IOException{
        int opcion;

        out.print("Seleccione una opcion: ");
        opcion = Integer.parseInt(in.readLine());

        return opcion;
    }
    
    static void mostrarMensaje(String pmensaje) {
    	out.println("");
    	out.println("-------------------------------------------");
		out.println(" " + pmensaje);
		out.println("-------------------------------------------");
		out.println("");
    }
}
