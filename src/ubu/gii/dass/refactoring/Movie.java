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

public class Movie {
	private String _title;
	private MovieClass clase;

	public Movie(String title, MovieClass clase) {
		_title = title;
		this.setClase(clase);
	}
	
	public MovieClass getClase() {
		return clase;
	}

	public void setClase(MovieClass clase) {
		this.clase = clase;
	}

	public String getTitle() {
		return _title;
	}
}
