package ubu.gii.dass.refactoring;
public class VideoClubAplicacion {

	public static void main(String[] arg) {
		Movie m1 = new Movie("Sky Captain", MovieClass.NEW_RELEASE);
		Movie m3 = new Movie("Accion Mutante", MovieClass.REGULAR);
		Movie m4 = new Movie("Hermano Oso", MovieClass.CHILDRENS);

		Customer c1 = new Customer("Manuel");

		Rental r1 = new Rental(m1, 5);
		Rental r2 = new Rental(m3, 1);
		Rental r3 = new Rental(m4, 10);

		c1.addRental(r1);
		c1.addRental(r2);
		c1.addRental(r3);

		System.out.println(c1.statement(false));
		System.out.println(c1.statement(true));
	}

}