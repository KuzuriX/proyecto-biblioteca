package CapaAccesoBD;


import java.net.URL;

/**
 *Clase Conector
 *@version 1.0
 *@author Laura Monge Izaguirre
 *Clase que inicializa la conexi�n con
 *los valores correctos y
 *permite manejar una �nica
 *conexi�n para todo el proyecto y
 *
 */
 
public class Conector{
	//atributo de la clase	
	private static AccesoBD conectorBD = null;
	
	/**
	 *M�todo est�tico que devuelve el 
	 *objeto AccesoBD para que sea utilizado
	 *por las clases
	 *@return objeto del tipo AccesoBD del paquete 
	 *CapaAccesoDatos
	 */
	 
	public static AccesoBD getConector() throws 
	java.sql.SQLException,Exception{
		if (conectorBD == null){			
//			conectorBD = new AccesoBD("sun.jdbc.odbc.JdbcOdbcDriver","jdbc:odbc:BDLibros","","");
			//conectorBD = new AccesoBD("jdbc:ucanaccess:///Users/elizabeth/git/proyecto-biblioteca/src/BaseDeDatos/BDLibros.accdb", "", "");
			conectorBD = new AccesoBD("jdbc:ucanaccess:///Users/miguel/Google Drive/CENFOTEC/Progra2/proyecto-biblioteca/src/BaseDeDatos/BDLibros.accdb", "", "");
		}
		return conectorBD;
	}
	
	private static String rutaBaseDatos() {
		
		try {
			URL url = Conector.class.getResource("/BaseDatos/BDPinturas.accdb"); 
	        return url.toString();
		} catch (Exception e) {
			System.out.println("Lel");
		}
		
		return "";
    }
	
    private static String formatearRuta(String path) {
    	return path.replace("file:/", "");
    }
	
}