package modelo;

public class producto {
String nombre;
String marca;
int id_pro;
double precio;
int ref;

public producto(String nombre, String marca, int id_pro, double precio, int ref) {
	super();
	this.nombre = nombre;
	this.marca = marca;
	this.id_pro = id_pro;
	this.precio = precio;
	this.ref = ref;
}

public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getMarca() {
	return marca;
}
public void setMarca(String marca) {
	this.marca = marca;
}
public int getId_pro() {
	return id_pro;
}
public void setId_pro(int id_pro) {
	this.id_pro = id_pro;
}

public double getPrecio() {
	return precio;
}

public void setPrecio(double precio) {
	this.precio = precio;
}

public int getRef() {
	return ref;
}

public void setRef(int ref) {
	this.ref = ref;
}

}
