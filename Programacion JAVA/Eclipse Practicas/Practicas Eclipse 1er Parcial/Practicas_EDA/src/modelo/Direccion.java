package modelo;

public class Direccion {
  String nombre;
  int numero;
  String colonia;
  String ciudad;
  
  public Direccion() {
	  
  }
  
  
  
@Override
public String toString() {
	return "Direccion [nombre=" + nombre + ", numero=" + numero + ", colonia=" + colonia + ", ciudad=" + ciudad + "]";
}



public Direccion(String nombre, int numero, String colonia, String ciudad) {
	super();
	this.nombre = nombre;
	this.numero = numero;
	this.colonia = colonia;
	this.ciudad = ciudad;
}

public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public int getNumero() {
	return numero;
}
public void setNumero(int numero) {
	this.numero = numero;
}
public String getColonia() {
	return colonia;
}
public void setColonia(String colonia) {
	this.colonia = colonia;
}
public String getCiudad() {
	return ciudad;
}
public void setCiudad(String ciudad) {
	this.ciudad = ciudad;
}
  
}
