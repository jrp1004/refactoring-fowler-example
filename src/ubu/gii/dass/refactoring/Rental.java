package ubu.gii.dass.refactoring;
/**
 * Tema Refactorizaciones
 * 
 * Ejemplo de aplicación de refactorizaciones. Actualizado para colecciones
 * genéricas de java 1.5.
 * 
 * @author M. Fowler y <A HREF="mailto:clopezno@ubu.es">Carlos López</A>
 * @version 1.1
 * @see java.io.File
 * 
 */
public class Rental {
	public Movie _movie;
	private int _daysRented;

	public Rental(Movie movie, int daysRented) {
		_movie = movie;
		_daysRented = daysRented;
	}

	public int getDaysRented() {
		return _daysRented;
	}

	public Movie getMovie() {
		return _movie;
	}
	
	public double getCharge() {
		return getMovie().getCharge(getDaysRented());
	}

	public int getFrecuentRenterPoints() {
		// add frequent renter points
		int points=1;
		// add bonus for a two day new release rental
		if ((getMovie().getClase() == MovieClass.NEW_RELEASE) && getDaysRented() > 1) {
			points++;
		}
		return points;
	}

}
