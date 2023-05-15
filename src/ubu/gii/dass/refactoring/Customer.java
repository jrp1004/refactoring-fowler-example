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
		String result = getCabecera(html);
		while (rentals.hasNext()) {
			Rental each = rentals.next();
			// determine amounts for each line
			double thisAmount = each.getCharge();
			
			frequentRenterPoints += each.getFrecuentRenterPoints();
			// show figures for this rental
			result = getFila(result, thisAmount, each.getMovie().getTitle(), html);
			totalAmount += thisAmount;
		}
		// add footer lines
		result = getPie(totalAmount, frequentRenterPoints, result, html);
		return result;
	}

	private String getPie(double totalAmount, int frequentRenterPoints, String result, boolean html) {
		if(html) {
			result+="<p>Amount owed is "+totalAmount+"</p>";
			result+="<p>You earned "+frequentRenterPoints+" frequent renter points</p>";
		}else {
			result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
			result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		}
		return result;
	}

	private String getFila(String result, double thisAmount, String titulo, boolean html) {
		if(html) {
			result+="<h2>"+titulo+" "+thisAmount+"</h2>";
		}else {
			result += "\t" + titulo + "\t" + String.valueOf(thisAmount) + "\n";
		}
		return result;
	}

	private String getCabecera(boolean html) {
		if(html) {
			return "<h1>Rental Record for "+getName()+"</h1>";
		}else {
			return "Rental Record for " + getName() + "\n";
		}
	}
}
