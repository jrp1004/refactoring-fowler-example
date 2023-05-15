package ubu.gii.dass.refactoring;

public enum MovieClass {
	CHILDRENS(1.5,3,1.5), REGULAR(2,2,1.5), NEW_RELEASE(0,0,3);
	
	private double price;
	private int dias;
	private double multiplicador;
	
	private MovieClass(double price, int dias, double multiplicador) {
		this.price=price;
		this.dias=dias;
		this.multiplicador=multiplicador;
	}

	public double getPrice() {
		return price;
	}

	public int getDias() {
		return dias;
	}

	public double getMultiplicador() {
		return multiplicador;
	}
	
}
