package modelo;

public class cliente {
 String nombre;
 String apell;
 String correo;
 String contra;
 String id_cliente;
 byte imagen;
public cliente(String nombre, String apell, String correo, String contra, String id_cliente) {
	super();
	this.nombre = nombre;
	this.apell = apell;
	this.correo = correo;
	this.contra = contra;
	this.id_cliente = id_cliente;
	
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getApell() {
	return apell;
}
public void setApell(String apell) {
	this.apell = apell;
}
public String getCorreo() {
	return correo;
}
public void setCorreo(String correo) {
	this.correo = correo;
}
public String getContra() {
	return contra;
}
public void setContra(String contra) {
	this.contra = contra;
}
public String getString_cliente() {
	return id_cliente;
}
public void setId_cliente(String id_cliente) {
	this.id_cliente = id_cliente;
}
 
}
