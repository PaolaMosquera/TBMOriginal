package controlador;

import java.sql.*;
import javax.swing.*;

public class conexion {
	Connection cn;
	
public Connection conexionbd() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try {
			cn=DriverManager.getConnection("jdbc:mysql://localhost/baseproyecto","root","");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return cn;
}
}
