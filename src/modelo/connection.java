package modelo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {
	Connection conexion;
	private String url, user, password;
	
	public connection() {
		
		try {
			
			Class.forName("org.postgresql.Driver");
			
		
			url = "jdbc:postgresql://ns3034756.ip-91-121-81.eu/a20-amarbou";
			user = "a20-amarbou";
			password = "a20-amarbou";
			
			
			conexion = DriverManager.getConnection(url, user, password);
			
		} catch (SQLException e) {
				
			e.printStackTrace();
			System.out.println("Hay algún problema con la conexión (url, usuario, contraseña");
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			System.out.println("Hay algún problema con el driver");
		}
		
	}
	
	public void endConnection() {
	
		try {
			
			conexion.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.out.println("Hay algún problema al cerrar la conexión");
		}
	
	}
	
	public Connection getConexion() {
		
		return conexion;
	}

}
