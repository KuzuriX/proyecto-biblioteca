package CapaLogica;

import java.time.LocalDate;
import java.util.*;

	public class Gestor2 {
	public void libroAgregar(String pisbn, String ptitulo, int pvolumen, String peditorial, LocalDate pfechaPublicacion, String ptipo) throws Exception {
		Libro libro;
		libro = (new MultiLibro()).crear(pisbn, ptitulo, pvolumen, peditorial, pfechaPublicacion, ptipo);
	}
	
	public TreeMap libroBuscar(String pisbn) throws Exception {
		TreeMap datos = null;
		Libro libro=null;
		String nombre;
		datos = new TreeMap();
		libro = (new MultiLibro()).buscar(pisbn);
		datos.put("titulo", libro.getTitulo());
		datos.put("volumen", libro.getVolumen());
		datos.put("editorial", libro.getEditorial());
		datos.put("fechaPublicacion", libro.getFechaPublicacion());
		datos.put("tipo", libro.obtenerTipo());
		return datos;
	}
		
	public Vector clienteBuscarPorNombre(String pnombre) throws Exception {
		Vector clientes=null;
		Vector datosClientes=null;
		Cliente client;
		clientes = (new MultiCliente()).buscarPorNombre(pnombre);
		datosClientes = new Vector();
		for (int i=0; i<clientes.size(); i++) {
			client = ((Cliente) clientes.get(i));
			TreeMap datosCliente = new TreeMap();
			datosCliente.put("nombre", client.getNombre());
			datosCliente.put("identificacion", client.getId());
			datosClientes.add(datosCliente);
		}
		return datosClientes;
	}
	
	public Vector clienteBuscarCuentas(String pidCliente) throws Exception{
		Cliente client;
		Cuenta cuent;
		Vector cuentas=null;
		Vector datosCuentas = new Vector();
		client = (new MultiCliente()).buscar(pidCliente);
		cuentas = client.getCuentas();
		for (int i=0; i<cuentas.size(); i++) {
			cuent = ((Cuenta) cuentas.get(i));
			TreeMap datosCuenta = new TreeMap();
			datosCuenta.put("numero", cuent.getNumero());
			datosCuenta.put("descripcion", cuent.getDescripcion());
			datosCuenta.put("fechaVencimiento", cuent.getFechaVencimiento());
			datosCuenta.put("monto", ""+cuent.getMonto());
			datosCuenta.put("saldo", ""+cuent.getSaldo());
			datosCuenta.put("idCliente", cuent.getIdCliente());
			datosCuentas.add(datosCuenta);
		}
		return datosCuentas;
	}
	
	public void clienteBorrar(String pidCliente) throws Exception {
		Cliente client;
		client = (new MultiCliente()).buscar(pidCliente);
		(new MultiCliente()).borrar(client);
	}
	
	public void clienteModificar(String pidentificacion, String pnombre) throws Exception {
		Cliente client;
		client = (new MultiCliente()).buscar(pidentificacion);
		client.setNombre(pnombre);
		(new MultiCliente()).actualizar(client);
	}
	
	public void cuentaAgregar(String pnumero, String pdescripcion, String pfechaVencimiento, 
			double pmonto, String pidCliente) throws Exception {
		Cliente client;
		client = (new MultiCliente()).buscar(pidCliente);
		client.agregarCuenta(pnumero, pdescripcion, pfechaVencimiento,pmonto);
	}

	public void cuentaModificar(String pnumero, String pdescripcion, String pfechaVencimiento) throws Exception {
		Cuenta cuent;
		cuent = (new MultiCuenta()).buscar(pnumero);
		cuent.setDescripcion(pdescripcion);
		cuent.setFechaVencimiento(pfechaVencimiento);
		(new MultiCuenta()).actualizar(cuent);
	}

	public void cuentaAplicarAbono(String pnumCuenta, double pmontoAbono) throws Exception{
		Abono abono;
		Cuenta cuent;
		cuent = (new MultiCuenta()).buscar(pnumCuenta);
		abono = cuent.aplicarAbono(pmontoAbono);
	}
	
	public Vector cuentaBuscarAbonos(String pnumCuenta) throws Exception {
		Cuenta cuent=null;
		
		Abono abono=null;
		Vector abonos=null;
		Vector datosAbonos = new Vector();
		cuent = (new MultiCuenta()).buscar(pnumCuenta);
		abonos = cuent.getAbonos();
		for (int i=0; i<abonos.size(); i++) {
			abono = ((Abono) abonos.get(i));
			TreeMap datosAbono = new TreeMap();
			datosAbono.put("numeroAbono", ""+abono.getNumeroAbono());
			datosAbono.put("monto", ""+abono.getMonto());
			datosAbono.put("fecha", abono.getFecha());
			datosAbonos.add(datosAbono);
		}
		return datosAbonos;		

	}
	
	public TreeMap cuentaBuscar(String pnumero) throws Exception {
		Cuenta cuent=null;
		TreeMap datos = new TreeMap ();
		cuent = (new MultiCuenta()).buscar(pnumero);
		datos.put("numero", cuent.getNumero());
		datos.put("descripcion", cuent.getDescripcion());
		datos.put("fechaVencimiento", cuent.getFechaVencimiento());
		datos.put("monto", ""+cuent.getMonto());
		datos.put("saldo", ""+cuent.getSaldo());
		Cliente client;
		client = cuent.getCliente();
		datos.put("idCliente", client.getId());
		datos.put("nombreCliente",client.getNombre());
		return datos;
	}
	
	public void cuentaBorrar(String pnumero) throws Exception {
		Cuenta cuent;
		cuent = (new MultiCuenta()).buscar(pnumero);
		(new MultiCuenta()).borrar(cuent);
	}

}