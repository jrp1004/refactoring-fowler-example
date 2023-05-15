package ubu.gii.dass.refactoring;

/**
* Tema  Refactorizaciones 
*
* Ejemplo de aplicaci�n de refactorizaciones. Actualizado para colecciones gen�ricas de java 1.5
*
* @author M. Fowler y <A HREF="mailto:clopezno@ubu.es">Carlos L�pez</A>
* @version 1.1
* @see java.io.File
*
*/
import java.util.*;

public class Customer {
	private String _name;
	private List<Rental> _rentals;

	public Customer(String name) {
		_name = name;
		_rentals = new ArrayList<Rental>();

	}

	public void addRental(Rental arg) {
		_rentals.add(arg);
	}

	public String getName() {
		return _name;
	}

	public String statement(boolean html) {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Iterator<Rental> rentals = _rentals.iterator();
		String result = getCabecera(false);
		while (rentals.hasNext()) {
			double thisAmount = 0;
			Rental each = rentals.next();
			// determine amounts for each line
			thisAmount = each.getCharge();
			
			// add frequent renter points
			frequentRenterPoints++;
			// add bonus for a two day new release rental
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE)
					&& each.getDaysRented() > 1)
				frequentRenterPoints++;
			// show figures for this rental
			result = getFila(result, thisAmount, each.getMovie().getTitle(), false);
			totalAmount += thisAmount;
		}
		// add footer lines
		result = getPie(totalAmount, frequentRenterPoints, result, false);
		return result;
	}

	private String getPie(double totalAmount, int frequentRenterPoints, String result, boolean html) {
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		return result;
	}

	private String getFila(String result, double thisAmount, String titulo, boolean html) {
		result += "\t" + titulo + "\t" + String.valueOf(thisAmount) + "\n";
		return result;
	}

	private String getCabecera(boolean html) {
		String result = "Rental Record for " + getName() + "\n";
		return result;
	}
}
