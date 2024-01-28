package lista;

public class Libro {
private int isbn;
private String titulo;

private String autor;
private String editorial;
public Libro(){
	
}
public int getIsbn() {
	return isbn;
}
public void setIsbn(int isbn) {
	this.isbn = isbn;
}
public String getTitulo() {
	return titulo;
}
public void setTitulo(String titulo) {
	this.titulo = titulo;
}
public String getAutor() {
	return autor;
}
public void setAutor(String autor) {
	this.autor = autor;
}
public String getEditorial() {
	return editorial;
}
public void setEditorial(String editorial) {
	this.editorial = editorial;
}
}
