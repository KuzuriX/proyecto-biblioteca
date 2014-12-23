package CapaLogica;

public class Biblioteca {
	private int maxDiasPrestamo;
	private double multaPorDiaMorosidad;
	private static int id;
	
	/**
	 * Constructor
	 * @param pmaxDiasPrestamo		Maximo de dias que la biblioteca presta libros.
	 * @param pmultaPorMorosidad	Monto de multa por dia por morosidad.
	 */	
	public Biblioteca(int pmaxDiasPrestamo, double pmultaPorDiaMorosidad) {
		setMaxDiasPrestamo(pmaxDiasPrestamo);
		setMultaPorMorosidad(pmultaPorDiaMorosidad);
		setId(id++);
	}

	/**
	 * getMaxDiasPrestamo
	 * @return int Maxima cantidad de dias que la biblioteca presta libros.
	 */
	public int getMaxDiasPrestamo() {
		return maxDiasPrestamo;
	}

	/**
	 * @return the id
	 */
	public static int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public static void setId(int id) {
		Biblioteca.id = id;
	}

	/**
	 * setMaxDiasPrestamo
	 * @param maxDiasPrestamo Maxima cantidad de dias que la biblioteca presta libros.
	 */
	public void setMaxDiasPrestamo(int maxDiasPrestamo) {
		this.maxDiasPrestamo = maxDiasPrestamo;
	}

	/**
	 * getMultaPorMorosidad
	 * @return double Monto por dia que se cobra por morosidad.
	 */
	public double getMultaPorMorosidad() {
		return multaPorDiaMorosidad;
	}

	/**
	 * setMultaPorMorosidad
	 * @param pmultaPorDiaMorosidad Monto por dia que se cobra por morosidad.
	 */
	public void setMultaPorMorosidad(double pmultaPorDiaMorosidad) {
		multaPorDiaMorosidad = pmultaPorDiaMorosidad;
	}	
}
